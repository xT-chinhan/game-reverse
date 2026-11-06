package com.tapsdk.tapad.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mar.sdk.IAction;
import com.tapsdk.tapad.AdRequest;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapInterstitialAd;
import com.tapsdk.tapad.b;
import com.tapsdk.tapad.c;
import com.tapsdk.tapad.constants.ErrorCodeEnum;
import com.tapsdk.tapad.internal.ionia.IoniaAdWindowTracker;
import com.tapsdk.tapad.internal.ionia.IoniaIdentityManager;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.ShowHostFacts;
import com.tapsdk.tapad.internal.runtime.WasmAdInstance;
import com.tapsdk.tapad.internal.runtime.WasmModule;
import com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener;
import com.tapsdk.tapad.internal.runtime.plugin.stub.BaseAdActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class WasmInterstitialPresenter implements AdCallbackListener, IoniaPlaybackSource {
    private static final String FN_IS_READY = "ad_is_ready_instance";
    private static final String FN_LOAD = "ad_load_instance";
    private static final String FN_LOSS = "ad_send_loss_notification_instance";
    private static final String FN_PRESENT = "ad_present_interstitial_instance_v2";
    private static final String FN_RENDER = "ad_render_interstitial";
    private static final String FN_WIN = "ad_send_win_notification_instance";
    private static final String TAG = "WasmInterstitialPresenter";
    private AdapterInterstitialAd callbackAd;
    private boolean closed;
    private final Context context;
    private boolean fallbackActive;
    private boolean fallbackOnly;
    private AndroidInterstitialFallback.Session fallbackSession;
    private boolean fallbackTakeoverPending;
    private TapInterstitialAd.InterstitialAdInteractionListener interactionListener;
    private boolean loadFinished;
    private TapAdNative.InterstitialAdListener loadListener;
    private long price;
    private volatile boolean ready;
    private final AdRequest request;
    private volatile boolean showing;
    private boolean shown;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final WasmAdnLoadAttempt loadAttempt = new WasmAdnLoadAttempt();
    private final Map<String, Object> mediaExtraInfo = new HashMap();
    private final AtomicBoolean disposed = new AtomicBoolean(false);
    private WeakReference<WasmAdInstance> instanceRef = new WeakReference<>(null);
    private WeakReference<Activity> activityRef = new WeakReference<>(null);
    private String trackId = "";

    public static final class AdapterInterstitialAd implements TapInterstitialAd {
        private final WasmInterstitialPresenter presenter;

        public AdapterInterstitialAd(WasmInterstitialPresenter wasmInterstitialPresenter) {
            this.presenter = wasmInterstitialPresenter;
        }

        @Override // com.tapsdk.tapad.TapInterstitialAd
        public void dispose() {
            this.presenter.dispose();
        }

        @Override // com.tapsdk.tapad.TapInterstitialAd
        public Map<String, Object> getMediaExtraInfo() {
            HashMap map;
            synchronized (this.presenter.mediaExtraInfo) {
                map = new HashMap(this.presenter.mediaExtraInfo);
            }
            return map;
        }

        @Override // com.tapsdk.tapad.TapInterstitialAd
        public long getPrice() {
            return this.presenter.price;
        }

        @Override // com.tapsdk.tapad.TapInterstitialAd
        public boolean isValid() {
            return this.presenter.isValid();
        }

        @Override // com.tapsdk.tapad.TapInterstitialAd
        public void sendLossNotification(Map<String, Object> map) {
            this.presenter.reportBidding(false, map);
        }

        @Override // com.tapsdk.tapad.TapInterstitialAd
        public void sendWinNotification(Map<String, Object> map) {
            this.presenter.reportBidding(true, map);
        }

        @Override // com.tapsdk.tapad.TapInterstitialAd
        public void setInteractionListener(TapInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener) {
            this.presenter.interactionListener = interstitialAdInteractionListener;
        }

        @Override // com.tapsdk.tapad.TapInterstitialAd
        public void show(Activity activity) {
            this.presenter.show(activity);
        }
    }

    public WasmInterstitialPresenter(Context context, AdRequest adRequest) {
        this.context = context.getApplicationContext();
        this.request = adRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeLoad() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmInterstitialPresenter$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.completeLoad();
                }
            });
            return;
        }
        if (this.disposed.get() || this.loadFinished) {
            return;
        }
        this.loadFinished = true;
        AdapterInterstitialAd adapterInterstitialAd = new AdapterInterstitialAd(this);
        this.callbackAd = adapterInterstitialAd;
        TapAdNative.InterstitialAdListener interstitialAdListener = this.loadListener;
        this.loadListener = null;
        if (interstitialAdListener != null) {
            interstitialAdListener.onInterstitialAdLoad(adapterInterstitialAd);
        }
    }

    private void copyMediaExtra(JSONObject jSONObject) {
        Map<String, Object> mapFromLoadPayload = WasmAdMediaExtraInfo.fromLoadPayload(jSONObject);
        mapFromLoadPayload.put("bid_price", Long.valueOf(this.price));
        putIfNotEmpty(mapFromLoadPayload, "adn_track_id", this.trackId);
        putIfNotEmpty(mapFromLoadPayload, com.tapsdk.tapad.constants.Constants.Bidding.REQUEST_ID, jSONObject.optString(com.tapsdk.tapad.constants.Constants.Bidding.REQUEST_ID, this.request.requestId));
        String strOptString = jSONObject.optString(com.tapsdk.tapad.constants.Constants.Bidding.REQ_UUID, "");
        putIfNotEmpty(mapFromLoadPayload, com.tapsdk.tapad.constants.Constants.Bidding.REQ_UUID, strOptString);
        putIfNotEmpty(mapFromLoadPayload, "trace_id", firstNonEmpty(strOptString, this.request.requestId));
        synchronized (this.mediaExtraInfo) {
            this.mediaExtraInfo.clear();
            this.mediaExtraInfo.putAll(mapFromLoadPayload);
        }
    }

    private void disposeCore() {
        WasmAdInstance wasmAdInstance = this.instanceRef.get();
        this.instanceRef = new WeakReference<>(null);
        if (wasmAdInstance != null) {
            wasmAdInstance.dispose();
        }
    }

    private void enrichIonia() {
        Object obj;
        synchronized (this.mediaExtraInfo) {
            obj = this.mediaExtraInfo.get(com.tapsdk.tapad.constants.Constants.Bidding.REQ_UUID);
        }
        IoniaIdentityManager.getInstance().enrichAfterGetAds(obj == null ? "" : String.valueOf(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failLoad(final Exception exc) {
        WasmAdnLoadAttempt.FailureTiming failureTimingMarkFailed = this.loadAttempt.markFailed();
        if (failureTimingMarkFailed == WasmAdnLoadAttempt.FailureTiming.ALREADY_FAILED) {
            return;
        }
        final boolean z = failureTimingMarkFailed == WasmAdnLoadAttempt.FailureTiming.BEFORE_AD_LOAD;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmInterstitialPresenter$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m126lambda$failLoad$2$comtapsdktapadinternalWasmInterstitialPresenter(exc, z);
                }
            });
        } else {
            m126lambda$failLoad$2$comtapsdktapadinternalWasmInterstitialPresenter(exc, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: failLoadOnMain, reason: merged with bridge method [inline-methods] */
    public void m126lambda$failLoad$2$comtapsdktapadinternalWasmInterstitialPresenter(Exception exc, boolean z) {
        if (this.disposed.get() || this.loadFinished) {
            return;
        }
        disposeCore();
        if (z) {
            this.fallbackOnly = true;
            this.ready = true;
            this.trackId = "dirichlet-extreme-interstitial";
            this.mediaExtraInfo.put("extreme_fallback", Boolean.TRUE);
            completeLoad();
            return;
        }
        this.loadFinished = true;
        TapAdNative.InterstitialAdListener interstitialAdListener = this.loadListener;
        this.loadListener = null;
        if (interstitialAdListener != null) {
            interstitialAdListener.onError(WasmRewardPresenter.resolvePublicLoadErrorCode(exc, ErrorCodeEnum.INTERNAL_ERROR.getCode()), WasmRewardPresenter.loadErrorMessage(exc));
        }
    }

    public static TapInterstitialAd fallbackOnly(Context context) {
        WasmInterstitialPresenter wasmInterstitialPresenter = new WasmInterstitialPresenter(context, new AdRequest.Builder().withSpaceId(0L).build());
        wasmInterstitialPresenter.fallbackOnly = true;
        wasmInterstitialPresenter.ready = true;
        wasmInterstitialPresenter.trackId = "dirichlet-extreme-interstitial";
        wasmInterstitialPresenter.mediaExtraInfo.put("extreme_fallback", Boolean.TRUE);
        AdapterInterstitialAd adapterInterstitialAd = new AdapterInterstitialAd(wasmInterstitialPresenter);
        wasmInterstitialPresenter.callbackAd = adapterInterstitialAd;
        return adapterInterstitialAd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishWithClose() {
        if (this.closed || this.disposed.get()) {
            return;
        }
        this.closed = true;
        TapInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener = this.interactionListener;
        if (interstitialAdInteractionListener != null) {
            interstitialAdInteractionListener.onAdClose();
        }
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishWithError() {
        if (this.closed || this.disposed.get()) {
            return;
        }
        this.closed = true;
        TapInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener = this.interactionListener;
        if (interstitialAdInteractionListener != null) {
            interstitialAdInteractionListener.onAdError();
        }
        dispose();
    }

    private static String firstNonEmpty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2 == null ? "" : str2;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forward(String str) {
        TapInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener = this.interactionListener;
        if (interstitialAdInteractionListener == null) {
            return;
        }
        str.getClass();
        switch (str) {
            case "onAdClick":
                interstitialAdInteractionListener.onAdClick();
                break;
            case "onAdValidShow":
                interstitialAdInteractionListener.onAdValidShow();
                break;
            case "onAdShow":
                interstitialAdInteractionListener.onAdShow();
                break;
        }
    }

    private void handleFallbackTerminal(String str) {
        this.fallbackTakeoverPending = false;
        int iOptInt = 2;
        try {
            if (str == null) {
                str = "{}";
            }
            iOptInt = new JSONObject(str).optInt("outcome", 2);
        } catch (Throwable th) {
        }
        if (iOptInt == 1 || iOptInt == 3) {
            this.mainHandler.post(new WasmInterstitialPresenter$$ExternalSyntheticLambda2(this));
        } else if (this.shown) {
            this.mainHandler.post(new WasmInterstitialPresenter$$ExternalSyntheticLambda1(this));
        } else {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmInterstitialPresenter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m127lambda$handleFallbackTerminal$6$comtapsdktapadinternalWasmInterstitialPresenter();
                }
            });
        }
    }

    private void handleLoaded(String str) {
        try {
            if (str == null) {
                str = "{}";
            }
            JSONObject jSONObject = new JSONObject(str);
            this.price = jSONObject.optLong(IAction.PurchaseKey.Price, 0L);
            this.trackId = firstNonEmpty(jSONObject.optString("adn_track_id", ""), jSONObject.optString("track_id", ""));
            copyMediaExtra(jSONObject);
            enrichIonia();
        } catch (Throwable th) {
        }
        this.ready = true;
        completeLoad();
    }

    private WasmAdInstance instance() {
        WasmAdInstance wasmAdInstance = this.instanceRef.get();
        if (wasmAdInstance == null || wasmAdInstance.isDisposed()) {
            return null;
        }
        return wasmAdInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValid() {
        WasmAdInstance wasmAdInstanceInstance = instance();
        if (!this.showing && !this.disposed.get()) {
            if (this.fallbackOnly) {
                return this.ready;
            }
            if (wasmAdInstanceInstance == null) {
                return false;
            }
            try {
                return wasmAdInstanceInstance.module().callIntSync(FN_IS_READY, Integer.valueOf(wasmAdInstanceInstance.instanceId())) == 1;
            } catch (Throwable th) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepare(final DirichletRuntime dirichletRuntime, final WasmModule wasmModule) {
        if (this.disposed.get() || this.loadFinished) {
            return;
        }
        String[] strArr = {FN_LOAD, FN_IS_READY, FN_PRESENT, FN_RENDER, FN_WIN, FN_LOSS};
        for (int i = 0; i < 6; i++) {
            String str = strArr[i];
            if (!wasmModule.hasFunction(str)) {
                failLoad(new IllegalStateException(c.a("Core Interstitial export missing: ", str)));
                return;
            }
        }
        if (dirichletRuntime.runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmInterstitialPresenter$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m129lambda$prepare$0$comtapsdktapadinternalWasmInterstitialPresenter(dirichletRuntime, wasmModule);
            }
        })) {
            return;
        }
        failLoad(new IllegalStateException("Core runtime queue unavailable"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: prepareOnRuntime, reason: merged with bridge method [inline-methods] */
    public void m129lambda$prepare$0$comtapsdktapadinternalWasmInterstitialPresenter(DirichletRuntime dirichletRuntime, WasmModule wasmModule) {
        try {
            if (!AdnRuntimeBootstrap.getInstance().ensurePublisherInstalled(this.context, dirichletRuntime, wasmModule)) {
                failLoad(new IllegalStateException("ADN publisher is not initialized"));
                return;
            }
            WeakReference<WasmAdInstance> weakReferenceCreate = WasmAdInstance.create(wasmModule, new DirichletRuntime.NativeCallback() { // from class: com.tapsdk.tapad.internal.WasmInterstitialPresenter$$ExternalSyntheticLambda9
                @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.NativeCallback
                public final void onCallback(String str, String str2) {
                    this.f$0.m136lambda$onCallback$2$comtapsdktapadinternalWasmNativeFeedPresenter(str, str2);
                }
            });
            WasmAdInstance wasmAdInstance = weakReferenceCreate.get();
            if (wasmAdInstance != null && !this.disposed.get()) {
                this.instanceRef = weakReferenceCreate;
                dirichletRuntime.registerAdSurface(wasmAdInstance.instanceId(), wasmModule, this, this);
                JSONObject jSONObjectCreate = WasmAdnLoadRequest.create(this.request);
                if (this.loadAttempt.tryMarkAdLoadDispatched()) {
                    wasmModule.callVoidSync(FN_LOAD, Integer.valueOf(wasmAdInstance.instanceId()), MediationConstant.RIT_TYPE_INTERSTITIAL, jSONObjectCreate.toString());
                    return;
                }
                return;
            }
            if (wasmAdInstance != null) {
                wasmAdInstance.dispose();
            }
            failLoad(new IllegalStateException("Core Interstitial instance creation failed"));
        } catch (Throwable th) {
            failLoad(new RuntimeException("Core Interstitial preparation failed", th));
        }
    }

    private static void putIfNotEmpty(Map<String, Object> map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportBidding(boolean z, Map<String, Object> map) {
        WasmAdInstance wasmAdInstanceInstance = instance();
        if (wasmAdInstanceInstance == null) {
            return;
        }
        try {
            wasmAdInstanceInstance.module().callVoid(z ? FN_WIN : FN_LOSS, Integer.valueOf(wasmAdInstanceInstance.instanceId()), (map == null ? new JSONObject() : new JSONObject(map)).toString());
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show(Activity activity) {
        if (!isValid() || activity == null || activity.isFinishing() || activity.isDestroyed()) {
            finishWithError();
            return;
        }
        this.showing = true;
        this.ready = false;
        this.activityRef = new WeakReference<>(activity);
        if (this.fallbackOnly) {
            m132lambda$startFallback$5$comtapsdktapadinternalWasmInterstitialPresenter("embedded shell");
            return;
        }
        WasmAdInstance wasmAdInstanceInstance = instance();
        if (wasmAdInstanceInstance == null) {
            m132lambda$startFallback$5$comtapsdktapadinternalWasmInterstitialPresenter("Core Interstitial instance unavailable");
            return;
        }
        try {
            DirichletRuntime.getInstance().registerAdSurface(wasmAdInstanceInstance.instanceId(), wasmAdInstanceInstance.module(), this, this, activity);
            wasmAdInstanceInstance.module().callInt(FN_PRESENT, new WasmModule.IntCallback() { // from class: com.tapsdk.tapad.internal.WasmInterstitialPresenter$$ExternalSyntheticLambda3
                @Override // com.tapsdk.tapad.internal.runtime.WasmModule.IntCallback
                public final void onResult(int i) {
                    this.f$0.m131lambda$show$4$comtapsdktapadinternalWasmInterstitialPresenter(i);
                }
            }, Integer.valueOf(wasmAdInstanceInstance.instanceId()), Integer.valueOf(ShowHostFacts.forFullscreen(activity, false)));
        } catch (Throwable th) {
            m132lambda$startFallback$5$comtapsdktapadinternalWasmInterstitialPresenter("Core Interstitial show failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startFallback, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void m132lambda$startFallback$5$comtapsdktapadinternalWasmInterstitialPresenter(final String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmInterstitialPresenter$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m132lambda$startFallback$5$comtapsdktapadinternalWasmInterstitialPresenter(str);
                }
            });
            return;
        }
        if (this.disposed.get() || this.fallbackActive || this.shown) {
            return;
        }
        WasmAdInstance wasmAdInstanceInstance = instance();
        if (wasmAdInstanceInstance != null) {
            BaseAdActivity.finishActivitiesForInstance(wasmAdInstanceInstance.instanceId());
        }
        Activity activity = this.activityRef.get();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            finishWithError();
            return;
        }
        this.fallbackActive = true;
        this.shown = true;
        try {
            this.fallbackSession = AndroidInterstitialFallback.show(activity, new AndroidInterstitialFallback.Listener() { // from class: com.tapsdk.tapad.internal.WasmInterstitialPresenter.2
                @Override // com.tapsdk.tapad.internal.AndroidInterstitialFallback.Listener
                public void onClose() {
                    WasmInterstitialPresenter.this.fallbackActive = false;
                    WasmInterstitialPresenter.this.finishWithClose();
                }

                @Override // com.tapsdk.tapad.internal.AndroidInterstitialFallback.Listener
                public void onShow() {
                    WasmInterstitialPresenter.this.forward("onAdShow");
                }

                @Override // com.tapsdk.tapad.internal.AndroidInterstitialFallback.Listener
                public void onValidShow() {
                    WasmInterstitialPresenter.this.forward("onAdValidShow");
                }
            }, IoniaAdWindowTracker.forFullscreen(ioniaWindowKey(), ioniaTriggerCorrelationId()));
        } catch (RuntimeException e) {
            this.fallbackActive = false;
            finishWithError();
        }
    }

    public void dispose() {
        if (this.disposed.compareAndSet(false, true)) {
            AndroidInterstitialFallback.Session session = this.fallbackSession;
            this.fallbackSession = null;
            if (session != null) {
                session.release();
            }
            WasmAdInstance wasmAdInstanceInstance = instance();
            if (wasmAdInstanceInstance != null) {
                BaseAdActivity.finishActivitiesForInstance(wasmAdInstanceInstance.instanceId());
            }
            disposeCore();
            this.ready = false;
            this.showing = false;
            this.loadListener = null;
            this.interactionListener = null;
            this.activityRef = new WeakReference<>(null);
        }
    }

    @Override // com.tapsdk.tapad.internal.IoniaPlaybackSource
    public String ioniaTriggerCorrelationId() {
        String strValueOf;
        synchronized (this.mediaExtraInfo) {
            Object obj = this.mediaExtraInfo.get(com.tapsdk.tapad.constants.Constants.Bidding.REQ_UUID);
            strValueOf = obj == null ? "" : String.valueOf(obj);
        }
        return strValueOf;
    }

    @Override // com.tapsdk.tapad.internal.IoniaPlaybackSource
    public String ioniaWindowKey() {
        return TextUtils.isEmpty(ioniaTriggerCorrelationId()) ? "" : this.trackId;
    }

    /* JADX INFO: renamed from: lambda$handleFallbackTerminal$6$com-tapsdk-tapad-internal-WasmInterstitialPresenter, reason: not valid java name */
    /* synthetic */ void m127lambda$handleFallbackTerminal$6$comtapsdktapadinternalWasmInterstitialPresenter() {
        m132lambda$startFallback$5$comtapsdktapadinternalWasmInterstitialPresenter("Core fallback settlement failed");
    }

    /* JADX INFO: renamed from: lambda$show$3$com-tapsdk-tapad-internal-WasmInterstitialPresenter, reason: not valid java name */
    /* synthetic */ void m130lambda$show$3$comtapsdktapadinternalWasmInterstitialPresenter(int i) {
        m132lambda$startFallback$5$comtapsdktapadinternalWasmInterstitialPresenter(b.a("Core Interstitial surface attach failed: ", i));
    }

    /* JADX INFO: renamed from: lambda$show$4$com-tapsdk-tapad-internal-WasmInterstitialPresenter, reason: not valid java name */
    /* synthetic */ void m131lambda$show$4$comtapsdktapadinternalWasmInterstitialPresenter(final int i) {
        if (ShowHostFacts.isAdmissionRejection(i) && !this.shown && !this.disposed.get()) {
            finishWithError();
        } else {
            if (i > 0 || this.shown || this.disposed.get()) {
                return;
            }
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmInterstitialPresenter$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m130lambda$show$3$comtapsdktapadinternalWasmInterstitialPresenter(i);
                }
            });
        }
    }

    public void load(TapAdNative.InterstitialAdListener interstitialAdListener) {
        this.loadListener = interstitialAdListener;
        final DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        WasmCoreModuleLoader.load(dirichletRuntime, new WasmCoreModuleLoader.Callback() { // from class: com.tapsdk.tapad.internal.WasmInterstitialPresenter.1
            @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
            public void onError(Exception exc) {
                WasmInterstitialPresenter.this.failLoad(exc);
            }

            @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
            public void onLoaded(WasmModule wasmModule) {
                WasmInterstitialPresenter.this.prepare(dirichletRuntime, wasmModule);
            }
        });
    }

    @Override // com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener
    /* JADX INFO: renamed from: onCallback */
    public void m136lambda$onCallback$2$comtapsdktapadinternalWasmNativeFeedPresenter(final String str, String str2) {
        if (this.disposed.get()) {
            return;
        }
        str.getClass();
        switch (str) {
            case "onError":
            case "onVideoError":
                if (this.showing && !this.fallbackTakeoverPending && !this.shown) {
                    this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmInterstitialPresenter$$ExternalSyntheticLambda8
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m128lambda$onCallback$1$comtapsdktapadinternalWasmInterstitialPresenter(str);
                        }
                    });
                    break;
                } else {
                    if (this.showing && this.shown) {
                        this.mainHandler.post(new WasmInterstitialPresenter$$ExternalSyntheticLambda1(this));
                    } else {
                        failLoad(WasmRewardPresenter.parseLoadError(str2));
                    }
                    break;
                }
                break;
            case "onAdClick":
            case "onAdValidShow":
                forward(str);
                break;
            case "onAdClose":
                this.mainHandler.post(new WasmInterstitialPresenter$$ExternalSyntheticLambda2(this));
                break;
            case "onCoreRuntimeFatal":
            case "onFallbackTakeoverStarted":
                this.fallbackTakeoverPending = true;
                break;
            case "onFallbackTerminal":
                handleFallbackTerminal(str2);
                break;
            case "onInterstitialAdError":
                failLoad(WasmRewardPresenter.parseLoadError(str2));
                break;
            case "onAdShow":
                this.shown = true;
                this.fallbackTakeoverPending = false;
                forward(str);
                break;
            case "onInterstitialAdLoaded":
                handleLoaded(str2);
                break;
        }
    }
}

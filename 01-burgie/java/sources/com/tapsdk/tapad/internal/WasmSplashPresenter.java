package com.tapsdk.tapad.internal;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mar.sdk.IAction;
import com.tapsdk.tapad.AdRequest;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapSplashAd;
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
import com.tapsdk.tapad.internal.runtime.plugin.stub.InlineAdSurfaceHost;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class WasmSplashPresenter implements AdCallbackListener {
    private static final String FN_IS_READY = "ad_is_ready_instance";
    private static final String FN_LOAD = "ad_load_instance";
    private static final String FN_LOSS = "ad_send_loss_notification_instance";
    private static final String FN_PRESENT = "ad_present_splash_instance_v2";
    private static final String FN_RENDER = "ad_render_splash";
    private static final String FN_WIN = "ad_send_win_notification_instance";
    private static final String TAG = "WasmSplashPresenter";
    private AdapterSplashAd callbackAd;
    private final Context context;
    private volatile long expirationEpochSeconds;
    private boolean fallbackActive;
    private boolean fallbackOnly;
    private AndroidSplashFallback.Session fallbackSession;
    private TapSplashAd.AdInteractionListener interactionListener;
    private IoniaAdWindowTracker ioniaWindowTracker;
    private boolean loadFinished;
    private TapAdNative.SplashAdListener loadListener;
    private long price;
    private volatile boolean ready;
    private final AdRequest request;
    private FrameLayout root;
    private volatile boolean showing;
    private boolean shown;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final WasmAdnLoadAttempt loadAttempt = new WasmAdnLoadAttempt();
    private final Map<String, Object> mediaExtraInfo = new HashMap();
    private final AtomicBoolean disposed = new AtomicBoolean(false);
    private WeakReference<WasmAdInstance> instanceRef = new WeakReference<>(null);
    private int hostToken = -1;
    private String trackId = "";
    private String imageUrl = "";

    public WasmSplashPresenter(Context context, AdRequest adRequest) {
        this.context = context.getApplicationContext();
        this.request = adRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginPresent(Activity activity, FrameLayout frameLayout) {
        if (this.disposed.get() || this.showing || !this.ready) {
            return;
        }
        this.showing = true;
        this.ready = false;
        if (this.fallbackOnly) {
            m152lambda$onCallback$1$comtapsdktapadinternalWasmSplashPresenter("embedded shell");
            return;
        }
        WasmAdInstance wasmAdInstanceInstance = instance();
        if (wasmAdInstanceInstance == null) {
            m152lambda$onCallback$1$comtapsdktapadinternalWasmSplashPresenter("Core Splash instance unavailable");
            return;
        }
        DirichletRuntime.getInstance().registerAdSurface(wasmAdInstanceInstance.instanceId(), wasmAdInstanceInstance.module(), this, this, activity);
        int iRegister = InlineAdSurfaceHost.register(frameLayout, AdType.SplashAd);
        this.hostToken = iRegister;
        if (iRegister <= 0) {
            m152lambda$onCallback$1$comtapsdktapadinternalWasmSplashPresenter("Splash inline host registration failed");
        } else {
            wasmAdInstanceInstance.module().callInt(FN_PRESENT, new WasmModule.IntCallback() { // from class: com.tapsdk.tapad.internal.WasmSplashPresenter$$ExternalSyntheticLambda6
                @Override // com.tapsdk.tapad.internal.runtime.WasmModule.IntCallback
                public final void onResult(int i) {
                    this.f$0.m150lambda$beginPresent$4$comtapsdktapadinternalWasmSplashPresenter(i);
                }
            }, Integer.valueOf(wasmAdInstanceInstance.instanceId()), Integer.valueOf(this.hostToken), Integer.valueOf(ShowHostFacts.forInline(frameLayout)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeLoad() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmSplashPresenter$$ExternalSyntheticLambda1
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
        AdapterSplashAd adapterSplashAd = new AdapterSplashAd(this);
        this.callbackAd = adapterSplashAd;
        TapAdNative.SplashAdListener splashAdListener = this.loadListener;
        this.loadListener = null;
        if (splashAdListener != null) {
            splashAdListener.onSplashAdLoad(adapterSplashAd);
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
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmSplashPresenter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m151lambda$failLoad$3$comtapsdktapadinternalWasmSplashPresenter(exc, z);
                }
            });
        } else {
            m151lambda$failLoad$3$comtapsdktapadinternalWasmSplashPresenter(exc, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: failLoadOnMain, reason: merged with bridge method [inline-methods] */
    public void m151lambda$failLoad$3$comtapsdktapadinternalWasmSplashPresenter(Exception exc, boolean z) {
        if (this.disposed.get() || this.loadFinished) {
            return;
        }
        disposeCore();
        if (z) {
            this.fallbackOnly = true;
            this.ready = true;
            completeLoad();
        } else {
            this.loadFinished = true;
            TapAdNative.SplashAdListener splashAdListener = this.loadListener;
            this.loadListener = null;
            if (splashAdListener != null) {
                splashAdListener.onError(WasmRewardPresenter.resolvePublicLoadErrorCode(exc, ErrorCodeEnum.INTERNAL_ERROR.getCode()), WasmRewardPresenter.loadErrorMessage(exc));
            }
        }
    }

    public static TapSplashAd fallbackOnly(Context context) {
        WasmSplashPresenter wasmSplashPresenter = new WasmSplashPresenter(context, new AdRequest.Builder().withSpaceId(0L).build());
        wasmSplashPresenter.fallbackOnly = true;
        wasmSplashPresenter.ready = true;
        AdapterSplashAd adapterSplashAd = new AdapterSplashAd(wasmSplashPresenter);
        wasmSplashPresenter.callbackAd = adapterSplashAd;
        return adapterSplashAd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishFallback(boolean z) {
        if (!this.fallbackActive || this.disposed.get()) {
            return;
        }
        this.fallbackActive = false;
        TapSplashAd.AdInteractionListener adInteractionListener = this.interactionListener;
        if (adInteractionListener != null) {
            if (z) {
                adInteractionListener.onAdSkip();
            } else {
                adInteractionListener.onAdTimeOver();
            }
        }
        dispose();
    }

    private static String firstNonEmpty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2 == null ? "" : str2;
        }
        return str;
    }

    private void forward(String str) {
        TapSplashAd.AdInteractionListener adInteractionListener = this.interactionListener;
        if (adInteractionListener == null) {
            return;
        }
        str.getClass();
        switch (str) {
            case "onAdTimeOver":
                adInteractionListener.onAdTimeOver();
                break;
            case "onAdClick":
                adInteractionListener.onAdClick();
                break;
            case "onAdValidShow":
                adInteractionListener.onAdValidShow();
                break;
            case "onAdShow":
                adInteractionListener.onAdShow();
                break;
            case "onAdSkip":
                adInteractionListener.onAdSkip();
                break;
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
            this.imageUrl = jSONObject.optString("image_url", "");
            this.expirationEpochSeconds = Math.max(0L, jSONObject.optLong("expire_time", 0L));
            copyMediaExtra(jSONObject);
            this.ioniaWindowTracker = IoniaAdWindowTracker.forFullscreen(this.trackId, ioniaTriggerCorrelationId());
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

    private String ioniaTriggerCorrelationId() {
        String strValueOf;
        synchronized (this.mediaExtraInfo) {
            Object obj = this.mediaExtraInfo.get(com.tapsdk.tapad.constants.Constants.Bidding.REQ_UUID);
            strValueOf = obj == null ? "" : String.valueOf(obj);
        }
        return strValueOf;
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
    public void notifyIoniaHidden() {
        IoniaAdWindowTracker ioniaAdWindowTracker = this.ioniaWindowTracker;
        if (ioniaAdWindowTracker != null) {
            ioniaAdWindowTracker.onHidden();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyIoniaShown() {
        IoniaAdWindowTracker ioniaAdWindowTracker = this.ioniaWindowTracker;
        if (ioniaAdWindowTracker != null) {
            ioniaAdWindowTracker.onShown();
        }
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
                failLoad(new IllegalStateException(c.a("Core Splash export missing: ", str)));
                return;
            }
        }
        if (dirichletRuntime.runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmSplashPresenter$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m154lambda$prepare$0$comtapsdktapadinternalWasmSplashPresenter(dirichletRuntime, wasmModule);
            }
        })) {
            return;
        }
        failLoad(new IllegalStateException("Core runtime queue unavailable"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: prepareOnRuntime, reason: merged with bridge method [inline-methods] */
    public void m154lambda$prepare$0$comtapsdktapadinternalWasmSplashPresenter(DirichletRuntime dirichletRuntime, WasmModule wasmModule) {
        try {
            if (!AdnRuntimeBootstrap.getInstance().ensurePublisherInstalled(this.context, dirichletRuntime, wasmModule)) {
                failLoad(new IllegalStateException("ADN publisher is not initialized"));
                return;
            }
            WeakReference<WasmAdInstance> weakReferenceCreate = WasmAdInstance.create(wasmModule, new DirichletRuntime.NativeCallback() { // from class: com.tapsdk.tapad.internal.WasmSplashPresenter$$ExternalSyntheticLambda0
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
                    wasmModule.callVoidSync(FN_LOAD, Integer.valueOf(wasmAdInstance.instanceId()), MediationConstant.RIT_TYPE_SPLASH, jSONObjectCreate.toString());
                    return;
                }
                return;
            }
            if (wasmAdInstance != null) {
                wasmAdInstance.dispose();
            }
            failLoad(new IllegalStateException("Core Splash instance creation failed"));
        } catch (Throwable th) {
            failLoad(new RuntimeException("Core Splash preparation failed", th));
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
    public static Activity resolveActivity(View view) {
        Context baseContext;
        if (view == null) {
            return null;
        }
        Context context = view.getContext();
        while (context != null) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (!(context instanceof ContextWrapper) || (baseContext = ((ContextWrapper) context).getBaseContext()) == context) {
                return null;
            }
            context = baseContext;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout splashView(final Activity activity) {
        if (this.disposed.get() || activity == null) {
            return null;
        }
        FrameLayout frameLayout = this.root;
        if (frameLayout != null) {
            return frameLayout;
        }
        final FrameLayout frameLayout2 = new FrameLayout(activity) { // from class: com.tapsdk.tapad.internal.WasmSplashPresenter.2
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                IoniaAdWindowTracker ioniaAdWindowTracker = WasmSplashPresenter.this.ioniaWindowTracker;
                if (ioniaAdWindowTracker != null) {
                    ioniaAdWindowTracker.onTouchEvent(motionEvent);
                }
                return super.dispatchTouchEvent(motionEvent);
            }
        };
        frameLayout2.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.tapsdk.tapad.internal.WasmSplashPresenter.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                WasmSplashPresenter.this.beginPresent(activity, frameLayout2);
                if (WasmSplashPresenter.this.shown) {
                    WasmSplashPresenter.this.notifyIoniaShown();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                WasmSplashPresenter.this.notifyIoniaHidden();
            }
        });
        this.root = frameLayout2;
        return frameLayout2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startFallback, reason: merged with bridge method [inline-methods] */
    public void m152lambda$onCallback$1$comtapsdktapadinternalWasmSplashPresenter(String str) {
        if (this.disposed.get() || this.fallbackActive) {
            return;
        }
        int i = this.hostToken;
        if (i > 0) {
            FrameLayout frameLayoutTakeOverForFallback = InlineAdSurfaceHost.takeOverForFallback(i);
            if (frameLayoutTakeOverForFallback != null) {
                this.root = frameLayoutTakeOverForFallback;
            }
            this.hostToken = -1;
        }
        disposeCore();
        FrameLayout frameLayout = this.root;
        if (frameLayout == null) {
            return;
        }
        this.fallbackActive = true;
        this.shown = true;
        this.fallbackSession = AndroidSplashFallback.show(frameLayout, this.imageUrl, new AndroidSplashFallback.Listener() { // from class: com.tapsdk.tapad.internal.WasmSplashPresenter.4
            @Override // com.tapsdk.tapad.internal.AndroidSplashFallback.Listener
            public void onFinished(boolean z) {
                WasmSplashPresenter.this.finishFallback(z);
            }

            @Override // com.tapsdk.tapad.internal.AndroidSplashFallback.Listener
            public void onShow(long j) {
                WasmSplashPresenter.this.notifyIoniaShown();
                TapSplashAd.AdInteractionListener adInteractionListener = WasmSplashPresenter.this.interactionListener;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdShow();
                }
            }

            @Override // com.tapsdk.tapad.internal.AndroidSplashFallback.Listener
            public void onValidShow() {
                TapSplashAd.AdInteractionListener adInteractionListener = WasmSplashPresenter.this.interactionListener;
                if (adInteractionListener != null) {
                    adInteractionListener.onAdValidShow();
                }
            }
        });
    }

    public void dispose() {
        if (this.disposed.compareAndSet(false, true)) {
            notifyIoniaHidden();
            this.ioniaWindowTracker = null;
            AndroidSplashFallback.Session session = this.fallbackSession;
            this.fallbackSession = null;
            if (session != null) {
                session.release();
            }
            int i = this.hostToken;
            if (i > 0) {
                InlineAdSurfaceHost.release(i);
                this.hostToken = -1;
            }
            disposeCore();
            FrameLayout frameLayout = this.root;
            if (frameLayout != null && (frameLayout.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.root.getParent()).removeView(this.root);
            }
            FrameLayout frameLayout2 = this.root;
            if (frameLayout2 != null) {
                frameLayout2.removeAllViews();
            }
            this.root = null;
            this.ready = false;
            this.showing = false;
            this.loadListener = null;
            this.interactionListener = null;
        }
    }

    /* JADX INFO: renamed from: lambda$beginPresent$4$com-tapsdk-tapad-internal-WasmSplashPresenter, reason: not valid java name */
    /* synthetic */ void m150lambda$beginPresent$4$comtapsdktapadinternalWasmSplashPresenter(int i) {
        if (ShowHostFacts.isAdmissionRejection(i) && !this.shown && !this.disposed.get()) {
            dispose();
        } else {
            if (i > 0 || this.shown || this.disposed.get()) {
                return;
            }
            m152lambda$onCallback$1$comtapsdktapadinternalWasmSplashPresenter(b.a("Core Splash surface attach failed: ", i));
        }
    }

    /* JADX INFO: renamed from: lambda$onCallback$2$com-tapsdk-tapad-internal-WasmSplashPresenter, reason: not valid java name */
    /* synthetic */ void m153lambda$onCallback$2$comtapsdktapadinternalWasmSplashPresenter() {
        m152lambda$onCallback$1$comtapsdktapadinternalWasmSplashPresenter("Core Splash video failed");
    }

    public void load(TapAdNative.SplashAdListener splashAdListener) {
        this.loadListener = splashAdListener;
        final DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        WasmCoreModuleLoader.load(dirichletRuntime, new WasmCoreModuleLoader.Callback() { // from class: com.tapsdk.tapad.internal.WasmSplashPresenter.1
            @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
            public void onError(Exception exc) {
                WasmSplashPresenter.this.failLoad(exc);
            }

            @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
            public void onLoaded(WasmModule wasmModule) {
                WasmSplashPresenter.this.prepare(dirichletRuntime, wasmModule);
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
            case "onCoreRuntimeFatal":
                if (!this.showing && !this.ready) {
                    failLoad(WasmRewardPresenter.parseLoadError(str2));
                    break;
                } else {
                    this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmSplashPresenter$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m152lambda$onCallback$1$comtapsdktapadinternalWasmSplashPresenter(str);
                        }
                    });
                    break;
                }
                break;
            case "onAdTimeOver":
            case "onAdClick":
            case "onAdValidShow":
            case "onAdSkip":
                forward(str);
                break;
            case "onSplashAdError":
                failLoad(WasmRewardPresenter.parseLoadError(str2));
                break;
            case "onAdClose":
                if (!this.fallbackActive) {
                    dispose();
                    break;
                }
                break;
            case "onSplashAdLoaded":
                handleLoaded(str2);
                break;
            case "onAdShow":
                this.shown = true;
                notifyIoniaShown();
                forward(str);
                break;
            case "onVideoError":
                this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmSplashPresenter$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m153lambda$onCallback$2$comtapsdktapadinternalWasmSplashPresenter();
                    }
                });
                break;
        }
    }

    public static final class AdapterSplashAd implements TapSplashAd {
        private final WasmSplashPresenter presenter;

        public AdapterSplashAd(WasmSplashPresenter wasmSplashPresenter) {
            this.presenter = wasmSplashPresenter;
        }

        @Override // com.tapsdk.tapad.TapSplashAd
        public void destroyView() {
            this.presenter.dispose();
        }

        @Override // com.tapsdk.tapad.TapSplashAd
        public void dispose() {
            this.presenter.dispose();
        }

        @Override // com.tapsdk.tapad.TapSplashAd
        public long getExpirationTimestamp() {
            return this.presenter.expirationEpochSeconds;
        }

        @Override // com.tapsdk.tapad.TapSplashAd
        public Map<String, Object> getMediaExtraInfo() {
            HashMap map;
            synchronized (this.presenter.mediaExtraInfo) {
                map = new HashMap(this.presenter.mediaExtraInfo);
            }
            return map;
        }

        @Override // com.tapsdk.tapad.TapSplashAd
        public long getPrice() {
            return this.presenter.price;
        }

        @Override // com.tapsdk.tapad.TapSplashAd
        public View getSplashView(Activity activity) {
            return this.presenter.splashView(activity);
        }

        @Override // com.tapsdk.tapad.TapSplashAd
        public boolean isValid() {
            return this.presenter.isValid();
        }

        @Override // com.tapsdk.tapad.TapSplashAd
        public void sendLossNotification(Map<String, Object> map) {
            this.presenter.reportBidding(false, map);
        }

        @Override // com.tapsdk.tapad.TapSplashAd
        public void sendWinNotification(Map<String, Object> map) {
            this.presenter.reportBidding(true, map);
        }

        @Override // com.tapsdk.tapad.TapSplashAd
        public void setSplashInteractionListener(TapSplashAd.AdInteractionListener adInteractionListener) {
            this.presenter.interactionListener = adInteractionListener;
        }

        @Override // com.tapsdk.tapad.TapSplashAd
        public void show(Activity activity) {
            if (activity == null) {
                return;
            }
            View splashView = getSplashView(activity);
            View viewFindViewById = activity.findViewById(R.id.content);
            if (splashView != null && (viewFindViewById instanceof ViewGroup) && splashView.getParent() == null) {
                ((ViewGroup) viewFindViewById).addView(splashView, new ViewGroup.LayoutParams(-1, -1));
            }
        }

        @Override // com.tapsdk.tapad.TapSplashAd
        public void show(ViewGroup viewGroup) {
            View splashView;
            Activity activityResolveActivity = WasmSplashPresenter.resolveActivity(viewGroup);
            if (activityResolveActivity == null || (splashView = getSplashView(activityResolveActivity)) == null) {
                return;
            }
            if ((splashView.getParent() instanceof ViewGroup) && splashView.getParent() != viewGroup) {
                ((ViewGroup) splashView.getParent()).removeView(splashView);
            }
            if (splashView.getParent() == null) {
                viewGroup.addView(splashView, new ViewGroup.LayoutParams(-1, -1));
            }
        }
    }
}

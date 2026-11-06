package com.tapsdk.tapad.internal;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mar.sdk.IAction;
import com.tapsdk.tapad.AdRequest;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapBannerAd;
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
public final class WasmBannerPresenter implements AdCallbackListener {
    private static final long FALLBACK_VALID_DELAY_MS = 1000;
    private static final String FN_IS_READY = "ad_is_ready_instance";
    private static final String FN_LOAD = "ad_load_instance";
    private static final String FN_LOSS = "ad_send_loss_notification_instance";
    private static final String FN_PRESENT = "ad_present_banner_instance_v2";
    private static final String FN_RENDER = "ad_render_banner";
    private static final String FN_WIN = "ad_send_win_notification_instance";
    private static final String TAG = "WasmBannerPresenter";
    private AdapterBannerAd callbackAd;
    private final Context context;
    private boolean fallbackActive;
    private boolean fallbackOnly;
    private TapBannerAd.BannerInteractionListener interactionListener;
    private IoniaAdWindowTracker ioniaWindowTracker;
    private boolean loadFinished;
    private TapAdNative.BannerAdListener loadListener;
    private int orientation;
    private int preferredWidthDp;
    private long price;
    private volatile boolean ready;
    private final AdRequest request;
    private FrameLayout root;
    private volatile boolean showing;
    private boolean shown;
    private boolean validShown;
    private final WeakReference<Context> viewContextRef;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final WasmAdnLoadAttempt loadAttempt = new WasmAdnLoadAttempt();
    private final Map<String, Object> mediaExtraInfo = new HashMap();
    private final AtomicBoolean disposed = new AtomicBoolean(false);
    private WeakReference<WasmAdInstance> instanceRef = new WeakReference<>(null);
    private int hostToken = -1;
    private String trackId = "";
    private int preferredHeightDp = 94;
    private final Runnable fallbackValid = new Runnable() { // from class: com.tapsdk.tapad.internal.WasmBannerPresenter$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.m108lambda$new$0$comtapsdktapadinternalWasmBannerPresenter();
        }
    };

    public static final class AdapterBannerAd implements TapBannerAd {
        private final WasmBannerPresenter presenter;

        public AdapterBannerAd(WasmBannerPresenter wasmBannerPresenter) {
            this.presenter = wasmBannerPresenter;
        }

        @Override // com.tapsdk.tapad.TapBannerAd
        public void dispose() {
            this.presenter.dispose();
        }

        @Override // com.tapsdk.tapad.TapBannerAd
        public View getBannerView() {
            return this.presenter.bannerView();
        }

        @Override // com.tapsdk.tapad.TapBannerAd
        public Map<String, Object> getMediaExtraInfo() {
            HashMap map;
            synchronized (this.presenter.mediaExtraInfo) {
                map = new HashMap(this.presenter.mediaExtraInfo);
            }
            return map;
        }

        @Override // com.tapsdk.tapad.TapBannerAd
        public long getPrice() {
            return this.presenter.price;
        }

        @Override // com.tapsdk.tapad.TapBannerAd
        public boolean isValid() {
            return this.presenter.isValid();
        }

        @Override // com.tapsdk.tapad.TapBannerAd
        public void sendLossNotification(Map<String, Object> map) {
            this.presenter.reportBidding(false, map);
        }

        @Override // com.tapsdk.tapad.TapBannerAd
        public void sendWinNotification(Map<String, Object> map) {
            this.presenter.reportBidding(true, map);
        }

        @Override // com.tapsdk.tapad.TapBannerAd
        public void setBannerInteractionListener(TapBannerAd.BannerInteractionListener bannerInteractionListener) {
            this.presenter.interactionListener = bannerInteractionListener;
        }

        @Override // com.tapsdk.tapad.TapBannerAd
        public void show(Activity activity, int i, int i2) {
            View bannerView;
            if (activity == null || (bannerView = getBannerView()) == null) {
                return;
            }
            if (bannerView.getParent() instanceof ViewGroup) {
                ((ViewGroup) bannerView.getParent()).removeView(bannerView);
            }
            FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.content);
            if (frameLayout == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.presenter.preferredWidthDp > 0 ? WasmBannerPresenter.dp(bannerView, this.presenter.preferredWidthDp) : -1, WasmBannerPresenter.dp(bannerView, this.presenter.preferredHeightDp), i == 0 ? 48 : 80);
            if (i == 0) {
                layoutParams.topMargin = Math.max(0, i2);
            } else {
                layoutParams.bottomMargin = Math.max(0, i2);
            }
            frameLayout.addView(bannerView, layoutParams);
        }
    }

    public WasmBannerPresenter(Context context, AdRequest adRequest) {
        this.context = context.getApplicationContext();
        this.viewContextRef = new WeakReference<>(context);
        this.request = adRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout bannerView() {
        if (this.disposed.get()) {
            return null;
        }
        FrameLayout frameLayout = this.root;
        if (frameLayout != null) {
            return frameLayout;
        }
        Context context = this.viewContextRef.get();
        if (context == null) {
            return null;
        }
        final FrameLayout frameLayout2 = new FrameLayout(context) { // from class: com.tapsdk.tapad.internal.WasmBannerPresenter.2
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                IoniaAdWindowTracker ioniaAdWindowTracker = WasmBannerPresenter.this.ioniaWindowTracker;
                if (ioniaAdWindowTracker != null) {
                    ioniaAdWindowTracker.onTouchEvent(motionEvent);
                }
                return super.dispatchTouchEvent(motionEvent);
            }
        };
        frameLayout2.setBackgroundColor(-1);
        frameLayout2.setMinimumHeight(dp(frameLayout2, this.preferredHeightDp));
        int i = this.preferredWidthDp;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(i > 0 ? dp(frameLayout2, i) : -1, dp(frameLayout2, this.preferredHeightDp)));
        frameLayout2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.tapsdk.tapad.internal.WasmBannerPresenter.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                WasmBannerPresenter.this.beginPresent(frameLayout2);
                if (WasmBannerPresenter.this.shown) {
                    WasmBannerPresenter.this.notifyIoniaShown();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                WasmBannerPresenter.this.notifyIoniaHidden();
            }
        });
        this.root = frameLayout2;
        return frameLayout2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginPresent(FrameLayout frameLayout) {
        if (this.disposed.get() || this.showing || !this.ready) {
            return;
        }
        this.showing = true;
        this.ready = false;
        if (this.fallbackOnly) {
            m109lambda$onCallback$2$comtapsdktapadinternalWasmBannerPresenter("embedded shell");
            return;
        }
        WasmAdInstance wasmAdInstanceInstance = instance();
        if (wasmAdInstanceInstance == null) {
            m109lambda$onCallback$2$comtapsdktapadinternalWasmBannerPresenter("Core Banner instance unavailable");
            return;
        }
        DirichletRuntime.getInstance().registerAdSurface(wasmAdInstanceInstance.instanceId(), wasmAdInstanceInstance.module(), this, this);
        int iRegister = InlineAdSurfaceHost.register(frameLayout, AdType.Banner);
        this.hostToken = iRegister;
        if (iRegister <= 0) {
            m109lambda$onCallback$2$comtapsdktapadinternalWasmBannerPresenter("Banner inline host registration failed");
        } else {
            wasmAdInstanceInstance.module().callInt(FN_PRESENT, new WasmModule.IntCallback() { // from class: com.tapsdk.tapad.internal.WasmBannerPresenter$$ExternalSyntheticLambda6
                @Override // com.tapsdk.tapad.internal.runtime.WasmModule.IntCallback
                public final void onResult(int i) {
                    this.f$0.m106lambda$beginPresent$4$comtapsdktapadinternalWasmBannerPresenter(i);
                }
            }, Integer.valueOf(wasmAdInstanceInstance.instanceId()), Integer.valueOf(this.hostToken), 1, Integer.valueOf(ShowHostFacts.forInline(frameLayout)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeLoad() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmBannerPresenter$$ExternalSyntheticLambda7
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
        AdapterBannerAd adapterBannerAd = new AdapterBannerAd(this);
        this.callbackAd = adapterBannerAd;
        TapAdNative.BannerAdListener bannerAdListener = this.loadListener;
        this.loadListener = null;
        if (bannerAdListener != null) {
            bannerAdListener.onBannerAdLoad(adapterBannerAd);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static int dp(View view, int i) {
        float f = view.getResources().getDisplayMetrics().density;
        float f2 = i;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return Math.round(f2 * f);
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
            this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmBannerPresenter$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m107lambda$failLoad$3$comtapsdktapadinternalWasmBannerPresenter(exc, z);
                }
            });
        } else {
            m107lambda$failLoad$3$comtapsdktapadinternalWasmBannerPresenter(exc, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: failLoadOnMain, reason: merged with bridge method [inline-methods] */
    public void m107lambda$failLoad$3$comtapsdktapadinternalWasmBannerPresenter(Exception exc, boolean z) {
        if (this.disposed.get() || this.loadFinished) {
            return;
        }
        disposeCore();
        if (z) {
            this.fallbackOnly = true;
            this.ready = true;
            this.trackId = "dirichlet-extreme-banner";
            this.mediaExtraInfo.put("extreme_fallback", Boolean.TRUE);
            completeLoad();
            return;
        }
        this.loadFinished = true;
        TapAdNative.BannerAdListener bannerAdListener = this.loadListener;
        this.loadListener = null;
        if (bannerAdListener != null) {
            bannerAdListener.onError(WasmRewardPresenter.resolvePublicLoadErrorCode(exc, ErrorCodeEnum.INTERNAL_ERROR.getCode()), WasmRewardPresenter.loadErrorMessage(exc));
        }
    }

    public static TapBannerAd fallbackOnly(Context context) {
        WasmBannerPresenter wasmBannerPresenter = new WasmBannerPresenter(context, new AdRequest.Builder().withSpaceId(0L).build());
        wasmBannerPresenter.fallbackOnly = true;
        wasmBannerPresenter.ready = true;
        wasmBannerPresenter.trackId = "dirichlet-extreme-banner";
        wasmBannerPresenter.mediaExtraInfo.put("extreme_fallback", Boolean.TRUE);
        AdapterBannerAd adapterBannerAd = new AdapterBannerAd(wasmBannerPresenter);
        wasmBannerPresenter.callbackAd = adapterBannerAd;
        return adapterBannerAd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishWithClose() {
        if (this.disposed.get()) {
            return;
        }
        TapBannerAd.BannerInteractionListener bannerInteractionListener = this.interactionListener;
        if (bannerInteractionListener != null) {
            bannerInteractionListener.onAdClose();
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
        TapBannerAd.BannerInteractionListener bannerInteractionListener = this.interactionListener;
        if (bannerInteractionListener == null) {
            return;
        }
        str.getClass();
        switch (str) {
            case "onAdClick":
                bannerInteractionListener.onAdClick();
                break;
            case "onAdValidShow":
                bannerInteractionListener.onAdValidShow();
                break;
            case "onAdShow":
                bannerInteractionListener.onAdShow();
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
            this.orientation = jSONObject.optInt("orientation", 0);
            this.preferredWidthDp = jSONObject.optInt("preferred_width_dp", 0);
            int i = 94;
            int iOptInt = jSONObject.optInt("preferred_height_dp", 94);
            if (iOptInt >= 48 && iOptInt <= 200) {
                i = iOptInt;
            }
            this.preferredHeightDp = i;
            if (this.preferredWidthDp <= 0 && this.orientation == 2) {
                this.preferredWidthDp = MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
            }
            copyMediaExtra(jSONObject);
            this.ioniaWindowTracker = IoniaAdWindowTracker.forBanner(this.trackId, ioniaTriggerCorrelationId());
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
                failLoad(new IllegalStateException(c.a("Core Banner export missing: ", str)));
                return;
            }
        }
        if (dirichletRuntime.runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmBannerPresenter$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m110lambda$prepare$1$comtapsdktapadinternalWasmBannerPresenter(dirichletRuntime, wasmModule);
            }
        })) {
            return;
        }
        failLoad(new IllegalStateException("Core runtime queue unavailable"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: prepareOnRuntime, reason: merged with bridge method [inline-methods] */
    public void m110lambda$prepare$1$comtapsdktapadinternalWasmBannerPresenter(DirichletRuntime dirichletRuntime, WasmModule wasmModule) {
        try {
            if (!AdnRuntimeBootstrap.getInstance().ensurePublisherInstalled(this.context, dirichletRuntime, wasmModule)) {
                failLoad(new IllegalStateException("ADN publisher is not initialized"));
                return;
            }
            WeakReference<WasmAdInstance> weakReferenceCreate = WasmAdInstance.create(wasmModule, new DirichletRuntime.NativeCallback() { // from class: com.tapsdk.tapad.internal.WasmBannerPresenter$$ExternalSyntheticLambda5
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
                    wasmModule.callVoidSync(FN_LOAD, Integer.valueOf(wasmAdInstance.instanceId()), MediationConstant.RIT_TYPE_BANNER, jSONObjectCreate.toString());
                    return;
                }
                return;
            }
            if (wasmAdInstance != null) {
                wasmAdInstance.dispose();
            }
            failLoad(new IllegalStateException("Core Banner instance creation failed"));
        } catch (Throwable th) {
            failLoad(new RuntimeException("Core Banner preparation failed", th));
        }
    }

    private static void putIfNotEmpty(Map<String, Object> map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    private void renderFallback(FrameLayout frameLayout) {
        frameLayout.removeAllViews();
        frameLayout.setBackgroundColor(-1);
        ImageView imageView = new ImageView(frameLayout.getContext());
        imageView.setImageResource(com.tapsdk.tapad.R.drawable.tapad_banner_extreme_fallback);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(false);
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(frameLayout.getContext());
        textView.setText("×");
        textView.setTextColor(-1);
        textView.setTextSize(16.0f);
        textView.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1728053248);
        gradientDrawable.setShape(1);
        textView.setBackground(gradientDrawable);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tapsdk.tapad.internal.WasmBannerPresenter$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m111lambda$renderFallback$5$comtapsdktapadinternalWasmBannerPresenter(view);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp(frameLayout, 24), dp(frameLayout, 24), 53);
        layoutParams.topMargin = dp(frameLayout, 6);
        layoutParams.rightMargin = dp(frameLayout, 6);
        frameLayout.addView(textView, layoutParams);
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
    /* JADX INFO: renamed from: startFallback, reason: merged with bridge method [inline-methods] */
    public void m109lambda$onCallback$2$comtapsdktapadinternalWasmBannerPresenter(String str) {
        if (this.disposed.get() || this.fallbackActive) {
            return;
        }
        notifyIoniaHidden();
        this.ioniaWindowTracker = null;
        int i = this.hostToken;
        if (i > 0) {
            FrameLayout frameLayoutTakeOverForFallback = InlineAdSurfaceHost.takeOverForFallback(i);
            if (frameLayoutTakeOverForFallback != null) {
                this.root = frameLayoutTakeOverForFallback;
            }
            this.hostToken = -1;
        }
        disposeCore();
        if (this.root == null) {
            return;
        }
        this.fallbackOnly = true;
        this.fallbackActive = true;
        this.price = 0L;
        this.trackId = "dirichlet-extreme-banner";
        synchronized (this.mediaExtraInfo) {
            this.mediaExtraInfo.clear();
            this.mediaExtraInfo.put("extreme_fallback", Boolean.TRUE);
        }
        renderFallback(this.root);
        if (!this.shown) {
            this.shown = true;
            forward("onAdShow");
        }
        this.mainHandler.postDelayed(this.fallbackValid, 1000L);
    }

    public void dispose() {
        if (this.disposed.compareAndSet(false, true)) {
            this.mainHandler.removeCallbacks(this.fallbackValid);
            notifyIoniaHidden();
            this.ioniaWindowTracker = null;
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
            this.fallbackActive = false;
            this.loadListener = null;
            this.interactionListener = null;
        }
    }

    /* JADX INFO: renamed from: lambda$beginPresent$4$com-tapsdk-tapad-internal-WasmBannerPresenter, reason: not valid java name */
    /* synthetic */ void m106lambda$beginPresent$4$comtapsdktapadinternalWasmBannerPresenter(int i) {
        if (ShowHostFacts.isAdmissionRejection(i) && !this.shown && !this.disposed.get()) {
            dispose();
        } else {
            if (i > 0 || this.shown || this.disposed.get()) {
                return;
            }
            m109lambda$onCallback$2$comtapsdktapadinternalWasmBannerPresenter(b.a("Core Banner surface attach failed: ", i));
        }
    }

    /* JADX INFO: renamed from: lambda$new$0$com-tapsdk-tapad-internal-WasmBannerPresenter, reason: not valid java name */
    /* synthetic */ void m108lambda$new$0$comtapsdktapadinternalWasmBannerPresenter() {
        if (this.disposed.get() || !this.fallbackActive || this.validShown) {
            return;
        }
        this.validShown = true;
        TapBannerAd.BannerInteractionListener bannerInteractionListener = this.interactionListener;
        if (bannerInteractionListener != null) {
            bannerInteractionListener.onAdValidShow();
        }
    }

    /* JADX INFO: renamed from: lambda$renderFallback$5$com-tapsdk-tapad-internal-WasmBannerPresenter, reason: not valid java name */
    /* synthetic */ void m111lambda$renderFallback$5$comtapsdktapadinternalWasmBannerPresenter(View view) {
        finishWithClose();
    }

    public void load(TapAdNative.BannerAdListener bannerAdListener) {
        this.loadListener = bannerAdListener;
        final DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        WasmCoreModuleLoader.load(dirichletRuntime, new WasmCoreModuleLoader.Callback() { // from class: com.tapsdk.tapad.internal.WasmBannerPresenter.1
            @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
            public void onError(Exception exc) {
                WasmBannerPresenter.this.failLoad(exc);
            }

            @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
            public void onLoaded(WasmModule wasmModule) {
                WasmBannerPresenter.this.prepare(dirichletRuntime, wasmModule);
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
                    this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmBannerPresenter$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m109lambda$onCallback$2$comtapsdktapadinternalWasmBannerPresenter(str);
                        }
                    });
                    break;
                }
                break;
            case "onAdClick":
            case "onAdValidShow":
                if ("onAdValidShow".equals(str)) {
                    this.validShown = true;
                }
                forward(str);
                break;
            case "onAdClose":
                this.mainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmBannerPresenter$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.finishWithClose();
                    }
                });
                break;
            case "onAdShow":
                this.shown = true;
                notifyIoniaShown();
                forward(str);
                break;
            case "onBannerAdError":
                failLoad(WasmRewardPresenter.parseLoadError(str2));
                break;
            case "onBannerAdLoaded":
                handleLoaded(str2);
                break;
        }
    }
}

package com.tapsdk.tapad.group.ads;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.a;
import com.tapsdk.tapad.group.adapter.AdapterNativeImage;
import com.tapsdk.tapad.group.adapter.AdapterNativeSplashBinding;
import com.tapsdk.tapad.group.adapter.AdapterNativeSplashSession;
import com.tapsdk.tapad.group.adapter.AdapterViewSupport;
import com.tapsdk.tapad.group.views.DirichletAdNativeContainer;
import com.tapsdk.tapad.internal.runtime.MediationRuntimeCoreBridge;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderAttributionSlots;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import com.tapsdk.tapad.internal.runtime.view.ContainerViewManager;
import com.tapsdk.tapad.internal.selfrender.ProviderEventSink;
import com.tapsdk.tapad.internal.selfrender.ProviderMotionAction;
import com.tapsdk.tapad.internal.selfrender.ProviderSplashPresenter;
import com.tapsdk.tapad.internal.selfrender.ProviderSplashSession;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class MediationNativeSplashSession extends MediationSplashSession implements ProviderSplashSession.HostEvents {
    private static final int CLOSE_BOTTOM_LEFT = 2;
    private static final int CLOSE_BOTTOM_RIGHT = 3;
    private static final int CLOSE_TOP_RIGHT = 1;
    private static final int IMAGE_MODE_VIDEO = 2;
    private static final String RAW_CLOSE_POSITION = "__d_splash_close_position";
    private static final String RAW_CORE_TRIGGER = "__d_splash_core_trigger";
    private static final String RAW_COUNTDOWN_MS = "__d_splash_countdown_ms";
    private static final String RAW_NATIVE_SPLASH = "__d_native_splash";
    private static final String RAW_REMAINING_MS = "__d_splash_remaining_ms";
    private static final String RAW_RENDER_DURATION_MS = "__d_splash_render_duration_ms";
    private static final String RAW_VIEW_DURATION_MS = "__d_splash_view_duration_ms";
    private static final String RAW_VIEW_ORIENTATION = "__d_splash_view_orientation";
    private static final String RAW_VIEW_TAG = "__d_splash_view_tag";
    private volatile Activity activity;
    private final AtomicBoolean baseDestroyed;
    private final NativeCoreSession coreSession;
    private long countdownEndUptimeMillis;
    private volatile View latestCreativeView;
    private final AdapterNativeSplashSession nativeSession;
    private AdapterNativeSplashBinding nativeSplashBinding;
    private volatile int pendingClickTrigger;
    private int presentationClosePosition;
    private long presentationCountdownMillis;
    private volatile ProviderSplashPresenter presenter;
    private long renderDurationMillis;
    private long renderStartMillis;
    private long showStartMillis;

    public MediationNativeSplashSession(AdapterNativeSplashSession adapterNativeSplashSession) {
        super(adapterNativeSplashSession);
        this.baseDestroyed = new AtomicBoolean(false);
        NativeCoreSession nativeCoreSession = new NativeCoreSession();
        this.coreSession = nativeCoreSession;
        this.presentationClosePosition = 3;
        this.nativeSession = adapterNativeSplashSession;
        adapterNativeSplashSession.setEventSink(nativeCoreSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindSplash(Activity activity, FrameLayout frameLayout, View view, List<View> list, ProviderAttributionSlots providerAttributionSlots) {
        bindSplash(activity, frameLayout, view, new ProviderInteractionViews(list, list, null), providerAttributionSlots);
    }

    private ProviderSplashSession.LoadFacts buildSplashLoadFacts() {
        return new ProviderSplashSession.LoadFacts(getRequestId(), getTrackId(), getDecisionTags());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout createSplashRoot(Context context) {
        return new DirichletAdNativeContainer(context);
    }

    private void dispatchSplashClicked(View view) {
        View viewResolveClickTrackingView = resolveClickTrackingView(view);
        int i = this.pendingClickTrigger;
        this.pendingClickTrigger = 0;
        effects().selfNativeClick(this, this.activity, viewResolveClickTrackingView, i);
        super.onClick(viewResolveClickTrackingView);
    }

    private void dispatchSplashRenderFailed(int i, String str, View view) {
        this.renderDurationMillis = Math.max(0L, System.currentTimeMillis() - this.renderStartMillis);
        super.onRenderFailure(view, i, str);
    }

    private void dispatchSplashShown(View view) {
        this.showStartMillis = System.currentTimeMillis();
        super.onShow(view);
    }

    private static String firstNonEmpty(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return str2 == null ? "" : str2;
        }
        return str;
    }

    private FrameLayout.LayoutParams getAdLogoLayoutParams(Context context) {
        int i;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AdapterViewSupport.dpToPx(context, 34.0f), AdapterViewSupport.dpToPx(context, 16.0f));
        int nativeSplashClosePosition = getNativeSplashClosePosition();
        if (nativeSplashClosePosition == 1) {
            i = 53;
        } else {
            i = nativeSplashClosePosition == 2 ? 83 : 85;
        }
        layoutParams.gravity = i;
        float f = 87.0f;
        int iDpToPx = AdapterViewSupport.dpToPx(context, nativeSplashClosePosition == 2 ? 87.0f : 0.0f);
        int iDpToPx2 = AdapterViewSupport.dpToPx(context, nativeSplashClosePosition == 1 ? 52.0f : 0.0f);
        if (nativeSplashClosePosition != 1 && nativeSplashClosePosition != 3) {
            f = 0.0f;
        }
        layoutParams.setMargins(iDpToPx, iDpToPx2, AdapterViewSupport.dpToPx(context, f), AdapterViewSupport.dpToPx(context, nativeSplashClosePosition != 1 ? 27.0f : 0.0f));
        return layoutParams;
    }

    private List<String> getDecisionTags() {
        List<String> decisionTags = this.nativeSession.getDecisionTags();
        return decisionTags == null ? Collections.EMPTY_LIST : decisionTags;
    }

    private View getInternalAdView(Context context) {
        return this.nativeSession.getMediaView(context);
    }

    private int getNativeSplashClosePosition() {
        return this.presentationClosePosition;
    }

    private Map<String, Object> nativeSplashEventFacts(View view) {
        return MediationCandidateEffects.statusFacts(this, 0, "", null, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] normalizedSplashCreative() {
        return MediationRuntimeCoreBridge.normalizeProviderCreative(MediationConstant.RIT_TYPE_SPLASH, firstNonEmpty(getTrackId(), getRequestId()), this.nativeSession, getExpirationTimestamp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyNativeSplashGetView(View view) {
        if (view != null) {
            effects().codebitGetView(this, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean performSplashMotionAction(View view, int i, List<View> list) {
        this.pendingClickTrigger = i;
        if (view == null) {
            view = this.latestCreativeView;
        }
        boolean zPerformShake = ProviderMotionAction.performShake(i, view, list);
        if (!zPerformShake) {
            this.pendingClickTrigger = 0;
        }
        return zPerformShake;
    }

    private static void putViewMeasurements(Map<String, Object> map, String str, View view) {
        if (map == null || view == null) {
            return;
        }
        map.put(a.a(str, "_width"), Integer.valueOf(view.getWidth()));
        map.put(str + "_height", Integer.valueOf(view.getHeight()));
        map.put(str + "_measured_width", Integer.valueOf(view.getMeasuredWidth()));
        map.put(str + "_measured_height", Integer.valueOf(view.getMeasuredHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseSplashProvider() {
        AdapterNativeSplashBinding adapterNativeSplashBinding = this.nativeSplashBinding;
        if (adapterNativeSplashBinding != null) {
            adapterNativeSplashBinding.release();
            this.nativeSplashBinding = null;
        }
        this.nativeSession.destroy();
    }

    private View resolveClickTrackingView(View view) {
        return view != null ? view : this.latestCreativeView;
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    private int safeImageMode() {
        try {
            return getImageMode();
        } catch (Throwable th) {
            return -1;
        }
    }

    private int safeInteractionType() {
        try {
            return getInteractionType();
        } catch (Throwable th) {
            return -1;
        }
    }

    private String splashFallbackImageUrl() {
        List<AdapterNativeImage> images = this.nativeSession.getImages();
        if (images == null) {
            return "";
        }
        for (AdapterNativeImage adapterNativeImage : images) {
            if (adapterNativeImage != null && adapterNativeImage.getUrl() != null && !adapterNativeImage.getUrl().isEmpty()) {
                return adapterNativeImage.getUrl();
            }
        }
        return "";
    }

    private static int viewOrientation(View view) {
        if (view == null || view.getResources() == null) {
            return 0;
        }
        return view.getResources().getConfiguration().orientation;
    }

    public void addCoreTriggerFact(Map<String, Object> map, int i) {
        if (map == null || i <= 0) {
            return;
        }
        map.put(RAW_CORE_TRIGGER, Integer.valueOf(i));
    }

    public void addTelemetryFacts(Map<String, Object> map, View view) {
        if (map == null) {
            return;
        }
        map.put(RAW_NATIVE_SPLASH, Boolean.TRUE);
        Object tag = view == null ? null : view.getTag();
        if (!(tag instanceof String)) {
            tag = "";
        }
        map.put(RAW_VIEW_TAG, tag);
        map.put(RAW_VIEW_ORIENTATION, Integer.valueOf(viewOrientation(view)));
        map.put(RAW_CLOSE_POSITION, Integer.valueOf(this.presentationClosePosition));
        map.put(RAW_REMAINING_MS, Long.valueOf(getLeftMillisForTracking()));
        map.put(RAW_RENDER_DURATION_MS, Long.valueOf(getRenderDurationForTracking()));
        map.put(RAW_VIEW_DURATION_MS, Long.valueOf(getViewDurationForTracking()));
        map.put("interaction_type", Integer.valueOf(safeInteractionType()));
        map.put("image_mode", Integer.valueOf(safeImageMode()));
        putViewMeasurements(map, "native_splash_view", view);
    }

    public int getImageMode() {
        return this.nativeSession.getImageMode();
    }

    public int getInteractionType() {
        return this.nativeSession.getInteractionType();
    }

    public long getLeftMillisForTracking() {
        long j = this.countdownEndUptimeMillis;
        if (j <= 0) {
            return 0L;
        }
        return Math.max(0L, j - SystemClock.uptimeMillis());
    }

    public long getRenderDurationForTracking() {
        return Math.max(0L, this.renderDurationMillis);
    }

    public long getViewDurationForTracking() {
        if (this.showStartMillis <= 0) {
            return 0L;
        }
        return Math.max(0L, System.currentTimeMillis() - this.showStartMillis);
    }

    @Override // com.tapsdk.tapad.group.ads.MediationSplashSession
    public final void innerShow(ViewGroup viewGroup) {
        this.renderStartMillis = System.currentTimeMillis();
        this.presentationClosePosition = nativeSplashClosePosition();
        Map<String, Object> mapNativeSplashEventFacts = nativeSplashEventFacts(viewGroup);
        putViewMeasurements(mapNativeSplashEventFacts, ContainerViewManager.NAME, viewGroup);
        effects().reportCandidateFact(36, mapNativeSplashEventFacts);
        this.presenter = ProviderSplashPresenter.show(viewGroup, this.coreSession, this, buildSplashLoadFacts(), splashFallbackImageUrl());
    }

    public View latestCreativeView() {
        return this.latestCreativeView;
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate
    public void onBeforeSessionDestroy() {
        if (this.baseDestroyed.compareAndSet(false, true)) {
            this.coreSession.clearProviderEventSink();
            this.latestCreativeView = null;
            this.activity = null;
            ProviderSplashPresenter providerSplashPresenter = this.presenter;
            this.presenter = null;
            if (providerSplashPresenter != null) {
                providerSplashPresenter.dispose();
            }
        }
    }

    @Override // com.tapsdk.tapad.group.ads.MediationSplashSession, com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onClick(View view) {
        dispatchSplashClicked(view);
    }

    @Override // com.tapsdk.tapad.internal.selfrender.ProviderSplashSession.HostEvents
    public void onPresentationStarted(Activity activity) {
        effects().codebitShow(this, activity);
    }

    @Override // com.tapsdk.tapad.group.ads.MediationSplashSession, com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onRenderFailure(View view, int i, String str) {
        dispatchSplashRenderFailed(i, str, view);
    }

    @Override // com.tapsdk.tapad.group.ads.MediationSplashSession, com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onShow(View view) {
        dispatchSplashShown(view);
    }

    @Override // com.tapsdk.tapad.internal.selfrender.ProviderSplashSession.HostEvents
    public void onSplashBound(View view, long j) {
        this.presentationCountdownMillis = Math.max(0L, j);
        this.renderDurationMillis = Math.max(0L, System.currentTimeMillis() - this.renderStartMillis);
        this.countdownEndUptimeMillis = SystemClock.uptimeMillis() + this.presentationCountdownMillis;
        effects().reportCandidateFact(38, nativeSplashEventFacts(null));
        Map<String, Object> mapNativeSplashEventFacts = nativeSplashEventFacts(null);
        mapNativeSplashEventFacts.put(RAW_COUNTDOWN_MS, Long.valueOf(this.presentationCountdownMillis));
        effects().reportCandidateFact(35, mapNativeSplashEventFacts);
        super.onRenderSuccess(view, view == null ? 0.0f : view.getWidth(), view != null ? view.getHeight() : 0.0f);
    }

    @Override // com.tapsdk.tapad.internal.selfrender.ProviderSplashSession.HostEvents
    public void onSplashSkipped() {
        effects().reportCandidateFact(37, nativeSplashEventFacts(null));
        super.onSkip();
    }

    @Override // com.tapsdk.tapad.internal.selfrender.ProviderSplashSession.HostEvents
    public void onSplashTimeOver() {
        effects().reportCandidateFact(34, nativeSplashEventFacts(null));
        super.onTimeOver();
    }

    public final class NativeCoreSession extends NativeProviderEventRelay implements ProviderSplashSession {
        private NativeCoreSession() {
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderSplashSession
        public void bindSplash(Activity activity, FrameLayout frameLayout, View view, List<View> list, ProviderAttributionSlots providerAttributionSlots, ProviderEventSink providerEventSink) {
            bindProviderEventSink(providerEventSink);
            MediationNativeSplashSession.this.bindSplash(activity, frameLayout, view, list, providerAttributionSlots);
        }

        @Override // com.tapsdk.tapad.group.ads.NativeProviderEventRelay
        public boolean canRelayProviderEvent() {
            return !MediationNativeSplashSession.this.baseDestroyed.get();
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderSplashSession
        public FrameLayout createSplashRoot(Context context) {
            return MediationNativeSplashSession.this.createSplashRoot(context);
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderSplashSession
        public byte[] normalizedSplashCreative() {
            return MediationNativeSplashSession.this.normalizedSplashCreative();
        }

        @Override // com.tapsdk.tapad.group.ads.NativeProviderEventRelay
        public void onProviderClicked(View view) {
            MediationNativeSplashSession.this.latestCreativeView = view;
        }

        @Override // com.tapsdk.tapad.group.ads.NativeProviderEventRelay
        public void onProviderShown(View view) {
            MediationNativeSplashSession.this.latestCreativeView = view;
        }

        @Override // com.tapsdk.tapad.group.ads.NativeProviderEventRelay
        public void onProviderViewAcquired(View view) {
            MediationNativeSplashSession.this.notifyNativeSplashGetView(view);
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderSplashSession
        public boolean performSplashMotionAction(View view, int i, List<View> list) {
            return MediationNativeSplashSession.this.performSplashMotionAction(view, i, list);
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderSplashSession
        public void releaseSplashProvider() {
            clearProviderEventSink();
            MediationNativeSplashSession.this.nativeSession.setEventSink(null);
            MediationNativeSplashSession.this.releaseSplashProvider();
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderSplashSession
        public void setSplashVideoMuted(boolean z) {
            if (MediationNativeSplashSession.this.nativeSession.supportsVideoMuteControl()) {
                MediationNativeSplashSession.this.nativeSession.setVideoMuted(z);
            }
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderSplashSession
        public boolean updateSplashInteractionViews(List<View> list, List<View> list2, List<View> list3) {
            return MediationNativeSplashSession.this.nativeSession.updateSplashInteractionViews(list, list2, list3);
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderSplashSession
        public void bindSplash(Activity activity, FrameLayout frameLayout, View view, ProviderInteractionViews providerInteractionViews, ProviderAttributionSlots providerAttributionSlots, ProviderEventSink providerEventSink) {
            bindProviderEventSink(providerEventSink);
            MediationNativeSplashSession.this.bindSplash(activity, frameLayout, view, providerInteractionViews, providerAttributionSlots);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindSplash(Activity activity, FrameLayout frameLayout, View view, ProviderInteractionViews providerInteractionViews, ProviderAttributionSlots providerAttributionSlots) {
        if (!(frameLayout instanceof DirichletAdNativeContainer)) {
            throw new IllegalArgumentException("Splash provider root type mismatch");
        }
        this.activity = activity;
        this.latestCreativeView = view;
        if (getImageMode() == 2) {
            if (!(view instanceof ViewGroup)) {
                throw new IllegalStateException("Splash provider media slot is unavailable");
            }
            View internalAdView = getInternalAdView(activity);
            notifyNativeSplashGetView(internalAdView);
            if (internalAdView == null) {
                throw new IllegalStateException("Splash provider media view is unavailable");
            }
            ViewParent parent = internalAdView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(internalAdView);
            }
            ViewGroup viewGroup = (ViewGroup) view;
            viewGroup.removeAllViews();
            viewGroup.addView(internalAdView, new ViewGroup.LayoutParams(-1, -1));
        }
        if (providerInteractionViews == null) {
            providerInteractionViews = new ProviderInteractionViews(null, null, null);
        }
        if (this.nativeSplashBinding != null) {
            if (!this.nativeSession.updateSplashInteractionViews(providerInteractionViews.getClickViews(), providerInteractionViews.getCreativeViews(), providerInteractionViews.getDirectDownloadViews())) {
                throw new IllegalStateException("Splash provider cannot refresh interaction Views");
            }
        } else {
            AdapterNativeSplashBinding adapterNativeSplashBindingWithDynamicAttributionSlots = AdapterNativeSplashBinding.withDynamicAttributionSlots((DirichletAdNativeContainer) frameLayout, providerInteractionViews.getClickViews(), providerInteractionViews.getCreativeViews(), getAdLogoLayoutParams(activity), providerAttributionSlots);
            this.nativeSplashBinding = adapterNativeSplashBindingWithDynamicAttributionSlots;
            this.nativeSession.bind(activity, adapterNativeSplashBindingWithDynamicAttributionSlots);
        }
    }
}

package com.tapsdk.tapad.group.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.group.adapter.AdapterHostedInterstitialSession;
import com.tapsdk.tapad.group.adapter.AdapterInterstitialSession;
import com.tapsdk.tapad.group.adapter.AdapterNativeFullscreenBinding;
import com.tapsdk.tapad.group.adapter.AdapterNativeInterstitialSession;
import com.tapsdk.tapad.internal.runtime.MediationRuntimeCoreBridge;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderAttributionSlots;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import com.tapsdk.tapad.internal.selfrender.ProviderEventSink;
import com.tapsdk.tapad.internal.selfrender.ProviderInterstitialPresenter;
import com.tapsdk.tapad.internal.selfrender.ProviderInterstitialSession;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class MediationInterstitialSession extends AdapterAdCandidate<AdapterInterstitialSession> implements ProviderInterstitialSession.HostEvents {
    private final NativeCoreSession coreSession;
    private final AtomicBoolean didNotifyClick;
    private final AtomicBoolean didNotifyClose;
    private final AtomicBoolean didNotifyShow;
    private final AdapterHostedInterstitialSession hostedSession;
    private DirichletInterstitialAd.InterstitialAdInteractionListener interactionListener;
    private final AdapterNativeInterstitialSession nativeSession;
    private ProviderInterstitialPresenter providerPresenter;

    /* JADX WARN: Multi-variable type inference failed */
    public MediationInterstitialSession(AdapterInterstitialSession adapterInterstitialSession) {
        super(adapterInterstitialSession);
        NativeCoreSession nativeCoreSession = new NativeCoreSession();
        this.coreSession = nativeCoreSession;
        this.didNotifyShow = new AtomicBoolean(false);
        this.didNotifyClick = new AtomicBoolean(false);
        this.didNotifyClose = new AtomicBoolean(false);
        AdapterHostedInterstitialSession adapterHostedInterstitialSession = adapterInterstitialSession instanceof AdapterHostedInterstitialSession ? (AdapterHostedInterstitialSession) adapterInterstitialSession : null;
        this.hostedSession = adapterHostedInterstitialSession;
        AdapterNativeInterstitialSession adapterNativeInterstitialSession = adapterInterstitialSession instanceof AdapterNativeInterstitialSession ? (AdapterNativeInterstitialSession) adapterInterstitialSession : null;
        this.nativeSession = adapterNativeInterstitialSession;
        if ((adapterHostedInterstitialSession == null) == (adapterNativeInterstitialSession == null)) {
            throw new IllegalArgumentException("Interstitial session must expose exactly one presentation capability");
        }
        if (adapterNativeInterstitialSession != null) {
            adapterInterstitialSession.setEventSink(nativeCoreSession);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdapterNativeInterstitialSession requireNativeSession() {
        AdapterNativeInterstitialSession adapterNativeInterstitialSession = this.nativeSession;
        if (adapterNativeInterstitialSession != null) {
            return adapterNativeInterstitialSession;
        }
        throw new IllegalStateException("Interstitial session is not Core-hosted");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String resolveCreativeId() {
        Object obj = getDirichletExtraInfo().get("track_id");
        String strSafe = obj instanceof String ? (String) obj : "";
        if (strSafe.isEmpty()) {
            strSafe = safe(getTrackId());
        }
        if (strSafe.isEmpty()) {
            strSafe = safe(getRequestId());
        }
        return strSafe.isEmpty() ? "interstitial-" + Integer.toHexString(System.identityHashCode(this)) : strSafe;
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate
    public void onBeforeSessionDestroy() {
        ProviderInterstitialPresenter providerInterstitialPresenter = this.providerPresenter;
        this.providerPresenter = null;
        if (providerInterstitialPresenter != null) {
            providerInterstitialPresenter.dispose();
        }
        this.coreSession.clearProviderEventSink();
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onClick(View view) {
        if (this.didNotifyClick.compareAndSet(false, true)) {
            super.onClick(view);
            final DirichletInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener = this.interactionListener;
            if (interstitialAdInteractionListener != null) {
                Objects.requireNonNull(interstitialAdInteractionListener);
                AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationInterstitialSession$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        interstitialAdInteractionListener.onAdClick();
                    }
                });
            }
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onClose() {
        if (this.didNotifyClose.compareAndSet(false, true)) {
            super.onClose();
            final DirichletInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener = this.interactionListener;
            if (interstitialAdInteractionListener != null) {
                Objects.requireNonNull(interstitialAdInteractionListener);
                AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationInterstitialSession$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        interstitialAdInteractionListener.onAdClose();
                    }
                });
            }
        }
    }

    @Override // com.tapsdk.tapad.internal.selfrender.ProviderInterstitialSession.HostEvents
    public void onPresentationStarted(Activity activity) {
        effects().codebitShow(this, activity);
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onShow(View view) {
        if (this.didNotifyShow.compareAndSet(false, true)) {
            super.onShow(view);
            final DirichletInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener = this.interactionListener;
            if (interstitialAdInteractionListener != null) {
                Objects.requireNonNull(interstitialAdInteractionListener);
                AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationInterstitialSession$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        interstitialAdInteractionListener.onAdShow();
                    }
                });
            }
        }
    }

    public void setInteractionListener(DirichletInterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener) {
        this.interactionListener = interstitialAdInteractionListener;
    }

    public void show(Activity activity) {
        if (MediationShowAdmissionBridge.claimFullscreen(this, 2, activity, isValid())) {
            effects().spaceShow(this, activity);
            if (this.nativeSession != null) {
                this.providerPresenter = ProviderInterstitialPresenter.show(activity, this.coreSession, this);
            } else if (this.hostedSession == null) {
                onRenderFailure(null, -1, "Interstitial session has no presentation capability");
            } else {
                effects().codebitShow(this, activity);
                this.hostedSession.show(activity);
            }
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate
    public boolean usesProviderFullscreenSurface() {
        return this.hostedSession != null;
    }

    public final class NativeCoreSession extends NativeProviderEventRelay implements ProviderInterstitialSession {
        private AdapterNativeFullscreenBinding surfaceBinding;

        private NativeCoreSession() {
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderInterstitialSession
        public void bindInterstitial(Activity activity, FrameLayout frameLayout, ViewGroup viewGroup, List<View> list, ProviderAttributionSlots providerAttributionSlots, ProviderEventSink providerEventSink) {
            bindProviderEventSink(providerEventSink);
            AdapterNativeFullscreenBinding adapterNativeFullscreenBinding = this.surfaceBinding;
            if (adapterNativeFullscreenBinding != null) {
                adapterNativeFullscreenBinding.release();
            }
            this.surfaceBinding = AdapterNativeFullscreenBinding.withDynamicAttributionSlots(frameLayout, viewGroup, list, providerAttributionSlots);
            MediationInterstitialSession.this.requireNativeSession().bind(activity, this.surfaceBinding);
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderInterstitialSession
        public FrameLayout createInterstitialRoot(Activity activity) {
            return MediationInterstitialSession.this.requireNativeSession().createActivityRoot(activity);
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderInterstitialSession
        public ProviderInterstitialSession.LoadFacts interstitialLoadFacts() {
            return new ProviderInterstitialSession.LoadFacts(MediationInterstitialSession.this.getRequestId(), MediationInterstitialSession.this.getTrackId());
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderInterstitialSession
        public byte[] normalizedInterstitialCreative() {
            return MediationRuntimeCoreBridge.normalizeProviderCreative(MediationConstant.RIT_TYPE_INTERSTITIAL, MediationInterstitialSession.this.resolveCreativeId(), MediationInterstitialSession.this.requireNativeSession(), 0L);
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderInterstitialSession
        public void releaseInterstitialProvider() {
            clearProviderEventSink();
            AdapterNativeFullscreenBinding adapterNativeFullscreenBinding = this.surfaceBinding;
            if (adapterNativeFullscreenBinding != null) {
                adapterNativeFullscreenBinding.release();
                this.surfaceBinding = null;
            }
            AdapterNativeInterstitialSession adapterNativeInterstitialSession = MediationInterstitialSession.this.nativeSession;
            if (adapterNativeInterstitialSession != null) {
                adapterNativeInterstitialSession.setEventSink(null);
                adapterNativeInterstitialSession.destroy();
            }
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderInterstitialSession
        public void setInterstitialVideoMuted(boolean z) {
            AdapterNativeInterstitialSession adapterNativeInterstitialSessionRequireNativeSession = MediationInterstitialSession.this.requireNativeSession();
            if (adapterNativeInterstitialSessionRequireNativeSession.supportsVideoMuteControl()) {
                adapterNativeInterstitialSessionRequireNativeSession.setVideoMuted(z);
            }
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderInterstitialSession
        public boolean updateInterstitialCreativeViews(List<View> list) {
            return MediationInterstitialSession.this.requireNativeSession().updateFullscreenCreativeViews(list);
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderInterstitialSession
        public boolean updateInterstitialInteractionViews(List<View> list, List<View> list2, List<View> list3) {
            return MediationInterstitialSession.this.requireNativeSession().updateFullscreenInteractionViews(list, list2, list3);
        }

        @Override // com.tapsdk.tapad.internal.selfrender.ProviderInterstitialSession
        public void bindInterstitial(Activity activity, FrameLayout frameLayout, ViewGroup viewGroup, ProviderInteractionViews providerInteractionViews, ProviderAttributionSlots providerAttributionSlots, ProviderEventSink providerEventSink) {
            bindProviderEventSink(providerEventSink);
            AdapterNativeFullscreenBinding adapterNativeFullscreenBinding = this.surfaceBinding;
            if (adapterNativeFullscreenBinding != null) {
                adapterNativeFullscreenBinding.release();
            }
            if (providerInteractionViews == null) {
                providerInteractionViews = new ProviderInteractionViews(null, null, null);
            }
            this.surfaceBinding = AdapterNativeFullscreenBinding.withDynamicAttributionSlots(frameLayout, viewGroup, providerInteractionViews.getClickViews(), providerInteractionViews.getCreativeViews(), providerInteractionViews.getDirectDownloadViews(), providerAttributionSlots);
            MediationInterstitialSession.this.requireNativeSession().bind(activity, this.surfaceBinding);
        }
    }
}

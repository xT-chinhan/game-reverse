package com.tapsdk.tapad.group.ads;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import com.tapsdk.tapad.group.DirichletAdNative;
import com.tapsdk.tapad.group.adapter.AdapterHostedSplashSession;
import com.tapsdk.tapad.group.adapter.AdapterSplashSession;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
class MediationSplashSession extends AdapterAdCandidate<AdapterSplashSession> {
    private final AtomicBoolean didNotifyClick;
    private final AtomicBoolean didNotifyClose;
    private final AtomicBoolean didNotifyShow;
    private boolean hasShown;
    private DirichletSplashAd.AdInteractionListener interactionListener;
    private boolean renderFailedBeforeShow;

    public MediationSplashSession(AdapterSplashSession adapterSplashSession) {
        super(adapterSplashSession);
        this.didNotifyShow = new AtomicBoolean(false);
        this.didNotifyClick = new AtomicBoolean(false);
        this.didNotifyClose = new AtomicBoolean(false);
    }

    public static Activity resolveActivity(View view) {
        Context baseContext;
        if (view == null) {
            return null;
        }
        Context context = view.getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        while ((context instanceof ContextWrapper) && (baseContext = ((ContextWrapper) context).getBaseContext()) != context) {
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
            context = baseContext;
        }
        return null;
    }

    public final long getExpirationTimestamp() {
        return getSession().getExpirationTimestamp();
    }

    public void innerShow(ViewGroup viewGroup) {
        if (!(getSession() instanceof AdapterHostedSplashSession)) {
            onRenderFailure(null, -1, "Splash session has no presentation capability");
        } else {
            effects().codebitShow(this, resolveActivity(viewGroup));
            ((AdapterHostedSplashSession) getSession()).show(viewGroup);
        }
    }

    /* JADX INFO: renamed from: lambda$onRenderFailure$0$com-tapsdk-tapad-group-ads-MediationSplashSession, reason: not valid java name */
    /* synthetic */ void m72lambda$onRenderFailure$0$comtapsdktapadgroupadsMediationSplashSession(int i, String str) {
        ((DirichletAdNative.SplashAutoAdListener) this.interactionListener).onError(i, str);
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onClick(View view) {
        if (this.didNotifyClick.compareAndSet(false, true)) {
            super.onClick(view);
            final DirichletSplashAd.AdInteractionListener adInteractionListener = this.interactionListener;
            if (adInteractionListener != null) {
                Objects.requireNonNull(adInteractionListener);
                AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationSplashSession$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        adInteractionListener.onAdClick();
                    }
                });
            }
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onClose() {
        if (this.didNotifyClose.compareAndSet(false, true)) {
            super.onClose();
            DirichletSplashAd.AdInteractionListener adInteractionListener = this.interactionListener;
            if (adInteractionListener != null) {
                if (this.renderFailedBeforeShow && (adInteractionListener instanceof DirichletAdNative.SplashAutoAdListener)) {
                    return;
                }
                Objects.requireNonNull(adInteractionListener);
                AdapterAdCandidate.dispatchCallback(new MediationSplashSession$$ExternalSyntheticLambda0(adInteractionListener));
            }
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onRenderFailure(View view, final int i, final String str) {
        this.renderFailedBeforeShow = !this.hasShown;
        super.onRenderFailure(view, i, str);
        if (this.renderFailedBeforeShow && (this.interactionListener instanceof DirichletAdNative.SplashAutoAdListener)) {
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationSplashSession$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m72lambda$onRenderFailure$0$comtapsdktapadgroupadsMediationSplashSession(i, str);
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onShow(View view) {
        if (this.didNotifyShow.compareAndSet(false, true)) {
            this.hasShown = true;
            super.onShow(view);
            final DirichletSplashAd.AdInteractionListener adInteractionListener = this.interactionListener;
            if (adInteractionListener != null) {
                Objects.requireNonNull(adInteractionListener);
                AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationSplashSession$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        adInteractionListener.onAdShow();
                    }
                });
            }
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onTimeOver() {
        if (this.didNotifyClose.compareAndSet(false, true)) {
            super.onTimeOver();
            DirichletSplashAd.AdInteractionListener adInteractionListener = this.interactionListener;
            if (adInteractionListener != null) {
                Objects.requireNonNull(adInteractionListener);
                AdapterAdCandidate.dispatchCallback(new MediationSplashSession$$ExternalSyntheticLambda0(adInteractionListener));
            }
        }
    }

    public void setSplashInteractionListener(DirichletSplashAd.AdInteractionListener adInteractionListener) {
        this.interactionListener = adInteractionListener;
    }

    public void show(ViewGroup viewGroup) {
        if (MediationShowAdmissionBridge.claimInline(this, 3, viewGroup, isValid())) {
            effects().spaceShow(this, resolveActivity(viewGroup));
            innerShow(viewGroup);
        }
    }
}

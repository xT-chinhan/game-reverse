package com.tapsdk.tapad.group.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.group.AdNetworkType;
import com.tapsdk.tapad.group.adapter.AdapterBannerSession;
import com.tapsdk.tapad.group.adapter.AdapterViewSupport;
import com.tapsdk.tapad.group.views.DirichletAdView;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class MediationBannerSession extends AdapterAdCandidate<AdapterBannerSession> {
    private DirichletAdView dirichletBannerView;
    private DirichletBannerAd.BannerInteractionListener interactionListener;

    public MediationBannerSession(AdapterBannerSession adapterBannerSession) {
        super(adapterBannerSession);
    }

    private View getInternalBannerView() {
        View view = getSession().getView();
        effects().codebitGetView(this, view);
        return view;
    }

    public View getBannerView() {
        View internalBannerView = getInternalBannerView();
        effects().spaceGetView(this, internalBannerView);
        if (internalBannerView == null) {
            onRenderFailure(null, -1, "banner view 为空");
            return null;
        }
        if (!MediationShowAdmissionBridge.claimInline(this, 4, internalBannerView, isValid())) {
            return null;
        }
        Context context = internalBannerView.getContext();
        if (context == null) {
            return internalBannerView;
        }
        if (this.dirichletBannerView == null) {
            this.dirichletBannerView = new DirichletAdView(context);
            if (androidNetworkType() != AdNetworkType.AD_IQY) {
                this.dirichletBannerView.setAdContent(internalBannerView, MediationConstant.RIT_TYPE_BANNER, androidNetworkType());
            } else {
                int iAcceptedWidth = acceptedWidth();
                this.dirichletBannerView.setAdContent(internalBannerView, MediationConstant.RIT_TYPE_BANNER, androidNetworkType(), iAcceptedWidth < 0 ? AdapterViewSupport.screenWidthPx(context) : iAcceptedWidth, acceptedHeight());
            }
        }
        return this.dirichletBannerView;
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate
    public void onBeforeSessionDestroy() {
        DirichletAdView dirichletAdView = this.dirichletBannerView;
        if (dirichletAdView != null) {
            dirichletAdView.destroy();
            this.dirichletBannerView = null;
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onClick(View view) {
        super.onClick(view);
        final DirichletBannerAd.BannerInteractionListener bannerInteractionListener = this.interactionListener;
        if (bannerInteractionListener != null) {
            Objects.requireNonNull(bannerInteractionListener);
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationBannerSession$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    bannerInteractionListener.onAdClick();
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onClose() {
        super.onClose();
        final DirichletBannerAd.BannerInteractionListener bannerInteractionListener = this.interactionListener;
        if (bannerInteractionListener != null) {
            Objects.requireNonNull(bannerInteractionListener);
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationBannerSession$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    bannerInteractionListener.onAdClose();
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onShow(View view) {
        super.onShow(view);
        final DirichletBannerAd.BannerInteractionListener bannerInteractionListener = this.interactionListener;
        if (bannerInteractionListener != null) {
            Objects.requireNonNull(bannerInteractionListener);
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationBannerSession$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    bannerInteractionListener.onAdShow();
                }
            });
        }
    }

    public void setBannerInteractionListener(DirichletBannerAd.BannerInteractionListener bannerInteractionListener) {
        this.interactionListener = bannerInteractionListener;
    }

    public void show(Activity activity, int i, int i2) {
        if (MediationShowAdmissionBridge.claimFullscreen(this, 4, activity, isValid())) {
            effects().spaceShow(this, activity);
            effects().codebitShow(this, activity);
            if (getSession().show(activity, i, i2)) {
                return;
            }
            onRenderFailure(null, -1, "banner view 为空");
        }
    }
}

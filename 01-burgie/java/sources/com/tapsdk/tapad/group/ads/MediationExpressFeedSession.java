package com.tapsdk.tapad.group.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tapsdk.tapad.group.adapter.AdapterExpressFeedRenderOptions;
import com.tapsdk.tapad.group.adapter.AdapterExpressFeedSession;
import com.tapsdk.tapad.group.ads.feed.FeedOption;
import com.tapsdk.tapad.group.ads.feed.VideoOption;
import com.tapsdk.tapad.group.views.DirichletAdView;

/* JADX INFO: loaded from: classes2.dex */
final class MediationExpressFeedSession extends AdapterAdCandidate<AdapterExpressFeedSession> {
    private DirichletExpressFeedAd.ExpressRenderListener renderListener;

    public MediationExpressFeedSession(AdapterExpressFeedSession adapterExpressFeedSession) {
        super(adapterExpressFeedSession);
    }

    private static AdapterExpressFeedRenderOptions toAdapterOptions(FeedOption feedOption) {
        int i = feedOption == null ? -1 : feedOption.expressWidth;
        int i2 = feedOption == null ? -2 : feedOption.expressHeight;
        VideoOption videoOption = feedOption == null ? null : feedOption.videoOption;
        return new AdapterExpressFeedRenderOptions(i, i2, videoOption == null || videoOption.autoPlayPolicy == VideoOption.AutoPlayPolicy.ALWAYS);
    }

    /* JADX INFO: renamed from: lambda$onClick$2$com-tapsdk-tapad-group-ads-MediationExpressFeedSession, reason: not valid java name */
    /* synthetic */ void m50lambda$onClick$2$comtapsdktapadgroupadsMediationExpressFeedSession(View view) {
        this.renderListener.onAdClicked(view);
    }

    /* JADX INFO: renamed from: lambda$onClose$0$com-tapsdk-tapad-group-ads-MediationExpressFeedSession, reason: not valid java name */
    /* synthetic */ void m51lambda$onClose$0$comtapsdktapadgroupadsMediationExpressFeedSession() {
        this.renderListener.onAdClosed(null);
    }

    /* JADX INFO: renamed from: lambda$onRenderFailure$4$com-tapsdk-tapad-group-ads-MediationExpressFeedSession, reason: not valid java name */
    /* synthetic */ void m52lambda$onRenderFailure$4$comtapsdktapadgroupadsMediationExpressFeedSession(View view, int i, String str) {
        this.renderListener.onRenderFail(view, (DirichletExpressFeedAd) getOuterAd(), 200010, getAdnTrackId() + "," + i + "," + str);
    }

    /* JADX INFO: renamed from: lambda$onRenderSuccess$3$com-tapsdk-tapad-group-ads-MediationExpressFeedSession, reason: not valid java name */
    /* synthetic */ void m53lambda$onRenderSuccess$3$comtapsdktapadgroupadsMediationExpressFeedSession(View view) {
        if (view == null || view.getContext() == null) {
            this.renderListener.onRenderSuccess(view);
            return;
        }
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        DirichletAdView dirichletAdView = new DirichletAdView(view.getContext());
        dirichletAdView.setAdContent(view, "express_feed", androidNetworkType());
        this.renderListener.onRenderSuccess(dirichletAdView);
    }

    /* JADX INFO: renamed from: lambda$onShow$1$com-tapsdk-tapad-group-ads-MediationExpressFeedSession, reason: not valid java name */
    /* synthetic */ void m54lambda$onShow$1$comtapsdktapadgroupadsMediationExpressFeedSession(View view) {
        this.renderListener.onAdShow(view);
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onClick(final View view) {
        super.onClick(view);
        if (this.renderListener != null) {
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationExpressFeedSession$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m50lambda$onClick$2$comtapsdktapadgroupadsMediationExpressFeedSession(view);
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onClose() {
        super.onClose();
        if (this.renderListener != null) {
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationExpressFeedSession$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m51lambda$onClose$0$comtapsdktapadgroupadsMediationExpressFeedSession();
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onRenderFailure(final View view, final int i, final String str) {
        super.onRenderFailure(view, i, str);
        if (this.renderListener != null) {
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationExpressFeedSession$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m52lambda$onRenderFailure$4$comtapsdktapadgroupadsMediationExpressFeedSession(view, i, str);
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onRenderSuccess(final View view, float f, float f2) {
        super.onRenderSuccess(view, f, f2);
        if (this.renderListener != null) {
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationExpressFeedSession$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m53lambda$onRenderSuccess$3$comtapsdktapadgroupadsMediationExpressFeedSession(view);
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onShow(final View view) {
        super.onShow(view);
        if (this.renderListener != null) {
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationExpressFeedSession$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m54lambda$onShow$1$comtapsdktapadgroupadsMediationExpressFeedSession(view);
                }
            });
        }
    }

    public void render(FeedOption feedOption) {
        getSession().render(toAdapterOptions(feedOption));
    }

    public void setExpressRenderListener(DirichletExpressFeedAd.ExpressRenderListener expressRenderListener) {
        this.renderListener = expressRenderListener;
    }

    public void render(Activity activity, FeedOption feedOption) {
        getSession().render(activity, toAdapterOptions(feedOption));
    }
}

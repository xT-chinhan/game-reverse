package com.smartdigimkt.w;

import com.smartdigimkt.sdk.api.format.myoffer.SDMMyOfferBannerView;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements com.smartdigimkt.j1.a {
    final /* synthetic */ SDMMyOfferBannerView this$0;
    final /* synthetic */ boolean val$currentRefreshStatus;

    public n(SDMMyOfferBannerView sDMMyOfferBannerView, boolean z) {
        this.this$0 = sDMMyOfferBannerView;
        this.val$currentRefreshStatus = z;
    }

    @Override // com.smartdigimkt.j1.a
    public void onAdClick(com.smartdigimkt.j1.w wVar) {
        if (this.this$0.mInnerBannerListener != null) {
            this.this$0.mInnerBannerListener.onBannerClicked();
        }
    }

    @Override // com.smartdigimkt.j1.a
    public void onAdClosed() {
        if (this.this$0.mInnerBannerListener != null) {
            this.this$0.mInnerBannerListener.onBannerClose();
        }
    }

    @Override // com.smartdigimkt.j1.a
    public void onAdShow(com.smartdigimkt.j1.w wVar) {
        if (this.this$0.mInnerBannerListener != null) {
            this.this$0.mInnerBannerListener.onBannerShow(this.val$currentRefreshStatus);
        }
    }

    @Override // com.smartdigimkt.j1.a
    public void onDeeplinkCallback(boolean z) {
        if (this.this$0.mInnerBannerListener != null) {
            this.this$0.mInnerBannerListener.onDeeplinkCallback(z);
        }
    }

    @Override // com.smartdigimkt.j1.a
    public void onShowFailed(com.smartdigimkt.h0.g gVar) {
    }
}

package com.smartdigimkt.w;

import com.smartdigimkt.sdk.api.format.myoffer.SDMMyOfferInterstitialAd;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements com.smartdigimkt.j1.a, com.smartdigimkt.j1.g {
    final /* synthetic */ SDMMyOfferInterstitialAd this$0;

    public s(SDMMyOfferInterstitialAd sDMMyOfferInterstitialAd) {
        this.this$0 = sDMMyOfferInterstitialAd;
    }

    @Override // com.smartdigimkt.j1.a
    public void onAdClick(com.smartdigimkt.j1.w wVar) {
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdClick();
        }
    }

    @Override // com.smartdigimkt.j1.a
    public void onAdClosed() {
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdClose();
        }
    }

    @Override // com.smartdigimkt.j1.a
    public void onAdShow(com.smartdigimkt.j1.w wVar) {
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdShow();
        }
    }

    @Override // com.smartdigimkt.j1.a
    public void onDeeplinkCallback(boolean z) {
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onDeeplinkCallback(z);
        }
    }

    @Override // com.smartdigimkt.j1.g
    public void onRewarded() {
    }

    @Override // com.smartdigimkt.j1.a
    public void onShowFailed(com.smartdigimkt.h0.g gVar) {
        String str = gVar != null ? gVar.b : "";
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdShowFail(com.smartdigimkt.z3.b.a("20002", str));
        }
    }

    @Override // com.smartdigimkt.j1.g
    public void onVideoAdPlayEnd() {
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdVideoEnd();
        }
    }

    @Override // com.smartdigimkt.j1.g
    public void onVideoAdPlayStart() {
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdVideoStart();
        }
    }
}

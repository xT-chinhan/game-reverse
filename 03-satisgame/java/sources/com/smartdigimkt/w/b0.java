package com.smartdigimkt.w;

import com.smartdigimkt.sdk.api.format.myoffer.SDMMyOfferRewardedVideoAd;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements com.smartdigimkt.j1.a, com.smartdigimkt.j1.g {
    final /* synthetic */ SDMMyOfferRewardedVideoAd this$0;

    public b0(SDMMyOfferRewardedVideoAd sDMMyOfferRewardedVideoAd) {
        this.this$0 = sDMMyOfferRewardedVideoAd;
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
            this.this$0.mDevListener.onAdPlayStart();
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
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdReward();
        }
    }

    @Override // com.smartdigimkt.j1.a
    public void onShowFailed(com.smartdigimkt.h0.g gVar) {
        String str = gVar != null ? gVar.b : "";
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdPlayFailed(com.smartdigimkt.z3.b.a("20002", str));
        }
    }

    @Override // com.smartdigimkt.j1.g
    public void onVideoAdPlayEnd() {
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdPlayEnd();
        }
    }

    @Override // com.smartdigimkt.j1.g
    public void onVideoAdPlayStart() {
    }
}

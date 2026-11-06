package com.smartdigimkt.w;

import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.format.myoffer.SDMMyOfferRewardedVideoAd;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements com.smartdigimkt.t4.p {
    final /* synthetic */ SDMMyOfferRewardedVideoAd this$0;

    public z(SDMMyOfferRewardedVideoAd sDMMyOfferRewardedVideoAd) {
        this.this$0 = sDMMyOfferRewardedVideoAd;
    }

    @Override // com.smartdigimkt.t4.p
    public void onAdLoadFail(AdError adError) {
        com.smartdigimkt.h3.b activeAdLoadLatencyTrace = this.this$0.getActiveAdLoadLatencyTrace();
        this.this$0.markAdLoadInternalReady(activeAdLoadLatencyTrace);
        synchronized (((com.smartdigimkt.t4.s) this.this$0).M_LOCK) {
            this.this$0.isLoading = false;
        }
        com.smartdigimkt.q3.f.a().a(new y(this, activeAdLoadLatencyTrace, adError));
    }

    @Override // com.smartdigimkt.t4.p
    public void onAdLoaded(com.smartdigimkt.k1.d dVar) {
        com.smartdigimkt.h3.b activeAdLoadLatencyTrace = this.this$0.getActiveAdLoadLatencyTrace();
        this.this$0.markAdLoadInternalReady(activeAdLoadLatencyTrace);
        synchronized (((com.smartdigimkt.t4.s) this.this$0).M_LOCK) {
            this.this$0.isLoading = false;
            ((com.smartdigimkt.t4.s) this.this$0).mCacheAd = dVar;
        }
        com.smartdigimkt.q3.f.a().a(new x(this, activeAdLoadLatencyTrace));
    }
}

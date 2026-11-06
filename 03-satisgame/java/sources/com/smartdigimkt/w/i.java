package com.smartdigimkt.w;

import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.format.myoffer.SDMMyOfferBannerView;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Runnable {
    final /* synthetic */ SDMMyOfferBannerView this$0;
    final /* synthetic */ com.smartdigimkt.h3.b val$latencyTrace;
    final /* synthetic */ AdError val$paramError;

    public i(SDMMyOfferBannerView sDMMyOfferBannerView, com.smartdigimkt.h3.b bVar, AdError adError) {
        this.this$0 = sDMMyOfferBannerView;
        this.val$latencyTrace = bVar;
        this.val$paramError = adError;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.finishAdLoadLatency(this.val$latencyTrace, "failure", this.val$paramError);
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdLoadFail(this.val$paramError);
        }
    }
}

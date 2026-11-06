package com.smartdigimkt.w;

import com.smartdigimkt.sdk.api.format.myoffer.SDMMyOfferBannerView;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements Runnable {
    final /* synthetic */ SDMMyOfferBannerView this$0;
    final /* synthetic */ com.smartdigimkt.h3.b val$latencyTrace;

    public k(SDMMyOfferBannerView sDMMyOfferBannerView, com.smartdigimkt.h3.b bVar) {
        this.this$0 = sDMMyOfferBannerView;
        this.val$latencyTrace = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.finishAdLoadLatency(this.val$latencyTrace, "success", null);
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdLoaded();
        }
    }
}

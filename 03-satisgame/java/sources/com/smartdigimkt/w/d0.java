package com.smartdigimkt.w;

import com.smartdigimkt.sdk.api.format.myoffer.SDMMyOfferSplashAd;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements Runnable {
    final /* synthetic */ SDMMyOfferSplashAd this$0;
    final /* synthetic */ com.smartdigimkt.h3.b val$latencyTrace;

    public d0(SDMMyOfferSplashAd sDMMyOfferSplashAd, com.smartdigimkt.h3.b bVar) {
        this.this$0 = sDMMyOfferSplashAd;
        this.val$latencyTrace = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.finishAdLoadLatency(this.val$latencyTrace, "success", null);
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdLoaded(false);
        }
    }
}

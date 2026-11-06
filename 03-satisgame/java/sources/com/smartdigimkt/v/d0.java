package com.smartdigimkt.v;

import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.format.SDMSplashAd;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements Runnable {
    final /* synthetic */ SDMSplashAd this$0;
    final /* synthetic */ com.smartdigimkt.h3.b val$latencyTrace;
    final /* synthetic */ AdError val$loadingError;

    public d0(SDMSplashAd sDMSplashAd, com.smartdigimkt.h3.b bVar, AdError adError) {
        this.this$0 = sDMSplashAd;
        this.val$latencyTrace = bVar;
        this.val$loadingError = adError;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.finishAdLoadLatency(this.val$latencyTrace, "failure", this.val$loadingError);
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdLoadFail(this.val$loadingError);
        }
    }
}

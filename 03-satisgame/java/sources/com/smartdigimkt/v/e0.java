package com.smartdigimkt.v;

import com.smartdigimkt.sdk.api.format.SDMSplashAd;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 implements Runnable {
    final /* synthetic */ SDMSplashAd this$0;
    final /* synthetic */ com.smartdigimkt.h3.b val$latencyTrace;

    public e0(SDMSplashAd sDMSplashAd, com.smartdigimkt.h3.b bVar) {
        this.this$0 = sDMSplashAd;
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

package com.smartdigimkt.v;

import com.smartdigimkt.sdk.api.format.SDMSplashAd;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements Runnable {
    final /* synthetic */ i0 this$2;
    final /* synthetic */ com.smartdigimkt.h3.b val$callbackTrace;
    final /* synthetic */ boolean val$isTimeout;
    final /* synthetic */ String val$requestId;

    public f0(i0 i0Var, String str, com.smartdigimkt.h3.b bVar, boolean z) {
        this.this$2 = i0Var;
        this.val$requestId = str;
        this.val$callbackTrace = bVar;
        this.val$isTimeout = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        SDMSplashAd sDMSplashAd = this.this$2.this$1.this$0;
        sDMSplashAd.tryReportAdxFillTiming3000022(((com.smartdigimkt.t4.o) sDMSplashAd).mCacheAd, this.val$requestId, this.val$callbackTrace);
        this.this$2.this$1.this$0.finishAdLoadLatency(this.val$callbackTrace, this.val$isTimeout ? "timeout" : "success", null);
        if (this.this$2.this$1.this$0.mDevListener != null) {
            this.this$2.this$1.this$0.mDevListener.onAdLoaded(this.val$isTimeout);
        }
    }
}

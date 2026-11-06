package com.smartdigimkt.v;

import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 implements Runnable {
    final /* synthetic */ i0 this$2;
    final /* synthetic */ AdError val$adError;
    final /* synthetic */ com.smartdigimkt.h3.b val$callbackTrace;
    final /* synthetic */ String val$requestId;

    public g0(i0 i0Var, String str, com.smartdigimkt.h3.b bVar, AdError adError) {
        this.this$2 = i0Var;
        this.val$requestId = str;
        this.val$callbackTrace = bVar;
        this.val$adError = adError;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$2.this$1.this$0.tryReportAdxFillTiming3000022(null, this.val$requestId, this.val$callbackTrace);
        this.this$2.this$1.this$0.finishAdLoadLatency(this.val$callbackTrace, "failure", this.val$adError);
        if (this.this$2.this$1.this$0.mDevListener != null) {
            this.this$2.this$1.this$0.mDevListener.onAdLoadFail(this.val$adError);
        }
    }
}

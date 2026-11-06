package com.smartdigimkt.w;

import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements Runnable {
    final /* synthetic */ h0 this$2;
    final /* synthetic */ AdError val$adError;
    final /* synthetic */ com.smartdigimkt.h3.b val$callbackTrace;

    public f0(h0 h0Var, com.smartdigimkt.h3.b bVar, AdError adError) {
        this.this$2 = h0Var;
        this.val$callbackTrace = bVar;
        this.val$adError = adError;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$2.this$1.this$0.finishAdLoadLatency(this.val$callbackTrace, "failure", this.val$adError);
        if (this.this$2.this$1.this$0.mDevListener != null) {
            this.this$2.this$1.this$0.mDevListener.onAdLoadFail(this.val$adError);
        }
    }
}

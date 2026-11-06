package com.smartdigimkt.w;

import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements Runnable {
    final /* synthetic */ v this$1;
    final /* synthetic */ AdError val$adError;
    final /* synthetic */ com.smartdigimkt.h3.b val$latencyTrace;

    public u(v vVar, com.smartdigimkt.h3.b bVar, AdError adError) {
        this.this$1 = vVar;
        this.val$latencyTrace = bVar;
        this.val$adError = adError;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.this$0.finishAdLoadLatency(this.val$latencyTrace, "failure", this.val$adError);
        if (this.this$1.this$0.mDevListener != null) {
            this.this$1.this$0.mDevListener.onAdLoadFail(this.val$adError);
        }
    }
}

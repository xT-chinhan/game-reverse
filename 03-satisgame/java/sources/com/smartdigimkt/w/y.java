package com.smartdigimkt.w;

import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements Runnable {
    final /* synthetic */ z this$1;
    final /* synthetic */ AdError val$adError;
    final /* synthetic */ com.smartdigimkt.h3.b val$latencyTrace;

    public y(z zVar, com.smartdigimkt.h3.b bVar, AdError adError) {
        this.this$1 = zVar;
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

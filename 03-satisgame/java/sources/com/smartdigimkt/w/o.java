package com.smartdigimkt.w;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements Runnable {
    final /* synthetic */ q this$1;
    final /* synthetic */ com.smartdigimkt.h3.b val$latencyTrace;

    public o(q qVar, com.smartdigimkt.h3.b bVar) {
        this.this$1 = qVar;
        this.val$latencyTrace = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.this$0.finishAdLoadLatency(this.val$latencyTrace, "success", null);
        if (this.this$1.this$0.mDevListener != null) {
            this.this$1.this$0.mDevListener.onAdLoaded();
        }
    }
}

package com.smartdigimkt.w;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {
    final /* synthetic */ h this$1;
    final /* synthetic */ com.smartdigimkt.h3.b val$latencyTrace;

    public f(h hVar, com.smartdigimkt.h3.b bVar) {
        this.this$1 = hVar;
        this.val$latencyTrace = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.this$0.finishAdLoadLatency(this.val$latencyTrace, "success", null);
        if (this.this$1.this$0.mDevListener != null) {
            this.this$1.this$0.mDevListener.onAdLoaded();
        }
        this.this$1.this$0.controlShow();
    }
}

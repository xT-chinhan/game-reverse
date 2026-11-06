package com.smartdigimkt.w;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 implements Runnable {
    final /* synthetic */ h0 this$2;

    public g0(h0 h0Var) {
        this.this$2 = h0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        i0 i0Var = this.this$2.this$1;
        i0Var.this$0.finishAdLoadLatency(i0Var.val$latencyTrace, "timeout", null);
        if (this.this$2.this$1.this$0.mDevListener != null) {
            this.this$2.this$1.this$0.mDevListener.onAdLoadTimeout();
        }
    }
}

package com.smartdigimkt.v;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 implements Runnable {
    final /* synthetic */ i0 this$2;
    final /* synthetic */ String val$requestId;

    public h0(i0 i0Var, String str) {
        this.this$2 = i0Var;
        this.val$requestId = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        j0 j0Var = this.this$2.this$1;
        j0Var.this$0.tryReportAdxFillTiming3000022(null, this.val$requestId, j0Var.val$latencyTrace);
        j0 j0Var2 = this.this$2.this$1;
        j0Var2.this$0.finishAdLoadLatency(j0Var2.val$latencyTrace, "timeout", null);
        if (this.this$2.this$1.this$0.mDevListener != null) {
            this.this$2.this$1.this$0.mDevListener.onAdLoadTimeout();
        }
    }
}

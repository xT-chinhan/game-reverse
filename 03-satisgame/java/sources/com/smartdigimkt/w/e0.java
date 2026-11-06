package com.smartdigimkt.w;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 implements Runnable {
    final /* synthetic */ h0 this$2;
    final /* synthetic */ com.smartdigimkt.h3.b val$callbackTrace;
    final /* synthetic */ boolean val$isTimeout;

    public e0(h0 h0Var, boolean z, com.smartdigimkt.h3.b bVar) {
        this.this$2 = h0Var;
        this.val$isTimeout = z;
        this.val$callbackTrace = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$2.this$1.this$0.finishAdLoadLatency(this.val$callbackTrace, this.val$isTimeout ? "timeout" : "success", null);
        if (this.this$2.this$1.this$0.mDevListener != null) {
            this.this$2.this$1.this$0.mDevListener.onAdLoaded(this.val$isTimeout);
        }
    }
}

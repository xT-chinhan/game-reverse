package com.smartdigimkt.v;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {
    final /* synthetic */ h this$1;
    final /* synthetic */ com.smartdigimkt.h3.b val$latencyTrace;
    final /* synthetic */ com.smartdigimkt.e1.d val$loadedAd;

    public f(h hVar, com.smartdigimkt.e1.d dVar, com.smartdigimkt.h3.b bVar) {
        this.this$1 = hVar;
        this.val$loadedAd = dVar;
        this.val$latencyTrace = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.this$0.tryReportBannerFillTiming3000022(this.val$loadedAd, null, this.val$latencyTrace);
        this.this$1.this$0.finishAdLoadLatency(this.val$latencyTrace, "success", null);
        if (this.this$1.this$0.mDevListener != null) {
            this.this$1.this$0.mDevListener.onAdLoaded();
        }
        this.this$1.this$0.controlShow();
    }
}

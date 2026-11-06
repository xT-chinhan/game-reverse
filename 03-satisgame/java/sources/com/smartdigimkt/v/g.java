package com.smartdigimkt.v;

import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {
    final /* synthetic */ h this$1;
    final /* synthetic */ AdError val$adError;
    final /* synthetic */ boolean val$isRefreshLoad;
    final /* synthetic */ com.smartdigimkt.h3.b val$latencyTrace;

    public g(h hVar, com.smartdigimkt.h3.b bVar, AdError adError, boolean z) {
        this.this$1 = hVar;
        this.val$latencyTrace = bVar;
        this.val$adError = adError;
        this.val$isRefreshLoad = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.this$0.tryReportBannerFillTiming3000022(null, null, this.val$latencyTrace);
        this.this$1.this$0.finishAdLoadLatency(this.val$latencyTrace, "failure", this.val$adError);
        if (this.this$1.this$0.mDevListener == null || !this.this$1.this$0.canRenderBanner || this.val$isRefreshLoad) {
            return;
        }
        this.this$1.this$0.mDevListener.onAdLoadFail(this.val$adError);
    }
}

package com.smartdigimkt.v;

import com.smartdigimkt.sdk.api.format.SDMBannerView;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements Runnable {
    final /* synthetic */ SDMBannerView this$0;
    final /* synthetic */ com.smartdigimkt.h3.b val$latencyTrace;

    public k(SDMBannerView sDMBannerView, com.smartdigimkt.h3.b bVar) {
        this.this$0 = sDMBannerView;
        this.val$latencyTrace = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.finishAdLoadLatency(this.val$latencyTrace, "success", null);
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdLoaded();
        }
    }
}

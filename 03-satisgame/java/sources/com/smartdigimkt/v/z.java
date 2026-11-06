package com.smartdigimkt.v;

import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.format.SDMRewardedVideoAd;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements com.smartdigimkt.t4.p {
    final /* synthetic */ SDMRewardedVideoAd this$0;

    public z(SDMRewardedVideoAd sDMRewardedVideoAd) {
        this.this$0 = sDMRewardedVideoAd;
    }

    @Override // com.smartdigimkt.t4.p
    public void onAdLoadFail(AdError adError) {
        com.smartdigimkt.h3.b activeAdLoadLatencyTrace = this.this$0.getActiveAdLoadLatencyTrace();
        this.this$0.markAdLoadInternalReady(activeAdLoadLatencyTrace);
        this.this$0.printAdStatusLog("request_result", "fail", adError != null ? adError.getErrorInfo() : "", adError);
        synchronized (((com.smartdigimkt.t4.o) this.this$0).M_LOCK) {
            this.this$0.isLoading = false;
        }
        com.smartdigimkt.q3.f.a().a(new y(this, activeAdLoadLatencyTrace, adError));
    }

    @Override // com.smartdigimkt.t4.p
    public void onAdLoaded(com.smartdigimkt.e1.d dVar) {
        com.smartdigimkt.h3.b activeAdLoadLatencyTrace = this.this$0.getActiveAdLoadLatencyTrace();
        this.this$0.markAdLoadInternalReady(activeAdLoadLatencyTrace);
        synchronized (((com.smartdigimkt.t4.o) this.this$0).M_LOCK) {
            this.this$0.isLoading = false;
            ((com.smartdigimkt.t4.o) this.this$0).mCacheAd = dVar;
        }
        this.this$0.printAdStatusLog("request_result", "success", "");
        com.smartdigimkt.q3.f.a().a(new x(this, activeAdLoadLatencyTrace));
    }
}

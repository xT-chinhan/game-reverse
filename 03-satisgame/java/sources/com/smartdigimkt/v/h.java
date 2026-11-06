package com.smartdigimkt.v;

import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.format.SDMBannerView;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements com.smartdigimkt.t4.p {
    final /* synthetic */ SDMBannerView this$0;

    public h(SDMBannerView sDMBannerView) {
        this.this$0 = sDMBannerView;
    }

    @Override // com.smartdigimkt.t4.p
    public void onAdLoadFail(AdError adError) {
        com.smartdigimkt.h3.b bVar;
        boolean z;
        synchronized (this.this$0.M_LOCK) {
            bVar = this.this$0.activeAdLoadLatencyTrace;
            z = this.this$0.mIsRefresh;
            this.this$0.isLoading = false;
        }
        this.this$0.markAdLoadInternalReady(bVar);
        this.this$0.onAdStatus("request_result", "fail", adError);
        if (z) {
            this.this$0.tryReportBannerFillTiming3000022(null, null, bVar);
            this.this$0.finishAdLoadLatency(bVar, "failure", adError);
            return;
        }
        com.smartdigimkt.q3.f.a().a(new g(this, bVar, adError, z));
        if (this.this$0.mSdmAdLoadManager == null || !this.this$0.isInView() || this.this$0.mBannerRefreshTimer.e) {
            return;
        }
        this.this$0.mBannerRefreshTimer.b();
    }

    @Override // com.smartdigimkt.t4.p
    public void onAdLoaded(com.smartdigimkt.e1.d dVar) {
        com.smartdigimkt.h3.b bVar;
        boolean z;
        synchronized (this.this$0.M_LOCK) {
            bVar = this.this$0.activeAdLoadLatencyTrace;
            z = this.this$0.mIsRefresh;
            this.this$0.isLoading = false;
            if (dVar instanceof com.smartdigimkt.e1.a) {
                if (z) {
                    this.this$0.mRefreshCacheAd = (com.smartdigimkt.e1.a) dVar;
                } else {
                    this.this$0.mCacheAd = (com.smartdigimkt.e1.a) dVar;
                }
            }
            this.this$0.onAdStatus("request_result", "success");
        }
        this.this$0.markAdLoadInternalReady(bVar);
        this.this$0.isShowCall = true;
        if (!z) {
            com.smartdigimkt.q3.f.a().a(new f(this, dVar, bVar));
        } else {
            this.this$0.tryReportBannerFillTiming3000022(dVar, null, bVar);
            this.this$0.finishAdLoadLatency(bVar, "success", null);
        }
    }
}

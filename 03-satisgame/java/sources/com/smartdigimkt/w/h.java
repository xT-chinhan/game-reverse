package com.smartdigimkt.w;

import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.format.myoffer.SDMMyOfferBannerView;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements com.smartdigimkt.t4.p {
    final /* synthetic */ SDMMyOfferBannerView this$0;

    public h(SDMMyOfferBannerView sDMMyOfferBannerView) {
        this.this$0 = sDMMyOfferBannerView;
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
        if (z) {
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
    public void onAdLoaded(com.smartdigimkt.k1.d dVar) {
        com.smartdigimkt.h3.b bVar;
        boolean z;
        synchronized (this.this$0.M_LOCK) {
            bVar = this.this$0.activeAdLoadLatencyTrace;
            z = this.this$0.mIsRefresh;
            this.this$0.isLoading = false;
            if (dVar instanceof com.smartdigimkt.k1.a) {
                this.this$0.mCacheAd = (com.smartdigimkt.k1.a) dVar;
            }
        }
        this.this$0.markAdLoadInternalReady(bVar);
        this.this$0.isShowCall = true;
        if (z) {
            this.this$0.finishAdLoadLatency(bVar, "success", null);
        } else {
            com.smartdigimkt.q3.f.a().a(new f(this, bVar));
        }
    }
}

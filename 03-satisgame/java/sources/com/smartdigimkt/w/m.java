package com.smartdigimkt.w;

import com.smartdigimkt.sdk.api.format.myoffer.SDMMyOfferBannerView;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements Runnable {
    final /* synthetic */ SDMMyOfferBannerView this$0;
    final /* synthetic */ boolean val$currentRefreshStatus;

    public m(SDMMyOfferBannerView sDMMyOfferBannerView, boolean z) {
        this.this$0 = sDMMyOfferBannerView;
        this.val$currentRefreshStatus = z;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007e A[Catch: all -> 0x0090, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000f, B:8:0x0018, B:10:0x0021, B:31:0x0087, B:11:0x0033, B:13:0x003b, B:17:0x0045, B:28:0x0076, B:30:0x007e, B:20:0x004d, B:22:0x0055, B:24:0x005d, B:26:0x006e, B:33:0x0089, B:34:0x008e), top: B:39:0x0007 }] */
    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.this$0.mSdmAdLoadManager) {
            if (!this.this$0.canRenderBanner) {
                String unused = this.this$0.TAG;
                return;
            }
            com.smartdigimkt.k1.a bannerCache = this.this$0.getBannerCache();
            boolean z = true;
            if (bannerCache != null) {
                if (this.this$0.isInView()) {
                    this.this$0.canRenderBanner = false;
                    com.smartdigimkt.q3.f.a().a(new l(this, bannerCache));
                } else {
                    if (!this.this$0.hasTouchWindow || !this.this$0.isShown()) {
                        z = false;
                    }
                    String unused2 = this.this$0.TAG;
                    if (z) {
                        if (this.this$0.mBannerRefreshTimer != null) {
                            this.this$0.mBannerRefreshTimer.b();
                        }
                    }
                }
            } else if (this.this$0.isRefreshOpen() && this.this$0.mSdmAdLoadManager != null) {
                SDMMyOfferBannerView sDMMyOfferBannerView = this.this$0;
                sDMMyOfferBannerView.load(1, sDMMyOfferBannerView.mLastSdmAdRequest);
                if (this.this$0.hasTouchWindow && this.this$0.isShown()) {
                    if (this.this$0.mBannerRefreshTimer != null) {
                        this.this$0.mBannerRefreshTimer.b();
                    }
                }
            }
        }
    }
}

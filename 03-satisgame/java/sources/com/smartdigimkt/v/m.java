package com.smartdigimkt.v;

import com.smartdigimkt.sdk.api.format.SDMBannerView;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements Runnable {
    final /* synthetic */ SDMBannerView this$0;
    final /* synthetic */ boolean val$currentRefreshStatus;

    public m(SDMBannerView sDMBannerView, boolean z) {
        this.this$0 = sDMBannerView;
        this.val$currentRefreshStatus = z;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0087 A[Catch: all -> 0x0099, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000f, B:8:0x0018, B:10:0x0021, B:13:0x002a, B:15:0x0032, B:19:0x003c, B:31:0x007f, B:33:0x0087, B:34:0x0090, B:22:0x0044, B:23:0x0056, B:25:0x005e, B:27:0x0066, B:29:0x0077, B:36:0x0092, B:37:0x0097), top: B:42:0x0007 }] */
    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.this$0.mSdmAdLoadManager) {
            if (!this.this$0.canRenderBanner) {
                String unused = this.this$0.TAG;
                return;
            }
            com.smartdigimkt.e1.a bannerCache = this.this$0.getBannerCache();
            boolean z = true;
            if (bannerCache != null) {
                if (bannerCache != this.this$0.mRefreshCacheAd || this.this$0.isInView()) {
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
                SDMBannerView sDMBannerView = this.this$0;
                sDMBannerView.load(1, sDMBannerView.mLastSdmAdRequest);
                if (this.this$0.hasTouchWindow && this.this$0.isShown()) {
                    if (this.this$0.mBannerRefreshTimer != null) {
                        this.this$0.mBannerRefreshTimer.b();
                    }
                }
            }
        }
    }
}

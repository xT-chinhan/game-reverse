package com.smartdigimkt.w;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {
    final /* synthetic */ m this$1;
    final /* synthetic */ com.smartdigimkt.k1.a val$adCacheInfo;

    public l(m mVar, com.smartdigimkt.k1.a aVar) {
        this.this$1 = mVar;
        this.val$adCacheInfo = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar = this.this$1;
        mVar.this$0.renderBannerView(this.val$adCacheInfo, mVar.val$currentRefreshStatus);
    }
}

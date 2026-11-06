package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.IQyRewardVideoAd;

/* JADX INFO: loaded from: classes2.dex */
public final class lg implements Runnable {
    public final /* synthetic */ IQyRewardVideoAd a;
    public final /* synthetic */ ng b;

    public lg(ng ngVar, IQyRewardVideoAd iQyRewardVideoAd) {
        this.b = ngVar;
        this.a = iQyRewardVideoAd;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.onRewardVideoAdLoad(this.a);
    }
}

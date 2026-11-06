package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.IQyBanner;

/* JADX INFO: loaded from: classes2.dex */
public final class xd implements Runnable {
    public final /* synthetic */ IQyBanner a;
    public final /* synthetic */ yd b;

    public xd(yd ydVar, IQyBanner iQyBanner) {
        this.b = ydVar;
        this.a = iQyBanner;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.onBannerAdLoad(this.a);
    }
}

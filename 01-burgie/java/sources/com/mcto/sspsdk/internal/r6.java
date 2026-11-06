package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.IQyFullScreenAd;

/* JADX INFO: loaded from: classes2.dex */
public final class r6 implements Runnable {
    public final /* synthetic */ IQyFullScreenAd a;
    public final /* synthetic */ t6 b;

    public r6(t6 t6Var, IQyFullScreenAd iQyFullScreenAd) {
        this.b = t6Var;
        this.a = iQyFullScreenAd;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.onFullScreenAdLoad(this.a);
    }
}

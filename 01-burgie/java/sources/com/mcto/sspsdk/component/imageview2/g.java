package com.mcto.sspsdk.component.imageview2;

import com.mcto.sspsdk.internal.ej;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ QYImageView2 b;

    public g(QYImageView2 qYImageView2, int i) {
        this.b = qYImageView2;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((ej) this.b.l).a(Integer.valueOf(this.a));
    }
}

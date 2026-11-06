package com.smartdigimkt.n1;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ r b;

    public p(r rVar, Bitmap bitmap) {
        this.b = rVar;
        this.a = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r rVar = this.b;
        rVar.b.setBitmapAndResize(this.a, rVar.a.getWidth(), this.b.a.getHeight());
        this.b.b.setVisibility(0);
    }
}

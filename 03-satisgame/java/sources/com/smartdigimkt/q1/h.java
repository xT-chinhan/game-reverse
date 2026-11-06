package com.smartdigimkt.q1;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ j b;

    public h(j jVar, Bitmap bitmap) {
        this.b = jVar;
        this.a = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.setBitmapAndResize(this.a, this.b.b.getWidth(), this.b.b.getHeight());
    }
}

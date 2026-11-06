package com.smartdigimkt.n1;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ y b;

    public w(y yVar, Bitmap bitmap) {
        this.b = yVar;
        this.a = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        y yVar = this.b;
        yVar.b.setBitmapAndResize(this.a, yVar.a.getWidth(), this.b.a.getHeight());
        this.b.b.setVisibility(0);
    }
}

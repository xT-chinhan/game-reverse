package com.smartdigimkt.i3;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ l b;
    public final /* synthetic */ String c;

    public g(Bitmap bitmap, l lVar, String str) {
        this.a = bitmap;
        this.b = lVar;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap bitmap = this.a;
        if (bitmap != null) {
            this.b.a(this.c, bitmap);
        } else {
            this.b.a();
        }
    }
}

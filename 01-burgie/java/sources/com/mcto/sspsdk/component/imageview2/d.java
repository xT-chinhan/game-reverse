package com.mcto.sspsdk.component.imageview2;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ QYImageView2 b;

    public d(QYImageView2 qYImageView2, Bitmap bitmap) {
        this.b = qYImageView2;
        this.a = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.setImageBitmap(this.a);
        this.b.a();
        QYImageView2.b(this.b, 1);
    }
}

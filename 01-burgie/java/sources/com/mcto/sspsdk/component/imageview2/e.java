package com.mcto.sspsdk.component.imageview2;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Runnable {
    public final /* synthetic */ Drawable a;
    public final /* synthetic */ QYImageView2 b;

    public e(QYImageView2 qYImageView2, Drawable drawable) {
        this.b = qYImageView2;
        this.a = drawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b();
        this.b.setImageDrawable(this.a);
        Drawable drawable = this.a;
        if (drawable instanceof AnimatedImageDrawable) {
            ((AnimatedImageDrawable) drawable).start();
        }
        int intrinsicWidth = this.a.getIntrinsicWidth();
        int intrinsicHeight = this.a.getIntrinsicHeight();
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            this.b.r = intrinsicWidth / intrinsicHeight;
        }
        this.b.a();
        QYImageView2.b(this.b, 1);
    }
}

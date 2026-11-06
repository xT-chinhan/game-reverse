package com.mcto.sspsdk.component.imageview2;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {
    public final /* synthetic */ Drawable a;
    public final /* synthetic */ c b;

    public b(c cVar, Drawable drawable) {
        this.b = cVar;
        this.a = drawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar = this.b;
        if (cVar.a.equals(cVar.d.m)) {
            this.b.d.b();
            this.b.d.setImageDrawable(this.a);
            Drawable drawable = this.a;
            if (drawable instanceof AnimatedImageDrawable) {
                ((AnimatedImageDrawable) drawable).start();
            }
            int intrinsicWidth = this.a.getIntrinsicWidth();
            int intrinsicHeight = this.a.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                this.b.d.r = intrinsicWidth / intrinsicHeight;
            }
            this.b.d.a();
            QYImageView2.b(this.b.d, 1);
        }
    }
}

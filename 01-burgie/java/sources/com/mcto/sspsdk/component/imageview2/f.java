package com.mcto.sspsdk.component.imageview2;

import android.graphics.Movie;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Movie b;
    public final /* synthetic */ QYImageView2 c;

    public f(Movie movie, QYImageView2 qYImageView2, String str) {
        this.c = qYImageView2;
        this.a = str;
        this.b = movie;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.equals(this.c.m)) {
            this.c.b();
            this.c.setImageDrawable(null);
            this.c.n = this.b;
            this.c.o = 0L;
            this.c.p = this.b.duration();
            if (this.c.p <= 0) {
                this.c.p = 1000;
            }
            int iWidth = this.b.width();
            int iHeight = this.b.height();
            if (iWidth > 0 && iHeight > 0) {
                this.c.r = iWidth / iHeight;
            }
            this.c.a();
            QYImageView2.b(this.c, 1);
            this.c.invalidate();
        }
    }
}

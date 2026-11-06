package com.mcto.sspsdk.internal;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: loaded from: classes2.dex */
public final class hc implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ ic b;

    public hc(ic icVar, Bitmap bitmap) {
        this.b = icVar;
        this.a = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a != null) {
            this.b.a.a = new BitmapDrawable(this.b.a.getResources(), this.a);
        }
        jc jcVar = this.b.a;
        int i = jc.c;
        jcVar.a();
        this.b.a.setVisibility(0);
    }
}

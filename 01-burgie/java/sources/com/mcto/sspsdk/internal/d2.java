package com.mcto.sspsdk.internal;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public final class d2 implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ j2 b;

    public d2(j2 j2Var, Bitmap bitmap) {
        this.b = j2Var;
        this.a = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j2 j2Var = this.b;
        q2 q2Var = j2Var.t;
        Bitmap bitmap = this.a;
        q2Var.d = bitmap;
        if (bitmap != null) {
            j2Var.c.setImageBitmap(bitmap);
        }
    }
}

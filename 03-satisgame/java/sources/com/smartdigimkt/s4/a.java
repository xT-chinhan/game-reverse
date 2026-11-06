package com.smartdigimkt.s4;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ b b;

    public a(b bVar, Bitmap bitmap) {
        this.b = bVar;
        this.a = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar = this.b.c;
        if (cVar != null) {
            Bitmap bitmap = this.a;
            if (bitmap != null) {
                cVar.a(bitmap);
            } else {
                cVar.a();
            }
        }
    }
}

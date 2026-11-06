package com.smartdigimkt.s4;

import android.content.Context;
import android.graphics.Bitmap;
import com.smartdigimkt.q3.f;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ c c;

    public b(Context context, Bitmap bitmap, c cVar) {
        this.a = context;
        this.b = bitmap;
        this.c = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a().a(new a(this, d.a(this.a, this.b)));
    }
}

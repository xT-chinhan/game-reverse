package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import com.smartdigimkt.sdk.basead.ui.SimpleMediaATView;

/* JADX INFO: loaded from: classes3.dex */
public final class c5 implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ d5 b;

    public c5(d5 d5Var, Bitmap bitmap) {
        this.b = d5Var;
        this.a = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SimpleMediaATView simpleMediaATView = this.b.b;
        Bitmap bitmap = this.a;
        simpleMediaATView.f = bitmap;
        simpleMediaATView.a(bitmap);
        this.b.b.d.setImageBitmap(this.a);
        this.b.b.d.setVisibility(0);
        com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.s4.b(this.b.b.getContext(), this.a, new b5(this)));
    }
}

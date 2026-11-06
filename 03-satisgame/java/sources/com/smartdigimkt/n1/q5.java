package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import com.smartdigimkt.sdk.basead.ui.WrapRoundImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class q5 implements Runnable {
    public final /* synthetic */ WrapRoundImageView a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ s5 c;

    public q5(s5 s5Var, WrapRoundImageView wrapRoundImageView, Bitmap bitmap) {
        this.c = s5Var;
        this.a = wrapRoundImageView;
        this.b = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.setBitmapAndResize(this.b, this.c.a.getWidth(), this.c.a.getHeight());
    }
}

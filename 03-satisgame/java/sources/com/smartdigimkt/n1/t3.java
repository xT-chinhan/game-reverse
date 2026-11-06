package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class t3 implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ v3 b;

    public t3(v3 v3Var, Bitmap bitmap) {
        this.b = v3Var;
        this.a = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int width = this.b.a.getWidth();
        int height = this.b.a.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        int[] iArrA = com.smartdigimkt.o3.d.a(width, height, this.a.getWidth() / this.a.getHeight());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.a.o.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = iArrA[0];
            layoutParams.height = iArrA[1];
            layoutParams.addRule(13);
            this.b.a.o.setLayoutParams(layoutParams);
        }
    }
}

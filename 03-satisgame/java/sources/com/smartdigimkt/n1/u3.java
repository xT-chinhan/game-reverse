package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class u3 implements com.smartdigimkt.s4.c {
    public final /* synthetic */ v3 a;

    public u3(v3 v3Var) {
        this.a = v3Var;
    }

    @Override // com.smartdigimkt.s4.c
    public final void a() {
    }

    @Override // com.smartdigimkt.s4.c
    public final void a(Bitmap bitmap) {
        this.a.a.n.setVisibility(0);
        this.a.a.n.setScaleType(ImageView.ScaleType.FIT_XY);
        this.a.a.n.setImageBitmap(bitmap);
    }
}

package com.smartdigimkt.i2;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements com.smartdigimkt.i3.l {
    public final /* synthetic */ j a;

    public i(j jVar) {
        this.a = jVar;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.a.b.g)) {
            this.a.e.setScaleType(ImageView.ScaleType.FIT_XY);
            this.a.e.setImageBitmap(bitmap);
            j jVar = this.a;
            if (jVar.m) {
                jVar.n = 0;
            } else {
                jVar.e.setVisibility(0);
            }
            this.a.e.post(new h(this));
        }
    }
}

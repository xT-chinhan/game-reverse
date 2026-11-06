package com.smartdigimkt.y1;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ ImageView a;

    public k0(ImageView imageView) {
        this.a = imageView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}

package com.smartdigimkt.c2;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.smartdigimkt.i3.l;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements l {
    public final /* synthetic */ ImageView a;

    public b(ImageView imageView) {
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

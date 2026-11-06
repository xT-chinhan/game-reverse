package com.smartdigimkt.e0;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.smartdigimkt.i3.l;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements l {
    public final /* synthetic */ Context a;
    public final /* synthetic */ g b;

    public b(g gVar, Context context) {
        this.b = gVar;
        this.a = context;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        ImageView imageView = this.b.b;
        if (imageView == null || this.a == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
    }
}

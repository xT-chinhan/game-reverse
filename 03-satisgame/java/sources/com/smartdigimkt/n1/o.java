package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.AsseblemCardSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements com.smartdigimkt.i3.l {
    public final /* synthetic */ AsseblemCardSplashATView a;

    public o(AsseblemCardSplashATView asseblemCardSplashATView) {
        this.a = asseblemCardSplashATView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        ImageView imageView = this.a.t0;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}

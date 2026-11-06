package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class r1 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ BaseSdkSplashATView a;

    public r1(BaseSdkSplashATView baseSdkSplashATView) {
        this.a = baseSdkSplashATView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.a.c.f)) {
            ImageView imageView = this.a.h0;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            this.a.g0.setImageBitmap(bitmap);
        }
    }
}

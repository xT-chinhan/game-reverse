package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import com.smartdigimkt.sdk.basead.ui.SplashEndCardView;

/* JADX INFO: loaded from: classes3.dex */
public final class b6 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ SplashEndCardView a;

    public b6(SplashEndCardView splashEndCardView) {
        this.a = splashEndCardView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (bitmap != null) {
            this.a.l.setImageBitmap(bitmap);
        }
    }
}

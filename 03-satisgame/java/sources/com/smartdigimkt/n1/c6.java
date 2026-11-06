package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.SplashEndCardView;

/* JADX INFO: loaded from: classes3.dex */
public final class c6 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ String a;
    public final /* synthetic */ SplashEndCardView b;

    public c6(SplashEndCardView splashEndCardView, String str) {
        this.b = splashEndCardView;
        this.a = str;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.a)) {
            this.b.f.setImageBitmap(bitmap);
        }
    }
}

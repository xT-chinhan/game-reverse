package com.smartdigimkt.e;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.china.formatbusiness.ui.LeftSkipSinglePictureSplashATView;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 implements com.smartdigimkt.i3.l {
    public final /* synthetic */ String a;
    public final /* synthetic */ RoundImageView b;
    public final /* synthetic */ int c;
    public final /* synthetic */ LeftSkipSinglePictureSplashATView d;

    public g0(int i, LeftSkipSinglePictureSplashATView leftSkipSinglePictureSplashATView, RoundImageView roundImageView, String str) {
        this.d = leftSkipSinglePictureSplashATView;
        this.a = str;
        this.b = roundImageView;
        this.c = i;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (!TextUtils.equals(str, this.a) || this.b == null) {
            return;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            LeftSkipSinglePictureSplashATView.a(this.c, this.d, this.b, this.a);
        } else {
            this.b.setImageBitmap(bitmap);
            LeftSkipSinglePictureSplashATView.a(this.b);
        }
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
        LeftSkipSinglePictureSplashATView.a(this.c, this.d, this.b, this.a);
    }
}

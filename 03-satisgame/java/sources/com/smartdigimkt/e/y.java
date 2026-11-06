package com.smartdigimkt.e;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.china.formatbusiness.ui.LeftSkipAsseblemSplashATView;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements com.smartdigimkt.i3.l {
    public final /* synthetic */ String a;
    public final /* synthetic */ RoundImageView b;
    public final /* synthetic */ int c;
    public final /* synthetic */ LeftSkipAsseblemSplashATView d;

    public y(int i, LeftSkipAsseblemSplashATView leftSkipAsseblemSplashATView, RoundImageView roundImageView, String str) {
        this.d = leftSkipAsseblemSplashATView;
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
            LeftSkipAsseblemSplashATView.a(this.c, this.d, this.b, this.a);
        } else {
            this.b.setImageBitmap(bitmap);
            LeftSkipAsseblemSplashATView.a(this.b);
        }
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
        LeftSkipAsseblemSplashATView.a(this.c, this.d, this.b, this.a);
    }
}

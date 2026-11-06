package com.smartdigimkt.e;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.china.formatbusiness.ui.LeftSkipAsseblemSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements com.smartdigimkt.i3.l {
    public final /* synthetic */ LeftSkipAsseblemSplashATView a;

    public w(LeftSkipAsseblemSplashATView leftSkipAsseblemSplashATView) {
        this.a = leftSkipAsseblemSplashATView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        LeftSkipAsseblemSplashATView leftSkipAsseblemSplashATView = this.a;
        int i = LeftSkipAsseblemSplashATView.t0;
        if (TextUtils.equals(str, leftSkipAsseblemSplashATView.c.e)) {
            this.a.o0.setImageBitmap(bitmap);
        }
    }
}

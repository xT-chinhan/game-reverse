package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.AsseblemSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements com.smartdigimkt.i3.l {
    public final /* synthetic */ AsseblemSplashATView a;

    public u(AsseblemSplashATView asseblemSplashATView) {
        this.a = asseblemSplashATView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.a.c.e)) {
            this.a.o0.setImageBitmap(bitmap);
        }
    }
}

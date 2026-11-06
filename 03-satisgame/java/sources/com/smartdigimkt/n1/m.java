package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.AsseblemCardSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements com.smartdigimkt.i3.l {
    public final /* synthetic */ AsseblemCardSplashATView a;

    public m(AsseblemCardSplashATView asseblemCardSplashATView) {
        this.a = asseblemCardSplashATView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.a.c.e)) {
            this.a.r0.setImageBitmap(bitmap);
        }
    }
}

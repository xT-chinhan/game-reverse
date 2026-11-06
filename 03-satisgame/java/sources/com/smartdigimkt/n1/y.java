package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.smartdigimkt.sdk.basead.ui.AsseblemSplashATView;
import com.smartdigimkt.sdk.basead.ui.WrapRoundImageView;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements com.smartdigimkt.i3.l {
    public final /* synthetic */ FrameLayout a;
    public final /* synthetic */ WrapRoundImageView b;
    public final /* synthetic */ RoundImageView c;
    public final /* synthetic */ AsseblemSplashATView d;

    public y(AsseblemSplashATView asseblemSplashATView, FrameLayout frameLayout, WrapRoundImageView wrapRoundImageView, RoundImageView roundImageView) {
        this.d = asseblemSplashATView;
        this.a = frameLayout;
        this.b = wrapRoundImageView;
        this.c = roundImageView;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.d.c.f)) {
            this.a.post(new w(this, bitmap));
            com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.s4.b(this.d.getContext(), bitmap, new x(this)));
        }
    }
}

package com.smartdigimkt.q1;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.animation.AlphaAnimation;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements com.smartdigimkt.i3.l {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ BaseAnimPlayerView c;

    public f(BaseAnimPlayerView baseAnimPlayerView, int i, int i2) {
        this.c = baseAnimPlayerView;
        this.a = i;
        this.b = i2;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        if (TextUtils.equals(str, this.c.w)) {
            this.c.y.setBitmapAndResize(bitmap, this.a, this.b);
            com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.s4.b(this.c.getContext(), bitmap, new e(this)));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setDuration(100L);
            this.c.y.startAnimation(alphaAnimation);
            this.c.x.startAnimation(alphaAnimation);
        }
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
        this.c.a(new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.l, com.anythink.core.common.inner.b.b.T));
    }
}

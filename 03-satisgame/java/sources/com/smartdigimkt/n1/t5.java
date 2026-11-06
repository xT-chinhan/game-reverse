package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.SinglePictureBottomSlideSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class t5 implements Runnable {
    public final /* synthetic */ SinglePictureBottomSlideSplashATView a;

    public t5(SinglePictureBottomSlideSplashATView singlePictureBottomSlideSplashATView) {
        this.a = singlePictureBottomSlideSplashATView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SinglePictureBottomSlideSplashATView singlePictureBottomSlideSplashATView = this.a;
        if (singlePictureBottomSlideSplashATView.L == null) {
            return;
        }
        int width = singlePictureBottomSlideSplashATView.getWidth();
        int height = this.a.getHeight();
        int i = (int) (((double) this.a.getResources().getDisplayMetrics().widthPixels) * 0.5d);
        int i2 = (int) (((double) this.a.getResources().getDisplayMetrics().heightPixels) * 0.5d);
        if (width < i) {
            this.a.a(new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.k, "Splash display width is less than 50% of screen width!"));
        } else if (height < i2) {
            this.a.a(new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.k, "Splash display height is less than 50% of screen height!"));
        } else {
            this.a.m();
        }
    }
}

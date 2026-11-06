package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.SinglePictureSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class y5 implements Runnable {
    public final /* synthetic */ SinglePictureSplashATView a;

    public y5(SinglePictureSplashATView singlePictureSplashATView) {
        this.a = singlePictureSplashATView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SinglePictureSplashATView singlePictureSplashATView = this.a;
        if (singlePictureSplashATView.L == null) {
            return;
        }
        int width = singlePictureSplashATView.getWidth();
        int height = this.a.getHeight();
        int i = (int) (((double) this.a.getResources().getDisplayMetrics().widthPixels) * 0.5d);
        int i2 = (int) (((double) this.a.getResources().getDisplayMetrics().heightPixels) * 0.5d);
        if (width < i) {
            this.a.a(new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.k, "Splash display width is less than 50% of screen width!"));
        } else {
            if (height < i2) {
                this.a.a(new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.k, "Splash display height is less than 50% of screen height!"));
                return;
            }
            SinglePictureSplashATView singlePictureSplashATView2 = this.a;
            int i3 = SinglePictureSplashATView.n0;
            singlePictureSplashATView2.m();
        }
    }
}

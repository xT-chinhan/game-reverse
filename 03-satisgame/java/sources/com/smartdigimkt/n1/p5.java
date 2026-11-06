package com.smartdigimkt.n1;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import com.smartdigimkt.sdk.basead.ui.SinglePictureBottomSlideSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class p5 implements Runnable {
    public final /* synthetic */ SinglePictureBottomSlideSplashATView a;

    public p5(SinglePictureBottomSlideSplashATView singlePictureBottomSlideSplashATView) {
        this.a = singlePictureBottomSlideSplashATView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            ObjectAnimator objectAnimator = this.a.u0;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
                this.a.u0.cancel();
            }
            ValueAnimator valueAnimator = this.a.v0;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.a.v0.cancel();
            }
        } catch (Throwable unused) {
        }
    }
}

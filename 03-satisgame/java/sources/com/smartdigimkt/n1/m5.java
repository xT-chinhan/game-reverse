package com.smartdigimkt.n1;

import android.animation.ValueAnimator;
import com.smartdigimkt.sdk.basead.ui.SinglePictureBottomSlideSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class m5 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ SinglePictureBottomSlideSplashATView a;

    public m5(SinglePictureBottomSlideSplashATView singlePictureBottomSlideSplashATView) {
        this.a = singlePictureBottomSlideSplashATView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        SinglePictureBottomSlideSplashATView singlePictureBottomSlideSplashATView = this.a;
        if (singlePictureBottomSlideSplashATView.p0 == null || iIntValue >= singlePictureBottomSlideSplashATView.t0.size()) {
            return;
        }
        SinglePictureBottomSlideSplashATView singlePictureBottomSlideSplashATView2 = this.a;
        singlePictureBottomSlideSplashATView2.p0.setImageResource(((Integer) singlePictureBottomSlideSplashATView2.t0.get(iIntValue)).intValue());
    }
}

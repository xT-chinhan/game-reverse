package com.smartdigimkt.n1;

import android.animation.ValueAnimator;
import android.view.View;
import com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView;
import com.smartdigimkt.sdk.basead.ui.SplashEndCardView;

/* JADX INFO: loaded from: classes3.dex */
public final class m1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ BaseSdkSplashATView b;

    public m1(BaseSdkSplashATView baseSdkSplashATView, View view) {
        this.b = baseSdkSplashATView;
        this.a = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        SplashEndCardView splashEndCardView = this.b.j0;
        if (splashEndCardView != null) {
            splashEndCardView.setAlpha(fFloatValue);
        }
        View view = this.a;
        if (view != null) {
            view.setAlpha((float) (1.0d - ((((double) fFloatValue) - 0.2d) * 1.25d)));
        }
    }
}

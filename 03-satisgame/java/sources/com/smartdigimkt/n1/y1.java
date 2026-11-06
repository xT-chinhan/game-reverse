package com.smartdigimkt.n1;

import android.animation.ValueAnimator;
import com.smartdigimkt.sdk.basead.ui.BaseShakeView;

/* JADX INFO: loaded from: classes3.dex */
public final class y1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BaseShakeView a;

    public y1(BaseShakeView baseShakeView) {
        this.a = baseShakeView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}

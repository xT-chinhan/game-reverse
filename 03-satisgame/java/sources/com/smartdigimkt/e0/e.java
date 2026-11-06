package com.smartdigimkt.e0;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ f a;

    public e(f fVar) {
        this.a = fVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        double dPow = Math.pow(((valueAnimator.getDuration() * 2) - valueAnimator.getCurrentPlayTime()) / (valueAnimator.getDuration() * 2.0f), 2.0d) * Math.sin(Math.toRadians(fFloatValue));
        f fVar = this.a;
        fVar.a.setTranslationY(-((float) (((double) fVar.b.i) * dPow)));
    }
}

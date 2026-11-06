package com.mcto.sspsdk.internal;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes2.dex */
public final class fe implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ge a;

    public fe(ge geVar) {
        this.a = geVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.e = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.a.postInvalidate();
    }
}

package com.smartdigimkt.p1;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ f a;

    public e(f fVar) {
        this.a = fVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view = this.a.a;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        f fVar = this.a;
        if (fVar.j == null && fVar.h == null) {
            return;
        }
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        f fVar2 = this.a;
        fVar2.o = (int) (((fVar2.p * 2) + fVar2.c + fVar2.n) * fFloatValue);
        fVar2.a.postInvalidate();
    }
}

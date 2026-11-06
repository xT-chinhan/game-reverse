package com.smartdigimkt.b2;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ d0 a;

    public b0(d0 d0Var) {
        this.a = d0Var;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.a.a.j != null) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            g0 g0Var = this.a.a;
            if (g0Var.i != null && g0Var.j.getParent() == null) {
                this.a.a.i.setAlpha(fFloatValue);
            }
            if (this.a.a.j.getParent() != null) {
                this.a.a.j.setAlpha(fFloatValue);
            }
        }
    }
}

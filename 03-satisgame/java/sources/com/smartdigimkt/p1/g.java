package com.smartdigimkt.p1;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ h a;

    public g(h hVar) {
        this.a = hVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.a.a;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.a.a.setScaleX(fFloatValue);
        this.a.a.setScaleY(fFloatValue);
    }
}

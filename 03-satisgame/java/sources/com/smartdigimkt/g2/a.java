package com.smartdigimkt.g2;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ b a;

    public a(b bVar) {
        this.a = bVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        try {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.a.a.setScaleX(fFloatValue);
            this.a.a.setScaleY(fFloatValue);
        } catch (Throwable unused) {
            this.a.a.setScaleX(3.0f);
            this.a.a.setScaleY(3.0f);
        }
    }
}

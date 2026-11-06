package com.mcto.sspsdk.internal;

import android.animation.ValueAnimator;
import com.mcto.sspsdk.component.interaction.QyRingView;

/* JADX INFO: loaded from: classes2.dex */
public final class de implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ QyRingView a;

    public de(QyRingView qyRingView) {
        this.a = qyRingView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}

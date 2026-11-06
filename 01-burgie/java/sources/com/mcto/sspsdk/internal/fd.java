package com.mcto.sspsdk.internal;

import android.animation.ValueAnimator;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public final class fd implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ gd a;

    public fd(gd gdVar) {
        this.a = gdVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.setLayoutParams(layoutParams);
    }
}

package com.smartdigimkt.w1;

import android.animation.ValueAnimator;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ h b;

    public f(h hVar, int i) {
        this.b = hVar;
        this.a = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        float f = -iIntValue;
        this.b.a.a.k.setTranslationY(f);
        this.b.a.a.c.setTranslationY(f);
        this.b.a.a.e.setTranslationY(f);
        this.b.a.a.h.setTranslationY(f);
        this.b.a.a.k.setTranslationY(f);
        float f2 = iIntValue;
        this.b.a.a.l.setTranslationY(f2);
        RelativeLayout relativeLayout = this.b.a.a.b;
        if (relativeLayout != null) {
            relativeLayout.setAlpha(((f2 * 1.0f) / this.a) * 0.8f);
        }
    }
}

package com.smartdigimkt.n1;

import android.animation.ValueAnimator;
import android.os.Looper;
import com.smartdigimkt.sdk.basead.ui.SpreadAnimLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class g6 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ SpreadAnimLayout a;

    public g6(SpreadAnimLayout spreadAnimLayout) {
        this.a = spreadAnimLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        SpreadAnimLayout spreadAnimLayout = this.a;
        h6 h6Var = spreadAnimLayout.c;
        h6Var.b = (int) ((1.0f - fFloatValue) * 255.0f);
        int i = (int) (spreadAnimLayout.f * fFloatValue);
        h6Var.a.set(spreadAnimLayout.d);
        float f = -i;
        this.a.c.a.inset(f, f);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            this.a.invalidate();
        } else {
            this.a.postInvalidate();
        }
    }
}

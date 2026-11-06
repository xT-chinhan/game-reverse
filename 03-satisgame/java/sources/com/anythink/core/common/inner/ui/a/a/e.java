package com.anythink.core.common.inner.ui.a.a;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class e extends a {
    private float e;

    public e(View view) {
        super(view);
        this.e = 0.95f;
    }

    @Override // com.anythink.core.common.inner.ui.a.a.a
    protected final ValueAnimator e() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, this.e);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.setRepeatMode(2);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.core.common.inner.ui.a.a.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (e.this.a == null || e.this.a.getVisibility() != 0) {
                    return;
                }
                e.this.a.setScaleX(fFloatValue);
                e.this.a.setScaleY(fFloatValue);
            }
        });
        return valueAnimatorOfFloat;
    }

    public final void g() {
        this.e = 0.85f;
    }
}

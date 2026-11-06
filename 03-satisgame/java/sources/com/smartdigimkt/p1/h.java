package com.smartdigimkt.p1;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends b {
    public float e;

    public h(View view) {
        super(view);
        this.e = 0.95f;
    }

    @Override // com.smartdigimkt.p1.b
    public final ValueAnimator b() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, this.e);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.setRepeatMode(2);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.addUpdateListener(new g(this));
        return valueAnimatorOfFloat;
    }
}

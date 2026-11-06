package com.smartdigimkt.p1;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends b {
    public i(View view) {
        super(view);
    }

    @Override // com.smartdigimkt.p1.b
    public final ValueAnimator b() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.a, "rotation", 0.0f, 4.0f, 0.0f, -4.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(1);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        return objectAnimatorOfFloat;
    }
}

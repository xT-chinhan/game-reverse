package com.anythink.basead.ui.a.a;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class f extends a {
    public f(View view) {
        super(view);
    }

    @Override // com.anythink.basead.ui.a.a.a
    protected final ValueAnimator e() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.a, "rotation", 0.0f, 4.0f, 0.0f, -4.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(1);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        return objectAnimatorOfFloat;
    }
}

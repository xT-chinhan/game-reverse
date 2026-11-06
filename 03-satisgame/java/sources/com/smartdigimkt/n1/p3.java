package com.smartdigimkt.n1;

import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

/* JADX INFO: loaded from: classes3.dex */
public final class p3 implements Runnable {
    public final /* synthetic */ r3 a;

    public p3(r3 r3Var) {
        this.a = r3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.b.setAlpha(1.0f);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -360.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            rotateAnimation.setRepeatCount(-1);
            this.a.b.startAnimation(rotateAnimation);
        } catch (Throwable unused) {
        }
    }
}

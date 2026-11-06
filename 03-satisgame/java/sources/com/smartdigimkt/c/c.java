package com.smartdigimkt.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.widget.ImageView;
import com.smartdigimkt.china.based.twist.TwistG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ TwistG2CV2View a;

    public c(TwistG2CV2View twistG2CV2View) {
        this.a = twistG2CV2View;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        try {
            ImageView imageView = this.a.i;
            if (imageView != null) {
                imageView.setRotation(0.0f);
                this.a.i.setRotationY(0.0f);
            }
            AnimatorSet animatorSet = this.a.k;
            if (animatorSet != null) {
                animatorSet.start();
            }
        } catch (Throwable unused) {
        }
    }
}

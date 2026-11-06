package com.byazt.nc;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 52, 1955})
public class ShakeButton extends Button {
    public ValueAnimator pr;

    public ShakeButton(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        pr();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.pr;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.pr.removeAllListeners();
            this.pr.removeAllUpdateListeners();
            this.pr = null;
        }
    }

    private void pr() {
        ValueAnimator valueAnimator = this.pr;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.pr.removeAllListeners();
            this.pr.removeAllUpdateListeners();
            this.pr = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.pr = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1300L);
        this.pr.setInterpolator(new LinearInterpolator());
        this.pr.setRepeatCount(-1);
        this.pr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.nc.ShakeButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float animatedFraction = valueAnimator2.getAnimatedFraction();
                ShakeButton.this.setRotation((float) (((double) ((1.0f - animatedFraction) * 6.0f)) * Math.cos(((double) (animatedFraction * 10.0f)) * 3.141592653589793d)));
            }
        });
        this.pr.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.nc.ShakeButton.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationEnd(animator);
                ShakeButton.this.setRotation(6.0f);
            }
        });
        this.pr.start();
    }
}

package com.byazt.mr;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 2207})
public class ShakeButton extends Button {
    public ValueAnimator n;

    public ShakeButton(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.n.removeAllListeners();
            this.n.removeAllUpdateListeners();
            this.n = null;
        }
    }

    private void n() {
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.n.removeAllListeners();
            this.n.removeAllUpdateListeners();
            this.n = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.n = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1300L);
        this.n.setInterpolator(new LinearInterpolator());
        this.n.setRepeatCount(-1);
        this.n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.mr.ShakeButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float animatedFraction = valueAnimator2.getAnimatedFraction();
                ShakeButton.this.setRotation((float) (((double) ((1.0f - animatedFraction) * 6.0f)) * Math.cos(((double) (animatedFraction * 10.0f)) * 3.141592653589793d)));
            }
        });
        this.n.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.mr.ShakeButton.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationEnd(animator);
                ShakeButton.this.setRotation(6.0f);
            }
        });
        this.n.start();
    }
}

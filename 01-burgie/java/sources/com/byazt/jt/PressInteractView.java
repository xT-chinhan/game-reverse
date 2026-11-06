package com.byazt.jt;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.ca.g;
import com.byazt.js.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 2231})
public class PressInteractView extends FrameLayout {
    public boolean c;
    public SplashDiffuseView hn;
    public ImageView hw;
    public Context pr;
    public TextView uc;
    public AnimatorSet x;

    public PressInteractView(Context context) {
        super(context);
        this.c = true;
        this.pr = context;
        this.x = new AnimatorSet();
        hn();
        x();
        post(new Runnable() { // from class: com.byazt.jt.PressInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                int iPr = (int) zo.pr(PressInteractView.this.pr, 50.0f);
                int iPr2 = (int) zo.pr(PressInteractView.this.pr, 50.0f);
                if (PressInteractView.this.hn.getMeasuredHeight() > 0) {
                    iPr = PressInteractView.this.hn.getMeasuredHeight();
                }
                if (PressInteractView.this.hn.getMeasuredWidth() > 0) {
                    iPr2 = PressInteractView.this.hn.getMeasuredWidth();
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressInteractView.this.hw.getLayoutParams();
                layoutParams.topMargin = ((int) ((iPr / 2.0f) - zo.pr(PressInteractView.this.getContext(), 5.0f))) + ((int) zo.pr(PressInteractView.this.pr, 40.0f));
                layoutParams.leftMargin = ((int) ((iPr2 / 2.0f) - zo.pr(PressInteractView.this.getContext(), 5.0f))) + ((int) zo.pr(PressInteractView.this.pr, 20.0f));
                layoutParams.bottomMargin = (int) (((-iPr) / 2.0f) + zo.pr(PressInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-iPr2) / 2.0f) + zo.pr(PressInteractView.this.getContext(), 5.0f));
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginStart(layoutParams.leftMargin);
                    layoutParams.setMarginEnd(layoutParams.rightMargin);
                }
                PressInteractView.this.hw.setLayoutParams(layoutParams);
            }
        });
    }

    private void hn() {
        this.hn = new SplashDiffuseView(this.pr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) zo.pr(this.pr, 50.0f), (int) zo.pr(this.pr, 50.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) zo.pr(this.pr, 40.0f);
        layoutParams.leftMargin = (int) zo.pr(this.pr, 20.0f);
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        addView(this.hn, layoutParams);
        this.hw = new ImageView(this.pr);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) zo.pr(this.pr, 78.0f), (int) zo.pr(this.pr, 78.0f));
        g.pr(this.pr, "tt_splash_hand", this.hw, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        addView(this.hw, layoutParams2);
        TextView textView = new TextView(this.pr);
        this.uc = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) zo.pr(this.pr, 10.0f);
        addView(this.uc, layoutParams3);
        this.uc.setVisibility(8);
    }

    private void x() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.hw, "scaleX", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(600L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.byazt.jt.PressInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(PressInteractView.this.hw, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                PressInteractView.this.hw.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressInteractView.this.c) {
                    PressInteractView.this.hn.pr();
                }
                PressInteractView pressInteractView = PressInteractView.this;
                pressInteractView.c = !pressInteractView.c;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.hw, "scaleY", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(600L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.x.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void setGuideText(String str) {
        this.uc.setVisibility(0);
        this.uc.setText(str);
    }

    public void setGuideTextColor(int i) {
        this.uc.setTextColor(i);
    }

    public void pr() {
        this.x.start();
    }

    public void hw() {
        AnimatorSet animatorSet = this.x;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        SplashDiffuseView splashDiffuseView = this.hn;
        if (splashDiffuseView != null) {
            splashDiffuseView.hw();
        }
        ImageView imageView = this.hw;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }
}

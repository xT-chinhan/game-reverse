package com.byazt.jt;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.ca.g;
import com.byazt.js.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 1623})
public class PressButtonInteractView extends FrameLayout {
    public boolean c;
    public SplashDiffuseView hn;
    public ImageView hw;
    public Context pr;
    public AnimatorSet x;

    public PressButtonInteractView(Context context) {
        super(context);
        this.c = true;
        this.pr = context;
        this.x = new AnimatorSet();
        hn();
        x();
        post(new Runnable() { // from class: com.byazt.jt.PressButtonInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressButtonInteractView.this.hw.getLayoutParams();
                layoutParams.topMargin = (int) ((PressButtonInteractView.this.hn.getMeasuredHeight() / 2.0f) - zo.pr(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.leftMargin = (int) ((PressButtonInteractView.this.hn.getMeasuredWidth() / 2.0f) - zo.pr(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.bottomMargin = (int) (((-PressButtonInteractView.this.hn.getMeasuredHeight()) / 2.0f) + zo.pr(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-PressButtonInteractView.this.hn.getMeasuredWidth()) / 2.0f) + zo.pr(PressButtonInteractView.this.getContext(), 5.0f));
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginStart(layoutParams.leftMargin);
                    layoutParams.setMarginEnd(layoutParams.rightMargin);
                }
                PressButtonInteractView.this.hw.setLayoutParams(layoutParams);
            }
        });
    }

    private void hn() {
        this.hn = new SplashDiffuseView(this.pr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) zo.pr(this.pr, 40.0f), (int) zo.pr(this.pr, 40.0f));
        layoutParams.gravity = 8388627;
        addView(this.hn, layoutParams);
        this.hw = new ImageView(this.pr);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) zo.pr(this.pr, 62.0f), (int) zo.pr(this.pr, 62.0f));
        layoutParams2.gravity = 16;
        g.pr(this.pr, "tt_splash_hand", this.hw, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        addView(this.hw, layoutParams2);
    }

    private void x() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.hw, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.byazt.jt.PressButtonInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(PressButtonInteractView.this.hw, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                objectAnimatorOfFloat2.start();
                PressButtonInteractView.this.hw.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressButtonInteractView.this.c) {
                    PressButtonInteractView.this.hn.pr();
                }
                PressButtonInteractView pressButtonInteractView = PressButtonInteractView.this;
                pressButtonInteractView.c = !pressButtonInteractView.c;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.hw, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(800L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.x.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
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

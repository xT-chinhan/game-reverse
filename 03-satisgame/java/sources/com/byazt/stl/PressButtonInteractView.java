package com.byazt.stl;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.cq.fs;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, TTAdConstant.STYLE_SIZE_RADIO_16_9})
public class PressButtonInteractView extends FrameLayout {
    public boolean l;
    public Context n;
    public AnimatorSet q;
    public ImageView qg;
    public SplashDiffuseView s;

    public PressButtonInteractView(Context context) {
        super(context);
        this.l = true;
        this.n = context;
        this.q = new AnimatorSet();
        s();
        q();
        post(new Runnable() { // from class: com.byazt.stl.PressButtonInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressButtonInteractView.this.qg.getLayoutParams();
                layoutParams.topMargin = (int) ((PressButtonInteractView.this.s.getMeasuredHeight() / 2.0f) - fs.n(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.leftMargin = (int) ((PressButtonInteractView.this.s.getMeasuredWidth() / 2.0f) - fs.n(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.bottomMargin = (int) (((-PressButtonInteractView.this.s.getMeasuredHeight()) / 2.0f) + fs.n(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-PressButtonInteractView.this.s.getMeasuredWidth()) / 2.0f) + fs.n(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                PressButtonInteractView.this.qg.setLayoutParams(layoutParams);
            }
        });
    }

    private void s() {
        this.s = new SplashDiffuseView(this.n);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) fs.n(this.n, 40.0f), (int) fs.n(this.n, 40.0f));
        layoutParams.gravity = 8388627;
        addView(this.s, layoutParams);
        this.qg = new ImageView(this.n);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) fs.n(this.n, 62.0f), (int) fs.n(this.n, 62.0f));
        layoutParams2.gravity = 16;
        sz.n(this.n, "tt_splash_hand", this.qg, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        addView(this.qg, layoutParams2);
    }

    private void q() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.qg, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.byazt.stl.PressButtonInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(PressButtonInteractView.this.qg, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                objectAnimatorOfFloat2.start();
                PressButtonInteractView.this.qg.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressButtonInteractView.this.l) {
                    PressButtonInteractView.this.s.n();
                }
                PressButtonInteractView pressButtonInteractView = PressButtonInteractView.this;
                pressButtonInteractView.l = !pressButtonInteractView.l;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.qg, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(800L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.q.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void n() {
        this.q.start();
    }

    public void qg() {
        AnimatorSet animatorSet = this.q;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        SplashDiffuseView splashDiffuseView = this.s;
        if (splashDiffuseView != null) {
            splashDiffuseView.qg();
        }
        ImageView imageView = this.qg;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }
}

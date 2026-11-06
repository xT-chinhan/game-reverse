package com.byazt.stl;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.cq.fs;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 2426})
public class PressInteractView extends FrameLayout {
    public boolean l;
    public Context n;
    public AnimatorSet q;
    public ImageView qg;
    public SplashDiffuseView s;
    public TextView w;

    public PressInteractView(Context context) {
        super(context);
        this.l = true;
        this.n = context;
        this.q = new AnimatorSet();
        s();
        q();
        post(new Runnable() { // from class: com.byazt.stl.PressInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                int iN = (int) fs.n(PressInteractView.this.n, 50.0f);
                int iN2 = (int) fs.n(PressInteractView.this.n, 50.0f);
                if (PressInteractView.this.s.getMeasuredHeight() > 0) {
                    iN = PressInteractView.this.s.getMeasuredHeight();
                }
                if (PressInteractView.this.s.getMeasuredWidth() > 0) {
                    iN2 = PressInteractView.this.s.getMeasuredWidth();
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressInteractView.this.qg.getLayoutParams();
                layoutParams.topMargin = ((int) ((iN / 2.0f) - fs.n(PressInteractView.this.getContext(), 5.0f))) + ((int) fs.n(PressInteractView.this.n, 40.0f));
                layoutParams.leftMargin = ((int) ((iN2 / 2.0f) - fs.n(PressInteractView.this.getContext(), 5.0f))) + ((int) fs.n(PressInteractView.this.n, 20.0f));
                layoutParams.bottomMargin = (int) (((-iN) / 2.0f) + fs.n(PressInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-iN2) / 2.0f) + fs.n(PressInteractView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                PressInteractView.this.qg.setLayoutParams(layoutParams);
            }
        });
    }

    private void s() {
        this.s = new SplashDiffuseView(this.n);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) fs.n(this.n, 50.0f), (int) fs.n(this.n, 50.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) fs.n(this.n, 40.0f);
        layoutParams.leftMargin = (int) fs.n(this.n, 20.0f);
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.s, layoutParams);
        this.qg = new ImageView(this.n);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) fs.n(this.n, 78.0f), (int) fs.n(this.n, 78.0f));
        sz.n(this.n, "tt_splash_hand", this.qg, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        addView(this.qg, layoutParams2);
        TextView textView = new TextView(this.n);
        this.w = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) fs.n(this.n, 10.0f);
        addView(this.w, layoutParams3);
        this.w.setVisibility(8);
    }

    private void q() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.qg, "scaleX", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(600L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.byazt.stl.PressInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(PressInteractView.this.qg, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                PressInteractView.this.qg.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressInteractView.this.l) {
                    PressInteractView.this.s.n();
                }
                PressInteractView pressInteractView = PressInteractView.this;
                pressInteractView.l = !pressInteractView.l;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.qg, "scaleY", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(600L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.q.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void setGuideText(String str) {
        this.w.setVisibility(0);
        this.w.setText(str);
    }

    public void setGuideTextColor(int i) {
        this.w.setTextColor(i);
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

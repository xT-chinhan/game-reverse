package com.byazt.jt;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.ca.g;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 2171})
public class BluePressInteractView extends FrameLayout {
    public int aj;
    public View c;
    public ImageView fw;
    public boolean hn;
    public ObjectAnimator hw;
    public AnimatorSet pr;
    public View uc;
    public Context vk;
    public View x;
    public int zo;

    public BluePressInteractView(Context context, int i, int i2) {
        super(context);
        this.hn = false;
        this.pr = new AnimatorSet();
        this.zo = i;
        this.aj = i2;
        this.vk = context;
        hn();
        x();
    }

    private void hn() {
        View view = new View(this.vk);
        this.x = view;
        view.setBackground(pr("#1A7BBEFF", "#337BBEFF"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (((double) this.zo) * 0.45d), (int) (((double) this.aj) * 0.45d));
        layoutParams.gravity = 17;
        this.x.setLayoutParams(layoutParams);
        addView(this.x);
        View view2 = new View(this.vk);
        this.c = view2;
        view2.setBackground(pr("#337BBEFF", "#807BBEFF"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (((double) this.zo) * 0.25d), (int) (((double) this.aj) * 0.25d));
        layoutParams2.gravity = 17;
        this.c.setLayoutParams(layoutParams2);
        addView(this.c);
        View view3 = new View(this.vk);
        this.uc = view3;
        view3.setBackground(pr("#807BBEFF", "#FF7BBEFF"));
        int i = this.zo;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (((double) i) * 0.25d), (int) (((double) i) * 0.25d));
        layoutParams3.gravity = 17;
        this.uc.setLayoutParams(layoutParams3);
        addView(this.uc);
        this.fw = new ImageView(this.vk);
        g.pr(getContext(), "tt_blue_hand", this.fw, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.fw.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams((int) (((double) this.zo) * 0.62d), (int) (((double) this.aj) * 0.53d));
        layoutParams4.gravity = 17;
        layoutParams4.topMargin = (layoutParams4.width / 2) - 5;
        layoutParams4.leftMargin = (layoutParams4.height / 2) - 5;
        this.fw.setLayoutParams(layoutParams4);
        addView(this.fw);
    }

    private void x() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.x, "scaleX", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.x, "scaleY", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.c, "scaleX", 1.0f, 2.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.c, "scaleY", 1.0f, 2.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.uc, "scaleX", 1.0f, 1.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.uc, "scaleY", 1.0f, 1.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.fw, "rotation", 0.0f, -20.0f, 0.0f);
        this.hw = objectAnimatorOfFloat7;
        objectAnimatorOfFloat7.setDuration(1000L);
        this.pr.setDuration(1500L);
        this.pr.setInterpolator(new AccelerateDecelerateInterpolator());
        this.pr.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat4).with(objectAnimatorOfFloat5).with(objectAnimatorOfFloat6);
        this.pr.addListener(new Animator.AnimatorListener() { // from class: com.byazt.jt.BluePressInteractView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!BluePressInteractView.this.hn) {
                    BluePressInteractView.this.hw.start();
                    BluePressInteractView.this.pr.start();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                BluePressInteractView.this.hn = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private GradientDrawable pr(String str, String str2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setStroke(1, Color.parseColor(str2));
        return gradientDrawable;
    }

    public void pr() {
        this.hn = false;
        ObjectAnimator objectAnimator = this.hw;
        if (objectAnimator != null && this.pr != null) {
            objectAnimator.start();
            this.pr.start();
        }
    }

    public void hw() {
        this.hn = true;
        ObjectAnimator objectAnimator = this.hw;
        if (objectAnimator != null && this.pr != null) {
            objectAnimator.cancel();
            this.pr.cancel();
        }
    }
}

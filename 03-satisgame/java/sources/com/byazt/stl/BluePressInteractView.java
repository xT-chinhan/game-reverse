package com.byazt.stl;

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
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 2382})
public class BluePressInteractView extends FrameLayout {
    public int fs;
    public View l;
    public AnimatorSet n;
    public View q;
    public ObjectAnimator qg;
    public int rv;
    public boolean s;
    public Context tj;
    public View w;
    public ImageView x;

    public BluePressInteractView(Context context, int i, int i2) {
        super(context);
        this.s = false;
        this.n = new AnimatorSet();
        this.fs = i;
        this.rv = i2;
        this.tj = context;
        s();
        q();
    }

    private void s() {
        View view = new View(this.tj);
        this.q = view;
        view.setBackground(n("#1A7BBEFF", "#337BBEFF"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (((double) this.fs) * 0.45d), (int) (((double) this.rv) * 0.45d));
        layoutParams.gravity = 17;
        this.q.setLayoutParams(layoutParams);
        addView(this.q);
        View view2 = new View(this.tj);
        this.l = view2;
        view2.setBackground(n("#337BBEFF", "#807BBEFF"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (((double) this.fs) * 0.25d), (int) (((double) this.rv) * 0.25d));
        layoutParams2.gravity = 17;
        this.l.setLayoutParams(layoutParams2);
        addView(this.l);
        View view3 = new View(this.tj);
        this.w = view3;
        view3.setBackground(n("#807BBEFF", "#FF7BBEFF"));
        int i = this.fs;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (((double) i) * 0.25d), (int) (((double) i) * 0.25d));
        layoutParams3.gravity = 17;
        this.w.setLayoutParams(layoutParams3);
        addView(this.w);
        this.x = new ImageView(this.tj);
        sz.n(getContext(), "tt_blue_hand", this.x, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.x.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams((int) (((double) this.fs) * 0.62d), (int) (((double) this.rv) * 0.53d));
        layoutParams4.gravity = 17;
        layoutParams4.topMargin = (layoutParams4.width / 2) - 5;
        layoutParams4.leftMargin = (layoutParams4.height / 2) - 5;
        this.x.setLayoutParams(layoutParams4);
        addView(this.x);
    }

    private void q() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.q, "scaleX", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.q, "scaleY", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.l, "scaleX", 1.0f, 2.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.l, "scaleY", 1.0f, 2.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.w, "scaleX", 1.0f, 1.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.w, "scaleY", 1.0f, 1.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.x, "rotation", 0.0f, -20.0f, 0.0f);
        this.qg = objectAnimatorOfFloat7;
        objectAnimatorOfFloat7.setDuration(1000L);
        this.n.setDuration(1500L);
        this.n.setInterpolator(new AccelerateDecelerateInterpolator());
        this.n.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat4).with(objectAnimatorOfFloat5).with(objectAnimatorOfFloat6);
        this.n.addListener(new Animator.AnimatorListener() { // from class: com.byazt.stl.BluePressInteractView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (BluePressInteractView.this.s) {
                    return;
                }
                BluePressInteractView.this.qg.start();
                BluePressInteractView.this.n.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                BluePressInteractView.this.s = true;
            }
        });
    }

    private GradientDrawable n(String str, String str2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setStroke(1, Color.parseColor(str2));
        return gradientDrawable;
    }

    public void n() {
        this.s = false;
        ObjectAnimator objectAnimator = this.qg;
        if (objectAnimator == null || this.n == null) {
            return;
        }
        objectAnimator.start();
        this.n.start();
    }

    public void qg() {
        this.s = true;
        ObjectAnimator objectAnimator = this.qg;
        if (objectAnimator == null || this.n == null) {
            return;
        }
        objectAnimator.cancel();
        this.n.cancel();
    }
}

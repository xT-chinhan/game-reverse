package com.byazt.stl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.cq.fs;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 2444})
public class SlideRightView extends FrameLayout {
    public AnimatorSet fs;
    public TextView l;
    public Context n;
    public ImageView q;
    public ImageView qg;
    public AnimatorSet rv;
    public ImageView s;
    public AnimatorSet w;
    public AnimatorSet x;

    public SlideRightView(Context context) {
        super(context);
        this.w = new AnimatorSet();
        this.x = new AnimatorSet();
        this.fs = new AnimatorSet();
        this.rv = new AnimatorSet();
        this.n = context;
        s();
    }

    private void s() {
        ImageView imageView = new ImageView(this.n);
        this.q = imageView;
        sz.n(this.n, "tt_splash_slide_right_bg", (View) imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -2);
        layoutParams.gravity = 48;
        layoutParams.leftMargin = (int) fs.n(this.n, 30.0f);
        addView(this.q, layoutParams);
        setClipChildren(false);
        setClipToPadding(false);
        ImageView imageView2 = new ImageView(this.n);
        this.s = imageView2;
        sz.n(this.n, "tt_splash_slide_right_circle", imageView2, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) fs.n(this.n, 50.0f), (int) fs.n(this.n, 50.0f));
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = (int) fs.n(this.n, 30.0f);
        addView(this.s, layoutParams2);
        ImageView imageView3 = new ImageView(this.n);
        this.qg = imageView3;
        sz.n(this.n, "tt_splash_hand2", imageView3, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) fs.n(this.n, 80.0f), (int) fs.n(this.n, 80.0f));
        layoutParams3.gravity = 48;
        layoutParams3.leftMargin = (int) fs.n(this.n, 30.0f);
        addView(this.qg, layoutParams3);
        TextView textView = new TextView(this.n);
        this.l = textView;
        textView.setTextColor(-1);
        this.l.setSingleLine();
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 80;
        addView(this.l, layoutParams4);
        post(new Runnable() { // from class: com.byazt.stl.SlideRightView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) SlideRightView.this.qg.getLayoutParams();
                layoutParams5.topMargin = (int) ((SlideRightView.this.s.getMeasuredHeight() / 2.0f) - fs.n(SlideRightView.this.getContext(), 7.0f));
                layoutParams5.leftMargin = (-SlideRightView.this.s.getMeasuredWidth()) + ((int) fs.n(SlideRightView.this.n, 30.0f));
                layoutParams5.setMarginStart(layoutParams5.leftMargin);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                SlideRightView.this.qg.setLayoutParams(layoutParams5);
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) SlideRightView.this.q.getLayoutParams();
                layoutParams6.topMargin = (int) ((SlideRightView.this.s.getMeasuredHeight() / 2.0f) - fs.n(SlideRightView.this.getContext(), 5.0f));
                layoutParams6.leftMargin = (int) ((SlideRightView.this.s.getMeasuredWidth() / 2.0f) + ((int) fs.n(SlideRightView.this.n, 30.0f)));
                layoutParams5.setMarginStart(layoutParams5.leftMargin);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                SlideRightView.this.q.setLayoutParams(layoutParams6);
            }
        });
    }

    private void q() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.qg, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.s, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.s, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.q, "alpha", 0.0f, 1.0f);
        this.fs.setDuration(300L);
        this.fs.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.qg, "translationX", 0.0f, fs.n(getContext(), 90.0f));
        objectAnimatorOfFloat5.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) fs.n(getContext(), 90.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.stl.SlideRightView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SlideRightView.this.q.getLayoutParams();
                layoutParams.width = num.intValue();
                SlideRightView.this.q.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.s, "translationX", 0.0f, fs.n(getContext(), 90.0f));
        objectAnimatorOfFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.rv.setDuration(1500L);
        this.rv.playTogether(objectAnimatorOfFloat5, valueAnimatorOfInt, objectAnimatorOfFloat6);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.qg, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.q, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.s, "alpha", 1.0f, 0.0f);
        this.x.setDuration(50L);
        this.x.playTogether(objectAnimatorOfFloat7, objectAnimatorOfFloat8, objectAnimatorOfFloat9);
        this.w.playSequentially(this.fs, this.rv, this.x);
    }

    public void n() {
        q();
        this.w.start();
        this.w.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.stl.SlideRightView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideRightView.this.postDelayed(new Runnable() { // from class: com.byazt.stl.SlideRightView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideRightView.this.w.start();
                    }
                }, 200L);
            }
        });
    }

    public void qg() {
        try {
            AnimatorSet animatorSet = this.w;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.fs;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.rv;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.x;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable unused) {
        }
    }

    public void setGuideText(String str) {
        this.l.setText(str);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }
}

package com.byazt.jt;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.ca.g;
import com.byazt.ce.x;
import com.byazt.js.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 2254})
public class SlideRightView extends FrameLayout {
    public AnimatorSet aj;
    public TextView c;
    public AnimatorSet fw;
    public ImageView hn;
    public ImageView hw;
    public Context pr;
    public AnimatorSet uc;
    public ImageView x;
    public AnimatorSet zo;

    public SlideRightView(Context context) {
        super(context);
        this.uc = new AnimatorSet();
        this.fw = new AnimatorSet();
        this.zo = new AnimatorSet();
        this.aj = new AnimatorSet();
        this.pr = context;
        hn();
    }

    private void hn() {
        ImageView imageView = new ImageView(this.pr);
        this.x = imageView;
        g.pr(this.pr, "tt_splash_slide_right_bg", (View) imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -2);
        layoutParams.gravity = 48;
        layoutParams.leftMargin = (int) zo.pr(this.pr, 30.0f);
        addView(this.x, layoutParams);
        setClipChildren(false);
        setClipToPadding(false);
        ImageView imageView2 = new ImageView(this.pr);
        this.hn = imageView2;
        g.pr(this.pr, "tt_splash_slide_right_circle", imageView2, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) zo.pr(this.pr, 50.0f), (int) zo.pr(this.pr, 50.0f));
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = (int) zo.pr(this.pr, 30.0f);
        addView(this.hn, layoutParams2);
        ImageView imageView3 = new ImageView(this.pr);
        this.hw = imageView3;
        g.pr(this.pr, "tt_splash_hand2", imageView3, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) zo.pr(this.pr, 80.0f), (int) zo.pr(this.pr, 80.0f));
        layoutParams3.gravity = 48;
        layoutParams3.leftMargin = (int) zo.pr(this.pr, 30.0f);
        addView(this.hw, layoutParams3);
        TextView textView = new TextView(this.pr);
        this.c = textView;
        textView.setTextColor(-1);
        this.c.setSingleLine();
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 80;
        addView(this.c, layoutParams4);
        post(new Runnable() { // from class: com.byazt.jt.SlideRightView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) SlideRightView.this.hw.getLayoutParams();
                layoutParams5.topMargin = (int) ((SlideRightView.this.hn.getMeasuredHeight() / 2.0f) - zo.pr(SlideRightView.this.getContext(), 7.0f));
                layoutParams5.leftMargin = (-SlideRightView.this.hn.getMeasuredWidth()) + ((int) zo.pr(SlideRightView.this.pr, 30.0f));
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams5.setMarginStart(layoutParams5.leftMargin);
                    layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                }
                SlideRightView.this.hw.setLayoutParams(layoutParams5);
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) SlideRightView.this.x.getLayoutParams();
                layoutParams6.topMargin = (int) ((SlideRightView.this.hn.getMeasuredHeight() / 2.0f) - zo.pr(SlideRightView.this.getContext(), 5.0f));
                layoutParams6.leftMargin = (int) ((SlideRightView.this.hn.getMeasuredWidth() / 2.0f) + ((int) zo.pr(SlideRightView.this.pr, 30.0f)));
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams5.setMarginStart(layoutParams5.leftMargin);
                    layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                }
                SlideRightView.this.x.setLayoutParams(layoutParams6);
            }
        });
    }

    private void x() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.hw, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.hn, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.hn, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.x, "alpha", 0.0f, 1.0f);
        this.zo.setDuration(300L);
        this.zo.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.hw, "translationX", 0.0f, zo.pr(getContext(), 90.0f));
        if (Build.VERSION.SDK_INT >= 21) {
            objectAnimatorOfFloat5.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        } else {
            objectAnimatorOfFloat5.setInterpolator(x.pr(0.2f, 0.0f, 0.3f, 1.0f));
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) zo.pr(getContext(), 90.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.jt.SlideRightView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SlideRightView.this.x.getLayoutParams();
                layoutParams.width = num.intValue();
                SlideRightView.this.x.setLayoutParams(layoutParams);
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        } else {
            valueAnimatorOfInt.setInterpolator(x.pr(0.2f, 0.0f, 0.3f, 1.0f));
        }
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.hn, "translationX", 0.0f, zo.pr(getContext(), 90.0f));
        if (Build.VERSION.SDK_INT >= 21) {
            objectAnimatorOfFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        } else {
            objectAnimatorOfFloat6.setInterpolator(x.pr(0.2f, 0.0f, 0.3f, 1.0f));
        }
        this.aj.setDuration(1500L);
        this.aj.playTogether(objectAnimatorOfFloat5, valueAnimatorOfInt, objectAnimatorOfFloat6);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.hw, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.x, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.hn, "alpha", 1.0f, 0.0f);
        this.fw.setDuration(50L);
        this.fw.playTogether(objectAnimatorOfFloat7, objectAnimatorOfFloat8, objectAnimatorOfFloat9);
        this.uc.playSequentially(this.zo, this.aj, this.fw);
    }

    public void pr() {
        x();
        this.uc.start();
        this.uc.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.jt.SlideRightView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideRightView.this.postDelayed(new Runnable() { // from class: com.byazt.jt.SlideRightView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideRightView.this.uc.start();
                    }
                }, 200L);
            }
        });
    }

    public void hw() {
        try {
            AnimatorSet animatorSet = this.uc;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.zo;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.aj;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.fw;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable th) {
        }
    }

    public void setGuideText(String str) {
        this.c.setText(str);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }
}

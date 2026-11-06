package com.byazt.jm;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.byazt.ca.g;
import com.byazt.ca.ho;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 1638})
public class SplashClickBarArrow extends FrameLayout {
    public RelativeLayout aj;
    public ImageView c;
    public ImageView fw;
    public ImageView hn;
    public RelativeLayout hw;
    public AnimatorSet k;
    public ImageView pr;
    public FrameLayout uc;
    public boolean vk;
    public int w;
    public ImageView x;
    public SplashDiffuseView zo;

    public SplashClickBarArrow(Context context) {
        super(context);
        this.vk = true;
        this.k = new AnimatorSet();
        hw(context);
    }

    public void pr(int i) {
        this.w = i;
        pr();
    }

    private View pr(Context context) {
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setClipChildren(false);
        frameLayout.setLayoutParams(layoutParams);
        this.pr = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics()));
        this.pr.setId(2114387592);
        layoutParams2.gravity = 16;
        g.pr(context, "tt_splash_click_bar_go", (View) this.pr, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.pr.setLayoutParams(layoutParams2);
        frameLayout.addView(this.pr);
        er.pr((View) this.pr, 8);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.hw = relativeLayout;
        relativeLayout.setId(2114387591);
        new FrameLayout.LayoutParams(-2, -2).gravity = 16;
        this.hw.setPadding(er.hn(context, 4.0f), 0, 0, 0);
        frameLayout.addView(this.hw);
        er.pr((View) this.hw, 8);
        ImageView imageView = new ImageView(context);
        this.hn = imageView;
        imageView.setId(2114387590);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.hn.setAlpha(0.0f);
        g.pr(context, "tt_splash_arrow", this.hn, 160);
        this.hn.setLayoutParams(layoutParams3);
        this.hw.addView(this.hn);
        ImageView imageView2 = new ImageView(context);
        this.x = imageView2;
        imageView2.setId(2114387589);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.x.setAlpha(0.0f);
        g.pr(context, "tt_splash_arrow", (View) this.x, 160);
        this.x.setLayoutParams(layoutParams4);
        this.hw.addView(this.x);
        ImageView imageView3 = new ImageView(context);
        this.c = imageView3;
        imageView3.setId(2114387588);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.c.setAlpha(0.0f);
        g.pr(context, "tt_splash_arrow", (View) this.c, 160);
        this.c.setLayoutParams(layoutParams5);
        this.hw.addView(this.c);
        View view = new View(context);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics())));
        this.hw.addView(view);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.uc = frameLayout2;
        frameLayout2.setId(2114387587);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        this.uc.setClipChildren(false);
        this.uc.setLayoutParams(layoutParams6);
        frameLayout.addView(this.uc);
        er.pr((View) this.uc, 8);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.aj = relativeLayout2;
        relativeLayout2.setId(2114387586);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, -1);
        this.aj.setClipChildren(false);
        this.aj.setLayoutParams(layoutParams7);
        this.uc.addView(this.aj);
        ImageView imageView4 = new ImageView(context);
        this.fw = imageView4;
        imageView4.setId(2114387585);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 50.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 50.0f, resources.getDisplayMetrics()));
        g.pr(context, "tt_splash_hand", this.fw, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.fw.setLayoutParams(layoutParams8);
        this.aj.addView(this.fw);
        er.pr((View) this.fw, 4);
        return frameLayout;
    }

    private void hw(Context context) {
        View viewPr = pr(getContext());
        if (viewPr == null) {
            return;
        }
        addView(viewPr);
        SplashDiffuseView splashDiffuseView = new SplashDiffuseView(getContext());
        this.zo = splashDiffuseView;
        this.uc.addView(splashDiffuseView, 0);
        ViewGroup.LayoutParams layoutParams = this.zo.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.zo.setVisibility(4);
    }

    public Animator getAnimator() {
        return this.k;
    }

    private void pr() {
        this.pr.setVisibility(8);
        this.hw.setVisibility(8);
        switch (this.w) {
            case 1:
                this.hw.setVisibility(0);
                hw();
                break;
            case 2:
                this.uc.setVisibility(0);
                post(new Runnable() { // from class: com.byazt.jm.SplashClickBarArrow.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SplashClickBarArrow.this.aj.getLayoutParams();
                        layoutParams.topMargin = (int) ((SplashClickBarArrow.this.zo.getMeasuredHeight() / 2.0f) - er.hn(SplashClickBarArrow.this.getContext(), 5.0f));
                        layoutParams.leftMargin = (int) ((SplashClickBarArrow.this.zo.getMeasuredWidth() / 2.0f) - er.hn(SplashClickBarArrow.this.getContext(), 5.0f));
                        layoutParams.bottomMargin = (int) (((-SplashClickBarArrow.this.zo.getMeasuredHeight()) / 2.0f) + er.hn(SplashClickBarArrow.this.getContext(), 5.0f));
                        layoutParams.rightMargin = (int) (((-SplashClickBarArrow.this.zo.getMeasuredWidth()) / 2.0f) + er.hn(SplashClickBarArrow.this.getContext(), 5.0f));
                        SplashClickBarArrow.this.aj.setLayoutParams(layoutParams);
                    }
                });
                hn();
                break;
            case 3:
            case 4:
            case 5:
            case 7:
                break;
            case 6:
            default:
                this.pr.setVisibility(0);
                break;
        }
    }

    private void hw() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.hn, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new pr());
        objectAnimatorOfFloat.setDuration(1300L);
        objectAnimatorOfFloat.setStartDelay(700L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.hn, "translationX", 0.0f, er.hn(getContext(), 20.0f));
        objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat2.setDuration(1300L);
        objectAnimatorOfFloat2.setStartDelay(700L);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.x, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat3.setInterpolator(new pr());
        objectAnimatorOfFloat3.setDuration(1300L);
        objectAnimatorOfFloat3.setStartDelay(500L);
        objectAnimatorOfFloat3.setRepeatCount(-1);
        objectAnimatorOfFloat3.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.x, "translationX", er.hn(getContext(), 23.0f));
        objectAnimatorOfFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat4.setDuration(1300L);
        objectAnimatorOfFloat4.setStartDelay(500L);
        objectAnimatorOfFloat4.setRepeatCount(-1);
        objectAnimatorOfFloat4.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.c, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat5.setInterpolator(new pr());
        objectAnimatorOfFloat5.setDuration(1300L);
        objectAnimatorOfFloat5.setStartDelay(200L);
        objectAnimatorOfFloat5.setRepeatCount(-1);
        objectAnimatorOfFloat5.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.c, "translationX", er.hn(getContext(), 25.0f));
        objectAnimatorOfFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat6.setDuration(1300L);
        objectAnimatorOfFloat6.setStartDelay(200L);
        objectAnimatorOfFloat6.setRepeatCount(-1);
        objectAnimatorOfFloat6.setRepeatMode(1);
        this.k.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat3, objectAnimatorOfFloat5, objectAnimatorOfFloat2, objectAnimatorOfFloat4, objectAnimatorOfFloat6);
    }

    private void hn() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.fw, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.byazt.jm.SplashClickBarArrow.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(SplashClickBarArrow.this.fw, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                SplashClickBarArrow.this.fw.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (SplashClickBarArrow.this.vk) {
                    SplashClickBarArrow.this.zo.pr();
                }
                SplashClickBarArrow splashClickBarArrow = SplashClickBarArrow.this;
                splashClickBarArrow.vk = !splashClickBarArrow.vk;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.fw, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.k.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.k.setStartDelay(1000L);
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 2213})
    private static class pr implements Interpolator {
        private pr() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f <= 0.38f) {
                return f * 2.631579f;
            }
            return (f * (-1.6129032f)) + 1.6129032f;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            AnimatorSet animatorSet = this.k;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
        } catch (Exception e) {
            ho.pr(e.getMessage());
        }
    }
}

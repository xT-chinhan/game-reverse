package com.byazt.hi;

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
import com.byazt.tk.k;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 123, 1795})
public class SplashClickBarArrow extends FrameLayout {
    public int cp;
    public AnimatorSet d;
    public SplashDiffuseView fs;
    public ImageView l;
    public ImageView n;
    public ImageView q;
    public RelativeLayout qg;
    public RelativeLayout rv;
    public ImageView s;
    public boolean tj;
    public FrameLayout w;
    public ImageView x;

    public SplashClickBarArrow(Context context) {
        super(context);
        this.tj = true;
        this.d = new AnimatorSet();
        qg(context);
    }

    public void n(int i) {
        this.cp = i;
        n();
    }

    private View n(Context context) {
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setClipChildren(false);
        frameLayout.setLayoutParams(layoutParams);
        this.n = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics()));
        this.n.setId(2114387592);
        layoutParams2.gravity = 16;
        sz.n(context, "tt_splash_click_bar_go", (View) this.n, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.n.setLayoutParams(layoutParams2);
        frameLayout.addView(this.n);
        com.byazt.okk.s.n((View) this.n, 8);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.qg = relativeLayout;
        relativeLayout.setId(2114387591);
        new FrameLayout.LayoutParams(-2, -2).gravity = 16;
        this.qg.setPadding(com.byazt.okk.s.s(context, 4.0f), 0, 0, 0);
        frameLayout.addView(this.qg);
        com.byazt.okk.s.n((View) this.qg, 8);
        ImageView imageView = new ImageView(context);
        this.s = imageView;
        imageView.setId(2114387590);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.s.setAlpha(0.0f);
        sz.n(context, "tt_splash_arrow", this.s, 160);
        this.s.setLayoutParams(layoutParams3);
        this.qg.addView(this.s);
        ImageView imageView2 = new ImageView(context);
        this.q = imageView2;
        imageView2.setId(2114387589);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.q.setAlpha(0.0f);
        sz.n(context, "tt_splash_arrow", (View) this.q, 160);
        this.q.setLayoutParams(layoutParams4);
        this.qg.addView(this.q);
        ImageView imageView3 = new ImageView(context);
        this.l = imageView3;
        imageView3.setId(2114387588);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.l.setAlpha(0.0f);
        sz.n(context, "tt_splash_arrow", (View) this.l, 160);
        this.l.setLayoutParams(layoutParams5);
        this.qg.addView(this.l);
        View view = new View(context);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics())));
        this.qg.addView(view);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.w = frameLayout2;
        frameLayout2.setId(2114387587);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        this.w.setClipChildren(false);
        this.w.setLayoutParams(layoutParams6);
        frameLayout.addView(this.w);
        com.byazt.okk.s.n((View) this.w, 8);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.rv = relativeLayout2;
        relativeLayout2.setId(2114387586);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, -1);
        this.rv.setClipChildren(false);
        this.rv.setLayoutParams(layoutParams7);
        this.w.addView(this.rv);
        ImageView imageView4 = new ImageView(context);
        this.x = imageView4;
        imageView4.setId(2114387585);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 50.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 50.0f, resources.getDisplayMetrics()));
        sz.n(context, "tt_splash_hand", this.x, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.x.setLayoutParams(layoutParams8);
        this.rv.addView(this.x);
        com.byazt.okk.s.n((View) this.x, 4);
        return frameLayout;
    }

    private void qg(Context context) {
        View viewN = n(getContext());
        if (viewN == null) {
            return;
        }
        addView(viewN);
        SplashDiffuseView splashDiffuseView = new SplashDiffuseView(getContext());
        this.fs = splashDiffuseView;
        this.w.addView(splashDiffuseView, 0);
        ViewGroup.LayoutParams layoutParams = this.fs.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.fs.setVisibility(4);
    }

    public Animator getAnimator() {
        return this.d;
    }

    private void n() {
        this.n.setVisibility(8);
        this.qg.setVisibility(8);
        int i = this.cp;
        if (i == 1) {
            this.qg.setVisibility(0);
            qg();
            return;
        }
        if (i == 2) {
            this.w.setVisibility(0);
            post(new Runnable() { // from class: com.byazt.hi.SplashClickBarArrow.1
                @Override // java.lang.Runnable
                public void run() {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SplashClickBarArrow.this.rv.getLayoutParams();
                    layoutParams.topMargin = (int) ((SplashClickBarArrow.this.fs.getMeasuredHeight() / 2.0f) - com.byazt.okk.s.s(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.leftMargin = (int) ((SplashClickBarArrow.this.fs.getMeasuredWidth() / 2.0f) - com.byazt.okk.s.s(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.bottomMargin = (int) (((-SplashClickBarArrow.this.fs.getMeasuredHeight()) / 2.0f) + com.byazt.okk.s.s(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.rightMargin = (int) (((-SplashClickBarArrow.this.fs.getMeasuredWidth()) / 2.0f) + com.byazt.okk.s.s(SplashClickBarArrow.this.getContext(), 5.0f));
                    SplashClickBarArrow.this.rv.setLayoutParams(layoutParams);
                }
            });
            s();
        } else {
            if (i == 3 || i == 4 || i == 5 || i == 7) {
                return;
            }
            this.n.setVisibility(0);
        }
    }

    private void qg() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.s, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new n());
        objectAnimatorOfFloat.setDuration(1300L);
        objectAnimatorOfFloat.setStartDelay(700L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.s, "translationX", 0.0f, com.byazt.okk.s.s(getContext(), 20.0f));
        objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat2.setDuration(1300L);
        objectAnimatorOfFloat2.setStartDelay(700L);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.q, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat3.setInterpolator(new n());
        objectAnimatorOfFloat3.setDuration(1300L);
        objectAnimatorOfFloat3.setStartDelay(500L);
        objectAnimatorOfFloat3.setRepeatCount(-1);
        objectAnimatorOfFloat3.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.q, "translationX", com.byazt.okk.s.s(getContext(), 23.0f));
        objectAnimatorOfFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat4.setDuration(1300L);
        objectAnimatorOfFloat4.setStartDelay(500L);
        objectAnimatorOfFloat4.setRepeatCount(-1);
        objectAnimatorOfFloat4.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.l, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat5.setInterpolator(new n());
        objectAnimatorOfFloat5.setDuration(1300L);
        objectAnimatorOfFloat5.setStartDelay(200L);
        objectAnimatorOfFloat5.setRepeatCount(-1);
        objectAnimatorOfFloat5.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.l, "translationX", com.byazt.okk.s.s(getContext(), 25.0f));
        objectAnimatorOfFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat6.setDuration(1300L);
        objectAnimatorOfFloat6.setStartDelay(200L);
        objectAnimatorOfFloat6.setRepeatCount(-1);
        objectAnimatorOfFloat6.setRepeatMode(1);
        this.d.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat3, objectAnimatorOfFloat5, objectAnimatorOfFloat2, objectAnimatorOfFloat4, objectAnimatorOfFloat6);
    }

    private void s() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.x, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.byazt.hi.SplashClickBarArrow.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(SplashClickBarArrow.this.x, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                SplashClickBarArrow.this.x.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (SplashClickBarArrow.this.tj) {
                    SplashClickBarArrow.this.fs.n();
                }
                SplashClickBarArrow splashClickBarArrow = SplashClickBarArrow.this;
                splashClickBarArrow.tj = !splashClickBarArrow.tj;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.x, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.d.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.d.setStartDelay(1000L);
    }

    @com.byazt.cp.n(n = {0, 1, 123, 1774})
    private static class n implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.38f ? f * 2.631579f : (f * (-1.6129032f)) + 1.6129032f;
        }

        private n() {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            AnimatorSet animatorSet = this.d;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
        } catch (Exception e) {
            k.n(e.getMessage());
        }
    }
}

package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;

/* JADX INFO: loaded from: classes2.dex */
public class SplashClickBarArrow extends FrameLayout {
    private ImageView ab;
    private ImageView ah;
    private FrameLayout c;
    private boolean ch;
    private ImageView d;
    private int hi;
    private ImageView ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private View f2325ms;
    private RelativeLayout ny;
    private AnimatorSet sl;
    private SplashDiffuseView x;
    private RelativeLayout xr;

    public SplashClickBarArrow(Context context) {
        super(context);
        this.ch = true;
        this.sl = new AnimatorSet();
        xr(context);
    }

    public void ms(int i) {
        this.hi = i;
        ms();
    }

    private View ms(Context context) {
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setClipChildren(false);
        frameLayout.setLayoutParams(layoutParams);
        this.f2325ms = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics()));
        this.f2325ms.setId(2114387598);
        layoutParams2.gravity = 16;
        t.ms(context, "tt_splash_click_bar_go", this.f2325ms);
        this.f2325ms.setLayoutParams(layoutParams2);
        frameLayout.addView(this.f2325ms);
        ul.ms(this.f2325ms, 8);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.xr = relativeLayout;
        relativeLayout.setId(2114387597);
        new FrameLayout.LayoutParams(-2, -2).gravity = 16;
        this.xr.setPadding(ul.ah(context, 4.0f), 0, 0, 0);
        frameLayout.addView(this.xr);
        ul.ms((View) this.xr, 8);
        ImageView imageView = new ImageView(context);
        this.ah = imageView;
        imageView.setId(2114387596);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.ah.setAlpha(0.0f);
        t.ms(context, "tt_splash_arrow", this.ah);
        this.ah.setLayoutParams(layoutParams3);
        this.xr.addView(this.ah);
        ImageView imageView2 = new ImageView(context);
        this.d = imageView2;
        imageView2.setId(2114387595);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.d.setAlpha(0.0f);
        t.ms(context, "tt_splash_arrow", (View) this.d);
        this.d.setLayoutParams(layoutParams4);
        this.xr.addView(this.d);
        ImageView imageView3 = new ImageView(context);
        this.ka = imageView3;
        imageView3.setId(2114387594);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.ka.setAlpha(0.0f);
        t.ms(context, "tt_splash_arrow", (View) this.ka);
        this.ka.setLayoutParams(layoutParams5);
        this.xr.addView(this.ka);
        View view = new View(context);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics())));
        this.xr.addView(view);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.c = frameLayout2;
        frameLayout2.setId(2114387593);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        this.c.setClipChildren(false);
        this.c.setLayoutParams(layoutParams6);
        frameLayout.addView(this.c);
        ul.ms((View) this.c, 8);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.ny = relativeLayout2;
        relativeLayout2.setId(2114387592);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, -1);
        this.ny.setClipChildren(false);
        this.ny.setLayoutParams(layoutParams7);
        this.c.addView(this.ny);
        ImageView imageView4 = new ImageView(context);
        this.ab = imageView4;
        imageView4.setId(2114387591);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 50.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 50.0f, resources.getDisplayMetrics()));
        Drawable drawableAh = t.ah(context, "tt_splash_hand");
        if (drawableAh != null) {
            this.ab.setImageDrawable(drawableAh);
        } else {
            com.bytedance.sdk.openadsdk.x.xr.ms(com.bytedance.sdk.openadsdk.core.x.ah.ms("splash_hand.png")).ms(this.ab);
        }
        this.ab.setLayoutParams(layoutParams8);
        this.ny.addView(this.ab);
        ul.ms((View) this.ab, 4);
        return frameLayout;
    }

    private void xr(Context context) {
        View viewMs = ms(getContext());
        if (viewMs == null) {
            return;
        }
        addView(viewMs);
        SplashDiffuseView splashDiffuseView = new SplashDiffuseView(getContext());
        this.x = splashDiffuseView;
        this.c.addView(splashDiffuseView, 0);
        ViewGroup.LayoutParams layoutParams = this.x.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.x.setVisibility(4);
    }

    public Animator getAnimator() {
        return this.sl;
    }

    private void ms() {
        this.f2325ms.setVisibility(8);
        this.xr.setVisibility(8);
        int i = this.hi;
        if (i == 1) {
            this.xr.setVisibility(0);
            xr();
            return;
        }
        if (i == 2) {
            this.c.setVisibility(0);
            post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.1
                @Override // java.lang.Runnable
                public void run() {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SplashClickBarArrow.this.ny.getLayoutParams();
                    layoutParams.topMargin = (int) ((SplashClickBarArrow.this.x.getMeasuredHeight() / 2.0f) - ul.ah(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.leftMargin = (int) ((SplashClickBarArrow.this.x.getMeasuredWidth() / 2.0f) - ul.ah(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.bottomMargin = (int) (((-SplashClickBarArrow.this.x.getMeasuredHeight()) / 2.0f) + ul.ah(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.rightMargin = (int) (((-SplashClickBarArrow.this.x.getMeasuredWidth()) / 2.0f) + ul.ah(SplashClickBarArrow.this.getContext(), 5.0f));
                    SplashClickBarArrow.this.ny.setLayoutParams(layoutParams);
                }
            });
            ah();
        } else {
            if (i == 3 || i == 4 || i == 5 || i == 7) {
                return;
            }
            this.f2325ms.setVisibility(0);
        }
    }

    private void xr() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.ah, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new ms());
        objectAnimatorOfFloat.setDuration(1300L);
        objectAnimatorOfFloat.setStartDelay(700L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.ah, "translationX", 0.0f, ul.ah(getContext(), 20.0f));
        objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat2.setDuration(1300L);
        objectAnimatorOfFloat2.setStartDelay(700L);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.d, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat3.setInterpolator(new ms());
        objectAnimatorOfFloat3.setDuration(1300L);
        objectAnimatorOfFloat3.setStartDelay(500L);
        objectAnimatorOfFloat3.setRepeatCount(-1);
        objectAnimatorOfFloat3.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.d, "translationX", ul.ah(getContext(), 23.0f));
        objectAnimatorOfFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat4.setDuration(1300L);
        objectAnimatorOfFloat4.setStartDelay(500L);
        objectAnimatorOfFloat4.setRepeatCount(-1);
        objectAnimatorOfFloat4.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.ka, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat5.setInterpolator(new ms());
        objectAnimatorOfFloat5.setDuration(1300L);
        objectAnimatorOfFloat5.setStartDelay(200L);
        objectAnimatorOfFloat5.setRepeatCount(-1);
        objectAnimatorOfFloat5.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.ka, "translationX", ul.ah(getContext(), 25.0f));
        objectAnimatorOfFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        objectAnimatorOfFloat6.setDuration(1300L);
        objectAnimatorOfFloat6.setStartDelay(200L);
        objectAnimatorOfFloat6.setRepeatCount(-1);
        objectAnimatorOfFloat6.setRepeatMode(1);
        this.sl.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat3, objectAnimatorOfFloat5, objectAnimatorOfFloat2, objectAnimatorOfFloat4, objectAnimatorOfFloat6);
    }

    private void ah() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.ab, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(SplashClickBarArrow.this.ab, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                SplashClickBarArrow.this.ab.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (SplashClickBarArrow.this.ch) {
                    SplashClickBarArrow.this.x.ms();
                }
                SplashClickBarArrow splashClickBarArrow = SplashClickBarArrow.this;
                splashClickBarArrow.ch = !splashClickBarArrow.ch;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.ab, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.sl.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.sl.setStartDelay(1000L);
    }

    private static class ms implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.38f ? f * 2.631579f : (f * (-1.6129032f)) + 1.6129032f;
        }

        private ms() {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            AnimatorSet animatorSet = this.sl;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
        } catch (Exception e) {
            sl.xr(e.getMessage());
        }
    }
}

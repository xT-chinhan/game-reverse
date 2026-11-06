package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class SlideUpView extends RelativeLayout {
    private AnimatorSet ab;
    private ImageView ah;
    private AnimatorSet c;
    private ImageView d;
    private AnimatorSet ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ImageView f2322ms;
    private AnimatorSet x;
    private ImageView xr;

    public SlideUpView(Context context) {
        super(context);
        xr(context);
    }

    private View ms(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setGravity(16);
        relativeLayout.setClipChildren(false);
        relativeLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(context);
        this.ah = imageView;
        imageView.setId(2114387645);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        layoutParams2.addRule(14);
        layoutParams2.addRule(8, 2114387767);
        layoutParams2.bottomMargin = ul.ah(context, -24.0f);
        t.ms(context, "tt_splash_slide_up_circle", (View) this.ah);
        this.ah.setAlpha(0.0f);
        this.ah.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.ah);
        ImageView imageView2 = new ImageView(context);
        this.xr = imageView2;
        imageView2.setId(2114387945);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 0.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(14);
        layoutParams3.addRule(1, 2114387767);
        layoutParams3.addRule(8, 2114387767);
        t.ms(context, "tt_splash_slide_up_bg", (View) this.xr);
        layoutParams3.leftMargin = ul.ah(context, -7.0f);
        this.xr.setLayoutParams(layoutParams3);
        relativeLayout.addView(this.xr);
        ImageView imageView3 = new ImageView(context);
        this.f2322ms = imageView3;
        imageView3.setId(2114387650);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 91.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 68.0f, resources.getDisplayMetrics()));
        layoutParams4.addRule(14);
        layoutParams4.addRule(1, 2114387767);
        layoutParams4.addRule(8, 2114387767);
        t.ms(context, "tt_splash_slide_up_finger", (View) this.f2322ms);
        layoutParams4.leftMargin = ul.ah(context, -7.0f);
        layoutParams4.bottomMargin = ul.ah(context, -20.0f);
        this.f2322ms.setAlpha(0.0f);
        this.f2322ms.setLayoutParams(layoutParams4);
        relativeLayout.addView(this.f2322ms);
        ImageView imageView4 = new ImageView(context);
        this.d = imageView4;
        imageView4.setId(2114387767);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 124.0f, resources.getDisplayMetrics()));
        layoutParams5.addRule(14);
        t.ms(context, "tt_splash_slide_up_arrow", (View) this.d);
        this.d.setLayoutParams(layoutParams5);
        relativeLayout.addView(this.d);
        return relativeLayout;
    }

    private void xr(Context context) {
        if (context == null) {
            context = re.getContext();
        }
        View viewMs = ms(context);
        if (viewMs == null) {
            return;
        }
        addView(viewMs);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.ka;
    }

    public void ms() {
        this.c = new AnimatorSet();
        this.ab = new AnimatorSet();
        this.x = new AnimatorSet();
        this.ka = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f2322ms, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f2322ms, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f2322ms, "translationY", 0.0f, ul.ah(getContext(), -110.0f));
        objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, ul.ah(getContext(), 110.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SlideUpView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.xr.getLayoutParams();
                layoutParams.height = num.intValue();
                SlideUpView.this.xr.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.xr, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.xr, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.ah, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.ah, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.ah, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.ah, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.ah, "translationY", 0.0f, ul.ah(getContext(), -110.0f));
        objectAnimatorOfFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.c.setDuration(50L);
        this.x.setDuration(1500L);
        this.ab.setDuration(50L);
        this.c.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.ab.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.x.playTogether(objectAnimatorOfFloat3, valueAnimatorOfInt, objectAnimatorOfFloat10);
        this.ka.playSequentially(this.ab, this.x, this.c);
    }

    public void xr() {
        AnimatorSet animatorSet = this.ka;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.ab;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.c;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        AnimatorSet animatorSet4 = this.x;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
    }
}

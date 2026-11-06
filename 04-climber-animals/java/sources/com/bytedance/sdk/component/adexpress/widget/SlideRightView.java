package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.d.x;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class SlideRightView extends FrameLayout {
    private AnimatorSet ab;
    private ImageView ah;
    private AnimatorSet c;
    private ImageView d;
    private TextView ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f971ms;
    private AnimatorSet ny;
    private AnimatorSet x;
    private ImageView xr;

    public SlideRightView(Context context) {
        super(context);
        this.c = new AnimatorSet();
        this.ab = new AnimatorSet();
        this.x = new AnimatorSet();
        this.ny = new AnimatorSet();
        this.f971ms = context;
        ah();
    }

    private void ah() {
        ImageView imageView = new ImageView(this.f971ms);
        this.d = imageView;
        imageView.setBackgroundResource(t.ka(this.f971ms, "tt_splash_slide_right_bg"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -2);
        layoutParams.gravity = 48;
        layoutParams.leftMargin = (int) x.ms(this.f971ms, 30.0f);
        addView(this.d, layoutParams);
        setClipChildren(false);
        setClipToPadding(false);
        ImageView imageView2 = new ImageView(this.f971ms);
        this.ah = imageView2;
        imageView2.setImageResource(t.ka(this.f971ms, "tt_splash_slide_right_circle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) x.ms(this.f971ms, 50.0f), (int) x.ms(this.f971ms, 50.0f));
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = (int) x.ms(this.f971ms, 30.0f);
        addView(this.ah, layoutParams2);
        ImageView imageView3 = new ImageView(this.f971ms);
        this.xr = imageView3;
        imageView3.setImageResource(t.ka(this.f971ms, "tt_splash_hand2"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) x.ms(this.f971ms, 80.0f), (int) x.ms(this.f971ms, 80.0f));
        layoutParams3.gravity = 48;
        layoutParams3.leftMargin = (int) x.ms(this.f971ms, 30.0f);
        addView(this.xr, layoutParams3);
        TextView textView = new TextView(this.f971ms);
        this.ka = textView;
        textView.setTextColor(-1);
        this.ka.setSingleLine();
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 80;
        addView(this.ka, layoutParams4);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) SlideRightView.this.xr.getLayoutParams();
                layoutParams5.topMargin = (int) ((SlideRightView.this.ah.getMeasuredHeight() / 2.0f) - x.ms(SlideRightView.this.getContext(), 7.0f));
                layoutParams5.leftMargin = (-SlideRightView.this.ah.getMeasuredWidth()) + ((int) x.ms(SlideRightView.this.f971ms, 30.0f));
                layoutParams5.setMarginStart(layoutParams5.leftMargin);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                SlideRightView.this.xr.setLayoutParams(layoutParams5);
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) SlideRightView.this.d.getLayoutParams();
                layoutParams6.topMargin = (int) ((SlideRightView.this.ah.getMeasuredHeight() / 2.0f) - x.ms(SlideRightView.this.getContext(), 5.0f));
                layoutParams6.leftMargin = (int) ((SlideRightView.this.ah.getMeasuredWidth() / 2.0f) + ((int) x.ms(SlideRightView.this.f971ms, 30.0f)));
                layoutParams5.setMarginStart(layoutParams5.leftMargin);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                SlideRightView.this.d.setLayoutParams(layoutParams6);
            }
        });
    }

    private void d() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.xr, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.ah, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.ah, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.d, "alpha", 0.0f, 1.0f);
        this.x.setDuration(300L);
        this.x.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.xr, "translationX", 0.0f, x.ms(getContext(), 90.0f));
        objectAnimatorOfFloat5.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) x.ms(getContext(), 90.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SlideRightView.this.d.getLayoutParams();
                layoutParams.width = num.intValue();
                SlideRightView.this.d.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.ah, "translationX", 0.0f, x.ms(getContext(), 90.0f));
        objectAnimatorOfFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.ny.setDuration(1500L);
        this.ny.playTogether(objectAnimatorOfFloat5, valueAnimatorOfInt, objectAnimatorOfFloat6);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.xr, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.d, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.ah, "alpha", 1.0f, 0.0f);
        this.ab.setDuration(50L);
        this.ab.playTogether(objectAnimatorOfFloat7, objectAnimatorOfFloat8, objectAnimatorOfFloat9);
        this.c.playSequentially(this.x, this.ny, this.ab);
    }

    public void ms() {
        d();
        this.c.start();
        this.c.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideRightView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideRightView.this.c.start();
                    }
                }, 200L);
            }
        });
    }

    public void xr() {
        try {
            AnimatorSet animatorSet = this.c;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.x;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.ny;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.ab;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable unused) {
        }
    }

    public void setGuideText(String str) {
        this.ka.setText(str);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }
}

package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.d.x;
import com.bytedance.sdk.component.utils.sl;

/* JADX INFO: loaded from: classes2.dex */
public class SlideUpView extends RelativeLayout {
    private AnimatorSet ab;
    private ImageView ah;
    private AnimatorSet c;
    private String ch;
    private TextView d;
    private int hi;
    private TextView ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ImageView f976ms;
    private AnimatorSet ny;
    private AnimatorSet x;
    private ImageView xr;

    public SlideUpView(Context context) {
        super(context);
        this.c = new AnimatorSet();
        this.ab = new AnimatorSet();
        this.x = new AnimatorSet();
        this.ny = new AnimatorSet();
        this.hi = 100;
        ms(context);
    }

    public SlideUpView(Context context, String str) {
        super(context);
        this.c = new AnimatorSet();
        this.ab = new AnimatorSet();
        this.x = new AnimatorSet();
        this.ny = new AnimatorSet();
        this.hi = 100;
        setClipChildren(false);
        this.ch = str;
        ms(context);
    }

    protected void ms(Context context) {
        if (context == null) {
            context = d.getContext();
        }
        if ("5".equals(this.ch)) {
            addView(com.bytedance.sdk.component.adexpress.ah.ms.c(context));
            this.hi = (int) (((double) this.hi) * 1.25d);
        } else {
            addView(com.bytedance.sdk.component.adexpress.ah.ms.ka(context));
        }
        this.f976ms = (ImageView) findViewById(2097610734);
        this.xr = (ImageView) findViewById(2097610735);
        this.d = (TextView) findViewById(2097610730);
        this.ah = (ImageView) findViewById(2097610733);
        this.ka = (TextView) findViewById(2097610731);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.c;
    }

    public void ms() {
        ah();
        this.c.start();
        this.c.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideUpView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideUpView.this.c.start();
                    }
                }, 200L);
            }
        });
    }

    public void ah() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f976ms, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f976ms, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f976ms, "translationY", 0.0f, x.ms(getContext(), -this.hi));
        objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) x.ms(getContext(), this.hi));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (SlideUpView.this.ah != null) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.ah.getLayoutParams();
                    layoutParams.height = num.intValue();
                    SlideUpView.this.ah.setLayoutParams(layoutParams);
                }
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.ah, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.ah, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.xr, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.xr, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.xr, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.xr, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.xr, "translationY", 0.0f, x.ms(getContext(), -this.hi));
        objectAnimatorOfFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.ab.setDuration(50L);
        this.ny.setDuration(1500L);
        this.x.setDuration(50L);
        this.ab.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.x.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.ny.playTogether(objectAnimatorOfFloat3, valueAnimatorOfInt, objectAnimatorOfFloat10);
        this.c.playSequentially(this.x, this.ny, this.ab);
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
            AnimatorSet animatorSet3 = this.ab;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.ny;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Exception e) {
            sl.xr(e.getMessage());
        }
    }

    public void setGuideText(String str) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSlideText(String str) {
        if (this.ka != null) {
            if (TextUtils.isEmpty(str)) {
                this.ka.setText("");
            } else {
                this.ka.setText(str);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xr();
    }
}

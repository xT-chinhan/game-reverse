package com.bytedance.sdk.component.adexpress.widget;

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
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class BluePressInteractView extends FrameLayout {
    private ImageView ab;
    private boolean ah;
    private View c;
    private Context ch;
    private View d;
    private View ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private AnimatorSet f910ms;
    private int ny;
    private int x;
    private ObjectAnimator xr;

    public BluePressInteractView(Context context, int i, int i2) {
        super(context);
        this.ah = false;
        this.f910ms = new AnimatorSet();
        this.x = i;
        this.ny = i2;
        this.ch = context;
        ah();
        d();
    }

    private void ah() {
        View view = new View(this.ch);
        this.d = view;
        view.setBackground(ms("#1A7BBEFF", "#337BBEFF"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (((double) this.x) * 0.45d), (int) (((double) this.ny) * 0.45d));
        layoutParams.gravity = 17;
        this.d.setLayoutParams(layoutParams);
        addView(this.d);
        View view2 = new View(this.ch);
        this.ka = view2;
        view2.setBackground(ms("#337BBEFF", "#807BBEFF"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (((double) this.x) * 0.25d), (int) (((double) this.ny) * 0.25d));
        layoutParams2.gravity = 17;
        this.ka.setLayoutParams(layoutParams2);
        addView(this.ka);
        View view3 = new View(this.ch);
        this.c = view3;
        view3.setBackground(ms("#807BBEFF", "#FF7BBEFF"));
        int i = this.x;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (((double) i) * 0.25d), (int) (((double) i) * 0.25d));
        layoutParams3.gravity = 17;
        this.c.setLayoutParams(layoutParams3);
        addView(this.c);
        ImageView imageView = new ImageView(this.ch);
        this.ab = imageView;
        imageView.setImageResource(t.ka(getContext(), "tt_blue_hand"));
        this.ab.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams((int) (((double) this.x) * 0.62d), (int) (((double) this.ny) * 0.53d));
        layoutParams4.gravity = 17;
        layoutParams4.topMargin = (layoutParams4.width / 2) - 5;
        layoutParams4.leftMargin = (layoutParams4.height / 2) - 5;
        this.ab.setLayoutParams(layoutParams4);
        addView(this.ab);
    }

    private void d() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.d, "scaleX", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.d, "scaleY", 1.0f, 2.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.ka, "scaleX", 1.0f, 2.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.ka, "scaleY", 1.0f, 2.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.c, "scaleX", 1.0f, 1.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.c, "scaleY", 1.0f, 1.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.ab, "rotation", 0.0f, -20.0f, 0.0f);
        this.xr = objectAnimatorOfFloat7;
        objectAnimatorOfFloat7.setDuration(1000L);
        this.f910ms.setDuration(1500L);
        this.f910ms.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f910ms.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat4).with(objectAnimatorOfFloat5).with(objectAnimatorOfFloat6);
        this.f910ms.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.BluePressInteractView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (BluePressInteractView.this.ah) {
                    return;
                }
                BluePressInteractView.this.xr.start();
                BluePressInteractView.this.f910ms.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                BluePressInteractView.this.ah = true;
            }
        });
    }

    private GradientDrawable ms(String str, String str2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setStroke(1, Color.parseColor(str2));
        return gradientDrawable;
    }

    public void ms() {
        this.ah = false;
        ObjectAnimator objectAnimator = this.xr;
        if (objectAnimator == null || this.f910ms == null) {
            return;
        }
        objectAnimator.start();
        this.f910ms.start();
    }

    public void xr() {
        this.ah = true;
        ObjectAnimator objectAnimator = this.xr;
        if (objectAnimator == null || this.f910ms == null) {
            return;
        }
        objectAnimator.cancel();
        this.f910ms.cancel();
    }
}

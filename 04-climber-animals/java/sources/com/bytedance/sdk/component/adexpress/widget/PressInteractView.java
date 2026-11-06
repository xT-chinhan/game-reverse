package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.d.x;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class PressInteractView extends FrameLayout {
    private SplashDiffuseView ah;
    private TextView c;
    private AnimatorSet d;
    private boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f957ms;
    private ImageView xr;

    public PressInteractView(Context context) {
        super(context);
        this.ka = true;
        this.f957ms = context;
        this.d = new AnimatorSet();
        ah();
        d();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.PressInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                int iMs = (int) x.ms(PressInteractView.this.f957ms, 50.0f);
                int iMs2 = (int) x.ms(PressInteractView.this.f957ms, 50.0f);
                if (PressInteractView.this.ah.getMeasuredHeight() > 0) {
                    iMs = PressInteractView.this.ah.getMeasuredHeight();
                }
                if (PressInteractView.this.ah.getMeasuredWidth() > 0) {
                    iMs2 = PressInteractView.this.ah.getMeasuredWidth();
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressInteractView.this.xr.getLayoutParams();
                layoutParams.topMargin = ((int) ((iMs / 2.0f) - x.ms(PressInteractView.this.getContext(), 5.0f))) + ((int) x.ms(PressInteractView.this.f957ms, 40.0f));
                layoutParams.leftMargin = ((int) ((iMs2 / 2.0f) - x.ms(PressInteractView.this.getContext(), 5.0f))) + ((int) x.ms(PressInteractView.this.f957ms, 20.0f));
                layoutParams.bottomMargin = (int) (((-iMs) / 2.0f) + x.ms(PressInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-iMs2) / 2.0f) + x.ms(PressInteractView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                PressInteractView.this.xr.setLayoutParams(layoutParams);
            }
        });
    }

    private void ah() {
        this.ah = new SplashDiffuseView(this.f957ms);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) x.ms(this.f957ms, 50.0f), (int) x.ms(this.f957ms, 50.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) x.ms(this.f957ms, 40.0f);
        layoutParams.leftMargin = (int) x.ms(this.f957ms, 20.0f);
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.ah, layoutParams);
        this.xr = new ImageView(this.f957ms);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) x.ms(this.f957ms, 78.0f), (int) x.ms(this.f957ms, 78.0f));
        this.xr.setImageResource(t.ka(this.f957ms, "tt_splash_hand"));
        addView(this.xr, layoutParams2);
        TextView textView = new TextView(this.f957ms);
        this.c = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) x.ms(this.f957ms, 10.0f);
        addView(this.c, layoutParams3);
        this.c.setVisibility(8);
    }

    private void d() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.xr, "scaleX", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(600L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.PressInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(PressInteractView.this.xr, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                objectAnimatorOfFloat2.start();
                PressInteractView.this.xr.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressInteractView.this.ka) {
                    PressInteractView.this.ah.ms();
                }
                PressInteractView pressInteractView = PressInteractView.this;
                pressInteractView.ka = !pressInteractView.ka;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.xr, "scaleY", 1.0f, 1.0f, 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(600L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.d.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void setGuideText(String str) {
        this.c.setVisibility(0);
        this.c.setText(str);
    }

    public void setGuideTextColor(int i) {
        this.c.setTextColor(i);
    }

    public void ms() {
        this.d.start();
    }

    public void xr() {
        AnimatorSet animatorSet = this.d;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        SplashDiffuseView splashDiffuseView = this.ah;
        if (splashDiffuseView != null) {
            splashDiffuseView.xr();
        }
        ImageView imageView = this.xr;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }
}

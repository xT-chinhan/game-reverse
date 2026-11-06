package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.d.x;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class PressButtonInteractView extends FrameLayout {
    private SplashDiffuseView ah;
    private AnimatorSet d;
    private boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f954ms;
    private ImageView xr;

    public PressButtonInteractView(Context context) {
        super(context);
        this.ka = true;
        this.f954ms = context;
        this.d = new AnimatorSet();
        ah();
        d();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressButtonInteractView.this.xr.getLayoutParams();
                layoutParams.topMargin = (int) ((PressButtonInteractView.this.ah.getMeasuredHeight() / 2.0f) - x.ms(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.leftMargin = (int) ((PressButtonInteractView.this.ah.getMeasuredWidth() / 2.0f) - x.ms(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.bottomMargin = (int) (((-PressButtonInteractView.this.ah.getMeasuredHeight()) / 2.0f) + x.ms(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-PressButtonInteractView.this.ah.getMeasuredWidth()) / 2.0f) + x.ms(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                PressButtonInteractView.this.xr.setLayoutParams(layoutParams);
            }
        });
    }

    private void ah() {
        this.ah = new SplashDiffuseView(this.f954ms);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) x.ms(this.f954ms, 40.0f), (int) x.ms(this.f954ms, 40.0f));
        layoutParams.gravity = 8388627;
        addView(this.ah, layoutParams);
        this.xr = new ImageView(this.f954ms);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) x.ms(this.f954ms, 62.0f), (int) x.ms(this.f954ms, 62.0f));
        layoutParams2.gravity = 16;
        this.xr.setImageResource(t.ka(this.f954ms, "tt_splash_hand"));
        addView(this.xr, layoutParams2);
    }

    private void d() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.xr, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(PressButtonInteractView.this.xr, "alpha", 0.0f, 1.0f);
                objectAnimatorOfFloat2.setDuration(200L);
                objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                objectAnimatorOfFloat2.start();
                PressButtonInteractView.this.xr.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressButtonInteractView.this.ka) {
                    PressButtonInteractView.this.ah.ms();
                }
                PressButtonInteractView pressButtonInteractView = PressButtonInteractView.this;
                pressButtonInteractView.ka = !pressButtonInteractView.ka;
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.xr, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setDuration(800L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.d.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
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

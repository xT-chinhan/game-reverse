package com.byazt.gx;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.byazt.rk.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 1861})
public class DynamicBaseScrollWidgetImp extends DynamicBaseWidgetImp implements c {
    public int a;
    public Runnable cz;
    public ObjectAnimator hw;
    public ObjectAnimator pr;

    /* JADX INFO: Access modifiers changed from: private */
    public void aj() {
        final View childAt = getChildAt(this.a);
        final View childAt2 = getChildAt((this.a + 1) % getChildCount());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(childAt, "translationY", 0.0f, (-(this.zo + getChildAt(this.a).getHeight())) / 2);
        this.pr = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.pr.addListener(new Animator.AnimatorListener() { // from class: com.byazt.gx.DynamicBaseScrollWidgetImp.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(childAt2, "translationY", (this.zo + childAt2.getHeight()) / 2, 0.0f);
        this.hw = objectAnimatorOfFloat2;
        objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        this.hw.addListener(new Animator.AnimatorListener() { // from class: com.byazt.gx.DynamicBaseScrollWidgetImp.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                childAt2.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.pr.setDuration(500L);
        this.hw.setDuration(500L);
        this.pr.start();
        this.hw.start();
        int i = this.a + 1;
        this.a = i;
        this.a = i % getChildCount();
        postDelayed(this.cz, 2000L);
    }

    public DynamicBaseScrollWidgetImp(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        this.a = 0;
        this.cz = new Runnable() { // from class: com.byazt.gx.DynamicBaseScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicBaseScrollWidgetImp.this.aj();
            }
        };
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = (this.zo - layoutParams.height) / 2;
            childAt.setLayoutParams(layoutParams);
            if (i != 0) {
                childAt.setVisibility(8);
            }
        }
        postDelayed(this.cz, 2500L);
    }

    @Override // com.byazt.gx.DynamicBaseWidget, com.byazt.gx.c
    public void hw() {
        removeCallbacks(this.cz);
        ObjectAnimator objectAnimator = this.pr;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.pr.cancel();
        }
        ObjectAnimator objectAnimator2 = this.hw;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.hw.cancel();
        }
        super.hw();
    }
}

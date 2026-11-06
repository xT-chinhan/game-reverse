package com.byazt.gx;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.byazt.rk.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 1737})
public class DynamicBaseInternalScrollWidgetImp extends DynamicBaseWidgetImp implements c {
    public int a;
    public boolean cz;
    public ObjectAnimator hw;
    public Runnable ny;
    public ObjectAnimator pr;

    public DynamicBaseInternalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        this.a = 0;
        this.cz = false;
        this.ny = new Runnable() { // from class: com.byazt.gx.DynamicBaseInternalScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicBaseInternalScrollWidgetImp.this.aj();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj() {
        final View childAt;
        final View childAt2 = getChildAt(this.a);
        int i = this.a;
        if (i == 0) {
            this.cz = false;
        }
        if (i + 1 < getChildCount() && ((ViewGroup) getChildAt(this.a + 1)).getChildCount() > 0) {
            childAt = getChildAt(this.a + 1);
            this.pr = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (-(this.fw + getChildAt(this.a).getWidth())) / 2);
        } else {
            this.cz = true;
            childAt = getChildAt(this.a - 1);
            this.pr = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (this.fw + getChildAt(this.a).getWidth()) / 2);
        }
        this.pr.setInterpolator(new LinearInterpolator());
        this.pr.addListener(new Animator.AnimatorListener() { // from class: com.byazt.gx.DynamicBaseInternalScrollWidgetImp.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt2.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        if (this.cz) {
            this.hw = ObjectAnimator.ofFloat(childAt, "translationX", (-(this.fw + childAt.getWidth())) / 2, 0.0f);
        } else {
            this.hw = ObjectAnimator.ofFloat(childAt, "translationX", (this.fw + childAt.getWidth()) / 2, 0.0f);
        }
        this.hw.setInterpolator(new LinearInterpolator());
        this.hw.addListener(new Animator.AnimatorListener() { // from class: com.byazt.gx.DynamicBaseInternalScrollWidgetImp.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                childAt.setVisibility(0);
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
        if (this.cz) {
            this.a--;
        } else {
            this.a++;
        }
        postDelayed(this.ny, 2000L);
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
        postDelayed(this.ny, 2500L);
    }

    @Override // com.byazt.gx.DynamicBaseWidget, com.byazt.gx.c
    public void hw() {
        removeCallbacks(this.ny);
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

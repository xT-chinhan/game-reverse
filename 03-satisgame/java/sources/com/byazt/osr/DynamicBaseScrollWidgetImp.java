package com.byazt.osr;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.byazt.lh.fs;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 2017})
public class DynamicBaseScrollWidgetImp extends DynamicBaseWidgetImp implements l {
    public int a;
    public ObjectAnimator n;
    public Runnable py;
    public ObjectAnimator qg;

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        final View childAt = getChildAt(this.a);
        final View childAt2 = getChildAt((this.a + 1) % getChildCount());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(childAt, "translationY", 0.0f, (-(this.fs + getChildAt(this.a).getHeight())) / 2);
        this.n = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.n.addListener(new Animator.AnimatorListener() { // from class: com.byazt.osr.DynamicBaseScrollWidgetImp.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt.setVisibility(8);
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(childAt2, "translationY", (this.fs + childAt2.getHeight()) / 2, 0.0f);
        this.qg = objectAnimatorOfFloat2;
        objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        this.qg.addListener(new Animator.AnimatorListener() { // from class: com.byazt.osr.DynamicBaseScrollWidgetImp.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                childAt2.setVisibility(0);
            }
        });
        this.n.setDuration(500L);
        this.qg.setDuration(500L);
        this.n.start();
        this.qg.start();
        int i = this.a + 1;
        this.a = i;
        this.a = i % getChildCount();
        postDelayed(this.py, 2000L);
    }

    public DynamicBaseScrollWidgetImp(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        this.a = 0;
        this.py = new Runnable() { // from class: com.byazt.osr.DynamicBaseScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicBaseScrollWidgetImp.this.rv();
            }
        };
    }

    @Override // com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = (this.fs - layoutParams.height) / 2;
            childAt.setLayoutParams(layoutParams);
            if (i != 0) {
                childAt.setVisibility(8);
            }
        }
        postDelayed(this.py, 2500L);
    }

    @Override // com.byazt.osr.DynamicBaseWidget, com.byazt.osr.l
    public void qg() {
        removeCallbacks(this.py);
        ObjectAnimator objectAnimator = this.n;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.n.cancel();
        }
        ObjectAnimator objectAnimator2 = this.qg;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.qg.cancel();
        }
        super.qg();
    }
}

package com.byazt.osr;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.byazt.lh.fs;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 1892})
public class DynamicBaseInternalScrollWidgetImp extends DynamicBaseWidgetImp implements l {
    public int a;
    public ObjectAnimator n;
    public Runnable ou;
    public boolean py;
    public ObjectAnimator qg;

    public DynamicBaseInternalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        this.a = 0;
        this.py = false;
        this.ou = new Runnable() { // from class: com.byazt.osr.DynamicBaseInternalScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicBaseInternalScrollWidgetImp.this.rv();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        final View childAt;
        final View childAt2 = getChildAt(this.a);
        int i = this.a;
        if (i == 0) {
            this.py = false;
        }
        if (i + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.a + 1)).getChildCount() <= 0) {
            this.py = true;
            childAt = getChildAt(this.a - 1);
            this.n = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (this.x + getChildAt(this.a).getWidth()) / 2);
        } else {
            childAt = getChildAt(this.a + 1);
            this.n = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (-(this.x + getChildAt(this.a).getWidth())) / 2);
        }
        this.n.setInterpolator(new LinearInterpolator());
        this.n.addListener(new Animator.AnimatorListener() { // from class: com.byazt.osr.DynamicBaseInternalScrollWidgetImp.2
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
                childAt2.setVisibility(8);
            }
        });
        if (this.py) {
            this.qg = ObjectAnimator.ofFloat(childAt, "translationX", (-(this.x + childAt.getWidth())) / 2, 0.0f);
        } else {
            this.qg = ObjectAnimator.ofFloat(childAt, "translationX", (this.x + childAt.getWidth()) / 2, 0.0f);
        }
        this.qg.setInterpolator(new LinearInterpolator());
        this.qg.addListener(new Animator.AnimatorListener() { // from class: com.byazt.osr.DynamicBaseInternalScrollWidgetImp.3
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
                childAt.setVisibility(0);
            }
        });
        this.n.setDuration(500L);
        this.qg.setDuration(500L);
        this.n.start();
        this.qg.start();
        if (this.py) {
            this.a--;
        } else {
            this.a++;
        }
        postDelayed(this.ou, 2000L);
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
        postDelayed(this.ou, 2500L);
    }

    @Override // com.byazt.osr.DynamicBaseWidget, com.byazt.osr.l
    public void qg() {
        removeCallbacks(this.ou);
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

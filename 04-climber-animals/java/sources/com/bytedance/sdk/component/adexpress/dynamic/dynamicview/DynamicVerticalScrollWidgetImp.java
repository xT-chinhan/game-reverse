package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.tapsdk.tapad.e.a;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicVerticalScrollWidgetImp extends DynamicBaseWidgetImp implements ka {
    private Runnable b;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    ObjectAnimator f836ms;
    private boolean nw;
    private int t;
    ObjectAnimator xr;

    public DynamicVerticalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.t = 0;
        this.nw = false;
        this.b = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicVerticalScrollWidgetImp.this.ny();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny() {
        View childAt;
        final View childAt2;
        final View childAt3 = getChildAt(this.t);
        int i = this.t;
        if (i == 0) {
            this.nw = false;
        }
        boolean z = i + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.t + 1)).getChildCount() <= 0;
        if (!this.zb.ch().ka().ms() && z) {
            this.nw = true;
            childAt2 = getChildAt(this.t - 1);
            this.f836ms = ObjectAnimator.ofFloat(childAt3, "translationY", 0.0f, (this.x + getChildAt(this.t).getHeight()) / 2);
        } else {
            if (z) {
                childAt = getChildAt((this.t + 2) % getChildCount());
            } else {
                childAt = getChildAt((this.t + 1) % getChildCount());
            }
            this.f836ms = ObjectAnimator.ofFloat(childAt3, "translationY", 0.0f, (-(this.x + getChildAt(this.t).getHeight())) / 2);
            if (z) {
                this.t++;
            }
            childAt2 = childAt;
        }
        this.f836ms.setInterpolator(new LinearInterpolator());
        this.f836ms.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.2
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
                childAt3.setVisibility(8);
            }
        });
        if (this.nw) {
            this.xr = ObjectAnimator.ofFloat(childAt2, "translationY", (-(this.x + childAt2.getHeight())) / 2, 0.0f);
        } else {
            this.xr = ObjectAnimator.ofFloat(childAt2, "translationY", (this.x + childAt2.getHeight()) / 2, 0.0f);
        }
        this.xr.setInterpolator(new LinearInterpolator());
        this.xr.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.3
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
        this.f836ms.setDuration(500L);
        this.xr.setDuration(500L);
        this.f836ms.start();
        this.xr.start();
        if (this.nw) {
            this.t--;
        } else {
            int i2 = this.t + 1;
            this.t = i2;
            this.t = i2 % getChildCount();
        }
        postDelayed(this.b, a.f);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = (this.x - layoutParams.height) / 2;
            childAt.setLayoutParams(layoutParams);
            if (i != 0) {
                childAt.setVisibility(8);
            }
        }
        postDelayed(this.b, 2500L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ka
    public void xr() {
        removeCallbacks(this.b);
        ObjectAnimator objectAnimator = this.f836ms;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.f836ms.cancel();
        }
        ObjectAnimator objectAnimator2 = this.xr;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.xr.cancel();
        }
        super.xr();
    }
}

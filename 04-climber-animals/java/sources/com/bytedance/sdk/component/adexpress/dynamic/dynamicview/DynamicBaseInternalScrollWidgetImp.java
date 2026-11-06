package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.anythink.basead.exoplayer.i.a;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicBaseInternalScrollWidgetImp extends DynamicBaseWidgetImp implements ka {
    private Runnable b;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    ObjectAnimator f794ms;
    private boolean nw;
    private int t;
    ObjectAnimator xr;

    public DynamicBaseInternalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.t = 0;
        this.nw = false;
        this.b = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicBaseInternalScrollWidgetImp.this.ny();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny() {
        final View childAt;
        final View childAt2 = getChildAt(this.t);
        int i = this.t;
        if (i == 0) {
            this.nw = false;
        }
        if (i + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.t + 1)).getChildCount() <= 0) {
            this.nw = true;
            childAt = getChildAt(this.t - 1);
            this.f794ms = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (this.ab + getChildAt(this.t).getWidth()) / 2);
        } else {
            childAt = getChildAt(this.t + 1);
            this.f794ms = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (-(this.ab + getChildAt(this.t).getWidth())) / 2);
        }
        this.f794ms.setInterpolator(new LinearInterpolator());
        this.f794ms.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.2
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
        if (this.nw) {
            this.xr = ObjectAnimator.ofFloat(childAt, "translationX", (-(this.ab + childAt.getWidth())) / 2, 0.0f);
        } else {
            this.xr = ObjectAnimator.ofFloat(childAt, "translationX", (this.ab + childAt.getWidth()) / 2, 0.0f);
        }
        this.xr.setInterpolator(new LinearInterpolator());
        this.xr.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.3
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
        this.f794ms.setDuration(500L);
        this.xr.setDuration(500L);
        this.f794ms.start();
        this.xr.start();
        if (this.nw) {
            this.t--;
        } else {
            this.t++;
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
        ObjectAnimator objectAnimator = this.f794ms;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.f794ms.cancel();
        }
        ObjectAnimator objectAnimator2 = this.xr;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.xr.cancel();
        }
        super.xr();
    }
}

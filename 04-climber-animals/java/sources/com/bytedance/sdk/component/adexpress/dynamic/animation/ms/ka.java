package com.bytedance.sdk.component.adexpress.dynamic.animation.ms;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends d {
    public ka(View view, com.bytedance.sdk.component.adexpress.dynamic.ah.ms msVar) {
        super(view, msVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x003d  */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.ms.d
    List<ObjectAnimator> ms() {
        byte b;
        ArrayList arrayList = new ArrayList();
        switch (this.xr.nw()) {
            case "both":
                b = 0;
                break;
            case "none":
                b = 3;
                break;
            case "forwards":
                b = 1;
                break;
            case "backwards":
                b = 2;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            ms(arrayList);
        } else if (b == 1) {
            d(arrayList);
        } else if (b == 2) {
            xr(arrayList);
        } else {
            ah(arrayList);
        }
        return arrayList;
    }

    private void ms(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ah, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.xr.t())).setDuration(((int) (this.xr.ch() * 1000.0d)) / 2);
        duration.setInterpolator(new LinearInterpolator());
        duration.setRepeatMode(2);
        this.xr.c(this.xr.ub() * 2);
        list.add(ms(duration));
    }

    private void xr(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ah, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.xr.t())).setDuration((int) (this.xr.ch() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.ms.ka.1
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
                ka.this.ah.setTranslationY(0.0f);
            }
        });
        list.add(ms(duration));
    }

    private void ah(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ah, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.xr.t())).setDuration((int) (this.xr.ch() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.ms.ka.2
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
                ka.this.ah.setTranslationY(0.0f);
            }
        });
        list.add(ms(duration));
    }

    private void d(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ah, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.xr.t())).setDuration((int) (this.xr.ch() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        list.add(ms(duration));
    }
}

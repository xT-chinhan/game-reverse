package com.bytedance.sdk.component.adexpress.dynamic.animation.ms;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ka {
    public View ah;
    private Set<ScheduledFuture<?>> d = new HashSet();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public List<ObjectAnimator> f772ms = ms();
    com.bytedance.sdk.component.adexpress.dynamic.ah.ms xr;

    abstract List<ObjectAnimator> ms();

    public d(View view, com.bytedance.sdk.component.adexpress.dynamic.ah.ms msVar) {
        this.ah = view;
        this.xr = msVar;
    }

    public void ah() {
        List<ObjectAnimator> list = this.f772ms;
        if (list == null) {
            return;
        }
        for (final ObjectAnimator objectAnimator : list) {
            objectAnimator.start();
            if (this.xr.h() > 0.0d) {
                objectAnimator.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.ms.d.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        objectAnimator.pause();
                        ms msVar = d.this.new ms(objectAnimator);
                        ScheduledFuture<?> scheduledFutureMs = com.bytedance.sdk.component.adexpress.d.ka.ms(msVar, (long) (d.this.xr.h() * 1000.0d), TimeUnit.MILLISECONDS);
                        msVar.ms(scheduledFutureMs);
                        d.this.d.add(scheduledFutureMs);
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ka
    public void xr() {
        List<ObjectAnimator> list = this.f772ms;
        if (list == null) {
            return;
        }
        for (ObjectAnimator objectAnimator : list) {
            objectAnimator.cancel();
            objectAnimator.removeAllUpdateListeners();
        }
        Iterator<ScheduledFuture<?>> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
    }

    ObjectAnimator ms(final ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay((long) (this.xr.u() * 1000.0d));
        if (this.xr.ub() > 0) {
            objectAnimator.setRepeatCount(this.xr.ub() - 1);
        } else {
            objectAnimator.setRepeatCount(-1);
        }
        if (!PrerollVideoResponse.NORMAL.equals(this.xr.ao())) {
            if ("alternate".equals(this.xr.ao()) || "alternate-reverse".equals(this.xr.ao())) {
                objectAnimator.setRepeatMode(2);
            } else {
                objectAnimator.setRepeatMode(1);
            }
        }
        if ("ease-in-out".equals(this.xr.zb())) {
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if ("ease-in".equals(this.xr.ao())) {
            objectAnimator.setInterpolator(new AccelerateInterpolator());
        } else if ("ease-out".equals(this.xr.ao())) {
            objectAnimator.setInterpolator(new DecelerateInterpolator());
        } else {
            objectAnimator.setInterpolator(new LinearInterpolator());
        }
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.ms.d.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getCurrentPlayTime() > 0) {
                    d.this.ah.setVisibility(0);
                    if (d.this.ah.getParent() instanceof DynamicBaseWidgetImp) {
                        ((View) d.this.ah.getParent()).setVisibility(0);
                    }
                    objectAnimator.removeAllUpdateListeners();
                }
            }
        });
        return objectAnimator;
    }

    public class ms implements Runnable {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        ObjectAnimator f775ms;
        ScheduledFuture<?> xr;

        ms(ObjectAnimator objectAnimator) {
            this.f775ms = objectAnimator;
        }

        public void ms(ScheduledFuture<?> scheduledFuture) {
            this.xr = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah() != null) {
                com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().xr().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.ms.d.ms.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.this.f775ms.resume();
                    }
                });
                if (this.xr != null) {
                    d.this.d.remove(this.xr);
                }
            }
        }
    }
}

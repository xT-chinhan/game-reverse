package com.byazt.hv;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.byazt.gx.DynamicBaseWidgetImp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 802, 121})
public abstract class x implements com.byazt.gx.c {
    public View hn;
    public com.byazt.rk.pr hw;
    public Set<ScheduledFuture<?>> x = new HashSet();
    public List<ObjectAnimator> pr = pr();

    public abstract List<ObjectAnimator> pr();

    public x(View view, com.byazt.rk.pr prVar) {
        this.hn = view;
        this.hw = prVar;
    }

    public void hn() {
        List<ObjectAnimator> list = this.pr;
        if (list == null) {
            return;
        }
        for (final ObjectAnimator objectAnimator : list) {
            objectAnimator.start();
            if (this.hw.yb() > 0.0d && Build.VERSION.SDK_INT >= 19) {
                objectAnimator.addListener(new Animator.AnimatorListener() { // from class: com.byazt.hv.x.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        objectAnimator.pause();
                        pr prVar = x.this.new pr(objectAnimator);
                        ScheduledFuture<?> scheduledFuturePr = com.byazt.js.c.pr(prVar, (long) (x.this.hw.yb() * 1000.0d), TimeUnit.MILLISECONDS);
                        prVar.pr(scheduledFuturePr);
                        x.this.x.add(scheduledFuturePr);
                    }
                });
            }
        }
    }

    @Override // com.byazt.gx.c
    public void hw() {
        List<ObjectAnimator> list = this.pr;
        if (list == null) {
            return;
        }
        for (ObjectAnimator objectAnimator : list) {
            objectAnimator.cancel();
            objectAnimator.removeAllUpdateListeners();
        }
        Iterator<ScheduledFuture<?>> it = this.x.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
    }

    public ObjectAnimator pr(final ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay((long) (this.hw.g() * 1000.0d));
        if (this.hw.ho() > 0) {
            objectAnimator.setRepeatCount(this.hw.ho() - 1);
        } else {
            objectAnimator.setRepeatCount(-1);
        }
        if (!"normal".equals(this.hw.nt())) {
            if ("alternate".equals(this.hw.nt()) || "alternate-reverse".equals(this.hw.nt())) {
                objectAnimator.setRepeatMode(2);
            } else {
                objectAnimator.setRepeatMode(1);
            }
        }
        if ("ease-in-out".equals(this.hw.m())) {
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if ("ease-in".equals(this.hw.nt())) {
            objectAnimator.setInterpolator(new AccelerateInterpolator());
        } else if ("ease-out".equals(this.hw.nt())) {
            objectAnimator.setInterpolator(new DecelerateInterpolator());
        } else {
            objectAnimator.setInterpolator(new LinearInterpolator());
        }
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.hv.x.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getCurrentPlayTime() > 0) {
                    x.this.hn.setVisibility(0);
                    if (x.this.hn.getParent() instanceof DynamicBaseWidgetImp) {
                        ((View) x.this.hn.getParent()).setVisibility(0);
                    }
                    objectAnimator.removeAllUpdateListeners();
                }
            }
        });
        return objectAnimator;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 802, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    public class pr implements Runnable {
        public ScheduledFuture<?> hw;
        public ObjectAnimator pr;

        public pr(ObjectAnimator objectAnimator) {
            this.pr = objectAnimator;
        }

        public void pr(ScheduledFuture<?> scheduledFuture) {
            this.hw = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT >= 19 && com.byazt.bg.pr.pr().hn() != null) {
                com.byazt.bg.pr.pr().hn().hw().post(new Runnable() { // from class: com.byazt.hv.x.pr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pr.this.pr.resume();
                    }
                });
                if (this.hw != null) {
                    x.this.x.remove(this.hw);
                }
            }
        }
    }
}

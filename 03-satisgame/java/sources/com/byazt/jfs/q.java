package com.byazt.jfs;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.byazt.osr.DynamicBaseWidgetImp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1191, 5})
public abstract class q implements com.byazt.osr.l {
    public com.byazt.lh.n qg;
    public View s;
    public Set<ScheduledFuture<?>> q = new HashSet();
    public List<ObjectAnimator> n = n();

    public abstract List<ObjectAnimator> n();

    public q(View view, com.byazt.lh.n nVar) {
        this.s = view;
        this.qg = nVar;
    }

    public void s() {
        List<ObjectAnimator> list = this.n;
        if (list == null) {
            return;
        }
        for (final ObjectAnimator objectAnimator : list) {
            objectAnimator.start();
            if (this.qg.hd() > 0.0d) {
                objectAnimator.addListener(new Animator.AnimatorListener() { // from class: com.byazt.jfs.q.1
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
                        n nVar = q.this.new n(objectAnimator);
                        ScheduledFuture<?> scheduledFutureN = com.byazt.cq.l.n(nVar, (long) (q.this.qg.hd() * 1000.0d), TimeUnit.MILLISECONDS);
                        nVar.n(scheduledFutureN);
                        q.this.q.add(scheduledFutureN);
                    }
                });
            }
        }
    }

    @Override // com.byazt.osr.l
    public void qg() {
        List<ObjectAnimator> list = this.n;
        if (list == null) {
            return;
        }
        for (ObjectAnimator objectAnimator : list) {
            objectAnimator.cancel();
            objectAnimator.removeAllUpdateListeners();
        }
        Iterator<ScheduledFuture<?>> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
    }

    public ObjectAnimator n(final ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay((long) (this.qg.sz() * 1000.0d));
        if (this.qg.k() > 0) {
            objectAnimator.setRepeatCount(this.qg.k() - 1);
        } else {
            objectAnimator.setRepeatCount(-1);
        }
        if (!"normal".equals(this.qg.cy())) {
            if ("alternate".equals(this.qg.cy()) || "alternate-reverse".equals(this.qg.cy())) {
                objectAnimator.setRepeatMode(2);
            } else {
                objectAnimator.setRepeatMode(1);
            }
        }
        if ("ease-in-out".equals(this.qg.oa())) {
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if ("ease-in".equals(this.qg.cy())) {
            objectAnimator.setInterpolator(new AccelerateInterpolator());
        } else if ("ease-out".equals(this.qg.cy())) {
            objectAnimator.setInterpolator(new DecelerateInterpolator());
        } else {
            objectAnimator.setInterpolator(new LinearInterpolator());
        }
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.jfs.q.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getCurrentPlayTime() > 0) {
                    q.this.s.setVisibility(0);
                    if (q.this.s.getParent() instanceof DynamicBaseWidgetImp) {
                        ((View) q.this.s.getParent()).setVisibility(0);
                    }
                    objectAnimator.removeAllUpdateListeners();
                }
            }
        });
        return objectAnimator;
    }

    @com.byazt.cp.n(n = {0, 1, 1191, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    public class n implements Runnable {
        public ObjectAnimator n;
        public ScheduledFuture<?> qg;

        public n(ObjectAnimator objectAnimator) {
            this.n = objectAnimator;
        }

        public void n(ScheduledFuture<?> scheduledFuture) {
            this.qg = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.byazt.gkj.n.n().s() != null) {
                com.byazt.gkj.n.n().s().qg().post(new Runnable() { // from class: com.byazt.jfs.q.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.n.resume();
                    }
                });
                if (this.qg != null) {
                    q.this.q.remove(this.qg);
                }
            }
        }
    }
}

package com.byazt.nu;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1243, 19})
public abstract class n extends ValueAnimator {
    public final Set<ValueAnimator.AnimatorUpdateListener> n = new CopyOnWriteArraySet();
    public final Set<Animator.AnimatorListener> qg = new CopyOnWriteArraySet();
    public final Set<Animator.AnimatorPauseListener> s = new CopyOnWriteArraySet();

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.n.add(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.n.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.n.clear();
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.qg.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.qg.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.qg.clear();
    }

    public void n(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.qg) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    @Override // android.animation.Animator
    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.s.add(animatorPauseListener);
    }

    @Override // android.animation.Animator
    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.s.remove(animatorPauseListener);
    }

    public void n() {
        Iterator<Animator.AnimatorListener> it = this.qg.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    public void qg(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.qg) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    public void qg() {
        Iterator<Animator.AnimatorListener> it = this.qg.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    public void s() {
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    public void q() {
        Iterator<Animator.AnimatorPauseListener> it = this.s.iterator();
        while (it.hasNext()) {
            it.next().onAnimationPause(this);
        }
    }

    public void l() {
        Iterator<Animator.AnimatorPauseListener> it = this.s.iterator();
        while (it.hasNext()) {
            it.next().onAnimationResume(this);
        }
    }
}

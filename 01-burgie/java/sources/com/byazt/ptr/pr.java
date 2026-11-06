package com.byazt.ptr;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 950, 37})
public abstract class pr extends ValueAnimator {
    public final Set<ValueAnimator.AnimatorUpdateListener> pr = new CopyOnWriteArraySet();
    public final Set<Animator.AnimatorListener> hw = new CopyOnWriteArraySet();
    public final Set<Animator.AnimatorPauseListener> hn = new CopyOnWriteArraySet();

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
        this.pr.add(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.pr.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.pr.clear();
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.hw.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.hw.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.hw.clear();
    }

    public void pr(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.hw) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    @Override // android.animation.Animator
    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.hn.add(animatorPauseListener);
    }

    @Override // android.animation.Animator
    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.hn.remove(animatorPauseListener);
    }

    public void pr() {
        Iterator<Animator.AnimatorListener> it = this.hw.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    public void hw(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.hw) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    public void hw() {
        Iterator<Animator.AnimatorListener> it = this.hw.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    public void hn() {
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.pr.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    public void x() {
        if (Build.VERSION.SDK_INT >= 19) {
            Iterator<Animator.AnimatorPauseListener> it = this.hn.iterator();
            while (it.hasNext()) {
                it.next().onAnimationPause(this);
            }
        }
    }

    public void c() {
        if (Build.VERSION.SDK_INT >= 19) {
            Iterator<Animator.AnimatorPauseListener> it = this.hn.iterator();
            while (it.hasNext()) {
                it.next().onAnimationResume(this);
            }
        }
    }
}

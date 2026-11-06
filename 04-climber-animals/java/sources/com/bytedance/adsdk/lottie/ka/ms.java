package com.bytedance.adsdk.lottie.ka;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms extends ValueAnimator {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Set<ValueAnimator.AnimatorUpdateListener> f172ms = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorListener> xr = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorPauseListener> ah = new CopyOnWriteArraySet();

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
        this.f172ms.add(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f172ms.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.f172ms.clear();
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.xr.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.xr.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.xr.clear();
    }

    void ms(boolean z) {
        Iterator<Animator.AnimatorListener> it = this.xr.iterator();
        while (it.hasNext()) {
            it.next().onAnimationStart(this, z);
        }
    }

    @Override // android.animation.Animator
    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.ah.add(animatorPauseListener);
    }

    @Override // android.animation.Animator
    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.ah.remove(animatorPauseListener);
    }

    void ms() {
        Iterator<Animator.AnimatorListener> it = this.xr.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    void xr(boolean z) {
        Iterator<Animator.AnimatorListener> it = this.xr.iterator();
        while (it.hasNext()) {
            it.next().onAnimationEnd(this, z);
        }
    }

    void xr() {
        Iterator<Animator.AnimatorListener> it = this.xr.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    void ah() {
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.f172ms.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    void d() {
        Iterator<Animator.AnimatorPauseListener> it = this.ah.iterator();
        while (it.hasNext()) {
            it.next().onAnimationPause(this);
        }
    }

    void ka() {
        Iterator<Animator.AnimatorPauseListener> it = this.ah.iterator();
        while (it.hasNext()) {
            it.next().onAnimationResume(this);
        }
    }
}

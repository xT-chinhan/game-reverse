package com.smartdigimkt.w1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends AnimatorListenerAdapter {
    public final /* synthetic */ i a;

    public h(i iVar) {
        this.a = iVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        int y = (int) this.a.a.a.getY();
        this.a.a.q = ValueAnimator.ofInt(0, y);
        this.a.a.q.setDuration(300L);
        this.a.a.q.addUpdateListener(new f(this, y));
        this.a.a.q.addListener(new g(this));
        RelativeLayout relativeLayout = this.a.a.b;
        if (relativeLayout != null) {
            relativeLayout.setAlpha(0.0f);
            this.a.a.b.setVisibility(0);
        }
        this.a.a.q.start();
        this.a.a.m.setVisibility(8);
    }
}

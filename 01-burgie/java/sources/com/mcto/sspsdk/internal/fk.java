package com.mcto.sspsdk.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class fk extends AnimatorListenerAdapter {
    public final /* synthetic */ FrameLayout a;

    public fk(FrameLayout frameLayout) {
        this.a = frameLayout;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.a.removeAllViews();
        if (this.a.getParent() != null) {
            ((ViewGroup) this.a.getParent()).removeView(this.a);
        }
    }
}

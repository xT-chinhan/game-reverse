package com.smartdigimkt.n1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class n1 extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;

    public n1(View view) {
        this.a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        View view = this.a;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}

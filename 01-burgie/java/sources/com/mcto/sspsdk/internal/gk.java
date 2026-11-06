package com.mcto.sspsdk.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class gk extends AnimatorListenerAdapter {
    public final /* synthetic */ FrameLayout a;
    public final /* synthetic */ View b;

    public gk(FrameLayout frameLayout, View view) {
        this.a = frameLayout;
        this.b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.a.setBackgroundColor(0);
        if (this.b.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
    }
}

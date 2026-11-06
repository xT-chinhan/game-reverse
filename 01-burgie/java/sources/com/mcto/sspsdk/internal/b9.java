package com.mcto.sspsdk.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class b9 extends AnimatorListenerAdapter {
    public final /* synthetic */ LinearLayout a;
    public final /* synthetic */ d9 b;

    public b9(d9 d9Var, LinearLayout linearLayout) {
        this.b = d9Var;
        this.a = linearLayout;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.b.q = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        d9 d9Var = this.b;
        d9Var.q = null;
        if (d9Var.n) {
            return;
        }
        d9.a(d9Var, this.a);
        d9 d9Var2 = this.b;
        int i = d9Var2.a;
        if (i > 0) {
            d9Var2.l = new a9(this, ((long) i) * 1000);
            a9 a9Var = this.b.l;
            synchronized (a9Var) {
                a9Var.c();
            }
        }
    }
}

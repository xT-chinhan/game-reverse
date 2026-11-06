package com.onevcat.uniwebview;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes3.dex */
public final class L implements Animation.AnimationListener {
    public final /* synthetic */ N a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;

    public L(N n, boolean z, String str) {
        this.a = n;
        this.b = z;
        this.c = str;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        c2 c2Var;
        String name;
        d2 d2Var;
        N n = this.a;
        n.j = null;
        boolean z = this.b;
        String str = this.c;
        if (z) {
            c2Var = n.c;
            name = n.p.getName();
            d2Var = d2.ShowTransitionFinished;
        } else {
            n.e.setVisibility(4);
            c2Var = n.c;
            name = n.p.getName();
            d2Var = d2.HideTransitionFinished;
        }
        c2Var.a(name, d2Var, str);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}

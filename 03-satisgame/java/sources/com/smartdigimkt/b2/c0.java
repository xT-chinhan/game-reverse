package com.smartdigimkt.b2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends AnimatorListenerAdapter {
    public final /* synthetic */ d0 a;

    public c0(d0 d0Var) {
        this.a = d0Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        int iIndexOfChild;
        super.onAnimationRepeat(animator);
        try {
            g0 g0Var = this.a.a;
            if (g0Var.j == null || !g0Var.a()) {
                return;
            }
            com.smartdigimkt.o3.d.a(this.a.a.j);
            g0 g0Var2 = this.a.a;
            RelativeLayout relativeLayout = (RelativeLayout) g0Var2.d.findViewById(com.smartdigimkt.r4.k.a(g0Var2.a, "myoffer_end_card_id", "id"));
            if (relativeLayout != null) {
                relativeLayout.addView(this.a.a.j);
            } else {
                g0 g0Var3 = this.a.a;
                View view = g0Var3.g;
                if (view == null || g0Var3.d.indexOfChild(view) <= 0) {
                    iIndexOfChild = -1;
                } else {
                    g0 g0Var4 = this.a.a;
                    iIndexOfChild = g0Var4.d.indexOfChild(g0Var4.g);
                }
                g0 g0Var5 = this.a.a;
                g0Var5.d.addView(g0Var5.j, iIndexOfChild);
            }
            this.a.a.j.setAlpha(0.2f);
            this.a.a.j.setVisibility(0);
            this.a.a.i.setVisibility(8);
        } catch (Throwable unused) {
        }
    }
}

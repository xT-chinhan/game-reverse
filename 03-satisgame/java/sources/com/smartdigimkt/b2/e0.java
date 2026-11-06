package com.smartdigimkt.b2;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 implements View.OnClickListener {
    public final /* synthetic */ g0 a;

    public e0(g0 g0Var) {
        this.a = g0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        g0 g0Var = this.a;
        if (g0Var.h != null) {
            this.a.h.a(1, com.smartdigimkt.z.c0.b(g0Var.b, g0Var.c) ? 1 : 5);
        }
    }
}

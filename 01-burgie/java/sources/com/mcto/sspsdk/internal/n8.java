package com.mcto.sspsdk.internal;

import android.os.SystemClock;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class n8 implements View.OnClickListener {
    public final /* synthetic */ p8 a;

    public n8(p8 p8Var) {
        this.a = p8Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a4 a4Var = new a4();
        a4Var.b = z3.GRAPHIC;
        a4Var.c = this.a.h() + "_graphic";
        a4Var.a = view;
        a4Var.g = SystemClock.elapsedRealtime() - this.a.j;
        a4Var.e = gj.a(view);
        b4 b4Var = new b4(a4Var);
        re reVar = this.a.e;
        if (reVar != null) {
            reVar.a.b(b4Var);
        }
    }
}

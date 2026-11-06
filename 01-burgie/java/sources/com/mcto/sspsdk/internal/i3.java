package com.mcto.sspsdk.internal;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class i3 implements View.OnClickListener {
    public final /* synthetic */ z3 a;
    public final /* synthetic */ n3 b;

    public i3(n3 n3Var, z3 z3Var) {
        this.b = n3Var;
        this.a = z3Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        n3.a(this.b, this.a, view);
    }
}

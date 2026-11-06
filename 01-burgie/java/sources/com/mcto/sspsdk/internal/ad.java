package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.component.interaction.QyTwistView;

/* JADX INFO: loaded from: classes2.dex */
public final class ad implements m7 {
    public final /* synthetic */ QyTwistView a;
    public final /* synthetic */ bd b;

    public ad(bd bdVar, QyTwistView qyTwistView) {
        this.b = bdVar;
        this.a = qyTwistView;
    }

    @Override // com.mcto.sspsdk.internal.m7
    public final void a() {
        bd bdVar = this.b;
        z3 z3Var = z3.TWIST;
        QyTwistView qyTwistView = this.a;
        bdVar.getClass();
        a4 a4Var = new a4();
        a4Var.b = z3Var;
        a4Var.a = qyTwistView;
        a4Var.e = gj.a(qyTwistView);
        bdVar.o.a.b(new b4(a4Var));
    }
}

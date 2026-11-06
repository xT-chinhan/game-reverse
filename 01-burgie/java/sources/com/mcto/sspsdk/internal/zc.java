package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.component.interaction.QySharkView;

/* JADX INFO: loaded from: classes2.dex */
public final class zc extends td {
    public final /* synthetic */ QySharkView b;
    public final /* synthetic */ bd c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zc(bd bdVar, bd bdVar2, QySharkView qySharkView) {
        super(bdVar2);
        this.c = bdVar;
        this.b = qySharkView;
    }

    @Override // com.mcto.sspsdk.internal.m7
    public final void a() {
        bd bdVar = this.c;
        z3 z3Var = z3.SHAKE;
        QySharkView qySharkView = this.b;
        bdVar.getClass();
        a4 a4Var = new a4();
        a4Var.b = z3Var;
        a4Var.a = qySharkView;
        a4Var.e = gj.a(qySharkView);
        bdVar.o.a.b(new b4(a4Var));
    }
}

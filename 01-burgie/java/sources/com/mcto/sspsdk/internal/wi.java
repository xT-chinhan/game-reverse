package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class wi extends td {
    public final /* synthetic */ xi b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wi(xi xiVar) {
        super(xiVar);
        this.b = xiVar;
    }

    @Override // com.mcto.sspsdk.internal.m7
    public final void a() {
        xi xiVar = this.b;
        gi giVar = xiVar.e;
        if (giVar != null) {
            z3 z3Var = xiVar.f ? z3.SHAKE_TEMPLATE : z3.SHAKE;
            a4 a4Var = new a4();
            a4Var.a = xiVar.g;
            a4Var.b = z3Var;
            giVar.a(new b4(a4Var));
        }
    }
}

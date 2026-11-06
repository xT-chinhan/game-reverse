package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class aj implements m7 {
    public final /* synthetic */ bj a;

    public aj(bj bjVar) {
        this.a = bjVar;
    }

    @Override // com.mcto.sspsdk.internal.m7
    public final void a() {
        bj bjVar = this.a;
        gi giVar = bjVar.e;
        if (giVar != null) {
            z3 z3Var = bjVar.f ? z3.TWIST_TEMPLATE : z3.TWIST;
            a4 a4Var = new a4();
            a4Var.a = bjVar.g;
            a4Var.b = z3Var;
            giVar.a(new b4(a4Var));
        }
    }
}

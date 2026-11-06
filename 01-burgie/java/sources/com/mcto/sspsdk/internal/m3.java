package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class m3 extends td {
    public final boolean b;
    public final /* synthetic */ n3 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m3(n3 n3Var, boolean z) {
        super(n3Var.c);
        this.c = n3Var;
        this.b = z;
    }

    @Override // com.mcto.sspsdk.internal.m7
    public final void a() {
        n3 n3Var = this.c;
        n3.a(n3Var, this.b ? z3.SHAKE_TEMPLATE : z3.SHAKE, n3Var.c);
    }
}

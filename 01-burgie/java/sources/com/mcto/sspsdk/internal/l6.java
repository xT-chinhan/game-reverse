package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class l6 implements k7 {
    public final /* synthetic */ t6 a;
    public final /* synthetic */ ea b;
    public final /* synthetic */ p c;

    public l6(t6 t6Var, ea eaVar, p pVar) {
        this.a = t6Var;
        this.b = eaVar;
        this.c = pVar;
    }

    @Override // com.mcto.sspsdk.internal.k7
    public final void a(Object obj) {
        this.a.a(this.b);
    }

    @Override // com.mcto.sspsdk.internal.k7
    public final void onError(int i, String str) {
        t6 t6Var = this.a;
        vh vhVar = this.c.c;
        t6Var.a(i, str);
    }
}

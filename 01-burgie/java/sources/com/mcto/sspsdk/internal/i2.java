package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class i2 implements u3 {
    public final /* synthetic */ j2 a;

    public i2(j2 j2Var) {
        this.a = j2Var;
    }

    @Override // com.mcto.sspsdk.internal.u3
    public final void a() {
        j2 j2Var = this.a;
        j2Var.A = false;
        if (j2Var.t.c == 4) {
            j2Var.a();
        }
    }

    @Override // com.mcto.sspsdk.internal.u3
    public final void b() {
        j2 j2Var = this.a;
        j2Var.A = true;
        int i = j2Var.t.c;
        if (i == 2 || i == 5) {
            j2Var.a(j2Var.b());
        }
    }
}

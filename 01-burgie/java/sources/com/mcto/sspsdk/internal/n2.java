package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class n2 implements w3 {
    public final /* synthetic */ p2 a;

    public n2(p2 p2Var) {
        this.a = p2Var;
    }

    @Override // com.mcto.sspsdk.internal.w3
    public final void a(Object obj) {
        if (((Integer) obj).intValue() == 1) {
            p2 p2Var = this.a;
            if (p2Var.r == null) {
                p2Var.r = new l3(p2Var);
            }
            l3 l3Var = p2Var.r;
            p pVar = p2Var.d;
            l3Var.b();
            return;
        }
        p2 p2Var2 = this.a;
        if (p2Var2.r == null) {
            p2Var2.r = new l3(p2Var2);
        }
        l3 l3Var2 = p2Var2.r;
        p pVar2 = p2Var2.d;
        l3Var2.a(0, 0);
    }
}

package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class ke implements w3 {
    public final /* synthetic */ ve a;

    public ke(ve veVar) {
        this.a = veVar;
    }

    @Override // com.mcto.sspsdk.internal.w3
    public final void a(Object obj) {
        re reVar;
        int i = ((w5) obj).a;
        if (i == 0 || i == 8) {
            this.a.h0 = 4;
            ve.a(this.a);
            ve veVar = this.a;
            veVar.g.a(4, veVar.z);
            return;
        }
        ve veVar2 = this.a;
        p pVar = veVar2.c;
        c cVar = veVar2.f.T;
        synchronized (veVar2) {
            reVar = veVar2.C;
            if (reVar == null) {
                reVar = new re(veVar2);
                veVar2.C = reVar;
            }
        }
        m8 m8Var = new m8(veVar2, pVar, cVar, reVar);
        j7 j7Var = veVar2.D;
        if (j7Var != null) {
            j7Var.destroy();
        }
        veVar2.D = m8Var;
        m8Var.i();
        this.a.h0 = 5;
        ve veVar3 = this.a;
        veVar3.g.a(5, veVar3.z);
        fc.a(this.a.b, "金币下发失败，请点击下方按钮手动领取。", 3000);
    }
}

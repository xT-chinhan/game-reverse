package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class li implements qa {
    public final /* synthetic */ pi a;

    public li(pi piVar) {
        this.a = piVar;
    }

    @Override // com.mcto.sspsdk.internal.qa
    public final void a(b4 b4Var) {
        pi.a(this.a, b4Var);
    }

    @Override // com.mcto.sspsdk.internal.qa
    public final void a(int i) {
        if (1 == i) {
            this.a.j.d();
            pi piVar = this.a;
            fj fjVar = piVar.j;
            d8 d8Var = new d8();
            d8Var.a = fjVar;
            d8Var.c = 100;
            d8Var.b = 50;
            u5 u5Var = new u5(piVar.a, d8Var);
            piVar.j.addView(u5Var);
            u5Var.f = new ni(piVar);
            u5Var.a = true;
            if (!u5Var.b) {
                u5Var.a();
            }
        }
        pi piVar2 = this.a;
        ai aiVar = piVar2.l;
        if (aiVar != null) {
            if (i != 1 || piVar2.j == null) {
                aiVar.a.a(9);
                return;
            }
            di diVar = aiVar.a;
            if (diVar.a != null && diVar.e.compareAndSet(false, true)) {
                diVar.d.post(new bi(diVar, piVar2));
            }
        }
    }
}

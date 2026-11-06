package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class te extends p7 {
    public final /* synthetic */ ve a;

    public te(ve veVar) {
        this.a = veVar;
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [android.support.v7.app.AppCompatActivity, com.mcto.sspsdk.internal.o7] */
    @Override // com.mcto.sspsdk.internal.p7
    public final void a(int i, int i2) {
        if (this.a.M.get()) {
            ve veVar = this.a;
            if (veVar.t) {
                veVar.d(0);
            }
            this.a.f();
            this.a.B.a(4, "play error");
        }
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void b(p pVar) {
        this.a.m();
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void a(p pVar) {
        this.a.k();
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void a(p pVar, long j, long j2) {
        ve veVar = this.a;
        int i = (int) j2;
        veVar.i.a(i);
        veVar.u = i / 1000;
        veVar.a(((i * 100) + 10) / ((int) j), true);
        if (veVar.u >= veVar.z) {
            veVar.d(0);
        }
        p pVar2 = veVar.c;
        if (pVar2.q0 == 1 && i >= (veVar.z * 1000) - pVar2.r0) {
            veVar.c(0);
        }
        l lVarA = l.a();
        p pVar3 = veVar.c;
        lVarA.getClass();
        l.b(i, pVar3);
        veVar.e(veVar.u);
    }
}

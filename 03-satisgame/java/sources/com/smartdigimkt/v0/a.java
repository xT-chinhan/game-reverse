package com.smartdigimkt.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements f0 {
    public final f0 a;
    public boolean b;
    public final /* synthetic */ b c;

    public a(b bVar, f0 f0Var) {
        this.c = bVar;
        this.a = f0Var;
    }

    @Override // com.smartdigimkt.v0.f0
    public final boolean a() {
        return this.c.d == -9223372036854775807L && this.a.a();
    }

    @Override // com.smartdigimkt.v0.f0
    public final void b() {
        this.a.b();
    }

    @Override // com.smartdigimkt.v0.f0
    public final int a(com.smartdigimkt.i0.t tVar, com.smartdigimkt.l0.e eVar, boolean z) {
        if (this.c.d != -9223372036854775807L) {
            return -3;
        }
        if (this.b) {
            eVar.a = 4;
            return -4;
        }
        int iA = this.a.a(tVar, eVar, z);
        if (iA == -5) {
            com.smartdigimkt.i0.s sVar = tVar.a;
            if (sVar.v != 0 || sVar.w != 0) {
                this.c.getClass();
                tVar.a = new com.smartdigimkt.i0.s(sVar.a, sVar.e, sVar.f, sVar.c, sVar.b, sVar.g, sVar.k, sVar.l, sVar.m, sVar.n, sVar.o, sVar.q, sVar.p, sVar.r, sVar.s, sVar.t, sVar.u, sVar.v, this.c.e != Long.MIN_VALUE ? 0 : sVar.w, sVar.x, sVar.y, sVar.z, sVar.j, sVar.h, sVar.i, sVar.d);
            }
            return -5;
        }
        b bVar = this.c;
        long j = bVar.e;
        if (j == Long.MIN_VALUE || ((iA != -4 || eVar.c < j) && !(iA == -3 && bVar.d() == Long.MIN_VALUE))) {
            return iA;
        }
        eVar.a();
        eVar.a = 4;
        this.b = true;
        return -4;
    }

    @Override // com.smartdigimkt.v0.f0
    public final int a(long j) {
        if (this.c.d != -9223372036854775807L) {
            return -3;
        }
        return this.a.a(j);
    }
}

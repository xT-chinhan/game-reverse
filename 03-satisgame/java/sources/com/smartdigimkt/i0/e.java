package com.smartdigimkt.i0;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.smartdigimkt.z0.h {
    public final com.smartdigimkt.z0.o a = new com.smartdigimkt.z0.o();
    public final d b;
    public a c;
    public com.smartdigimkt.z0.h d;

    public e(d dVar) {
        this.b = dVar;
    }

    @Override // com.smartdigimkt.z0.h
    public final a0 a(a0 a0Var) {
        com.smartdigimkt.z0.h hVar = this.d;
        if (hVar != null) {
            a0Var = hVar.a(a0Var);
        }
        this.a.a(a0Var);
        ((p) this.b).a(a0Var);
        return a0Var;
    }

    @Override // com.smartdigimkt.z0.h
    public final long b() {
        a aVar = this.c;
        return (aVar == null || aVar.d() || (!this.c.e() && this.c.g)) ? this.a.b() : this.d.b();
    }

    @Override // com.smartdigimkt.z0.h
    public final a0 a() {
        com.smartdigimkt.z0.h hVar = this.d;
        return hVar != null ? hVar.a() : this.a.e;
    }
}

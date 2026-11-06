package com.anythink.basead.exoplayer;

/* JADX INFO: loaded from: classes.dex */
final class e implements com.anythink.basead.exoplayer.k.n {
    private final com.anythink.basead.exoplayer.k.z a;
    private final a b;
    private y c;
    private com.anythink.basead.exoplayer.k.n d;

    public interface a {
        void a(v vVar);
    }

    public e(a aVar, com.anythink.basead.exoplayer.k.c cVar) {
        this.b = aVar;
        this.a = new com.anythink.basead.exoplayer.k.z(cVar);
    }

    public final void a() {
        this.a.a();
    }

    public final void b() {
        this.a.b();
    }

    public final void a(long j) {
        this.a.a(j);
    }

    public final void a(y yVar) throws g {
        com.anythink.basead.exoplayer.k.n nVar;
        com.anythink.basead.exoplayer.k.n nVarC = yVar.c();
        if (nVarC == null || nVarC == (nVar = this.d)) {
            return;
        }
        if (nVar != null) {
            throw g.a(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.d = nVarC;
        this.c = yVar;
        nVarC.a(this.a.e());
        f();
    }

    public final void b(y yVar) {
        if (yVar == this.c) {
            this.d = null;
            this.c = null;
        }
    }

    public final long c() {
        if (g()) {
            f();
            return this.d.d();
        }
        return this.a.d();
    }

    @Override // com.anythink.basead.exoplayer.k.n
    public final long d() {
        if (g()) {
            return this.d.d();
        }
        return this.a.d();
    }

    @Override // com.anythink.basead.exoplayer.k.n
    public final v a(v vVar) {
        com.anythink.basead.exoplayer.k.n nVar = this.d;
        if (nVar != null) {
            vVar = nVar.a(vVar);
        }
        this.a.a(vVar);
        this.b.a(vVar);
        return vVar;
    }

    @Override // com.anythink.basead.exoplayer.k.n
    public final v e() {
        com.anythink.basead.exoplayer.k.n nVar = this.d;
        return nVar != null ? nVar.e() : this.a.e();
    }

    private void f() {
        this.a.a(this.d.d());
        v vVarE = this.d.e();
        if (vVarE.equals(this.a.e())) {
            return;
        }
        this.a.a(vVarE);
        this.b.a(vVarE);
    }

    private boolean g() {
        y yVar = this.c;
        if (yVar == null || yVar.v()) {
            return false;
        }
        return this.c.u() || !this.c.g();
    }
}

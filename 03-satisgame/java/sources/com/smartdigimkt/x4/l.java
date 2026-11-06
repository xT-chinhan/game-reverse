package com.smartdigimkt.x4;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements com.smartdigimkt.j1.f {
    public final /* synthetic */ com.smartdigimkt.h3.b a;
    public final /* synthetic */ com.smartdigimkt.v4.a b;
    public final /* synthetic */ com.smartdigimkt.k1.d c;
    public final /* synthetic */ m d;

    public l(m mVar, com.smartdigimkt.h3.b bVar, com.smartdigimkt.v4.a aVar, com.smartdigimkt.k1.d dVar) {
        this.d = mVar;
        this.a = bVar;
        this.b = aVar;
        this.c = dVar;
    }

    @Override // com.smartdigimkt.j1.f
    public final void a() {
        com.smartdigimkt.h3.b bVar = this.a;
        if (bVar != null) {
            bVar.a("offer");
            this.a.d("resource");
        }
    }

    @Override // com.smartdigimkt.j1.f
    public final void b() {
        m mVar = this.d;
        com.smartdigimkt.v4.a aVar = this.b;
        mVar.getClass();
        com.smartdigimkt.h3.b bVar = aVar.x;
        if (bVar != null) {
            if (bVar.a("offer")) {
                bVar.d("resource");
            }
            bVar.a("resource");
        }
        if (!this.c.d()) {
            this.b.a(com.smartdigimkt.z3.b.a(com.anythink.core.common.inner.b.b.d, "load fill but ad not ready."));
            this.d.d(this.b);
            return;
        }
        com.smartdigimkt.v4.d dVar = new com.smartdigimkt.v4.d();
        dVar.a = this.c;
        com.smartdigimkt.v4.a aVar2 = this.b;
        aVar2.u = dVar;
        this.d.e(aVar2);
    }

    @Override // com.smartdigimkt.j1.f
    public final void a(com.smartdigimkt.h0.g gVar) {
        m mVar = this.d;
        com.smartdigimkt.v4.a aVar = this.b;
        mVar.getClass();
        m.f(aVar);
        this.b.a(com.smartdigimkt.z3.b.a("10010", gVar.a()));
        this.d.d(this.b);
    }
}

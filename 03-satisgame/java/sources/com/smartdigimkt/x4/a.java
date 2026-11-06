package com.smartdigimkt.x4;

import android.os.SystemClock;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.smartdigimkt.j1.f {
    public final /* synthetic */ com.smartdigimkt.h3.b a;
    public final /* synthetic */ com.smartdigimkt.v4.a b;
    public final /* synthetic */ com.smartdigimkt.e1.d c;
    public final /* synthetic */ b d;

    public a(b bVar, com.smartdigimkt.h3.b bVar2, com.smartdigimkt.v4.a aVar, com.smartdigimkt.e1.d dVar) {
        this.d = bVar;
        this.a = bVar2;
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
        com.smartdigimkt.w4.a aVar;
        com.smartdigimkt.b3.e eVar;
        b bVar = this.d;
        com.smartdigimkt.v4.a aVar2 = this.b;
        bVar.getClass();
        com.smartdigimkt.h3.b bVar2 = aVar2.x;
        if (bVar2 != null) {
            if (bVar2.a("offer")) {
                bVar2.d("resource");
            }
            bVar2.a("resource");
        }
        com.smartdigimkt.n3.t.a(this.b, true);
        com.smartdigimkt.e1.d dVar = this.c;
        boolean z = false;
        if (!dVar.a(dVar.b())) {
            this.b.a(com.smartdigimkt.z3.b.a(com.anythink.core.common.inner.b.b.d, "load fill but ad not ready."));
            com.smartdigimkt.v4.a aVar3 = this.b;
            com.smartdigimkt.e1.d dVar2 = this.c;
            aVar3.j = dVar2.m;
            aVar3.k = dVar2.n;
            com.smartdigimkt.n3.t.a(aVar3, false);
            this.d.d(this.b);
            return;
        }
        com.smartdigimkt.v4.d dVar3 = new com.smartdigimkt.v4.d();
        com.smartdigimkt.e1.d dVar4 = this.c;
        dVar3.a = dVar4;
        com.smartdigimkt.v4.a aVar4 = this.b;
        aVar4.u = dVar3;
        com.smartdigimkt.f3.a aVar5 = aVar4.v;
        if (aVar5 != null && (aVar = aVar4.i) != null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aVar5.e0 = System.currentTimeMillis() - aVar.a;
            aVar5.g0 = jElapsedRealtime;
            aVar5.f0 = System.currentTimeMillis() - aVar.a;
            aVar5.h0 = jElapsedRealtime;
            aVar5.i0 = com.smartdigimkt.z.c0.a(dVar4.e, dVar4.c);
            try {
                com.smartdigimkt.b3.b bVar3 = dVar4.e;
                if (bVar3 != null && (eVar = bVar3.w) != null) {
                    com.smartdigimkt.b3.d dVar5 = eVar.R1;
                    if (dVar5 != null) {
                        long j = dVar5.a;
                        if (j > 0) {
                            com.smartdigimkt.a3.a aVar6 = dVar4.c;
                            aVar5.a(j, bVar3, aVar6);
                            long j2 = aVar5.l0;
                            if (aVar6 != null && aVar6.c == 1 && com.smartdigimkt.b3.h.a(j2) && (!com.smartdigimkt.b3.q.a || !com.smartdigimkt.b3.h.a(j2))) {
                                z = true;
                            }
                            aVar5.n0 = z;
                        }
                    }
                    int i = bVar3.w.s1;
                    String strValueOf = i > 0 ? String.valueOf(i) : "";
                    aVar5.E0 = strValueOf != null ? strValueOf : "";
                }
            } catch (Throwable unused) {
            }
        }
        com.smartdigimkt.v4.a aVar7 = this.b;
        com.smartdigimkt.e1.d dVar6 = this.c;
        aVar7.j = dVar6.m;
        aVar7.k = dVar6.n;
        com.smartdigimkt.n3.e.a(SDKContext.getInstance().d()).a(2, this.b.v, -1L);
        if (this.b.m != 1) {
            com.smartdigimkt.n3.e.a(SDKContext.getInstance().d()).a(12, this.b.v, -1L);
        }
        this.d.e(this.b);
    }

    @Override // com.smartdigimkt.j1.f
    public final void a(com.smartdigimkt.h0.g gVar) {
        b bVar = this.d;
        com.smartdigimkt.v4.a aVar = this.b;
        bVar.getClass();
        b.f(aVar);
        com.smartdigimkt.n3.t.a(this.b, false);
        this.b.a(com.smartdigimkt.z3.b.a("10010", gVar.a()));
        com.smartdigimkt.v4.a aVar2 = this.b;
        com.smartdigimkt.e1.d dVar = this.c;
        aVar2.j = dVar.m;
        aVar2.k = dVar.n;
        this.d.d(aVar2);
    }
}

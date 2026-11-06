package com.smartdigimkt.e1;

import com.smartdigimkt.z.c0;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.smartdigimkt.j1.f {
    public final /* synthetic */ com.smartdigimkt.j1.f a;
    public final /* synthetic */ d b;

    public b(d dVar, com.smartdigimkt.x4.a aVar) {
        this.b = dVar;
        this.a = aVar;
    }

    @Override // com.smartdigimkt.j1.f
    public final void a() {
        com.smartdigimkt.j1.f fVar = this.a;
        if (fVar != null) {
            fVar.a();
        }
    }

    @Override // com.smartdigimkt.j1.f
    public final void b() {
        com.smartdigimkt.f3.a aVar;
        d dVar = this.b;
        Map map = dVar.h;
        if (map != null) {
            map.put(com.anythink.core.bridge.a.b.a, Integer.valueOf(c0.a(dVar.e, dVar.c)));
            com.smartdigimkt.b3.b bVar = dVar.e;
            if (bVar != null && (aVar = dVar.l) != null && aVar.v) {
                dVar.h.put(com.anythink.core.bridge.a.b.m, bVar.c);
                dVar.h.put(com.anythink.core.bridge.a.b.n, dVar.e.d);
                dVar.h.put(com.anythink.core.bridge.a.b.o, dVar.e.T);
                dVar.h.put(com.anythink.core.bridge.a.b.p, dVar.e.i);
                dVar.h.put(com.anythink.core.bridge.a.b.q, dVar.e.l);
                dVar.h.put(com.anythink.core.bridge.a.b.r, dVar.e.m);
            }
        }
        com.smartdigimkt.j1.f fVar = this.a;
        if (fVar != null) {
            fVar.b();
        }
    }

    @Override // com.smartdigimkt.j1.f
    public final void a(com.smartdigimkt.h0.g gVar) {
        com.smartdigimkt.j1.f fVar = this.a;
        if (fVar != null) {
            fVar.a(gVar);
        }
    }
}

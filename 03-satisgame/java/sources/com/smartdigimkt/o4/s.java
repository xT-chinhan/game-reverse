package com.smartdigimkt.o4;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class s {
    public final Object b = new Object();
    public final ConcurrentHashMap a = new ConcurrentHashMap();

    public final void a(com.smartdigimkt.g4.l lVar, q qVar) {
        String str = lVar.c;
        synchronized (this.b) {
            com.smartdigimkt.f4.n nVar = (com.smartdigimkt.f4.n) this.a.get(lVar.c);
            if (nVar != null) {
                nVar.a((com.smartdigimkt.a4.b) qVar);
                return;
            }
            com.smartdigimkt.f4.n nVar2 = new com.smartdigimkt.f4.n(lVar);
            this.a.put(str, nVar2);
            nVar2.a((com.smartdigimkt.a4.b) new r(str, qVar, this.a));
            nVar2.a(0, (com.smartdigimkt.a4.b) new com.smartdigimkt.f4.i(nVar2));
        }
    }
}

package com.smartdigimkt.v0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements Runnable {
    public final /* synthetic */ com.smartdigimkt.j0.c a;
    public final /* synthetic */ x b;

    public o(x xVar, com.smartdigimkt.j0.c cVar) {
        this.b = xVar;
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.j0.c cVar = this.a;
        x xVar = this.b;
        int i = xVar.a;
        m mVar = xVar.b;
        com.smartdigimkt.j0.a aVar = cVar.d;
        aVar.a.add(new com.smartdigimkt.j0.b(i, mVar));
        if (aVar.a.size() == 1 && !aVar.e.c() && !aVar.a.isEmpty()) {
            aVar.c = (com.smartdigimkt.j0.b) aVar.a.get(0);
        }
        cVar.a(i, mVar);
        Iterator it = cVar.a.iterator();
        if (it.hasNext()) {
            throw com.smartdigimkt.x.d.a(it);
        }
    }
}

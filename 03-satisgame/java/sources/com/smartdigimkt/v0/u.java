package com.smartdigimkt.v0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements Runnable {
    public final /* synthetic */ com.smartdigimkt.j0.c a;
    public final /* synthetic */ x b;

    public u(x xVar, com.smartdigimkt.j0.c cVar) {
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
        aVar.getClass();
        aVar.d = new com.smartdigimkt.j0.b(i, mVar);
        cVar.a(i, mVar);
        Iterator it = cVar.a.iterator();
        if (it.hasNext()) {
            com.smartdigimkt.a.a.a(it.next());
            throw null;
        }
    }
}

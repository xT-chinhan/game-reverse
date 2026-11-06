package com.smartdigimkt.v0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements Runnable {
    public final /* synthetic */ com.smartdigimkt.j0.c a;
    public final /* synthetic */ x b;

    public s(x xVar, com.smartdigimkt.j0.c cVar, y yVar, z zVar) {
        this.b = xVar;
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.j0.c cVar = this.a;
        x xVar = this.b;
        cVar.a(xVar.a, xVar.b);
        Iterator it = cVar.a.iterator();
        if (it.hasNext()) {
            com.smartdigimkt.a.a.a(it.next());
            throw null;
        }
    }
}

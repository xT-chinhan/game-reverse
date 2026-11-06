package com.smartdigimkt.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements Runnable {
    public final /* synthetic */ com.smartdigimkt.j0.c a;
    public final /* synthetic */ x b;

    public p(x xVar, com.smartdigimkt.j0.c cVar) {
        this.b = xVar;
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.j0.c cVar = this.a;
        x xVar = this.b;
        cVar.b(xVar.a, xVar.b);
    }
}

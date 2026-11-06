package com.smartdigimkt.j;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Runnable {
    public final /* synthetic */ com.smartdigimkt.b3.c a;
    public final /* synthetic */ u b;

    public j(u uVar, com.smartdigimkt.b3.c cVar) {
        this.b = uVar;
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.b3.e eVar;
        com.smartdigimkt.b3.c cVar = this.a;
        if (cVar == null || (eVar = cVar.w) == null || eVar.m1 != 1) {
            return;
        }
        this.b.j.put(cVar.m, cVar);
        u.a(this.b);
    }
}

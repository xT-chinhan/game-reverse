package com.smartdigimkt.d0;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements com.smartdigimkt.m3.b {
    public final /* synthetic */ n a;

    public k(n nVar) {
        this.a = nVar;
    }

    @Override // com.smartdigimkt.m3.b
    public final boolean a() {
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar = this.a;
        com.smartdigimkt.b3.e eVar = nVar.d.f.w;
        String str = eVar != null ? eVar.t1 : "";
        if (nVar.a) {
            return;
        }
        nVar.a = true;
        com.smartdigimkt.m3.g.a().a(nVar.b);
        q qVar = nVar.d;
        com.smartdigimkt.n3.k.a(qVar.f, qVar.h, false, System.currentTimeMillis() - nVar.c, 7, "h5 template load timeout", 0L, str);
        nVar.d.a(5);
    }
}

package com.smartdigimkt.t4;

import android.content.Context;
import com.smartdigimkt.sdk.api.SDMAdRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements Runnable {
    public final /* synthetic */ com.smartdigimkt.h3.b a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ int c;
    public final /* synthetic */ SDMAdRequest d;
    public final /* synthetic */ p e;
    public final /* synthetic */ n f;

    public m(n nVar, com.smartdigimkt.h3.b bVar, Context context, int i, SDMAdRequest sDMAdRequest, p pVar) {
        this.f = nVar;
        this.a = bVar;
        this.b = context;
        this.c = i;
        this.d = sDMAdRequest;
        this.e = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.h3.b bVar = this.a;
        if (bVar != null) {
            bVar.a("entryQueue");
        }
        n nVar = this.f;
        com.smartdigimkt.r4.w.a(nVar.b, com.smartdigimkt.r4.j.a(String.valueOf(nVar.a)), "load", "start", "");
        com.smartdigimkt.x4.n nVar2 = new com.smartdigimkt.x4.n();
        com.smartdigimkt.x4.a0 a0Var = new com.smartdigimkt.x4.a0();
        nVar2.a = a0Var;
        com.smartdigimkt.x4.k kVar = new com.smartdigimkt.x4.k();
        a0Var.a = kVar;
        com.smartdigimkt.x4.x xVar = new com.smartdigimkt.x4.x();
        kVar.a = xVar;
        com.smartdigimkt.x4.d0 d0Var = new com.smartdigimkt.x4.d0();
        xVar.a = d0Var;
        com.smartdigimkt.x4.p pVar = new com.smartdigimkt.x4.p();
        d0Var.a = pVar;
        com.smartdigimkt.x4.h hVar = new com.smartdigimkt.x4.h();
        pVar.a = hVar;
        hVar.a = new com.smartdigimkt.x4.b();
        Context context = this.b;
        n nVar3 = this.f;
        com.smartdigimkt.v4.a aVar = new com.smartdigimkt.v4.a(context, nVar3.b, nVar3.a, this.c, this.d, this.e);
        aVar.a(this.a);
        nVar2.c(aVar);
    }
}

package com.smartdigimkt.t4;

import android.content.Context;
import com.smartdigimkt.sdk.api.SDMAdRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements Runnable {
    public final /* synthetic */ com.smartdigimkt.h3.b a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ int c;
    public final /* synthetic */ SDMAdRequest d;
    public final /* synthetic */ p e;
    public final /* synthetic */ r f;

    public q(r rVar, com.smartdigimkt.h3.b bVar, Context context, int i, SDMAdRequest sDMAdRequest, p pVar) {
        this.f = rVar;
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
            this.a.b("strategy");
            this.a.b("bidToken");
            this.a.b("bid");
        }
        r rVar = this.f;
        com.smartdigimkt.r4.w.a(rVar.b, com.smartdigimkt.r4.j.a(String.valueOf(rVar.a)), "load", "start", "");
        com.smartdigimkt.x4.n nVar = new com.smartdigimkt.x4.n();
        com.smartdigimkt.x4.a0 a0Var = new com.smartdigimkt.x4.a0();
        nVar.a = a0Var;
        com.smartdigimkt.x4.k kVar = new com.smartdigimkt.x4.k();
        a0Var.a = kVar;
        kVar.a = new com.smartdigimkt.x4.m();
        Context context = this.b;
        r rVar2 = this.f;
        com.smartdigimkt.v4.a aVar = new com.smartdigimkt.v4.a(context, rVar2.b, rVar2.a, this.c, this.d, this.e);
        aVar.a(this.a);
        nVar.c(aVar);
    }
}

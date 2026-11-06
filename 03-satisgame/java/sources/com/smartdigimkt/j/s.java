package com.smartdigimkt.j;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements Runnable {
    public final /* synthetic */ com.smartdigimkt.k.r a;
    public final /* synthetic */ u b;

    public s(u uVar, com.smartdigimkt.k.r rVar) {
        this.b = uVar;
        this.a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.b3.e eVar;
        com.smartdigimkt.k.r rVar = this.a;
        com.smartdigimkt.k.o oVar = this.b.o;
        if (oVar != null) {
            oVar.a(rVar, "at_offer_action_3");
        }
        com.smartdigimkt.b3.c cVar = this.a.j;
        if (cVar != null && (eVar = cVar.w) != null && eVar.m1 == 1) {
            u.a(this.b);
        }
        this.b.d(this.a);
        this.b.f(this.a);
    }
}

package com.smartdigimkt.k;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ n b;
    public final /* synthetic */ o c;

    public l(o oVar, String str, n nVar) {
        this.c = oVar;
        this.a = str;
        this.b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.z2.g gVar = this.c.b;
        if (gVar == null) {
            n nVar = this.b;
            if (nVar != null) {
                nVar.onCallback(null);
                return;
            }
            return;
        }
        com.smartdigimkt.b3.f fVarA = gVar.a(this.a);
        n nVar2 = this.b;
        if (nVar2 != null) {
            if (fVarA != null) {
                nVar2.onCallback(o.a(this.c, fVarA));
            } else {
                nVar2.onCallback(null);
            }
        }
    }
}

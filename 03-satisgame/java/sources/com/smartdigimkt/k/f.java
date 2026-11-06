package com.smartdigimkt.k;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {
    public final /* synthetic */ r a;
    public final /* synthetic */ o b;

    public f(o oVar, r rVar) {
        this.b = oVar;
        this.a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o oVar = this.b;
        com.smartdigimkt.z2.g gVar = oVar.b;
        if (gVar != null) {
            try {
                gVar.a(o.a(oVar, this.a));
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }
}

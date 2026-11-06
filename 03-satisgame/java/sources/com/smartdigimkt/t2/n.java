package com.smartdigimkt.t2;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ com.smartdigimkt.b3.c b;
    public final /* synthetic */ o c;

    public n(o oVar, String str, com.smartdigimkt.b3.b bVar) {
        this.c = oVar;
        this.a = str;
        this.b = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.c.e) {
            o oVar = this.c;
            String str = oVar.a;
            long jC = o.c();
            if (oVar.d != jC) {
                oVar.c.clear();
                oVar.d = jC;
            }
            q qVar = (q) this.c.c.get(this.a);
            if (qVar == null) {
                qVar = new q();
                this.c.c.put(this.a, qVar);
            }
            com.smartdigimkt.b3.c cVar = this.b;
            if (cVar instanceof com.smartdigimkt.b3.b) {
                qVar.a(((com.smartdigimkt.b3.b) cVar).c0);
            }
        }
        o.a(this.c, 6, this.a, this.b);
    }
}

package com.smartdigimkt.t2;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ com.smartdigimkt.b3.c b;
    public final /* synthetic */ o c;

    public m(o oVar, String str, com.smartdigimkt.b3.b bVar) {
        this.c = oVar;
        this.a = str;
        this.b = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o oVar = this.c;
        String str = oVar.a;
        synchronized (oVar.e) {
            o oVar2 = this.c;
            oVar2.getClass();
            long jC = o.c();
            if (oVar2.d != jC) {
                oVar2.c.clear();
                oVar2.d = jC;
            }
            q qVar = (q) this.c.c.get(this.a);
            if (qVar == null) {
                qVar = new q();
                this.c.c.put(this.a, qVar);
            }
            qVar.b(((com.smartdigimkt.b3.b) this.b).c0);
        }
        o.a(this.c, 4, this.a, this.b);
    }
}

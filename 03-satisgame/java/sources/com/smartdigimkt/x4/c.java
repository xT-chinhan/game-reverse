package com.smartdigimkt.x4;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ com.smartdigimkt.v4.a a;
    public final /* synthetic */ com.smartdigimkt.p4.g b;
    public final /* synthetic */ h c;

    public c(h hVar, com.smartdigimkt.v4.a aVar, com.smartdigimkt.p4.g gVar) {
        this.c = hVar;
        this.a = aVar;
        this.b = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.c.d.compareAndSet(false, true)) {
            this.c.e.set(true);
            h hVar = this.c;
            com.smartdigimkt.v4.a aVar = this.a;
            hVar.getClass();
            com.smartdigimkt.h3.b bVar = aVar.x;
            if (bVar != null) {
                boolean zA = bVar.a("bidToken");
                boolean zA2 = bVar.a("bid");
                if (zA && !zA2) {
                    bVar.b("bid");
                }
            }
            this.a.a(System.currentTimeMillis());
            this.a.a(com.smartdigimkt.z3.b.a("10007", ""));
            h hVar2 = this.c;
            com.smartdigimkt.v4.a aVar2 = this.a;
            hVar2.getClass();
            h.a("fail", aVar2);
            this.c.a(this.a, this.b, -3);
            this.c.d(this.a);
        }
    }
}

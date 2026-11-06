package com.smartdigimkt.a0;

/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public final com.smartdigimkt.b3.c a;
    public com.smartdigimkt.h0.m b;
    public final boolean c;
    public boolean d = false;
    public boolean e = false;

    public r(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar) {
        com.smartdigimkt.b3.e eVar;
        this.a = cVar;
        this.c = false;
        if (aVar == null || (eVar = aVar.s) == null) {
            return;
        }
        this.c = eVar.O != 2;
    }

    public final synchronized void a() {
        com.smartdigimkt.b3.e eVar;
        if (this.b == null) {
            return;
        }
        if (this.c || !this.d) {
            this.d = true;
            com.smartdigimkt.b3.c cVar = this.a;
            if (cVar == null || !(cVar instanceof com.smartdigimkt.b3.l) || !((com.smartdigimkt.b3.l) cVar).j() || (eVar = this.a.w) == null || eVar.C1 == 2) {
                com.smartdigimkt.z.s.a(9, this.a, this.b);
            }
        }
    }

    public final synchronized void b() {
        com.smartdigimkt.b3.e eVar;
        if (this.c || !this.e) {
            this.e = true;
            com.smartdigimkt.b3.c cVar = this.a;
            if (cVar == null || !(cVar instanceof com.smartdigimkt.b3.l) || !((com.smartdigimkt.b3.l) cVar).j() || (eVar = this.a.w) == null || eVar.C1 == 2) {
                com.smartdigimkt.z.s.a(24, this.a, this.b);
            }
        }
    }
}

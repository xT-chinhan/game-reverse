package com.smartdigimkt.b2;

import com.smartdigimkt.n1.y2;
import com.smartdigimkt.sdk.basead.ui.FullScreenATView;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements com.smartdigimkt.d2.c {
    public final /* synthetic */ p a;

    public n(p pVar) {
        this.a = pVar;
    }

    public final void a() {
        p pVar = this.a;
        com.smartdigimkt.a3.a aVar = pVar.c;
        com.smartdigimkt.b3.c cVar = pVar.b;
        long j = pVar.l;
        boolean z = pVar.m;
        long j2 = pVar.k;
        int i = pVar.o;
        com.smartdigimkt.f3.c cVar2 = new com.smartdigimkt.f3.c(String.valueOf(aVar.c), "66");
        cVar2.a = "1004733";
        cVar2.a(aVar);
        com.smartdigimkt.b3.e eVar = aVar.s;
        if (eVar != null) {
            cVar2.l = eVar.f1 == 2 ? "1" : "2";
            cVar2.q = String.valueOf(eVar.g1);
            cVar2.r = String.valueOf(aVar.s.h1);
            cVar2.t = String.valueOf(aVar.s.i1);
            long j3 = aVar.s.x;
            if (j3 <= 0) {
                j3 = 30000;
            }
            cVar2.u = String.valueOf(j3);
        }
        cVar2.m = String.valueOf(j);
        cVar2.n = String.valueOf(System.currentTimeMillis() - j);
        if (cVar instanceof com.smartdigimkt.b3.b) {
            cVar2.o = ((com.smartdigimkt.b3.b) cVar).c0;
            cVar2.p = cVar.a;
        }
        cVar2.s = z ? "1" : "2";
        cVar2.v = String.valueOf(j2);
        cVar2.w = String.valueOf(i);
        com.smartdigimkt.n3.k.a(cVar2);
        this.a.b();
    }

    public final void a(long j) {
        com.smartdigimkt.j1.v vVar;
        e eVar = this.a.h;
        if (eVar instanceof y2) {
            y2 y2Var = (y2) eVar;
            if (j > 0) {
                FullScreenATView fullScreenATView = y2Var.a;
                fullScreenATView.T = Math.max(0L, fullScreenATView.T - j);
                FullScreenATView fullScreenATView2 = y2Var.a;
                if (fullScreenATView2.W) {
                    return;
                }
                String str = FullScreenATView.TAG;
                fullScreenATView2.P();
                FullScreenATView fullScreenATView3 = y2Var.a;
                if (fullScreenATView3.T <= 0) {
                    fullScreenATView3.z();
                    return;
                }
                com.smartdigimkt.u1.d dVar = fullScreenATView3.n;
                if (dVar != null) {
                    long jA = dVar.a();
                    if (jA > 0) {
                        FullScreenATView fullScreenATView4 = y2Var.a;
                        if (jA >= fullScreenATView4.T) {
                            fullScreenATView4.z();
                            return;
                        } else {
                            fullScreenATView4.b(fullScreenATView4.n.a());
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            FullScreenATView fullScreenATView5 = y2Var.a;
            if (!fullScreenATView5.L0 && fullScreenATView5.T()) {
                com.smartdigimkt.n3.k.b(16, 53, fullScreenATView5.b, fullScreenATView5.c, com.smartdigimkt.b3.g.a(1), true);
                fullScreenATView5.L0 = true;
                if (!fullScreenATView5.f && (vVar = fullScreenATView5.t0) != null) {
                    vVar.c();
                }
            }
            FullScreenATView fullScreenATView6 = y2Var.a;
            if (fullScreenATView6.L0) {
                return;
            }
            fullScreenATView6.z();
            y2Var.a.c(1);
        }
    }
}

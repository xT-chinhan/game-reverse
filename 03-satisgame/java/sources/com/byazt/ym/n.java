package com.byazt.ym;

import com.anythink.core.common.l.b;
import com.byazt.cri.fs;
import com.byazt.pq.a;
import com.byazt.pq.bb;
import com.byazt.pq.h;
import com.byazt.pq.ln;
import com.byazt.pq.m;
import com.byazt.wa.cd;
import com.byazt.wa.d;
import com.byazt.wa.um;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1223, 19})
public final class n implements a {
    public final w n;

    public n(w wVar) {
        this.n = wVar;
    }

    @Override // com.byazt.pq.a
    public bb n(a.n nVar) throws IOException {
        w wVar = this.n;
        bb bbVarN = wVar != null ? wVar.n(nVar.n()) : null;
        s sVarN = new s.n(System.currentTimeMillis(), nVar.n(), bbVarN).n();
        h hVar = sVarN.n;
        bb bbVar = sVarN.qg;
        if (bbVarN != null && bbVar == null) {
            com.byazt.zho.s.n(bbVarN.rv());
        }
        if (hVar == null && bbVar == null) {
            return new bb.n().n(nVar.n()).n(m.HTTP_1_1).n(504).n("Unsatisfiable Request (only-if-cached)").n(com.byazt.zho.s.s).n(-1L).qg(System.currentTimeMillis()).n();
        }
        if (hVar == null) {
            return bbVar.tj().qg(n(bbVar)).n();
        }
        try {
            bb bbVarN2 = nVar.n(hVar);
            if (bbVarN2 == null && bbVarN != null) {
                com.byazt.zho.s.n(bbVarN.rv());
            }
            if (bbVar != null) {
                if (bbVarN2.q() == 304) {
                    bb bbVarN3 = bbVar.tj().n(n(bbVar.fs(), bbVarN2.fs())).n(bbVarN2.sz()).qg(bbVarN2.k()).qg(n(bbVar)).n(n(bbVarN2)).n();
                    bbVarN2.rv().close();
                    this.n.update(bbVar, bbVarN3);
                    return bbVarN3;
                }
                com.byazt.zho.s.n(bbVar.rv());
            }
            bb bbVarN4 = bbVarN2.tj().qg(n(bbVar)).n(n(bbVarN2)).n();
            if (this.n != null) {
                if (com.byazt.cri.l.s(bbVarN4) && s.n(bbVarN4, hVar)) {
                    return n(this.n.n(bbVarN4), bbVarN4);
                }
                com.byazt.cri.w.n(hVar.qg());
            }
            return bbVarN4;
        } catch (Throwable th) {
            if (bbVarN != null) {
                com.byazt.zho.s.n(bbVarN.rv());
            }
            throw th;
        }
    }

    private static bb n(bb bbVar) {
        return (bbVar == null || bbVar.rv() == null) ? bbVar : bbVar.tj().n((ln) null).n();
    }

    private bb n(final qg qgVar, bb bbVar) throws IOException {
        cd cdVarN;
        if (qgVar == null || (cdVarN = qgVar.n()) == null) {
            return bbVar;
        }
        final com.byazt.wa.l lVarS = bbVar.rv().s();
        final com.byazt.wa.q qVarN = d.n(cdVarN);
        return bbVar.tj().n(new fs(bbVar.qg(b.g), bbVar.rv().qg(), d.n(new um() { // from class: com.byazt.ym.n.1
            public boolean n;

            @Override // com.byazt.wa.um
            public long n(com.byazt.wa.s sVar, long j) throws IOException {
                try {
                    long jN = lVarS.n(sVar, j);
                    if (jN == -1) {
                        if (!this.n) {
                            this.n = true;
                            qVarN.close();
                        }
                        return -1L;
                    }
                    sVar.n(qVarN.s(), sVar.qg() - jN, jN);
                    qVarN.py();
                    return jN;
                } catch (IOException e) {
                    if (!this.n) {
                        this.n = true;
                    }
                    throw e;
                }
            }

            @Override // com.byazt.wa.um
            public com.byazt.wa.a n() {
                return lVarS.n();
            }

            @Override // com.byazt.wa.um, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.n && !com.byazt.zho.s.n(this, 100, TimeUnit.MILLISECONDS)) {
                    this.n = true;
                }
                lVarS.close();
            }
        }))).n();
    }

    private static com.byazt.pq.cd n(com.byazt.pq.cd cdVar, com.byazt.pq.cd cdVar2) {
        com.byazt.pq.cd.n nVar = new com.byazt.pq.cd.n();
        int iN = cdVar.n();
        for (int i = 0; i < iN; i++) {
            String strN = cdVar.n(i);
            String strQg = cdVar.qg(i);
            if ((!"Warning".equalsIgnoreCase(strN) || !strQg.startsWith("1")) && (!n(strN) || cdVar2.n(strN) == null)) {
                com.byazt.zho.n.n.n(nVar, strN, strQg);
            }
        }
        int iN2 = cdVar2.n();
        for (int i2 = 0; i2 < iN2; i2++) {
            String strN2 = cdVar2.n(i2);
            if (!"Content-Length".equalsIgnoreCase(strN2) && n(strN2)) {
                com.byazt.zho.n.n.n(nVar, strN2, cdVar2.qg(i2));
            }
        }
        return nVar.n();
    }

    public static boolean n(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}

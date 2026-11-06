package com.byazt.jr;

import com.byazt.gct.nf;
import com.byazt.se.fs;
import com.byazt.se.x;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1256, 13})
public class w {
    public com.byazt.zrp.n n;
    public com.byazt.se.qg qg;
    public s<fs, x> s;

    public w(com.byazt.se.qg qgVar, s<fs, x> sVar) {
        if (qgVar == null || sVar == null) {
            return;
        }
        this.qg = qgVar;
        this.s = sVar;
        if (qgVar.tj() == 1) {
            this.n = new com.byazt.kr.qg();
        } else {
            this.n = new com.byazt.kr.q();
        }
    }

    public boolean n() {
        return this.n instanceof com.byazt.kr.q;
    }

    public void qg() {
        com.byazt.se.qg qgVar = this.qg;
        if (qgVar == null || this.s == null) {
            return;
        }
        com.byazt.zrp.n nVar = this.n;
        if (nVar instanceof com.byazt.kr.qg) {
            nVar.n(qgVar, new s<fs, x>() { // from class: com.byazt.jr.w.1
                @Override // com.byazt.jr.s
                /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                public void s(fs fsVar) {
                    if (fsVar != null) {
                        fsVar.l(false);
                    }
                    w.this.s.s(fsVar);
                }

                @Override // com.byazt.jr.s
                public void qg(fs fsVar) {
                    if (fsVar != null) {
                        fsVar.l(true);
                    }
                    w.this.s.qg(fsVar);
                    com.byazt.hi.fs.n(w.this.qg.cp());
                }

                @Override // com.byazt.jr.s
                public void n(x xVar) {
                    w.this.s.n(xVar);
                }
            });
        } else {
            nVar.n(qgVar, new s<fs, x>() { // from class: com.byazt.jr.w.2
                @Override // com.byazt.jr.s
                /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                public void s(fs fsVar) {
                    if (fsVar != null) {
                        fsVar.l(false);
                    }
                    w.this.s.s(fsVar);
                }

                @Override // com.byazt.jr.s
                public void qg(fs fsVar) {
                    if (fsVar != null) {
                        fsVar.l(true);
                    }
                    w.this.s.qg(fsVar);
                }

                @Override // com.byazt.jr.s
                public void n(x xVar) {
                    if (w.this.qg.d() && w.this.qg.qg() != null) {
                        nf.n(w.this.qg.qg(), 1);
                    }
                    new com.byazt.kr.qg().n(w.this.qg, w.this.s);
                }
            });
        }
    }
}

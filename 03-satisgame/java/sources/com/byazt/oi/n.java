package com.byazt.oi;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 28, 19})
public class n implements com.byazt.kmf.n {
    public com.byazt.wea.qg n;
    public boolean qg = false;
    public boolean s = false;

    @Override // com.byazt.kmf.n
    public void n(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
    }

    private void n(com.byazt.wea.qg qgVar) {
        if (this.n == null) {
            this.n = qgVar;
        }
    }

    @Override // com.byazt.kmf.n
    public void qg(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        n(qgVar);
        this.s = true;
    }

    @Override // com.byazt.kmf.n
    public void s(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        n(qgVar);
        this.s = true;
    }

    @Override // com.byazt.kmf.n
    public void q(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        n(qgVar);
        this.s = true;
    }

    @Override // com.byazt.kmf.n
    public void l(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        n(qgVar);
        this.s = true;
    }

    @Override // com.byazt.kmf.n
    public void w(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        n(qgVar);
        this.s = true;
    }

    @Override // com.byazt.kmf.n
    public void x(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        com.byazt.mi.qg qgVar2;
        n(qgVar);
        this.s = true;
        if (qgVar.q == null || qgVar.q.ev() != 1 || (qgVar2 = (com.byazt.mi.qg) com.byazt.ikv.qg.n(qgVar.q.py(), com.byazt.mi.qg.class)) == null) {
            return;
        }
        qgVar2.n(6, null);
    }

    @Override // com.byazt.kmf.n
    public void fs(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        n(qgVar);
        this.s = true;
    }

    @Override // com.byazt.kmf.n
    public void rv(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        n(qgVar);
        this.s = true;
        if (!this.qg && qgVar.q != null && qgVar.q.nf() && !qgVar.q.pe() && qgVar.q.hy() && qgVar.q.ev() == 1) {
            this.qg = true;
            qgVar.q.x(true);
            com.byazt.mi.qg qgVar2 = (com.byazt.mi.qg) com.byazt.ikv.qg.n(qgVar.q.py(), com.byazt.mi.qg.class);
            if (qgVar2 != null) {
                com.byazt.hm.n.n(qgVar.q, 1);
                qgVar2.n(5, null);
            }
        }
    }

    @Override // com.byazt.kmf.n
    public void tj(com.byazt.wea.qg qgVar, com.byazt.bok.w wVar) {
        if (this.qg || wVar == null || wVar.n("source") == null || !this.s || qgVar.q == null || !qgVar.q.nf() || qgVar.q.pe() || !qgVar.q.hy() || !wVar.n("source").equals(1)) {
            return;
        }
        this.qg = true;
        com.byazt.mi.qg qgVar2 = (com.byazt.mi.qg) com.byazt.ikv.qg.n(qgVar.q.py(), com.byazt.mi.qg.class);
        if (qgVar2 != null) {
            qgVar.q.x(true);
            com.byazt.hm.n.n(qgVar.q, 2);
            qgVar2.n(5, null);
        }
    }
}

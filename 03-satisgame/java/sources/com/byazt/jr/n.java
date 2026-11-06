package com.byazt.jr;

import com.byazt.se.rv;
import com.byazt.se.x;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1256, 19})
public class n {
    public com.byazt.hw.qg n;
    public com.byazt.fvm.qg q;
    public com.byazt.se.s qg;
    public q<rv, x> s;

    public n(com.byazt.se.s sVar, q<rv, x> qVar, com.byazt.mz.n nVar) {
        if (sVar == null || qVar == null) {
            return;
        }
        this.qg = sVar;
        this.s = qVar;
        com.byazt.hw.qg qgVar = new com.byazt.hw.qg(sVar.getContext(), sVar.x(), sVar.w(), this.qg.fs(), sVar, qVar, nVar);
        this.n = qgVar;
        this.q = qgVar;
    }

    public void n(int i) {
        com.byazt.hw.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.qg(i);
        }
    }

    public void n(w wVar) {
        com.byazt.se.s sVar = this.qg;
        if (sVar == null || sVar.q == null || wVar == null) {
            return;
        }
        boolean zN = wVar.n();
        this.qg.q.n(zN);
        com.byazt.hw.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.qg(zN);
        }
    }

    public com.byazt.fvm.qg n() {
        return this.q;
    }

    public void qg() {
        com.byazt.hw.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.n(this.qg, this.s);
        }
    }
}

package com.byazt.hi;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 123, 19})
public class n {
    public com.byazt.cne.qg n;

    public void n(com.byazt.cne.qg qgVar) {
        this.n = qgVar;
    }

    public void n() {
        com.byazt.cne.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.qg();
            this.n = null;
        }
    }

    public void n(com.byazt.fvm.qg qgVar) {
        com.byazt.cne.qg qgVar2 = this.n;
        if (qgVar2 != null) {
            qgVar2.n(qgVar);
        }
    }

    public void qg() {
        com.byazt.cne.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.n();
        }
    }

    public boolean s() {
        return this.n == null;
    }
}

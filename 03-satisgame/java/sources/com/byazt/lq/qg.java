package com.byazt.lq;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 751, 26})
public class qg implements com.byazt.okm.n {
    public static qg n;
    public com.byazt.lpr.s.n qg;

    private qg() {
    }

    public com.byazt.lpr.s.n n() {
        return this.qg;
    }

    public static void n(com.byazt.lpr.s.n nVar, boolean z) {
        qg qgVar = new qg();
        n = qgVar;
        if (z) {
            qgVar.qg = new n(nVar);
        } else {
            qgVar.qg = nVar;
        }
    }

    public void s(String str, String str2) {
        com.byazt.lpr.s.n nVar = this.qg;
        if (nVar != null) {
            nVar.qg(str, str2);
        }
    }

    @Override // com.byazt.okm.n
    public void n(String str, String str2) {
        com.byazt.lpr.s.n nVar = this.qg;
        if (nVar != null) {
            nVar.s(str, str2);
        }
    }

    @Override // com.byazt.okm.n
    public void qg(String str, String str2) {
        com.byazt.lpr.s.n nVar = this.qg;
        if (nVar != null) {
            nVar.q(str, str2);
        }
    }

    @Override // com.byazt.okm.n
    public void n(String str, String str2, Throwable th) {
        com.byazt.lpr.s.n nVar = this.qg;
        if (nVar != null) {
            nVar.n(str, str2, th);
        }
    }

    @Override // com.byazt.okm.n
    public void n(String str, Throwable th) {
        com.byazt.lpr.s.n nVar = this.qg;
        if (nVar != null) {
            nVar.n(str, th);
        }
    }
}

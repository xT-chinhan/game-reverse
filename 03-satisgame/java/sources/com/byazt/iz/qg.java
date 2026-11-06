package com.byazt.iz;

import com.byazt.gct.pk;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 861, 26})
public class qg implements com.byazt.ot.n.qg {
    @Override // com.byazt.ot.n.qg
    public void n() {
    }

    @Override // com.byazt.ot.n.qg
    public void q() {
    }

    @Override // com.byazt.ot.n.qg
    public void s() {
    }

    private qg() {
        com.byazt.ot.n nVarS = com.byazt.vyf.s.cy().s();
        if (nVarS != null) {
            nVarS.n(this);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 861, 48})
    private static class n {
        public static qg n = new qg();
    }

    public static qg l() {
        return n.n;
    }

    @Override // com.byazt.ot.n.qg
    public void qg() {
        com.byazt.ag.qg.n(new com.byazt.qit.x("dl_work") { // from class: com.byazt.iz.qg.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.vyf.s.cy().n(rv.n((pk) null, true));
            }
        });
    }
}

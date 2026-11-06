package com.byazt.bh;

import com.byazt.qit.x;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 125, 8})
public class s implements com.byazt.kmf.qg {
    @Override // com.byazt.kmf.qg
    public void n(com.byazt.wea.s sVar, com.byazt.bok.w wVar) {
        if (sVar == null) {
            return;
        }
        final long jN = wVar != null ? wVar.n() : System.currentTimeMillis();
        final String strN = sVar.n();
        final int i = sVar.n;
        final String str = sVar.s;
        com.byazt.ag.qg.n(new x("tmax_record_on_ad_started") { // from class: com.byazt.bh.s.1
            @Override // java.lang.Runnable
            public void run() {
                w.n().n(strN, i, str, jN);
            }
        });
    }

    @Override // com.byazt.kmf.qg
    public void qg(com.byazt.wea.s sVar, com.byazt.bok.w wVar) {
        if (sVar == null) {
            return;
        }
        final long jN = wVar != null ? wVar.n() : System.currentTimeMillis();
        final String strN = sVar.n();
        com.byazt.ag.qg.n(new x("tmax_record_on_ad_reqed") { // from class: com.byazt.bh.s.2
            @Override // java.lang.Runnable
            public void run() {
                w.n().n(strN, jN);
            }
        });
    }

    @Override // com.byazt.kmf.qg
    public void s(com.byazt.wea.s sVar, com.byazt.bok.w wVar) {
        if (sVar == null) {
            return;
        }
        final long jN = wVar != null ? wVar.n() : System.currentTimeMillis();
        final String strN = sVar.n();
        com.byazt.ag.qg.n(new x("tmax_record_on_ad_received") { // from class: com.byazt.bh.s.3
            @Override // java.lang.Runnable
            public void run() {
                w.n().qg(strN, jN);
            }
        });
    }

    @Override // com.byazt.kmf.qg
    public void q(com.byazt.wea.s sVar, com.byazt.bok.w wVar) {
        if (sVar == null) {
            return;
        }
        final String strN = sVar.n();
        if (sVar.rv) {
            final long jN = wVar != null ? wVar.n() : System.currentTimeMillis();
            final long jQ = sVar.q != null ? sVar.q.kx().q() : 0L;
            final long jL = sVar.q != null ? sVar.q.kx().l() : 0L;
            com.byazt.ag.qg.n(new x("tmax_record_on_ad_loaded") { // from class: com.byazt.bh.s.4
                @Override // java.lang.Runnable
                public void run() {
                    w.n().n(strN, jQ, jL);
                    w.n().s(strN, jN);
                }
            });
        }
    }
}

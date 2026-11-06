package com.byazt.bh;

import android.text.TextUtils;
import com.byazt.qit.x;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 125, 5})
public class q implements com.byazt.kmf.s {
    @Override // com.byazt.kmf.s
    public void l(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
    }

    @Override // com.byazt.kmf.s
    public void n(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
    }

    @Override // com.byazt.kmf.s
    public void q(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
    }

    @Override // com.byazt.kmf.s
    public void s(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
    }

    @Override // com.byazt.kmf.s
    public void w(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
    }

    @Override // com.byazt.kmf.s
    public void qg(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
        if (qVar == null || TextUtils.isEmpty(qVar.x)) {
            return;
        }
        final String str = qVar.x;
        final long jN = wVar != null ? wVar.n() : System.currentTimeMillis();
        com.byazt.ag.qg.n(new x("tmax_record_on_ad_start") { // from class: com.byazt.bh.q.1
            @Override // java.lang.Runnable
            public void run() {
                w.n().l(str, jN);
            }
        });
    }

    @Override // com.byazt.kmf.s
    public void x(com.byazt.wea.q qVar, com.byazt.bok.w wVar) {
        if (qVar == null || TextUtils.isEmpty(qVar.x)) {
            return;
        }
        final String str = qVar.x;
        final long jN = wVar != null ? wVar.n() : System.currentTimeMillis();
        com.byazt.ag.qg.n(new x("tmax_record_on_ad_end") { // from class: com.byazt.bh.q.2
            @Override // java.lang.Runnable
            public void run() {
                w.n().w(str, jN);
            }
        });
    }
}

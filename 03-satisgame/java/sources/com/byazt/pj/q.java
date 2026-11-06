package com.byazt.pj;

import com.byazt.fvm.cp;
import com.byazt.fvm.k;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 441, 5})
public class q {
    public com.byazt.ap.x n;
    public com.byazt.ap.q qg;

    public q(com.byazt.ap.x xVar) {
        this.n = xVar;
    }

    public q(com.byazt.ap.q qVar) {
        this.qg = qVar;
    }

    public void n(int i, String str) {
        com.byazt.ap.x xVar = this.n;
        if (xVar != null) {
            xVar.n(i, str);
        }
        com.byazt.ap.q qVar = this.qg;
        if (qVar != null) {
            qVar.n(i, str);
        }
    }

    public void n(Object obj) {
        com.byazt.ap.x xVar = this.n;
        if (xVar != null && (obj instanceof k)) {
            xVar.n((k) obj);
        }
        com.byazt.ap.q qVar = this.qg;
        if (qVar == null || !(obj instanceof cp)) {
            return;
        }
        qVar.n((cp) obj);
    }

    public void qg(Object obj) {
        com.byazt.ap.x xVar = this.n;
        if (xVar != null && (obj instanceof k)) {
            xVar.n();
            this.n.qg((k) obj);
        }
        com.byazt.ap.q qVar = this.qg;
        if (qVar == null || !(obj instanceof cp)) {
            return;
        }
        qVar.n();
        this.qg.qg((cp) obj);
    }

    public long n() {
        Object obj = this.n;
        if (obj != null) {
            return obj instanceof com.byazt.yy.qg ? ((com.byazt.yy.qg) obj).qg() : System.currentTimeMillis();
        }
        Object obj2 = this.qg;
        if (obj2 != null) {
            return obj2 instanceof com.byazt.yy.qg ? ((com.byazt.yy.qg) obj2).qg() : System.currentTimeMillis();
        }
        return 0L;
    }
}

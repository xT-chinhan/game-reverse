package com.byazt.kr;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.ej.k;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.nf.rv;
import com.byazt.se.fs;
import com.byazt.se.x;
import com.byazt.tk.hd;
import com.byazt.zsl.l;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1300, 5})
public class q implements com.byazt.zrp.n {
    public x n = new x();

    @Override // com.byazt.zrp.n
    public void n(com.byazt.se.qg qgVar, com.byazt.jr.s<fs, x> sVar) {
        qg(qgVar, sVar);
    }

    private void qg(com.byazt.se.qg qgVar, com.byazt.jr.s<fs, x> sVar) {
        l lVarN;
        if (qgVar == null || sVar == null) {
            return;
        }
        this.n.qg(qgVar.oa());
        this.n.n(qgVar.qg());
        int iFs = qgVar.fs();
        com.byazt.zsl.s sVarX = qgVar.x();
        this.n.n(true);
        if (sVarX == null) {
            this.n.qg(2);
            this.n.n("no video info");
            sVar.n(this.n);
            return;
        }
        String strD = sVarX.d();
        if (TextUtils.isEmpty(strD)) {
            this.n.qg(2);
            this.n.n("no video url");
            sVar.n(this.n);
            return;
        }
        String strK = sVarX.k();
        if (TextUtils.isEmpty(strK)) {
            strK = com.byazt.tk.l.qg(strD);
        }
        if (TextUtils.isEmpty(strK)) {
            this.n.qg(2);
            this.n.n("no video cahce filename");
            sVar.n(this.n);
            return;
        }
        com.byazt.eo.n.n("Splash_FullLink", "加载视频素材");
        pk pkVarQg = qgVar.qg();
        if (pkVarQg == null) {
            return;
        }
        boolean zRv = qgVar.rv();
        sVarX.w(1);
        if (sVarX.cy() == 0) {
            sVarX.l(307200);
        }
        if (zRv) {
            lVarN = ta.n(2, pkVarQg);
        } else {
            lVarN = ta.n(3, pkVarQg);
        }
        lVarN.n("material_meta", pkVarQg);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (com.byazt.ql.qg.n(pkVarQg.io()).n(lVarN)) {
            fs fsVar = new fs(qgVar.qg(), qgVar.oa());
            fsVar.n(true);
            fsVar.s(true);
            fsVar.n(qgVar.n());
            fsVar.l(qgVar.s());
            sVar.qg(fsVar);
            lVarN.rv(1);
            com.byazt.gks.s.n(lVarN, pkVarQg, SystemClock.elapsedRealtime() - jElapsedRealtime);
            return;
        }
        if (rv.qg().x(String.valueOf(iFs)) && !hd.q(rv.getContext())) {
            this.n.qg(2);
            this.n.n("network error");
            sVar.n(this.n);
        } else {
            if (qgVar.qg() != null && qgVar.qg().ca() == 3) {
                fs fsVar2 = new fs(qgVar.qg(), qgVar.oa());
                fsVar2.n(true);
                fsVar2.s(false);
                fsVar2.n(qgVar.n());
                fsVar2.l(qgVar.s());
                fsVar2.n(ta.n(qgVar.qg()));
                sVar.qg(fsVar2);
                return;
            }
            com.byazt.lhs.n.n();
            n(lVarN, qgVar, qgVar.qg(), sVar);
        }
    }

    private void n(l lVar, final com.byazt.se.qg qgVar, pk pkVar, final com.byazt.jr.s<fs, x> sVar) {
        if (pkVar == null || sVar == null || qgVar == null || lVar == null || ta.k(pkVar) == null) {
            return;
        }
        com.byazt.gks.s.n(lVar, new com.byazt.pzg.n() { // from class: com.byazt.kr.q.1
            @Override // com.byazt.ej.tj.n
            public void qg(k kVar, int i) {
                if (sVar != null) {
                    fs fsVar = new fs(qgVar.qg(), qgVar.oa());
                    fsVar.n(true);
                    fsVar.s(false);
                    fsVar.n(qgVar.n());
                    fsVar.l(qgVar.s());
                    sVar.qg(fsVar);
                }
            }

            @Override // com.byazt.ej.tj.n
            public void n(k kVar, int i, String str) {
                if (sVar != null) {
                    q.this.n.qg(2);
                    q.this.n.n("preload video fail");
                    sVar.n(q.this.n);
                }
            }
        });
    }
}

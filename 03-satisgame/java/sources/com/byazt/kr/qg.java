package com.byazt.kr;

import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.se.fs;
import com.byazt.se.x;
import com.byazt.si.a;
import com.byazt.si.cy;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1300, 26})
public class qg implements com.byazt.zrp.n {
    public x n = new x();

    @Override // com.byazt.zrp.n
    public void n(com.byazt.se.qg qgVar, com.byazt.jr.s<fs, x> sVar) {
        qg(qgVar, sVar);
    }

    private void qg(final com.byazt.se.qg qgVar, final com.byazt.jr.s<fs, x> sVar) {
        if (qgVar == null || sVar == null) {
            return;
        }
        this.n.qg(qgVar.oa());
        this.n.n(qgVar.qg());
        if (rv.qg().x(qgVar.fs()) == 4) {
            fs fsVar = new fs(qgVar.qg(), qgVar.oa());
            fsVar.n(false);
            fsVar.n(qgVar.n());
            fsVar.n(qgVar.s());
            sVar.qg(fsVar);
            return;
        }
        com.byazt.imu.q qVarQ = qgVar.q();
        if (qVarQ == null) {
            this.n.qg(2);
            this.n.n("image request fail");
            this.n.n(false);
            sVar.n(this.n);
            return;
        }
        com.byazt.eo.n.n("Splash_FullLink", "加载图片素材 " + qgVar.qg().ou());
        com.byazt.imu.n.n(qVarQ, qgVar.l(), qgVar.w(), new com.byazt.imu.n.InterfaceC0203n() { // from class: com.byazt.kr.qg.1
            @Override // com.byazt.imu.n.InterfaceC0203n
            public void n(com.byazt.qdx.qg qgVar2, cy cyVar) {
                fs fsVar2 = new fs(qgVar2, qgVar.qg(), qgVar.oa());
                fsVar2.n(false);
                fsVar2.n(qgVar.n());
                fsVar2.l(qgVar.s());
                if (cyVar != null) {
                    fsVar2.n(cyVar.x());
                    fsVar2.qg(cyVar.rv());
                    fsVar2.qg(com.byazt.jc.qg.n(cyVar.x()));
                    if (cyVar.tj() != null) {
                        fsVar2.qg(cyVar.tj().qg());
                        fsVar2.s(cyVar.tj().n());
                        fsVar2.q(cyVar.tj().s());
                    }
                }
                sVar.qg(fsVar2);
            }

            @Override // com.byazt.imu.n.InterfaceC0203n
            public void n() {
                qg.this.n.qg(2);
                qg.this.n.n("load image fail");
                qg.this.n.n(false);
                sVar.n(qg.this.n);
            }
        }, com.byazt.ql.qg.l(), 4, new a() { // from class: com.byazt.kr.qg.2
            @Override // com.byazt.si.a
            public void n(int i, Object obj) {
                if (i == 3 && qg.this.n(qgVar)) {
                    fs fsVar2 = new fs(qgVar.qg(), qgVar.oa());
                    fsVar2.n(false);
                    fsVar2.n(qgVar.n());
                    fsVar2.n(qgVar.s());
                    fsVar2.q(true);
                    fsVar2.qg(false);
                    sVar.s(fsVar2);
                }
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(com.byazt.se.qg qgVar) {
        pk pkVarQg;
        if (qgVar == null || (pkVarQg = qgVar.qg()) == null) {
            return false;
        }
        int iIz = pkVarQg.iz();
        return iIz == 3 || iIz == 4;
    }
}

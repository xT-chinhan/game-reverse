package com.byazt.pj;

import com.byazt.gct.j;
import com.byazt.gct.pe;
import com.byazt.gct.pk;
import com.byazt.gct.ur;
import com.byazt.nf.rv;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 441, 19})
public class n extends l<com.byazt.rv.q> {
    @Override // com.byazt.pj.l
    public boolean n() {
        return false;
    }

    @Override // com.byazt.pj.l
    public /* synthetic */ void qg(com.byazt.zq.qg qgVar, List list, com.byazt.rv.q qVar) {
        n(qgVar, (List<pk>) list, qVar);
    }

    public n(com.byazt.gzx.qg qgVar) {
        super(qgVar);
    }

    @Override // com.byazt.msp.qg
    public void n(com.byazt.zq.qg qgVar, List<pk> list, com.byazt.msp.qg.n<com.byazt.rv.q> nVar) {
        com.byazt.rv.q qVar = new com.byazt.rv.q(rv.getContext(), list.get(0), qgVar);
        if (nVar != null) {
            nVar.n(qVar);
        }
    }

    @Override // com.byazt.pj.l
    public boolean n(com.byazt.gct.n nVar) {
        List<pk> listQg;
        if (nVar != null && (listQg = nVar.qg()) != null) {
            pk pkVar = listQg.get(0);
            if (ur.n(pkVar)) {
                return pkVar.nq().s() != 1;
            }
            if (j.qg(n(), pkVar, false) && j.q(pkVar) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.pj.l
    public void n(com.byazt.rv.q qVar) {
        qVar.n(1);
    }

    public void n(com.byazt.zq.qg qgVar, List<pk> list, com.byazt.rv.q qVar) {
        pk pkVar = list.get(0);
        if (pkVar.aj() <= 0) {
            qVar.n(System.currentTimeMillis() + 10500000);
        } else {
            qVar.n(pkVar.aj() * 1000);
        }
        if (com.byazt.gks.n.n(pkVar) || com.byazt.qq.qg.s(pkVar) || pe.n(pkVar) || !pkVar.wn()) {
            return;
        }
        qVar.w();
    }
}

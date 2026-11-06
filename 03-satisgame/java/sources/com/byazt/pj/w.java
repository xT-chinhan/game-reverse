package com.byazt.pj;

import com.byazt.gct.j;
import com.byazt.gct.pe;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 441, 13})
public class w extends l<com.byazt.rv.l> {
    @Override // com.byazt.pj.l
    public boolean n() {
        return true;
    }

    @Override // com.byazt.pj.l
    public /* synthetic */ void qg(com.byazt.zq.qg qgVar, List list, com.byazt.rv.l lVar) {
        n(qgVar, (List<pk>) list, lVar);
    }

    public w(com.byazt.gzx.qg qgVar) {
        super(qgVar);
    }

    @Override // com.byazt.msp.qg
    public void n(com.byazt.zq.qg qgVar, List<pk> list, com.byazt.msp.qg.n<com.byazt.rv.l> nVar) {
        com.byazt.rv.l lVar = new com.byazt.rv.l(rv.getContext(), list.get(0), qgVar);
        if (nVar != null) {
            nVar.n(lVar);
        }
    }

    @Override // com.byazt.pj.l
    public boolean n(com.byazt.gct.n nVar) {
        List<pk> listQg;
        if (nVar != null && (listQg = nVar.qg()) != null) {
            pk pkVar = listQg.get(0);
            if (j.qg(n(), pkVar, false) && j.q(pkVar) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.pj.l
    public void n(com.byazt.rv.l lVar) {
        lVar.s(1);
    }

    public void n(com.byazt.zq.qg qgVar, List<pk> list, com.byazt.rv.l lVar) {
        pk pkVar = list.get(0);
        if (pkVar.aj() <= 0) {
            lVar.n(System.currentTimeMillis() + 10500000);
        } else {
            lVar.n(pkVar.aj() * 1000);
        }
        if (com.byazt.gks.n.n(pkVar) || com.byazt.qq.qg.s(pkVar) || pe.n(pkVar) || !pkVar.wn()) {
            return;
        }
        lVar.w();
    }
}

package com.byazt.vgo;

import com.byazt.be.s;
import com.byazt.fvm.rv;
import com.byazt.gct.pk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 25, 26})
public class qg extends com.byazt.msp.qg<List<rv>> {
    @Override // com.byazt.msp.qg
    public /* bridge */ /* synthetic */ void n(com.byazt.zq.qg qgVar, List list, List<rv> list2) {
        n2(qgVar, (List<pk>) list, list2);
    }

    public qg(com.byazt.gzx.qg qgVar) {
        super(qgVar);
    }

    @Override // com.byazt.msp.qg
    public void n(com.byazt.zq.qg qgVar, List<pk> list, com.byazt.msp.qg.n<List<rv>> nVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<pk> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new s(com.byazt.nf.rv.getContext(), it.next(), 9, qgVar));
        }
        if (nVar != null) {
            nVar.n(arrayList);
        }
    }

    /* JADX INFO: renamed from: n, reason: avoid collision after fix types in other method */
    public void n2(com.byazt.zq.qg qgVar, List<pk> list, List<rv> list2) {
        for (int i = 0; i < list2.size(); i++) {
            pk pkVar = list.get(i);
            rv rvVar = list2.get(i);
            if (this.n != null) {
                this.n.qg().n(qgVar, pkVar, (Object) rvVar, false);
            }
        }
    }
}

package com.byazt.ju;

import com.byazt.hg.of;
import com.byazt.mr.aj;
import com.byazt.sd.a;
import com.byazt.yb.hn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1108, 13})
public class hw extends com.byazt.ra.hw<List<aj>> {
    @Override // com.byazt.ra.hw
    public /* bridge */ /* synthetic */ void pr(com.byazt.qe.hw hwVar, List list, List<aj> list2) {
        pr2(hwVar, (List<of>) list, list2);
    }

    public hw(com.byazt.pe.hw hwVar) {
        super(hwVar);
    }

    @Override // com.byazt.ra.hw
    public void pr(com.byazt.qe.hw hwVar, List<of> list, com.byazt.ra.hw.pr<List<aj>> prVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<of> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new hn(a.getContext(), it.next(), 9, hwVar));
        }
        if (prVar != null) {
            prVar.pr(arrayList);
        }
    }

    /* JADX INFO: renamed from: pr, reason: avoid collision after fix types in other method */
    public void pr2(com.byazt.qe.hw hwVar, List<of> list, List<aj> list2) {
        for (int i = 0; i < list2.size(); i++) {
            of ofVar = list.get(i);
            aj ajVar = list2.get(i);
            if (this.pr != null) {
                this.pr.hw().pr(hwVar, ofVar, (Object) ajVar, false);
            }
        }
    }
}

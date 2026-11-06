package com.byazt.vh;

import com.byazt.hg.o;
import com.byazt.hg.of;
import com.byazt.hg.ww;
import com.byazt.sd.a;
import com.byazt.wt.ny;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1093, 5})
public class uc extends c<com.byazt.joa.hn> {
    @Override // com.byazt.vh.c
    public /* synthetic */ void hw(com.byazt.qe.hw hwVar, List list, com.byazt.joa.hn hnVar) {
        pr(hwVar, (List<of>) list, hnVar);
    }

    public uc(com.byazt.pe.hw hwVar) {
        super(hwVar);
    }

    @Override // com.byazt.vh.c
    public boolean pr() {
        return true;
    }

    @Override // com.byazt.ra.hw
    public void pr(com.byazt.qe.hw hwVar, List<of> list, com.byazt.ra.hw.pr<com.byazt.joa.hn> prVar) {
        com.byazt.joa.hn hnVar = new com.byazt.joa.hn(a.getContext(), list.get(0), hwVar);
        if (prVar != null) {
            prVar.pr(hnVar);
        }
    }

    @Override // com.byazt.vh.c
    public boolean pr(com.byazt.hg.pr prVar) {
        List<of> listHw;
        if (prVar == null || (listHw = prVar.hw()) == null) {
            return false;
        }
        of ofVar = listHw.get(0);
        return ww.hw(pr(), ofVar, false) && ww.x(ofVar) != 0;
    }

    @Override // com.byazt.vh.c
    public void pr(com.byazt.joa.hn hnVar) {
        hnVar.hn(1);
    }

    public void pr(com.byazt.qe.hw hwVar, List<of> list, com.byazt.joa.hn hnVar) {
        of ofVar = list.get(0);
        if (ofVar.hp() <= 0) {
            hnVar.pr(System.currentTimeMillis() + 10500000);
        } else {
            hnVar.pr(ofVar.hp() * 1000);
        }
        if (!com.byazt.lpk.pr.pr(ofVar) && !ny.hn(ofVar) && !o.pr(ofVar) && ofVar.ji()) {
            hnVar.pr();
        }
    }
}

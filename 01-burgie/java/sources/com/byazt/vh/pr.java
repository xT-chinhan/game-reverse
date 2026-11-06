package com.byazt.vh;

import com.byazt.hg.o;
import com.byazt.hg.of;
import com.byazt.hg.ve;
import com.byazt.hg.ww;
import com.byazt.sd.a;
import com.byazt.wt.ny;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1093, 37})
public class pr extends c<com.byazt.joa.hw> {
    @Override // com.byazt.vh.c
    public /* synthetic */ void hw(com.byazt.qe.hw hwVar, List list, com.byazt.joa.hw hwVar2) {
        pr(hwVar, (List<of>) list, hwVar2);
    }

    public pr(com.byazt.pe.hw hwVar) {
        super(hwVar);
    }

    @Override // com.byazt.vh.c
    public boolean pr() {
        return false;
    }

    @Override // com.byazt.ra.hw
    public void pr(com.byazt.qe.hw hwVar, List<of> list, com.byazt.ra.hw.pr<com.byazt.joa.hw> prVar) {
        com.byazt.joa.hw hwVar2 = new com.byazt.joa.hw(a.getContext(), list.get(0), hwVar);
        if (prVar != null) {
            prVar.pr(hwVar2);
        }
    }

    @Override // com.byazt.vh.c
    public boolean pr(com.byazt.hg.pr prVar) {
        List<of> listHw;
        if (prVar == null || (listHw = prVar.hw()) == null) {
            return false;
        }
        of ofVar = listHw.get(0);
        if (ve.pr(ofVar)) {
            return ofVar.sb().hn() != 1;
        }
        return ww.hw(pr(), ofVar, false) && ww.x(ofVar) != 0;
    }

    @Override // com.byazt.vh.c
    public void pr(com.byazt.joa.hw hwVar) {
        hwVar.pr(1);
    }

    public void pr(com.byazt.qe.hw hwVar, List<of> list, com.byazt.joa.hw hwVar2) {
        of ofVar = list.get(0);
        if (ofVar.hp() <= 0) {
            hwVar2.pr(System.currentTimeMillis() + 10500000);
        } else {
            hwVar2.pr(ofVar.hp() * 1000);
        }
        if (!com.byazt.lpk.pr.pr(ofVar) && !ny.hn(ofVar) && !o.pr(ofVar) && ofVar.ji()) {
            hwVar2.pr();
        }
    }
}

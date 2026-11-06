package com.byazt.lze;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 936, 20})
public class hn implements com.byazt.lf.hn {
    public final com.byazt.af.fw pr = new com.byazt.af.fw();

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, Map<String, Object> map2, com.byazt.hws.pr prVar) {
        int iHn;
        com.byazt.lx.hw.pr(this.pr, prVar.hn(), map, map2);
        if (!pr(map2)) {
            prVar.hw(map2, null);
            return true;
        }
        if (this.pr.fo() != -1001) {
            iHn = this.pr.fo();
        } else {
            iHn = com.byazt.eg.hw.pr().hn();
            this.pr.pr(iHn);
            com.byazt.lx.hw.pr(this.pr, map2).jw(iHn);
        }
        map2.put("saas_status_while_click", Integer.valueOf(iHn));
        com.byazt.af.fw fwVar = this.pr;
        com.byazt.ye.uc ucVar = new com.byazt.ye.uc(fwVar, fwVar.getContext(), this.pr.hw(), this.pr.hn(), map2);
        if (this.pr.fw() != -1) {
            ucVar.hw(this.pr.fw());
        }
        ucVar.pr(this.pr.zo());
        ucVar.hw(this.pr.aj());
        if (new com.byazt.ye.hw(new com.byazt.ye.c(ucVar, com.byazt.lx.hw.pr(this.pr, map2), prVar, map2, this.pr.hw()), this.pr.getContext(), com.byazt.lx.hw.pr(this.pr, map2), this.pr.hw(), map2, prVar).pr(new HashMap())) {
            com.byazt.lx.hw.pr(map2, com.byazt.wb.x.hn);
            prVar.hw(map2);
            return false;
        }
        prVar.hw(map2, null);
        return false;
    }

    private boolean pr(Map<String, Object> map) {
        return (com.byazt.lx.hw.pr(this.pr, map) == null || this.pr.getContext() == null) ? false : true;
    }
}

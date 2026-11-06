package com.byazt.lze;

import com.byazt.ye.zo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 936, 121})
public class x implements com.byazt.lf.hn {
    public final com.byazt.af.x pr = new com.byazt.af.x();

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, Map<String, Object> map2, com.byazt.hws.pr prVar) {
        com.byazt.lx.hw.pr(this.pr, prVar.hn(), prVar.hw(), map2);
        if (!pr(map2)) {
            com.byazt.lx.hw.pr(map2, com.byazt.wb.uc.x);
            prVar.hw(map2, null);
            return true;
        }
        if (pr(map2, prVar).pr(new HashMap())) {
            com.byazt.lx.hw.pr(map2, com.byazt.wb.uc.hn);
            prVar.hw(map2);
        } else {
            prVar.hw(map2, null);
        }
        return true;
    }

    private zo pr(Map<String, Object> map, com.byazt.hws.pr prVar) {
        com.byazt.af.x xVar = this.pr;
        return new zo(xVar, xVar.getContext(), this.pr.hw(), this.pr.hn(), map, prVar, this.pr.x(), true);
    }

    private boolean pr(Map<String, Object> map) {
        return (com.byazt.lx.hw.pr(this.pr, map) == null || this.pr.getContext() == null || this.pr.F_() == null) ? false : true;
    }
}

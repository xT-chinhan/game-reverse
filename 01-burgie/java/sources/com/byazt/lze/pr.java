package com.byazt.lze;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 936, 37})
public class pr implements com.byazt.lf.hn {
    public final com.byazt.af.hw pr = new com.byazt.af.hw();

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, Map<String, Object> map2, com.byazt.hws.pr prVar) {
        com.byazt.lx.hw.pr(this.pr, prVar.hn(), map, map2);
        if (!pr(map2)) {
            prVar.hw(map2, null);
            return true;
        }
        if (new com.byazt.ov.hw(pr(map2, com.byazt.ye.pr.x(map2)), this.pr.yb()).pr(map2)) {
            com.byazt.lx.hw.pr(map2, com.byazt.wb.hw.hn);
            prVar.hw(map2);
        } else {
            prVar.hw(map2, null);
        }
        return true;
    }

    private com.byazt.ye.pr pr(Map<String, Object> map, int i) {
        com.byazt.af.hw hwVar = this.pr;
        com.byazt.ye.x xVar = new com.byazt.ye.x(hwVar, hwVar.getContext(), this.pr.zo(), this.pr.vk(), this.pr.g(), this.pr.a(), map, true);
        xVar.hw(this.pr.m());
        xVar.pr(this.pr.k(), i);
        xVar.pr(this.pr.aj());
        xVar.pr(this.pr.fw());
        xVar.pr(this.pr.w());
        xVar.pr(this.pr.nt());
        xVar.pr(this.pr.z_());
        return xVar;
    }

    private boolean pr(Map<String, Object> map) {
        if (com.byazt.lx.hw.pr(this.pr, map) == null || this.pr.getContext() == null) {
            return false;
        }
        if (TextUtils.isEmpty(this.pr.g())) {
            com.byazt.hg.c cVarHo = this.pr.ho();
            if (cVarHo != null) {
                this.pr.pr(cVarHo.hw());
            }
            if (TextUtils.isEmpty(this.pr.g())) {
                return false;
            }
        }
        return (TextUtils.isEmpty(this.pr.zo()) || this.pr.vk() == null) ? false : true;
    }
}

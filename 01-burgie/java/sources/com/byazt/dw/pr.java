package com.byazt.dw;

import com.byazt.mr.uc;
import com.byazt.mr.x;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1007, 37})
public class pr extends x {
    public final hw pr;

    public pr(hw hwVar) {
        this.pr = hwVar;
    }

    @Override // com.byazt.mr.x
    public List<uc> pr() {
        hw hwVar = this.pr;
        if (hwVar == null) {
            return null;
        }
        return hwVar.pr();
    }
}

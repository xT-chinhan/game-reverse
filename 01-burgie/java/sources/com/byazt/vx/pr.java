package com.byazt.vx;

import com.byazt.zn.aj;
import com.byazt.zn.fw;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1155, 37})
public class pr {
    public x<aj, fw> hn;
    public com.byazt.zn.hn hw;
    public com.byazt.rw.hw pr;
    public com.byazt.mr.hw x;

    public pr(com.byazt.zn.hn hnVar, x<aj, fw> xVar, com.byazt.ks.pr prVar) {
        if (hnVar == null || xVar == null) {
            return;
        }
        this.hw = hnVar;
        this.hn = xVar;
        com.byazt.rw.hw hwVar = new com.byazt.rw.hw(hnVar.getContext(), hnVar.fw(), hnVar.uc(), this.hw.zo(), hnVar, xVar, prVar);
        this.pr = hwVar;
        this.x = hwVar;
    }

    public void pr(int i) {
        com.byazt.rw.hw hwVar = this.pr;
        if (hwVar != null) {
            hwVar.hw(i);
        }
    }

    public void pr(uc ucVar) {
        com.byazt.zn.hn hnVar = this.hw;
        if (hnVar != null && hnVar.x != null && ucVar != null) {
            boolean zPr = ucVar.pr();
            this.hw.x.pr(zPr);
            com.byazt.rw.hw hwVar = this.pr;
            if (hwVar != null) {
                hwVar.hw(zPr);
            }
        }
    }

    public com.byazt.mr.hw pr() {
        return this.x;
    }

    public void hw() {
        com.byazt.rw.hw hwVar = this.pr;
        if (hwVar != null) {
            hwVar.pr(this.hw, this.hn);
        }
    }
}

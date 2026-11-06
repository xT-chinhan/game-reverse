package com.byazt.qam;

import com.byazt.sd.zo;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1745, 37})
public class pr {
    public Boolean pr = null;
    public Boolean hw = null;
    public Boolean hn = null;

    public boolean pr() {
        if (this.hw == null) {
            fw fwVarYb = zo.nt().yb();
            this.hw = Boolean.valueOf(fwVarYb == null || fwVarYb.x());
        }
        return this.hw.booleanValue();
    }

    public boolean hw() {
        if (this.hn == null) {
            fw fwVarYb = zo.nt().yb();
            this.hn = Boolean.valueOf(fwVarYb == null || fwVarYb.pr());
        }
        return this.hn.booleanValue();
    }

    public boolean pr(int i) {
        fw fwVarYb = zo.nt().yb();
        return fwVarYb == null || fw.pr(fwVarYb, i);
    }
}

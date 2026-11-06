package com.byazt.qam;

import com.byazt.sd.a;
import com.byazt.sd.z;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1745, 62})
public class fw extends z {
    public boolean pr;

    public fw(com.byazt.qe.x xVar, boolean z) {
        super(xVar);
        this.pr = false;
        this.pr = z;
    }

    private boolean hw(int i) {
        return a.hw().w(i) && hn(i);
    }

    private boolean hn(int i) {
        switch (i) {
            case 0:
            case 1:
            case 3:
                return super.hn();
            case 2:
                return super.x();
            default:
                return false;
        }
    }

    public boolean pr(int i) {
        return hw(i);
    }

    public static boolean pr(fw fwVar, int i) {
        if (fwVar == null) {
            return true;
        }
        return fwVar.pr(i);
    }

    @Override // com.byazt.sd.z, com.byazt.qe.x
    public boolean x() {
        if (this.pr) {
            return false;
        }
        return super.x();
    }

    @Override // com.byazt.sd.z, com.byazt.qe.x
    public boolean hn() {
        if (this.pr) {
            return false;
        }
        return super.hn();
    }

    @Override // com.byazt.qe.x
    public com.byazt.or.hw yb() {
        com.byazt.qe.x xVarG = g();
        if (xVarG == null) {
            return super.yb();
        }
        return xVarG.yb();
    }
}

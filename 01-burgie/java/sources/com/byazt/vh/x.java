package com.byazt.vh;

import com.byazt.mr.ho;
import com.byazt.mr.w;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1093, 121})
public class x {
    public com.byazt.pis.x hw;
    public com.byazt.pis.fw pr;

    public x(com.byazt.pis.fw fwVar) {
        this.pr = fwVar;
    }

    public x(com.byazt.pis.x xVar) {
        this.hw = xVar;
    }

    public void pr(int i, String str) {
        com.byazt.pis.fw fwVar = this.pr;
        if (fwVar != null) {
            fwVar.pr(i, str);
        }
        com.byazt.pis.x xVar = this.hw;
        if (xVar != null) {
            xVar.pr(i, str);
        }
    }

    public void pr(Object obj) {
        com.byazt.pis.fw fwVar = this.pr;
        if (fwVar != null && (obj instanceof ho)) {
            fwVar.pr((ho) obj);
        }
        com.byazt.pis.x xVar = this.hw;
        if (xVar != null && (obj instanceof w)) {
            xVar.pr((w) obj);
        }
    }

    public void hw(Object obj) {
        com.byazt.pis.fw fwVar = this.pr;
        if (fwVar != null && (obj instanceof ho)) {
            fwVar.hw();
            this.pr.hw((ho) obj);
        }
        com.byazt.pis.x xVar = this.hw;
        if (xVar != null && (obj instanceof w)) {
            xVar.hw();
            this.hw.hw((w) obj);
        }
    }

    public long pr() {
        Object obj = this.pr;
        if (obj != null) {
            return obj instanceof com.byazt.cv.hw ? ((com.byazt.cv.hw) obj).pr() : System.currentTimeMillis();
        }
        Object obj2 = this.hw;
        if (obj2 != null) {
            return obj2 instanceof com.byazt.cv.hw ? ((com.byazt.cv.hw) obj2).pr() : System.currentTimeMillis();
        }
        return 0L;
    }
}

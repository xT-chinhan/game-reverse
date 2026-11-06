package com.byazt.blx;

import com.byazt.qp.q;
import com.byazt.vf.cp;
import com.byazt.vf.wm;
import com.byazt.vr.w;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 224, 19})
public class n implements w {
    public int n;
    public int qg;

    @Override // com.byazt.vr.w
    public int qg() {
        return this.n;
    }

    @Override // com.byazt.vr.w
    public int n() {
        return this.qg;
    }

    public n(int i, int i2) {
        i = i <= 0 ? 10 : i;
        i2 = i2 <= 0 ? 100 : i2;
        i2 = i > i2 ? i : i2;
        this.n = i;
        this.qg = i2;
    }

    public static n n(com.byazt.vf.n nVar) {
        wm wmVar = (wm) q.n("mediation_settings", nVar);
        int iS = wmVar != null ? wmVar.s() : 100;
        return new n(iS, iS);
    }

    public static n qg(com.byazt.vf.n nVar) {
        cp cpVar = (cp) q.n("csj_settings", nVar);
        int iCp = cpVar.cp();
        int iD = cpVar.d();
        if (iCp > iD) {
            iD = iCp;
        }
        return new n(iCp, iD);
    }

    public static n s(com.byazt.vf.n nVar) {
        int iD = ((cp) q.n("csj_settings", nVar)).d();
        if (iD <= 1) {
            iD = 10;
        }
        return new n(1, iD);
    }

    public static n q(com.byazt.vf.n nVar) {
        int iD = ((cp) q.n("csj_settings", nVar)).d();
        if (iD <= 1) {
            iD = 10;
        }
        return new n(1, iD);
    }

    public static n s() {
        return new n(1, 100);
    }
}

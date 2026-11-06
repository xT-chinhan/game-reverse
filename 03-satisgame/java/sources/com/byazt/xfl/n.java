package com.byazt.xfl;

import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.udb.oa;
import com.byazt.vgx.w;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2441, 19})
public abstract class n implements qg {
    public abstract String n(pk pkVar, int i, int i2);

    @Override // com.byazt.xfl.qg
    public String n(pk pkVar) {
        int iL = l(pkVar);
        int iQ = q(pkVar);
        if (iL <= 0 || iL > 9 || iQ == -1) {
            return null;
        }
        return n(pkVar, iL, iQ);
    }

    private int q(pk pkVar) {
        if (pkVar == null) {
            return -1;
        }
        return pkVar.ge();
    }

    private static int l(pk pkVar) {
        int iD;
        if (pkVar == null) {
            return -1;
        }
        com.byazt.zq.qg qgVarXd = pkVar.xd();
        int iA = qgVarXd != null ? qgVarXd.a() : -1;
        return ((iA <= 0 || iA >= 10) && (iD = w.d(pkVar)) > 0 && iD < 10) ? iD : iA;
    }

    public static qg n(pk pkVar, oa oaVar) {
        if (pkVar == null || l(pkVar) != 5) {
            return null;
        }
        if ((oaVar instanceof com.byazt.gn.s) && ((com.byazt.gn.s) oaVar).an()) {
            return new com.byazt.zfz.n();
        }
        return new com.byazt.jo.n();
    }

    public static boolean qg(pk pkVar) {
        if (pkVar == null) {
            return false;
        }
        return (nf.q(pkVar) == 2) && s(pkVar);
    }

    public static boolean s(pk pkVar) {
        return l(pkVar) == 5;
    }
}

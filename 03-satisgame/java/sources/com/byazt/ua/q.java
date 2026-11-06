package com.byazt.ua;

import com.byazt.pl.fs;
import com.byazt.zf.cp;
import com.byazt.zf.d;
import com.byazt.zf.l;
import com.byazt.zf.tj;
import com.byazt.zf.w;
import com.byazt.zf.x;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 958, 5})
public class q {
    public static com.byazt.nw.n n(com.byazt.dd.qg qgVar, com.byazt.nw.qg qgVar2) {
        if (qgVar == null) {
            return null;
        }
        int iK = qgVar.k();
        switch (qgVar.h()) {
            case 1:
                return new com.byazt.zf.n(qgVar2);
            case 2:
                return new x(qgVar2);
            case 3:
                return new d(qgVar2);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (iK == 4) {
                    return new tj(qgVar2);
                }
                if (iK == 5) {
                    return new l(qgVar2);
                }
                if (iK == 3) {
                    return new com.byazt.zf.n(qgVar2);
                }
                return new tj(qgVar2);
            case 7:
                if (iK == 6) {
                    return new cp(qgVar2);
                }
                if (iK == 7) {
                    return new w(qgVar2);
                }
                if (iK == 8) {
                    return new x(qgVar2);
                }
                return new cp(qgVar2);
            case 8:
                return new w(qgVar2);
            case 9:
                return new l(qgVar2);
            case 10:
                if (iK == 1) {
                    return new x(qgVar2);
                }
                if (iK == 2) {
                    return new w(qgVar2);
                }
                return null;
        }
    }

    public static com.byazt.nw.n n(String str, com.byazt.dd.qg qgVar, com.byazt.nw.qg qgVar2) {
        if (qgVar == null) {
            return null;
        }
        int iK = qgVar.k();
        switch (qgVar.h()) {
            case 1:
                return new com.byazt.pl.n(str, qgVar2);
            case 2:
                return new com.byazt.pl.w(str, qgVar2);
            case 3:
                return new fs(str, qgVar2);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (iK == 4) {
                    return new com.byazt.pl.q(str, qgVar2);
                }
                if (iK == 5) {
                    return new com.byazt.pl.s(str, qgVar2);
                }
                if (iK == 3) {
                    return new com.byazt.pl.n(str, qgVar2);
                }
                return new com.byazt.pl.q(str, qgVar2);
            case 7:
                if (iK == 6) {
                    return new com.byazt.pl.x(str, qgVar2);
                }
                if (iK == 7) {
                    return new com.byazt.pl.l(str, qgVar2);
                }
                if (iK == 8) {
                    return new com.byazt.pl.w(str, qgVar2);
                }
                return new com.byazt.pl.x(str, qgVar2);
            case 8:
                return new com.byazt.pl.l(str, qgVar2);
            case 9:
                return new com.byazt.pl.s(str, qgVar2);
            case 10:
                if (iK == 1) {
                    return new com.byazt.pl.w(str, qgVar2);
                }
                if (iK == 2) {
                    return new com.byazt.pl.l(str, qgVar2);
                }
                return null;
        }
    }
}

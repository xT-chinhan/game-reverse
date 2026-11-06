package com.byazt.sl;

import android.text.TextUtils;
import com.byazt.lk.l;
import com.byazt.nf.tj;
import com.byazt.qp.q;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1837, 19})
public final class n {
    public static String n(com.byazt.vf.n nVar, String str) {
        return n(nVar, str, s(), true);
    }

    public static String qg(com.byazt.vf.n nVar, String str) {
        return qg(nVar, str, s(), true);
    }

    public static String s(com.byazt.vf.n nVar, String str) {
        return s(nVar, str, s());
    }

    public static boolean n() {
        if (tj.l < 7800) {
            return false;
        }
        return l.n();
    }

    public static String n(com.byazt.vf.n nVar, String str, boolean z) {
        return n(nVar, str, n(), z);
    }

    public static String qg(com.byazt.vf.n nVar, String str, boolean z) {
        return qg(nVar, str, n(), z);
    }

    public static String q(com.byazt.vf.n nVar, String str) {
        return s(nVar, str, n());
    }

    private static String n(com.byazt.vf.n nVar, String str, boolean z, boolean z2) {
        String strN = n(str, "ads_layer_default");
        if (z && z2) {
            strN = w(nVar, strN);
        }
        return l(nVar, strN);
    }

    private static String qg(com.byazt.vf.n nVar, String str, boolean z, boolean z2) {
        String strN = n(str, "ads_global_default");
        if (z) {
            if (z2) {
                strN = w(nVar, strN);
            }
            strN = qg(strN, "_global");
        }
        return l(nVar, strN);
    }

    private static String s(com.byazt.vf.n nVar, String str, boolean z) {
        String strN = n(str, "ads_version_default");
        if (z) {
            strN = w(nVar, strN);
        }
        return l(nVar, strN);
    }

    private static String n(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    private static String qg(String str, String str2) {
        return str + str2;
    }

    private static String l(com.byazt.vf.n nVar, String str) {
        return n(str, nVar != null && nVar.qg(), nVar == null ? null : nVar.n());
    }

    private static String n(String str, boolean z, String str2) {
        if (z) {
            return str;
        }
        com.byazt.vf.l lVar = (com.byazt.vf.l) q.n("app_process");
        return (!lVar.n() && l.qg()) ? str + lVar.qg() : str;
    }

    private static boolean s() {
        if (qg()) {
            return false;
        }
        return l.n();
    }

    private static String w(com.byazt.vf.n nVar, String str) {
        if (nVar == null || TextUtils.isEmpty(nVar.n())) {
            return str;
        }
        return nVar.n() + "_" + str;
    }

    public static boolean qg() {
        return tj.l < 7500;
    }
}

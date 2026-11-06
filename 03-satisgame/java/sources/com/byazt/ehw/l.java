package com.byazt.ehw;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 470, 18})
public class l {
    public static volatile String n;
    public static String q;
    public static volatile String qg;
    public static volatile String s;

    public static void n(String str) {
        if (com.byazt.orb.n.n() != null) {
            com.byazt.orb.n.n().n(str);
        }
        if (TextUtils.isEmpty(str) || str.equals(n)) {
            return;
        }
        com.byazt.ikv.n.n().n("did", str);
        n = str;
    }

    public static String n() {
        if (!TextUtils.isEmpty(n)) {
            return n;
        }
        String strQg = com.byazt.ikv.n.n().qg("did", q);
        n = strQg;
        return strQg;
    }

    public static void qg(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, qg)) {
            return;
        }
        com.byazt.ikv.n.qg().n("dev6101", str);
        qg = str;
    }

    public static String qg() {
        if (!TextUtils.isEmpty(qg)) {
            return qg;
        }
        String strQg = com.byazt.ikv.n.qg().qg("dev6101", q);
        qg = strQg;
        return strQg;
    }

    public static void s(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, s)) {
            return;
        }
        com.byazt.ikv.n.qg().n("dev6102", str);
        s = str;
    }

    public static String s() {
        if (!TextUtils.isEmpty(s)) {
            return s;
        }
        String strQg = com.byazt.ikv.n.qg().qg("dev6102", q);
        s = strQg;
        return strQg;
    }
}

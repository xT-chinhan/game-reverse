package com.byazt.byp;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 74, 26})
public class qg {
    public static boolean n;
    public static boolean qg;

    public static void n(String str) {
        if (!qg) {
            com.byazt.lk.l.n(str, "sp_multi_info").n("is_support_multi_process", true);
        }
        n = true;
        qg = true;
    }

    public static void qg(String str) {
        if (qg) {
            com.byazt.lk.l.n(str, "sp_multi_info").n("is_support_multi_process", false);
        }
        n = false;
    }

    public static boolean n() {
        if (!qg) {
            n = com.byazt.lk.l.n(com.byazt.vgx.s.q(), "sp_multi_info").qg("is_support_multi_process", false);
            qg = true;
        }
        return n;
    }
}

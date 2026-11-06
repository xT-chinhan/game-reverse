package com.byazt.rb;

import com.byazt.tk.k;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1315, 26})
public class qg {
    public static boolean n = true;
    public static boolean qg = false;
    public static int s = 4;

    public static void n(int i) {
        s = i;
    }

    public static void n() {
        qg = true;
        n(3);
    }

    public static boolean qg() {
        return com.byazt.vy.l.n || qg;
    }

    public static void n(String str, String str2) {
        qg();
    }

    public static void n(String str, String str2, Throwable th) {
        qg();
    }

    public static void n(String str) {
        if (qg()) {
            qg("Logger", str);
        }
    }

    public static void qg(String str, String str2) {
        qg();
    }

    public static void s(String str, String str2) {
        qg();
    }

    public static void q(String str, String str2) {
        if (qg() && str2 != null && s <= 6) {
            k.qg(str, str2);
        }
    }
}

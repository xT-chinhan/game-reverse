package com.byazt.yq;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 776, 26})
public final class qg {
    public static volatile String n = "";
    public static volatile boolean qg = true;

    public static void n(String str) {
        if (str == null) {
            str = "";
        }
        n = str;
    }

    public static String n() {
        return n;
    }

    public static void n(boolean z) {
        qg = z;
    }

    public static boolean qg() {
        return qg;
    }
}

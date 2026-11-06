package com.byazt.two;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 802, 21})
public final class x {
    public static final ThreadLocal<String> n = new ThreadLocal<>();

    public static void n(String str) {
        n.set(str);
    }

    public static String n() {
        return n.get();
    }

    public static void qg() {
        n.remove();
    }
}

package com.byazt.km;

import com.byazt.tk.k;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 832, 29})
public class cp {
    public static boolean n = false;
    public static boolean qg = false;

    public static void n(String str) {
    }

    public static void n(String str, Throwable th) {
    }

    public static void q(String str, Throwable th) {
    }

    public static void qg(String str) {
    }

    public static void qg(String str, Throwable th) {
    }

    public static void s(String str, Throwable th) {
        k.n("TeaLog", str, th);
    }

    public static void n(Throwable th) {
        k.n("TeaLog", "", th);
    }

    public static void qg(Throwable th) {
        if (th != null) {
            th.getMessage();
        }
    }
}

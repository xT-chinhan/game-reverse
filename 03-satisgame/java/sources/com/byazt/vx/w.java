package com.byazt.vx;

import com.byazt.tk.k;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1148, 13})
public class w {
    public static boolean n = false;
    public static int qg = 4;

    public static void n(String str) {
    }

    public static void n(String str, String str2) {
    }

    public static void n(String str, String str2, Throwable th) {
    }

    public static void n(Throwable th) {
    }

    public static void q(String str, String str2) {
    }

    public static void q(String str, String str2, Throwable th) {
    }

    public static void qg(String str, String str2) {
    }

    public static void qg(String str, String str2, Throwable th) {
    }

    public static void s(String str, String str2) {
    }

    public static void s(String str, String str2, Throwable th) {
    }

    public static void n(int i) {
        qg = i;
    }

    public static void n() {
        n = true;
        n(3);
    }

    public static void n(String str, Object... objArr) {
        if (n && objArr != null && qg <= 5) {
            n(objArr);
        }
    }

    public static void qg(String str) {
        if (n) {
            l("TTLogger", str);
        }
    }

    public static void l(String str, String str2) {
        if (n && str2 != null && qg <= 6) {
            k.qg(str, str2);
        }
    }

    public static void l(String str, String str2, Throwable th) {
        if (n) {
            if (!(str2 == null && th == null) && qg <= 6) {
                k.n(str, str2, th);
            }
        }
    }

    private static String n(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}

package com.byazt.tk;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, 210})
public final class k {
    public static boolean n = false;
    public static String q = "";
    public static int qg = 4;
    public static com.byazt.okm.n s;

    public static void n(com.byazt.okm.n nVar) {
        s = nVar;
    }

    public static void n(int i) {
        qg = i;
    }

    public static boolean n() {
        return qg <= 3;
    }

    public static void qg() {
        n = true;
        n(3);
    }

    public static boolean s() {
        return n;
    }

    public static void n(String str, String str2) {
        com.byazt.okm.n nVar = s;
        if (nVar != null) {
            nVar.n(qg(str), str2);
        }
        if (str2 == null) {
            return;
        }
        if (str == null) {
            str = "Logger";
        }
        qg(str);
    }

    public static void n(String str) {
        if (n) {
            qg("Logger", str);
        }
    }

    public static void qg(String str, String str2) {
        com.byazt.okm.n nVar = s;
        if (nVar != null) {
            nVar.qg(qg(str), str2);
        }
        if (n && str2 != null && qg <= 6) {
            Log.e(qg(str), str2);
        }
    }

    public static void n(String str, String str2, Throwable th) {
        com.byazt.okm.n nVar = s;
        if (nVar != null) {
            nVar.n(qg(str), str2, th);
        }
        if (n) {
            if (!(str2 == null && th == null) && qg <= 6) {
                Log.e(qg(str), str2, th);
            }
        }
    }

    public static void n(String str, Throwable th) {
        n(str, "", th);
    }

    public static void n(String str, Object... objArr) {
        com.byazt.okm.n nVar = s;
        if (nVar != null) {
            nVar.qg(qg(str), n(objArr));
        }
        if (n && objArr != null && qg <= 6) {
            Log.e(qg(str), n(objArr));
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

    public static String qg(String str) {
        return TextUtils.isEmpty(q) ? str : n("[" + q + "]-[" + str + "]");
    }
}

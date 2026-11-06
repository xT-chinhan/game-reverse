package com.byazt.nl;

import android.text.TextUtils;
import com.byazt.tk.k;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1690, 26})
public class qg {
    public static boolean n = false;
    public static int qg = 4;
    public static String s = "";

    public static void n(int i) {
        qg = i;
    }

    public static void n() {
        n = true;
        n(3);
    }

    public static boolean qg() {
        return n;
    }

    public static void n(String str) {
        if (n) {
            n("Logger", str);
        }
    }

    public static void n(String str, String str2) {
        if (n && str2 != null && qg <= 6) {
            k.qg(qg(str), str2);
        }
    }

    public static void n(String str, String str2, Throwable th) {
        if (n) {
            if (!(str2 == null && th == null) && qg <= 6) {
                k.n(qg(str), str2, th);
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

    private static String qg(String str) {
        return TextUtils.isEmpty(s) ? str : n("[" + s + "]-[" + str + "]");
    }
}

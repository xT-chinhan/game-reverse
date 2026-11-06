package com.byazt.o;

import android.text.TextUtils;
import com.byazt.ca.ho;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1257, 13})
public class hw {
    public static boolean pr = false;
    public static int hw = 4;
    public static String hn = "";

    public static void pr(int i) {
        hw = i;
    }

    public static void pr() {
        pr = true;
        pr(3);
    }

    public static boolean hw() {
        return pr;
    }

    public static void pr(String str) {
        if (!pr) {
            return;
        }
        pr("Logger", str);
    }

    public static void pr(String str, String str2) {
        if (pr && str2 != null && hw <= 6) {
            ho.hw(hw(str), str2);
        }
    }

    public static void pr(String str, String str2, Throwable th) {
        if (!pr) {
            return;
        }
        if ((str2 != null || th != null) && hw <= 6) {
            ho.pr(hw(str), str2, th);
        }
    }

    private static String pr(Object... objArr) {
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

    private static String hw(String str) {
        return TextUtils.isEmpty(hn) ? str : pr("[" + hn + "]-[" + str + "]");
    }
}

package com.byazt.dea;

import com.byazt.ca.ho;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 84, 5})
public class uc {
    public static boolean pr = false;
    public static int hw = 4;

    public static void pr(int i) {
        hw = i;
    }

    public static void pr() {
        pr = true;
        pr(3);
    }

    public static void pr(String str, String str2) {
    }

    public static void pr(String str, String str2, Throwable th) {
    }

    public static void hw(String str, String str2) {
    }

    public static void hw(String str, String str2, Throwable th) {
    }

    public static void pr(String str, Object... objArr) {
        if (pr && objArr != null && hw <= 3) {
            pr(objArr);
        }
    }

    public static void pr(String str) {
    }

    public static void hn(String str, String str2) {
    }

    public static void hn(String str, String str2, Throwable th) {
    }

    public static void x(String str, String str2) {
    }

    public static void x(String str, String str2, Throwable th) {
    }

    public static void hw(String str, Object... objArr) {
        if (pr && objArr != null && hw <= 5) {
            pr(objArr);
        }
    }

    public static void hw(String str) {
        if (!pr) {
            return;
        }
        c("TTLogger", str);
    }

    public static void c(String str, String str2) {
        if (pr && str2 != null && hw <= 6) {
            ho.hw(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (!pr) {
            return;
        }
        if ((str2 != null || th != null) && hw <= 6) {
            ho.pr(str, str2, th);
        }
    }

    public static void pr(Throwable th) {
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
}

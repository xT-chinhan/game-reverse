package com.bytedance.sdk.openadsdk.api;

import com.bytedance.sdk.component.utils.sl;

/* JADX INFO: loaded from: classes2.dex */
public class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static boolean f1774ms = false;
    private static int xr = 4;

    public static void ms(String str, String str2) {
    }

    public static void ms(String str, String str2, Throwable th) {
    }

    public static void xr(String str, String str2) {
    }

    public static void xr(String str, String str2, Throwable th) {
    }

    public static void ms(int i) {
        xr = i;
    }

    public static void ms() {
        f1774ms = true;
        ms(3);
    }

    public static void ms(String str, Object... objArr) {
        if (f1774ms && objArr != null && xr <= 3) {
            ms(objArr);
        }
    }

    public static void ah(String str, String str2) {
        if (f1774ms && str2 != null && xr <= 4) {
            sl.ms(str, str2);
        }
    }

    public static void ah(String str, String str2, Throwable th) {
        if (f1774ms) {
            if (!(str2 == null && th == null) && xr <= 4) {
                sl.ms(str, str2, th);
            }
        }
    }

    public static void ms(String str) {
        if (f1774ms) {
            d("TTLogger", str);
        }
    }

    public static void d(String str, String str2) {
        if (f1774ms && str2 != null && xr <= 5) {
            sl.xr(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (f1774ms) {
            if (!(str2 == null && th == null) && xr <= 5) {
                sl.xr(str, str2, th);
            }
        }
    }

    public static void xr(String str, Object... objArr) {
        if (f1774ms && objArr != null && xr <= 5) {
            ms(objArr);
        }
    }

    public static void xr(String str) {
        if (f1774ms) {
            ka("TTLogger", str);
        }
    }

    public static void ka(String str, String str2) {
        if (f1774ms && str2 != null && xr <= 6) {
            sl.d(str, str2);
        }
    }

    public static void ka(String str, String str2, Throwable th) {
        if (f1774ms) {
            if (!(str2 == null && th == null) && xr <= 6) {
                sl.ah(str, str2, th);
            }
        }
    }

    private static String ms(Object... objArr) {
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

    public static void ms(Throwable th) {
        d("TTLogger", "", th);
    }
}

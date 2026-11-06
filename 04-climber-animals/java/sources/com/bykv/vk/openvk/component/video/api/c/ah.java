package com.bykv.vk.openvk.component.video.api.c;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;

/* JADX INFO: loaded from: classes.dex */
public class ah {
    private static String ah = "";

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static boolean f19ms = false;
    private static int xr = 4;

    public static void ms(int i) {
        xr = i;
    }

    public static void ms() {
        f19ms = true;
        ms(3);
    }

    public static boolean xr() {
        return f19ms;
    }

    public static void ms(String str) {
        if (f19ms) {
            ms("Logger", str);
        }
    }

    public static void ms(String str, String str2) {
        if (f19ms && str2 != null && xr <= 4) {
            sl.ms(ah(str), str2);
        }
    }

    public static void ms(String str, String str2, Throwable th) {
        if (f19ms) {
            if (!(str2 == null && th == null) && xr <= 4) {
                sl.ms(ah(str), str2, th);
            }
        }
    }

    public static void ms(String str, Object... objArr) {
        if (f19ms && objArr != null && xr <= 4) {
            ah(str);
            ms(objArr);
        }
    }

    public static void xr(String str, String str2) {
        if (f19ms && str2 != null && xr <= 5) {
            sl.xr(ah(str), str2);
        }
    }

    public static void xr(String str, String str2, Throwable th) {
        if (f19ms) {
            if (!(str2 == null && th == null) && xr <= 5) {
                sl.xr(ah(str), str2, th);
            }
        }
    }

    public static void xr(String str, Object... objArr) {
        if (f19ms && objArr != null && xr <= 5) {
            ah(str);
            ms(objArr);
        }
    }

    public static void xr(String str) {
        if (f19ms) {
            ah("Logger", str);
        }
    }

    public static void ah(String str, String str2) {
        if (f19ms && str2 != null && xr <= 6) {
            sl.d(ah(str), str2);
        }
    }

    public static void ah(String str, String str2, Throwable th) {
        if (f19ms) {
            if (!(str2 == null && th == null) && xr <= 6) {
                sl.ah(ah(str), str2, th);
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

    private static String ah(String str) {
        return TextUtils.isEmpty(ah) ? str : ms("[" + ah + "]-[" + str + "]");
    }
}

package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class sl {
    private static com.bytedance.sdk.component.ms ah = null;
    private static String d = "";

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static boolean f1366ms = false;
    private static int xr = 4;

    public static void ms(com.bytedance.sdk.component.ms msVar) {
        ah = msVar;
    }

    public static void ms(int i) {
        xr = i;
    }

    public static boolean ms() {
        return xr <= 3;
    }

    public static void xr() {
        f1366ms = true;
        ms(3);
    }

    public static boolean ah() {
        return f1366ms;
    }

    public static void ms(String str, String str2) {
        com.bytedance.sdk.component.ms msVar = ah;
        if (msVar != null) {
            msVar.ms(ah(str), str2);
        }
        if (f1366ms && str2 != null && xr <= 4) {
            Log.i(ah(str), str2);
        }
    }

    public static void ms(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.ms msVar = ah;
        if (msVar != null) {
            msVar.ms(ah(str), str2 + Log.getStackTraceString(th));
        }
        if (f1366ms) {
            if (!(str2 == null && th == null) && xr <= 4) {
                Log.i(ah(str), str2, th);
            }
        }
    }

    public static void ms(String str, Object... objArr) {
        com.bytedance.sdk.component.ms msVar = ah;
        if (msVar != null) {
            msVar.ms(ah(str), ms(objArr));
        }
        if (f1366ms && objArr != null && xr <= 4) {
            Log.i(ah(str), ms(objArr));
        }
    }

    public static void ms(String str) {
        if (f1366ms) {
            xr("Logger", str);
        }
    }

    public static void xr(String str, String str2) {
        com.bytedance.sdk.component.ms msVar = ah;
        if (msVar != null) {
            msVar.xr(ah(str), str2);
        }
        if (f1366ms && str2 != null && xr <= 5) {
            Log.w(ah(str), str2);
        }
    }

    public static void xr(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.ms msVar = ah;
        if (msVar != null) {
            msVar.ms(ah(str), str2, th);
        }
        if (f1366ms) {
            if (!(str2 == null && th == null) && xr <= 5) {
                Log.w(ah(str), str2, th);
            }
        }
    }

    public static void xr(String str, Object... objArr) {
        com.bytedance.sdk.component.ms msVar = ah;
        if (msVar != null) {
            msVar.xr(ah(str), ms(objArr));
        }
        if (f1366ms && objArr != null && xr <= 5) {
            Log.w(ah(str), ms(objArr));
        }
    }

    public static void ah(String str, String str2) {
        com.bytedance.sdk.component.ms msVar = ah;
        if (msVar != null) {
            msVar.ms(ah(str), str2);
        }
        if (str2 == null) {
            return;
        }
        if (str == null) {
            str = "Logger";
        }
        Log.i(ah(str), str2);
    }

    public static void xr(String str) {
        if (f1366ms) {
            d("Logger", str);
        }
    }

    public static void d(String str, String str2) {
        com.bytedance.sdk.component.ms msVar = ah;
        if (msVar != null) {
            msVar.ah(ah(str), str2);
        }
        if (f1366ms && str2 != null && xr <= 6) {
            Log.e(ah(str), str2);
        }
    }

    public static void ah(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.ms msVar = ah;
        if (msVar != null) {
            msVar.xr(ah(str), str2, th);
        }
        if (f1366ms) {
            if (!(str2 == null && th == null) && xr <= 6) {
                Log.e(ah(str), str2, th);
            }
        }
    }

    public static void ah(String str, Object... objArr) {
        com.bytedance.sdk.component.ms msVar = ah;
        if (msVar != null) {
            msVar.ah(ah(str), ms(objArr));
        }
        if (f1366ms && objArr != null && xr <= 6) {
            Log.e(ah(str), ms(objArr));
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

    public static String ah(String str) {
        return TextUtils.isEmpty(d) ? str : ms("[" + d + "]-[" + str + "]");
    }

    public static void ms(Throwable th) {
        xr(d, "", th);
    }

    public static void ms(int i, String str, String str2) {
        ms(str, str2);
    }
}

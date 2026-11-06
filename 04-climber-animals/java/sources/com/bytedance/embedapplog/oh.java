package com.bytedance.embedapplog;

/* JADX INFO: loaded from: classes2.dex */
public class oh {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static boolean f511ms = false;
    public static boolean xr = false;

    public static void ms(String str) {
    }

    public static void ms(String str, Throwable th) {
    }

    public static void xr(String str) {
        xr(str, null);
    }

    public static void xr(String str, Throwable th) {
        com.bytedance.sdk.component.utils.sl.xr("TeaLog", str, th);
    }

    public static void ah(String str, Throwable th) {
        com.bytedance.sdk.component.utils.sl.ah("TeaLog", str, th);
    }

    public static void ms(Throwable th) {
        com.bytedance.sdk.component.utils.sl.ah("TeaLog", "", th);
    }

    public static void d(String str, Throwable th) {
        com.bytedance.sdk.component.utils.sl.ms("TeaLog", str, th);
    }

    public static void xr(Throwable th) {
        if (th != null) {
            com.bytedance.sdk.component.utils.sl.ms("TeaLog", th.getMessage());
        }
    }
}

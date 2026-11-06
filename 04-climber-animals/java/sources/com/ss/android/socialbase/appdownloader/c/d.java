package com.ss.android.socialbase.appdownloader.c;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.ab;
import com.tencent.bugly.Bugly;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private static String ah;
    private static String d;
    private static Boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f4561ms;
    private static String xr;

    public static boolean ms(Context context) {
        return context != null && ah(context) == 0 && ka();
    }

    public static boolean xr(Context context) {
        return context != null && d(context) == 0 && c();
    }

    public static String ms() {
        if (f4561ms == null) {
            f4561ms = ms("getApiVersion");
        }
        return f4561ms;
    }

    public static String xr() {
        if (xr == null) {
            xr = ms("getVersion");
        }
        return xr;
    }

    public static String ah() {
        if (ah == null) {
            ah = ms("getReleaseType");
        }
        return ah;
    }

    public static String d() {
        if (d == null) {
            d = ms("getBuildVersion");
        }
        return d;
    }

    public static int ah(Context context) {
        if (context == null) {
            return 1;
        }
        if (xr(xr(), ms())) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1;
        }
        return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
    }

    public static int d(Context context) {
        return (context == null || Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) ? 1 : 0;
    }

    public static boolean ka() {
        if (ka == null) {
            ka = Boolean.FALSE;
            try {
                ka = Boolean.valueOf("156".equals(ms("ro.config.hw_optb", "0")) && "true".equals(ms("hw_mc.pure_mode.enable", Bugly.SDK_IS_DEV)));
            } catch (Exception unused) {
            }
        }
        return ka.booleanValue();
    }

    public static boolean c() {
        return ka() && xr(xr(), ms()) && ms(Process.myUid()) == 0;
    }

    public static String ab() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String ms(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static int ms(int i) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.UserHandleEx");
            return ((Integer) cls.getMethod("getUserId", Integer.TYPE).invoke(cls, Integer.valueOf(i))).intValue();
        } catch (Throwable th) {
            ab.ms(th);
            return 1;
        }
    }

    private static String ms(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean xr(String str, String str2) {
        return !TextUtils.isEmpty(str2) && str.startsWith("3");
    }
}

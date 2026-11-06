package com.bytedance.sdk.openadsdk.core.jw;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.tencent.bugly.Bugly;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zb {
    private static int ab = 1;
    private static Boolean ah = null;
    private static Boolean c = null;
    private static String d = null;
    private static String ka = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f2759ms = null;
    private static int x = 1;
    private static String xr;

    public static void ms() {
        if (ah == null) {
            if (d() || ah()) {
                try {
                    Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                    ah = Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
                } catch (Throwable unused) {
                    ah = Boolean.FALSE;
                }
                if (f2759ms == null) {
                    f2759ms = ms("getApiVersion");
                }
                if (xr == null) {
                    xr = ms("getVersion");
                }
                if (ka == null) {
                    ka = ms("getReleaseType");
                }
                if (d == null) {
                    d = ms("getBuildVersion");
                }
                if (c == null) {
                    c = Boolean.FALSE;
                    try {
                        c = Boolean.valueOf("156".equals(xr("ro.config.hw_optb", "0")) && "true".equals(xr("hw_mc.pure_mode.enable", Bugly.SDK_IS_DEV)));
                    } catch (Exception unused2) {
                    }
                }
                try {
                    ab = Settings.Secure.getInt(com.bytedance.sdk.openadsdk.core.re.getContext().getContentResolver(), "pure_enhanced_mode_state", 1);
                } catch (Throwable unused3) {
                }
                try {
                    Class<?> cls2 = Class.forName("com.huawei.android.os.UserHandleEx");
                    x = ((Integer) cls2.getMethod("getUserId", Integer.TYPE).invoke(cls2, Integer.valueOf(Process.myUid()))).intValue();
                    return;
                } catch (Throwable unused4) {
                    return;
                }
            }
            ah = Boolean.FALSE;
        }
    }

    public static boolean xr() {
        Boolean bool = ah;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean ah() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toUpperCase().startsWith("HUAWEI")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toUpperCase().startsWith("HUAWEI");
        }
        return true;
    }

    public static boolean d() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toUpperCase().startsWith("HONOR")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toUpperCase().startsWith("HONOR");
        }
        return true;
    }

    public static String ka() {
        return f2759ms;
    }

    public static String c() {
        return xr;
    }

    public static String ab() {
        return ka;
    }

    public static String x() {
        return d;
    }

    private static String ms(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean ms(Context context) {
        return context != null && xr(context) == 0 && sl();
    }

    public static void ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            int i = 1;
            jSONObject.put("pure_enhanced_mode", ny() ? 1 : 2);
            if (!ch()) {
                i = 2;
            }
            jSONObject.put("pure_enhanced_mode_enable", i);
        } catch (Throwable unused) {
        }
    }

    public static boolean ny() {
        return hi() == 0 && ch();
    }

    public static boolean ch() {
        return sl() && ms(c(), ka()) && zb() == 0;
    }

    public static int hi() {
        return ab;
    }

    private static boolean ms(String str, String str2) {
        return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !str.startsWith("3")) ? false : true;
    }

    private static int zb() {
        return x;
    }

    private static int xr(Context context) {
        if (context != null) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
        }
        return 1;
    }

    public static boolean sl() {
        Boolean bool = c;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private static String xr(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
            return str2;
        } catch (Throwable unused) {
            return str2;
        }
    }
}

package com.byazt.ehw;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 470, 5})
public class q {
    public static int fs = 1;
    public static String l = null;
    public static String n = null;
    public static String q = null;
    public static String qg = null;
    public static Boolean s = null;
    public static Boolean w = null;
    public static int x = 1;

    public static void n() {
        if (s == null) {
            if (q() || s()) {
                try {
                    Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                    s = Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
                } catch (Throwable unused) {
                    s = Boolean.FALSE;
                }
                if (n == null) {
                    n = n("getApiVersion");
                }
                if (qg == null) {
                    qg = n("getVersion");
                }
                if (l == null) {
                    l = n("getReleaseType");
                }
                if (q == null) {
                    q = n("getBuildVersion");
                }
                if (w == null) {
                    w = Boolean.FALSE;
                    try {
                        w = Boolean.valueOf("156".equals(qg("ro.config.hw_optb", "0")) && "true".equals(qg("hw_mc.pure_mode.enable", "false")));
                    } catch (Exception unused2) {
                    }
                }
                try {
                    x = Settings.Secure.getInt(com.byazt.nf.rv.getContext().getContentResolver(), "pure_enhanced_mode_state", 1);
                } catch (Throwable unused3) {
                }
                try {
                    Class<?> cls2 = Class.forName("com.huawei.android.os.UserHandleEx");
                    fs = ((Integer) cls2.getMethod("getUserId", Integer.TYPE).invoke(cls2, Integer.valueOf(Process.myUid()))).intValue();
                    return;
                } catch (Throwable unused4) {
                    return;
                }
            }
            s = Boolean.FALSE;
        }
    }

    public static boolean qg() {
        Boolean bool = s;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean s() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toUpperCase().startsWith("HUAWEI")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toUpperCase().startsWith("HUAWEI");
        }
        return true;
    }

    public static boolean q() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toUpperCase().startsWith("HONOR")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toUpperCase().startsWith("HONOR");
        }
        return true;
    }

    public static String l() {
        return n;
    }

    public static String w() {
        return qg;
    }

    public static String x() {
        return l;
    }

    public static String fs() {
        return q;
    }

    private static String n(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean n(Context context) {
        return context != null && qg(context) == 0 && d();
    }

    public static void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            int i = 1;
            jSONObject.put("pure_enhanced_mode", rv() ? 1 : 2);
            if (!tj()) {
                i = 2;
            }
            jSONObject.put("pure_enhanced_mode_enable", i);
        } catch (Throwable unused) {
        }
    }

    public static boolean rv() {
        return cp() == 0 && tj();
    }

    public static boolean tj() {
        return d() && n(w(), l()) && oa() == 0;
    }

    public static int cp() {
        return x;
    }

    private static boolean n(String str, String str2) {
        return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !str.startsWith("3")) ? false : true;
    }

    private static int oa() {
        return fs;
    }

    private static int qg(Context context) {
        if (context != null) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
        }
        return 1;
    }

    public static boolean d() {
        Boolean bool = w;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private static String qg(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }
}

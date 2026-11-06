package com.byazt.now;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.qq.e.comm.managers.setting.GlobalSetting;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1862, 121})
public class x {
    public static Boolean c;
    public static String hn;
    public static String hw;
    public static String pr;
    public static String x;

    public static boolean pr(Context context) {
        return context != null && hn(context) == 0 && c();
    }

    public static boolean hw(Context context) {
        return context != null && x(context) == 0 && uc();
    }

    public static String pr() {
        if (pr == null) {
            pr = pr("getApiVersion");
        }
        return pr;
    }

    public static String hw() {
        if (hw == null) {
            hw = pr("getVersion");
        }
        return hw;
    }

    public static String hn() {
        if (hn == null) {
            hn = pr("getReleaseType");
        }
        return hn;
    }

    public static String x() {
        if (x == null) {
            x = pr("getBuildVersion");
        }
        return x;
    }

    public static int hn(Context context) {
        if (context == null) {
            return 1;
        }
        if (hw(hw(), pr())) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1;
        }
        return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
    }

    public static int x(Context context) {
        if (context == null || Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) {
            return 1;
        }
        return 0;
    }

    public static boolean c() {
        if (c == null) {
            c = Boolean.FALSE;
            try {
                c = Boolean.valueOf("156".equals(pr("ro.config.hw_optb", "0")) && "true".equals(pr("hw_mc.pure_mode.enable", "false")));
            } catch (Exception e) {
            }
        }
        return c.booleanValue();
    }

    public static boolean uc() {
        if (c() && hw(hw(), pr()) && pr(Process.myUid()) == 0) {
            return true;
        }
        return false;
    }

    public static String fw() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable th) {
            return "";
        }
    }

    private static String pr(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable th) {
            return str2;
        }
    }

    private static int pr(int i) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.UserHandleEx");
            return ((Integer) cls.getMethod("getUserId", Integer.TYPE).invoke(cls, Integer.valueOf(i))).intValue();
        } catch (Throwable th) {
            return 1;
        }
    }

    private static String pr(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean hw(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str.startsWith(GlobalSetting.SPLASH_AD)) {
            return true;
        }
        return false;
    }
}

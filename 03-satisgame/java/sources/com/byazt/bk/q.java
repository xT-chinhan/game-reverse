package com.byazt.bk;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 5})
public class q {
    public static Boolean l;
    public static String n;
    public static String q;
    public static String qg;
    public static String s;

    public static boolean n(Context context) {
        return context != null && s(context) == 0 && l();
    }

    public static boolean qg(Context context) {
        return context != null && q(context) == 0 && w();
    }

    public static String n() {
        if (n == null) {
            n = n("getApiVersion");
        }
        return n;
    }

    public static String qg() {
        if (qg == null) {
            qg = n("getVersion");
        }
        return qg;
    }

    public static String s() {
        if (s == null) {
            s = n("getReleaseType");
        }
        return s;
    }

    public static String q() {
        if (q == null) {
            q = n("getBuildVersion");
        }
        return q;
    }

    public static int s(Context context) {
        if (context == null) {
            return 1;
        }
        if (qg(qg(), n())) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1;
        }
        return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
    }

    public static int q(Context context) {
        return (context == null || Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) ? 1 : 0;
    }

    public static boolean l() {
        if (l == null) {
            l = Boolean.FALSE;
            try {
                l = Boolean.valueOf("156".equals(n("ro.config.hw_optb", "0")) && "true".equals(n("hw_mc.pure_mode.enable", "false")));
            } catch (Exception unused) {
            }
        }
        return l.booleanValue();
    }

    public static boolean w() {
        return l() && qg(qg(), n()) && n(Process.myUid()) == 0;
    }

    public static String x() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String n(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static int n(int i) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.UserHandleEx");
            return ((Integer) cls.getMethod("getUserId", Integer.TYPE).invoke(cls, Integer.valueOf(i))).intValue();
        } catch (Throwable unused) {
            return 1;
        }
    }

    private static String n(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean qg(String str, String str2) {
        return !TextUtils.isEmpty(str2) && str.startsWith("3");
    }
}

package com.byazt.wt;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.managers.setting.GlobalSetting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 250})
public class k {
    public static String hw;
    public static String pr;
    public static Boolean hn = null;
    public static String x = null;
    public static String c = null;
    public static Boolean uc = null;
    public static int fw = 1;
    public static int zo = 1;

    public static void pr() {
        if (hn == null) {
            if (x() || hn()) {
                try {
                    Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                    hn = Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
                } catch (Throwable th) {
                    hn = Boolean.FALSE;
                }
                if (pr == null) {
                    pr = pr("getApiVersion");
                }
                if (hw == null) {
                    hw = pr("getVersion");
                }
                if (c == null) {
                    c = pr("getReleaseType");
                }
                if (x == null) {
                    x = pr("getBuildVersion");
                }
                if (uc == null) {
                    uc = Boolean.FALSE;
                    try {
                        uc = Boolean.valueOf("156".equals(hw("ro.config.hw_optb", "0")) && "true".equals(hw("hw_mc.pure_mode.enable", "false")));
                    } catch (Exception e) {
                    }
                }
                try {
                    fw = Settings.Secure.getInt(com.byazt.sd.a.getContext().getContentResolver(), "pure_enhanced_mode_state", 1);
                } catch (Throwable th2) {
                }
                try {
                    Class<?> cls2 = Class.forName("com.huawei.android.os.UserHandleEx");
                    zo = ((Integer) cls2.getMethod("getUserId", Integer.TYPE).invoke(cls2, Integer.valueOf(Process.myUid()))).intValue();
                    return;
                } catch (Throwable th3) {
                    return;
                }
            }
            hn = Boolean.FALSE;
        }
    }

    public static boolean hw() {
        Boolean bool = hn;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean hn() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toUpperCase().startsWith("HUAWEI")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toUpperCase().startsWith("HUAWEI");
        }
        return true;
    }

    public static boolean x() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toUpperCase().startsWith("HONOR")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toUpperCase().startsWith("HONOR");
        }
        return true;
    }

    public static String c() {
        return pr;
    }

    public static String uc() {
        return hw;
    }

    public static String fw() {
        return c;
    }

    public static String zo() {
        return x;
    }

    private static String pr(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean pr(Context context) {
        return context != null && hw(context) == 0 && k();
    }

    public static void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            int i = 1;
            jSONObject.put("pure_enhanced_mode", aj() ? 1 : 2);
            if (!vk()) {
                i = 2;
            }
            jSONObject.put("pure_enhanced_mode_enable", i);
        } catch (Throwable th) {
        }
    }

    public static boolean aj() {
        return w() == 0 && vk();
    }

    public static boolean vk() {
        if (k() && pr(uc(), c()) && m() == 0) {
            return true;
        }
        return false;
    }

    public static int w() {
        return fw;
    }

    private static boolean pr(String str, String str2) {
        return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !str.startsWith(GlobalSetting.SPLASH_AD)) ? false : true;
    }

    private static int m() {
        return zo;
    }

    private static int hw(Context context) {
        if (context != null) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
        }
        return 1;
    }

    public static boolean k() {
        Boolean bool = uc;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private static String hw(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e) {
            return str2;
        }
    }
}

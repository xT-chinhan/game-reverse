package com.byazt.wt;

import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 110})
public class z {
    public static String zo;
    public static final CharSequence hn = "sony";
    public static final CharSequence x = "amigo";
    public static final CharSequence c = "funtouch";
    public static final CharSequence uc = LiveConfigKey.ORIGIN;
    public static volatile int pr = 0;
    public static int hw = 0;
    public static int fw = Integer.MAX_VALUE;

    public static String pr() {
        return pr("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static String hw() {
        if (a()) {
            return "miui_" + pr("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
        }
        return "";
    }

    public static String hn() {
        String str = Build.DISPLAY;
        if (str != null && str.toLowerCase().contains("flyme")) {
            return str;
        }
        return "";
    }

    public static String x() {
        if (yb()) {
            return "coloros_" + pr("ro.build.version.kllkrom") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static String c() {
        String strIu = ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).iu();
        if (strIu == null) {
            return "";
        }
        if (strIu.toLowerCase().contains("emotionui") || strIu.toLowerCase().contains("magicui")) {
            return strIu + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static boolean uc() {
        String strPr = pr("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(strPr)) {
            return false;
        }
        return strPr.toLowerCase().contains(c) || strPr.toLowerCase().contains(LiveConfigKey.ORIGIN);
    }

    public static String fw() {
        return "vivo_" + pr("ro.vivo.os.build.display.id") + "_" + pr("ro.vivo.product.version");
    }

    public static boolean zo() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(x);
    }

    public static boolean aj() {
        try {
            return "FreemeOS".equalsIgnoreCase(pr("ro.build.freemeos_label"));
        } catch (Throwable th) {
            return false;
        }
    }

    public static String vk() {
        return Build.DISPLAY + "_" + pr("ro.gn.sv.version");
    }

    public static boolean w() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String k() {
        if (m()) {
            return "eui_" + pr("ro.letv.release.version") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static boolean m() {
        return !TextUtils.isEmpty(pr("ro.letv.release.version"));
    }

    public static String g() {
        if (TextUtils.isEmpty(zo)) {
            zo = ny();
        }
        return zo;
    }

    private static String ny() {
        if (a()) {
            return hw();
        }
        if (cz()) {
            return hn();
        }
        if (yb()) {
            return x();
        }
        String strC = c();
        if (!TextUtils.isEmpty(strC)) {
            return strC;
        }
        if (uc()) {
            return fw();
        }
        if (zo()) {
            return vk();
        }
        if (w()) {
            return pr();
        }
        String strK = k();
        if (!TextUtils.isEmpty(strK)) {
            return strK;
        }
        if (Build.MANUFACTURER.toLowerCase(Locale.ROOT).contains("oneplus")) {
            return "oneplus_" + Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
        }
        if (lb()) {
            return "honor_" + ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).iu();
        }
        if (aj()) {
            return "freeme_" + ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).iu();
        }
        return Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
    }

    public static boolean ho() {
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
            }
        } catch (Exception e) {
            com.byazt.ca.ho.hw("romUtil", e.getMessage());
        }
        return false;
    }

    public static boolean nt() {
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                return str.toLowerCase().contains("vivo");
            }
            return false;
        } catch (Exception e) {
            com.byazt.ca.ho.hw("romUtils", e.getMessage());
            return false;
        }
    }

    public static boolean yb() {
        if (fw == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String strK = ls.k("kllk");
            if (!TextUtils.isEmpty(str) && str.toLowerCase(Locale.ROOT).contains(strK)) {
                fw = 1;
            } else {
                fw = 0;
            }
        }
        return fw == 1;
    }

    public static boolean lb() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("honor")) {
            return (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor")) || "HONOR".equalsIgnoreCase(Build.MANUFACTURER);
        }
        return true;
    }

    public static String pr(String str) {
        com.byazt.vkw.er erVar = (com.byazt.vkw.er) com.byazt.zs.uc.pr("system_info");
        if (erVar != null) {
            return erVar.pr(str);
        }
        return "";
    }

    public static int qa() {
        try {
            return (int) Os.sysconf(OsConstants._SC_PAGESIZE);
        } catch (Throwable th) {
            return 4097;
        }
    }

    public static boolean a() {
        if (pr == 0) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    pr = 1;
                } else {
                    pr = 2;
                }
            } catch (Throwable th) {
                pr = 2;
            }
        }
        return pr == 1;
    }

    public static boolean cz() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }
}

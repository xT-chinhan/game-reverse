package com.byazt.ehw;

import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.fragment.app.FragmentTransaction;
import com.byazt.tk.k;
import com.byazt.vf.oa;
import com.byazt.vf.u;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 470, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static String fs = null;
    public static volatile int n = 0;
    public static int qg = 0;
    public static int x = Integer.MAX_VALUE;
    public static final CharSequence s = "sony";
    public static final CharSequence q = "amigo";
    public static final CharSequence l = "funtouch";
    public static final CharSequence w = LiveConfigKey.ORIGIN;

    public static String n() {
        return n("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static String qg() {
        return a() ? "miui_" + n("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    public static String s() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static String q() {
        return hd() ? "coloros_" + n("ro.build.version.kllkrom") + "_" + Build.DISPLAY : "";
    }

    public static String l() {
        String strT = ((oa) com.byazt.qp.q.n("device_info_new")).t();
        if (strT != null) {
            return (strT.toLowerCase().contains("emotionui") || strT.toLowerCase().contains("magicui")) ? strT + "_" + Build.DISPLAY : "";
        }
        return "";
    }

    public static boolean w() {
        String strN = n("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(strN)) {
            return false;
        }
        return strN.toLowerCase().contains(l) || strN.toLowerCase().contains(LiveConfigKey.ORIGIN);
    }

    public static String x() {
        return "vivo_" + n("ro.vivo.os.build.display.id") + "_" + n("ro.vivo.product.version");
    }

    public static boolean fs() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(q);
    }

    public static boolean rv() {
        try {
            return "FreemeOS".equalsIgnoreCase(n("ro.build.freemeos_label"));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String tj() {
        return Build.DISPLAY + "_" + n("ro.gn.sv.version");
    }

    public static boolean cp() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String d() {
        return oa() ? "eui_" + n("ro.letv.release.version") + "_" + Build.DISPLAY : "";
    }

    public static boolean oa() {
        return !TextUtils.isEmpty(n("ro.letv.release.version"));
    }

    public static String sz() {
        if (TextUtils.isEmpty(fs)) {
            fs = ou();
        }
        return fs;
    }

    private static String ou() {
        if (a()) {
            return qg();
        }
        if (py()) {
            return s();
        }
        if (hd()) {
            return q();
        }
        String strL = l();
        if (!TextUtils.isEmpty(strL)) {
            return strL;
        }
        if (w()) {
            return x();
        }
        if (fs()) {
            return tj();
        }
        if (cp()) {
            return n();
        }
        String strD = d();
        if (!TextUtils.isEmpty(strD)) {
            return strD;
        }
        if (Build.MANUFACTURER.toLowerCase(Locale.ROOT).contains("oneplus")) {
            return "oneplus_" + Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
        }
        if (cd()) {
            return "honor_" + ((oa) com.byazt.qp.q.n("device_info_new")).t();
        }
        if (rv()) {
            return "freeme_" + ((oa) com.byazt.qp.q.n("device_info_new")).t();
        }
        return Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
    }

    public static boolean k() {
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
            }
        } catch (Exception e) {
            k.qg("romUtil", e.getMessage());
        }
        return false;
    }

    public static boolean cy() {
        try {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.toLowerCase().contains("vivo");
        } catch (Exception e) {
            k.qg("romUtils", e.getMessage());
            return false;
        }
    }

    public static boolean hd() {
        if (x == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String strD = com.byazt.vgx.w.d("kllk");
            if (!TextUtils.isEmpty(str) && str.toLowerCase(Locale.ROOT).contains(strD)) {
                x = 1;
            } else {
                x = 0;
            }
        }
        return x == 1;
    }

    public static boolean cd() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("honor")) {
            return (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor")) || "HONOR".equalsIgnoreCase(Build.MANUFACTURER);
        }
        return true;
    }

    public static String n(String str) {
        u uVar = (u) com.byazt.qp.q.n("system_info");
        return uVar != null ? uVar.n(str) : "";
    }

    public static int um() {
        try {
            return (int) Os.sysconf(OsConstants._SC_PAGESIZE);
        } catch (Throwable unused) {
            return FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
    }

    public static boolean a() {
        if (n == 0) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    n = 1;
                } else {
                    n = 2;
                }
            } catch (Throwable unused) {
                n = 2;
            }
        }
        return n == 1;
    }

    public static boolean py() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }
}

package com.byazt.sd;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.km.sz;
import com.byazt.km.tj;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 506, 19})
public class n {
    public static final CharSequence n = "sony";
    public static final CharSequence qg = "amigo";
    public static final CharSequence s = "funtouch";
    public static final AbstractC0332n<Boolean> q = new AbstractC0332n<Boolean>() { // from class: com.byazt.sd.n.1
        @Override // com.byazt.sd.n.AbstractC0332n
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public Boolean qg(Object... objArr) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                return Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            } catch (Throwable unused) {
                return Boolean.FALSE;
            }
        }
    };

    public static String n() {
        return n("ro.build.version.emui");
    }

    public static String qg() {
        if (sz()) {
            return k();
        }
        if (w()) {
            return hd();
        }
        if (cd()) {
            return a();
        }
        String strCy = cy();
        if (!TextUtils.isEmpty(strCy)) {
            return strCy;
        }
        if (x()) {
            return l();
        }
        if (fs()) {
            return rv();
        }
        if (q()) {
            return s();
        }
        String strTj = tj();
        return !TextUtils.isEmpty(strTj) ? strTj : Build.DISPLAY;
    }

    public static String s() {
        return n("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean q() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String l() {
        return n("ro.vivo.os.build.display.id") + "_" + n("ro.vivo.product.version");
    }

    public static boolean w() {
        return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    public static boolean x() {
        String strN = n("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strN) && strN.toLowerCase().contains(s);
    }

    public static boolean fs() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(qg);
    }

    public static String rv() {
        return Build.DISPLAY + "_" + n("ro.gn.sv.version");
    }

    public static String tj() {
        return cp() ? "eui_" + n("ro.letv.release.version") + "_" + Build.DISPLAY : "";
    }

    public static boolean cp() {
        return !TextUtils.isEmpty(n("ro.letv.release.version"));
    }

    public static boolean d() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("honor")) {
            return (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor")) || "HONOR".equalsIgnoreCase(Build.MANUFACTURER);
        }
        return true;
    }

    public static boolean oa() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return !TextUtils.isEmpty((String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui"));
        } catch (Exception e) {
            k.qg("Honor", e.getMessage());
        }
    }

    public static boolean sz() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String k() {
        return sz() ? "miui_" + n("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    public static String cy() {
        String strN = n();
        if (strN != null) {
            return (strN.toLowerCase().contains("emotionui") || strN.toLowerCase().contains("magicui")) ? strN + "_" + Build.DISPLAY : "";
        }
        return "";
    }

    public static String hd() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean cd() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    public static boolean um() {
        return Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("REDMI");
    }

    public static String a() {
        return cd() ? "coloros_" + n("ro.build.version.opporom") + "_" + Build.DISPLAY : "";
    }

    private static String n(String str) {
        String strN = tj.n(str);
        return !TextUtils.isEmpty(strN) ? strN : sz.n(str);
    }

    public static boolean py() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean ou() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean wm() {
        return "samsung".equalsIgnoreCase(Build.BRAND) || "samsung".equalsIgnoreCase(Build.MANUFACTURER);
    }

    private static String t() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static boolean m() {
        if ("lenovo".equalsIgnoreCase(Build.BRAND) || "motorola".equalsIgnoreCase(Build.MANUFACTURER)) {
            return true;
        }
        String str = Build.FINGERPRINT;
        if (!TextUtils.isEmpty(str)) {
            return str.contains("VIBEUI_V2");
        }
        String strN = n("ro.build.version.incremental");
        return !TextUtils.isEmpty(strN) && strN.contains("VIBEUI_V2");
    }

    public static boolean hu() {
        return t().toUpperCase().contains("NUBIA");
    }

    public static boolean h() {
        return t().toUpperCase().contains("ASUS");
    }

    public static boolean n(Context context) {
        return t().toUpperCase().contains("HUAWEI");
    }

    /* JADX INFO: renamed from: com.byazt.sd.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 506, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static abstract class AbstractC0332n<T> {
        public volatile T n;

        public abstract T qg(Object... objArr);

        public final T s(Object... objArr) {
            if (this.n == null) {
                synchronized (this) {
                    if (this.n == null) {
                        this.n = qg(objArr);
                    }
                }
            }
            return this.n;
        }
    }
}

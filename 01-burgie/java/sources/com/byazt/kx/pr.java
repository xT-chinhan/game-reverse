package com.byazt.kx;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.ec.g;
import com.byazt.ec.vk;
import com.mar.sdk.MARCode;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 949, 37})
public class pr {
    public static final CharSequence pr = "sony";
    public static final CharSequence hw = "amigo";
    public static final CharSequence hn = "funtouch";
    public static final AbstractC0117pr<Boolean> x = new AbstractC0117pr<Boolean>() { // from class: com.byazt.kx.pr.1
        @Override // com.byazt.kx.pr.AbstractC0117pr
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public Boolean hw(Object... objArr) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                return Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            } catch (Throwable th) {
                return Boolean.FALSE;
            }
        }
    };

    public static String pr() {
        return pr("ro.build.version.emui");
    }

    public static String hw() {
        if (g()) {
            return ho();
        }
        if (uc()) {
            return yb();
        }
        if (lb()) {
            return a();
        }
        String strNt = nt();
        if (!TextUtils.isEmpty(strNt)) {
            return strNt;
        }
        if (fw()) {
            return c();
        }
        if (zo()) {
            return aj();
        }
        if (x()) {
            return hn();
        }
        String strVk = vk();
        if (!TextUtils.isEmpty(strVk)) {
            return strVk;
        }
        return Build.DISPLAY;
    }

    public static String hn() {
        return pr("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean x() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String c() {
        return pr("ro.vivo.os.build.display.id") + "_" + pr("ro.vivo.product.version");
    }

    public static boolean uc() {
        return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    public static boolean fw() {
        String strPr = pr("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strPr) && strPr.toLowerCase().contains(hn);
    }

    public static boolean zo() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(hw);
    }

    public static String aj() {
        return Build.DISPLAY + "_" + pr("ro.gn.sv.version");
    }

    public static String vk() {
        if (w()) {
            return "eui_" + pr("ro.letv.release.version") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static boolean w() {
        return !TextUtils.isEmpty(pr("ro.letv.release.version"));
    }

    public static boolean k() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("honor")) {
            return (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor")) || "HONOR".equalsIgnoreCase(Build.MANUFACTURER);
        }
        return true;
    }

    public static boolean m() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return !TextUtils.isEmpty((String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui"));
        } catch (Exception e) {
            ho.hw("Honor", e.getMessage());
        }
    }

    public static boolean g() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static String ho() {
        if (g()) {
            return "miui_" + pr("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
        }
        return "";
    }

    public static String nt() {
        String strPr = pr();
        if (strPr == null) {
            return "";
        }
        if (strPr.toLowerCase().contains("emotionui") || strPr.toLowerCase().contains("magicui")) {
            return strPr + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static String yb() {
        String str = Build.DISPLAY;
        if (str != null && str.toLowerCase().contains("flyme")) {
            return str;
        }
        return "";
    }

    public static boolean lb() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    public static boolean qa() {
        return Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("REDMI");
    }

    public static String a() {
        if (lb()) {
            return "coloros_" + pr("ro.build.version.opporom") + "_" + Build.DISPLAY;
        }
        return "";
    }

    private static String pr(String str) {
        String strPr = vk.pr(str);
        if (!TextUtils.isEmpty(strPr)) {
            return strPr;
        }
        return g.pr(str);
    }

    public static boolean cz() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean ny() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean fo() {
        if ("samsung".equalsIgnoreCase(Build.BRAND) || "samsung".equalsIgnoreCase(Build.MANUFACTURER)) {
            return true;
        }
        return false;
    }

    private static String iu() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static boolean rc() {
        if ("lenovo".equalsIgnoreCase(Build.BRAND) || "motorola".equalsIgnoreCase(Build.MANUFACTURER)) {
            return true;
        }
        String str = Build.FINGERPRINT;
        if (!TextUtils.isEmpty(str)) {
            return str.contains("VIBEUI_V2");
        }
        String strPr = pr("ro.build.version.incremental");
        return !TextUtils.isEmpty(strPr) && strPr.contains("VIBEUI_V2");
    }

    public static boolean z() {
        return iu().toUpperCase().contains("NUBIA");
    }

    public static boolean b() {
        return iu().toUpperCase().contains("ASUS");
    }

    public static boolean pr(Context context) {
        return iu().toUpperCase().contains("HUAWEI");
    }

    /* JADX INFO: renamed from: com.byazt.kx.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 949, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static abstract class AbstractC0117pr<T> {
        public volatile T pr;

        public abstract T hw(Object... objArr);

        public final T hn(Object... objArr) {
            if (this.pr == null) {
                synchronized (this) {
                    if (this.pr == null) {
                        this.pr = hw(objArr);
                    }
                }
            }
            return this.pr;
        }
    }
}

package com.bytedance.sdk.openadsdk.core.jw;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class w {
    private static String ab = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static int f2746ms = 0;
    private static String ny = null;
    private static int x = Integer.MAX_VALUE;
    public static int xr;
    private static final CharSequence ah = "sony";
    private static final CharSequence d = "amigo";
    private static final CharSequence ka = "funtouch";
    private static final CharSequence c = LiveConfigKey.ORIGIN;

    public static String ms() {
        if (TextUtils.isEmpty(ab)) {
            ab = yu();
        }
        return ab;
    }

    public static String xr() {
        return xr("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static String ah() {
        return ao() ? "miui_" + xr("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    public static String d() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static String ka() {
        return b() ? "coloros_" + xr("ro.build.version.kllkrom") + "_" + Build.DISPLAY : "";
    }

    public static String c() {
        String strNw = nw();
        if (strNw != null) {
            return (strNw.toLowerCase().contains("emotionui") || strNw.toLowerCase().contains("magicui")) ? strNw + "_" + Build.DISPLAY : "";
        }
        return "";
    }

    public static boolean ab() {
        String strXr = xr("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(strXr)) {
            return false;
        }
        return strXr.toLowerCase().contains(ka) || strXr.toLowerCase().contains(LiveConfigKey.ORIGIN);
    }

    public static String x() {
        return "vivo_" + xr("ro.vivo.os.build.display.id") + "_" + xr("ro.vivo.product.version");
    }

    public static boolean ny() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(d);
    }

    public static boolean ch() {
        try {
            return "FreemeOS".equalsIgnoreCase(xr("ro.build.freemeos_label"));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String hi() {
        return Build.DISPLAY + "_" + xr("ro.gn.sv.version");
    }

    public static boolean sl() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String zb() {
        return u() ? "eui_" + xr("ro.letv.release.version") + "_" + Build.DISPLAY : "";
    }

    public static boolean u() {
        return !TextUtils.isEmpty(xr("ro.letv.release.version"));
    }

    public static String ub() {
        if (TextUtils.isEmpty(ny)) {
            ny = w();
        }
        return ny;
    }

    private static String w() {
        if (ao()) {
            return ah();
        }
        if (t()) {
            return d();
        }
        if (b()) {
            return ka();
        }
        String strC = c();
        if (!TextUtils.isEmpty(strC)) {
            return strC;
        }
        if (ab()) {
            return x();
        }
        if (ny()) {
            return hi();
        }
        if (sl()) {
            return xr();
        }
        String strZb = zb();
        if (!TextUtils.isEmpty(strZb)) {
            return strZb;
        }
        if (Build.MANUFACTURER.toLowerCase(Locale.ROOT).contains("oneplus")) {
            return "oneplus_" + Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
        }
        if (i()) {
            return "honor_" + nw();
        }
        if (ch()) {
            return "freeme_" + nw();
        }
        return Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
    }

    public static boolean ao() {
        if (f2746ms == 0) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    f2746ms = 1;
                } else {
                    f2746ms = 2;
                }
            } catch (Exception unused) {
            }
        }
        return f2746ms == 1;
    }

    public static boolean h() {
        if (xr == 0) {
            try {
                if (Class.forName("com.huawei.system.BuildEx") != null) {
                    xr = 1;
                } else {
                    xr = 2;
                }
            } catch (Exception unused) {
            }
        }
        return xr == 1;
    }

    private static String yu() {
        String str = Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
        String str2 = Build.MANUFACTURER;
        if (ao()) {
            return "miui_".concat(String.valueOf(str));
        }
        if (h()) {
            return "huawei_".concat(String.valueOf(str));
        }
        if (str2.toLowerCase(Locale.ROOT).contains("oppo")) {
            return "oppo_".concat(String.valueOf(str));
        }
        if (str2.toLowerCase(Locale.ROOT).contains("vivo")) {
            return "vivo_".concat(String.valueOf(str));
        }
        return str2.toLowerCase(Locale.ROOT).contains("oneplus") ? "oneplus_".concat(String.valueOf(str)) : str;
    }

    public static boolean qv() {
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.d("romUtil", e.getMessage());
        }
        return false;
    }

    public static boolean y() {
        try {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.toLowerCase().contains("vivo");
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.d("romUtils", e.getMessage());
            return false;
        }
    }

    public static boolean t() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String nw() {
        return ah("ro.build.version.emui");
    }

    public static boolean b() {
        if (x == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String strHi = f.hi("kllk");
            if (!TextUtils.isEmpty(str) && str.toLowerCase(Locale.ROOT).contains(strHi)) {
                x = 1;
            } else {
                x = 0;
            }
        }
        return x == 1;
    }

    public static boolean re() {
        try {
            return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith("huawei")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("huawei"));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean i() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("honor")) {
            return (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor")) || "HONOR".equalsIgnoreCase(Build.MANUFACTURER);
        }
        return true;
    }

    public static boolean ms(String str) {
        if (TextUtils.isEmpty(str)) {
            str = nw();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || re();
    }

    public static String xr(String str) {
        com.bytedance.sdk.component.d.ah ahVar = (com.bytedance.sdk.component.d.ah) AutoService.ms(com.bytedance.sdk.component.d.ah.class);
        return ahVar != null ? ahVar.ms(str) : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String ah(String str) {
        String strOp;
        try {
            strOp = op();
            try {
                if (TextUtils.isEmpty(strOp)) {
                    final com.bytedance.sdk.component.ch.x xVar = new com.bytedance.sdk.component.ch.x(new ms(str), 5, 2);
                    com.bytedance.sdk.component.ch.ab.ah(new com.bytedance.sdk.component.ch.ny("getSystemPropertyTask") { // from class: com.bytedance.sdk.openadsdk.core.jw.w.1
                        @Override // java.lang.Runnable
                        public void run() {
                            xVar.run();
                        }
                    });
                    strOp = (String) xVar.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            strOp = "";
        }
        return strOp == null ? "" : strOp;
    }

    private static String op() {
        try {
            return g.ms("rom_info").xr("rom_property_info", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static class ms implements Callable<String> {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f2748ms;

        public ms(String str) {
            this.f2748ms = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            System.currentTimeMillis();
            String strXr = w.xr(this.f2748ms);
            System.currentTimeMillis();
            if (!TextUtils.isEmpty(strXr)) {
                try {
                    g.ms("rom_info").ms("rom_property_info", strXr);
                } catch (Throwable unused) {
                }
            }
            return strXr;
        }
    }
}

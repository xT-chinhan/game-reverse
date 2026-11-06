package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class ny {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final CharSequence f509ms = "sony";
    private static final CharSequence xr = "amigo";
    private static final CharSequence ah = "funtouch";
    private static final ms<Boolean> d = new ms<Boolean>() { // from class: com.bytedance.embedapplog.ny.1
    };

    public static String ms() {
        return xr("ro.build.version.emui");
    }

    public static boolean ms(String str) {
        if (TextUtils.isEmpty(str)) {
            str = ms();
        }
        return (!TextUtils.isEmpty(str) && (str.toLowerCase().contains("emotionui") || str.toLowerCase().contains("magicui"))) || xr() || ah();
    }

    public static boolean xr() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("huawei")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("huawei");
        }
        return true;
    }

    public static boolean ah() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("honor")) {
            return (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor")) || "HONOR".equalsIgnoreCase(Build.MANUFACTURER);
        }
        return true;
    }

    public static boolean d() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return !TextUtils.isEmpty((String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui"));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.d("Honor", e.getMessage());
        }
    }

    public static boolean ka() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    public static boolean ab() {
        return Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("REDMI");
    }

    private static String xr(String str) {
        String strMs = ih.ms(str);
        return !TextUtils.isEmpty(strMs) ? strMs : zd.ms(str);
    }

    public static boolean x() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean ny() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean ch() {
        return "samsung".equalsIgnoreCase(Build.BRAND) || "samsung".equalsIgnoreCase(Build.MANUFACTURER);
    }

    private static String u() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER.trim();
    }

    public static boolean hi() {
        String str = Build.FINGERPRINT;
        if (!TextUtils.isEmpty(str)) {
            return str.contains("VIBEUI_V2");
        }
        String strXr = xr("ro.build.version.incremental");
        return !TextUtils.isEmpty(strXr) && strXr.contains("VIBEUI_V2");
    }

    public static boolean sl() {
        return u().toUpperCase().contains("NUBIA");
    }

    public static boolean zb() {
        return u().toUpperCase().contains("ASUS");
    }

    public static boolean ms(Context context) {
        return u().toUpperCase().contains("HUAWEI");
    }

    static abstract class ms<T> {
        ms() {
        }
    }
}

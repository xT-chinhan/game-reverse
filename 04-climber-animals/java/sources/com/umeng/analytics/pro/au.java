package com.umeng.analytics.pro;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: compiled from: RomUtils.java */
/* JADX INFO: loaded from: classes4.dex */
public class au {
    private static String a = "";
    private static String b = "";
    private static final String c = "hw_sc.build.platform.version";
    private static final String d = "ro.build.version.emui";
    private static final String e = "ro.build.version.magic";
    private static final String f = "ro.miui.ui.version.name";
    private static final String g = "ro.build.version.opporom";
    private static final String h = "ro.vivo.os.name";
    private static final String i = "ro.vivo.os.version";
    private static final String j = "ro.build.version.oplusrom";
    private static final String k = "ro.rom.version";

    private static String d(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(a)) {
            e(str);
        }
        return a;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(a)) {
            e(str);
        }
        return b;
    }

    public static String c(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll(" ", "").toUpperCase();
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005e  */
    private static void e(String str) {
        try {
            switch (c(str)) {
                case "HUAWEI":
                    if (a()) {
                        b = d(c);
                        a = "HarmonyOS";
                        break;
                    } else {
                        a = "EMUI";
                        b = d(d);
                        break;
                    }
                    break;
                case "HONOR":
                    if (!TextUtils.isEmpty(d(e))) {
                        a = "MagicUI";
                        b = d(e);
                        break;
                    } else {
                        a = "EMUI";
                        b = d(d);
                        break;
                    }
                    break;
                case "XIAOMI":
                case "REDMI":
                    a = "MIUI";
                    b = d(f);
                    break;
                case "REALME":
                case "OPPO":
                    a = "ColorOS";
                    b = d(g);
                    break;
                case "VIVO":
                    a = "Funtouch";
                    b = d(i);
                    break;
                case "ONEPLUS":
                    a = "HydrogenOS";
                    String strD = d(k);
                    if (TextUtils.isEmpty(strD)) {
                        a = "ColorOS";
                        strD = d(j);
                    }
                    b = strD;
                    break;
                default:
                    a = "Android";
                    b = Build.VERSION.RELEASE;
                    break;
            }
        } catch (Throwable unused) {
        }
    }
}

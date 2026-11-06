package com.tapsdk.tapad.oaid;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.fi.BaseConstants;

/* JADX INFO: loaded from: classes3.dex */
public final class OAIDRom {
    private OAIDRom() {
    }

    public static boolean is360OS() {
        return !TextUtils.isEmpty(sysProperty("ro.build.uiversion", ""));
    }

    public static boolean isASUS() {
        return Build.MANUFACTURER.equalsIgnoreCase("ASUS") || Build.BRAND.equalsIgnoreCase("ASUS");
    }

    public static boolean isBlackShark() {
        return Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") || Build.BRAND.equalsIgnoreCase("BLACKSHARK");
    }

    public static boolean isCoolpad(Context context) {
        if (Build.MANUFACTURER.toUpperCase().contains("COOL") || Build.BRAND.toUpperCase().contains("COOL") || Build.MODEL.toUpperCase().contains("COOL")) {
            return true;
        }
        try {
            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean isCoosea() {
        return sysProperty("ro.odm.manufacturer", "").equalsIgnoreCase("PRIZE");
    }

    public static boolean isEmui() {
        return !TextUtils.isEmpty(sysProperty("ro.build.version.emui", ""));
    }

    public static boolean isFreeme() {
        return !TextUtils.isEmpty(sysProperty("ro.build.freeme.label", ""));
    }

    public static boolean isHarmonyOS() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Object objInvoke = cls.getMethod("getOsBrand", null).invoke(cls, null);
            return objInvoke != null && objInvoke.toString().length() > 0;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean isHonor() {
        return Build.MANUFACTURER.equalsIgnoreCase("HONOR") || Build.BRAND.equalsIgnoreCase("HONOR");
    }

    public static boolean isHuawei() {
        return Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") || Build.BRAND.equalsIgnoreCase("HUAWEI");
    }

    public static boolean isLenovo() {
        if (Build.MANUFACTURER.equalsIgnoreCase("LENOVO")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("LENOVO") || str.equalsIgnoreCase("ZUK");
    }

    public static boolean isMagicUI() {
        return !TextUtils.isEmpty(sysProperty("ro.build.version.magic", ""));
    }

    public static boolean isMeizu() {
        return Build.MANUFACTURER.equalsIgnoreCase("MEIZU") || Build.BRAND.equalsIgnoreCase("MEIZU") || Build.DISPLAY.toUpperCase().contains("FLYME");
    }

    public static boolean isMiui() {
        return !TextUtils.isEmpty(sysProperty("ro.miui.ui.version.name", ""));
    }

    public static boolean isMiuiGlobal() {
        if (!TextUtils.isEmpty(sysProperty("ro.com.google.gmsversion", ""))) {
            return true;
        }
        if (sysProperty("ro.miui.region", "").equalsIgnoreCase("CN")) {
            return false;
        }
        return sysProperty("ro.product.mod_device", "").endsWith("_global");
    }

    @Deprecated
    public static boolean isMotolora() {
        return isMotorola();
    }

    public static boolean isMotorola() {
        if (Build.MANUFACTURER.toUpperCase().contains("MOTO")) {
            return true;
        }
        String str = Build.BRAND;
        return str.toUpperCase().contains("MOTO") || str.equalsIgnoreCase("MOTOROLA");
    }

    public static boolean isNubia() {
        return Build.MANUFACTURER.equalsIgnoreCase("NUBIA") || Build.BRAND.equalsIgnoreCase("NUBIA");
    }

    public static boolean isOnePlus() {
        return Build.MANUFACTURER.equalsIgnoreCase("ONEPLUS") || Build.BRAND.equalsIgnoreCase("ONEPLUS");
    }

    public static boolean isOppo() {
        if (Build.MANUFACTURER.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT) || str.equalsIgnoreCase("REALME") || !TextUtils.isEmpty(sysProperty("ro.build.version.opporom", ""));
    }

    public static boolean isSSUI() {
        return !TextUtils.isEmpty(sysProperty("ro.ssui.product", ""));
    }

    public static boolean isSamsung() {
        return Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG");
    }

    public static boolean isVivo() {
        return Build.MANUFACTURER.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO") || !TextUtils.isEmpty(sysProperty("ro.vivo.os.version", ""));
    }

    public static boolean isXiaomi() {
        if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("XIAOMI") || str.equalsIgnoreCase("REDMI");
    }

    public static boolean isZTE() {
        return Build.MANUFACTURER.equalsIgnoreCase("ZTE") || Build.BRAND.equalsIgnoreCase("ZTE");
    }

    public static String sysProperty(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Throwable th) {
            OAIDLog.print("System property invoke error: " + th);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }
}

package com.taptap.sdk.kit.internal.utils;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class OSUtil {
    private static final String KEY_COLOROS_VERSION_NAME = "ro.build.version.opporom";
    private static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
    private static final String KEY_FLYME_VERSION_NAME = "ro.build.display.id";
    private static final String KEY_HARMONYOS_VERSION_NAME = "hw_sc.build.platform.version";
    private static final String KEY_MAGICUI_VERSION = "ro.build.version.magic";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_NUBIA_VERSION_CODE = "ro.build.nubia.rom.code";
    private static final String KEY_NUBIA_VERSION_NAME = "ro.build.nubia.rom.name";
    private static final String KEY_ONEPLUS_VERSION_NAME = "ro.rom.version";
    private static final String KEY_VIVO_VERSION = "ro.vivo.os.version";
    private static final String KEY_VIVO_VERSION_NAME = "ro.vivo.os.name";
    private static String customOS = "";
    private static String customOSVersion = "";

    private static String getSystemPropertyValue(String key) {
        try {
            Class<?> classType = Class.forName("android.os.SystemProperties");
            Method getMethod = classType.getDeclaredMethod("get", String.class);
            String value = (String) getMethod.invoke(classType, key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean isHarmonyOS() {
        try {
            Class<?> classType = Class.forName("com.huawei.system.BuildEx");
            Method getMethod = classType.getMethod("getOsBrand", new Class[0]);
            String value = (String) getMethod.invoke(classType, new Object[0]);
            return !TextUtils.isEmpty(value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getCustomOS(String phoneBrand) {
        if (TextUtils.isEmpty(customOS)) {
            setCustomOSInfo(phoneBrand);
        }
        return customOS.toLowerCase(Locale.US);
    }

    public static String getCustomOSVersion(String phoneBrand) {
        if (TextUtils.isEmpty(customOS)) {
            setCustomOSInfo(phoneBrand);
        }
        return customOSVersion.toLowerCase(Locale.US);
    }

    public static String deleteSpaceAndToUpperCase(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll(" ", "").toUpperCase(Locale.US);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:5:0x000e  */
    private static void setCustomOSInfo(String phoneBrand) {
        try {
            switch (deleteSpaceAndToUpperCase(phoneBrand)) {
                case "HUAWEI":
                    if (isHarmonyOS()) {
                        customOSVersion = getSystemPropertyValue(KEY_HARMONYOS_VERSION_NAME);
                        customOS = "HarmonyOS";
                        break;
                    } else {
                        customOS = "EMUI";
                        customOSVersion = getSystemPropertyValue(KEY_EMUI_VERSION_NAME);
                        break;
                    }
                    break;
                case "HONOR":
                    if (isHarmonyOS()) {
                        customOS = "HarmonyOS";
                        if (!TextUtils.isEmpty(getSystemPropertyValue(KEY_HARMONYOS_VERSION_NAME))) {
                            customOSVersion = getSystemPropertyValue(KEY_HARMONYOS_VERSION_NAME);
                        } else {
                            customOSVersion = "";
                        }
                        break;
                    } else {
                        if (!TextUtils.isEmpty(getSystemPropertyValue(KEY_MAGICUI_VERSION))) {
                            customOS = "MagicUI";
                            customOSVersion = getSystemPropertyValue(KEY_MAGICUI_VERSION);
                        } else {
                            customOS = "EMUI";
                            customOSVersion = getSystemPropertyValue(KEY_EMUI_VERSION_NAME);
                        }
                        break;
                    }
                    break;
                case "XIAOMI":
                case "REDMI":
                    customOS = "MIUI";
                    customOSVersion = getSystemPropertyValue(KEY_MIUI_VERSION_NAME);
                    break;
                case "REALME":
                case "OPPO":
                    customOS = "ColorOS";
                    customOSVersion = getSystemPropertyValue(KEY_COLOROS_VERSION_NAME);
                    break;
                case "VIVO":
                    customOS = "Funtouch";
                    customOSVersion = getSystemPropertyValue(KEY_VIVO_VERSION);
                    break;
                case "ONEPLUS":
                    customOS = "HydrogenOS";
                    customOSVersion = getSystemPropertyValue(KEY_ONEPLUS_VERSION_NAME);
                    break;
                case "MEIZU":
                    customOS = "Flyme";
                    customOSVersion = getSystemPropertyValue(KEY_FLYME_VERSION_NAME);
                    break;
                case "NUBIA":
                    customOS = getSystemPropertyValue(KEY_NUBIA_VERSION_NAME);
                    customOSVersion = getSystemPropertyValue(KEY_NUBIA_VERSION_CODE);
                    break;
                default:
                    customOS = "Android";
                    customOSVersion = Build.VERSION.RELEASE;
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

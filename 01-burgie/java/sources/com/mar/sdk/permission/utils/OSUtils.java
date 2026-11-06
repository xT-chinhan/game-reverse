package com.mar.sdk.permission.utils;

import android.os.Build;
import com.mar.sdk.log.Log;
import java.io.IOException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class OSUtils {
    private static final String KEY_EMUI_VERSION_CODE = "ro.build.version.emui";
    private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";
    private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";

    private static boolean isPropertiesExist(String... keys) {
        try {
            BuildProperties prop = BuildProperties.newInstance();
            for (String key : keys) {
                String str = prop.getProperty(key);
                if (str == null) {
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void printOSInfo() {
        Log.d("MARSDK", "OS INFO BEGIN");
        Log.d("MARSDK", "Build.DISPLAY=" + Build.DISPLAY);
        Log.d("MARSDK", "Build.MANUFACTURER=" + Build.MANUFACTURER);
        try {
            BuildProperties prop = BuildProperties.newInstance();
            for (Object key : prop.keySet()) {
                String str = prop.getProperty(key.toString());
                if (str != null) {
                    Log.d("MARSDK", key + "=" + str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("MARSDK", "OS INFO END");
    }

    public static boolean isOSNeedPermission() {
        return isMIUI();
    }

    public static boolean isEMUI() {
        return isPropertiesExist(KEY_EMUI_VERSION_CODE);
    }

    public static boolean isMIUI() {
        return isPropertiesExist(KEY_MIUI_VERSION_CODE, KEY_MIUI_VERSION_NAME, KEY_MIUI_INTERNAL_STORAGE);
    }

    public static boolean isFlyme() {
        try {
            Method method = Build.class.getMethod("hasSmartBar", new Class[0]);
            return method != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isOppoOS() {
        return Build.MANUFACTURER.equalsIgnoreCase("oppo");
    }

    public static boolean isVivoOS() {
        return Build.MANUFACTURER.equalsIgnoreCase("vivo");
    }
}

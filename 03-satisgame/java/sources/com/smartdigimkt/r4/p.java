package com.smartdigimkt.r4;

import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p {
    public static final String[] a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    public static String a() {
        try {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                str = Build.CPU_ABI2;
            }
            return str != null ? str : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(Context context) {
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? "2" : "1";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) clsLoadClass.getMethod("get", String.class).invoke(clsLoadClass, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(Context context) {
        try {
            return String.valueOf(((BatteryManager) context.getSystemService("batterymanager")).getIntProperty(4));
        } catch (Throwable unused) {
            return "";
        }
    }
}

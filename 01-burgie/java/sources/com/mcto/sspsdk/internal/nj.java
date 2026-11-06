package com.mcto.sspsdk.internal;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class nj {
    public static int a = -1;

    public static int a() {
        try {
            int i = a;
            if (i != -1) {
                return i;
            }
            if (!TextUtils.isEmpty(a("ro.build.version.emui"))) {
                a = 1;
                if ("honor".equalsIgnoreCase(Build.MANUFACTURER) && e1.c("com.hihonor.appmarket")) {
                    a = 5;
                }
            } else if ("oppo".equalsIgnoreCase(Build.MANUFACTURER)) {
                a = 3;
            } else if (!TextUtils.isEmpty(a("ro.vivo.os.version"))) {
                a = 2;
            } else if (TextUtils.isEmpty(a("ro.miui.ui.version.name"))) {
                a = 0;
            } else {
                a = 4;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return a;
    }

    public static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Throwable th) {
            th.toString();
            return "";
        }
    }
}

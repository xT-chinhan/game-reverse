package com.bytedance.ms.xr.x;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static boolean f590ms = false;

    public static boolean ms(String str) {
        if (TextUtils.isEmpty(str)) {
            str = ms();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return xr();
        }
        return true;
    }

    public static String ms() {
        return xr("ro.build.version.emui");
    }

    private static String xr(String str) {
        BufferedReader bufferedReader;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                bufferedReader.close();
                c.ms(bufferedReader);
                return line;
            } catch (Throwable unused) {
                c.ms(bufferedReader);
                return line;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static boolean xr() {
        try {
            return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase(Locale.getDefault()).startsWith("huawei")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase(Locale.getDefault()).startsWith("huawei"));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean ah() {
        if (!f590ms) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    com.bytedance.ms.xr.ab.xr.f554ms = true;
                    f590ms = true;
                    return com.bytedance.ms.xr.ab.xr.f554ms;
                }
            } catch (Exception unused) {
            }
            f590ms = true;
        }
        return com.bytedance.ms.xr.ab.xr.f554ms;
    }

    public static boolean d() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }
}

package com.byazt.wf;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 201, 20})
public class hn {
    public static boolean pr = false;

    public static boolean pr(String str) {
        if (TextUtils.isEmpty(str)) {
            str = pr();
        }
        if (!TextUtils.isEmpty(str) && str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return true;
        }
        return hw();
    }

    public static String pr() {
        return hw("ro.build.version.emui");
    }

    private static String hw(String str) {
        BufferedReader bufferedReader;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                bufferedReader.close();
                uc.pr(bufferedReader);
                return line;
            } catch (Throwable th) {
                uc.pr(bufferedReader);
                return line;
            }
        } catch (Throwable th2) {
            bufferedReader = null;
        }
    }

    public static boolean hw() {
        try {
            return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase(Locale.getDefault()).startsWith("huawei")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase(Locale.getDefault()).startsWith("huawei"));
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean hn() {
        if (!pr) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    com.byazt.tv.hw.pr = true;
                    pr = true;
                    return com.byazt.tv.hw.pr;
                }
            } catch (Exception e) {
            }
            pr = true;
        }
        return com.byazt.tv.hw.pr;
    }

    public static boolean x() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }
}

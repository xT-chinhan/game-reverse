package com.byazt.yw;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 8})
public class s {
    public static boolean n = false;

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            str = n();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return qg();
        }
        return true;
    }

    public static String n() {
        return qg("ro.build.version.emui");
    }

    private static String qg(String str) {
        BufferedReader bufferedReader;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                bufferedReader.close();
                w.n(bufferedReader);
                return line;
            } catch (Throwable unused) {
                w.n(bufferedReader);
                return line;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static boolean qg() {
        try {
            return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase(Locale.getDefault()).startsWith("huawei")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase(Locale.getDefault()).startsWith("huawei"));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean s() {
        if (!n) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    com.byazt.xh.qg.n = true;
                    n = true;
                    return com.byazt.xh.qg.n;
                }
            } catch (Exception unused) {
            }
            n = true;
        }
        return com.byazt.xh.qg.n;
    }

    public static boolean q() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }
}

package com.byazt.yw;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa {
    public static final CharSequence n = "sony";
    public static final CharSequence qg = "amigo";
    public static final CharSequence s = "funtouch";

    public static String n() {
        if (s.s()) {
            return tj();
        }
        if (s.q()) {
            return d();
        }
        if (oa()) {
            return sz();
        }
        String strCp = cp();
        if (!TextUtils.isEmpty(strCp)) {
            return strCp;
        }
        if (l()) {
            return q();
        }
        if (w()) {
            return x();
        }
        if (s()) {
            return qg();
        }
        String strFs = fs();
        return !TextUtils.isEmpty(strFs) ? strFs : Build.DISPLAY;
    }

    public static String qg() {
        return n("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean s() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String q() {
        return n("ro.vivo.os.build.display.id") + "_" + n("ro.vivo.product.version");
    }

    public static boolean l() {
        String strN = n("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strN) && strN.toLowerCase(Locale.getDefault()).contains(s);
    }

    public static boolean w() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(qg);
    }

    public static String x() {
        return Build.DISPLAY + "_" + n("ro.gn.sv.version");
    }

    public static String fs() {
        return rv() ? "eui_" + n("ro.letv.release.version") + "_" + Build.DISPLAY : "";
    }

    public static boolean rv() {
        return !TextUtils.isEmpty(n("ro.letv.release.version"));
    }

    public static String tj() {
        return s.s() ? "miui_" + n("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    public static String cp() {
        String strN = s.n();
        return (strN == null || !strN.toLowerCase(Locale.getDefault()).contains("emotionui")) ? "" : strN + "_" + Build.DISPLAY;
    }

    public static String d() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
    }

    public static boolean oa() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static String sz() {
        return oa() ? "coloros_" + n("ro.build.version.opporom") + "_" + Build.DISPLAY : "";
    }

    private static String n(String str) {
        BufferedReader bufferedReader;
        String line = "";
        try {
            Process processExec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                processExec.destroy();
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
}

package com.byazt.wf;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 201, 108})
public class m {
    public static final CharSequence pr = "sony";
    public static final CharSequence hw = "amigo";
    public static final CharSequence hn = "funtouch";

    public static String pr() {
        if (hn.hn()) {
            return vk();
        }
        if (hn.x()) {
            return k();
        }
        if (m()) {
            return g();
        }
        String strW = w();
        if (!TextUtils.isEmpty(strW)) {
            return strW;
        }
        if (c()) {
            return x();
        }
        if (uc()) {
            return fw();
        }
        if (hn()) {
            return hw();
        }
        String strZo = zo();
        if (!TextUtils.isEmpty(strZo)) {
            return strZo;
        }
        return Build.DISPLAY;
    }

    public static String hw() {
        return pr("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean hn() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String x() {
        return pr("ro.vivo.os.build.display.id") + "_" + pr("ro.vivo.product.version");
    }

    public static boolean c() {
        String strPr = pr("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strPr) && strPr.toLowerCase(Locale.getDefault()).contains(hn);
    }

    public static boolean uc() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(hw);
    }

    public static String fw() {
        return Build.DISPLAY + "_" + pr("ro.gn.sv.version");
    }

    public static String zo() {
        if (aj()) {
            return "eui_" + pr("ro.letv.release.version") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static boolean aj() {
        return !TextUtils.isEmpty(pr("ro.letv.release.version"));
    }

    public static String vk() {
        if (hn.hn()) {
            return "miui_" + pr("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
        }
        return "";
    }

    public static String w() {
        String strPr = hn.pr();
        if (strPr != null && strPr.toLowerCase(Locale.getDefault()).contains("emotionui")) {
            return strPr + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static String k() {
        String str = Build.DISPLAY;
        if (str != null && str.toLowerCase(Locale.getDefault()).contains("flyme")) {
            return str;
        }
        return "";
    }

    public static boolean m() {
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str)) {
            return str.toLowerCase(Locale.getDefault()).contains("oppo");
        }
        return false;
    }

    public static String g() {
        if (m()) {
            return "coloros_" + pr("ro.build.version.opporom") + "_" + Build.DISPLAY;
        }
        return "";
    }

    private static String pr(String str) {
        BufferedReader bufferedReader;
        String line = "";
        try {
            Process processExec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                processExec.destroy();
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
}

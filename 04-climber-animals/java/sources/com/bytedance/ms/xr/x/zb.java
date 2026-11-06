package com.bytedance.ms.xr.x;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class zb {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final CharSequence f597ms = "sony";
    private static final CharSequence xr = "amigo";
    private static final CharSequence ah = "funtouch";

    public static String ms() {
        if (ah.ah()) {
            return ch();
        }
        if (ah.d()) {
            return sl();
        }
        if (zb()) {
            return u();
        }
        String strHi = hi();
        if (!TextUtils.isEmpty(strHi)) {
            return strHi;
        }
        if (ka()) {
            return d();
        }
        if (c()) {
            return ab();
        }
        if (ah()) {
            return xr();
        }
        String strX = x();
        return !TextUtils.isEmpty(strX) ? strX : Build.DISPLAY;
    }

    public static String xr() {
        return ms("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean ah() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String d() {
        return ms("ro.vivo.os.build.display.id") + "_" + ms("ro.vivo.product.version");
    }

    public static boolean ka() {
        String strMs = ms("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strMs) && strMs.toLowerCase(Locale.getDefault()).contains(ah);
    }

    public static boolean c() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(xr);
    }

    public static String ab() {
        return Build.DISPLAY + "_" + ms("ro.gn.sv.version");
    }

    public static String x() {
        return ny() ? "eui_" + ms("ro.letv.release.version") + "_" + Build.DISPLAY : "";
    }

    public static boolean ny() {
        return !TextUtils.isEmpty(ms("ro.letv.release.version"));
    }

    public static String ch() {
        return ah.ah() ? "miui_" + ms("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    public static String hi() {
        String strMs = ah.ms();
        return (strMs == null || !strMs.toLowerCase(Locale.getDefault()).contains("emotionui")) ? "" : strMs + "_" + Build.DISPLAY;
    }

    public static String sl() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
    }

    public static boolean zb() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static String u() {
        return zb() ? "coloros_" + ms("ro.build.version.opporom") + "_" + Build.DISPLAY : "";
    }

    private static String ms(String str) {
        BufferedReader bufferedReader;
        String line = "";
        try {
            Process processExec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                processExec.destroy();
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
}

package com.byazt.vy;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.vf.u;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, 33})
public class um {
    public static final CharSequence s = "sony";
    public static final CharSequence q = "amigo";
    public static final CharSequence l = "funtouch";
    public static final ExecutorService w = com.byazt.rb.l.n("romutils", 2, new RejectedExecutionHandler() { // from class: com.byazt.vy.um.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    });
    public static boolean n = false;
    public static boolean qg = false;

    public static String n() {
        if (k()) {
            return cy();
        }
        if (l()) {
            return d();
        }
        if (qg()) {
            return hd();
        }
        if (cd()) {
            return um();
        }
        String strOa = oa();
        if (!TextUtils.isEmpty(strOa)) {
            return strOa;
        }
        if (x()) {
            return w();
        }
        if (fs()) {
            return rv();
        }
        if (q()) {
            return s();
        }
        String strTj = tj();
        return !TextUtils.isEmpty(strTj) ? strTj : Build.DISPLAY;
    }

    public static boolean qg() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String s() {
        return s("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean q() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean l() {
        if (!qg) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    n = true;
                    qg = true;
                    return true;
                }
            } catch (Exception unused) {
            }
            qg = true;
        }
        return n;
    }

    public static String w() {
        return s("ro.vivo.os.build.display.id") + "_" + s("ro.vivo.product.version");
    }

    public static boolean x() {
        String strS = s("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strS) && strS.toLowerCase().contains(l);
    }

    public static boolean fs() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(q);
    }

    public static String rv() {
        return Build.DISPLAY + "_" + s("ro.gn.sv.version");
    }

    public static String tj() {
        return cp() ? "eui_" + s("ro.letv.release.version") + "_" + Build.DISPLAY : "";
    }

    public static boolean cp() {
        return !TextUtils.isEmpty(s("ro.letv.release.version"));
    }

    public static String d() {
        return l() ? "miui_" + s("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    public static String oa() {
        String strSz = sz();
        return (strSz == null || !strSz.toLowerCase().contains("emotionui")) ? "" : strSz + "_" + Build.DISPLAY;
    }

    public static String sz() {
        return s("ro.build.version.emui");
    }

    public static boolean k() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static String cy() {
        if (k()) {
            try {
                return "smartisan_".concat(String.valueOf(s("ro.smartisan.version")));
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static String hd() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean cd() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo");
    }

    public static String um() {
        return cd() ? "coloros_" + s("ro.build.version.opporom") + "_" + Build.DISPLAY : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String qg(String str) {
        u uVar = (u) com.byazt.qp.q.n("system_info");
        return uVar != null ? uVar.n(str) : "";
    }

    private static String s(String str) {
        String strOu;
        try {
            strOu = ou();
            try {
                if (TextUtils.isEmpty(strOu)) {
                    FutureTask futureTask = new FutureTask(new n(str));
                    w.execute(futureTask);
                    strOu = (String) futureTask.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            strOu = "";
        }
        return strOu == null ? "" : strOu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.gwu.s py() {
        try {
            if (com.byazt.qt.n.d() != null) {
                return com.byazt.lk.l.n(null, "gm_rom_info");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1431, 1217})
    public static class n implements Callable<String> {
        public final String n;

        public n(String str) {
            this.n = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strQg = um.qg(this.n);
            com.byazt.rb.qg.n("RomUtils", "property:" + strQg + ",getSystemProperty use time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
            if (!TextUtils.isEmpty(strQg)) {
                try {
                    com.byazt.rb.qg.s("RomUtils", "SP-getPropertyFromSP:".concat(String.valueOf(strQg)));
                    com.byazt.gwu.s sVarPy = um.py();
                    if (sVarPy != null) {
                        sVarPy.n("rom_property_info", strQg);
                    }
                } catch (Throwable unused) {
                }
            }
            return strQg;
        }
    }

    private static String ou() {
        try {
            com.byazt.gwu.s sVarPy = py();
            String string = sVarPy != null ? sVarPy.getString("rom_property_info", "") : "";
            com.byazt.rb.qg.qg("RomUtils", "get Property From SP...=".concat(String.valueOf(string)));
            return string;
        } catch (Throwable unused) {
            return "";
        }
    }
}

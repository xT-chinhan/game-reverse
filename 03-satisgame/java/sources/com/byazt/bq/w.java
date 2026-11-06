package com.byazt.bq;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.vf.u;
import com.byazt.vf.wo;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 290, 13})
public class w {
    public static int n;
    public static int qg;

    public static String n(com.byazt.vf.n nVar) {
        StringBuilder sb = new StringBuilder();
        try {
            if (n()) {
                sb.append("MIUI-");
            } else if (qg()) {
                sb.append("FLYME-");
            } else {
                String strQg = qg(nVar);
                if (n(strQg, nVar)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strQg)) {
                    sb.append(strQg).append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public static boolean n() {
        if (n == 0) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    n = 1;
                } else {
                    n = 2;
                }
            } catch (Exception unused) {
            }
        }
        return n == 1;
    }

    public static boolean qg() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String qg(com.byazt.vf.n nVar) {
        return qg("ro.build.version.emui", nVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String qg(String str, com.byazt.vf.n nVar) {
        String strS;
        try {
            strS = s(nVar);
            try {
                if (TextUtils.isEmpty(strS)) {
                    final com.byazt.qit.w wVar = new com.byazt.qit.w(new n(str, nVar), 5, 2);
                    ((wo) com.byazt.qp.q.n("thread_service")).qg().execute(new com.byazt.qit.x("getSystemPropertyTask") { // from class: com.byazt.bq.w.1
                        @Override // java.lang.Runnable
                        public void run() {
                            wVar.run();
                        }
                    });
                    strS = (String) wVar.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            strS = "";
        }
        return strS == null ? "" : strS;
    }

    private static String s(com.byazt.vf.n nVar) {
        try {
            return fs.n("rom_info", nVar).qg("rom_property_info", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    @com.byazt.cp.n(n = {0, 1, 290, 108})
    public static class n implements Callable<String> {
        public String n;
        public com.byazt.vf.n qg;

        public n(String str, com.byazt.vf.n nVar) {
            this.n = str;
            this.qg = nVar;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            System.currentTimeMillis();
            String strN = w.n(this.n);
            System.currentTimeMillis();
            if (!TextUtils.isEmpty(strN)) {
                try {
                    fs.n("rom_info", this.qg).n("rom_property_info", strN);
                } catch (Throwable unused) {
                }
            }
            return strN;
        }
    }

    public static String n(String str) {
        u uVar = (u) com.byazt.qp.q.n("system_info");
        return uVar != null ? uVar.n(str) : "";
    }

    public static String s() {
        String str = Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
        String str2 = Build.MANUFACTURER;
        if (n()) {
            return "miui_" + str;
        }
        if (q()) {
            return "huawei_" + str;
        }
        if (str2.toLowerCase(Locale.ROOT).contains("oppo")) {
            return "oppo_" + str;
        }
        if (str2.toLowerCase(Locale.ROOT).contains("vivo")) {
            return "vivo_" + str;
        }
        return str2.toLowerCase(Locale.ROOT).contains("oneplus") ? "oneplus_" + str : str;
    }

    public static boolean q() {
        if (qg == 0) {
            try {
                if (Class.forName("com.huawei.system.BuildEx") != null) {
                    qg = 1;
                } else {
                    qg = 2;
                }
            } catch (Exception unused) {
            }
        }
        return qg == 1;
    }

    public static boolean n(String str, com.byazt.vf.n nVar) {
        if (TextUtils.isEmpty(str)) {
            str = qg(nVar);
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || l();
    }

    public static boolean l() {
        try {
            return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith("huawei")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("huawei"));
        } catch (Throwable unused) {
            return false;
        }
    }
}

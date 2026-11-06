package com.byazt.fp;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.vkw.er;
import com.byazt.vkw.qi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 5})
public class uc {
    public static int pr = 0;
    public static int hw = 0;

    public static String pr(com.byazt.vkw.pr prVar) {
        StringBuilder sb = new StringBuilder();
        try {
            if (pr()) {
                sb.append("MIUI-");
            } else if (hw()) {
                sb.append("FLYME-");
            } else {
                String strHw = hw(prVar);
                if (pr(strHw, prVar)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strHw)) {
                    sb.append(strHw).append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable th) {
        }
        return sb.toString();
    }

    public static boolean pr() {
        if (pr == 0) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    pr = 1;
                } else {
                    pr = 2;
                }
            } catch (Exception e) {
            }
        }
        return pr == 1;
    }

    public static boolean hw() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String hw(com.byazt.vkw.pr prVar) {
        return hw("ro.build.version.emui", prVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String hw(String str, com.byazt.vkw.pr prVar) {
        String strHn;
        try {
            strHn = hn(prVar);
            try {
                if (TextUtils.isEmpty(strHn)) {
                    final com.byazt.xlm.uc ucVar = new com.byazt.xlm.uc(new pr(str, prVar), 5, 2);
                    ((qi) com.byazt.zs.uc.pr("thread_service")).hw().execute(new com.byazt.xlm.fw("getSystemPropertyTask") { // from class: com.byazt.fp.uc.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ucVar.run();
                        }
                    });
                    strHn = (String) ucVar.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            strHn = "";
        }
        if (strHn == null) {
            return "";
        }
        return strHn;
    }

    private static String hn(com.byazt.vkw.pr prVar) {
        try {
            return zo.pr("rom_info", prVar).hw("rom_property_info", "");
        } catch (Throwable th) {
            return "";
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 129})
    public static class pr implements Callable<String> {
        public com.byazt.vkw.pr hw;
        public String pr;

        public pr(String str, com.byazt.vkw.pr prVar) {
            this.pr = str;
            this.hw = prVar;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            System.currentTimeMillis();
            String strPr = uc.pr(this.pr);
            System.currentTimeMillis();
            if (!TextUtils.isEmpty(strPr)) {
                try {
                    zo.pr("rom_info", this.hw).pr("rom_property_info", strPr);
                } catch (Throwable th) {
                }
            }
            return strPr;
        }
    }

    public static String pr(String str) {
        er erVar = (er) com.byazt.zs.uc.pr("system_info");
        if (erVar != null) {
            return erVar.pr(str);
        }
        return "";
    }

    public static String hn() {
        String str = Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
        String str2 = Build.MANUFACTURER;
        if (pr()) {
            return "miui_" + str;
        }
        if (x()) {
            return "huawei_" + str;
        }
        if (str2.toLowerCase(Locale.ROOT).contains("oppo")) {
            return "oppo_" + str;
        }
        if (str2.toLowerCase(Locale.ROOT).contains("vivo")) {
            return "vivo_" + str;
        }
        if (str2.toLowerCase(Locale.ROOT).contains("oneplus")) {
            return "oneplus_" + str;
        }
        return str;
    }

    public static boolean x() {
        if (hw == 0) {
            try {
                if (Class.forName("com.huawei.system.BuildEx") != null) {
                    hw = 1;
                } else {
                    hw = 2;
                }
            } catch (Exception e) {
            }
        }
        return hw == 1;
    }

    public static boolean pr(String str, com.byazt.vkw.pr prVar) {
        if (TextUtils.isEmpty(str)) {
            str = hw(prVar);
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || c();
    }

    public static boolean c() {
        try {
            return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith("huawei")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("huawei"));
        } catch (Throwable th) {
            return false;
        }
    }
}

package com.byazt.wo;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import com.byazt.ae.aj;
import com.byazt.dea.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, 20})
public class hn {
    public static File pr = null;
    public static File hw = null;
    public static File hn = null;

    private static void c() {
        if (pr == null) {
            File file = new File(Zeus.getAppApplication().getFilesDir(), MediationConstant.ADN_PANGLE + aj.hn);
            pr = file;
            pr(file);
        }
    }

    public static String pr(File file) {
        if (file != null) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
        return null;
    }

    private static String pr(String... strArr) {
        c();
        File file = pr;
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    file = new File(file, str);
                }
            }
        }
        return pr(file);
    }

    public static String pr() {
        c();
        return pr.getPath();
    }

    public static String hw() {
        Application appApplication = Zeus.getAppApplication();
        if (hw == null) {
            File downloadDir = GlobalParam.getInstance().getDownloadDir();
            if (downloadDir == null) {
                downloadDir = new File(appApplication.getFilesDir(), ".pangle" + aj.hw);
            }
            hw = downloadDir;
        }
        return pr(hw);
    }

    public static String hn() {
        Application appApplication = Zeus.getAppApplication();
        if (hn == null) {
            hn = new File(appApplication.getFilesDir(), ".pangle" + aj.pr);
        }
        return pr(hn);
    }

    public static String x() {
        File externalFilesDir;
        Application appApplication = Zeus.getAppApplication();
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalFilesDir = appApplication.getExternalFilesDir(".pangle" + aj.hw)) != null) {
                return pr(externalFilesDir);
            }
            return null;
        } catch (Exception e) {
            uc.pr(e);
            return null;
        }
    }

    public static String pr(String str, int i) {
        c();
        File file = pr;
        String[] strArr = {str, "version-".concat(String.valueOf(i))};
        for (int i2 = 0; i2 < 2; i2++) {
            String str2 = strArr[i2];
            if (!TextUtils.isEmpty(str2)) {
                file = new File(file, str2);
            }
        }
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    public static String pr(String str) {
        return pr(str);
    }

    public static String hw(String str, int i) {
        return new File(pr(str, "version-".concat(String.valueOf(i)), "apk"), "base-1.apk").getPath();
    }

    public static String hn(String str, int i) {
        return com.byazt.gs.aj.m() ? pr(str, "version-".concat(String.valueOf(i)), "apk", "oat", com.byazt.xid.hw.pr()) : pr(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static String x(String str, int i) {
        return pr(str, "version-".concat(String.valueOf(i)), "lib");
    }

    public static String c(String str, int i) {
        return new File(pr(str, "version-".concat(String.valueOf(i)), "apk", "temp"), "base-1.apk").getPath();
    }

    public static String uc(String str, int i) {
        return new File(pr(str, "version-".concat(String.valueOf(i)), "apk")).getPath();
    }

    public static String fw(String str, int i) {
        return new File(pr(str, "version-".concat(String.valueOf(i)), "apk", "temp")).getPath();
    }

    public static String zo(String str, int i) {
        return com.byazt.gs.aj.m() ? pr(str, "version-".concat(String.valueOf(i)), "apk", "temp", "oat", com.byazt.xid.hw.pr()) : pr(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static boolean aj(String str, int i) {
        return new File(pr() + File.separator + str + File.separator + "version-" + i).exists();
    }

    public static String pr(String str, int i, String str2) {
        return new File(pr(str, "version-".concat(String.valueOf(i)), "dex"), str2).getPath();
    }

    public static File[] vk(String str, int i) {
        String strPr = pr(str, "version-".concat(String.valueOf(i)), "dex");
        if (!TextUtils.isEmpty(strPr)) {
            return new File(strPr).listFiles(new FileFilter() { // from class: com.byazt.wo.hn.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.isFile() && file.getName().endsWith(".dex");
                }
            });
        }
        return null;
    }

    public static String w(String str, int i) {
        return new File(pr(str, "version-".concat(String.valueOf(i)), "config"), "config.json").getPath();
    }
}

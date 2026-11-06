package com.byazt.zi;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import com.byazt.ry.rv;
import com.byazt.vx.w;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1948, 8})
public class s {
    public static File n;
    public static File qg;
    public static File s;

    private static void l() {
        if (n == null) {
            File file = new File(Zeus.getAppApplication().getFilesDir(), MediationConstant.ADN_PANGLE + rv.s);
            n = file;
            n(file);
        }
    }

    public static String n(File file) {
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    private static String n(String... strArr) {
        l();
        File file = n;
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    file = new File(file, str);
                }
            }
        }
        return n(file);
    }

    public static String n() {
        l();
        return n.getPath();
    }

    public static String qg() {
        Application appApplication = Zeus.getAppApplication();
        if (qg == null) {
            File downloadDir = GlobalParam.getInstance().getDownloadDir();
            if (downloadDir == null) {
                downloadDir = new File(appApplication.getFilesDir(), ".pangle" + rv.qg);
            }
            qg = downloadDir;
        }
        return n(qg);
    }

    public static String s() {
        Application appApplication = Zeus.getAppApplication();
        if (s == null) {
            s = new File(appApplication.getFilesDir(), ".pangle" + rv.n);
        }
        return n(s);
    }

    public static String q() {
        File externalFilesDir;
        Application appApplication = Zeus.getAppApplication();
        try {
            if (!"mounted".equals(Environment.getExternalStorageState()) || (externalFilesDir = appApplication.getExternalFilesDir(".pangle" + rv.qg)) == null) {
                return null;
            }
            return n(externalFilesDir);
        } catch (Exception e) {
            w.n(e);
            return null;
        }
    }

    public static String n(String str, int i) {
        l();
        File file = n;
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

    public static String n(String str) {
        return n(str);
    }

    public static String qg(String str, int i) {
        return new File(n(str, "version-".concat(String.valueOf(i)), "apk"), "base-1.apk").getPath();
    }

    public static String s(String str, int i) {
        return com.byazt.gx.rv.oa() ? n(str, "version-".concat(String.valueOf(i)), "apk", "oat", com.byazt.sw.qg.n()) : n(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static String q(String str, int i) {
        return n(str, "version-".concat(String.valueOf(i)), "lib");
    }

    public static String l(String str, int i) {
        return new File(n(str, "version-".concat(String.valueOf(i)), "apk", "temp"), "base-1.apk").getPath();
    }

    public static String w(String str, int i) {
        return new File(n(str, "version-".concat(String.valueOf(i)), "apk")).getPath();
    }

    public static String x(String str, int i) {
        return new File(n(str, "version-".concat(String.valueOf(i)), "apk", "temp")).getPath();
    }

    public static String fs(String str, int i) {
        return com.byazt.gx.rv.oa() ? n(str, "version-".concat(String.valueOf(i)), "apk", "temp", "oat", com.byazt.sw.qg.n()) : n(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static boolean rv(String str, int i) {
        return new File(n() + File.separator + str + File.separator + "version-" + i).exists();
    }

    public static String n(String str, int i, String str2) {
        return new File(n(str, "version-".concat(String.valueOf(i)), "dex"), str2).getPath();
    }

    public static File[] tj(String str, int i) {
        String strN = n(str, "version-".concat(String.valueOf(i)), "dex");
        if (TextUtils.isEmpty(strN)) {
            return null;
        }
        return new File(strN).listFiles(new FileFilter() { // from class: com.byazt.zi.s.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".dex");
            }
        });
    }

    public static String cp(String str, int i) {
        return new File(n(str, "version-".concat(String.valueOf(i)), "config"), "config.json").getPath();
    }
}

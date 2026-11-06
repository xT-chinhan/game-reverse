package com.bytedance.pangle.ka;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ny;
import com.bytedance.sdk.openadsdk.api.ab;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    private static File ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static File f641ms;
    private static File xr;

    private static void ka() {
        if (f641ms == null) {
            File file = new File(Zeus.getAppApplication().getFilesDir(), MediationConstant.ADN_PANGLE + ny.ah);
            f641ms = file;
            ms(file);
        }
    }

    public static String ms(File file) {
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    private static String ms(String... strArr) {
        ka();
        File file = f641ms;
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    file = new File(file, str);
                }
            }
        }
        return ms(file);
    }

    public static String ms() {
        ka();
        return f641ms.getPath();
    }

    public static String xr() {
        Application appApplication = Zeus.getAppApplication();
        if (xr == null) {
            File downloadDir = GlobalParam.getInstance().getDownloadDir();
            if (downloadDir == null) {
                downloadDir = new File(appApplication.getFilesDir(), ".pangle" + ny.xr);
            }
            xr = downloadDir;
        }
        return ms(xr);
    }

    public static String ah() {
        Application appApplication = Zeus.getAppApplication();
        if (ah == null) {
            ah = new File(appApplication.getFilesDir(), ".pangle" + ny.f650ms);
        }
        return ms(ah);
    }

    public static String d() {
        File externalFilesDir;
        Application appApplication = Zeus.getAppApplication();
        try {
            if (!"mounted".equals(Environment.getExternalStorageState()) || (externalFilesDir = appApplication.getExternalFilesDir(".pangle" + ny.xr)) == null) {
                return null;
            }
            return ms(externalFilesDir);
        } catch (Exception e) {
            ab.ms(e);
            return null;
        }
    }

    public static String ms(String str, int i) {
        ka();
        File file = f641ms;
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

    public static String ms(String str) {
        return ms(str);
    }

    public static String xr(String str, int i) {
        return new File(ms(str, "version-".concat(String.valueOf(i)), "apk"), "base-1.apk").getPath();
    }

    public static String ah(String str, int i) {
        return com.bytedance.pangle.util.ny.u() ? ms(str, "version-".concat(String.valueOf(i)), "apk", "oat", com.bytedance.pangle.c.xr.ms()) : ms(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static String d(String str, int i) {
        return ms(str, "version-".concat(String.valueOf(i)), "lib");
    }

    public static String ka(String str, int i) {
        return new File(ms(str, "version-".concat(String.valueOf(i)), "apk", "temp"), "base-1.apk").getPath();
    }

    public static String c(String str, int i) {
        return new File(ms(str, "version-".concat(String.valueOf(i)), "apk")).getPath();
    }

    public static String ab(String str, int i) {
        return new File(ms(str, "version-".concat(String.valueOf(i)), "apk", "temp")).getPath();
    }

    public static String x(String str, int i) {
        return com.bytedance.pangle.util.ny.u() ? ms(str, "version-".concat(String.valueOf(i)), "apk", "temp", "oat", com.bytedance.pangle.c.xr.ms()) : ms(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static String ny(String str, int i) {
        return ms(str, "version-".concat(String.valueOf(i)), "secondary-dexes");
    }

    public static boolean ch(String str, int i) {
        return new File(ms() + File.separator + str + File.separator + "version-" + i).exists();
    }

    public static String ms(String str, int i, String str2) {
        return new File(ms(str, "version-".concat(String.valueOf(i)), "dex"), str2).getPath();
    }

    public static File[] hi(String str, int i) {
        String strMs = ms(str, "version-".concat(String.valueOf(i)), "dex");
        if (TextUtils.isEmpty(strMs)) {
            return null;
        }
        return new File(strMs).listFiles(new FileFilter() { // from class: com.bytedance.pangle.ka.ah.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".dex");
            }
        });
    }

    public static String sl(String str, int i) {
        return new File(ms(str, "version-".concat(String.valueOf(i)), "config"), "config.json").getPath();
    }
}

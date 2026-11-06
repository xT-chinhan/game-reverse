package com.byazt.wf;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 201, 19})
public class ho {
    public static JSONObject pr(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("inner_app_used", hw(context));
            jSONObject.put("inner_free", hw());
            jSONObject.put("inner_total", hn());
            jSONObject.put("sdcard_app_used", hn(context));
            jSONObject.put("sdcard_free", x());
            jSONObject.put("sdcard_total", c());
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private static long hw(Context context) {
        try {
            return hn(com.byazt.mg.hw.pr(context).getParentFile());
        } catch (Exception e) {
            return 0L;
        }
    }

    private static long hw() {
        try {
            return hw(Environment.getRootDirectory());
        } catch (Exception e) {
            return 0L;
        }
    }

    private static long hn() {
        try {
            return pr(Environment.getRootDirectory());
        } catch (Exception e) {
            return 0L;
        }
    }

    private static long hn(Context context) {
        File filePr;
        try {
            if (pr() && (filePr = com.byazt.mg.hw.pr(context, null)) != null) {
                return hn(filePr.getParentFile());
            }
            return 0L;
        } catch (Exception e) {
            return 0L;
        }
    }

    private static long x() {
        try {
            if (pr()) {
                return Environment.getExternalStorageDirectory().getFreeSpace();
            }
            return 0L;
        } catch (Exception e) {
            return 0L;
        }
    }

    private static long c() {
        try {
            if (pr()) {
                return Environment.getExternalStorageDirectory().getTotalSpace();
            }
            return 0L;
        } catch (Exception e) {
            return 0L;
        }
    }

    public static boolean pr() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static long pr(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getTotalBytes();
            }
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            return 0L;
        }
    }

    public static long hw(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getFreeBytes();
            }
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            return 0L;
        }
    }

    public static long hn(File file) {
        long length;
        File[] fileArrListFiles = file.listFiles();
        long j = 0;
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                length = hn(file2);
            } else {
                length = file2.length();
            }
            j += length;
        }
        return j;
    }
}

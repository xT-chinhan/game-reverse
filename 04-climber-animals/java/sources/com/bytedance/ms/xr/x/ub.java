package com.bytedance.ms.xr.x;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ub {
    public static JSONObject ms(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("inner_app_used", xr(context));
            jSONObject.put("inner_free", xr());
            jSONObject.put("inner_total", ah());
            jSONObject.put("sdcard_app_used", ah(context));
            jSONObject.put("sdcard_free", d());
            jSONObject.put("sdcard_total", ka());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static long xr(Context context) {
        try {
            return ah(com.bytedance.sdk.openadsdk.api.plugin.xr.ms(context).getParentFile());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long xr() {
        try {
            return xr(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long ah() {
        try {
            return ms(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long ah(Context context) {
        File fileMs;
        try {
            if (!ms() || (fileMs = com.bytedance.sdk.openadsdk.api.plugin.xr.ms(context, null)) == null) {
                return 0L;
            }
            return ah(fileMs.getParentFile());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long d() {
        try {
            if (ms()) {
                return Environment.getExternalStorageDirectory().getFreeSpace();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long ka() {
        try {
            if (ms()) {
                return Environment.getExternalStorageDirectory().getTotalSpace();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static boolean ms() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static long ms(File file) {
        try {
            return new StatFs(file.getPath()).getTotalBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long xr(File file) {
        try {
            return new StatFs(file.getPath()).getFreeBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long ah(File file) {
        long length;
        File[] fileArrListFiles = file.listFiles();
        long j = 0;
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                length = ah(file2);
            } else {
                length = file2.length();
            }
            j += length;
        }
        return j;
    }
}

package com.byazt.yw;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 210})
public class k {
    public static JSONObject n(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("inner_app_used", qg(context));
            jSONObject.put("inner_free", qg());
            jSONObject.put("inner_total", s());
            jSONObject.put("sdcard_app_used", s(context));
            jSONObject.put("sdcard_free", q());
            jSONObject.put("sdcard_total", l());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static long qg(Context context) {
        try {
            return s(com.byazt.qyu.qg.n(context).getParentFile());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long qg() {
        try {
            return qg(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long s() {
        try {
            return n(Environment.getRootDirectory());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long s(Context context) {
        File fileN;
        try {
            if (!n() || (fileN = com.byazt.qyu.qg.n(context, null)) == null) {
                return 0L;
            }
            return s(fileN.getParentFile());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long q() {
        try {
            if (n()) {
                return Environment.getExternalStorageDirectory().getFreeSpace();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static long l() {
        try {
            if (n()) {
                return Environment.getExternalStorageDirectory().getTotalSpace();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static boolean n() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static long n(File file) {
        try {
            return new StatFs(file.getPath()).getTotalBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long qg(File file) {
        try {
            return new StatFs(file.getPath()).getFreeBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long s(File file) {
        long length;
        File[] fileArrListFiles = file.listFiles();
        long j = 0;
        if (fileArrListFiles == null) {
            return 0L;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                length = s(file2);
            } else {
                length = file2.length();
            }
            j += length;
        }
        return j;
    }
}

package com.bykv.vk.component.ttvideo.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import com.byazt.ol.TTDownloadField;
import java.io.BufferedReader;
import java.io.FileReader;

/* JADX INFO: loaded from: classes2.dex */
public class MemoryInfo {
    private static long[] mRomMemroy;
    private static long mTotalMemorySize = 0;

    public static long[] getRomMemroy() {
        if (mRomMemroy == null) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            mRomMemroy = new long[]{getTotalInternalMemorySize(), ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())};
        }
        return mRomMemroy;
    }

    public static long getTotalInternalMemorySize() {
        if (mTotalMemorySize == 0) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            mTotalMemorySize = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        }
        return mTotalMemorySize;
    }

    public static long getAvailMemory(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public static long getTolalMemory() throws Throwable {
        BufferedReader bufferedReader;
        String str = null;
        str = null;
        str = null;
        str = null;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8);
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        str = line;
                    }
                    bufferedReader.close();
                } catch (Exception e) {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return Integer.parseInt(str.substring(str.indexOf(58) + 1, str.indexOf(107)).trim());
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception e2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
            }
        } catch (Exception e4) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return Integer.parseInt(str.substring(str.indexOf(58) + 1, str.indexOf(107)).trim());
    }
}

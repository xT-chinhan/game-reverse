package com.byazt.tk;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy {
    public static long n(String str) {
        long availableBlocks = 0;
        try {
            if (!TextUtils.isEmpty(str)) {
                StatFs statFs = new StatFs(str);
                availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
        } catch (Throwable unused) {
        }
        String.valueOf(str);
        return availableBlocks;
    }

    public static long n() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable unused) {
            return 0L;
        }
    }
}

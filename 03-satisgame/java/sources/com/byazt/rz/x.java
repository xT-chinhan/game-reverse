package com.byazt.rz;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 21})
public class x {
    public static long n(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return n(file, file.lastModified(), 0);
    }

    private static long n(File file, long j, int i) {
        File[] fileArrListFiles;
        if (file != null && file.exists()) {
            j = Math.max(j, file.lastModified());
            int i2 = i + 1;
            if (i2 >= 50) {
                return j;
            }
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    j = Math.max(j, n(file2, j, i2));
                }
            }
        }
        return j;
    }
}

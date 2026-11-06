package com.byazt.uk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET, 62})
public class fw {
    public static long pr(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return pr(file, file.lastModified(), 0);
    }

    private static long pr(File file, long j, int i) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return j;
        }
        long jMax = Math.max(j, file.lastModified());
        int i2 = i + 1;
        if (i2 >= 50) {
            return jMax;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                jMax = Math.max(jMax, pr(file2, jMax, i2));
            }
        }
        return jMax;
    }
}

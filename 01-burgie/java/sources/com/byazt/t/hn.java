package com.byazt.t;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_FALLBACK_THRESHLOD, 20})
public class hn {
    public static long pr(String str, String str2) {
        File fileHn = hn(str, str2);
        if (fileHn.exists()) {
            return fileHn.length();
        }
        File fileHw = hw(str, str2);
        if (fileHw.exists()) {
            return fileHw.length();
        }
        return 0L;
    }

    public static File hw(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2 + ".temp");
    }

    public static File hn(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2);
    }

    public static boolean pr(RandomAccessFile randomAccessFile, byte[] bArr, long j, int i) throws IOException {
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr, 0, i);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}

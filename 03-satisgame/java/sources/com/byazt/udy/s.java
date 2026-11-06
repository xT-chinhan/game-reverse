package com.byazt.udy;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS, 8})
public class s {
    public static long n(String str, String str2) {
        File fileS = s(str, str2);
        if (fileS.exists()) {
            return fileS.length();
        }
        File fileQg = qg(str, str2);
        if (fileQg.exists()) {
            return fileQg.length();
        }
        return 0L;
    }

    public static File qg(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2 + ".temp");
    }

    public static File s(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2);
    }

    public static boolean n(RandomAccessFile randomAccessFile, byte[] bArr, long j, int i) throws IOException {
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr, 0, i);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}

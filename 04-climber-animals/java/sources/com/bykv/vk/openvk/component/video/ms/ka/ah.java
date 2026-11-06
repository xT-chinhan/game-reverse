package com.bykv.vk.openvk.component.video.ms.ka;

import com.anythink.dlopt.common.a.a;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
public class ah {
    public static long ms(String str, String str2) {
        File fileAh = ah(str, str2);
        if (fileAh.exists()) {
            return fileAh.length();
        }
        File fileXr = xr(str, str2);
        if (fileXr.exists()) {
            return fileXr.length();
        }
        return 0L;
    }

    public static File xr(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2 + a.f);
    }

    public static File ah(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2);
    }

    public static boolean ms(RandomAccessFile randomAccessFile, byte[] bArr, long j, int i) throws IOException {
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr, 0, i);
            return true;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.c.ah.ms("VideoFilesUtils", "append failed", th);
            return false;
        }
    }
}

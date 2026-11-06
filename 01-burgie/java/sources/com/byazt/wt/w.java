package com.byazt.wt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 109})
public class w {
    public static byte[] pr(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            byte[] bArr2 = new byte[4096];
            while (true) {
                int i = byteArrayInputStream.read(bArr2, 0, 4096);
                if (i > 0) {
                    gZIPOutputStream.write(bArr2, 0, i);
                } else {
                    gZIPOutputStream.close();
                    byteArrayInputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                        return byteArray;
                    } catch (Exception e) {
                        return byteArray;
                    }
                }
            }
        } catch (Exception e2) {
            return null;
        }
    }

    public static String hw(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int i = gZIPInputStream.read(bArr2);
                    if (i < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i);
                }
                String str = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
                try {
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                } catch (Throwable th) {
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                try {
                    com.byazt.ca.ho.hw("gzip compress error.", th.getMessage());
                    try {
                    } catch (Throwable th3) {
                        return null;
                    }
                } finally {
                    try {
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                    } catch (Throwable th4) {
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
            gZIPInputStream = null;
        }
    }
}

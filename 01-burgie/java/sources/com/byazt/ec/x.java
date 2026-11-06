package com.byazt.ec;

import com.bumptech.glide.load.Key;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, 121})
public class x {
    /* JADX WARN: Code duplicated, block: B:24:0x0048  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    public static byte[] pr(String str) {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                if (com.byazt.zrg.pr.zo()) {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(str.getBytes(Key.STRING_CHARSET_NAME));
                        gZIPOutputStream = gZIPOutputStream2;
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        try {
                            w.hw(th);
                            if (gZIPOutputStream != null) {
                                gZIPOutputStream.close();
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                            if (com.byazt.zrg.pr.zo()) {
                                return com.byakv.z.TTEncryptUtils.pr(byteArray, byteArray.length);
                            }
                            return byteArray;
                        } catch (Throwable th2) {
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e) {
                                    w.hw(e);
                                }
                            }
                            throw th2;
                        }
                    }
                } else {
                    byteArrayOutputStream.write(str.getBytes(Key.STRING_CHARSET_NAME));
                }
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                }
            } catch (IOException e2) {
                w.hw(e2);
            }
        } catch (Throwable th3) {
            th = th3;
        }
        byteArray = byteArrayOutputStream.toByteArray();
        if (com.byazt.zrg.pr.zo()) {
            return com.byakv.z.TTEncryptUtils.pr(byteArray, byteArray.length);
        }
        return byteArray;
    }
}

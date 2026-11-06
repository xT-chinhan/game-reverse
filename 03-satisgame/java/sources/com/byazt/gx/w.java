package com.byazt.gx;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_FORMAT, 13})
public final class w {
    public static final char[] n = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String n(String str) {
        return n(str.getBytes());
    }

    public static String n(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(com.anythink.core.common.u.n.a);
                messageDigest.update(bArr);
                return qg(messageDigest.digest());
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static String qg(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        char[] cArr = new char[length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = n;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static String n(File file) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(com.anythink.core.common.u.n.a);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                int i = fileInputStream.read(bArr, 0, 8192);
                if (i > 0) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    fileInputStream.close();
                    return qg(messageDigest.digest());
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }
}

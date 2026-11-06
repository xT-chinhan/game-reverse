package com.byazt.ec;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, 761})
public class TTEncryptUtils {
    public static byte[] a(byte[] bArr, int i) {
        try {
            return com.byakv.z.TTEncryptUtils.pr(bArr, i);
        } catch (Throwable th) {
            return null;
        }
    }

    public static byte[] b(byte[] bArr, int i) {
        try {
            return com.byakv.z.TTEncryptUtils.hw(bArr, i);
        } catch (Throwable th) {
            return null;
        }
    }
}

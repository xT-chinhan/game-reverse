package com.byazt.du;

import com.bumptech.glide.load.Key;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.nio.charset.Charset;
import kotlin.UShort;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, 213})
public final class cz {
    public static final Charset pr = Charset.forName(Key.STRING_CHARSET_NAME);

    public static void pr(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    public static short pr(short s) {
        int i = s & UShort.MAX_VALUE;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    public static int pr(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static void pr(Throwable th) throws Throwable {
        hw(th);
    }

    private static <T extends Throwable> void hw(Throwable th) throws Throwable {
        throw th;
    }

    public static boolean pr(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}

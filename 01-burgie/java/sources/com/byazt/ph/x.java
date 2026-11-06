package com.byazt.ph;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 121})
public final class x {
    public static <T> T pr(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    public static void pr(InputStream inputStream, byte[] bArr) throws IOException {
        pr(inputStream, bArr, 0, bArr.length);
    }

    public static void pr(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int iHw = hw(inputStream, bArr, i, i2);
        if (iHw != i2) {
            throw new EOFException("reached end of stream after reading " + iHw + " bytes; " + i2 + " bytes expected");
        }
    }

    public static int hw(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        pr(inputStream);
        pr(bArr);
        int i3 = 0;
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i2)));
        }
        pr(i, i + i2, bArr.length);
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }

    public static void pr(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(new StringBuilder().append(i).append(i2).append(i3).toString());
        }
    }
}

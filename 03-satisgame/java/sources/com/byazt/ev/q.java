package com.byazt.ev;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 5})
public final class q {
    public static <T> T n(T t) {
        t.getClass();
        return t;
    }

    public static void n(InputStream inputStream, byte[] bArr) throws IOException {
        n(inputStream, bArr, 0, bArr.length);
    }

    public static void n(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int iQg = qg(inputStream, bArr, i, i2);
        if (iQg != i2) {
            throw new EOFException("reached end of stream after reading " + iQg + " bytes; " + i2 + " bytes expected");
        }
    }

    public static int qg(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        n(inputStream);
        n(bArr);
        int i3 = 0;
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i2)));
        }
        n(i, i + i2, bArr.length);
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }

    public static void n(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(new StringBuilder().append(i).append(i2).append(i3).toString());
        }
    }
}

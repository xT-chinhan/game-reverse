package com.bytedance.pangle.res.ms;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static <T> T ms(T t) {
        t.getClass();
        return t;
    }

    public static void ms(InputStream inputStream, byte[] bArr) throws IOException {
        ms(inputStream, bArr, 0, bArr.length);
    }

    public static void ms(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int iXr = xr(inputStream, bArr, i, i2);
        if (iXr != i2) {
            throw new EOFException("reached end of stream after reading " + iXr + " bytes; " + i2 + " bytes expected");
        }
    }

    public static int xr(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        ms(inputStream);
        ms(bArr);
        int i3 = 0;
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i2)));
        }
        ms(i, i + i2, bArr.length);
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }

    public static void ms(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(new StringBuilder().append(i).append(i2).append(i3).toString());
        }
    }
}

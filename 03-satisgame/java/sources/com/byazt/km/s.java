package com.byazt.km;

import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 832, 8})
public class s {
    public static final char[] n = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String n(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        return n(bArr, 0, bArr.length);
    }

    public static String n(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5 + i] & UByte.MAX_VALUE;
            int i7 = i4 + 1;
            char[] cArr2 = n;
            cArr[i4] = cArr2[i6 >> 4];
            i4 = i7 + 1;
            cArr[i7] = cArr2[i6 & 15];
        }
        return new String(cArr, 0, i3);
    }

    public static String qg(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance(com.anythink.core.common.u.n.a);
                    messageDigest.update(bArr);
                    return n(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}

package com.byazt.cq;

import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 883, 19})
public class n {
    public static final byte[] n = {-119, 80, 78, 71, 13, 10, 26, 10};
    public static final byte[] qg = {97, 99, 84, 76};

    public static boolean n(byte[] bArr) {
        try {
            if (!n(bArr, n)) {
                return false;
            }
            int i = 8;
            while (i >= 0 && i + 12 <= bArr.length) {
                int iN = n(bArr, i);
                int i2 = i + 4;
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArr, i2, bArr2, 0, 4);
                int i3 = i2 + 4;
                if (Arrays.equals(bArr2, qg)) {
                    return true;
                }
                i = i3 + iN + 4;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean n(byte[] bArr, byte[] bArr2) {
        if (bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int n(byte[] bArr, int i) {
        return (bArr[i + 3] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
    }
}

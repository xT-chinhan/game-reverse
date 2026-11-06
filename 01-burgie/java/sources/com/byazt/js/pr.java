package com.byazt.js;

import com.umeng.analytics.pro.cc;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 756, 37})
public class pr {
    public static final byte[] pr = {-119, 80, 78, 71, cc.k, 10, 26, 10};
    public static final byte[] hw = {97, 99, 84, 76};

    public static boolean pr(byte[] bArr) {
        try {
            if (!pr(bArr, pr)) {
                return false;
            }
            int i = 8;
            while (i >= 0 && i + 12 <= bArr.length) {
                int iPr = pr(bArr, i);
                int i2 = i + 4;
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArr, i2, bArr2, 0, 4);
                int i3 = i2 + 4;
                if (Arrays.equals(bArr2, hw)) {
                    return true;
                }
                i = i3 + iPr + 4;
            }
        } catch (Throwable th) {
        }
        return false;
    }

    private static boolean pr(byte[] bArr, byte[] bArr2) {
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

    private static int pr(byte[] bArr, int i) {
        return (bArr[i + 3] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
    }
}

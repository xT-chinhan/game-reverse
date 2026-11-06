package com.bytedance.sdk.component.adexpress.d;

import com.bytedance.sdk.component.utils.sl;
import com.umeng.analytics.pro.ek;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final byte[] f756ms = {-119, 80, 78, 71, ek.k, 10, 26, 10};
    private static final byte[] xr = {97, 99, 84, 76};

    public static boolean ms(byte[] bArr) {
        try {
            if (!ms(bArr, f756ms)) {
                return false;
            }
            int i = 8;
            while (i >= 0 && i + 12 <= bArr.length) {
                int iMs = ms(bArr, i);
                int i2 = i + 4;
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArr, i2, bArr2, 0, 4);
                int i3 = i2 + 4;
                if (Arrays.equals(bArr2, xr)) {
                    return true;
                }
                i = i3 + iMs + 4;
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
        return false;
    }

    private static boolean ms(byte[] bArr, byte[] bArr2) {
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

    private static int ms(byte[] bArr, int i) {
        return (bArr[i + 3] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
    }
}

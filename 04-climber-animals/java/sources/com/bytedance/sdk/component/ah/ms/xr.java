package com.bytedance.sdk.component.ah.ms;

import com.anythink.basead.exoplayer.b;
import com.umeng.analytics.pro.ek;
import java.io.UnsupportedEncodingException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
final class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final byte[] f1022ms = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] xr = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    public static String ms(byte[] bArr) {
        return ms(bArr, f1022ms);
    }

    private static String ms(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int i3 = i + 1;
            bArr3[i] = bArr2[(bArr[i2] & UByte.MAX_VALUE) >> 2];
            int i4 = i3 + 1;
            int i5 = i2 + 1;
            bArr3[i3] = bArr2[((bArr[i2] & 3) << 4) | ((bArr[i5] & UByte.MAX_VALUE) >> 4)];
            int i6 = i4 + 1;
            int i7 = (bArr[i5] & ek.m) << 2;
            int i8 = i2 + 2;
            bArr3[i4] = bArr2[i7 | ((bArr[i8] & UByte.MAX_VALUE) >> 6)];
            i = i6 + 1;
            bArr3[i6] = bArr2[bArr[i8] & com.anythink.core.common.s.a.c.c];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            int i9 = i + 1;
            bArr3[i] = bArr2[(bArr[length] & UByte.MAX_VALUE) >> 2];
            int i10 = i9 + 1;
            bArr3[i9] = bArr2[(bArr[length] & 3) << 4];
            bArr3[i10] = 61;
            bArr3[i10 + 1] = 61;
        } else if (length2 == 2) {
            int i11 = i + 1;
            bArr3[i] = bArr2[(bArr[length] & UByte.MAX_VALUE) >> 2];
            int i12 = i11 + 1;
            int i13 = (bArr[length] & 3) << 4;
            int i14 = length + 1;
            bArr3[i11] = bArr2[((bArr[i14] & UByte.MAX_VALUE) >> 4) | i13];
            bArr3[i12] = bArr2[(bArr[i14] & ek.m) << 2];
            bArr3[i12 + 1] = 61;
        }
        try {
            return new String(bArr3, b.i);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}

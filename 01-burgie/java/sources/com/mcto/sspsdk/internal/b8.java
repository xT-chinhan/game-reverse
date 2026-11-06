package com.mcto.sspsdk.internal;

import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b8 {
    public static boolean a(byte[] bArr, int i) {
        int i2;
        int i3;
        if (i >= 21 && bArr[0] == 82 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 70 && bArr[8] == 87 && bArr[9] == 69 && bArr[10] == 66 && bArr[11] == 80) {
            int iMin = Math.min(i, 512);
            int i4 = 12;
            while (true) {
                int i5 = i4 + 8;
                if (i5 > iMin) {
                    break;
                }
                int i6 = bArr[i4] & UByte.MAX_VALUE;
                int i7 = bArr[i4 + 1] & UByte.MAX_VALUE;
                int i8 = bArr[i4 + 2] & UByte.MAX_VALUE;
                int i9 = bArr[i4 + 3] & UByte.MAX_VALUE;
                if (i6 == 65 && i7 == 78 && i8 == 73 && i9 == 77) {
                    return true;
                }
                if (i6 == 86 && i7 == 80 && i8 == 56 && i9 == 88 && (i3 = (bArr[i4 + 4] & UByte.MAX_VALUE) | ((bArr[i4 + 5] & UByte.MAX_VALUE) << 8) | ((bArr[i4 + 6] & UByte.MAX_VALUE) << 16) | ((bArr[i4 + 7] & UByte.MAX_VALUE) << 24)) >= 1 && i3 + i5 <= iMin) {
                    return (bArr[i5] & 2) != 0;
                }
                int i10 = (bArr[i4 + 4] & UByte.MAX_VALUE) | ((bArr[i4 + 5] & UByte.MAX_VALUE) << 8) | ((bArr[i4 + 6] & UByte.MAX_VALUE) << 16) | ((bArr[i4 + 7] & UByte.MAX_VALUE) << 24);
                if (i10 < 0 || (i2 = i10 + 8 + (i10 & 1)) <= 0) {
                    return false;
                }
                i4 += i2;
            }
        }
        return false;
    }

    public static boolean b(byte[] bArr, int i) {
        byte b;
        return i >= 6 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 56 && ((b = bArr[4]) == 55 || b == 57) && bArr[5] == 97;
    }
}

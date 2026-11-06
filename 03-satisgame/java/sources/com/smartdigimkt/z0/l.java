package com.smartdigimkt.z0;

import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public byte[] a;
    public int b;
    public int c;
    public int d;

    public l() {
    }

    public final int a(int i) {
        int i2;
        int i3;
        if (i == 0) {
            return 0;
        }
        this.c += i;
        int i4 = 0;
        while (true) {
            i2 = this.c;
            if (i2 <= 8) {
                break;
            }
            int i5 = i2 - 8;
            this.c = i5;
            byte[] bArr = this.a;
            int i6 = this.b;
            this.b = i6 + 1;
            i4 |= (bArr[i6] & UByte.MAX_VALUE) << i5;
        }
        byte[] bArr2 = this.a;
        int i7 = this.b;
        int i8 = ((-1) >>> (32 - i)) & (i4 | ((bArr2[i7] & UByte.MAX_VALUE) >> (8 - i2)));
        if (i2 == 8) {
            this.c = 0;
            this.b = i7 + 1;
        }
        int i9 = this.b;
        if (i9 < 0 || (i9 >= (i3 = this.d) && !(i9 == i3 && this.c == 0))) {
            throw new IllegalStateException();
        }
        return i8;
    }

    public l(byte[] bArr) {
        int length = bArr.length;
        this.a = bArr;
        this.d = length;
    }
}

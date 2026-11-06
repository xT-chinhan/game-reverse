package com.smartdigimkt.z0;

import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public final byte[] a;
    public final int b;
    public int c;
    public int d = 0;

    public n(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.c = i;
        this.b = i2;
        a();
    }

    public final int a(int i) {
        int i2;
        this.d += i;
        int i3 = 0;
        while (true) {
            i2 = this.d;
            int i4 = 2;
            if (i2 <= 8) {
                break;
            }
            int i5 = i2 - 8;
            this.d = i5;
            byte[] bArr = this.a;
            int i6 = this.c;
            i3 |= (bArr[i6] & UByte.MAX_VALUE) << i5;
            if (!b(i6 + 1)) {
                i4 = 1;
            }
            this.c = i6 + i4;
        }
        byte[] bArr2 = this.a;
        int i7 = this.c;
        int i8 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i7] & UByte.MAX_VALUE) >> (8 - i2)));
        if (i2 == 8) {
            this.d = 0;
            this.c = i7 + (b(i7 + 1) ? 2 : 1);
        }
        a();
        return i8;
    }

    public final boolean b() {
        boolean z = (this.a[this.c] & (128 >> this.d)) != 0;
        d();
        return z;
    }

    public final void c(int i) {
        int i2 = this.c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        this.c = i4;
        int i5 = (i - (i3 * 8)) + this.d;
        this.d = i5;
        if (i5 > 7) {
            this.c = i4 + 1;
            this.d = i5 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.c) {
                a();
                return;
            } else if (b(i2)) {
                this.c++;
                i2 += 2;
            }
        }
    }

    public final void d() {
        int i = this.d + 1;
        this.d = i;
        if (i == 8) {
            this.d = 0;
            int i2 = this.c;
            this.c = i2 + (b(i2 + 1) ? 2 : 1);
        }
        a();
    }

    public final boolean b(int i) {
        if (2 <= i && i < this.b) {
            byte[] bArr = this.a;
            if (bArr[i] == 3 && bArr[i - 2] == 0 && bArr[i - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public final void a() {
        int i = this.c;
        if (i >= 0) {
            int i2 = this.b;
            if (i < i2) {
                return;
            }
            if (i == i2 && this.d == 0) {
                return;
            }
        }
        throw new IllegalStateException();
    }

    public final int c() {
        int i = 0;
        while (!b()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? a(i) : 0);
    }
}

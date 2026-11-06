package com.smartdigimkt.z0;

import java.nio.charset.Charset;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends b {
    public int b;
    public int c;

    public m() {
    }

    public final void a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.a, this.b, bArr, i, i2);
        this.b += i2;
    }

    public final void b(int i) {
        byte[] bArr = this.a;
        if ((bArr == null ? 0 : bArr.length) < i) {
            bArr = new byte[i];
        }
        this.a = bArr;
        this.c = i;
        this.b = 0;
    }

    public final String c() {
        int i = this.c;
        int i2 = this.b;
        if (i - i2 == 0) {
            return null;
        }
        while (i2 < this.c && this.a[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.a;
        int i3 = this.b;
        String strA = u.a(bArr, i3, i2 - i3);
        this.b = i2;
        if (i2 < this.c) {
            this.b = i2 + 1;
        }
        return strA;
    }

    public final String d() {
        String str = new String(this.a, this.b, 4, Charset.forName("UTF-8"));
        this.b += 4;
        return str;
    }

    public final int e() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & UByte.MAX_VALUE;
    }

    public final long f() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 3;
        long j = ((((long) bArr[i]) & 255) << 24) | ((((long) bArr[i + 1]) & 255) << 16) | ((((long) bArr[i + 2]) & 255) << 8);
        this.b = i + 4;
        return (((long) bArr[i2]) & 255) | j;
    }

    public final int g() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 2;
        int i3 = ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i] & UByte.MAX_VALUE) << 16);
        this.b = i + 3;
        return (bArr[i2] & UByte.MAX_VALUE) | i3;
    }

    public final int h() {
        int iA = a();
        if (iA >= 0) {
            return iA;
        }
        throw new IllegalStateException("Top bit not zero: " + iA);
    }

    public final long i() {
        long jB = b();
        if (jB >= 0) {
            return jB;
        }
        throw new IllegalStateException("Top bit not zero: " + jB);
    }

    public final int j() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i] & UByte.MAX_VALUE) << 8;
        this.b = i + 2;
        return (bArr[i2] & UByte.MAX_VALUE) | i3;
    }

    public m(int i) {
        this.a = new byte[i];
        this.c = i;
    }

    public final int a() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = ((bArr[i + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i] & UByte.MAX_VALUE) << 24);
        int i3 = i + 3;
        int i4 = i2 | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
        this.b = i + 4;
        return (bArr[i3] & UByte.MAX_VALUE) | i4;
    }

    public m(byte[] bArr) {
        this.a = bArr;
        this.c = bArr.length;
    }

    public final long b() {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 7;
        long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
        this.b = i + 8;
        return (((long) bArr[i2]) & 255) | j;
    }

    public final String a(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.b;
        int i3 = (i2 + i) - 1;
        String strA = u.a(this.a, i2, (i3 >= this.c || this.a[i3] != 0) ? i : i - 1);
        this.b += i;
        return strA;
    }

    public m(int i, byte[] bArr) {
        this.a = bArr;
        this.c = i;
    }

    public final void c(int i) {
        if (i >= 0 && i <= this.c) {
            this.b = i;
            return;
        }
        throw new IllegalArgumentException();
    }
}

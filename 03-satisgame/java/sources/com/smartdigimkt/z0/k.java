package com.smartdigimkt.z0;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {
    public static final byte[] a = {0, 0, 0, 1};
    public static final float[] b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final Object c = new Object();
    public static int[] d = new int[10];

    public static int a(int i, byte[] bArr) {
        int i2;
        synchronized (c) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    if (i3 >= i - 2) {
                        i3 = i;
                        break;
                    }
                    try {
                        if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                            break;
                        }
                        i3++;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i3 < i) {
                    int[] iArr = d;
                    if (iArr.length <= i4) {
                        d = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    d[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = d[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i9 + 2;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }

    /* JADX WARN: Code duplicated, block: B:90:0x0138  */
    public static j a(byte[] bArr, int i, int i2) {
        int iC;
        float f;
        n nVar = new n(bArr, i, i2);
        nVar.c(8);
        int iA = nVar.a(8);
        nVar.c(16);
        nVar.c();
        int i3 = 1;
        if (iA == 100 || iA == 110 || iA == 122 || iA == 244 || iA == 44 || iA == 83 || iA == 86 || iA == 118 || iA == 128 || iA == 138) {
            iC = nVar.c();
            if (iC == 3) {
                nVar.b();
            }
            nVar.c();
            nVar.c();
            nVar.d();
            if (nVar.b()) {
                int i4 = iC != 3 ? 8 : 12;
                int i5 = 0;
                while (i5 < i4) {
                    if (nVar.b()) {
                        int i6 = i5 < 6 ? 16 : 64;
                        int i7 = 8;
                        int i8 = 8;
                        for (int i9 = 0; i9 < i6; i9++) {
                            if (i7 != 0) {
                                int iC2 = nVar.c();
                                i7 = (((((iC2 + 1) / 2) * (iC2 % 2 == 0 ? -1 : 1)) + i8) + 256) % 256;
                            }
                            if (i7 != 0) {
                                i8 = i7;
                            }
                        }
                    }
                    i5++;
                }
            }
        } else {
            iC = 1;
        }
        nVar.c();
        int iC3 = nVar.c();
        if (iC3 == 0) {
            nVar.c();
        } else if (iC3 == 1) {
            nVar.b();
            nVar.c();
            nVar.c();
            long jC = nVar.c();
            for (int i10 = 0; i10 < jC; i10++) {
                nVar.c();
            }
        }
        nVar.c();
        nVar.d();
        int iC4 = nVar.c() + 1;
        int iC5 = nVar.c() + 1;
        boolean zB = nVar.b();
        int i11 = 2 - (zB ? 1 : 0);
        int i12 = iC5 * i11;
        if (!zB) {
            nVar.d();
        }
        nVar.d();
        int i13 = iC4 * 16;
        int i14 = i12 * 16;
        if (nVar.b()) {
            int iC6 = nVar.c();
            int iC7 = nVar.c();
            int iC8 = nVar.c();
            int iC9 = nVar.c();
            if (iC != 0) {
                int i15 = iC == 3 ? 1 : 2;
                i11 *= iC != 1 ? 1 : 2;
                i3 = i15;
            }
            i13 -= (iC6 + iC7) * i3;
            i14 -= (iC8 + iC9) * i11;
        }
        if (nVar.b() && nVar.b()) {
            int iA2 = nVar.a(8);
            if (iA2 == 255) {
                int iA3 = nVar.a(16);
                int iA4 = nVar.a(16);
                if (iA3 == 0 || iA4 == 0) {
                    f = 1.0f;
                } else {
                    f = iA3 / iA4;
                }
            } else {
                float[] fArr = b;
                if (iA2 < 17) {
                    f = fArr[iA2];
                } else {
                    f = 1.0f;
                }
            }
        } else {
            f = 1.0f;
        }
        return new j(i13, i14, f);
    }
}

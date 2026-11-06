package com.anythink.basead.exoplayer.k;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class p {
    public static final int b = 255;
    private static final String d = "NalUnitUtil";
    private static final int e = 6;
    private static final int f = 7;
    private static final int g = 39;
    public static final byte[] a = {0, 0, 0, 1};
    public static final float[] c = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object h = new Object();
    private static int[] i = new int[10];

    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final float d;
        public final boolean e;
        public final boolean f;
        public final int g;
        public final int h;
        public final int i;
        public final boolean j;

        public b(int i, int i2, int i3, float f, boolean z, boolean z2, int i4, int i5, int i6, boolean z3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = f;
            this.e = z;
            this.f = z2;
            this.g = i4;
            this.h = i5;
            this.i = i6;
            this.j = z3;
        }
    }

    public static final class a {
        public final int a;
        public final int b;
        public final boolean c;

        public a(int i, int i2, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = z;
        }
    }

    public static int a(byte[] bArr, int i2) {
        int i3;
        synchronized (h) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2) {
                while (true) {
                    if (i4 >= i2 - 2) {
                        i4 = i2;
                        break;
                    }
                    if (bArr[i4] == 0 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 3) {
                        break;
                    }
                    i4++;
                }
                if (i4 < i2) {
                    int[] iArr = i;
                    if (iArr.length <= i5) {
                        i = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    i[i5] = i4;
                    i4 += 3;
                    i5++;
                }
            }
            i3 = i2 - i5;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = i[i8] - i7;
                System.arraycopy(bArr, i7, bArr, i6, i9);
                int i10 = i6 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i6 = i11 + 1;
                bArr[i11] = 0;
                i7 += i9 + 3;
            }
            System.arraycopy(bArr, i7, bArr, i6, i3 - i6);
        }
        return i3;
    }

    public static void a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (i4 < iPosition) {
                int i5 = byteBuffer.get(i2) & UByte.MAX_VALUE;
                if (i3 == 3) {
                    if (i5 == 1 && (byteBuffer.get(i4) & 31) == 7) {
                        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                        byteBufferDuplicate.position(i2 - 3);
                        byteBufferDuplicate.limit(iPosition);
                        byteBuffer.position(0);
                        byteBuffer.put(byteBufferDuplicate);
                        return;
                    }
                } else if (i5 == 0) {
                    i3++;
                }
                if (i5 != 0) {
                    i3 = 0;
                }
                i2 = i4;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static boolean a(String str, byte b2) {
        return (o.h.equals(str) && (b2 & 31) == 6) || (o.i.equals(str) && ((b2 & 126) >> 1) == 39);
    }

    private static int b(byte[] bArr, int i2) {
        return bArr[i2 + 3] & 31;
    }

    private static int c(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 126) >> 1;
    }

    /* JADX WARN: Code duplicated, block: B:64:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:67:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:69:0x010c  */
    /* JADX WARN: Code duplicated, block: B:70:0x010f  */
    /* JADX WARN: Code duplicated, block: B:72:0x0113  */
    /* JADX WARN: Code duplicated, block: B:73:0x0115  */
    /* JADX WARN: Code duplicated, block: B:75:0x0119  */
    /* JADX WARN: Code duplicated, block: B:92:0x0169 A[PHI: r4
      0x0169: PHI (r4v11 float) = (r4v10 float), (r4v10 float), (r4v10 float), (r4v10 float), (r4v10 float), (r4v13 float) binds: [B:79:0x0130, B:81:0x0136, B:91:0x015a, B:85:0x0148, B:86:0x014a, B:87:0x014c] A[DONT_GENERATE, DONT_INLINE]] */
    public static b a(byte[] bArr, int i2, int i3) {
        int iC;
        boolean z;
        int iC2;
        boolean z2;
        boolean zB;
        int i4;
        int i5;
        float f2;
        float f3;
        int i6;
        int i7;
        t tVar = new t(bArr, i2, i3);
        tVar.a(8);
        int iB = tVar.b(8);
        tVar.a(16);
        int iC3 = tVar.c();
        int i8 = 1;
        if (iB == 100 || iB == 110 || iB == 122 || iB == 244 || iB == 44 || iB == 83 || iB == 86 || iB == 118 || iB == 128 || iB == 138) {
            iC = tVar.c();
            boolean zB2 = iC == 3 ? tVar.b() : false;
            tVar.c();
            tVar.c();
            tVar.a();
            if (tVar.b()) {
                int i9 = iC != 3 ? 8 : 12;
                int i10 = 0;
                while (i10 < i9) {
                    if (tVar.b()) {
                        int i11 = i10 < 6 ? 16 : 64;
                        int iD = 8;
                        int i12 = 8;
                        for (int i13 = 0; i13 < i11; i13++) {
                            if (iD != 0) {
                                iD = ((tVar.d() + i12) + 256) % 256;
                            }
                            if (iD != 0) {
                                i12 = iD;
                            }
                        }
                    }
                    i10++;
                }
            }
            z = zB2;
        } else {
            iC = 1;
            z = false;
        }
        int iC4 = tVar.c() + 4;
        int iC5 = tVar.c();
        if (iC5 == 0) {
            iC2 = tVar.c() + 4;
        } else {
            if (iC5 == 1) {
                boolean zB3 = tVar.b();
                tVar.d();
                tVar.d();
                long jC = tVar.c();
                z = z;
                for (int i14 = 0; i14 < jC; i14++) {
                    tVar.c();
                }
                z2 = zB3;
                iC2 = 0;
            } else {
                iC2 = 0;
            }
            tVar.c();
            tVar.a();
            int iC6 = tVar.c() + 1;
            int iC7 = tVar.c() + 1;
            zB = tVar.b();
            int i15 = (2 - (zB ? 1 : 0)) * iC7;
            if (!zB) {
                tVar.a();
            }
            tVar.a();
            i4 = iC6 * 16;
            i5 = i15 * 16;
            if (tVar.b()) {
                int iC8 = tVar.c();
                int iC9 = tVar.c();
                int iC10 = tVar.c();
                int iC11 = tVar.c();
                if (iC == 0) {
                    i7 = 2 - (zB ? 1 : 0);
                } else {
                    if (iC == 3) {
                        i6 = 1;
                    } else {
                        i6 = 2;
                    }
                    i7 = (2 - (zB ? 1 : 0)) * (iC == 1 ? 2 : 1);
                    i8 = i6;
                }
                i4 -= (iC8 + iC9) * i8;
                i5 -= (iC10 + iC11) * i7;
            }
            int i16 = i4;
            int i17 = i5;
            f2 = 1.0f;
            if (tVar.b() || !tVar.b()) {
                f3 = f2;
            } else {
                int iB2 = tVar.b(8);
                if (iB2 == 255) {
                    int iB3 = tVar.b(16);
                    int iB4 = tVar.b(16);
                    if (iB3 != 0 && iB4 != 0) {
                        f2 = iB3 / iB4;
                    }
                } else {
                    float[] fArr = c;
                    if (iB2 < fArr.length) {
                        f3 = fArr[iB2];
                    } else {
                        Log.w(d, "Unexpected aspect_ratio_idc value: ".concat(String.valueOf(iB2)));
                    }
                }
                f3 = f2;
            }
            return new b(iC3, i16, i17, f3, z, zB, iC4, iC5, iC2, z2);
        }
        z2 = false;
        tVar.c();
        tVar.a();
        int iC12 = tVar.c() + 1;
        int iC13 = tVar.c() + 1;
        zB = tVar.b();
        int i18 = (2 - (zB ? 1 : 0)) * iC13;
        if (!zB) {
            tVar.a();
        }
        tVar.a();
        i4 = iC12 * 16;
        i5 = i18 * 16;
        if (tVar.b()) {
            int iC14 = tVar.c();
            int iC15 = tVar.c();
            int iC16 = tVar.c();
            int iC17 = tVar.c();
            if (iC == 0) {
                i7 = 2 - (zB ? 1 : 0);
            } else {
                if (iC == 3) {
                    i6 = 1;
                } else {
                    i6 = 2;
                }
                i7 = (2 - (zB ? 1 : 0)) * (iC == 1 ? 2 : 1);
                i8 = i6;
            }
            i4 -= (iC14 + iC15) * i8;
            i5 -= (iC16 + iC17) * i7;
        }
        int i19 = i4;
        int i110 = i5;
        f2 = 1.0f;
        if (tVar.b()) {
            f3 = f2;
        } else {
            f3 = f2;
        }
        return new b(iC3, i19, i110, f3, z, zB, iC4, iC5, iC2, z2);
    }

    private static a b(byte[] bArr, int i2, int i3) {
        t tVar = new t(bArr, i2, i3);
        tVar.a(8);
        int iC = tVar.c();
        int iC2 = tVar.c();
        tVar.a();
        return new a(iC, iC2, tVar.b());
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0094, code lost:
    
        r9 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(byte[] r8, int r9, int r10, boolean[] r11) {
        /*
            int r0 = r10 - r9
            r1 = 0
            r2 = 1
            if (r0 < 0) goto L8
            r3 = r2
            goto L9
        L8:
            r3 = r1
        L9:
            com.anythink.basead.exoplayer.k.a.b(r3)
            if (r0 != 0) goto Lf
            return r10
        Lf:
            r3 = 2
            if (r11 == 0) goto L40
            boolean r4 = r11[r1]
            if (r4 == 0) goto L1c
            a(r11)
            int r9 = r9 + (-3)
            return r9
        L1c:
            if (r0 <= r2) goto L2b
            boolean r4 = r11[r2]
            if (r4 == 0) goto L2b
            r4 = r8[r9]
            if (r4 != r2) goto L2b
            a(r11)
            int r9 = r9 - r3
            return r9
        L2b:
            if (r0 <= r3) goto L40
            boolean r4 = r11[r3]
            if (r4 == 0) goto L40
            r4 = r8[r9]
            if (r4 != 0) goto L40
            int r4 = r9 + 1
            r4 = r8[r4]
            if (r4 != r2) goto L40
            a(r11)
            int r9 = r9 - r2
            return r9
        L40:
            int r4 = r10 + (-1)
            int r9 = r9 + r3
        L43:
            if (r9 >= r4) goto L64
            r5 = r8[r9]
            r6 = r5 & 254(0xfe, float:3.56E-43)
            if (r6 != 0) goto L61
            int r6 = r9 + (-2)
            r7 = r8[r6]
            if (r7 != 0) goto L5f
            int r7 = r9 + (-1)
            r7 = r8[r7]
            if (r7 != 0) goto L5f
            if (r5 != r2) goto L5f
            if (r11 == 0) goto L5e
            a(r11)
        L5e:
            return r6
        L5f:
            int r9 = r9 + (-2)
        L61:
            int r9 = r9 + 3
            goto L43
        L64:
            if (r11 == 0) goto Lb8
            if (r0 <= r3) goto L7b
            int r9 = r10 + (-3)
            r9 = r8[r9]
            if (r9 != 0) goto L79
            int r9 = r10 + (-2)
            r9 = r8[r9]
            if (r9 != 0) goto L79
            r9 = r8[r4]
            if (r9 != r2) goto L79
            goto L94
        L79:
            r9 = r1
            goto L95
        L7b:
            if (r0 != r3) goto L8c
            boolean r9 = r11[r3]
            if (r9 == 0) goto L79
            int r9 = r10 + (-2)
            r9 = r8[r9]
            if (r9 != 0) goto L79
            r9 = r8[r4]
            if (r9 != r2) goto L79
            goto L94
        L8c:
            boolean r9 = r11[r2]
            if (r9 == 0) goto L79
            r9 = r8[r4]
            if (r9 != r2) goto L79
        L94:
            r9 = r2
        L95:
            r11[r1] = r9
            if (r0 <= r2) goto La4
            int r9 = r10 + (-2)
            r9 = r8[r9]
            if (r9 != 0) goto Lae
            r9 = r8[r4]
            if (r9 != 0) goto Lae
            goto Lac
        La4:
            boolean r9 = r11[r3]
            if (r9 == 0) goto Lae
            r9 = r8[r4]
            if (r9 != 0) goto Lae
        Lac:
            r9 = r2
            goto Laf
        Lae:
            r9 = r1
        Laf:
            r11[r2] = r9
            r8 = r8[r4]
            if (r8 != 0) goto Lb6
            r1 = r2
        Lb6:
            r11[r3] = r1
        Lb8:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.exoplayer.k.p.a(byte[], int, int, boolean[]):int");
    }

    private static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    private static int c(byte[] bArr, int i2, int i3) {
        while (i2 < i3 - 2) {
            if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 3) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    private static void a(t tVar, int i2) {
        int iD = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i2; i4++) {
            if (iD != 0) {
                iD = ((tVar.d() + i3) + 256) % 256;
            }
            if (iD != 0) {
                i3 = iD;
            }
        }
    }

    private p() {
    }
}

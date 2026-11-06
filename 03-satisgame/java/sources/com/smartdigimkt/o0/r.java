package com.smartdigimkt.o0;

import java.io.EOFException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class r {
    public static final int[] a = {com.smartdigimkt.z0.u.a("isom"), com.smartdigimkt.z0.u.a("iso2"), com.smartdigimkt.z0.u.a("iso3"), com.smartdigimkt.z0.u.a("iso4"), com.smartdigimkt.z0.u.a("iso5"), com.smartdigimkt.z0.u.a("iso6"), com.smartdigimkt.z0.u.a("avc1"), com.smartdigimkt.z0.u.a("hvc1"), com.smartdigimkt.z0.u.a("hev1"), com.smartdigimkt.z0.u.a("mp41"), com.smartdigimkt.z0.u.a("mp42"), com.smartdigimkt.z0.u.a("3g2a"), com.smartdigimkt.z0.u.a("3g2b"), com.smartdigimkt.z0.u.a("3gr6"), com.smartdigimkt.z0.u.a("3gs6"), com.smartdigimkt.z0.u.a("3ge6"), com.smartdigimkt.z0.u.a("3gg6"), com.smartdigimkt.z0.u.a("M4V "), com.smartdigimkt.z0.u.a("M4A "), com.smartdigimkt.z0.u.a("f4v "), com.smartdigimkt.z0.u.a("kddi"), com.smartdigimkt.z0.u.a("M4VP"), com.smartdigimkt.z0.u.a("qt  "), com.smartdigimkt.z0.u.a("MSNV")};

    public static boolean a(com.smartdigimkt.n0.c cVar, boolean z) throws InterruptedException, EOFException {
        boolean z2;
        boolean z3;
        int i;
        long j = cVar.c;
        long j2 = -1;
        if (j == -1 || j > com.anythink.china.a.c.m) {
            j = 4096;
        }
        int i2 = (int) j;
        com.smartdigimkt.z0.m mVar = new com.smartdigimkt.z0.m(64);
        int i3 = 0;
        boolean z4 = false;
        while (true) {
            if (i3 < i2) {
                mVar.b(8);
                byte[] bArr = mVar.a;
                if (cVar.a(8)) {
                    System.arraycopy(cVar.e, cVar.f - 8, bArr, 0, 8);
                }
                long jF = mVar.f();
                int iA = mVar.a();
                if (jF == 1) {
                    byte[] bArr2 = mVar.a;
                    if (cVar.a(8)) {
                        System.arraycopy(cVar.e, cVar.f - 8, bArr2, 8, 8);
                    }
                    if (16 > mVar.a.length) {
                        throw new IllegalArgumentException();
                    }
                    mVar.c = 16;
                    i = 16;
                    jF = mVar.i();
                } else {
                    if (jF == 0) {
                        long j3 = cVar.c;
                        if (j3 != j2) {
                            jF = ((long) 8) + (j3 - cVar.d);
                        }
                    }
                    i = 8;
                }
                long j4 = i;
                if (jF < j4) {
                    return false;
                }
                i3 += i;
                if (iA != c.C) {
                    if (iA == c.L || iA == c.N) {
                        z2 = true;
                        z3 = true;
                        if (!z4 && z == z3) {
                            return z2;
                        }
                    }
                    if ((((long) i3) + jF) - j4 < i2) {
                        int i4 = (int) (jF - j4);
                        i3 += i4;
                        if (iA == c.b) {
                            if (i4 < 8) {
                                return false;
                            }
                            mVar.b(i4);
                            byte[] bArr3 = mVar.a;
                            if (cVar.a(i4)) {
                                System.arraycopy(cVar.e, cVar.f - i4, bArr3, 0, i4);
                            }
                            int i5 = i4 / 4;
                            for (int i6 = 0; i6 < i5; i6++) {
                                if (i6 != 1) {
                                    int iA2 = mVar.a();
                                    if ((iA2 >>> 8) != com.smartdigimkt.z0.u.a("3gp")) {
                                        int[] iArr = a;
                                        int length = iArr.length;
                                        int i7 = 0;
                                        while (true) {
                                            if (i7 >= length) {
                                                continue;
                                            } else if (iArr[i7] != iA2) {
                                                i7++;
                                            }
                                        }
                                    }
                                    z4 = true;
                                    break;
                                }
                                mVar.c(mVar.b + 4);
                            }
                            if (!z4) {
                                return false;
                            }
                        } else if (i4 != 0) {
                            cVar.a(i4);
                        }
                        j2 = -1;
                    }
                }
            }
            z2 = true;
            z3 = false;
            return !z4 ? false : false;
        }
    }
}

package com.smartdigimkt.s0;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements com.smartdigimkt.q0.d {
    public static final int a = com.smartdigimkt.z0.u.a("ID3");

    public static int a(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public static h b(com.smartdigimkt.z0.m mVar, int i, int i2, boolean z, int i3) {
        int i4 = mVar.b;
        int iA = a(i4, mVar.a);
        String str = new String(mVar.a, i4, iA - i4, "ISO-8859-1");
        mVar.c(iA + 1);
        int iE = mVar.e();
        boolean z2 = (iE & 2) != 0;
        boolean z3 = (iE & 1) != 0;
        int iE2 = mVar.e();
        String[] strArr = new String[iE2];
        for (int i5 = 0; i5 < iE2; i5++) {
            int i6 = mVar.b;
            int iA2 = a(i6, mVar.a);
            strArr[i5] = new String(mVar.a, i6, iA2 - i6, "ISO-8859-1");
            mVar.c(iA2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i7 = i4 + i;
        while (mVar.b < i7) {
            o oVarA = a(i2, i3, mVar, z);
            if (oVarA != null) {
                arrayList.add(oVarA);
            }
        }
        o[] oVarArr = new o[arrayList.size()];
        arrayList.toArray(oVarArr);
        return new h(str, z2, z3, strArr, oVarArr);
    }

    public static String b(int i) {
        if (i == 1) {
            return "UTF-16";
        }
        if (i != 2) {
            return i != 3 ? "ISO-8859-1" : "UTF-8";
        }
        return "UTF-16BE";
    }

    public static s c(int i, com.smartdigimkt.z0.m mVar) {
        byte[] bArr = new byte[i];
        mVar.a(bArr, 0, i);
        int iA = a(0, bArr);
        String str = new String(bArr, 0, iA, "ISO-8859-1");
        int i2 = iA + 1;
        return new s(str, i <= i2 ? new byte[0] : Arrays.copyOfRange(bArr, i2, i));
    }

    public static u d(int i, com.smartdigimkt.z0.m mVar) {
        if (i < 1) {
            return null;
        }
        int iE = mVar.e();
        String strB = b(iE);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        mVar.a(bArr, 0, i2);
        int iA = a(bArr, 0, iE);
        String str = new String(bArr, 0, iA, strB);
        int iA2 = a(iE) + iA;
        return new u("TXXX", str, a(bArr, iA2, a(bArr, iA2, iE), strB));
    }

    public static w e(int i, com.smartdigimkt.z0.m mVar) {
        if (i < 1) {
            return null;
        }
        int iE = mVar.e();
        String strB = b(iE);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        mVar.a(bArr, 0, i2);
        int iA = a(bArr, 0, iE);
        String str = new String(bArr, 0, iA, strB);
        int iA2 = a(iE) + iA;
        return new w("WXXX", str, a(bArr, iA2, a(iA2, bArr), "ISO-8859-1"));
    }

    public static int f(int i, com.smartdigimkt.z0.m mVar) {
        byte[] bArr = mVar.a;
        int i2 = mVar.b;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= i) {
                return i;
            }
            if ((bArr[i2] & UByte.MAX_VALUE) == 255 && bArr[i3] == 0) {
                System.arraycopy(bArr, i2 + 2, bArr, i3, (i - i2) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:31:0x00ab  */
    @Override // com.smartdigimkt.q0.d
    public final com.smartdigimkt.q0.c a(com.smartdigimkt.q0.f fVar) {
        m mVar;
        boolean z;
        ByteBuffer byteBuffer = fVar.b;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        ArrayList arrayList = new ArrayList();
        com.smartdigimkt.z0.m mVar2 = new com.smartdigimkt.z0.m(iLimit, bArrArray);
        boolean z2 = false;
        if (iLimit - mVar2.b >= 10 && mVar2.g() == a) {
            int iE = mVar2.e();
            mVar2.c(mVar2.b + 1);
            int iE2 = mVar2.e();
            int iE3 = (mVar2.e() << 21) | (mVar2.e() << 14) | (mVar2.e() << 7) | mVar2.e();
            if (iE != 2) {
                if (iE == 3) {
                    if ((iE2 & 64) != 0) {
                        int iA = mVar2.a();
                        mVar2.c(mVar2.b + iA);
                        iE3 -= iA + 4;
                    }
                } else if (iE == 4) {
                    if ((iE2 & 64) != 0) {
                        int iE4 = (mVar2.e() << 21) | (mVar2.e() << 14) | (mVar2.e() << 7) | mVar2.e();
                        mVar2.c(mVar2.b + (iE4 - 4));
                        iE3 -= iE4;
                    }
                    if ((iE2 & 16) != 0) {
                        iE3 -= 10;
                    }
                } else {
                    mVar = null;
                }
                if (iE < 4) {
                    z = false;
                } else {
                    z = false;
                }
                mVar = new m(iE, iE3, z);
            } else if ((iE2 & 64) != 0) {
                mVar = null;
            } else {
                if (iE < 4 || (iE2 & 128) == 0) {
                    z = false;
                } else {
                    z = true;
                }
                mVar = new m(iE, iE3, z);
            }
        } else {
            mVar = null;
        }
        if (mVar == null) {
            return null;
        }
        int i = mVar2.b;
        int i2 = mVar.a == 2 ? 6 : 10;
        int iF = mVar.c;
        if (mVar.b) {
            iF = f(iF, mVar2);
        }
        int i3 = i + iF;
        if (i3 < 0 || i3 > mVar2.a.length) {
            throw new IllegalArgumentException();
        }
        mVar2.c = i3;
        if (!b(mVar.a, i2, mVar2, false)) {
            if (mVar.a != 4 || !b(4, i2, mVar2, true)) {
                return null;
            }
            z2 = true;
        }
        while (mVar2.c - mVar2.b >= i2) {
            o oVarA = a(mVar.a, i2, mVar2, z2);
            if (oVarA != null) {
                arrayList.add(oVarA);
            }
        }
        return new com.smartdigimkt.q0.c(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0086 A[PHI: r3
      0x0086: PHI (r3v17 int) = (r3v6 int), (r3v20 int) binds: [B:39:0x0083, B:31:0x0075] A[DONT_GENERATE, DONT_INLINE]] */
    public static boolean b(int i, int i2, com.smartdigimkt.z0.m mVar, boolean z) {
        int iG;
        long jG;
        int iJ;
        int i3;
        int i4 = mVar.b;
        while (true) {
            try {
                boolean z2 = true;
                if (mVar.c - mVar.b < i2) {
                    mVar.c(i4);
                    return true;
                }
                if (i >= 3) {
                    iG = mVar.a();
                    jG = mVar.f();
                    iJ = mVar.j();
                } else {
                    iG = mVar.g();
                    jG = mVar.g();
                    iJ = 0;
                }
                if (iG == 0 && jG == 0 && iJ == 0) {
                    mVar.c(i4);
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & jG) != 0) {
                        mVar.c(i4);
                        return false;
                    }
                    jG = (((jG >> 24) & 255) << 21) | (jG & 255) | (((jG >> 8) & 255) << 7) | (((jG >> 16) & 255) << 14);
                }
                if (i == 4) {
                    i3 = (iJ & 64) != 0 ? 1 : 0;
                    if ((iJ & 1) == 0) {
                        z2 = false;
                    }
                } else if (i == 3) {
                    i3 = (iJ & 32) != 0 ? 1 : 0;
                    if ((iJ & 128) == 0) {
                        z2 = false;
                    }
                } else {
                    i3 = 0;
                    z2 = false;
                }
                if (z2) {
                    i3 += 4;
                }
                if (jG < i3) {
                    mVar.c(i4);
                    return false;
                }
                int i5 = mVar.c;
                int i6 = mVar.b;
                if (i5 - i6 < jG) {
                    mVar.c(i4);
                    return false;
                }
                mVar.c(i6 + ((int) jG));
            } catch (Throwable th) {
                mVar.c(i4);
                throw th;
            }
        }
    }

    public static f a(com.smartdigimkt.z0.m mVar, int i, int i2, boolean z, int i3) {
        int i4 = mVar.b;
        int iA = a(i4, mVar.a);
        String str = new String(mVar.a, i4, iA - i4, "ISO-8859-1");
        mVar.c(iA + 1);
        int iA2 = mVar.a();
        int iA3 = mVar.a();
        long jF = mVar.f();
        long j = jF == 4294967295L ? -1L : jF;
        long jF2 = mVar.f();
        long j2 = jF2 == 4294967295L ? -1L : jF2;
        ArrayList arrayList = new ArrayList();
        int i5 = i4 + i;
        while (mVar.b < i5) {
            o oVarA = a(i2, i3, mVar, z);
            if (oVarA != null) {
                arrayList.add(oVarA);
            }
        }
        o[] oVarArr = new o[arrayList.size()];
        arrayList.toArray(oVarArr);
        return new f(str, iA2, iA3, j, j2, oVarArr);
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0172  */
    /* JADX WARN: Code duplicated, block: B:132:0x0183 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:133:0x0185  */
    /* JADX WARN: Code duplicated, block: B:138:0x0192 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:139:0x0194  */
    /* JADX WARN: Code duplicated, block: B:144:0x01a1 A[Catch: all -> 0x010a, UnsupportedEncodingException -> 0x01be, TryCatch #2 {UnsupportedEncodingException -> 0x01be, all -> 0x010a, blocks: (B:83:0x00f8, B:146:0x01b3, B:85:0x0100, B:94:0x0119, B:96:0x0121, B:104:0x013b, B:113:0x0153, B:124:0x016d, B:131:0x017e, B:137:0x018d, B:143:0x019c, B:144:0x01a1), top: B:155:0x00ee }] */
    public static o a(int i, int i2, com.smartdigimkt.z0.m mVar, boolean z) {
        int iG;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        o dVar;
        int iE = mVar.e();
        int iE2 = mVar.e();
        int iE3 = mVar.e();
        int iE4 = i >= 3 ? mVar.e() : 0;
        if (i == 4) {
            iG = mVar.h();
            if (!z) {
                iG = (((iG >> 24) & 255) << 21) | (iG & 255) | (((iG >> 8) & 255) << 7) | (((iG >> 16) & 255) << 14);
            }
        } else if (i == 3) {
            iG = mVar.h();
        } else {
            iG = mVar.g();
        }
        int iJ = i >= 3 ? mVar.j() : 0;
        if (iE == 0 && iE2 == 0 && iE3 == 0 && iE4 == 0 && iG == 0 && iJ == 0) {
            mVar.c(mVar.c);
            return null;
        }
        int i3 = mVar.b;
        int i4 = i3 + iG;
        int i5 = mVar.c;
        if (i4 > i5) {
            mVar.c(i5);
            return null;
        }
        if (i == 3) {
            z2 = (iJ & 128) != 0;
            z5 = (iJ & 64) != 0;
            z6 = false;
            z4 = (iJ & 32) != 0;
            z3 = z2;
        } else if (i == 4) {
            boolean z7 = (iJ & 64) != 0;
            boolean z8 = (iJ & 8) != 0;
            z5 = (iJ & 4) != 0;
            z6 = (iJ & 2) != 0;
            z3 = (iJ & 1) != 0;
            boolean z9 = z8;
            z4 = z7;
            z2 = z9;
        } else {
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
        }
        if (!z2 && !z5) {
            if (z4) {
                iG--;
                mVar.c(i3 + 1);
            }
            if (z3) {
                iG -= 4;
                mVar.c(mVar.b + 4);
            }
            if (z6) {
                iG = f(iG, mVar);
            }
            try {
                if (iE == 84 && iE2 == 88 && iE3 == 88 && (i == 2 || iE4 == 88)) {
                    dVar = d(iG, mVar);
                } else if (iE == 84) {
                    dVar = a(iG, mVar, a(i, iE, iE2, iE3, iE4));
                } else if (iE == 87 && iE2 == 88 && iE3 == 88 && (i == 2 || iE4 == 88)) {
                    dVar = e(iG, mVar);
                } else if (iE == 87) {
                    dVar = b(iG, mVar, a(i, iE, iE2, iE3, iE4));
                } else if (iE == 80 && iE2 == 82 && iE3 == 73 && iE4 == 86) {
                    dVar = c(iG, mVar);
                } else if (iE == 71 && iE2 == 69 && iE3 == 79 && (iE4 == 66 || i == 2)) {
                    dVar = b(iG, mVar);
                } else if (i == 2) {
                    if (iE == 80 && iE2 == 73 && iE3 == 67) {
                        dVar = a(mVar, iG, i);
                    } else if (iE != 67 && iE2 == 79 && iE3 == 77 && (iE4 == 77 || i == 2)) {
                        dVar = a(iG, mVar);
                    } else if (iE != 67 && iE2 == 72 && iE3 == 65 && iE4 == 80) {
                        dVar = a(mVar, iG, i, z, i2);
                    } else if (iE != 67 && iE2 == 84 && iE3 == 79 && iE4 == 67) {
                        dVar = b(mVar, iG, i, z, i2);
                    } else {
                        String strA = a(i, iE, iE2, iE3, iE4);
                        byte[] bArr = new byte[iG];
                        mVar.a(bArr, 0, iG);
                        dVar = new d(strA, bArr);
                    }
                } else if (iE == 65 && iE2 == 80 && iE3 == 73 && iE4 == 67) {
                    dVar = a(mVar, iG, i);
                } else if (iE != 67) {
                    if (iE != 67) {
                        if (iE != 67) {
                            String strA2 = a(i, iE, iE2, iE3, iE4);
                            byte[] bArr2 = new byte[iG];
                            mVar.a(bArr2, 0, iG);
                            dVar = new d(strA2, bArr2);
                        } else {
                            String strA3 = a(i, iE, iE2, iE3, iE4);
                            byte[] bArr3 = new byte[iG];
                            mVar.a(bArr3, 0, iG);
                            dVar = new d(strA3, bArr3);
                        }
                    } else if (iE != 67) {
                        String strA4 = a(i, iE, iE2, iE3, iE4);
                        byte[] bArr4 = new byte[iG];
                        mVar.a(bArr4, 0, iG);
                        dVar = new d(strA4, bArr4);
                    } else {
                        String strA5 = a(i, iE, iE2, iE3, iE4);
                        byte[] bArr5 = new byte[iG];
                        mVar.a(bArr5, 0, iG);
                        dVar = new d(strA5, bArr5);
                    }
                } else if (iE != 67) {
                    if (iE != 67) {
                        String strA6 = a(i, iE, iE2, iE3, iE4);
                        byte[] bArr6 = new byte[iG];
                        mVar.a(bArr6, 0, iG);
                        dVar = new d(strA6, bArr6);
                    } else {
                        String strA7 = a(i, iE, iE2, iE3, iE4);
                        byte[] bArr7 = new byte[iG];
                        mVar.a(bArr7, 0, iG);
                        dVar = new d(strA7, bArr7);
                    }
                } else if (iE != 67) {
                    String strA8 = a(i, iE, iE2, iE3, iE4);
                    byte[] bArr8 = new byte[iG];
                    mVar.a(bArr8, 0, iG);
                    dVar = new d(strA8, bArr8);
                } else {
                    String strA9 = a(i, iE, iE2, iE3, iE4);
                    byte[] bArr9 = new byte[iG];
                    mVar.a(bArr9, 0, iG);
                    dVar = new d(strA9, bArr9);
                }
                if (dVar == null) {
                    a(i, iE, iE2, iE3, iE4);
                }
                mVar.c(i4);
                return dVar;
            } catch (UnsupportedEncodingException unused) {
                return null;
            } finally {
                mVar.c(i4);
            }
        }
        mVar.c(i4);
        return null;
    }

    public static w b(int i, com.smartdigimkt.z0.m mVar, String str) {
        byte[] bArr = new byte[i];
        mVar.a(bArr, 0, i);
        return new w(str, null, new String(bArr, 0, a(0, bArr), "ISO-8859-1"));
    }

    public static l b(int i, com.smartdigimkt.z0.m mVar) {
        int iE = mVar.e();
        String strB = b(iE);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        mVar.a(bArr, 0, i2);
        int iA = a(0, bArr);
        String str = new String(bArr, 0, iA, "ISO-8859-1");
        int i3 = iA + 1;
        int iA2 = a(bArr, i3, iE);
        String strA = a(bArr, i3, iA2, strB);
        int iA3 = a(iE) + iA2;
        int iA4 = a(bArr, iA3, iE);
        String strA2 = a(bArr, iA3, iA4, strB);
        int iA5 = a(iE) + iA4;
        return new l(str, strA, strA2, i2 <= iA5 ? new byte[0] : Arrays.copyOfRange(bArr, iA5, i2));
    }

    public static u a(int i, com.smartdigimkt.z0.m mVar, String str) {
        if (i < 1) {
            return null;
        }
        int iE = mVar.e();
        String strB = b(iE);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        mVar.a(bArr, 0, i2);
        return new u(str, null, new String(bArr, 0, a(bArr, 0, iE), strB));
    }

    public static b a(com.smartdigimkt.z0.m mVar, int i, int i2) {
        int iA;
        String strConcat;
        int iE = mVar.e();
        String strB = b(iE);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        mVar.a(bArr, 0, i3);
        if (i2 == 2) {
            strConcat = "image/" + new String(bArr, 0, 3, "ISO-8859-1").toLowerCase(Locale.US);
            if ("image/jpg".equals(strConcat)) {
                strConcat = "image/jpeg";
            }
            iA = 2;
        } else {
            iA = a(0, bArr);
            String lowerCase = new String(bArr, 0, iA, "ISO-8859-1").toLowerCase(Locale.US);
            strConcat = lowerCase.indexOf(47) == -1 ? "image/".concat(lowerCase) : lowerCase;
        }
        int i4 = bArr[iA + 1] & UByte.MAX_VALUE;
        int i5 = iA + 2;
        int iA2 = a(bArr, i5, iE);
        String str = new String(bArr, i5, iA2 - i5, strB);
        int iA3 = a(iE) + iA2;
        return new b(strConcat, str, i4, i3 <= iA3 ? new byte[0] : Arrays.copyOfRange(bArr, iA3, i3));
    }

    public static j a(int i, com.smartdigimkt.z0.m mVar) {
        if (i < 4) {
            return null;
        }
        int iE = mVar.e();
        String strB = b(iE);
        byte[] bArr = new byte[3];
        mVar.a(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        mVar.a(bArr2, 0, i2);
        int iA = a(bArr2, 0, iE);
        String str2 = new String(bArr2, 0, iA, strB);
        int iA2 = a(iE) + iA;
        return new j(str, str2, a(bArr2, iA2, a(bArr2, iA2, iE), strB));
    }

    public static String a(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static int a(byte[] bArr, int i, int i2) {
        int iA = a(i, bArr);
        if (i2 == 0 || i2 == 3) {
            return iA;
        }
        while (iA < bArr.length - 1) {
            if (iA % 2 == 0 && bArr[iA + 1] == 0) {
                return iA;
            }
            iA = a(iA + 1, bArr);
        }
        return bArr.length;
    }

    public static int a(int i, byte[] bArr) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    public static String a(byte[] bArr, int i, int i2, String str) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }
}

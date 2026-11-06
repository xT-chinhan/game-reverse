package com.anythink.basead.exoplayer.g.b;

import android.os.Parcelable;
import android.util.Log;
import com.anythink.basead.exoplayer.k.af;
import com.anythink.basead.exoplayer.k.s;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class g implements com.anythink.basead.exoplayer.g.b {
    public static final a a = new a() { // from class: com.anythink.basead.exoplayer.g.b.g.1
        @Override // com.anythink.basead.exoplayer.g.b.g.a
        public final boolean a(int i2, int i3, int i4, int i5, int i6) {
            return false;
        }
    };
    public static final int b = af.f("ID3");
    public static final int c = 10;
    private static final String d = "Id3Decoder";
    private static final int e = 128;
    private static final int f = 64;
    private static final int g = 32;
    private static final int h = 8;
    private static final int i = 4;
    private static final int j = 64;
    private static final int k = 2;
    private static final int l = 1;
    private static final int m = 0;
    private static final int n = 1;
    private static final int o = 2;
    private static final int p = 3;
    private final a q;

    public interface a {
        boolean a(int i, int i2, int i3, int i4, int i5);
    }

    private static String a(int i2) {
        if (i2 == 1) {
            return com.anythink.basead.exoplayer.b.k;
        }
        if (i2 != 2) {
            return i2 != 3 ? "ISO-8859-1" : "UTF-8";
        }
        return "UTF-16BE";
    }

    private static int b(int i2) {
        return (i2 == 0 || i2 == 3) ? 1 : 2;
    }

    public g() {
        this(null);
    }

    private g(a aVar) {
        this.q = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009f  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:64:0x010e  */
    /* JADX WARN: Code duplicated, block: B:69:0x011a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0108 A[SYNTHETIC] */
    @Override // com.anythink.basead.exoplayer.g.b
    public final com.anythink.basead.exoplayer.g.a a(com.anythink.basead.exoplayer.g.e eVar) throws Throwable {
        boolean z;
        b bVar;
        int i2;
        int iF;
        h hVarA;
        ByteBuffer byteBuffer = eVar.e;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        ArrayList arrayList = new ArrayList();
        s sVar = new s(bArrArray, iLimit);
        boolean z2 = false;
        if (sVar.a() < 10) {
            Log.w(d, "Data too short to be an ID3 tag");
        } else {
            int iG = sVar.g();
            if (iG != b) {
                Log.w(d, "Unexpected first three bytes of ID3 tag header: ".concat(String.valueOf(iG)));
            } else {
                int iD = sVar.d();
                sVar.d(1);
                int iD2 = sVar.d();
                int iL = sVar.l();
                if (iD == 2) {
                    if ((iD2 & 64) != 0) {
                        Log.w(d, "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                    } else {
                        if (iD < 4 || (iD2 & 128) == 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                        bVar = new b(iD, z, iL);
                    }
                } else {
                    if (iD == 3) {
                        if ((iD2 & 64) != 0) {
                            int i3 = sVar.i();
                            sVar.d(i3);
                            iL -= i3 + 4;
                        }
                    } else if (iD == 4) {
                        if ((iD2 & 64) != 0) {
                            int iL2 = sVar.l();
                            sVar.d(iL2 - 4);
                            iL -= iL2;
                        }
                        if ((iD2 & 16) != 0) {
                            iL -= 10;
                        }
                    } else {
                        Log.w(d, "Skipped ID3 tag with unsupported majorVersion=".concat(String.valueOf(iD)));
                    }
                    if (iD < 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    bVar = new b(iD, z, iL);
                }
                if (bVar == null) {
                    return null;
                }
                int iC = sVar.c();
                i2 = bVar.a == 2 ? 6 : 10;
                iF = bVar.c;
                if (bVar.b) {
                    iF = f(sVar, bVar.c);
                }
                sVar.b(iC + iF);
                if (!a(sVar, bVar.a, i2, false)) {
                    if (bVar.a == 4 || !a(sVar, 4, i2, true)) {
                        Log.w(d, "Failed to validate ID3 tag with majorVersion=" + bVar.a);
                        return null;
                    }
                    z2 = true;
                }
                while (sVar.a() >= i2) {
                    hVarA = a(bVar.a, sVar, z2, i2, this.q);
                    if (hVarA != null) {
                        arrayList.add(hVarA);
                    }
                }
                return new com.anythink.basead.exoplayer.g.a(arrayList);
            }
        }
        bVar = null;
        if (bVar == null) {
            return null;
        }
        int iC2 = sVar.c();
        if (bVar.a == 2) {
        }
        iF = bVar.c;
        if (bVar.b) {
            iF = f(sVar, bVar.c);
        }
        sVar.b(iC2 + iF);
        if (!a(sVar, bVar.a, i2, false)) {
            if (bVar.a == 4) {
            }
            Log.w(d, "Failed to validate ID3 tag with majorVersion=" + bVar.a);
            return null;
        }
        while (sVar.a() >= i2) {
            hVarA = a(bVar.a, sVar, z2, i2, this.q);
            if (hVarA != null) {
                arrayList.add(hVarA);
            }
        }
        return new com.anythink.basead.exoplayer.g.a(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0095  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ad A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:64:0x0104  */
    /* JADX WARN: Code duplicated, block: B:69:0x0110 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x00fe A[SYNTHETIC] */
    private com.anythink.basead.exoplayer.g.a a(byte[] bArr, int i2) throws Throwable {
        boolean z;
        b bVar;
        int i3;
        int iF;
        h hVarA;
        ArrayList arrayList = new ArrayList();
        s sVar = new s(bArr, i2);
        boolean z2 = false;
        if (sVar.a() < 10) {
            Log.w(d, "Data too short to be an ID3 tag");
        } else {
            int iG = sVar.g();
            if (iG != b) {
                Log.w(d, "Unexpected first three bytes of ID3 tag header: ".concat(String.valueOf(iG)));
            } else {
                int iD = sVar.d();
                sVar.d(1);
                int iD2 = sVar.d();
                int iL = sVar.l();
                if (iD == 2) {
                    if ((iD2 & 64) != 0) {
                        Log.w(d, "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                    } else {
                        if (iD < 4 || (iD2 & 128) == 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                        bVar = new b(iD, z, iL);
                    }
                } else {
                    if (iD == 3) {
                        if ((iD2 & 64) != 0) {
                            int i4 = sVar.i();
                            sVar.d(i4);
                            iL -= i4 + 4;
                        }
                    } else if (iD == 4) {
                        if ((iD2 & 64) != 0) {
                            int iL2 = sVar.l();
                            sVar.d(iL2 - 4);
                            iL -= iL2;
                        }
                        if ((iD2 & 16) != 0) {
                            iL -= 10;
                        }
                    } else {
                        Log.w(d, "Skipped ID3 tag with unsupported majorVersion=".concat(String.valueOf(iD)));
                    }
                    if (iD < 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    bVar = new b(iD, z, iL);
                }
                if (bVar == null) {
                    return null;
                }
                int iC = sVar.c();
                i3 = bVar.a == 2 ? 6 : 10;
                iF = bVar.c;
                if (bVar.b) {
                    iF = f(sVar, bVar.c);
                }
                sVar.b(iC + iF);
                if (!a(sVar, bVar.a, i3, false)) {
                    if (bVar.a == 4 || !a(sVar, 4, i3, true)) {
                        Log.w(d, "Failed to validate ID3 tag with majorVersion=" + bVar.a);
                        return null;
                    }
                    z2 = true;
                }
                while (sVar.a() >= i3) {
                    hVarA = a(bVar.a, sVar, z2, i3, this.q);
                    if (hVarA != null) {
                        arrayList.add(hVarA);
                    }
                }
                return new com.anythink.basead.exoplayer.g.a(arrayList);
            }
        }
        bVar = null;
        if (bVar == null) {
            return null;
        }
        int iC2 = sVar.c();
        if (bVar.a == 2) {
        }
        iF = bVar.c;
        if (bVar.b) {
            iF = f(sVar, bVar.c);
        }
        sVar.b(iC2 + iF);
        if (!a(sVar, bVar.a, i3, false)) {
            if (bVar.a == 4) {
            }
            Log.w(d, "Failed to validate ID3 tag with majorVersion=" + bVar.a);
            return null;
        }
        while (sVar.a() >= i3) {
            hVarA = a(bVar.a, sVar, z2, i3, this.q);
            if (hVarA != null) {
                arrayList.add(hVarA);
            }
        }
        return new com.anythink.basead.exoplayer.g.a(arrayList);
    }

    private static b a(s sVar) {
        if (sVar.a() < 10) {
            Log.w(d, "Data too short to be an ID3 tag");
            return null;
        }
        int iG = sVar.g();
        if (iG != b) {
            Log.w(d, "Unexpected first three bytes of ID3 tag header: ".concat(String.valueOf(iG)));
            return null;
        }
        int iD = sVar.d();
        sVar.d(1);
        int iD2 = sVar.d();
        int iL = sVar.l();
        if (iD == 2) {
            if ((iD2 & 64) != 0) {
                Log.w(d, "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (iD == 3) {
            if ((iD2 & 64) != 0) {
                int i2 = sVar.i();
                sVar.d(i2);
                iL -= i2 + 4;
            }
        } else {
            if (iD != 4) {
                Log.w(d, "Skipped ID3 tag with unsupported majorVersion=".concat(String.valueOf(iD)));
                return null;
            }
            if ((iD2 & 64) != 0) {
                int iL2 = sVar.l();
                sVar.d(iL2 - 4);
                iL -= iL2;
            }
            if ((iD2 & 16) != 0) {
                iL -= 10;
            }
        }
        return new b(iD, iD < 4 && (iD2 & 128) != 0, iL);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0079 A[PHI: r3
      0x0079: PHI (r3v16 int) = (r3v5 int), (r3v19 int) binds: [B:40:0x0086, B:31:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    private static boolean a(s sVar, int i2, int i3, boolean z) {
        int iG;
        long jG;
        int iE;
        int i4;
        int iC = sVar.c();
        while (true) {
            try {
                boolean z2 = true;
                if (sVar.a() < i3) {
                    sVar.c(iC);
                    return true;
                }
                if (i2 >= 3) {
                    iG = sVar.i();
                    jG = sVar.h();
                    iE = sVar.e();
                } else {
                    iG = sVar.g();
                    jG = sVar.g();
                    iE = 0;
                }
                if (iG == 0 && jG == 0 && iE == 0) {
                    sVar.c(iC);
                    return true;
                }
                if (i2 == 4 && !z) {
                    if ((8421504 & jG) != 0) {
                        sVar.c(iC);
                        return false;
                    }
                    jG = (((jG >> 24) & 255) << 21) | (jG & 255) | (((jG >> 8) & 255) << 7) | (((jG >> 16) & 255) << 14);
                }
                if (i2 == 4) {
                    i4 = (iE & 64) != 0 ? 1 : 0;
                    if ((iE & 1) == 0) {
                        z2 = false;
                    }
                } else if (i2 == 3) {
                    i4 = (iE & 32) != 0 ? 1 : 0;
                    if ((iE & 128) == 0) {
                        z2 = false;
                    }
                } else {
                    i4 = 0;
                    z2 = false;
                }
                if (z2) {
                    i4 += 4;
                }
                if (jG < i4) {
                    sVar.c(iC);
                    return false;
                }
                if (sVar.a() >= jG) {
                    sVar.d((int) jG);
                } else {
                    sVar.c(iC);
                    return false;
                }
            } catch (Throwable th) {
                sVar.c(iC);
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:91:0x011a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.anythink.basead.exoplayer.g.b.h] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v28, types: [com.anythink.basead.exoplayer.g.b.h] */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    private static h a(int i2, s sVar, boolean z, int i3, a aVar) throws Throwable {
        int iG;
        int i4;
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i5;
        String str2;
        int i6;
        d dVarB;
        c cVarA;
        ?? eVar;
        int iB;
        String strD;
        Parcelable jVar;
        Object fVar;
        s sVar2 = sVar;
        int iD = sVar.d();
        int iD2 = sVar.d();
        int iD3 = sVar.d();
        int iD4 = i2 >= 3 ? sVar.d() : 0;
        if (i2 == 4) {
            iG = sVar.m();
            if (!z) {
                iG = (((iG >> 24) & 255) << 21) | (iG & 255) | (((iG >> 8) & 255) << 7) | (((iG >> 16) & 255) << 14);
            }
        } else if (i2 == 3) {
            iG = sVar.m();
        } else {
            iG = sVar.g();
        }
        int iF = iG;
        int iE = i2 >= 3 ? sVar.e() : 0;
        if (iD == 0 && iD2 == 0 && iD3 == 0 && iD4 == 0 && iF == 0 && iE == 0) {
            sVar2.c(sVar.b());
            return null;
        }
        int iC = sVar.c() + iF;
        if (iC > sVar.b()) {
            Log.w(d, "Frame size exceeds remaining tag data");
            sVar2.c(sVar.b());
            return null;
        }
        if (aVar != null) {
            i4 = iC;
            str = null;
            if (!aVar.a(i2, iD, iD2, iD3, iD4)) {
                sVar2.c(i4);
                return null;
            }
        } else {
            i4 = iC;
            str = null;
        }
        if (i2 == 3) {
            int i7 = iE;
            z3 = (i7 & 128) != 0;
            boolean z7 = (i7 & 64) != 0;
            z2 = (i7 & 32) != 0;
            z5 = z7;
            z6 = false;
            z4 = z3;
        } else {
            int i8 = iE;
            if (i2 == 4) {
                boolean z8 = (i8 & 64) != 0;
                z4 = (i8 & 8) != 0;
                z5 = (i8 & 4) != 0;
                z6 = (i8 & 2) != 0;
                if ((i8 & 1) != 0) {
                    z2 = z8;
                    z3 = true;
                } else {
                    z2 = z8;
                    z3 = false;
                }
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
                z6 = false;
            }
        }
        if (z4 || z5) {
            ?? r0 = str;
            Log.w(d, "Skipping unsupported compressed or encrypted frame");
            sVar2.c(i4);
            return r0;
        }
        if (z2) {
            iF--;
            sVar2.d(1);
        }
        if (z3) {
            iF -= 4;
            sVar2.d(4);
        }
        if (z6) {
            iF = f(sVar2, iF);
        }
        try {
            try {
                try {
                    if (iD == 84 && iD2 == 88 && iD3 == 88 && (i2 == 2 || iD4 == 88)) {
                        if (iF <= 0) {
                            fVar = str;
                        } else {
                            int iD5 = sVar.d();
                            String strA = a(iD5);
                            int i9 = iF - 1;
                            byte[] bArr = new byte[i9];
                            sVar2.a(bArr, 0, i9);
                            int iA = a(bArr, 0, iD5);
                            String str3 = new String(bArr, 0, iA, strA);
                            int iB2 = iA + b(iD5);
                            fVar = new k("TXXX", str3, a(bArr, iB2, a(bArr, iB2, iD5), strA));
                        }
                        i6 = i4;
                        eVar = fVar;
                    } else if (iD == 84) {
                        String strA2 = a(i2, iD, iD2, iD3, iD4);
                        if (iF <= 0) {
                            fVar = str;
                        } else {
                            int iD6 = sVar.d();
                            String strA3 = a(iD6);
                            int i10 = iF - 1;
                            byte[] bArr2 = new byte[i10];
                            sVar2.a(bArr2, 0, i10);
                            fVar = new k(strA2, str, new String(bArr2, 0, a(bArr2, 0, iD6), strA3));
                        }
                        i6 = i4;
                        eVar = fVar;
                    } else {
                        if (iD != 87 || iD2 != 88 || iD3 != 88 || (i2 != 2 && iD4 != 88)) {
                            if (iD == 87) {
                                String strA4 = a(i2, iD, iD2, iD3, iD4);
                                byte[] bArr3 = new byte[iF];
                                sVar2.a(bArr3, 0, iF);
                                jVar = new l(strA4, str, new String(bArr3, 0, b(bArr3, 0), "ISO-8859-1"));
                            } else if (iD == 80 && iD2 == 82 && iD3 == 73 && iD4 == 86) {
                                byte[] bArr4 = new byte[iF];
                                sVar2.a(bArr4, 0, iF);
                                int iB3 = b(bArr4, 0);
                                jVar = new j(new String(bArr4, 0, iB3, "ISO-8859-1"), b(bArr4, iB3 + 1, iF));
                            } else if (iD != 71 || iD2 != 69 || iD3 != 79 || (iD4 != 66 && i2 != 2)) {
                                try {
                                    if (i2 != 2 ? !(iD == 65 && iD2 == 80 && iD3 == 73 && iD4 == 67) : !(iD == 80 && iD2 == 73 && iD3 == 67)) {
                                        i6 = i4;
                                        if (iD != 67 || iD2 != 79 || iD3 != 77 || (iD4 != 77 && i2 != 2)) {
                                            sVar2 = sVar;
                                            if (iD == 67 && iD2 == 72 && iD3 == 65 && iD4 == 80) {
                                                cVarA = a(sVar, iF, i2, z, i3, aVar);
                                            } else if (iD == 67 && iD2 == 84 && iD3 == 79 && iD4 == 67) {
                                                dVarB = b(sVar, iF, i2, z, i3, aVar);
                                            } else {
                                                String strA5 = a(i2, iD, iD2, iD3, iD4);
                                                byte[] bArr5 = new byte[iF];
                                                sVar2.a(bArr5, 0, iF);
                                                eVar = new com.anythink.basead.exoplayer.g.b.b(strA5, bArr5);
                                            }
                                        } else if (iF < 4) {
                                            sVar2 = sVar;
                                            eVar = 0;
                                        } else {
                                            int iD7 = sVar.d();
                                            String strA6 = a(iD7);
                                            byte[] bArr6 = new byte[3];
                                            sVar2 = sVar;
                                            sVar2.a(bArr6, 0, 3);
                                            String str4 = new String(bArr6, 0, 3);
                                            int i11 = iF - 4;
                                            byte[] bArr7 = new byte[i11];
                                            sVar2.a(bArr7, 0, i11);
                                            int iA2 = a(bArr7, 0, iD7);
                                            String str5 = new String(bArr7, 0, iA2, strA6);
                                            int iB4 = iA2 + b(iD7);
                                            eVar = new e(str4, str5, a(bArr7, iB4, a(bArr7, iB4, iD7), strA6));
                                        }
                                    } else {
                                        try {
                                            int iD8 = sVar.d();
                                            String strA7 = a(iD8);
                                            int i12 = iF - 1;
                                            byte[] bArr8 = new byte[i12];
                                            sVar2.a(bArr8, 0, i12);
                                            if (i2 == 2) {
                                                i6 = i4;
                                                strD = "image/" + af.d(new String(bArr8, 0, 3, "ISO-8859-1"));
                                                if ("image/jpg".equals(strD)) {
                                                    strD = "image/jpeg";
                                                }
                                                iB = 2;
                                            } else {
                                                i6 = i4;
                                                iB = b(bArr8, 0);
                                                strD = af.d(new String(bArr8, 0, iB, "ISO-8859-1"));
                                                if (strD.indexOf(47) == -1) {
                                                    strD = "image/".concat(String.valueOf(strD));
                                                }
                                            }
                                            int i13 = bArr8[iB + 1] & UByte.MAX_VALUE;
                                            int i14 = iB + 2;
                                            int iA3 = a(bArr8, i14, iD8);
                                            sVar2 = sVar;
                                            eVar = new com.anythink.basead.exoplayer.g.b.a(strD, new String(bArr8, i14, iA3 - i14, strA7), i13, b(bArr8, iA3 + b(iD8), i12));
                                        } catch (UnsupportedEncodingException unused) {
                                            sVar2 = sVar;
                                            i5 = i4;
                                            str2 = r3;
                                            try {
                                                Log.w(str2, "Unsupported character encoding");
                                                sVar2.c(i5);
                                                return null;
                                            } catch (Throwable th) {
                                                th = th;
                                                sVar2.c(i5);
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            sVar2 = sVar;
                                            i5 = i4;
                                            sVar2.c(i5);
                                            throw th;
                                        }
                                    }
                                } catch (UnsupportedEncodingException unused2) {
                                    sVar2 = sVar;
                                    str2 = r3;
                                    i5 = i6;
                                    Log.w(str2, "Unsupported character encoding");
                                    sVar2.c(i5);
                                    return null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    sVar2 = sVar;
                                    i5 = i6;
                                    sVar2.c(i5);
                                    throw th;
                                }
                            } else {
                                int iD9 = sVar.d();
                                String strA8 = a(iD9);
                                int i15 = iF - 1;
                                byte[] bArr9 = new byte[i15];
                                sVar2.a(bArr9, 0, i15);
                                int iB5 = b(bArr9, 0);
                                String str6 = new String(bArr9, 0, iB5, "ISO-8859-1");
                                int i16 = iB5 + 1;
                                int iA4 = a(bArr9, i16, iD9);
                                String strA9 = a(bArr9, i16, iA4, strA8);
                                int iB6 = iA4 + b(iD9);
                                int iA5 = a(bArr9, iB6, iD9);
                                fVar = new f(str6, strA9, a(bArr9, iB6, iA5, strA8), b(bArr9, iA5 + b(iD9), i15));
                            }
                            fVar = jVar;
                        } else if (iF <= 0) {
                            fVar = str;
                        } else {
                            int iD10 = sVar.d();
                            String strA10 = a(iD10);
                            int i17 = iF - 1;
                            byte[] bArr10 = new byte[i17];
                            sVar2.a(bArr10, 0, i17);
                            int iA6 = a(bArr10, 0, iD10);
                            String str7 = new String(bArr10, 0, iA6, strA10);
                            int iB7 = iA6 + b(iD10);
                            fVar = new l("WXXX", str7, a(bArr10, iB7, b(bArr10, iB7), "ISO-8859-1"));
                        }
                        i6 = i4;
                        eVar = fVar;
                    }
                    if (eVar == 0) {
                        eVar = dVarB;
                        eVar = cVarA;
                        str2 = r3;
                        try {
                            Log.w(str2, "Failed to decode frame: id=" + a(i2, iD, iD2, iD3, iD4) + ", frameSize=" + iF);
                        } catch (UnsupportedEncodingException unused3) {
                            i5 = i6;
                            Log.w(str2, "Unsupported character encoding");
                            sVar2.c(i5);
                            return null;
                        }
                    }
                    eVar = dVarB;
                    eVar = cVarA;
                    sVar2.c(i6);
                    return eVar;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (UnsupportedEncodingException unused4) {
            }
        } catch (UnsupportedEncodingException unused5) {
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private static k a(s sVar, int i2) {
        if (i2 <= 0) {
            return null;
        }
        int iD = sVar.d();
        String strA = a(iD);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.a(bArr, 0, i3);
        int iA = a(bArr, 0, iD);
        String str = new String(bArr, 0, iA, strA);
        int iB = iA + b(iD);
        return new k("TXXX", str, a(bArr, iB, a(bArr, iB, iD), strA));
    }

    private static k a(s sVar, int i2, String str) {
        if (i2 <= 0) {
            return null;
        }
        int iD = sVar.d();
        String strA = a(iD);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.a(bArr, 0, i3);
        return new k(str, null, new String(bArr, 0, a(bArr, 0, iD), strA));
    }

    private static l b(s sVar, int i2) {
        if (i2 <= 0) {
            return null;
        }
        int iD = sVar.d();
        String strA = a(iD);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.a(bArr, 0, i3);
        int iA = a(bArr, 0, iD);
        String str = new String(bArr, 0, iA, strA);
        int iB = iA + b(iD);
        return new l("WXXX", str, a(bArr, iB, b(bArr, iB), "ISO-8859-1"));
    }

    private static l b(s sVar, int i2, String str) {
        byte[] bArr = new byte[i2];
        sVar.a(bArr, 0, i2);
        return new l(str, null, new String(bArr, 0, b(bArr, 0), "ISO-8859-1"));
    }

    private static j c(s sVar, int i2) {
        byte[] bArr = new byte[i2];
        sVar.a(bArr, 0, i2);
        int iB = b(bArr, 0);
        return new j(new String(bArr, 0, iB, "ISO-8859-1"), b(bArr, iB + 1, i2));
    }

    private static f d(s sVar, int i2) {
        int iD = sVar.d();
        String strA = a(iD);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        sVar.a(bArr, 0, i3);
        int iB = b(bArr, 0);
        String str = new String(bArr, 0, iB, "ISO-8859-1");
        int i4 = iB + 1;
        int iA = a(bArr, i4, iD);
        String strA2 = a(bArr, i4, iA, strA);
        int iB2 = iA + b(iD);
        int iA2 = a(bArr, iB2, iD);
        return new f(str, strA2, a(bArr, iB2, iA2, strA), b(bArr, iA2 + b(iD), i3));
    }

    private static com.anythink.basead.exoplayer.g.b.a a(s sVar, int i2, int i3) {
        int iB;
        String strConcat;
        int iD = sVar.d();
        String strA = a(iD);
        int i4 = i2 - 1;
        byte[] bArr = new byte[i4];
        sVar.a(bArr, 0, i4);
        if (i3 == 2) {
            strConcat = "image/" + af.d(new String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(strConcat)) {
                strConcat = "image/jpeg";
            }
            iB = 2;
        } else {
            iB = b(bArr, 0);
            String strD = af.d(new String(bArr, 0, iB, "ISO-8859-1"));
            strConcat = strD.indexOf(47) == -1 ? "image/".concat(String.valueOf(strD)) : strD;
        }
        int i5 = bArr[iB + 1] & UByte.MAX_VALUE;
        int i6 = iB + 2;
        int iA = a(bArr, i6, iD);
        return new com.anythink.basead.exoplayer.g.b.a(strConcat, new String(bArr, i6, iA - i6, strA), i5, b(bArr, iA + b(iD), i4));
    }

    private static e e(s sVar, int i2) {
        if (i2 < 4) {
            return null;
        }
        int iD = sVar.d();
        String strA = a(iD);
        byte[] bArr = new byte[3];
        sVar.a(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i3 = i2 - 4;
        byte[] bArr2 = new byte[i3];
        sVar.a(bArr2, 0, i3);
        int iA = a(bArr2, 0, iD);
        String str2 = new String(bArr2, 0, iA, strA);
        int iB = iA + b(iD);
        return new e(str, str2, a(bArr2, iB, a(bArr2, iB, iD), strA));
    }

    private static c a(s sVar, int i2, int i3, boolean z, int i4, a aVar) throws Throwable {
        int iC = sVar.c();
        int iB = b(sVar.a, iC);
        String str = new String(sVar.a, iC, iB - iC, "ISO-8859-1");
        sVar.c(iB + 1);
        int i5 = sVar.i();
        int i6 = sVar.i();
        long jH = sVar.h();
        long j2 = jH == 4294967295L ? -1L : jH;
        long jH2 = sVar.h();
        long j3 = jH2 == 4294967295L ? -1L : jH2;
        ArrayList arrayList = new ArrayList();
        int i7 = iC + i2;
        while (sVar.c() < i7) {
            h hVarA = a(i3, sVar, z, i4, aVar);
            if (hVarA != null) {
                arrayList.add(hVarA);
            }
        }
        h[] hVarArr = new h[arrayList.size()];
        arrayList.toArray(hVarArr);
        return new c(str, i5, i6, j2, j3, hVarArr);
    }

    private static d b(s sVar, int i2, int i3, boolean z, int i4, a aVar) throws Throwable {
        int iC = sVar.c();
        int iB = b(sVar.a, iC);
        String str = new String(sVar.a, iC, iB - iC, "ISO-8859-1");
        sVar.c(iB + 1);
        int iD = sVar.d();
        boolean z2 = (iD & 2) != 0;
        boolean z3 = (iD & 1) != 0;
        int iD2 = sVar.d();
        String[] strArr = new String[iD2];
        for (int i5 = 0; i5 < iD2; i5++) {
            int iC2 = sVar.c();
            int iB2 = b(sVar.a, iC2);
            strArr[i5] = new String(sVar.a, iC2, iB2 - iC2, "ISO-8859-1");
            sVar.c(iB2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i6 = iC + i2;
        while (sVar.c() < i6) {
            h hVarA = a(i3, sVar, z, i4, aVar);
            if (hVarA != null) {
                arrayList.add(hVarA);
            }
        }
        h[] hVarArr = new h[arrayList.size()];
        arrayList.toArray(hVarArr);
        return new d(str, z2, z3, strArr, hVarArr);
    }

    private static com.anythink.basead.exoplayer.g.b.b c(s sVar, int i2, String str) {
        byte[] bArr = new byte[i2];
        sVar.a(bArr, 0, i2);
        return new com.anythink.basead.exoplayer.g.b.b(str, bArr);
    }

    private static int f(s sVar, int i2) {
        byte[] bArr = sVar.a;
        int iC = sVar.c();
        while (true) {
            int i3 = iC + 1;
            if (i3 >= i2) {
                return i2;
            }
            if ((bArr[iC] & UByte.MAX_VALUE) == 255 && bArr[i3] == 0) {
                System.arraycopy(bArr, iC + 2, bArr, i3, (i2 - iC) - 2);
                i2--;
            }
            iC = i3;
        }
    }

    private static String a(int i2, int i3, int i4, int i5, int i6) {
        return i2 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    private static int a(byte[] bArr, int i2, int i3) {
        int iB = b(bArr, i2);
        if (i3 == 0 || i3 == 3) {
            return iB;
        }
        while (iB < bArr.length - 1) {
            if (iB % 2 == 0 && bArr[iB + 1] == 0) {
                return iB;
            }
            iB = b(bArr, iB + 1);
        }
        return bArr.length;
    }

    private static int b(byte[] bArr, int i2) {
        while (i2 < bArr.length) {
            if (bArr[i2] == 0) {
                return i2;
            }
            i2++;
        }
        return bArr.length;
    }

    private static byte[] b(byte[] bArr, int i2, int i3) {
        return i3 <= i2 ? new byte[0] : Arrays.copyOfRange(bArr, i2, i3);
    }

    private static String a(byte[] bArr, int i2, int i3, String str) {
        return (i3 <= i2 || i3 > bArr.length) ? "" : new String(bArr, i2, i3 - i2, str);
    }

    private static final class b {
        private final int a;
        private final boolean b;
        private final int c;

        public b(int i, boolean z, int i2) {
            this.a = i;
            this.b = z;
            this.c = i2;
        }
    }
}

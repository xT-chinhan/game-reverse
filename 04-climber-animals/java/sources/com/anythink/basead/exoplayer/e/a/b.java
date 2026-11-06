package com.anythink.basead.exoplayer.e.a;

import android.util.Log;
import android.util.Pair;
import com.anythink.basead.exoplayer.k.af;
import com.anythink.basead.exoplayer.k.o;
import com.anythink.basead.exoplayer.k.s;
import com.anythink.basead.exoplayer.t;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class b {
    private static final String a = "AtomParsers";
    private static final int b = af.f("vide");
    private static final int c = af.f("soun");
    private static final int d = af.f("text");
    private static final int e = af.f("sbtl");
    private static final int f = af.f("subt");
    private static final int g = af.f("clcp");
    private static final int h = af.f(TTDownloadField.TT_META);
    private static final int i = 3;

    /* JADX INFO: renamed from: com.anythink.basead.exoplayer.e.a.b$b, reason: collision with other inner class name */
    private interface InterfaceC0024b {
        int a();

        int b();

        boolean c();
    }

    public static final class g extends t {
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x00cb A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:62:0x00d4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00d6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:69:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:73:0x0103  */
    /* JADX WARN: Code duplicated, block: B:74:0x0105  */
    /* JADX WARN: Code duplicated, block: B:78:0x0113  */
    /* JADX WARN: Code duplicated, block: B:81:0x013e  */
    /* JADX WARN: Code duplicated, block: B:82:0x0140  */
    /* JADX WARN: Code duplicated, block: B:85:0x014b  */
    /* JADX WARN: Code duplicated, block: B:88:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:89:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:92:0x01c4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:93:0x01c5  */
    public static j a(com.anythink.basead.exoplayer.e.a.a.C0023a c0023a, com.anythink.basead.exoplayer.e.a.a.b bVar, long j, com.anythink.basead.exoplayer.d.e eVar, boolean z, boolean z2) throws t {
        int i2;
        int i3;
        boolean z3;
        long jH;
        int i4;
        f fVar;
        long j2;
        s sVar;
        int i5;
        long jH2;
        long jA;
        int iA;
        int i6;
        Pair pairCreate;
        c cVarA;
        long[] jArr;
        long[] jArr2;
        com.anythink.basead.exoplayer.e.a.a.C0023a c0023aE = c0023a.e(com.anythink.basead.exoplayer.e.a.a.J);
        s sVar2 = c0023aE.d(com.anythink.basead.exoplayer.e.a.a.X).aV;
        sVar2.c(16);
        int i7 = sVar2.i();
        if (i7 == c) {
            i3 = 1;
        } else {
            if (i7 == b) {
                i2 = 2;
            } else if (i7 == d || i7 == e || i7 == f || i7 == g) {
                i2 = 3;
            } else {
                i3 = i7 == h ? 4 : -1;
            }
            i3 = i2;
        }
        if (i3 == -1) {
            return null;
        }
        s sVar3 = c0023a.d(com.anythink.basead.exoplayer.e.a.a.T).aV;
        sVar3.c(8);
        int iA2 = com.anythink.basead.exoplayer.e.a.a.a(sVar3.i());
        sVar3.d(iA2 == 0 ? 8 : 16);
        int i8 = sVar3.i();
        sVar3.d(4);
        int iC = sVar3.c();
        int i9 = iA2 == 0 ? 4 : 8;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= i9) {
                z3 = true;
                break;
            }
            if (sVar3.a[iC + i11] != -1) {
                z3 = false;
                break;
            }
            i11++;
        }
        if (z3) {
            sVar3.d(i9);
        } else {
            jH = iA2 == 0 ? sVar3.h() : sVar3.n();
            if (jH == 0) {
            }
            sVar3.d(16);
            i4 = sVar3.i();
            int i12 = sVar3.i();
            sVar3.d(4);
            int i13 = sVar3.i();
            int i14 = sVar3.i();
            if (i4 != 0 && i12 == 65536 && i13 == -65536 && i14 == 0) {
                i10 = 90;
            } else if (i4 != 0 && i12 == -65536 && i13 == 65536 && i14 == 0) {
                i10 = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
            } else if (i4 == -65536 && i12 == 0 && i13 == 0 && i14 == -65536) {
                i10 = 180;
            }
            fVar = new f(i8, jH, i10);
            if (j == -9223372036854775807L) {
                j2 = fVar.b;
            } else {
                j2 = j;
            }
            sVar = bVar.aV;
            sVar.c(8);
            if (com.anythink.basead.exoplayer.e.a.a.a(sVar.i()) == 0) {
                i5 = 8;
            } else {
                i5 = 16;
            }
            sVar.d(i5);
            jH2 = sVar.h();
            jA = j2 != -9223372036854775807L ? af.a(j2, 1000000L, jH2) : -9223372036854775807L;
            com.anythink.basead.exoplayer.e.a.a.C0023a c0023aE2 = c0023aE.e(com.anythink.basead.exoplayer.e.a.a.K).e(com.anythink.basead.exoplayer.e.a.a.L);
            s sVar4 = c0023aE.d(com.anythink.basead.exoplayer.e.a.a.W).aV;
            sVar4.c(8);
            iA = com.anythink.basead.exoplayer.e.a.a.a(sVar4.i());
            if (iA == 0) {
                i6 = 8;
            } else {
                i6 = 16;
            }
            sVar4.d(i6);
            long jH3 = sVar4.h();
            sVar4.d(iA == 0 ? 4 : 8);
            int iE = sVar4.e();
            pairCreate = Pair.create(Long.valueOf(jH3), new StringBuilder().append((char) (((iE >> 10) & 31) + 96)).append((char) (((iE >> 5) & 31) + 96)).append((char) ((iE & 31) + 96)).toString());
            cVarA = a(c0023aE2.d(com.anythink.basead.exoplayer.e.a.a.Y).aV, fVar.a, fVar.c, (String) pairCreate.second, eVar, z2);
            if (z) {
                jArr = null;
                jArr2 = null;
            } else {
                Pair<long[], long[]> pairA = a(c0023a.e(com.anythink.basead.exoplayer.e.a.a.U));
                long[] jArr3 = (long[]) pairA.first;
                jArr2 = (long[]) pairA.second;
                jArr = jArr3;
            }
            if (cVarA.c == null) {
                return null;
            }
            return new j(fVar.a, i3, ((Long) pairCreate.first).longValue(), jH2, jA, cVarA.c, cVarA.e, cVarA.b, cVarA.d, jArr, jArr2);
        }
        jH = -9223372036854775807L;
        sVar3.d(16);
        i4 = sVar3.i();
        int i15 = sVar3.i();
        sVar3.d(4);
        int i16 = sVar3.i();
        int i17 = sVar3.i();
        if (i4 != 0) {
            if (i4 != 0) {
                if (i4 == -65536) {
                    i10 = 180;
                }
            } else if (i4 == -65536) {
                i10 = 180;
            }
        } else if (i4 != 0) {
            if (i4 == -65536) {
                i10 = 180;
            }
        } else if (i4 == -65536) {
            i10 = 180;
        }
        fVar = new f(i8, jH, i10);
        if (j == -9223372036854775807L) {
            j2 = fVar.b;
        } else {
            j2 = j;
        }
        sVar = bVar.aV;
        sVar.c(8);
        if (com.anythink.basead.exoplayer.e.a.a.a(sVar.i()) == 0) {
            i5 = 8;
        } else {
            i5 = 16;
        }
        sVar.d(i5);
        jH2 = sVar.h();
        if (j2 != -9223372036854775807L) {
        }
        com.anythink.basead.exoplayer.e.a.a.C0023a c0023aE3 = c0023aE.e(com.anythink.basead.exoplayer.e.a.a.K).e(com.anythink.basead.exoplayer.e.a.a.L);
        s sVar5 = c0023aE.d(com.anythink.basead.exoplayer.e.a.a.W).aV;
        sVar5.c(8);
        iA = com.anythink.basead.exoplayer.e.a.a.a(sVar5.i());
        if (iA == 0) {
            i6 = 8;
        } else {
            i6 = 16;
        }
        sVar5.d(i6);
        long jH4 = sVar5.h();
        sVar5.d(iA == 0 ? 4 : 8);
        int iE2 = sVar5.e();
        pairCreate = Pair.create(Long.valueOf(jH4), new StringBuilder().append((char) (((iE2 >> 10) & 31) + 96)).append((char) (((iE2 >> 5) & 31) + 96)).append((char) ((iE2 & 31) + 96)).toString());
        cVarA = a(c0023aE3.d(com.anythink.basead.exoplayer.e.a.a.Y).aV, fVar.a, fVar.c, (String) pairCreate.second, eVar, z2);
        if (z) {
            Pair<long[], long[]> pairA2 = a(c0023a.e(com.anythink.basead.exoplayer.e.a.a.U));
            long[] jArr4 = (long[]) pairA2.first;
            jArr2 = (long[]) pairA2.second;
            jArr = jArr4;
        } else {
            jArr = null;
            jArr2 = null;
        }
        if (cVarA.c == null) {
            return null;
        }
        return new j(fVar.a, i3, ((Long) pairCreate.first).longValue(), jH2, jA, cVarA.c, cVarA.e, cVarA.b, cVarA.d, jArr, jArr2);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:48:0x0103 A[ADDED_TO_REGION, LOOP:1: B:48:0x0103->B:49:0x0105, LOOP_START, PHI: r14 r15 r23 r27
      0x0103: PHI (r14v9 int) = (r14v7 int), (r14v14 int) binds: [B:47:0x0101, B:49:0x0105] A[DONT_GENERATE, DONT_INLINE]
      0x0103: PHI (r15v23 int) = (r15v22 int), (r15v29 int) binds: [B:47:0x0101, B:49:0x0105] A[DONT_GENERATE, DONT_INLINE]
      0x0103: PHI (r23v7 int) = (r23v6 int), (r23v10 int) binds: [B:47:0x0101, B:49:0x0105] A[DONT_GENERATE, DONT_INLINE]
      0x0103: PHI (r27v11 long) = (r27v10 long), (r27v13 long) binds: [B:47:0x0101, B:49:0x0105] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:49:0x0105 A[LOOP:1: B:48:0x0103->B:49:0x0105, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x0123 A[ADDED_TO_REGION, LOOP:2: B:52:0x0123->B:54:0x0127, LOOP_START, PHI: r16 r21 r22
      0x0123: PHI (r16v13 int) = (r16v9 int), (r16v14 int) binds: [B:51:0x0121, B:54:0x0127] A[DONT_GENERATE, DONT_INLINE]
      0x0123: PHI (r21v12 int) = (r21v10 int), (r21v14 int) binds: [B:51:0x0121, B:54:0x0127] A[DONT_GENERATE, DONT_INLINE]
      0x0123: PHI (r22v8 int) = (r22v1 int), (r22v9 int) binds: [B:51:0x0121, B:54:0x0127] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:58:0x0140  */
    /* JADX WARN: Code duplicated, block: B:59:0x0145  */
    /* JADX WARN: Code duplicated, block: B:62:0x014f  */
    /* JADX WARN: Code duplicated, block: B:63:0x0151  */
    /* JADX WARN: Code duplicated, block: B:66:0x0156  */
    /* JADX WARN: Code duplicated, block: B:68:0x015d  */
    /* JADX WARN: Code duplicated, block: B:76:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:77:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:80:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:83:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:92:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:95:0x0216  */
    /* JADX WARN: Code duplicated, block: B:98:0x0226 A[LOOP:8: B:96:0x0220->B:98:0x0226, LOOP_END] */
    public static m a(j jVar, com.anythink.basead.exoplayer.e.a.a.C0023a c0023a, com.anythink.basead.exoplayer.e.i iVar) throws t {
        InterfaceC0024b eVar;
        boolean z;
        int iM;
        int iM2;
        boolean z2;
        j jVar2;
        String str;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        int i2;
        long[] jArr3;
        int[] iArr3;
        long j;
        long jA;
        String str2;
        String str3;
        int[] iArr4;
        long[] jArr4;
        int[] iArr5;
        int[] iArr6;
        long[] jArr5;
        int[] iArr7;
        long[] jArr6;
        int i3;
        long j2;
        long j3;
        int i4;
        int i5;
        int i6;
        int iM3;
        int i7;
        int i8;
        int i9;
        int iM4;
        int i10;
        int i11;
        boolean z3;
        int i12;
        boolean z4;
        int iB;
        int i13;
        int iM5;
        com.anythink.basead.exoplayer.e.a.a.b bVarD = c0023a.d(com.anythink.basead.exoplayer.e.a.a.av);
        if (bVarD != null) {
            eVar = new d(bVarD);
        } else {
            com.anythink.basead.exoplayer.e.a.a.b bVarD2 = c0023a.d(com.anythink.basead.exoplayer.e.a.a.aw);
            if (bVarD2 == null) {
                throw new t("Track has no sample table size information");
            }
            eVar = new e(bVarD2);
        }
        int iA = eVar.a();
        if (iA == 0) {
            return new m(jVar, new long[0], new int[0], 0, new long[0], new int[0], -9223372036854775807L);
        }
        com.anythink.basead.exoplayer.e.a.a.b bVarD3 = c0023a.d(com.anythink.basead.exoplayer.e.a.a.ax);
        if (bVarD3 == null) {
            bVarD3 = c0023a.d(com.anythink.basead.exoplayer.e.a.a.ay);
            z = true;
        } else {
            z = false;
        }
        s sVar = bVarD3.aV;
        s sVar2 = c0023a.d(com.anythink.basead.exoplayer.e.a.a.au).aV;
        s sVar3 = c0023a.d(com.anythink.basead.exoplayer.e.a.a.ar).aV;
        com.anythink.basead.exoplayer.e.a.a.b bVarD4 = c0023a.d(com.anythink.basead.exoplayer.e.a.a.as);
        s sVar4 = null;
        s sVar5 = bVarD4 != null ? bVarD4.aV : null;
        com.anythink.basead.exoplayer.e.a.a.b bVarD5 = c0023a.d(com.anythink.basead.exoplayer.e.a.a.at);
        s sVar6 = bVarD5 != null ? bVarD5.aV : null;
        a aVar = new a(sVar2, sVar, z);
        sVar3.c(12);
        int iM6 = sVar3.m() - 1;
        int iM7 = sVar3.m();
        int iM8 = sVar3.m();
        if (sVar6 != null) {
            sVar6.c(12);
            iM = sVar6.m();
        } else {
            iM = 0;
        }
        int iM9 = -1;
        if (sVar5 != null) {
            sVar5.c(12);
            iM2 = sVar5.m();
            iM9 = iM2 > 0 ? sVar5.m() - 1 : -1;
            if (!eVar.c() && o.w.equals(jVar.h.h) && iM6 == 0 && iM == 0 && iM2 == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            long j4 = 0;
            if (!z2) {
                jArr5 = new long[iA];
                iArr7 = new int[iA];
                int i14 = iM2;
                jArr6 = new long[iA];
                iArr3 = new int[iA];
                i3 = iM8;
                j2 = 0;
                j3 = 0;
                i4 = iM6;
                i5 = 0;
                i6 = 0;
                iM3 = 0;
                i7 = 0;
                i8 = 0;
                i9 = i14;
                iM4 = iM9;
                i10 = iM;
                i11 = iM7;
                while (i5 < iA) {
                    while (i8 == 0) {
                        com.anythink.basead.exoplayer.k.a.b(aVar.a());
                        j3 = aVar.d;
                        i8 = aVar.c;
                        i4 = i4;
                        i11 = i11;
                    }
                    int i15 = i4;
                    int i16 = i11;
                    if (sVar6 != null) {
                        while (iM3 == 0 && i10 > 0) {
                            iM3 = sVar6.m();
                            i7 = sVar6.i();
                            i10--;
                        }
                        iM3--;
                    }
                    int i17 = i7;
                    jArr5[i5] = j3;
                    iB = eVar.b();
                    iArr7[i5] = iB;
                    if (iB > i6) {
                        i6 = iB;
                    }
                    jArr6[i5] = j2 + ((long) i17);
                    if (sVar4 == null) {
                        i13 = 1;
                    } else {
                        i13 = 0;
                    }
                    iArr3[i5] = i13;
                    if (i5 == iM4) {
                        iArr3[i5] = 1;
                        i9--;
                        if (i9 > 0) {
                            iM4 = sVar4.m() - 1;
                        }
                    }
                    j2 += (long) i3;
                    iM5 = i16 - 1;
                    if (iM5 != 0 && i15 > 0) {
                        i15--;
                        iM5 = sVar3.m();
                        i3 = sVar3.i();
                    }
                    int i18 = iM5;
                    j3 += (long) iArr7[i5];
                    i8--;
                    i5++;
                    eVar = eVar;
                    jArr5 = jArr5;
                    i11 = i18;
                    i7 = i17;
                    i4 = i15;
                }
                int i19 = i4;
                int i20 = i11;
                int i21 = i7;
                long[] jArr7 = jArr5;
                j = j2 + ((long) i21);
                if (iM3 == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                com.anythink.basead.exoplayer.k.a.a(z3);
                while (i10 > 0) {
                    if (sVar6.m() == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    com.anythink.basead.exoplayer.k.a.a(z4);
                    sVar6.i();
                    i10--;
                }
                if (i9 == 0 || i20 != 0) {
                    i12 = i8;
                } else {
                    i12 = i8;
                    if (i12 == 0 && i19 == 0) {
                        jVar2 = jVar;
                        str = a;
                    }
                    iArr2 = iArr7;
                    jArr2 = jArr7;
                    jArr3 = jArr6;
                    i2 = i6;
                }
                jVar2 = jVar;
                String str4 = "Inconsistent stbl box for track " + jVar2.c + ": remainingSynchronizationSamples " + i9 + ", remainingSamplesAtTimestampDelta " + i20 + ", remainingSamplesInChunk " + i12 + ", remainingTimestampDeltaChanges " + i19;
                str = a;
                Log.w(str, str4);
                iArr2 = iArr7;
                jArr2 = jArr7;
                jArr3 = jArr6;
                i2 = i6;
            } else {
                jVar2 = jVar;
                str = a;
                jArr = new long[aVar.a];
                iArr = new int[aVar.a];
                while (aVar.a()) {
                    jArr[aVar.b] = aVar.d;
                    iArr[aVar.b] = aVar.c;
                }
                com.anythink.basead.exoplayer.e.a.d.a aVarA = com.anythink.basead.exoplayer.e.a.d.a(af.b(jVar2.h.w, jVar2.h.u), jArr, iArr, iM8);
                jArr2 = aVarA.a;
                iArr2 = aVarA.b;
                i2 = aVarA.c;
                jArr3 = aVarA.d;
                iArr3 = aVarA.e;
                j = aVarA.f;
            }
            jA = af.a(j, 1000000L, jVar2.e);
            if (jVar2.j != null || iVar.a()) {
                af.a(jArr3, jVar2.e);
                return new m(jVar, jArr2, iArr2, i2, jArr3, iArr3, jA);
            }
            if (jVar2.j.length == 1 && jVar2.d == 1 && jArr3.length >= 2) {
                long j5 = jVar2.k[0];
                long jA2 = j5 + af.a(jVar2.j[0], jVar2.e, jVar2.f);
                int length = jArr3.length - 1;
                int iA2 = af.a(3, 0, length);
                str2 = str;
                int iA3 = af.a(jArr3.length - 3, 0, length);
                long j6 = jArr3[0];
                if (j6 <= j5 && j5 < jArr3[iA2] && jArr3[iA3] < jA2 && jA2 <= j) {
                    long jA3 = af.a(j5 - j6, jVar2.h.v, jVar2.e);
                    long jA4 = af.a(j - jA2, jVar2.h.v, jVar2.e);
                    if ((jA3 != 0 || jA4 != 0) && jA3 <= 2147483647L && jA4 <= 2147483647L) {
                        iVar.b = (int) jA3;
                        iVar.c = (int) jA4;
                        af.a(jArr3, jVar2.e);
                        return new m(jVar, jArr2, iArr2, i2, jArr3, iArr3, jA);
                    }
                }
            } else {
                str2 = str;
            }
            if (jVar2.j.length == 1 && jVar2.j[0] == 0) {
                long j7 = jVar2.k[0];
                for (int i22 = 0; i22 < jArr3.length; i22++) {
                    jArr3[i22] = af.a(jArr3[i22] - j7, 1000000L, jVar2.e);
                }
                return new m(jVar, jArr2, iArr2, i2, jArr3, iArr3, af.a(j - j7, 1000000L, jVar2.e));
            }
            boolean z5 = jVar2.d == 1;
            boolean z6 = false;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            while (i25 < jVar2.j.length) {
                int[] iArr8 = iArr2;
                int i26 = i2;
                long j8 = jVar2.k[i25];
                if (j8 != -1) {
                    long jA5 = af.a(jVar2.j[i25], jVar2.e, jVar2.f);
                    int iA4 = af.a(jArr3, j8, true, true);
                    int iA5 = af.a(jArr3, j8 + jA5, z5, false);
                    i23 += iA5 - iA4;
                    z6 |= i24 != iA4;
                    i24 = iA5;
                }
                i25++;
                iArr2 = iArr8;
                i2 = i26;
            }
            int[] iArr9 = iArr2;
            int i27 = i2;
            boolean z7 = z6 | (i23 != iA);
            long[] jArr8 = z7 ? new long[i23] : jArr2;
            int[] iArr10 = z7 ? new int[i23] : iArr9;
            int i28 = z7 ? 0 : i27;
            int[] iArr11 = z7 ? new int[i23] : iArr3;
            long[] jArr9 = new long[i23];
            int i29 = 0;
            int i30 = 0;
            while (i29 < jVar2.j.length) {
                long j9 = jVar2.k[i29];
                long j10 = jVar2.j[i29];
                if (j9 != -1) {
                    int[] iArr12 = iArr3;
                    jArr4 = jArr9;
                    int[] iArr13 = iArr11;
                    long jA6 = af.a(j10, jVar2.e, jVar2.f) + j9;
                    int iA6 = af.a(jArr3, j9, true, true);
                    int iA7 = af.a(jArr3, jA6, z5, false);
                    if (z7) {
                        int i31 = iA7 - iA6;
                        System.arraycopy(jArr2, iA6, jArr8, i30, i31);
                        iArr4 = iArr9;
                        System.arraycopy(iArr4, iA6, iArr10, i30, i31);
                        iArr6 = iArr12;
                        iArr5 = iArr13;
                        System.arraycopy(iArr6, iA6, iArr5, i30, i31);
                    } else {
                        iArr4 = iArr9;
                        iArr6 = iArr12;
                        iArr5 = iArr13;
                    }
                    if (iA6 < iA7 && (iArr5[i30] & 1) == 0) {
                        Log.w(str2, "Ignoring edit list: edit does not start with a sync sample.");
                        throw new g();
                    }
                    while (iA6 < iA7) {
                        int i32 = iA7;
                        String str5 = str2;
                        long j11 = j9;
                        jArr4[i30] = af.a(j4, 1000000L, jVar2.f) + af.a(jArr3[iA6] - j9, 1000000L, jVar2.e);
                        if (z7 && iArr10[i30] > i28) {
                            i28 = iArr4[iA6];
                        }
                        i30++;
                        iA6++;
                        iA7 = i32;
                        str2 = str5;
                        j9 = j11;
                    }
                    str3 = str2;
                } else {
                    str3 = str2;
                    iArr4 = iArr9;
                    jArr2 = jArr2;
                    jArr4 = jArr9;
                    iArr5 = iArr11;
                    iArr6 = iArr3;
                }
                j4 += j10;
                i29++;
                iArr3 = iArr6;
                iArr9 = iArr4;
                str2 = str3;
                jArr9 = jArr4;
                iArr11 = iArr5;
                jArr2 = jArr2;
            }
            return new m(jVar, jArr8, iArr10, i28, jArr9, iArr11, af.a(j4, 1000000L, jVar2.e));
        }
        iM2 = 0;
        sVar4 = sVar5;
        if (!eVar.c()) {
            z2 = false;
        } else {
            z2 = false;
        }
        long j12 = 0;
        if (!z2) {
            jArr5 = new long[iA];
            iArr7 = new int[iA];
            int i110 = iM2;
            jArr6 = new long[iA];
            iArr3 = new int[iA];
            i3 = iM8;
            j2 = 0;
            j3 = 0;
            i4 = iM6;
            i5 = 0;
            i6 = 0;
            iM3 = 0;
            i7 = 0;
            i8 = 0;
            i9 = i110;
            iM4 = iM9;
            i10 = iM;
            i11 = iM7;
            while (i5 < iA) {
                while (i8 == 0) {
                    com.anythink.basead.exoplayer.k.a.b(aVar.a());
                    j3 = aVar.d;
                    i8 = aVar.c;
                    i4 = i4;
                    i11 = i11;
                }
                int i111 = i4;
                int i112 = i11;
                if (sVar6 != null) {
                    while (iM3 == 0) {
                        iM3 = sVar6.m();
                        i7 = sVar6.i();
                        i10--;
                    }
                    iM3--;
                }
                int i113 = i7;
                jArr5[i5] = j3;
                iB = eVar.b();
                iArr7[i5] = iB;
                if (iB > i6) {
                    i6 = iB;
                }
                jArr6[i5] = j2 + ((long) i113);
                if (sVar4 == null) {
                    i13 = 1;
                } else {
                    i13 = 0;
                }
                iArr3[i5] = i13;
                if (i5 == iM4) {
                    iArr3[i5] = 1;
                    i9--;
                    if (i9 > 0) {
                        iM4 = sVar4.m() - 1;
                    }
                }
                j2 += (long) i3;
                iM5 = i112 - 1;
                if (iM5 != 0) {
                }
                int i114 = iM5;
                j3 += (long) iArr7[i5];
                i8--;
                i5++;
                eVar = eVar;
                jArr5 = jArr5;
                i11 = i114;
                i7 = i113;
                i4 = i111;
            }
            int i115 = i4;
            int i210 = i11;
            int i211 = i7;
            long[] jArr10 = jArr5;
            j = j2 + ((long) i211);
            if (iM3 == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            com.anythink.basead.exoplayer.k.a.a(z3);
            while (i10 > 0) {
                if (sVar6.m() == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                com.anythink.basead.exoplayer.k.a.a(z4);
                sVar6.i();
                i10--;
            }
            if (i9 == 0) {
                i12 = i8;
                jVar2 = jVar;
                String str6 = "Inconsistent stbl box for track " + jVar2.c + ": remainingSynchronizationSamples " + i9 + ", remainingSamplesAtTimestampDelta " + i210 + ", remainingSamplesInChunk " + i12 + ", remainingTimestampDeltaChanges " + i115;
                str = a;
                Log.w(str, str6);
            } else {
                i12 = i8;
                jVar2 = jVar;
                String str7 = "Inconsistent stbl box for track " + jVar2.c + ": remainingSynchronizationSamples " + i9 + ", remainingSamplesAtTimestampDelta " + i210 + ", remainingSamplesInChunk " + i12 + ", remainingTimestampDeltaChanges " + i115;
                str = a;
                Log.w(str, str7);
            }
            iArr2 = iArr7;
            jArr2 = jArr10;
            jArr3 = jArr6;
            i2 = i6;
        } else {
            jVar2 = jVar;
            str = a;
            jArr = new long[aVar.a];
            iArr = new int[aVar.a];
            while (aVar.a()) {
                jArr[aVar.b] = aVar.d;
                iArr[aVar.b] = aVar.c;
            }
            com.anythink.basead.exoplayer.e.a.d.a aVarA2 = com.anythink.basead.exoplayer.e.a.d.a(af.b(jVar2.h.w, jVar2.h.u), jArr, iArr, iM8);
            jArr2 = aVarA2.a;
            iArr2 = aVarA2.b;
            i2 = aVarA2.c;
            jArr3 = aVarA2.d;
            iArr3 = aVarA2.e;
            j = aVarA2.f;
        }
        jA = af.a(j, 1000000L, jVar2.e);
        if (jVar2.j != null) {
        }
        af.a(jArr3, jVar2.e);
        return new m(jVar, jArr2, iArr2, i2, jArr3, iArr3, jA);
    }

    public static com.anythink.basead.exoplayer.g.a a(com.anythink.basead.exoplayer.e.a.a.b bVar, boolean z) {
        if (z) {
            return null;
        }
        s sVar = bVar.aV;
        sVar.c(8);
        while (sVar.a() >= 8) {
            int iC = sVar.c();
            int i2 = sVar.i();
            if (sVar.i() == com.anythink.basead.exoplayer.e.a.a.aG) {
                sVar.c(iC);
                int i3 = iC + i2;
                sVar.d(12);
                while (sVar.c() < i3) {
                    int iC2 = sVar.c();
                    int i4 = sVar.i();
                    if (sVar.i() == com.anythink.basead.exoplayer.e.a.a.aH) {
                        sVar.c(iC2);
                        int i5 = iC2 + i4;
                        sVar.d(8);
                        ArrayList arrayList = new ArrayList();
                        while (sVar.c() < i5) {
                            com.anythink.basead.exoplayer.g.a.InterfaceC0027a interfaceC0027aA = com.anythink.basead.exoplayer.e.a.f.a(sVar);
                            if (interfaceC0027aA != null) {
                                arrayList.add(interfaceC0027aA);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            break;
                        }
                        return new com.anythink.basead.exoplayer.g.a(arrayList);
                    }
                    sVar.d(i4 - 8);
                }
                return null;
            }
            sVar.d(i2 - 8);
        }
        return null;
    }

    private static com.anythink.basead.exoplayer.g.a a(s sVar, int i2) {
        sVar.d(12);
        while (sVar.c() < i2) {
            int iC = sVar.c();
            int i3 = sVar.i();
            if (sVar.i() == com.anythink.basead.exoplayer.e.a.a.aH) {
                sVar.c(iC);
                int i4 = iC + i3;
                sVar.d(8);
                ArrayList arrayList = new ArrayList();
                while (sVar.c() < i4) {
                    com.anythink.basead.exoplayer.g.a.InterfaceC0027a interfaceC0027aA = com.anythink.basead.exoplayer.e.a.f.a(sVar);
                    if (interfaceC0027aA != null) {
                        arrayList.add(interfaceC0027aA);
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new com.anythink.basead.exoplayer.g.a(arrayList);
            }
            sVar.d(i3 - 8);
        }
        return null;
    }

    private static com.anythink.basead.exoplayer.g.a b(s sVar, int i2) {
        sVar.d(8);
        ArrayList arrayList = new ArrayList();
        while (sVar.c() < i2) {
            com.anythink.basead.exoplayer.g.a.InterfaceC0027a interfaceC0027aA = com.anythink.basead.exoplayer.e.a.f.a(sVar);
            if (interfaceC0027aA != null) {
                arrayList.add(interfaceC0027aA);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.anythink.basead.exoplayer.g.a(arrayList);
    }

    private static long a(s sVar) {
        sVar.c(8);
        sVar.d(com.anythink.basead.exoplayer.e.a.a.a(sVar.i()) != 0 ? 16 : 8);
        return sVar.h();
    }

    private static f b(s sVar) {
        boolean z;
        sVar.c(8);
        int iA = com.anythink.basead.exoplayer.e.a.a.a(sVar.i());
        sVar.d(iA == 0 ? 8 : 16);
        int i2 = sVar.i();
        sVar.d(4);
        int iC = sVar.c();
        int i3 = iA == 0 ? 4 : 8;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 >= i3) {
                z = true;
                break;
            }
            if (sVar.a[iC + i5] != -1) {
                z = false;
                break;
            }
            i5++;
        }
        long j = -9223372036854775807L;
        if (z) {
            sVar.d(i3);
        } else {
            long jH = iA == 0 ? sVar.h() : sVar.n();
            if (jH != 0) {
                j = jH;
            }
        }
        sVar.d(16);
        int i6 = sVar.i();
        int i7 = sVar.i();
        sVar.d(4);
        int i8 = sVar.i();
        int i9 = sVar.i();
        if (i6 == 0 && i7 == 65536 && i8 == -65536 && i9 == 0) {
            i4 = 90;
        } else if (i6 == 0 && i7 == -65536 && i8 == 65536 && i9 == 0) {
            i4 = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        } else if (i6 == -65536 && i7 == 0 && i8 == 0 && i9 == -65536) {
            i4 = 180;
        }
        return new f(i2, j, i4);
    }

    private static int c(s sVar) {
        sVar.c(16);
        int i2 = sVar.i();
        if (i2 == c) {
            return 1;
        }
        if (i2 == b) {
            return 2;
        }
        if (i2 == d || i2 == e || i2 == f || i2 == g) {
            return 3;
        }
        return i2 == h ? 4 : -1;
    }

    private static Pair<Long, String> d(s sVar) {
        sVar.c(8);
        int iA = com.anythink.basead.exoplayer.e.a.a.a(sVar.i());
        sVar.d(iA == 0 ? 8 : 16);
        long jH = sVar.h();
        sVar.d(iA == 0 ? 4 : 8);
        int iE = sVar.e();
        return Pair.create(Long.valueOf(jH), new StringBuilder().append((char) (((iE >> 10) & 31) + 96)).append((char) (((iE >> 5) & 31) + 96)).append((char) ((iE & 31) + 96)).toString());
    }

    /* JADX WARN: Code duplicated, block: B:198:0x0311  */
    /* JADX WARN: Code duplicated, block: B:200:0x0327  */
    /* JADX WARN: Code duplicated, block: B:201:0x0340  */
    /* JADX WARN: Multi-variable type inference failed */
    private static c a(s sVar, int i2, int i3, String str, com.anythink.basead.exoplayer.d.e eVar, boolean z) throws t {
        int i4;
        int i5;
        int i6;
        int i7;
        com.anythink.basead.exoplayer.d.e eVar2;
        byte[] bArrCopyOfRange;
        String str2;
        List<byte[]> list;
        String str3;
        com.anythink.basead.exoplayer.d.e eVarA;
        int iE;
        int iK;
        int iM;
        com.anythink.basead.exoplayer.d.e eVar3;
        String str4;
        String str5;
        String str6;
        com.anythink.basead.exoplayer.d.e eVar4;
        int i8;
        int i9;
        int i10;
        int iC;
        int i11;
        String str7;
        String str8;
        int i12;
        String str9;
        com.anythink.basead.exoplayer.d.e eVarA2;
        String str10;
        String str11;
        List list2;
        sVar.c(12);
        int i13 = sVar.i();
        c cVar = new c(i13);
        int i14 = 0;
        int i15 = 0;
        while (i15 < i13) {
            int iC2 = sVar.c();
            int i16 = sVar.i();
            boolean z2 = true;
            String str12 = "childAtomSize should be positive";
            com.anythink.basead.exoplayer.k.a.a(i16 > 0 ? 1 : i14, "childAtomSize should be positive");
            int i17 = sVar.i();
            if (i17 != com.anythink.basead.exoplayer.e.a.a.g && i17 != com.anythink.basead.exoplayer.e.a.a.h && i17 != com.anythink.basead.exoplayer.e.a.a.ae && i17 != com.anythink.basead.exoplayer.e.a.a.aq && i17 != com.anythink.basead.exoplayer.e.a.a.i && i17 != com.anythink.basead.exoplayer.e.a.a.j && i17 != com.anythink.basead.exoplayer.e.a.a.k && i17 != com.anythink.basead.exoplayer.e.a.a.aP && i17 != com.anythink.basead.exoplayer.e.a.a.aQ) {
                if (i17 != com.anythink.basead.exoplayer.e.a.a.n && i17 != com.anythink.basead.exoplayer.e.a.a.af && i17 != com.anythink.basead.exoplayer.e.a.a.s && i17 != com.anythink.basead.exoplayer.e.a.a.u && i17 != com.anythink.basead.exoplayer.e.a.a.w && i17 != com.anythink.basead.exoplayer.e.a.a.z && i17 != com.anythink.basead.exoplayer.e.a.a.x && i17 != com.anythink.basead.exoplayer.e.a.a.y && i17 != com.anythink.basead.exoplayer.e.a.a.aD && i17 != com.anythink.basead.exoplayer.e.a.a.aE && i17 != com.anythink.basead.exoplayer.e.a.a.q && i17 != com.anythink.basead.exoplayer.e.a.a.r && i17 != com.anythink.basead.exoplayer.e.a.a.o && i17 != com.anythink.basead.exoplayer.e.a.a.aT) {
                    if (i17 != com.anythink.basead.exoplayer.e.a.a.ao && i17 != com.anythink.basead.exoplayer.e.a.a.az && i17 != com.anythink.basead.exoplayer.e.a.a.aA && i17 != com.anythink.basead.exoplayer.e.a.a.aB && i17 != com.anythink.basead.exoplayer.e.a.a.aC) {
                        if (i17 == com.anythink.basead.exoplayer.e.a.a.aS) {
                            cVar.c = com.anythink.basead.exoplayer.m.a(Integer.toString(i2), o.ah, (String) null, (com.anythink.basead.exoplayer.d.e) null);
                        }
                        i4 = i15;
                        i5 = iC2;
                        i6 = i13;
                        i7 = i16;
                    } else {
                        sVar.c(iC2 + 8 + 8);
                        long j = Long.MAX_VALUE;
                        if (i17 == com.anythink.basead.exoplayer.e.a.a.ao) {
                            list2 = null;
                            str11 = o.Z;
                        } else if (i17 == com.anythink.basead.exoplayer.e.a.a.az) {
                            int i18 = (i16 - 8) - 8;
                            byte[] bArr = new byte[i18];
                            sVar.a(bArr, i14, i18);
                            List listSingletonList = Collections.singletonList(bArr);
                            str11 = o.aa;
                            list2 = listSingletonList;
                        } else {
                            if (i17 == com.anythink.basead.exoplayer.e.a.a.aA) {
                                str10 = o.ab;
                            } else if (i17 == com.anythink.basead.exoplayer.e.a.a.aB) {
                                j = 0;
                                list2 = null;
                                str11 = o.Z;
                            } else if (i17 == com.anythink.basead.exoplayer.e.a.a.aC) {
                                cVar.e = 1;
                                str10 = o.ac;
                            } else {
                                throw new IllegalStateException();
                            }
                            str11 = str10;
                            list2 = null;
                        }
                        i4 = i15;
                        i6 = i13;
                        cVar.c = com.anythink.basead.exoplayer.m.a(Integer.toString(i2), str11, (String) null, -1, 0, str, -1, (com.anythink.basead.exoplayer.d.e) null, j, (List<byte[]>) list2);
                        i7 = i16;
                        i5 = iC2;
                    }
                } else {
                    i4 = i15;
                    i6 = i13;
                    int i19 = i14;
                    i5 = iC2;
                    sVar.c(i5 + 8 + 8);
                    if (z) {
                        iE = sVar.e();
                        sVar.d(6);
                    } else {
                        sVar.d(8);
                        iE = i19;
                    }
                    if (iE == 0 || iE == 1) {
                        int iE2 = sVar.e();
                        sVar.d(6);
                        iK = sVar.k();
                        if (iE == 1) {
                            sVar.d(16);
                        }
                        iM = iE2;
                    } else if (iE == 2) {
                        sVar.d(16);
                        iK = (int) Math.round(Double.longBitsToDouble(sVar.j()));
                        iM = sVar.m();
                        sVar.d(20);
                    } else {
                        i7 = i16;
                    }
                    int iC3 = sVar.c();
                    if (i17 == com.anythink.basead.exoplayer.e.a.a.af) {
                        Pair<Integer, k> pairB = b(sVar, i5, i16);
                        if (pairB != null) {
                            i17 = ((Integer) pairB.first).intValue();
                            eVarA2 = eVar != null ? eVar.a(((k) pairB.second).b) : null;
                            cVar.b[i4] = (k) pairB.second;
                        } else {
                            eVarA2 = eVar;
                        }
                        sVar.c(iC3);
                        eVar3 = eVarA2;
                    } else {
                        eVar3 = eVar;
                    }
                    int i20 = com.anythink.basead.exoplayer.e.a.a.s;
                    String str13 = o.w;
                    if (i17 == i20) {
                        str4 = o.z;
                    } else if (i17 == com.anythink.basead.exoplayer.e.a.a.u) {
                        str4 = o.A;
                    } else if (i17 == com.anythink.basead.exoplayer.e.a.a.w) {
                        str4 = o.D;
                    } else if (i17 == com.anythink.basead.exoplayer.e.a.a.x || i17 == com.anythink.basead.exoplayer.e.a.a.y) {
                        str4 = o.E;
                    } else if (i17 == com.anythink.basead.exoplayer.e.a.a.z) {
                        str4 = o.F;
                    } else if (i17 == com.anythink.basead.exoplayer.e.a.a.aD) {
                        str4 = o.I;
                    } else if (i17 == com.anythink.basead.exoplayer.e.a.a.aE) {
                        str4 = o.J;
                    } else if (i17 == com.anythink.basead.exoplayer.e.a.a.q || i17 == com.anythink.basead.exoplayer.e.a.a.r) {
                        str4 = o.w;
                    } else if (i17 == com.anythink.basead.exoplayer.e.a.a.o) {
                        str4 = o.t;
                    } else {
                        str4 = i17 == com.anythink.basead.exoplayer.e.a.a.aT ? o.L : null;
                    }
                    int i21 = iK;
                    int iIntValue = iM;
                    int i22 = iC3;
                    byte[] bArr2 = null;
                    String str14 = str4;
                    while (i22 - i5 < i16) {
                        sVar.c(i22);
                        int i23 = sVar.i();
                        com.anythink.basead.exoplayer.k.a.a(i23 > 0 ? z2 : i19, str12);
                        int i24 = sVar.i();
                        if (i24 == com.anythink.basead.exoplayer.e.a.a.O || (z && i24 == com.anythink.basead.exoplayer.e.a.a.p)) {
                            str5 = str13;
                            str6 = str12;
                            String str15 = str14;
                            eVar4 = eVar3;
                            i8 = i19;
                            i9 = i23;
                            i10 = i22;
                            if (i24 == com.anythink.basead.exoplayer.e.a.a.O) {
                                iC = i10;
                                str6 = str6;
                            } else {
                                iC = sVar.c();
                                while (true) {
                                    if (iC - i10 >= i9) {
                                        str6 = str6;
                                        i11 = -1;
                                        iC = -1;
                                        break;
                                    }
                                    sVar.c(iC);
                                    int i25 = sVar.i();
                                    com.anythink.basead.exoplayer.k.a.a(i25 > 0 ? 1 : i8, str6);
                                    if (sVar.i() != com.anythink.basead.exoplayer.e.a.a.O) {
                                        iC += i25;
                                        str6 = str6;
                                    }
                                }
                                if (iC != i11) {
                                    Pair<String, byte[]> pairD = d(sVar, iC);
                                    str7 = (String) pairD.first;
                                    bArr2 = (byte[]) pairD.second;
                                    if (o.r.equals(str7)) {
                                        Pair<Integer, Integer> pairA = com.anythink.basead.exoplayer.k.d.a(bArr2);
                                        int iIntValue2 = ((Integer) pairA.first).intValue();
                                        iIntValue = ((Integer) pairA.second).intValue();
                                        i21 = iIntValue2;
                                    }
                                } else {
                                    str7 = str15;
                                }
                                str8 = str7;
                            }
                            i11 = -1;
                            if (iC != i11) {
                                Pair<String, byte[]> pairD2 = d(sVar, iC);
                                str7 = (String) pairD2.first;
                                bArr2 = (byte[]) pairD2.second;
                                if (o.r.equals(str7)) {
                                    Pair<Integer, Integer> pairA2 = com.anythink.basead.exoplayer.k.d.a(bArr2);
                                    int iIntValue3 = ((Integer) pairA2.first).intValue();
                                    iIntValue = ((Integer) pairA2.second).intValue();
                                    i21 = iIntValue3;
                                }
                            } else {
                                str7 = str15;
                            }
                            str8 = str7;
                        } else {
                            if (i24 == com.anythink.basead.exoplayer.e.a.a.t) {
                                sVar.c(i22 + 8);
                                cVar.c = com.anythink.basead.exoplayer.b.a.a(sVar, Integer.toString(i2), str, eVar3);
                            } else {
                                if (i24 == com.anythink.basead.exoplayer.e.a.a.v) {
                                    sVar.c(i22 + 8);
                                    cVar.c = com.anythink.basead.exoplayer.b.a.b(sVar, Integer.toString(i2), str, eVar3);
                                } else {
                                    if (i24 == com.anythink.basead.exoplayer.e.a.a.A) {
                                        i9 = i23;
                                        i12 = i22;
                                        str5 = str13;
                                        str9 = str12;
                                        str8 = str14;
                                        eVar4 = eVar3;
                                        cVar.c = com.anythink.basead.exoplayer.m.a(Integer.toString(i2), str14, null, -1, iIntValue, i21, null, eVar3, str);
                                    } else {
                                        i9 = i23;
                                        i12 = i22;
                                        str5 = str13;
                                        str9 = str12;
                                        str8 = str14;
                                        eVar4 = eVar3;
                                        if (i24 == com.anythink.basead.exoplayer.e.a.a.aT) {
                                            byte[] bArr3 = new byte[i9];
                                            i10 = i12;
                                            sVar.c(i10);
                                            i8 = 0;
                                            sVar.a(bArr3, 0, i9);
                                            bArr2 = bArr3;
                                        }
                                    }
                                    i10 = i12;
                                    i8 = 0;
                                }
                                str6 = str9;
                            }
                            str5 = str13;
                            str9 = str12;
                            str8 = str14;
                            eVar4 = eVar3;
                            i8 = i19;
                            i9 = i23;
                            i10 = i22;
                            str6 = str9;
                        }
                        i22 = i10 + i9;
                        str12 = str6;
                        i19 = i8;
                        eVar3 = eVar4;
                        str13 = str5;
                        str14 = str8;
                        z2 = true;
                    }
                    String str16 = str13;
                    String str17 = str14;
                    com.anythink.basead.exoplayer.d.e eVar5 = eVar3;
                    if (cVar.c != null || str17 == null) {
                        i7 = i16;
                    } else {
                        i7 = i16;
                        cVar.c = com.anythink.basead.exoplayer.m.a(Integer.toString(i2), str17, (String) null, -1, iIntValue, i21, str16.equals(str17) ? 2 : -1, (List<byte[]>) (bArr2 == null ? null : Collections.singletonList(bArr2)), eVar5, str);
                    }
                }
            } else {
                i4 = i15;
                i5 = iC2;
                i6 = i13;
                i7 = i16;
                sVar.c(i5 + 8 + 8);
                sVar.d(16);
                int iE3 = sVar.e();
                int iE4 = sVar.e();
                sVar.d(50);
                int iC4 = sVar.c();
                if (i17 == com.anythink.basead.exoplayer.e.a.a.ae) {
                    Pair<Integer, k> pairB2 = b(sVar, i5, i7);
                    if (pairB2 != null) {
                        i17 = ((Integer) pairB2.first).intValue();
                        eVarA = eVar == null ? null : eVar.a(((k) pairB2.second).b);
                        cVar.b[i4] = (k) pairB2.second;
                    } else {
                        eVarA = eVar;
                    }
                    sVar.c(iC4);
                    eVar2 = eVarA;
                } else {
                    eVar2 = eVar;
                }
                int i26 = -1;
                float fM = 1.0f;
                String str18 = null;
                List<byte[]> listSingletonList2 = null;
                byte[] bArr4 = null;
                boolean z3 = false;
                while (iC4 - i5 < i7) {
                    sVar.c(iC4);
                    int iC5 = sVar.c();
                    int i27 = sVar.i();
                    if (i27 == 0 && sVar.c() - i5 == i7) {
                        break;
                    }
                    com.anythink.basead.exoplayer.k.a.a(i27 > 0, "childAtomSize should be positive");
                    int i28 = sVar.i();
                    if (i28 == com.anythink.basead.exoplayer.e.a.a.M) {
                        com.anythink.basead.exoplayer.k.a.b(str18 == null);
                        sVar.c(iC5 + 8);
                        com.anythink.basead.exoplayer.l.a aVarA = com.anythink.basead.exoplayer.l.a.a(sVar);
                        list = aVarA.a;
                        cVar.d = aVarA.b;
                        if (!z3) {
                            fM = aVarA.e;
                        }
                        str3 = o.h;
                    } else {
                        if (i28 == com.anythink.basead.exoplayer.e.a.a.N) {
                            com.anythink.basead.exoplayer.k.a.b(str18 == null);
                            sVar.c(iC5 + 8);
                            com.anythink.basead.exoplayer.l.d dVarA = com.anythink.basead.exoplayer.l.d.a(sVar);
                            list = dVarA.a;
                            cVar.d = dVarA.b;
                            str3 = o.i;
                        } else {
                            if (i28 == com.anythink.basead.exoplayer.e.a.a.aR) {
                                com.anythink.basead.exoplayer.k.a.b(str18 == null);
                                str2 = i17 == com.anythink.basead.exoplayer.e.a.a.aP ? o.j : o.k;
                            } else if (i28 == com.anythink.basead.exoplayer.e.a.a.l) {
                                com.anythink.basead.exoplayer.k.a.b(str18 == null);
                                str2 = o.g;
                            } else if (i28 == com.anythink.basead.exoplayer.e.a.a.O) {
                                com.anythink.basead.exoplayer.k.a.b(str18 == null);
                                Pair<String, byte[]> pairD3 = d(sVar, iC5);
                                String str19 = (String) pairD3.first;
                                listSingletonList2 = Collections.singletonList((byte[]) pairD3.second);
                                str18 = str19;
                            } else if (i28 != com.anythink.basead.exoplayer.e.a.a.an) {
                                if (i28 == com.anythink.basead.exoplayer.e.a.a.aN) {
                                    int i29 = iC5 + 8;
                                    while (true) {
                                        if (i29 - iC5 >= i27) {
                                            bArrCopyOfRange = null;
                                            break;
                                        }
                                        sVar.c(i29);
                                        int i30 = sVar.i();
                                        if (sVar.i() == com.anythink.basead.exoplayer.e.a.a.aO) {
                                            bArrCopyOfRange = Arrays.copyOfRange(sVar.a, i29, i30 + i29);
                                            break;
                                        }
                                        i29 += i30;
                                    }
                                    bArr4 = bArrCopyOfRange;
                                } else if (i28 == com.anythink.basead.exoplayer.e.a.a.aM) {
                                    int iD = sVar.d();
                                    sVar.d(3);
                                    if (iD == 0) {
                                        int iD2 = sVar.d();
                                        if (iD2 == 0) {
                                            i26 = 0;
                                        } else if (iD2 == 1) {
                                            i26 = 1;
                                        } else if (iD2 == 2) {
                                            i26 = 2;
                                        } else if (iD2 == 3) {
                                            i26 = 3;
                                        }
                                    }
                                }
                            } else {
                                sVar.c(iC5 + 8);
                                fM = sVar.m() / sVar.m();
                                z3 = true;
                            }
                            str18 = str2;
                        }
                        iC4 += i27;
                    }
                    str18 = str3;
                    listSingletonList2 = list;
                    iC4 += i27;
                }
                if (str18 != null) {
                    cVar.c = com.anythink.basead.exoplayer.m.a(Integer.toString(i2), str18, null, -1, -1, iE3, iE4, -1.0f, listSingletonList2, i3, fM, bArr4, i26, null, eVar2);
                }
            }
            sVar.c(i5 + i7);
            i15 = i4 + 1;
            i13 = i6;
            i14 = 0;
        }
        return cVar;
    }

    private static void a(s sVar, int i2, int i3, int i4, int i5, String str, c cVar) {
        sVar.c(i3 + 8 + 8);
        int i6 = com.anythink.basead.exoplayer.e.a.a.ao;
        String str2 = o.Z;
        List listSingletonList = null;
        long j = Long.MAX_VALUE;
        if (i2 != i6) {
            if (i2 == com.anythink.basead.exoplayer.e.a.a.az) {
                int i7 = (i4 - 8) - 8;
                byte[] bArr = new byte[i7];
                sVar.a(bArr, 0, i7);
                listSingletonList = Collections.singletonList(bArr);
                str2 = o.aa;
            } else if (i2 == com.anythink.basead.exoplayer.e.a.a.aA) {
                str2 = o.ab;
            } else if (i2 == com.anythink.basead.exoplayer.e.a.a.aB) {
                j = 0;
            } else if (i2 == com.anythink.basead.exoplayer.e.a.a.aC) {
                cVar.e = 1;
                str2 = o.ac;
            } else {
                throw new IllegalStateException();
            }
        }
        cVar.c = com.anythink.basead.exoplayer.m.a(Integer.toString(i5), str2, (String) null, -1, 0, str, -1, (com.anythink.basead.exoplayer.d.e) null, j, (List<byte[]>) listSingletonList);
    }

    private static void a(s sVar, int i2, int i3, int i4, int i5, int i6, com.anythink.basead.exoplayer.d.e eVar, c cVar, int i7) throws t {
        int i8 = i3;
        com.anythink.basead.exoplayer.d.e eVarA = eVar;
        sVar.c(i8 + 8 + 8);
        sVar.d(16);
        int iE = sVar.e();
        int iE2 = sVar.e();
        sVar.d(50);
        int iC = sVar.c();
        int iIntValue = i2;
        if (iIntValue == com.anythink.basead.exoplayer.e.a.a.ae) {
            Pair<Integer, k> pairB = b(sVar, i8, i4);
            if (pairB != null) {
                iIntValue = ((Integer) pairB.first).intValue();
                eVarA = eVarA == null ? null : eVarA.a(((k) pairB.second).b);
                cVar.b[i7] = (k) pairB.second;
            }
            sVar.c(iC);
        }
        com.anythink.basead.exoplayer.d.e eVar2 = eVarA;
        float fM = 1.0f;
        int i9 = -1;
        boolean z = false;
        String str = null;
        List<byte[]> listSingletonList = null;
        byte[] bArrCopyOfRange = null;
        while (iC - i8 < i4) {
            sVar.c(iC);
            int iC2 = sVar.c();
            int i10 = sVar.i();
            if (i10 == 0 && sVar.c() - i8 == i4) {
                break;
            }
            com.anythink.basead.exoplayer.k.a.a(i10 > 0, "childAtomSize should be positive");
            int i11 = sVar.i();
            if (i11 == com.anythink.basead.exoplayer.e.a.a.M) {
                com.anythink.basead.exoplayer.k.a.b(str == null);
                sVar.c(iC2 + 8);
                com.anythink.basead.exoplayer.l.a aVarA = com.anythink.basead.exoplayer.l.a.a(sVar);
                listSingletonList = aVarA.a;
                cVar.d = aVarA.b;
                if (!z) {
                    fM = aVarA.e;
                }
                str = o.h;
            } else if (i11 == com.anythink.basead.exoplayer.e.a.a.N) {
                com.anythink.basead.exoplayer.k.a.b(str == null);
                sVar.c(iC2 + 8);
                com.anythink.basead.exoplayer.l.d dVarA = com.anythink.basead.exoplayer.l.d.a(sVar);
                listSingletonList = dVarA.a;
                cVar.d = dVarA.b;
                str = o.i;
            } else if (i11 == com.anythink.basead.exoplayer.e.a.a.aR) {
                com.anythink.basead.exoplayer.k.a.b(str == null);
                str = iIntValue == com.anythink.basead.exoplayer.e.a.a.aP ? o.j : o.k;
            } else if (i11 == com.anythink.basead.exoplayer.e.a.a.l) {
                com.anythink.basead.exoplayer.k.a.b(str == null);
                str = o.g;
            } else if (i11 == com.anythink.basead.exoplayer.e.a.a.O) {
                com.anythink.basead.exoplayer.k.a.b(str == null);
                Pair<String, byte[]> pairD = d(sVar, iC2);
                str = (String) pairD.first;
                listSingletonList = Collections.singletonList((byte[]) pairD.second);
            } else if (i11 != com.anythink.basead.exoplayer.e.a.a.an) {
                if (i11 == com.anythink.basead.exoplayer.e.a.a.aN) {
                    int i12 = iC2 + 8;
                    while (true) {
                        if (i12 - iC2 >= i10) {
                            bArrCopyOfRange = null;
                            break;
                        }
                        sVar.c(i12);
                        int i13 = sVar.i();
                        if (sVar.i() == com.anythink.basead.exoplayer.e.a.a.aO) {
                            bArrCopyOfRange = Arrays.copyOfRange(sVar.a, i12, i13 + i12);
                            break;
                        }
                        i12 += i13;
                    }
                } else if (i11 == com.anythink.basead.exoplayer.e.a.a.aM) {
                    int iD = sVar.d();
                    sVar.d(3);
                    if (iD == 0) {
                        int iD2 = sVar.d();
                        if (iD2 == 0) {
                            i9 = 0;
                        } else if (iD2 == 1) {
                            i9 = 1;
                        } else if (iD2 == 2) {
                            i9 = 2;
                        } else if (iD2 == 3) {
                            i9 = 3;
                        }
                    }
                }
            } else {
                sVar.c(iC2 + 8);
                fM = sVar.m() / sVar.m();
                z = true;
            }
            iC += i10;
            i8 = i3;
        }
        if (str == null) {
            return;
        }
        cVar.c = com.anythink.basead.exoplayer.m.a(Integer.toString(i5), str, null, -1, -1, iE, iE2, -1.0f, listSingletonList, i6, fM, bArrCopyOfRange, i9, null, eVar2);
    }

    private static Pair<long[], long[]> a(com.anythink.basead.exoplayer.e.a.a.C0023a c0023a) {
        com.anythink.basead.exoplayer.e.a.a.b bVarD;
        if (c0023a == null || (bVarD = c0023a.d(com.anythink.basead.exoplayer.e.a.a.V)) == null) {
            return Pair.create(null, null);
        }
        s sVar = bVarD.aV;
        sVar.c(8);
        int iA = com.anythink.basead.exoplayer.e.a.a.a(sVar.i());
        int iM = sVar.m();
        long[] jArr = new long[iM];
        long[] jArr2 = new long[iM];
        for (int i2 = 0; i2 < iM; i2++) {
            jArr[i2] = iA == 1 ? sVar.n() : sVar.h();
            jArr2[i2] = iA == 1 ? sVar.j() : sVar.i();
            if (sVar.f() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            sVar.d(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static float c(s sVar, int i2) {
        sVar.c(i2 + 8);
        return sVar.m() / sVar.m();
    }

    private static void a(s sVar, int i2, int i3, int i4, int i5, String str, boolean z, com.anythink.basead.exoplayer.d.e eVar, c cVar, int i6) {
        int iE;
        int iK;
        int iM;
        String str2;
        int i7;
        int i8;
        String str3;
        String str4;
        com.anythink.basead.exoplayer.d.e eVar2;
        boolean z2;
        int iC;
        com.anythink.basead.exoplayer.d.e eVarA = eVar;
        sVar.c(i3 + 8 + 8);
        if (z) {
            iE = sVar.e();
            sVar.d(6);
        } else {
            sVar.d(8);
            iE = 0;
        }
        boolean z3 = true;
        if (iE == 0 || iE == 1) {
            int iE2 = sVar.e();
            sVar.d(6);
            iK = sVar.k();
            if (iE == 1) {
                sVar.d(16);
            }
            iM = iE2;
        } else {
            if (iE != 2) {
                return;
            }
            sVar.d(16);
            iK = (int) Math.round(Double.longBitsToDouble(sVar.j()));
            iM = sVar.m();
            sVar.d(20);
        }
        int iC2 = sVar.c();
        int iIntValue = i2;
        if (iIntValue == com.anythink.basead.exoplayer.e.a.a.af) {
            Pair<Integer, k> pairB = b(sVar, i3, i4);
            if (pairB != null) {
                iIntValue = ((Integer) pairB.first).intValue();
                eVarA = eVarA == null ? null : eVarA.a(((k) pairB.second).b);
                cVar.b[i6] = (k) pairB.second;
            }
            sVar.c(iC2);
        }
        com.anythink.basead.exoplayer.d.e eVar3 = eVarA;
        int i9 = com.anythink.basead.exoplayer.e.a.a.s;
        String str5 = o.w;
        if (iIntValue == i9) {
            str2 = o.z;
        } else if (iIntValue == com.anythink.basead.exoplayer.e.a.a.u) {
            str2 = o.A;
        } else if (iIntValue == com.anythink.basead.exoplayer.e.a.a.w) {
            str2 = o.D;
        } else if (iIntValue == com.anythink.basead.exoplayer.e.a.a.x || iIntValue == com.anythink.basead.exoplayer.e.a.a.y) {
            str2 = o.E;
        } else if (iIntValue == com.anythink.basead.exoplayer.e.a.a.z) {
            str2 = o.F;
        } else if (iIntValue == com.anythink.basead.exoplayer.e.a.a.aD) {
            str2 = o.I;
        } else if (iIntValue == com.anythink.basead.exoplayer.e.a.a.aE) {
            str2 = o.J;
        } else if (iIntValue == com.anythink.basead.exoplayer.e.a.a.q || iIntValue == com.anythink.basead.exoplayer.e.a.a.r) {
            str2 = o.w;
        } else if (iIntValue == com.anythink.basead.exoplayer.e.a.a.o) {
            str2 = o.t;
        } else {
            str2 = iIntValue == com.anythink.basead.exoplayer.e.a.a.aT ? o.L : null;
        }
        String str6 = str2;
        int i10 = iK;
        int iIntValue2 = iM;
        int i11 = iC2;
        byte[] bArr = null;
        while (i11 - i3 < i4) {
            sVar.c(i11);
            int i12 = sVar.i();
            com.anythink.basead.exoplayer.k.a.a(i12 > 0 ? z3 : false, "childAtomSize should be positive");
            int i13 = sVar.i();
            if (i13 == com.anythink.basead.exoplayer.e.a.a.O || (z && i13 == com.anythink.basead.exoplayer.e.a.a.p)) {
                i7 = i12;
                i8 = i11;
                str3 = str6;
                str4 = str5;
                eVar2 = eVar3;
                z2 = true;
                if (i13 != com.anythink.basead.exoplayer.e.a.a.O) {
                    iC = sVar.c();
                    while (true) {
                        if (iC - i8 >= i7) {
                            iC = -1;
                            break;
                        }
                        sVar.c(iC);
                        int i14 = sVar.i();
                        com.anythink.basead.exoplayer.k.a.a(i14 > 0, "childAtomSize should be positive");
                        if (sVar.i() == com.anythink.basead.exoplayer.e.a.a.O) {
                            break;
                        } else {
                            iC += i14;
                        }
                    }
                } else {
                    iC = i8;
                }
                if (iC != -1) {
                    Pair<String, byte[]> pairD = d(sVar, iC);
                    String str7 = (String) pairD.first;
                    byte[] bArr2 = (byte[]) pairD.second;
                    if (o.r.equals(str7)) {
                        Pair<Integer, Integer> pairA = com.anythink.basead.exoplayer.k.d.a(bArr2);
                        int iIntValue3 = ((Integer) pairA.first).intValue();
                        bArr = bArr2;
                        str6 = str7;
                        iIntValue2 = ((Integer) pairA.second).intValue();
                        i10 = iIntValue3;
                    } else {
                        bArr = bArr2;
                        str6 = str7;
                    }
                }
                i11 = i8 + i7;
                z3 = z2;
                eVar3 = eVar2;
                str5 = str4;
            } else {
                if (i13 == com.anythink.basead.exoplayer.e.a.a.t) {
                    sVar.c(i11 + 8);
                    cVar.c = com.anythink.basead.exoplayer.b.a.a(sVar, Integer.toString(i5), str, eVar3);
                } else if (i13 == com.anythink.basead.exoplayer.e.a.a.v) {
                    sVar.c(i11 + 8);
                    cVar.c = com.anythink.basead.exoplayer.b.a.b(sVar, Integer.toString(i5), str, eVar3);
                } else if (i13 == com.anythink.basead.exoplayer.e.a.a.A) {
                    i7 = i12;
                    str3 = str6;
                    str4 = str5;
                    eVar2 = eVar3;
                    i8 = i11;
                    z2 = true;
                    cVar.c = com.anythink.basead.exoplayer.m.a(Integer.toString(i5), str6, null, -1, iIntValue2, i10, null, eVar3, str);
                } else {
                    i7 = i12;
                    i8 = i11;
                    str3 = str6;
                    str4 = str5;
                    eVar2 = eVar3;
                    z2 = true;
                    if (i13 == com.anythink.basead.exoplayer.e.a.a.aT) {
                        byte[] bArr3 = new byte[i7];
                        sVar.c(i8);
                        sVar.a(bArr3, 0, i7);
                        bArr = bArr3;
                    }
                }
                i7 = i12;
                i8 = i11;
                str3 = str6;
                str4 = str5;
                eVar2 = eVar3;
                z2 = true;
            }
            str6 = str3;
            i11 = i8 + i7;
            z3 = z2;
            eVar3 = eVar2;
            str5 = str4;
        }
        String str8 = str6;
        String str9 = str5;
        com.anythink.basead.exoplayer.d.e eVar4 = eVar3;
        if (cVar.c != null || str8 == null) {
            return;
        }
        cVar.c = com.anythink.basead.exoplayer.m.a(Integer.toString(i5), str8, (String) null, -1, iIntValue2, i10, str9.equals(str8) ? 2 : -1, (List<byte[]>) (bArr == null ? null : Collections.singletonList(bArr)), eVar4, str);
    }

    private static int a(s sVar, int i2, int i3) {
        int iC = sVar.c();
        while (iC - i2 < i3) {
            sVar.c(iC);
            int i4 = sVar.i();
            com.anythink.basead.exoplayer.k.a.a(i4 > 0, "childAtomSize should be positive");
            if (sVar.i() == com.anythink.basead.exoplayer.e.a.a.O) {
                return iC;
            }
            iC += i4;
        }
        return -1;
    }

    private static Pair<String, byte[]> d(s sVar, int i2) {
        sVar.c(i2 + 8 + 4);
        sVar.d(1);
        e(sVar);
        sVar.d(2);
        int iD = sVar.d();
        if ((iD & 128) != 0) {
            sVar.d(2);
        }
        if ((iD & 64) != 0) {
            sVar.d(sVar.e());
        }
        if ((iD & 32) != 0) {
            sVar.d(2);
        }
        sVar.d(1);
        e(sVar);
        String strA = o.a(sVar.d());
        if (o.t.equals(strA) || o.D.equals(strA) || o.E.equals(strA)) {
            return Pair.create(strA, null);
        }
        sVar.d(12);
        sVar.d(1);
        int iE = e(sVar);
        byte[] bArr = new byte[iE];
        sVar.a(bArr, 0, iE);
        return Pair.create(strA, bArr);
    }

    private static Pair<Integer, k> b(s sVar, int i2, int i3) {
        Pair<Integer, k> pairC;
        int iC = sVar.c();
        while (iC - i2 < i3) {
            sVar.c(iC);
            int i4 = sVar.i();
            com.anythink.basead.exoplayer.k.a.a(i4 > 0, "childAtomSize should be positive");
            if (sVar.i() == com.anythink.basead.exoplayer.e.a.a.aa && (pairC = c(sVar, iC, i4)) != null) {
                return pairC;
            }
            iC += i4;
        }
        return null;
    }

    private static Pair<Integer, k> c(s sVar, int i2, int i3) {
        int i4 = i2 + 8;
        int i5 = -1;
        int i6 = 0;
        String strO = null;
        Integer numValueOf = null;
        while (i4 - i2 < i3) {
            sVar.c(i4);
            int i7 = sVar.i();
            int i8 = sVar.i();
            if (i8 == com.anythink.basead.exoplayer.e.a.a.ag) {
                numValueOf = Integer.valueOf(sVar.i());
            } else if (i8 == com.anythink.basead.exoplayer.e.a.a.ab) {
                sVar.d(4);
                strO = sVar.o();
            } else if (i8 == com.anythink.basead.exoplayer.e.a.a.ac) {
                i5 = i4;
                i6 = i7;
            }
            i4 += i7;
        }
        if (!com.anythink.basead.exoplayer.b.bd.equals(strO) && !com.anythink.basead.exoplayer.b.be.equals(strO) && !com.anythink.basead.exoplayer.b.bf.equals(strO) && !com.anythink.basead.exoplayer.b.bg.equals(strO)) {
            return null;
        }
        com.anythink.basead.exoplayer.k.a.a(numValueOf != null, "frma atom is mandatory");
        com.anythink.basead.exoplayer.k.a.a(i5 != -1, "schi atom is mandatory");
        k kVarA = a(sVar, i5, i6, strO);
        com.anythink.basead.exoplayer.k.a.a(kVarA != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, kVarA);
    }

    private static k a(s sVar, int i2, int i3, String str) {
        int i4;
        int i5;
        int i6 = i2 + 8;
        while (true) {
            byte[] bArr = null;
            if (i6 - i2 >= i3) {
                return null;
            }
            sVar.c(i6);
            int i7 = sVar.i();
            if (sVar.i() == com.anythink.basead.exoplayer.e.a.a.ad) {
                int iA = com.anythink.basead.exoplayer.e.a.a.a(sVar.i());
                sVar.d(1);
                if (iA == 0) {
                    sVar.d(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int iD = sVar.d();
                    i4 = iD & 15;
                    i5 = (iD & MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA) >> 4;
                }
                boolean z = sVar.d() == 1;
                int iD2 = sVar.d();
                byte[] bArr2 = new byte[16];
                sVar.a(bArr2, 0, 16);
                if (z && iD2 == 0) {
                    int iD3 = sVar.d();
                    bArr = new byte[iD3];
                    sVar.a(bArr, 0, iD3);
                }
                return new k(z, str, iD2, bArr2, i5, i4, bArr);
            }
            i6 += i7;
        }
    }

    private static byte[] d(s sVar, int i2, int i3) {
        int i4 = i2 + 8;
        while (i4 - i2 < i3) {
            sVar.c(i4);
            int i5 = sVar.i();
            if (sVar.i() == com.anythink.basead.exoplayer.e.a.a.aO) {
                return Arrays.copyOfRange(sVar.a, i4, i5 + i4);
            }
            i4 += i5;
        }
        return null;
    }

    private static int e(s sVar) {
        int iD = sVar.d();
        int i2 = iD & 127;
        while ((iD & 128) == 128) {
            iD = sVar.d();
            i2 = (i2 << 7) | (iD & 127);
        }
        return i2;
    }

    private static boolean a(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[af.a(3, 0, length)] && jArr[af.a(jArr.length - 3, 0, length)] < j3 && j3 <= j;
    }

    private b() {
    }

    private static final class a {
        public final int a;
        public int b;
        public int c;
        public long d;
        private final boolean e;
        private final s f;
        private final s g;
        private int h;
        private int i;

        public a(s sVar, s sVar2, boolean z) {
            this.g = sVar;
            this.f = sVar2;
            this.e = z;
            sVar2.c(12);
            this.a = sVar2.m();
            sVar.c(12);
            this.i = sVar.m();
            com.anythink.basead.exoplayer.k.a.b(sVar.i() == 1, "first_chunk must be 1");
            this.b = -1;
        }

        public final boolean a() {
            int i = this.b + 1;
            this.b = i;
            if (i == this.a) {
                return false;
            }
            this.d = this.e ? this.f.n() : this.f.h();
            if (this.b == this.h) {
                this.c = this.g.m();
                this.g.d(4);
                int i2 = this.i - 1;
                this.i = i2;
                this.h = i2 > 0 ? this.g.m() - 1 : -1;
            }
            return true;
        }
    }

    private static final class f {
        private final int a;
        private final long b;
        private final int c;

        public f(int i, long j, int i2) {
            this.a = i;
            this.b = j;
            this.c = i2;
        }
    }

    private static final class c {
        public static final int a = 8;
        public final k[] b;
        public com.anythink.basead.exoplayer.m c;
        public int d;
        public int e = 0;

        public c(int i) {
            this.b = new k[i];
        }
    }

    static final class d implements InterfaceC0024b {
        private final int a;
        private final int b;
        private final s c;

        public d(com.anythink.basead.exoplayer.e.a.a.b bVar) {
            s sVar = bVar.aV;
            this.c = sVar;
            sVar.c(12);
            this.a = sVar.m();
            this.b = sVar.m();
        }

        @Override // com.anythink.basead.exoplayer.e.a.b.InterfaceC0024b
        public final int a() {
            return this.b;
        }

        @Override // com.anythink.basead.exoplayer.e.a.b.InterfaceC0024b
        public final int b() {
            int i = this.a;
            return i == 0 ? this.c.m() : i;
        }

        @Override // com.anythink.basead.exoplayer.e.a.b.InterfaceC0024b
        public final boolean c() {
            return this.a != 0;
        }
    }

    static final class e implements InterfaceC0024b {
        private final s a;
        private final int b;
        private final int c;
        private int d;
        private int e;

        @Override // com.anythink.basead.exoplayer.e.a.b.InterfaceC0024b
        public final boolean c() {
            return false;
        }

        public e(com.anythink.basead.exoplayer.e.a.a.b bVar) {
            s sVar = bVar.aV;
            this.a = sVar;
            sVar.c(12);
            this.c = sVar.m() & 255;
            this.b = sVar.m();
        }

        @Override // com.anythink.basead.exoplayer.e.a.b.InterfaceC0024b
        public final int a() {
            return this.b;
        }

        @Override // com.anythink.basead.exoplayer.e.a.b.InterfaceC0024b
        public final int b() {
            int i = this.c;
            if (i == 8) {
                return this.a.d();
            }
            if (i == 16) {
                return this.a.e();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 == 0) {
                int iD = this.a.d();
                this.e = iD;
                return (iD & MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA) >> 4;
            }
            return this.e & 15;
        }
    }
}

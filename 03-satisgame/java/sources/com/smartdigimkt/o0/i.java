package com.smartdigimkt.o0;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.i0.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {
    public static final int a = com.smartdigimkt.z0.u.a("vide");
    public static final int b = com.smartdigimkt.z0.u.a("soun");
    public static final int c = com.smartdigimkt.z0.u.a("text");
    public static final int d = com.smartdigimkt.z0.u.a("sbtl");
    public static final int e = com.smartdigimkt.z0.u.a("subt");
    public static final int f = com.smartdigimkt.z0.u.a("clcp");
    public static final int g = com.smartdigimkt.z0.u.a("meta");

    public static s a(a aVar, b bVar, long j, com.smartdigimkt.m0.d dVar, boolean z, boolean z2) throws y {
        int i;
        long jF;
        int i2;
        s sVar;
        long[] jArr;
        long[] jArr2;
        Pair pairCreate;
        b bVarC;
        int i3;
        com.smartdigimkt.m0.d dVar2;
        t[] tVarArr;
        char c2;
        char c3;
        int i4;
        int i5;
        String str;
        int i6;
        t[] tVarArr2;
        int iE;
        com.smartdigimkt.m0.d dVar3;
        int i7;
        int i8;
        int iH;
        int i9;
        com.smartdigimkt.m0.d dVar4;
        String str2;
        int i10;
        String str3;
        int iA;
        com.smartdigimkt.i0.s sVarA;
        int i11;
        String str4;
        long j2;
        List listSingletonList;
        String str5;
        a aVarB = aVar.b(c.F);
        com.smartdigimkt.z0.m mVar = aVarB.c(c.T).P0;
        mVar.c(16);
        int iA2 = mVar.a();
        if (iA2 == b) {
            i = 1;
        } else if (iA2 == a) {
            i = 2;
        } else if (iA2 == c || iA2 == d || iA2 == e || iA2 == f) {
            i = 3;
        } else {
            i = iA2 == g ? 4 : -1;
        }
        if (i == -1) {
            return null;
        }
        com.smartdigimkt.z0.m mVar2 = aVar.c(c.P).P0;
        mVar2.c(8);
        int iA3 = (mVar2.a() >> 24) & 255;
        mVar2.c(mVar2.b + (iA3 == 0 ? 8 : 16));
        int iA4 = mVar2.a();
        mVar2.c(mVar2.b + 4);
        int i12 = mVar2.b;
        int i13 = iA3 == 0 ? 4 : 8;
        int i14 = 0;
        while (true) {
            if (i14 >= i13) {
                mVar2.c(mVar2.b + i13);
            } else {
                if (mVar2.a[i12 + i14] != -1) {
                    jF = iA3 == 0 ? mVar2.f() : mVar2.i();
                    if (jF != 0) {
                        break;
                    }
                    break;
                }
                i14++;
            }
            jF = -9223372036854775807L;
            break;
        }
        mVar2.c(mVar2.b + 16);
        int iA5 = mVar2.a();
        int iA6 = mVar2.a();
        mVar2.c(mVar2.b + 4);
        int iA7 = mVar2.a();
        int iA8 = mVar2.a();
        if (iA5 == 0 && iA6 == 65536 && iA7 == -65536 && iA8 == 0) {
            i2 = 90;
        } else if (iA5 == 0 && iA6 == -65536 && iA7 == 65536 && iA8 == 0) {
            i2 = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        } else {
            i2 = (iA5 == -65536 && iA6 == 0 && iA7 == 0 && iA8 == -65536) ? 180 : 0;
        }
        long j3 = j == -9223372036854775807L ? jF : j;
        com.smartdigimkt.z0.m mVar3 = bVar.P0;
        mVar3.c(8);
        int iA9 = mVar3.a();
        int i15 = c.b;
        mVar3.c(mVar3.b + (((iA9 >> 24) & 255) == 0 ? 8 : 16));
        long jF2 = mVar3.f();
        long jA = j3 != -9223372036854775807L ? com.smartdigimkt.z0.u.a(j3, C.MICROS_PER_SECOND, jF2) : -9223372036854775807L;
        a aVarB2 = aVarB.b(c.G).b(c.H);
        com.smartdigimkt.z0.m mVar4 = aVarB.c(c.S).P0;
        mVar4.c(8);
        int iA10 = (mVar4.a() >> 24) & 255;
        mVar4.c(mVar4.b + (iA10 == 0 ? 8 : 16));
        long jF3 = mVar4.f();
        mVar4.c(mVar4.b + (iA10 == 0 ? 4 : 8));
        int iJ = mVar4.j();
        Pair pairCreate2 = Pair.create(Long.valueOf(jF3), "" + ((char) (((iJ >> 10) & 31) + 96)) + ((char) (((iJ >> 5) & 31) + 96)) + ((char) ((iJ & 31) + 96)));
        com.smartdigimkt.z0.m mVar5 = aVarB2.c(c.U).P0;
        String str6 = (String) pairCreate2.second;
        mVar5.c(12);
        int iA11 = mVar5.a();
        t[] tVarArr3 = new t[iA11];
        int i16 = 0;
        com.smartdigimkt.i0.s sVar2 = null;
        int i17 = 0;
        int i18 = 0;
        while (i16 < iA11) {
            int i19 = mVar5.b;
            int iA12 = mVar5.a();
            String str7 = "childAtomSize should be positive";
            com.smartdigimkt.z0.a.a("childAtomSize should be positive", iA12 > 0);
            int iA13 = mVar5.a();
            if (iA13 == c.c || iA13 == c.d || iA13 == c.a0 || iA13 == c.l0 || iA13 == c.e || iA13 == c.f || iA13 == c.g || iA13 == c.K0 || iA13 == c.L0) {
                pairCreate2 = pairCreate2;
                String str8 = "childAtomSize should be positive";
                i2 = i2;
                iA11 = iA11;
                i = i;
                i3 = i16;
                mVar5.c(i19 + 16);
                mVar5.c(mVar5.b + 16);
                int iJ2 = mVar5.j();
                int iJ3 = mVar5.j();
                mVar5.c(mVar5.b + 50);
                int i20 = mVar5.b;
                if (iA13 == c.a0) {
                    Pair pairA = a(mVar5, i19, iA12);
                    if (pairA != null) {
                        iA13 = ((Integer) pairA.first).intValue();
                        if (dVar == 0) {
                            dVar3 = null;
                        } else {
                            String str9 = ((t) pairA.second).a;
                            dVar3 = com.smartdigimkt.z0.u.a(dVar.c, str9) ? dVar : new com.smartdigimkt.m0.d(str9, dVar.a);
                        }
                        tVarArr3[i3] = (t) pairA.second;
                    } else {
                        dVar3 = dVar;
                    }
                    mVar5.c(i20);
                    dVar2 = dVar3;
                } else {
                    dVar2 = dVar;
                }
                int i21 = -1;
                boolean z3 = false;
                String str10 = null;
                float fH = 1.0f;
                byte[] bArrCopyOfRange = null;
                List listSingletonList2 = null;
                while (i20 - i19 < iA12) {
                    mVar5.c(i20);
                    int i22 = mVar5.b;
                    int iA14 = mVar5.a();
                    if (iA14 == 0 && mVar5.b - i19 == iA12) {
                        break;
                    }
                    String str11 = str8;
                    com.smartdigimkt.z0.a.a(str11, iA14 > 0);
                    int iA15 = mVar5.a();
                    if (iA15 != c.I) {
                        str8 = str11;
                        i4 = iA4;
                        i5 = iA12;
                        str = str6;
                        i6 = i19;
                        tVarArr2 = tVarArr3;
                        if (iA15 != c.J) {
                            if (iA15 == c.M0) {
                                if (str10 != null) {
                                    throw new IllegalStateException();
                                }
                                str10 = iA13 == c.K0 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                            } else if (iA15 == c.h) {
                                if (str10 != null) {
                                    throw new IllegalStateException();
                                }
                                str10 = "video/3gpp";
                            } else if (iA15 == c.K) {
                                if (str10 != null) {
                                    throw new IllegalStateException();
                                }
                                Pair pairA2 = a(i22, mVar5);
                                str10 = (String) pairA2.first;
                                listSingletonList2 = Collections.singletonList((byte[]) pairA2.second);
                            } else if (iA15 == c.j0) {
                                mVar5.c(i22 + 8);
                                fH = mVar5.h() / mVar5.h();
                                z3 = true;
                            } else if (iA15 == c.I0) {
                                int i23 = i22 + 8;
                                while (true) {
                                    if (i23 - i22 >= iA14) {
                                        bArrCopyOfRange = null;
                                        break;
                                    }
                                    mVar5.c(i23);
                                    int iA16 = mVar5.a();
                                    if (mVar5.a() == c.J0) {
                                        bArrCopyOfRange = Arrays.copyOfRange(mVar5.a, i23, iA16 + i23);
                                    } else {
                                        i23 += iA16;
                                    }
                                }
                            } else if (iA15 == c.H0) {
                                int iE2 = mVar5.e();
                                mVar5.c(mVar5.b + 3);
                                if (iE2 == 0) {
                                    int iE3 = mVar5.e();
                                    if (iE3 == 0) {
                                        i21 = 0;
                                    } else if (iE3 == 1) {
                                        i21 = 1;
                                    } else if (iE3 == 2) {
                                        i21 = 2;
                                    } else if (iE3 == 3) {
                                        i21 = 3;
                                    }
                                }
                            }
                            break;
                        }
                        if (str10 != null) {
                            throw new IllegalStateException();
                        }
                        mVar5.c(i22 + 8);
                        try {
                            mVar5.c(mVar5.b + 21);
                            int iE4 = mVar5.e() & 3;
                            int iE5 = mVar5.e();
                            int i24 = mVar5.b;
                            int i25 = 0;
                            for (int i26 = 0; i26 < iE5; i26++) {
                                mVar5.c(mVar5.b + 1);
                                int iJ4 = mVar5.j();
                                for (int i27 = 0; i27 < iJ4; i27++) {
                                    int iJ5 = mVar5.j();
                                    i25 += iJ5 + 4;
                                    mVar5.c(mVar5.b + iJ5);
                                }
                            }
                            mVar5.c(i24);
                            byte[] bArr = new byte[i25];
                            int i28 = 0;
                            for (int i29 = 0; i29 < iE5; i29++) {
                                mVar5.c(mVar5.b + 1);
                                int iJ6 = mVar5.j();
                                int i30 = 0;
                                while (i30 < iJ6) {
                                    int iJ7 = mVar5.j();
                                    System.arraycopy(com.smartdigimkt.z0.k.a, 0, bArr, i28, 4);
                                    int i31 = i28 + 4;
                                    System.arraycopy(mVar5.a, mVar5.b, bArr, i31, iJ7);
                                    i28 = i31 + iJ7;
                                    mVar5.c(mVar5.b + iJ7);
                                    i30++;
                                    iE5 = iE5;
                                }
                            }
                            iE = iE4 + 1;
                            str10 = "video/hevc";
                            listSingletonList2 = i25 == 0 ? null : Collections.singletonList(bArr);
                        } catch (ArrayIndexOutOfBoundsException e2) {
                            throw new y("Error parsing HEVC config", e2);
                        }
                        i20 += iA14;
                        str6 = str;
                        tVarArr3 = tVarArr2;
                        iA12 = i5;
                        i19 = i6;
                        iA4 = i4;
                    } else {
                        if (str10 != null) {
                            throw new IllegalStateException();
                        }
                        mVar5.c(i22 + 8);
                        try {
                            mVar5.c(mVar5.b + 4);
                            iE = (mVar5.e() & 3) + 1;
                            if (iE == 3) {
                                throw new IllegalStateException();
                            }
                            ArrayList arrayList = new ArrayList();
                            int iE6 = mVar5.e() & 31;
                            int i32 = 0;
                            while (i32 < iE6) {
                                int iJ8 = mVar5.j();
                                String str12 = str11;
                                int i33 = mVar5.b;
                                String str13 = str6;
                                mVar5.c(i33 + iJ8);
                                byte[] bArr2 = mVar5.a;
                                int i34 = iA12;
                                byte[] bArr3 = new byte[iJ8 + 4];
                                System.arraycopy(com.smartdigimkt.z0.d.a, 0, bArr3, 0, 4);
                                System.arraycopy(bArr2, i33, bArr3, 4, iJ8);
                                arrayList.add(bArr3);
                                i32++;
                                str6 = str13;
                                str11 = str12;
                                tVarArr3 = tVarArr3;
                                iA12 = i34;
                                i19 = i19;
                                iA4 = iA4;
                            }
                            str8 = str11;
                            i4 = iA4;
                            i5 = iA12;
                            str = str6;
                            i6 = i19;
                            tVarArr2 = tVarArr3;
                            int i35 = 0;
                            for (int iE7 = mVar5.e(); i35 < iE7; iE7 = iE7) {
                                int iJ9 = mVar5.j();
                                int i36 = mVar5.b;
                                mVar5.c(i36 + iJ9);
                                byte[] bArr4 = mVar5.a;
                                byte[] bArr5 = new byte[iJ9 + 4];
                                System.arraycopy(com.smartdigimkt.z0.d.a, 0, bArr5, 0, 4);
                                System.arraycopy(bArr4, i36, bArr5, 4, iJ9);
                                arrayList.add(bArr5);
                                i35++;
                            }
                            float f2 = iE6 > 0 ? com.smartdigimkt.z0.k.a((byte[]) arrayList.get(0), iE, ((byte[]) arrayList.get(0)).length).a : 1.0f;
                            if (!z3) {
                                fH = f2;
                            }
                            str10 = "video/avc";
                            listSingletonList2 = arrayList;
                        } catch (ArrayIndexOutOfBoundsException e3) {
                            throw new y("Error parsing AVC config", e3);
                        }
                    }
                    i18 = iE;
                    break;
                    i20 += iA14;
                    str6 = str;
                    tVarArr3 = tVarArr2;
                    iA12 = i5;
                    i19 = i6;
                    iA4 = i4;
                }
                iA4 = iA4;
                iA12 = iA12;
                str6 = str6;
                i19 = i19;
                tVarArr = tVarArr3;
                c2 = 4;
                c3 = 31;
                if (str10 != null) {
                    sVar2 = new com.smartdigimkt.i0.s(Integer.toString(iA4), null, str10, null, -1, -1, iJ2, iJ3, -1.0f, i2, fH, bArrCopyOfRange, i21, null, -1, -1, -1, -1, -1, 0, null, -1, LongCompanionObject.MAX_VALUE, listSingletonList2, dVar2, null);
                }
            } else {
                if (iA13 == c.j || iA13 == c.b0 || iA13 == c.o || iA13 == c.q || iA13 == c.s || iA13 == c.v || iA13 == c.t || iA13 == c.u || iA13 == c.y0 || iA13 == c.z0 || iA13 == c.m || iA13 == c.n || iA13 == c.k || iA13 == c.O0) {
                    mVar5.c(i19 + 16);
                    if (z2) {
                        int iJ10 = mVar5.j();
                        mVar5.c(mVar5.b + 6);
                        i7 = iJ10;
                    } else {
                        mVar5.c(mVar5.b + 8);
                        i7 = 0;
                    }
                    if (i7 == 0 || i7 == 1) {
                        int iJ11 = mVar5.j();
                        mVar5.c(mVar5.b + 6);
                        byte[] bArr6 = mVar5.a;
                        int i37 = mVar5.b;
                        int i38 = ((bArr6[i37] & UByte.MAX_VALUE) << 8) | (bArr6[i37 + 1] & UByte.MAX_VALUE);
                        mVar5.b = i37 + 4;
                        if (i7 == 1) {
                            mVar5.c(i37 + 20);
                        }
                        i8 = i38;
                        iH = iJ11;
                    } else if (i7 == 2) {
                        mVar5.c(mVar5.b + 16);
                        int iRound = (int) Math.round(Double.longBitsToDouble(mVar5.b()));
                        iH = mVar5.h();
                        mVar5.c(mVar5.b + 20);
                        i8 = iRound;
                    }
                    int i39 = mVar5.b;
                    if (iA13 == c.b0) {
                        Pair pairA3 = a(mVar5, i19, iA12);
                        if (pairA3 != null) {
                            int iIntValue = ((Integer) pairA3.first).intValue();
                            if (dVar == 0) {
                                i11 = iIntValue;
                                i9 = i8;
                                dVar4 = null;
                            } else {
                                i11 = iIntValue;
                                String str14 = ((t) pairA3.second).a;
                                i9 = i8;
                                dVar4 = com.smartdigimkt.z0.u.a(dVar.c, str14) ? dVar : new com.smartdigimkt.m0.d(str14, dVar.a);
                            }
                            tVarArr3[i16] = (t) pairA3.second;
                            iA13 = i11;
                        } else {
                            i9 = i8;
                            iH = iH;
                            dVar4 = dVar;
                        }
                        mVar5.c(i39);
                    } else {
                        i9 = i8;
                        iH = iH;
                        dVar4 = dVar;
                    }
                    if (iA13 == c.o) {
                        str2 = "audio/ac3";
                    } else if (iA13 == c.q) {
                        str2 = "audio/eac3";
                    } else if (iA13 == c.s) {
                        str2 = "audio/vnd.dts";
                    } else if (iA13 == c.t || iA13 == c.u) {
                        str2 = "audio/vnd.dts.hd";
                    } else if (iA13 == c.v) {
                        str2 = "audio/vnd.dts.hd;profile=lbr";
                    } else if (iA13 == c.y0) {
                        str2 = "audio/3gpp";
                    } else if (iA13 == c.z0) {
                        str2 = "audio/amr-wb";
                    } else if (iA13 == c.m || iA13 == c.n) {
                        str2 = "audio/raw";
                    } else if (iA13 == c.k) {
                        str2 = "audio/mpeg";
                    } else {
                        str2 = iA13 == c.O0 ? "audio/alac" : null;
                    }
                    int iIntValue2 = i9;
                    int iIntValue3 = iH;
                    byte[] bArr7 = null;
                    while (i39 - i19 < iA12) {
                        mVar5.c(i39);
                        int iA17 = mVar5.a();
                        com.smartdigimkt.z0.a.a(str7, iA17 > 0);
                        int iA18 = mVar5.a();
                        int i40 = i2;
                        int i41 = c.K;
                        int i42 = i16;
                        if (iA18 == i41 || (z2 && iA18 == c.l)) {
                            if (iA18 != i41) {
                                i10 = mVar5.b;
                                while (true) {
                                    if (i10 - i39 >= iA17) {
                                        str3 = str7;
                                        i10 = -1;
                                        break;
                                    }
                                    mVar5.c(i10);
                                    int iA19 = mVar5.a();
                                    com.smartdigimkt.z0.a.a(str7, iA19 > 0);
                                    str3 = str7;
                                    if (mVar5.a() == c.K) {
                                        break;
                                    }
                                    i10 += iA19;
                                    str7 = str3;
                                }
                            } else {
                                i10 = i39;
                                str3 = str7;
                            }
                            if (i10 != -1) {
                                Pair pairA4 = a(i10, mVar5);
                                str2 = (String) pairA4.first;
                                byte[] bArr8 = (byte[]) pairA4.second;
                                if ("audio/mp4a-latm".equals(str2)) {
                                    com.smartdigimkt.z0.l lVar = new com.smartdigimkt.z0.l(bArr8);
                                    int iA20 = lVar.a(5);
                                    if (iA20 == 31) {
                                        iA20 = lVar.a(6) + 32;
                                    }
                                    int iA21 = lVar.a(4);
                                    if (iA21 == 15) {
                                        iA = lVar.a(24);
                                    } else {
                                        if (iA21 >= 13) {
                                            throw new IllegalArgumentException();
                                        }
                                        iA = com.smartdigimkt.z0.d.b[iA21];
                                    }
                                    int iA22 = lVar.a(4);
                                    if (iA20 == 5 || iA20 == 29) {
                                        int iA23 = lVar.a(4);
                                        if (iA23 == 15) {
                                            iA = lVar.a(24);
                                        } else {
                                            if (iA23 >= 13) {
                                                throw new IllegalArgumentException();
                                            }
                                            iA = com.smartdigimkt.z0.d.b[iA23];
                                        }
                                        int iA24 = lVar.a(5);
                                        if (iA24 == 31) {
                                            iA24 = lVar.a(6) + 32;
                                        }
                                        if (iA24 == 22) {
                                            iA22 = lVar.a(4);
                                        }
                                    }
                                    int i43 = com.smartdigimkt.z0.d.c[iA22];
                                    if (i43 == -1) {
                                        throw new IllegalArgumentException();
                                    }
                                    Pair pairCreate3 = Pair.create(Integer.valueOf(iA), Integer.valueOf(i43));
                                    iIntValue2 = ((Integer) pairCreate3.first).intValue();
                                    iIntValue3 = ((Integer) pairCreate3.second).intValue();
                                }
                                bArr7 = bArr8;
                            }
                        } else {
                            if (iA18 == c.p) {
                                mVar5.c(i39 + 8);
                                String string = Integer.toString(iA4);
                                int i44 = com.smartdigimkt.k0.a.b[(mVar5.e() & MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT) >> 6];
                                int iE8 = mVar5.e();
                                int i45 = com.smartdigimkt.k0.a.c[(iE8 & 56) >> 3];
                                if ((iE8 & 4) != 0) {
                                    i45++;
                                }
                                sVarA = com.smartdigimkt.i0.s.a(string, "audio/ac3", i45, i44, -1, null, dVar4, str6);
                            } else if (iA18 == c.r) {
                                mVar5.c(i39 + 8);
                                String string2 = Integer.toString(iA4);
                                mVar5.c(mVar5.b + 2);
                                int i46 = com.smartdigimkt.k0.a.b[(mVar5.e() & MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT) >> 6];
                                int iE9 = mVar5.e();
                                int i47 = com.smartdigimkt.k0.a.c[(iE9 & 14) >> 1];
                                if ((iE9 & 1) != 0) {
                                    i47++;
                                }
                                if (((mVar5.e() & 30) >> 1) > 0 && (mVar5.e() & 2) != 0) {
                                    i47 += 2;
                                }
                                sVarA = com.smartdigimkt.i0.s.a(string2, (mVar5.c - mVar5.b <= 0 || (mVar5.e() & 1) == 0) ? "audio/eac3" : "audio/eac3-joc", i47, i46, -1, null, dVar4, str6);
                            } else {
                                if (iA18 == c.w) {
                                    sVarA = com.smartdigimkt.i0.s.a(Integer.toString(iA4), str2, iIntValue3, iIntValue2, -1, null, dVar4, str6);
                                } else if (iA18 == c.O0) {
                                    byte[] bArr9 = new byte[iA17];
                                    mVar5.c(i39);
                                    mVar5.a(bArr9, 0, iA17);
                                    bArr7 = bArr9;
                                }
                                str3 = str7;
                            }
                            sVar2 = sVarA;
                            str3 = str7;
                        }
                        i39 += iA17;
                        str7 = str3;
                        i2 = i40;
                        i16 = i42;
                    }
                    i2 = i2;
                    i3 = i16;
                    if (sVar2 == null && str2 != null) {
                        sVar2 = com.smartdigimkt.i0.s.a(Integer.toString(iA4), str2, iIntValue3, iIntValue2, "audio/raw".equals(str2) ? 2 : -1, bArr7 == null ? null : Collections.singletonList(bArr7), dVar4, str6);
                    }
                    iA4 = iA4;
                    iA12 = iA12;
                    str6 = str6;
                    tVarArr = tVarArr3;
                    c2 = 4;
                    c3 = 31;
                } else {
                    int i48 = c.k0;
                    if (iA13 == i48 || iA13 == c.u0 || iA13 == c.v0 || iA13 == c.w0 || iA13 == c.x0) {
                        mVar5.c(i19 + 16);
                        if (iA13 == i48) {
                            str5 = "application/ttml+xml";
                        } else {
                            if (iA13 == c.u0) {
                                int i49 = iA12 - 16;
                                byte[] bArr10 = new byte[i49];
                                mVar5.a(bArr10, 0, i49);
                                listSingletonList = Collections.singletonList(bArr10);
                                str4 = "application/x-quicktime-tx3g";
                                j2 = Long.MAX_VALUE;
                            } else if (iA13 == c.v0) {
                                str5 = "application/x-mp4-vtt";
                            } else if (iA13 == c.w0) {
                                str4 = "application/ttml+xml";
                                j2 = 0;
                                listSingletonList = null;
                            } else {
                                if (iA13 != c.x0) {
                                    throw new IllegalStateException();
                                }
                                str4 = "application/x-mp4-cea-608";
                                j2 = Long.MAX_VALUE;
                                listSingletonList = null;
                                i17 = 1;
                            }
                            sVar2 = new com.smartdigimkt.i0.s(Integer.toString(iA4), null, str4, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str6, -1, j2, listSingletonList, null, null);
                        }
                        str4 = str5;
                        j2 = Long.MAX_VALUE;
                        listSingletonList = null;
                        sVar2 = new com.smartdigimkt.i0.s(Integer.toString(iA4), null, str4, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str6, -1, j2, listSingletonList, null, null);
                    } else if (iA13 == c.N0) {
                        sVar2 = new com.smartdigimkt.i0.s(Integer.toString(iA4), null, "application/x-camera-motion", null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, LongCompanionObject.MAX_VALUE, null, null, null);
                    } else {
                        iA11 = iA11;
                    }
                    iA11 = iA11;
                    i = i;
                    i3 = i16;
                    tVarArr = tVarArr3;
                    c2 = 4;
                    c3 = 31;
                }
                i = i;
                i3 = i16;
                tVarArr = tVarArr3;
                c2 = 4;
                c3 = 31;
            }
            mVar5.c(i19 + iA12);
            i16 = i3 + 1;
            str6 = str6;
            iA11 = iA11;
            i = i;
            pairCreate2 = pairCreate2;
            i2 = i2;
            tVarArr3 = tVarArr;
            iA4 = iA4;
        }
        Pair pair = pairCreate2;
        int i50 = iA4;
        int i51 = i;
        t[] tVarArr4 = tVarArr3;
        if (z) {
            sVar = null;
            jArr = null;
            jArr2 = null;
        } else {
            a aVarB3 = aVar.b(c.Q);
            if (aVarB3 == null || (bVarC = aVarB3.c(c.R)) == null) {
                sVar = null;
                pairCreate = Pair.create(null, null);
            } else {
                com.smartdigimkt.z0.m mVar6 = bVarC.P0;
                mVar6.c(8);
                int iA25 = (mVar6.a() >> 24) & 255;
                int iH2 = mVar6.h();
                long[] jArr3 = new long[iH2];
                long[] jArr4 = new long[iH2];
                for (int i52 = 0; i52 < iH2; i52++) {
                    jArr3[i52] = iA25 == 1 ? mVar6.i() : mVar6.f();
                    jArr4[i52] = iA25 == 1 ? mVar6.b() : mVar6.a();
                    byte[] bArr11 = mVar6.a;
                    int i53 = mVar6.b;
                    int i54 = (bArr11[i53] & UByte.MAX_VALUE) << 8;
                    mVar6.b = i53 + 2;
                    if (((short) ((bArr11[i53 + 1] & UByte.MAX_VALUE) | i54)) != 1) {
                        throw new IllegalArgumentException("Unsupported media rate.");
                    }
                    mVar6.c(i53 + 4);
                }
                pairCreate = Pair.create(jArr3, jArr4);
                sVar = null;
            }
            long[] jArr5 = (long[]) pairCreate.first;
            jArr = (long[]) pairCreate.second;
            jArr2 = jArr5;
        }
        return sVar2 == null ? sVar : new s(i50, i51, ((Long) pair.first).longValue(), jF2, jA, sVar2, i17, tVarArr4, i18, jArr2, jArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Pair a(com.smartdigimkt.z0.m mVar, int i, int i2) {
        int i3;
        int i4;
        int i5 = mVar.b;
        while (true) {
            t tVar = null;
            Pair pairCreate = null;
            bArr = null;
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            mVar.c(i5);
            int iA = mVar.a();
            com.smartdigimkt.z0.a.a("childAtomSize should be positive", iA > 0);
            if (mVar.a() == c.W) {
                int i6 = i5 + 8;
                String strD = null;
                Integer numValueOf = null;
                int i7 = 0;
                int i8 = -1;
                while (i6 - i5 < iA) {
                    mVar.c(i6);
                    int iA2 = mVar.a();
                    int iA3 = mVar.a();
                    if (iA3 == c.c0) {
                        numValueOf = Integer.valueOf(mVar.a());
                    } else if (iA3 == c.X) {
                        mVar.c(mVar.b + 4);
                        strD = mVar.d();
                    } else if (iA3 == c.Y) {
                        i8 = i6;
                        i7 = iA2;
                    }
                    i6 += iA2;
                }
                if ("cenc".equals(strD) || "cbc1".equals(strD) || "cens".equals(strD) || "cbcs".equals(strD)) {
                    com.smartdigimkt.z0.a.a("frma atom is mandatory", numValueOf != null);
                    com.smartdigimkt.z0.a.a("schi atom is mandatory", i8 != -1);
                    int i9 = i8 + 8;
                    while (i9 - i8 < i7) {
                        mVar.c(i9);
                        int iA4 = mVar.a();
                        if (mVar.a() == c.Z) {
                            int iA5 = (mVar.a() >> 24) & 255;
                            mVar.c(mVar.b + 1);
                            if (iA5 == 0) {
                                mVar.c(mVar.b + 1);
                                i4 = 0;
                                i3 = 0;
                            } else {
                                int iE = mVar.e();
                                i3 = iE & 15;
                                i4 = (iE & MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA) >> 4;
                            }
                            Object[] objArr = mVar.e() == 1;
                            int iE2 = mVar.e();
                            byte[] bArr2 = new byte[16];
                            mVar.a(bArr2, 0, 16);
                            if (objArr != false && iE2 == 0) {
                                int iE3 = mVar.e();
                                byte[] bArr3 = new byte[iE3];
                                mVar.a(bArr3, 0, iE3);
                                bArr = bArr3;
                            }
                            tVar = new t(strD, iE2, bArr2, i4, i3, bArr);
                            numValueOf = numValueOf;
                            break;
                        }
                        i9 += iA4;
                    }
                    com.smartdigimkt.z0.a.a("tenc atom is mandatory", tVar != null);
                    pairCreate = Pair.create(numValueOf, tVar);
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            i5 += iA;
        }
    }

    public static Pair a(int i, com.smartdigimkt.z0.m mVar) {
        mVar.c(i + 12);
        mVar.c(mVar.b + 1);
        a(mVar);
        mVar.c(mVar.b + 2);
        int iE = mVar.e();
        if ((iE & 128) != 0) {
            mVar.c(mVar.b + 2);
        }
        if ((iE & 64) != 0) {
            mVar.c(mVar.b + mVar.j());
        }
        if ((iE & 32) != 0) {
            mVar.c(mVar.b + 2);
        }
        mVar.c(mVar.b + 1);
        a(mVar);
        String strA = com.smartdigimkt.z0.i.a(mVar.e());
        if (!"audio/mpeg".equals(strA) && !"audio/vnd.dts".equals(strA) && !"audio/vnd.dts.hd".equals(strA)) {
            mVar.c(mVar.b + 12);
            mVar.c(mVar.b + 1);
            int iA = a(mVar);
            byte[] bArr = new byte[iA];
            mVar.a(bArr, 0, iA);
            return Pair.create(strA, bArr);
        }
        return Pair.create(strA, null);
    }

    public static int a(com.smartdigimkt.z0.m mVar) {
        int iE = mVar.e();
        int i = iE & WorkQueueKt.MASK;
        while ((iE & 128) == 128) {
            iE = mVar.e();
            i = (i << 7) | (iE & WorkQueueKt.MASK);
        }
        return i;
    }
}

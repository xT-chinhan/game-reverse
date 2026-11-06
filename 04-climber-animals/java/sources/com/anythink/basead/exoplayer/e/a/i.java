package com.anythink.basead.exoplayer.e.a;

import com.anythink.basead.exoplayer.k.af;
import com.anythink.basead.exoplayer.k.s;

/* JADX INFO: loaded from: classes.dex */
final class i {
    private static final int a = 4096;
    private static final int[] b = {af.f("isom"), af.f("iso2"), af.f("iso3"), af.f("iso4"), af.f("iso5"), af.f("iso6"), af.f("avc1"), af.f("hvc1"), af.f("hev1"), af.f("mp41"), af.f("mp42"), af.f("3g2a"), af.f("3g2b"), af.f("3gr6"), af.f("3gs6"), af.f("3ge6"), af.f("3gg6"), af.f("M4V "), af.f("M4A "), af.f("f4v "), af.f("kddi"), af.f("M4VP"), af.f("qt  "), af.f("MSNV")};

    public static boolean a(com.anythink.basead.exoplayer.e.f fVar) {
        return a(fVar, true);
    }

    public static boolean b(com.anythink.basead.exoplayer.e.f fVar) {
        return a(fVar, false);
    }

    private static boolean a(com.anythink.basead.exoplayer.e.f fVar, boolean z) {
        boolean z2;
        int i;
        long jD = fVar.d();
        long j = -1;
        if (jD == -1 || jD > 4096) {
            jD = 4096;
        }
        int i2 = (int) jD;
        s sVar = new s(64);
        int i3 = 0;
        boolean z3 = false;
        while (true) {
            if (i3 < i2) {
                sVar.a(8);
                fVar.d(sVar.a, 0, 8);
                long jH = sVar.h();
                int i4 = sVar.i();
                if (jH == 1) {
                    fVar.d(sVar.a, 8, 8);
                    sVar.b(16);
                    i = 16;
                    jH = sVar.n();
                } else {
                    if (jH == 0) {
                        long jD2 = fVar.d();
                        if (jD2 != j) {
                            jH = 8 + (jD2 - fVar.c());
                        }
                    }
                    i = 8;
                }
                long j2 = i;
                if (jH < j2) {
                    return false;
                }
                i3 += i;
                if (i4 != a.G) {
                    if (i4 == a.P || i4 == a.R) {
                        z2 = true;
                        return !z3 && z == z2;
                    }
                    if ((((long) i3) + jH) - j2 < i2) {
                        int i5 = (int) (jH - j2);
                        i3 += i5;
                        if (i4 == a.f) {
                            if (i5 < 8) {
                                return false;
                            }
                            sVar.a(i5);
                            fVar.d(sVar.a, 0, i5);
                            int i6 = i5 / 4;
                            for (int i7 = 0; i7 < i6; i7++) {
                                if (i7 == 1) {
                                    sVar.d(4);
                                } else if (a(sVar.i())) {
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!z3) {
                                return false;
                            }
                        } else if (i5 != 0) {
                            fVar.e(i5);
                        }
                        j = -1;
                    }
                }
            }
            z2 = false;
            if (z3) {
            }
        }
    }

    private static boolean a(int i) {
        if ((i >>> 8) == af.f("3gp")) {
            return true;
        }
        for (int i2 : b) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private i() {
    }
}

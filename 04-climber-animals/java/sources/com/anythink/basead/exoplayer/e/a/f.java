package com.anythink.basead.exoplayer.e.a;

import android.util.Log;
import com.anythink.basead.exoplayer.k.af;
import com.anythink.basead.exoplayer.k.s;

/* JADX INFO: loaded from: classes.dex */
final class f {
    private static final String F = "und";
    private static final String a = "MetadataUtil";
    private static final int b = af.f("nam");
    private static final int c = af.f("trk");
    private static final int d = af.f("cmt");
    private static final int e = af.f(com.anythink.core.common.e.a.C0080a.k);
    private static final int f = af.f("ART");
    private static final int g = af.f("too");
    private static final int h = af.f("alb");
    private static final int i = af.f("com");
    private static final int j = af.f("wrt");
    private static final int k = af.f("lyr");
    private static final int l = af.f("gen");
    private static final int m = af.f("covr");
    private static final int n = af.f("gnre");
    private static final int o = af.f("grp");
    private static final int p = af.f("disk");
    private static final int q = af.f("trkn");
    private static final int r = af.f("tmpo");
    private static final int s = af.f("cpil");
    private static final int t = af.f("aART");
    private static final int u = af.f("sonm");
    private static final int v = af.f("soal");
    private static final int w = af.f("soar");
    private static final int x = af.f("soaa");
    private static final int y = af.f("soco");
    private static final int z = af.f("rtng");
    private static final int A = af.f("pgap");
    private static final int B = af.f("sosn");
    private static final int C = af.f("tvsh");
    private static final int D = af.f(com.anythink.basead.exoplayer.g.b.i.a);
    private static final String[] E = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    private f() {
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0035  */
    public static com.anythink.basead.exoplayer.g.a.InterfaceC0027a a(s sVar) {
        String str;
        String str2;
        int iC = sVar.c() + sVar.i();
        int i2 = sVar.i();
        int i3 = (i2 >> 24) & 255;
        com.anythink.basead.exoplayer.g.a.InterfaceC0027a eVar = null;
        try {
            if (i3 == 169 || i3 == 65533) {
                int i4 = 16777215 & i2;
                if (i4 == d) {
                    int i5 = sVar.i();
                    if (sVar.i() == a.aK) {
                        sVar.d(8);
                        String strE = sVar.e(i5 - 16);
                        eVar = new com.anythink.basead.exoplayer.g.b.e("und", strE, strE);
                    } else {
                        Log.w(a, "Failed to parse comment attribute: " + a.c(i2));
                    }
                    sVar.c(iC);
                    return eVar;
                }
                if (i4 != b && i4 != c) {
                    if (i4 != i && i4 != j) {
                        if (i4 == e) {
                            com.anythink.basead.exoplayer.g.b.k kVarA = a(i2, "TDRC", sVar);
                            sVar.c(iC);
                            return kVarA;
                        }
                        if (i4 == f) {
                            com.anythink.basead.exoplayer.g.b.k kVarA2 = a(i2, "TPE1", sVar);
                            sVar.c(iC);
                            return kVarA2;
                        }
                        if (i4 == g) {
                            com.anythink.basead.exoplayer.g.b.k kVarA3 = a(i2, "TSSE", sVar);
                            sVar.c(iC);
                            return kVarA3;
                        }
                        if (i4 == h) {
                            com.anythink.basead.exoplayer.g.b.k kVarA4 = a(i2, "TALB", sVar);
                            sVar.c(iC);
                            return kVarA4;
                        }
                        if (i4 == k) {
                            com.anythink.basead.exoplayer.g.b.k kVarA5 = a(i2, "USLT", sVar);
                            sVar.c(iC);
                            return kVarA5;
                        }
                        if (i4 == l) {
                            com.anythink.basead.exoplayer.g.b.k kVarA6 = a(i2, "TCON", sVar);
                            sVar.c(iC);
                            return kVarA6;
                        }
                        if (i4 == o) {
                            com.anythink.basead.exoplayer.g.b.k kVarA7 = a(i2, "TIT1", sVar);
                            sVar.c(iC);
                            return kVarA7;
                        }
                    }
                    com.anythink.basead.exoplayer.g.b.k kVarA8 = a(i2, "TCOM", sVar);
                    sVar.c(iC);
                    return kVarA8;
                }
                com.anythink.basead.exoplayer.g.b.k kVarA9 = a(i2, "TIT2", sVar);
                sVar.c(iC);
                return kVarA9;
            }
            if (i2 == n) {
                int iD = d(sVar);
                if (iD > 0) {
                    String[] strArr = E;
                    if (iD <= strArr.length) {
                        str2 = strArr[iD - 1];
                    } else {
                        str2 = null;
                    }
                } else {
                    str2 = null;
                }
                if (str2 != null) {
                    eVar = new com.anythink.basead.exoplayer.g.b.k("TCON", null, str2);
                } else {
                    Log.w(a, "Failed to parse standard genre code");
                }
                sVar.c(iC);
                return eVar;
            }
            if (i2 == p) {
                com.anythink.basead.exoplayer.g.b.k kVarB = b(i2, "TPOS", sVar);
                sVar.c(iC);
                return kVarB;
            }
            if (i2 == q) {
                com.anythink.basead.exoplayer.g.b.k kVarB2 = b(i2, "TRCK", sVar);
                sVar.c(iC);
                return kVarB2;
            }
            if (i2 == r) {
                com.anythink.basead.exoplayer.g.b.h hVarA = a(i2, "TBPM", sVar, true, false);
                sVar.c(iC);
                return hVarA;
            }
            if (i2 == s) {
                com.anythink.basead.exoplayer.g.b.h hVarA2 = a(i2, "TCMP", sVar, true, true);
                sVar.c(iC);
                return hVarA2;
            }
            if (i2 == m) {
                int i6 = sVar.i();
                if (sVar.i() == a.aK) {
                    int iB = a.b(sVar.i());
                    if (iB == 13) {
                        str = "image/jpeg";
                    } else {
                        str = iB == 14 ? "image/png" : null;
                    }
                    if (str == null) {
                        Log.w(a, "Unrecognized cover art flags: ".concat(String.valueOf(iB)));
                    } else {
                        sVar.d(4);
                        int i7 = i6 - 16;
                        byte[] bArr = new byte[i7];
                        sVar.a(bArr, 0, i7);
                        eVar = new com.anythink.basead.exoplayer.g.b.a(str, null, 3, bArr);
                    }
                } else {
                    Log.w(a, "Failed to parse cover art attribute");
                }
                sVar.c(iC);
                return eVar;
            }
            if (i2 == t) {
                com.anythink.basead.exoplayer.g.b.k kVarA10 = a(i2, "TPE2", sVar);
                sVar.c(iC);
                return kVarA10;
            }
            if (i2 == u) {
                com.anythink.basead.exoplayer.g.b.k kVarA11 = a(i2, "TSOT", sVar);
                sVar.c(iC);
                return kVarA11;
            }
            if (i2 == v) {
                com.anythink.basead.exoplayer.g.b.k kVarA12 = a(i2, "TSO2", sVar);
                sVar.c(iC);
                return kVarA12;
            }
            if (i2 == w) {
                com.anythink.basead.exoplayer.g.b.k kVarA13 = a(i2, "TSOA", sVar);
                sVar.c(iC);
                return kVarA13;
            }
            if (i2 == x) {
                com.anythink.basead.exoplayer.g.b.k kVarA14 = a(i2, "TSOP", sVar);
                sVar.c(iC);
                return kVarA14;
            }
            if (i2 == y) {
                com.anythink.basead.exoplayer.g.b.k kVarA15 = a(i2, "TSOC", sVar);
                sVar.c(iC);
                return kVarA15;
            }
            if (i2 == z) {
                com.anythink.basead.exoplayer.g.b.h hVarA3 = a(i2, "ITUNESADVISORY", sVar, false, false);
                sVar.c(iC);
                return hVarA3;
            }
            if (i2 == A) {
                com.anythink.basead.exoplayer.g.b.h hVarA4 = a(i2, "ITUNESGAPLESS", sVar, false, true);
                sVar.c(iC);
                return hVarA4;
            }
            if (i2 == B) {
                com.anythink.basead.exoplayer.g.b.k kVarA16 = a(i2, "TVSHOWSORT", sVar);
                sVar.c(iC);
                return kVarA16;
            }
            if (i2 == C) {
                com.anythink.basead.exoplayer.g.b.k kVarA17 = a(i2, "TVSHOW", sVar);
                sVar.c(iC);
                return kVarA17;
            }
            if (i2 == D) {
                com.anythink.basead.exoplayer.g.b.h hVarA5 = a(sVar, iC);
                sVar.c(iC);
                return hVarA5;
            }
            Log.d(a, "Skipped unknown metadata entry: " + a.c(i2));
            sVar.c(iC);
            return null;
        } catch (Throwable th) {
            sVar.c(iC);
            throw th;
        }
    }

    private static com.anythink.basead.exoplayer.g.b.k a(int i2, String str, s sVar) {
        int i3 = sVar.i();
        if (sVar.i() == a.aK) {
            sVar.d(8);
            return new com.anythink.basead.exoplayer.g.b.k(str, null, sVar.e(i3 - 16));
        }
        Log.w(a, "Failed to parse text attribute: " + a.c(i2));
        return null;
    }

    private static com.anythink.basead.exoplayer.g.b.e a(int i2, s sVar) {
        int i3 = sVar.i();
        if (sVar.i() == a.aK) {
            sVar.d(8);
            String strE = sVar.e(i3 - 16);
            return new com.anythink.basead.exoplayer.g.b.e("und", strE, strE);
        }
        Log.w(a, "Failed to parse comment attribute: " + a.c(i2));
        return null;
    }

    private static com.anythink.basead.exoplayer.g.b.h a(int i2, String str, s sVar, boolean z2, boolean z3) {
        int iD = d(sVar);
        if (z3) {
            iD = Math.min(1, iD);
        }
        if (iD < 0) {
            Log.w(a, "Failed to parse uint8 attribute: " + a.c(i2));
            return null;
        }
        if (z2) {
            return new com.anythink.basead.exoplayer.g.b.k(str, null, Integer.toString(iD));
        }
        return new com.anythink.basead.exoplayer.g.b.e("und", str, Integer.toString(iD));
    }

    private static com.anythink.basead.exoplayer.g.b.k b(int i2, String str, s sVar) {
        int i3 = sVar.i();
        if (sVar.i() == a.aK && i3 >= 22) {
            sVar.d(10);
            int iE = sVar.e();
            if (iE > 0) {
                String strValueOf = String.valueOf(iE);
                int iE2 = sVar.e();
                if (iE2 > 0) {
                    strValueOf = strValueOf + "/" + iE2;
                }
                return new com.anythink.basead.exoplayer.g.b.k(str, null, strValueOf);
            }
        }
        Log.w(a, "Failed to parse index/count attribute: " + a.c(i2));
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0011  */
    private static com.anythink.basead.exoplayer.g.b.k b(s sVar) {
        String str;
        int iD = d(sVar);
        if (iD > 0) {
            String[] strArr = E;
            if (iD <= strArr.length) {
                str = strArr[iD - 1];
            } else {
                str = null;
            }
        } else {
            str = null;
        }
        if (str != null) {
            return new com.anythink.basead.exoplayer.g.b.k("TCON", null, str);
        }
        Log.w(a, "Failed to parse standard genre code");
        return null;
    }

    private static com.anythink.basead.exoplayer.g.b.a c(s sVar) {
        String str;
        int i2 = sVar.i();
        if (sVar.i() == a.aK) {
            int iB = a.b(sVar.i());
            if (iB == 13) {
                str = "image/jpeg";
            } else {
                str = iB == 14 ? "image/png" : null;
            }
            if (str == null) {
                Log.w(a, "Unrecognized cover art flags: ".concat(String.valueOf(iB)));
                return null;
            }
            sVar.d(4);
            int i3 = i2 - 16;
            byte[] bArr = new byte[i3];
            sVar.a(bArr, 0, i3);
            return new com.anythink.basead.exoplayer.g.b.a(str, null, 3, bArr);
        }
        Log.w(a, "Failed to parse cover art attribute");
        return null;
    }

    private static com.anythink.basead.exoplayer.g.b.h a(s sVar, int i2) {
        String strE = null;
        String strE2 = null;
        int i3 = -1;
        int i4 = -1;
        while (sVar.c() < i2) {
            int iC = sVar.c();
            int i5 = sVar.i();
            int i6 = sVar.i();
            sVar.d(4);
            if (i6 == a.aI) {
                strE = sVar.e(i5 - 12);
            } else if (i6 == a.aJ) {
                strE2 = sVar.e(i5 - 12);
            } else {
                if (i6 == a.aK) {
                    i3 = iC;
                    i4 = i5;
                }
                sVar.d(i5 - 12);
            }
        }
        if (strE == null || strE2 == null || i3 == -1) {
            return null;
        }
        sVar.c(i3);
        sVar.d(16);
        return new com.anythink.basead.exoplayer.g.b.i(strE, strE2, sVar.e(i4 - 16));
    }

    private static int d(s sVar) {
        sVar.d(4);
        if (sVar.i() == a.aK) {
            sVar.d(8);
            return sVar.d();
        }
        Log.w(a, "Failed to parse uint8 attribute value");
        return -1;
    }
}

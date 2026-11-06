package com.smartdigimkt.o0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n {
    public static final int a = com.smartdigimkt.z0.u.a("nam");
    public static final int b = com.smartdigimkt.z0.u.a("trk");
    public static final int c = com.smartdigimkt.z0.u.a("cmt");
    public static final int d = com.smartdigimkt.z0.u.a(com.anythink.core.common.f.a.C0017a.k);
    public static final int e = com.smartdigimkt.z0.u.a("ART");
    public static final int f = com.smartdigimkt.z0.u.a("too");
    public static final int g = com.smartdigimkt.z0.u.a("alb");
    public static final int h = com.smartdigimkt.z0.u.a("com");
    public static final int i = com.smartdigimkt.z0.u.a("wrt");
    public static final int j = com.smartdigimkt.z0.u.a("lyr");
    public static final int k = com.smartdigimkt.z0.u.a("gen");
    public static final int l = com.smartdigimkt.z0.u.a("covr");
    public static final int m = com.smartdigimkt.z0.u.a("gnre");
    public static final int n = com.smartdigimkt.z0.u.a("grp");
    public static final int o = com.smartdigimkt.z0.u.a("disk");
    public static final int p = com.smartdigimkt.z0.u.a("trkn");
    public static final int q = com.smartdigimkt.z0.u.a("tmpo");
    public static final int r = com.smartdigimkt.z0.u.a("cpil");
    public static final int s = com.smartdigimkt.z0.u.a("aART");
    public static final int t = com.smartdigimkt.z0.u.a("sonm");
    public static final int u = com.smartdigimkt.z0.u.a("soal");
    public static final int v = com.smartdigimkt.z0.u.a("soar");
    public static final int w = com.smartdigimkt.z0.u.a("soaa");
    public static final int x = com.smartdigimkt.z0.u.a("soco");
    public static final int y = com.smartdigimkt.z0.u.a("rtng");
    public static final int z = com.smartdigimkt.z0.u.a("pgap");
    public static final int A = com.smartdigimkt.z0.u.a("sosn");
    public static final int B = com.smartdigimkt.z0.u.a("tvsh");
    public static final int C = com.smartdigimkt.z0.u.a("----");
    public static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    public static com.smartdigimkt.s0.q a(int i2, com.smartdigimkt.z0.m mVar) {
        String strA = null;
        String strA2 = null;
        int i3 = -1;
        int i4 = -1;
        while (true) {
            int i5 = mVar.b;
            if (i5 >= i2) {
                break;
            }
            int iA = mVar.a();
            int iA2 = mVar.a();
            mVar.c(mVar.b + 4);
            if (iA2 == c.D0) {
                strA = mVar.a(iA - 12);
            } else if (iA2 == c.E0) {
                strA2 = mVar.a(iA - 12);
            } else {
                if (iA2 == c.F0) {
                    i3 = i5;
                    i4 = iA;
                }
                mVar.c(mVar.b + (iA - 12));
            }
        }
        if (strA == null || strA2 == null || i3 == -1) {
            return null;
        }
        mVar.c(i3);
        mVar.c(mVar.b + 16);
        return new com.smartdigimkt.s0.q(strA, strA2, mVar.a(i4 - 16));
    }

    public static com.smartdigimkt.s0.u b(int i2, com.smartdigimkt.z0.m mVar, String str) {
        int iA = mVar.a();
        if (mVar.a() == c.F0) {
            mVar.c(mVar.b + 8);
            return new com.smartdigimkt.s0.u(str, null, mVar.a(iA - 16));
        }
        c.a(i2);
        return null;
    }

    public static com.smartdigimkt.s0.o a(int i2, String str, com.smartdigimkt.z0.m mVar, boolean z2, boolean z3) {
        int iMin;
        mVar.c(mVar.b + 4);
        if (mVar.a() == c.F0) {
            mVar.c(mVar.b + 8);
            iMin = mVar.e();
        } else {
            iMin = -1;
        }
        if (z3) {
            iMin = Math.min(1, iMin);
        }
        if (iMin < 0) {
            c.a(i2);
            return null;
        }
        if (z2) {
            return new com.smartdigimkt.s0.u(str, null, Integer.toString(iMin));
        }
        return new com.smartdigimkt.s0.j("und", str, Integer.toString(iMin));
    }

    public static com.smartdigimkt.s0.u a(int i2, com.smartdigimkt.z0.m mVar, String str) {
        int iA = mVar.a();
        if (mVar.a() == c.F0 && iA >= 22) {
            mVar.c(mVar.b + 10);
            int iJ = mVar.j();
            if (iJ > 0) {
                String str2 = "" + iJ;
                int iJ2 = mVar.j();
                if (iJ2 > 0) {
                    str2 = str2 + "/" + iJ2;
                }
                return new com.smartdigimkt.s0.u(str, null, str2);
            }
        }
        c.a(i2);
        return null;
    }
}

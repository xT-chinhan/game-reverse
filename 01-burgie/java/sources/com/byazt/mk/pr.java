package com.byazt.mk;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1191, 37})
public class pr implements Comparable {
    public long aj;
    public long fw;
    public long g;
    public long k;
    public int m;
    public long vk;
    public long w;
    public long zo;
    public static int pr = 1;
    public static int hw = 2;
    public static int hn = 3;
    public static int x = 0;
    public static int c = 1;
    public static int uc = 2;
    public static long ho = 0;
    public static long nt = 0;
    public static int yb = 0;

    public long pr() {
        return this.w;
    }

    public void pr(long j) {
        this.w = j;
    }

    public long hw() {
        return this.k;
    }

    public void hw(long j) {
        this.k = j;
    }

    public static long hn() {
        return ho + uc();
    }

    public static long x() {
        return nt + fw();
    }

    public static void pr(int i) {
        hw hwVar = new hw();
        long jW = hn.fw().w();
        List<pr> listPr = hwVar.pr(jW);
        Collections.sort(listPr);
        HashSet hashSet = new HashSet();
        if (listPr != null && !listPr.isEmpty()) {
            ho = 0L;
            nt = 0L;
            yb = 0;
            for (pr prVar : listPr) {
                if (prVar.m() == hw) {
                    nt += pr(prVar, jW);
                } else if (prVar.m() == hn) {
                    ho += prVar.pr();
                } else if (prVar.m() == pr && prVar.fw == jW) {
                    hashSet.add(Long.valueOf(prVar.vk()));
                }
            }
        }
        yb = hashSet.size();
        if (i == c) {
            yb = 1;
        }
        hwVar.pr();
    }

    private static long pr(pr prVar, long j) {
        long j2 = j - 518400000;
        long jZo = prVar.zo();
        if (jZo - prVar.hw() >= j2) {
            return prVar.hw();
        }
        long j3 = jZo - j2;
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public static int c() {
        int i = yb;
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public static void pr(int i, long j, long j2) {
        pr prVar = new pr();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jC = hn.fw().c();
        prVar.x(hn.fw().w());
        prVar.c(jC);
        prVar.hw(i);
        prVar.hn(jCurrentTimeMillis);
        if (i == pr) {
            prVar.pr(0L);
            prVar.hw(0L);
            prVar.fw(0L);
            prVar.uc(0L);
        } else if (i == hw) {
            prVar.pr(0L);
            prVar.hw(j2);
            prVar.fw(0L);
            prVar.uc(jCurrentTimeMillis);
        } else if (i == hn) {
            prVar.pr(j);
            prVar.hw(0L);
            prVar.fw(jCurrentTimeMillis);
            prVar.uc(0L);
        }
        new hw().insert(prVar);
    }

    public static long uc() {
        long jK = hn.fw().k();
        long jCurrentTimeMillis = System.currentTimeMillis() - jK;
        if (hn.fw().m() > jK) {
            return 0L;
        }
        if (jK == 0) {
            return System.currentTimeMillis() - hn.fw().c();
        }
        return jCurrentTimeMillis;
    }

    public static long fw() {
        long jM = hn.fw().m();
        if (hn.fw().k() > jM) {
            return 0L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - jM;
        if (jM == 0) {
            return 0L;
        }
        return jCurrentTimeMillis;
    }

    public long zo() {
        return this.g;
    }

    public void hn(long j) {
        this.g = j;
    }

    public long aj() {
        return this.fw;
    }

    public void x(long j) {
        this.fw = j;
    }

    public long vk() {
        return this.zo;
    }

    public void c(long j) {
        this.zo = j;
    }

    public long w() {
        return this.aj;
    }

    public void uc(long j) {
        this.aj = j;
    }

    public long k() {
        return this.vk;
    }

    public void fw(long j) {
        this.vk = j;
    }

    public int m() {
        return this.m;
    }

    public void hw(int i) {
        this.m = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj == null) {
            return 1;
        }
        pr prVar = (pr) obj;
        if (this.fw > prVar.fw || this.aj > prVar.aj || this.vk > prVar.vk) {
            return 1;
        }
        return 0;
    }
}

package com.byazt.wb;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1324, 19})
public class n implements Comparable {
    public static long cy = 0;
    public static int hd = 0;
    public static long k = 0;
    public static int l = 1;
    public static int n = 1;
    public static int q = 0;
    public static int qg = 2;
    public static int s = 3;
    public static int w = 2;
    public long cp;
    public long d;
    public long fs;
    public int oa;
    public long rv;
    public long sz;
    public long tj;
    public long x;

    public long n() {
        return this.cp;
    }

    public void n(long j) {
        this.cp = j;
    }

    public long qg() {
        return this.d;
    }

    public void qg(long j) {
        this.d = j;
    }

    public static long s() {
        return k + w();
    }

    public static long q() {
        return cy + x();
    }

    public static void n(int i) {
        qg qgVar = new qg();
        long jCp = s.x().cp();
        List<n> listN = qgVar.n(jCp);
        Collections.sort(listN);
        HashSet hashSet = new HashSet();
        if (listN != null && !listN.isEmpty()) {
            k = 0L;
            cy = 0L;
            hd = 0;
            for (n nVar : listN) {
                if (nVar.oa() == qg) {
                    cy += n(nVar, jCp);
                } else if (nVar.oa() == s) {
                    k += nVar.n();
                } else if (nVar.oa() == n && nVar.x == jCp) {
                    hashSet.add(Long.valueOf(nVar.tj()));
                }
            }
        }
        hd = hashSet.size();
        if (i == l) {
            hd = 1;
        }
        qgVar.n();
    }

    private static long n(n nVar, long j) {
        long j2 = j - 518400000;
        long jFs = nVar.fs();
        if (jFs - nVar.qg() >= j2) {
            return nVar.qg();
        }
        long j3 = jFs - j2;
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public static int l() {
        int i = hd;
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public static void n(int i, long j, long j2) {
        n nVar = new n();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jL = s.x().l();
        nVar.q(s.x().cp());
        nVar.l(jL);
        nVar.qg(i);
        nVar.s(jCurrentTimeMillis);
        if (i == n) {
            nVar.n(0L);
            nVar.qg(0L);
            nVar.x(0L);
            nVar.w(0L);
        } else if (i == qg) {
            nVar.n(0L);
            nVar.qg(j2);
            nVar.x(0L);
            nVar.w(jCurrentTimeMillis);
        } else if (i == s) {
            nVar.n(j);
            nVar.qg(0L);
            nVar.x(jCurrentTimeMillis);
            nVar.w(0L);
        }
        new qg().insert(nVar);
    }

    public static long w() {
        long jD = s.x().d();
        long jCurrentTimeMillis = System.currentTimeMillis() - jD;
        if (s.x().oa() > jD) {
            return 0L;
        }
        return jD == 0 ? System.currentTimeMillis() - s.x().l() : jCurrentTimeMillis;
    }

    public static long x() {
        long jOa = s.x().oa();
        if (s.x().d() > jOa) {
            return 0L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - jOa;
        if (jOa == 0) {
            return 0L;
        }
        return jCurrentTimeMillis;
    }

    public long fs() {
        return this.sz;
    }

    public void s(long j) {
        this.sz = j;
    }

    public long rv() {
        return this.x;
    }

    public void q(long j) {
        this.x = j;
    }

    public long tj() {
        return this.fs;
    }

    public void l(long j) {
        this.fs = j;
    }

    public long cp() {
        return this.rv;
    }

    public void w(long j) {
        this.rv = j;
    }

    public long d() {
        return this.tj;
    }

    public void x(long j) {
        this.tj = j;
    }

    public int oa() {
        return this.oa;
    }

    public void qg(int i) {
        this.oa = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj == null) {
            return 1;
        }
        n nVar = (n) obj;
        return (this.x <= nVar.x && this.rv <= nVar.rv && this.tj <= nVar.tj) ? 0 : 1;
    }
}

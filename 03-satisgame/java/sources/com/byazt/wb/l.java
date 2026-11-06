package com.byazt.wb;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1324, 18})
public class l {
    public static int l = 3;
    public static int n = -1;
    public static int q = 2;
    public static int qg = 0;
    public static int s = 1;
    public int w = n;
    public long x = 0;
    public long fs = 0;
    public long rv = 0;
    public final List<w> tj = new ArrayList();

    public void n(long j) {
        this.w = qg;
        this.x = j;
    }

    public void qg(long j) {
        int i;
        int i2 = this.w;
        if (i2 == n || i2 == (i = l)) {
            return;
        }
        this.w = i;
        this.rv = j;
    }

    public void s(long j) {
        int i;
        int i2 = this.w;
        if (i2 == n || i2 == (i = q) || i2 == l) {
            return;
        }
        this.w = i;
        this.fs = j;
    }

    public void q(long j) {
        int i = this.w;
        if (i == n || i != q) {
            return;
        }
        this.w = s;
        this.tj.add(new w(this.fs, j));
        this.fs = 0L;
    }

    public long n(long j, long j2) {
        long j3;
        long j4;
        long jQg;
        long j5 = this.rv;
        if (j5 != 0 && j > j5) {
            return 0L;
        }
        int i = 0;
        for (w wVar : this.tj) {
            if (wVar.qg() > j) {
                if (j < wVar.n()) {
                    j4 = i;
                    jQg = wVar.qg() - wVar.n();
                } else {
                    j4 = i;
                    jQg = wVar.qg() - j;
                }
                i = (int) (j4 + jQg);
            }
        }
        long j6 = this.x;
        if (j6 < j) {
            long j7 = this.fs;
            if (j7 == 0) {
                j7 = this.rv;
                if (j7 == 0) {
                    j3 = j2 - j;
                }
            } else if (j7 <= j) {
                return 0L;
            }
            return (j7 - j) - ((long) i);
        }
        long j8 = this.fs;
        if (j8 == 0) {
            j8 = this.rv;
            if (j8 == 0) {
                j3 = j2 - j6;
            }
        } else if (j8 <= j6) {
            return 0L;
        }
        return (j8 - j6) - ((long) i);
        return j3 - ((long) i);
    }

    public int n() {
        return this.w;
    }
}

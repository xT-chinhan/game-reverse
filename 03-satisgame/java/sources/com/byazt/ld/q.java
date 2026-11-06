package com.byazt.ld;

import com.byazt.aw.cy;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1423, 5})
public class q {
    public final String l;
    public final List<cy> n;
    public final double q;
    public final char qg;
    public final double s;
    public final String w;

    public static int n(char c, String str, String str2) {
        return (((c * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public q(List<cy> list, char c, double d, double d2, String str, String str2) {
        this.n = list;
        this.qg = c;
        this.s = d;
        this.q = d2;
        this.l = str;
        this.w = str2;
    }

    public List<cy> n() {
        return this.n;
    }

    public double qg() {
        return this.q;
    }

    public int hashCode() {
        return n(this.qg, this.w, this.l);
    }
}

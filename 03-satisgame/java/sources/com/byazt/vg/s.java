package com.byazt.vg;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1067, 8})
public class s {
    public String fs;
    public int l;
    public int n;
    public long rv;
    public int w;
    public int x;
    public long qg = 0;
    public long s = 0;
    public long q = 0;
    public final long tj = 30;

    public long l() {
        return 28L;
    }

    public int n() {
        return this.n;
    }

    public void n(int i) {
        this.n = i;
    }

    public long qg() {
        long j = this.s;
        return j > 0 ? j : this.q;
    }

    public long s() {
        return q() + qg();
    }

    public long q() {
        return ((long) this.l) + 30 + ((long) this.x);
    }

    public void qg(int i) {
        this.x = i;
    }

    public int w() {
        return this.x;
    }

    public long x() {
        return this.qg;
    }

    public void n(long j) {
        this.qg = j;
    }

    public long fs() {
        return this.s;
    }

    public void qg(long j) {
        this.s = j;
    }

    public long rv() {
        return this.q;
    }

    public void s(long j) {
        this.q = j;
    }

    public int tj() {
        return this.l;
    }

    public void s(int i) {
        this.l = i;
    }

    public int cp() {
        return this.w;
    }

    public void q(int i) {
        this.w = i;
    }

    public String d() {
        return this.fs;
    }

    public void n(String str) {
        this.fs = str;
    }

    public long oa() {
        return this.rv;
    }

    public void q(long j) {
        this.rv = j;
    }
}

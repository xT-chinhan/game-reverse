package com.byazt.gdj;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2284, 21})
public class x {
    public String n;
    public long q;
    public long qg;
    public long s;

    public String getType() {
        return this.n;
    }

    public void n(String str) {
        this.n = str;
    }

    public long n() {
        return this.qg;
    }

    public void n(long j) {
        this.qg = j;
    }

    public long qg() {
        return this.s;
    }

    public void qg(long j) {
        this.s = j;
    }

    public long s() {
        return this.q;
    }

    public void s(long j) {
        this.q = j;
    }

    public boolean q() {
        return "cross_session".equals(this.n);
    }
}

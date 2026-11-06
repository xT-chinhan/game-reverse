package com.byazt.ws;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 890, 18})
public class l implements Comparable<l> {
    public String n;
    public int q;
    public double qg;
    public int s;

    public l(String str, double d, int i, int i2) {
        this.n = str;
        this.qg = d;
        this.s = i;
        this.q = i2;
    }

    public String n() {
        return this.n;
    }

    public double qg() {
        return this.qg;
    }

    public int s() {
        return this.s;
    }

    public int q() {
        return this.q;
    }

    public String toString() {
        return "{mCsjRitId:" + this.n + ",mEcpm:" + this.qg + ",mLoadSort:" + this.s + ",mShowSort:" + this.q + "}";
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int compareTo(l lVar) {
        if (lVar == null) {
            return 1;
        }
        if (this.qg > lVar.qg()) {
            return -1;
        }
        if (this.qg < lVar.qg() || this.s > lVar.s()) {
            return 1;
        }
        if (this.s < lVar.s()) {
            return -1;
        }
        if (this.q > lVar.q()) {
            return 1;
        }
        return this.q < lVar.q() ? -1 : 0;
    }
}

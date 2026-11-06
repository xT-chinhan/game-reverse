package com.byazt.yvo;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1177, 26})
public class qg {
    public int l;
    public String n;
    public int q;
    public String qg;
    public long s;

    public qg(String str, String str2, long j) {
        this.q = -1;
        this.l = -1;
        this.n = str;
        this.qg = str2;
        this.s = j;
    }

    public qg(String str, String str2, long j, int i) {
        this.l = -1;
        this.n = str;
        this.qg = str2;
        this.s = j;
        this.q = i;
    }

    public String n() {
        return this.qg;
    }

    public String qg() {
        return this.n;
    }

    public long s() {
        return this.s;
    }

    public int q() {
        return this.q;
    }

    public int l() {
        return this.l;
    }

    public void n(int i) {
        this.l = i;
    }
}

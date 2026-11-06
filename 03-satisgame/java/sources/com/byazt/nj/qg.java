package com.byazt.nj;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1070, 26})
public final class qg {
    public int n;
    public int q;
    public int qg;
    public int s;

    public qg(int i, int i2, int i3) {
        this(i, i2, i3, 0);
    }

    public qg(int i, int i2, int i3, int i4) {
        this.n = i;
        this.qg = i2;
        this.s = i3;
        this.q = i4;
    }

    public static qg n() {
        return n(0);
    }

    public static qg n(int i) {
        return new qg(-1, -1, 0, i);
    }

    public int qg() {
        return this.n;
    }

    public int s() {
        return this.qg;
    }

    public int q() {
        return this.s;
    }

    public int l() {
        return this.q;
    }

    public void w() {
        this.q = 1;
    }

    public void update(int i, int i2, int i3) {
        this.n = i;
        this.qg = i2;
        this.s = i3;
    }
}

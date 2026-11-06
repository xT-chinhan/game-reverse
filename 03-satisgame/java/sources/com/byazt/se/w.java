package com.byazt.se;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1270, 13})
public class w extends n {
    public long fs;
    public boolean l;
    public com.byazt.gct.n q;
    public long rv;
    public long w;
    public long x;

    public w(com.byazt.gct.n nVar, boolean z) {
        this.q = nVar;
        if (nVar != null && nVar.qg() != null && !this.q.qg().isEmpty()) {
            this.qg = this.q.qg().get(0);
        }
        this.l = z;
    }

    public com.byazt.gct.n q() {
        return this.q;
    }

    public boolean l() {
        return this.l;
    }

    public long w() {
        return this.w;
    }

    public void qg(long j) {
        this.w = j;
    }

    public long x() {
        return this.x;
    }

    public void s(long j) {
        this.x = j;
    }

    public long fs() {
        return this.fs;
    }

    public void q(long j) {
        this.fs = j;
    }

    public long rv() {
        return this.rv;
    }

    public void l(long j) {
        this.rv = j;
    }
}

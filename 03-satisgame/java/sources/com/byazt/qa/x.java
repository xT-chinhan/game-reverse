package com.byazt.qa;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 944, 21})
public class x implements Comparable<x> {
    public com.byazt.sg.s n;
    public com.byazt.qn.qg q;
    public long qg;
    public boolean s = false;

    public x(com.byazt.sg.s sVar, long j, com.byazt.qn.qg qgVar) {
        this.n = sVar;
        this.qg = j;
        this.q = qgVar;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int compareTo(x xVar) {
        return this.n.compareTo(xVar.n);
    }

    public long n() {
        return this.qg;
    }

    public String qg() {
        com.byazt.sg.s sVar = this.n;
        if (sVar == null) {
            return null;
        }
        return sVar.el();
    }

    public boolean s() {
        return this.s;
    }

    public void n(boolean z) {
        this.s = z;
    }

    public com.byazt.qn.qg q() {
        return this.q;
    }

    public boolean l() {
        com.byazt.sg.s sVar = this.n;
        return (sVar == null || this.q == null || sVar.nf() || !this.n.ae(this.q.a())) ? false : true;
    }

    public String w() {
        com.byazt.qn.qg qgVar = this.q;
        if (qgVar == null) {
            return null;
        }
        return qgVar.a();
    }

    public void qg(boolean z) {
        com.byazt.sg.s sVar = this.n;
        if (sVar == null) {
            return;
        }
        sVar.n(z);
    }

    public boolean x() {
        com.byazt.sg.s sVar = this.n;
        if (sVar == null) {
            return false;
        }
        return sVar.ou();
    }
}

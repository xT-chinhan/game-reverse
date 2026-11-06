package com.byazt.ce;

import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.re.w;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1259, 8})
public class s {
    public int l;
    public final int q;
    public final w w;
    public final com.byazt.has.n x;
    public int n = 0;
    public int qg = 0;
    public int s = 1000;

    public s(boolean z, pk pkVar, w wVar, com.byazt.has.n nVar) {
        int iQ;
        this.w = wVar;
        this.x = nVar;
        if (z) {
            iQ = rv.qg().s(com.byazt.vgx.w.cy(pkVar));
        } else {
            iQ = rv.qg().q(com.byazt.vgx.w.cy(pkVar));
        }
        this.q = iQ;
    }

    public long n() {
        return this.w.bb();
    }

    public int qg() {
        return this.l;
    }

    public void n(int i) {
        this.l += i;
    }

    public int s() {
        return this.q;
    }

    public int q() {
        return this.x.df();
    }

    public int l() {
        return this.n;
    }

    public int w() {
        return this.qg;
    }

    public void x() {
        this.n++;
    }

    public void fs() {
        this.qg++;
    }

    public void qg(int i) {
        this.qg = i;
    }

    public void s(int i) {
        this.s = i;
    }

    public int rv() {
        return this.s;
    }
}

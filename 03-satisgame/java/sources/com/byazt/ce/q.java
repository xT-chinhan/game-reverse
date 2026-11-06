package com.byazt.ce;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1259, 5})
public class q implements com.byazt.ot.n.qg {
    public long n;
    public long qg;
    public long s;

    @Override // com.byazt.ot.n.qg
    public void q() {
    }

    @Override // com.byazt.ot.n.qg
    public void s() {
    }

    public q() {
        com.byazt.vyf.s.cy().n(this);
    }

    public void l() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.qg;
        if (j != 0) {
            this.n += jCurrentTimeMillis - j;
        }
        this.qg = jCurrentTimeMillis;
    }

    public void w() {
        if (this.qg == 0) {
            return;
        }
        this.n += System.currentTimeMillis() - this.qg;
        this.qg = 0L;
        this.s = 0L;
    }

    public long n(TimeUnit timeUnit) {
        if (timeUnit != null) {
            return timeUnit.convert(this.n, TimeUnit.MILLISECONDS);
        }
        return this.n;
    }

    public void x() {
        this.qg = 0L;
        this.s = 0L;
        this.n = 0L;
    }

    public void fs() {
        com.byazt.vyf.s.cy().qg(this);
    }

    @Override // com.byazt.ot.n.qg
    public void n() {
        w();
    }

    @Override // com.byazt.ot.n.qg
    public void qg() {
        l();
    }
}

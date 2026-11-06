package com.byazt.xx;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 719, 5})
public class q {
    public double n;
    public n qg;

    public interface n {
        void n(double d, double d2);
    }

    public void n(n nVar) {
        this.qg = nVar;
    }

    public double n() {
        return this.n;
    }

    public void n(double d) {
        double d2 = this.n;
        double d3 = d2 + d;
        if (d3 < 0.0d) {
            d3 = 0.0d;
        }
        if (d3 != d2) {
            this.n = d3;
            n nVar = this.qg;
            if (nVar != null) {
                nVar.n(d3, d);
            }
        }
    }

    public void qg() {
        this.n = 0.0d;
    }
}

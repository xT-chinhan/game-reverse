package com.byazt.edb;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 444, 121})
public class x {
    public double hn = -1.0d;
    public final int hw;
    public final double pr;
    public int x;

    public x(double d) {
        this.pr = d;
        this.hw = d == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d);
    }

    public void pr(double d) {
        double d2 = 1.0d - this.pr;
        int i = this.x;
        if (i > this.hw) {
            this.hn = Math.exp((d2 * Math.log(this.hn)) + (this.pr * Math.log(d)));
        } else if (i > 0) {
            double d3 = (d2 * ((double) i)) / (((double) i) + 1.0d);
            this.hn = Math.exp((d3 * Math.log(this.hn)) + ((1.0d - d3) * Math.log(d)));
        } else {
            this.hn = d;
        }
        this.x++;
    }

    public double pr() {
        return this.hn;
    }
}

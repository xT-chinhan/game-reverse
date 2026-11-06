package com.byazt.bw;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1399, 19})
public class n {
    public String cp;
    public String l;
    public double n;
    public double q;
    public double qg;
    public double s;
    public String tj;
    public int w;
    public int x = 0;
    public int fs = 0;
    public int rv = 0;

    public n(double d, double d2, double d3, double d4, int i, String str) {
        this.n = d;
        this.qg = d2;
        this.s = d3;
        this.q = d4;
        this.l = str;
        this.w = i;
    }

    public String toString() {
        return "adnName = " + this.tj + " adnRit = " + this.cp + ", send = " + this.x + ", fill = " + this.fs + ", show = " + this.rv + " localSsr = " + this.n + ", serviceSsr = " + this.s + ", localSrr = " + this.qg + ", serviceSrr = " + this.q + ", opt = " + this.l + ", condition = " + this.w + ", compareBehaviorSsr = " + q() + ", compareBehaviorSrr = " + l() + ", checkBehaviorRule = " + n();
    }

    public boolean n() {
        return q();
    }

    private boolean q() {
        return n(this.n, this.s);
    }

    private boolean l() {
        return n(this.qg, this.q);
    }

    private boolean n(double d, double d2) {
        String str = this.l;
        str.hashCode();
        switch (str) {
            case "1":
                return d > d2;
            case "2":
                return d < d2;
            case "3":
                return d >= d2;
            case "4":
                return d <= d2;
            case "5":
                return d == d2;
            default:
                return true;
        }
    }

    public double qg() {
        return this.n;
    }

    public double s() {
        return this.qg;
    }

    public void n(int i) {
        this.x = i;
    }

    public void qg(int i) {
        this.fs = i;
    }

    public void s(int i) {
        this.rv = i;
    }

    public void n(String str) {
        this.tj = str;
    }

    public void qg(String str) {
        this.cp = str;
    }
}

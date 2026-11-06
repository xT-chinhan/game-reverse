package com.byazt.prf;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 102, 210})
public class k {
    public final qg n;
    public n qg = new n();

    interface qg {
        int n();

        int n(View view);

        View n(int i);

        int qg();

        int qg(View view);
    }

    public k(qg qgVar) {
        this.n = qgVar;
    }

    public View n(int i, int i2, int i3, int i4) {
        int iN = this.n.n();
        int iQg = this.n.qg();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewN = this.n.n(i);
            this.qg.n(iN, iQg, this.n.n(viewN), this.n.qg(viewN));
            if (i3 != 0) {
                this.qg.n();
                this.qg.n(i3);
                if (this.qg.qg()) {
                    return viewN;
                }
            }
            if (i4 != 0) {
                this.qg.n();
                this.qg.n(i4);
                if (this.qg.qg()) {
                    view = viewN;
                }
            }
            i += i5;
        }
        return view;
    }

    public boolean n(View view, int i) {
        this.qg.n(this.n.n(), this.n.qg(), this.n.n(view), this.n.qg(view));
        if (i == 0) {
            return false;
        }
        this.qg.n();
        this.qg.n(i);
        return this.qg.qg();
    }

    @com.byazt.cp.n(n = {0, 1, 102, 116})
    static class n {
        public int l;
        public int n = 0;
        public int q;
        public int qg;
        public int s;

        public int n(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        public void n(int i, int i2, int i3, int i4) {
            this.qg = i;
            this.s = i2;
            this.q = i3;
            this.l = i4;
        }

        public void n(int i) {
            this.n = i | this.n;
        }

        public void n() {
            this.n = 0;
        }

        public boolean qg() {
            int i = this.n;
            if ((i & 7) != 0 && (i & (n(this.q, this.qg) << 0)) == 0) {
                return false;
            }
            int i2 = this.n;
            if ((i2 & 112) != 0 && (i2 & (n(this.q, this.s) << 4)) == 0) {
                return false;
            }
            int i3 = this.n;
            if ((i3 & 1792) != 0 && (i3 & (n(this.l, this.qg) << 8)) == 0) {
                return false;
            }
            int i4 = this.n;
            return (i4 & 28672) == 0 || (i4 & (n(this.l, this.s) << 12)) != 0;
        }
    }
}

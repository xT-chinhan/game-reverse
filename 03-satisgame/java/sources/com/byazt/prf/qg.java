package com.byazt.prf;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 102, 26})
public class qg {
    public final InterfaceC0305qg n;
    public final n qg = new n();
    public final List<View> s = new ArrayList();

    /* JADX INFO: renamed from: com.byazt.prf.qg$qg, reason: collision with other inner class name */
    interface InterfaceC0305qg {
        int n();

        int n(View view);

        void n(int i);

        void n(View view, int i);

        void n(View view, int i, ViewGroup.LayoutParams layoutParams);

        void q(View view);

        View qg(int i);

        RecyclerView.m qg(View view);

        void qg();

        void s(int i);

        void s(View view);
    }

    public qg(InterfaceC0305qg interfaceC0305qg) {
        this.n = interfaceC0305qg;
    }

    private void x(View view) {
        this.s.add(view);
        this.n.s(view);
    }

    private boolean fs(View view) {
        if (!this.s.remove(view)) {
            return false;
        }
        this.n.q(view);
        return true;
    }

    public void n(View view, boolean z) {
        n(view, -1, z);
    }

    public void n(View view, int i, boolean z) {
        int iW;
        if (i < 0) {
            iW = this.n.n();
        } else {
            iW = w(i);
        }
        this.qg.insert(iW, z);
        if (z) {
            x(view);
        }
        this.n.n(view, iW);
    }

    private int w(int i) {
        if (i < 0) {
            return -1;
        }
        int iN = this.n.n();
        int i2 = i;
        while (i2 < iN) {
            int iL = i - (i2 - this.qg.l(i2));
            if (iL == 0) {
                while (this.qg.s(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iL;
        }
        return -1;
    }

    public void n(View view) {
        int iN = this.n.n(view);
        if (iN >= 0) {
            if (this.qg.q(iN)) {
                fs(view);
            }
            this.n.n(iN);
        }
    }

    public void n(int i) {
        int iW = w(i);
        View viewQg = this.n.qg(iW);
        if (viewQg != null) {
            if (this.qg.q(iW)) {
                fs(viewQg);
            }
            this.n.n(iW);
        }
    }

    public View qg(int i) {
        return this.n.qg(w(i));
    }

    public void n() {
        this.qg.n();
        for (int size = this.s.size() - 1; size >= 0; size--) {
            this.n.q(this.s.get(size));
            this.s.remove(size);
        }
        this.n.qg();
    }

    public View s(int i) {
        int size = this.s.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.s.get(i2);
            RecyclerView.m mVarQg = this.n.qg(view);
            if (mVarQg.q() == i && !mVarQg.sz() && !mVarQg.hd()) {
                return view;
            }
        }
        return null;
    }

    public void n(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iW;
        if (i < 0) {
            iW = this.n.n();
        } else {
            iW = w(i);
        }
        this.qg.insert(iW, z);
        if (z) {
            x(view);
        }
        this.n.n(view, iW, layoutParams);
    }

    public int qg() {
        return this.n.n() - this.s.size();
    }

    public int s() {
        return this.n.n();
    }

    public View q(int i) {
        return this.n.qg(i);
    }

    public void l(int i) {
        int iW = w(i);
        this.qg.q(iW);
        this.n.s(iW);
    }

    public int qg(View view) {
        int iN = this.n.n(view);
        if (iN == -1 || this.qg.s(iN)) {
            return -1;
        }
        return iN - this.qg.l(iN);
    }

    public boolean s(View view) {
        return this.s.contains(view);
    }

    public void q(View view) {
        int iN = this.n.n(view);
        if (iN < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
        }
        this.qg.n(iN);
        x(view);
    }

    public void l(View view) {
        int iN = this.n.n(view);
        if (iN < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
        }
        if (!this.qg.s(iN)) {
            throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(view)));
        }
        this.qg.qg(iN);
        fs(view);
    }

    public String toString() {
        return this.qg.toString() + ", hidden list:" + this.s.size();
    }

    public boolean w(View view) {
        int iN = this.n.n(view);
        if (iN == -1) {
            fs(view);
            return true;
        }
        if (!this.qg.s(iN)) {
            return false;
        }
        this.qg.q(iN);
        fs(view);
        this.n.n(iN);
        return true;
    }

    @com.byazt.cp.n(n = {0, 1, 102, 48})
    static class n {
        public long n = 0;
        public n qg;

        public void n(int i) {
            if (i >= 64) {
                qg();
                this.qg.n(i - 64);
            } else {
                this.n |= 1 << i;
            }
        }

        private void qg() {
            if (this.qg == null) {
                this.qg = new n();
            }
        }

        public void qg(int i) {
            if (i >= 64) {
                n nVar = this.qg;
                if (nVar != null) {
                    nVar.qg(i - 64);
                    return;
                }
                return;
            }
            this.n &= ~(1 << i);
        }

        public boolean s(int i) {
            if (i < 64) {
                return (this.n & (1 << i)) != 0;
            }
            qg();
            return this.qg.s(i - 64);
        }

        public void n() {
            this.n = 0L;
            n nVar = this.qg;
            if (nVar != null) {
                nVar.n();
            }
        }

        public void insert(int i, boolean z) {
            if (i >= 64) {
                qg();
                this.qg.insert(i - 64, z);
                return;
            }
            long j = this.n;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.n = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                n(i);
            } else {
                qg(i);
            }
            if (z2 || this.qg != null) {
                qg();
                this.qg.insert(0, z2);
            }
        }

        public boolean q(int i) {
            if (i >= 64) {
                qg();
                return this.qg.q(i - 64);
            }
            long j = 1 << i;
            long j2 = this.n;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (~j);
            this.n = j3;
            long j4 = j - 1;
            this.n = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            n nVar = this.qg;
            if (nVar != null) {
                if (nVar.s(0)) {
                    n(63);
                }
                this.qg.q(0);
            }
            return z;
        }

        public int l(int i) {
            n nVar = this.qg;
            if (nVar == null) {
                return i >= 64 ? Long.bitCount(this.n) : Long.bitCount(this.n & ((1 << i) - 1));
            }
            return i < 64 ? Long.bitCount(this.n & ((1 << i) - 1)) : nVar.l(i - 64) + Long.bitCount(this.n);
        }

        public String toString() {
            return this.qg == null ? Long.toBinaryString(this.n) : this.qg.toString() + "xx" + Long.toBinaryString(this.n);
        }
    }
}

package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final InterfaceC0253xr f1431ms;
    final ms xr = new ms();
    final List<View> ah = new ArrayList();

    /* JADX INFO: renamed from: com.bytedance.sdk.component.widget.recycler.xr$xr, reason: collision with other inner class name */
    interface InterfaceC0253xr {
        void ah(int i);

        void ah(View view);

        void d(View view);

        int ms();

        int ms(View view);

        void ms(int i);

        void ms(View view, int i);

        void ms(View view, int i, ViewGroup.LayoutParams layoutParams);

        View xr(int i);

        RecyclerView.re xr(View view);

        void xr();
    }

    xr(InterfaceC0253xr interfaceC0253xr) {
        this.f1431ms = interfaceC0253xr;
    }

    private void ab(View view) {
        this.ah.add(view);
        this.f1431ms.ah(view);
    }

    private boolean x(View view) {
        if (!this.ah.remove(view)) {
            return false;
        }
        this.f1431ms.d(view);
        return true;
    }

    void ms(View view, boolean z) {
        ms(view, -1, z);
    }

    void ms(View view, int i, boolean z) {
        int iC;
        if (i < 0) {
            iC = this.f1431ms.ms();
        } else {
            iC = c(i);
        }
        this.xr.insert(iC, z);
        if (z) {
            ab(view);
        }
        this.f1431ms.ms(view, iC);
    }

    private int c(int i) {
        if (i < 0) {
            return -1;
        }
        int iMs = this.f1431ms.ms();
        int i2 = i;
        while (i2 < iMs) {
            int iKa = i - (i2 - this.xr.ka(i2));
            if (iKa == 0) {
                while (this.xr.ah(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iKa;
        }
        return -1;
    }

    void ms(View view) {
        int iMs = this.f1431ms.ms(view);
        if (iMs >= 0) {
            if (this.xr.d(iMs)) {
                x(view);
            }
            this.f1431ms.ms(iMs);
        }
    }

    void ms(int i) {
        int iC = c(i);
        View viewXr = this.f1431ms.xr(iC);
        if (viewXr != null) {
            if (this.xr.d(iC)) {
                x(viewXr);
            }
            this.f1431ms.ms(iC);
        }
    }

    View xr(int i) {
        return this.f1431ms.xr(c(i));
    }

    void ms() {
        this.xr.ms();
        for (int size = this.ah.size() - 1; size >= 0; size--) {
            this.f1431ms.d(this.ah.get(size));
            this.ah.remove(size);
        }
        this.f1431ms.xr();
    }

    View ah(int i) {
        int size = this.ah.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.ah.get(i2);
            RecyclerView.re reVarXr = this.f1431ms.xr(view);
            if (reVarXr.d() == i && !reVarXr.u() && !reVarXr.h()) {
                return view;
            }
        }
        return null;
    }

    void ms(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iC;
        if (i < 0) {
            iC = this.f1431ms.ms();
        } else {
            iC = c(i);
        }
        this.xr.insert(iC, z);
        if (z) {
            ab(view);
        }
        this.f1431ms.ms(view, iC, layoutParams);
    }

    int xr() {
        return this.f1431ms.ms() - this.ah.size();
    }

    int ah() {
        return this.f1431ms.ms();
    }

    View d(int i) {
        return this.f1431ms.xr(i);
    }

    void ka(int i) {
        int iC = c(i);
        this.xr.d(iC);
        this.f1431ms.ah(iC);
    }

    int xr(View view) {
        int iMs = this.f1431ms.ms(view);
        if (iMs == -1 || this.xr.ah(iMs)) {
            return -1;
        }
        return iMs - this.xr.ka(iMs);
    }

    boolean ah(View view) {
        return this.ah.contains(view);
    }

    void d(View view) {
        int iMs = this.f1431ms.ms(view);
        if (iMs < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
        }
        this.xr.ms(iMs);
        ab(view);
    }

    void ka(View view) {
        int iMs = this.f1431ms.ms(view);
        if (iMs < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
        }
        if (!this.xr.ah(iMs)) {
            throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(view)));
        }
        this.xr.xr(iMs);
        x(view);
    }

    public String toString() {
        return this.xr.toString() + ", hidden list:" + this.ah.size();
    }

    boolean c(View view) {
        int iMs = this.f1431ms.ms(view);
        if (iMs == -1) {
            x(view);
            return true;
        }
        if (!this.xr.ah(iMs)) {
            return false;
        }
        this.xr.d(iMs);
        x(view);
        this.f1431ms.ms(iMs);
        return true;
    }

    static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        long f1432ms = 0;
        ms xr;

        ms() {
        }

        void ms(int i) {
            if (i >= 64) {
                xr();
                this.xr.ms(i - 64);
            } else {
                this.f1432ms |= 1 << i;
            }
        }

        private void xr() {
            if (this.xr == null) {
                this.xr = new ms();
            }
        }

        void xr(int i) {
            if (i >= 64) {
                ms msVar = this.xr;
                if (msVar != null) {
                    msVar.xr(i - 64);
                    return;
                }
                return;
            }
            this.f1432ms &= ~(1 << i);
        }

        boolean ah(int i) {
            if (i < 64) {
                return (this.f1432ms & (1 << i)) != 0;
            }
            xr();
            return this.xr.ah(i - 64);
        }

        void ms() {
            this.f1432ms = 0L;
            ms msVar = this.xr;
            if (msVar != null) {
                msVar.ms();
            }
        }

        void insert(int i, boolean z) {
            if (i >= 64) {
                xr();
                this.xr.insert(i - 64, z);
                return;
            }
            long j = this.f1432ms;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.f1432ms = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                ms(i);
            } else {
                xr(i);
            }
            if (z2 || this.xr != null) {
                xr();
                this.xr.insert(0, z2);
            }
        }

        boolean d(int i) {
            if (i >= 64) {
                xr();
                return this.xr.d(i - 64);
            }
            long j = 1 << i;
            long j2 = this.f1432ms;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (~j);
            this.f1432ms = j3;
            long j4 = j - 1;
            this.f1432ms = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            ms msVar = this.xr;
            if (msVar != null) {
                if (msVar.ah(0)) {
                    ms(63);
                }
                this.xr.d(0);
            }
            return z;
        }

        int ka(int i) {
            ms msVar = this.xr;
            if (msVar == null) {
                return i >= 64 ? Long.bitCount(this.f1432ms) : Long.bitCount(this.f1432ms & ((1 << i) - 1));
            }
            return i < 64 ? Long.bitCount(this.f1432ms & ((1 << i) - 1)) : msVar.ka(i - 64) + Long.bitCount(this.f1432ms);
        }

        public String toString() {
            return this.xr == null ? Long.toBinaryString(this.f1432ms) : this.xr.toString() + "xx" + Long.toBinaryString(this.f1432ms);
        }
    }
}

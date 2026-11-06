package com.bytedance.sdk.component.widget.recycler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
final class d implements Runnable {
    long ah;
    long d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final ThreadLocal<d> f1410ms = new ThreadLocal<>();
    static Comparator<xr> ka = new Comparator<xr>() { // from class: com.bytedance.sdk.component.widget.recycler.d.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public int compare(xr xrVar, xr xrVar2) {
            if ((xrVar.d == null) != (xrVar2.d == null)) {
                return xrVar.d == null ? 1 : -1;
            }
            if (xrVar.f1412ms != xrVar2.f1412ms) {
                return xrVar.f1412ms ? -1 : 1;
            }
            int i = xrVar2.xr - xrVar.xr;
            if (i != 0) {
                return i;
            }
            int i2 = xrVar.ah - xrVar2.ah;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };
    ArrayList<RecyclerView> xr = new ArrayList<>();
    private ArrayList<xr> c = new ArrayList<>();

    d() {
    }

    public void ms(RecyclerView recyclerView) {
        this.xr.add(recyclerView);
    }

    public void xr(RecyclerView recyclerView) {
        this.xr.remove(recyclerView);
    }

    void ms(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.ah == 0) {
            this.ah = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.le.ms(i, i2);
    }

    private void ms() {
        xr xrVar;
        int size = this.xr.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.xr.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.le.ms(recyclerView, false);
                i += recyclerView.le.d;
            }
        }
        this.c.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.xr.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                ms msVar = recyclerView2.le;
                int iAbs = Math.abs(msVar.f1411ms) + Math.abs(msVar.xr);
                for (int i5 = 0; i5 < msVar.d * 2; i5 += 2) {
                    if (i3 >= this.c.size()) {
                        xrVar = new xr();
                        this.c.add(xrVar);
                    } else {
                        xrVar = this.c.get(i3);
                    }
                    int i6 = msVar.ah[i5 + 1];
                    xrVar.f1412ms = i6 <= iAbs;
                    xrVar.xr = iAbs;
                    xrVar.ah = i6;
                    xrVar.d = recyclerView2;
                    xrVar.ka = msVar.ah[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.c, ka);
    }

    static boolean ms(RecyclerView recyclerView, int i) {
        int iAh = recyclerView.ab.ah();
        for (int i2 = 0; i2 < iAh; i2++) {
            RecyclerView.re reVarKa = RecyclerView.ka(recyclerView.ab.d(i2));
            if (reVarKa.ah == i && !reVarKa.u()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.re ms(RecyclerView recyclerView, int i, long j) {
        if (ms(recyclerView, i)) {
            return null;
        }
        RecyclerView.ao aoVar = recyclerView.ka;
        try {
            recyclerView.sl();
            RecyclerView.re reVarMs = aoVar.ms(i, false, j);
            if (reVarMs != null) {
                if (reVarMs.ao() && !reVarMs.u()) {
                    aoVar.ms(reVarMs.f1391ms);
                } else {
                    aoVar.ms(reVarMs, false);
                }
            }
            return reVarMs;
        } finally {
            recyclerView.xr(false);
        }
    }

    private void ms(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.re && recyclerView.ab.ah() != 0) {
                recyclerView.ah();
            }
            ms msVar = recyclerView.le;
            msVar.ms(recyclerView, true);
            if (msVar.d != 0) {
                try {
                    com.bytedance.sdk.component.widget.recycler.ms.ms.ms.ms("RV Nested Prefetch");
                    recyclerView.cv.ms(recyclerView.zb);
                    for (int i = 0; i < msVar.d * 2; i += 2) {
                        ms(recyclerView, msVar.ah[i], j);
                    }
                    com.bytedance.sdk.component.widget.recycler.ms.ms.ms.ms();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.widget.recycler.ms.ms.ms.ms();
                    throw th;
                }
            }
        }
    }

    private void ms(xr xrVar, long j) {
        RecyclerView.re reVarMs = ms(xrVar.d, xrVar.ka, xrVar.f1412ms ? Long.MAX_VALUE : j);
        if (reVarMs == null || reVarMs.xr == null || !reVarMs.ao() || reVarMs.u()) {
            return;
        }
        ms(reVarMs.xr.get(), j);
    }

    private void xr(long j) {
        for (int i = 0; i < this.c.size(); i++) {
            xr xrVar = this.c.get(i);
            if (xrVar.d == null) {
                return;
            }
            ms(xrVar, j);
            xrVar.ms();
        }
    }

    void ms(long j) {
        ms();
        xr(j);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.bytedance.sdk.component.widget.recycler.ms.ms.ms.ms("RV Prefetch");
            if (!this.xr.isEmpty()) {
                int size = this.xr.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.xr.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    ms(TimeUnit.MILLISECONDS.toNanos(jMax) + this.d);
                }
            }
        } finally {
            this.ah = 0L;
            com.bytedance.sdk.component.widget.recycler.ms.ms.ms.ms();
        }
    }

    static class ms implements RecyclerView.ny.ms {
        int[] ah;
        int d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        int f1411ms;
        int xr;

        ms() {
        }

        void ms(int i, int i2) {
            this.f1411ms = i;
            this.xr = i2;
        }

        void ms(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            int[] iArr = this.ah;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.ny nyVar = recyclerView.u;
            if (recyclerView.zb == null || nyVar == null || !nyVar.u()) {
                return;
            }
            if (z) {
                if (!recyclerView.c.d()) {
                    nyVar.ms(recyclerView.zb.ms(), this);
                }
            } else if (!recyclerView.nw()) {
                nyVar.ms(this.f1411ms, this.xr, recyclerView.cv, this);
            }
            if (this.d > nyVar.ao) {
                nyVar.ao = this.d;
                nyVar.h = z;
                recyclerView.ka.xr();
            }
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ny.ms
        public void xr(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.d * 2;
            int[] iArr = this.ah;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.ah = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[i3 * 2];
                this.ah = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.ah;
            iArr4[i3] = i;
            iArr4[i3 + 1] = i2;
            this.d++;
        }

        boolean ms(int i) {
            if (this.ah != null) {
                int i2 = this.d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.ah[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        void ms() {
            int[] iArr = this.ah;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.d = 0;
        }
    }

    static class xr {
        public int ah;
        public RecyclerView d;
        public int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public boolean f1412ms;
        public int xr;

        xr() {
        }

        public void ms() {
            this.f1412ms = false;
            this.xr = 0;
            this.ah = 0;
            this.d = null;
            this.ka = 0;
        }
    }
}

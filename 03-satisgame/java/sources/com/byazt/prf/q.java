package com.byazt.prf;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 102, 5})
public final class q implements Runnable {
    public long q;
    public long s;
    public static final ThreadLocal<q> n = new ThreadLocal<>();
    public static Comparator<qg> l = new Comparator<qg>() { // from class: com.byazt.prf.q.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int compare(qg qgVar, qg qgVar2) {
            if ((qgVar.q == null) != (qgVar2.q == null)) {
                return qgVar.q == null ? 1 : -1;
            }
            if (qgVar.n != qgVar2.n) {
                return qgVar.n ? -1 : 1;
            }
            int i = qgVar2.qg - qgVar.qg;
            if (i != 0) {
                return i;
            }
            int i2 = qgVar.s - qgVar2.s;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };
    public ArrayList<RecyclerView> qg = new ArrayList<>();
    public ArrayList<qg> w = new ArrayList<>();

    public void n(RecyclerView recyclerView) {
        this.qg.add(recyclerView);
    }

    public void qg(RecyclerView recyclerView) {
        this.qg.remove(recyclerView);
    }

    public void n(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.s == 0) {
            this.s = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.ur.n(i, i2);
    }

    private void n() {
        qg qgVar;
        int size = this.qg.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.qg.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.ur.n(recyclerView, false);
                i += recyclerView.ur.q;
            }
        }
        this.w.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.qg.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                n nVar = recyclerView2.ur;
                int iAbs = Math.abs(nVar.n) + Math.abs(nVar.qg);
                for (int i5 = 0; i5 < nVar.q * 2; i5 += 2) {
                    if (i3 >= this.w.size()) {
                        qgVar = new qg();
                        this.w.add(qgVar);
                    } else {
                        qgVar = this.w.get(i3);
                    }
                    int i6 = nVar.s[i5 + 1];
                    qgVar.n = i6 <= iAbs;
                    qgVar.qg = iAbs;
                    qgVar.s = i6;
                    qgVar.q = recyclerView2;
                    qgVar.l = nVar.s[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.w, l);
    }

    public static boolean n(RecyclerView recyclerView, int i) {
        int iS = recyclerView.x.s();
        for (int i2 = 0; i2 < iS; i2++) {
            RecyclerView.m mVarL = RecyclerView.l(recyclerView.x.q(i2));
            if (mVarL.s == i && !mVarL.sz()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.m n(RecyclerView recyclerView, int i, long j) {
        if (n(recyclerView, i)) {
            return null;
        }
        RecyclerView.cy cyVar = recyclerView.l;
        try {
            recyclerView.oa();
            RecyclerView.m mVarN = cyVar.n(i, false, j);
            if (mVarN != null) {
                if (mVarN.cy() && !mVarN.sz()) {
                    cyVar.n(mVarN.n);
                } else {
                    cyVar.n(mVarN, false);
                }
            }
            return mVarN;
        } finally {
            recyclerView.qg(false);
        }
    }

    private void n(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.wm && recyclerView.x.s() != 0) {
                recyclerView.s();
            }
            n nVar = recyclerView.ur;
            nVar.n(recyclerView, true);
            if (nVar.q != 0) {
                try {
                    com.byazt.ybd.n.n("RV Nested Prefetch");
                    recyclerView.bb.n(recyclerView.oa);
                    for (int i = 0; i < nVar.q * 2; i += 2) {
                        n(recyclerView, nVar.s[i], j);
                    }
                    com.byazt.ybd.n.n();
                } catch (Throwable th) {
                    com.byazt.ybd.n.n();
                    throw th;
                }
            }
        }
    }

    private void n(qg qgVar, long j) {
        RecyclerView.m mVarN = n(qgVar.q, qgVar.l, qgVar.n ? LongCompanionObject.MAX_VALUE : j);
        if (mVarN == null || mVarN.qg == null || !mVarN.cy() || mVarN.sz()) {
            return;
        }
        n(mVarN.qg.get(), j);
    }

    private void qg(long j) {
        for (int i = 0; i < this.w.size(); i++) {
            qg qgVar = this.w.get(i);
            if (qgVar.q == null) {
                return;
            }
            n(qgVar, j);
            qgVar.n();
        }
    }

    public void n(long j) {
        n();
        qg(j);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.byazt.ybd.n.n("RV Prefetch");
            if (!this.qg.isEmpty()) {
                int size = this.qg.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.qg.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    n(TimeUnit.MILLISECONDS.toNanos(jMax) + this.q);
                }
            }
        } finally {
            this.s = 0L;
            com.byazt.ybd.n.n();
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    static class n implements RecyclerView.rv.n {
        public int n;
        public int q;
        public int qg;
        public int[] s;

        public void n(int i, int i2) {
            this.n = i;
            this.qg = i2;
        }

        public void n(RecyclerView recyclerView, boolean z) {
            this.q = 0;
            int[] iArr = this.s;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.rv rvVar = recyclerView.sz;
            if (recyclerView.oa == null || rvVar == null || !rvVar.k()) {
                return;
            }
            if (z) {
                if (!recyclerView.w.q()) {
                    rvVar.n(recyclerView.oa.n(), this);
                }
            } else if (!recyclerView.ou()) {
                rvVar.n(this.n, this.qg, recyclerView.bb, this);
            }
            if (this.q > rvVar.m) {
                rvVar.m = this.q;
                rvVar.hu = z;
                recyclerView.l.qg();
            }
        }

        @Override // com.byazt.prf.RecyclerView.rv.n
        public void qg(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.q * 2;
            int[] iArr = this.s;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.s = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[i3 * 2];
                this.s = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.s;
            iArr4[i3] = i;
            iArr4[i3 + 1] = i2;
            this.q++;
        }

        public boolean n(int i) {
            if (this.s != null) {
                int i2 = this.q * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.s[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void n() {
            int[] iArr = this.s;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.q = 0;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 524})
    static class qg {
        public int l;
        public boolean n;
        public RecyclerView q;
        public int qg;
        public int s;

        public void n() {
            this.n = false;
            this.qg = 0;
            this.s = 0;
            this.q = null;
            this.l = 0;
        }
    }
}

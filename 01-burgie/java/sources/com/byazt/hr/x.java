package com.byazt.hr;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 180, 121})
public final class x implements Runnable {
    public long hn;
    public ArrayList<RecyclerView> hw = new ArrayList<>();
    public ArrayList<hw> uc = new ArrayList<>();
    public long x;
    public static final ThreadLocal<x> pr = new ThreadLocal<>();
    public static Comparator<hw> c = new Comparator<hw>() { // from class: com.byazt.hr.x.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public int compare(hw hwVar, hw hwVar2) {
            if ((hwVar.x == null) != (hwVar2.x == null)) {
                return hwVar.x == null ? 1 : -1;
            }
            if (hwVar.pr != hwVar2.pr) {
                return hwVar.pr ? -1 : 1;
            }
            int i = hwVar2.hw - hwVar.hw;
            if (i != 0) {
                return i;
            }
            int i2 = hwVar.hn - hwVar2.hn;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };

    public void pr(RecyclerView recyclerView) {
        this.hw.add(recyclerView);
    }

    public void hw(RecyclerView recyclerView) {
        this.hw.remove(recyclerView);
    }

    public void pr(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.hn == 0) {
            this.hn = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.ve.pr(i, i2);
    }

    private void pr() {
        hw hwVar;
        int size = this.hw.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.hw.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.ve.pr(recyclerView, false);
                i += recyclerView.ve.x;
            }
        }
        this.uc.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.hw.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                pr prVar = recyclerView2.ve;
                int iAbs = Math.abs(prVar.pr) + Math.abs(prVar.hw);
                for (int i5 = 0; i5 < prVar.x * 2; i5 += 2) {
                    if (i3 >= this.uc.size()) {
                        hwVar = new hw();
                        this.uc.add(hwVar);
                    } else {
                        hwVar = this.uc.get(i3);
                    }
                    int i6 = prVar.hn[i5 + 1];
                    hwVar.pr = i6 <= iAbs;
                    hwVar.hw = iAbs;
                    hwVar.hn = i6;
                    hwVar.x = recyclerView2;
                    hwVar.c = prVar.hn[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.uc, c);
    }

    public static boolean pr(RecyclerView recyclerView, int i) {
        int iHn = recyclerView.fw.hn();
        for (int i2 = 0; i2 < iHn; i2++) {
            RecyclerView.fo foVarC = RecyclerView.c(recyclerView.fw.x(i2));
            if (foVarC.hn == i && !foVarC.g()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.fo pr(RecyclerView recyclerView, int i, long j) {
        if (pr(recyclerView, i)) {
            return null;
        }
        RecyclerView.nt ntVar = recyclerView.c;
        try {
            recyclerView.k();
            RecyclerView.fo foVarPr = ntVar.pr(i, false, j);
            if (foVarPr != null) {
                if (foVarPr.nt() && !foVarPr.g()) {
                    ntVar.pr(foVarPr.pr);
                } else {
                    ntVar.pr(foVarPr, false);
                }
            }
            return foVarPr;
        } finally {
            recyclerView.hw(false);
        }
    }

    private void pr(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.fo && recyclerView.fw.hn() != 0) {
                recyclerView.hn();
            }
            pr prVar = recyclerView.ve;
            prVar.pr(recyclerView, true);
            if (prVar.x != 0) {
                try {
                    com.byazt.de.pr.pr("RV Nested Prefetch");
                    recyclerView.gz.pr(recyclerView.m);
                    for (int i = 0; i < prVar.x * 2; i += 2) {
                        pr(recyclerView, prVar.hn[i], j);
                    }
                    com.byazt.de.pr.pr();
                } catch (Throwable th) {
                    com.byazt.de.pr.pr();
                    throw th;
                }
            }
        }
    }

    private void pr(hw hwVar, long j) {
        RecyclerView.fo foVarPr = pr(hwVar.x, hwVar.c, hwVar.pr ? LongCompanionObject.MAX_VALUE : j);
        if (foVarPr != null && foVarPr.hw != null && foVarPr.nt() && !foVarPr.g()) {
            pr(foVarPr.hw.get(), j);
        }
    }

    private void hw(long j) {
        for (int i = 0; i < this.uc.size(); i++) {
            hw hwVar = this.uc.get(i);
            if (hwVar.x != null) {
                pr(hwVar, j);
                hwVar.pr();
            } else {
                return;
            }
        }
    }

    public void pr(long j) {
        pr();
        hw(j);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.byazt.de.pr.pr("RV Prefetch");
            if (this.hw.isEmpty()) {
                return;
            }
            int size = this.hw.size();
            long jMax = 0;
            for (int i = 0; i < size; i++) {
                RecyclerView recyclerView = this.hw.get(i);
                if (recyclerView.getWindowVisibility() == 0) {
                    jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                }
            }
            if (jMax == 0) {
                return;
            }
            pr(TimeUnit.MILLISECONDS.toNanos(jMax) + this.x);
        } finally {
            this.hn = 0L;
            com.byazt.de.pr.pr();
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    static class pr implements RecyclerView.aj.pr {
        public int[] hn;
        public int hw;
        public int pr;
        public int x;

        public void pr(int i, int i2) {
            this.pr = i;
            this.hw = i2;
        }

        public void pr(RecyclerView recyclerView, boolean z) {
            this.x = 0;
            int[] iArr = this.hn;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.aj ajVar = recyclerView.g;
            if (recyclerView.m != null && ajVar != null && ajVar.g()) {
                if (z) {
                    if (!recyclerView.uc.x()) {
                        ajVar.pr(recyclerView.m.pr(), this);
                    }
                } else if (!recyclerView.cz()) {
                    ajVar.pr(this.pr, this.hw, recyclerView.gz, this);
                }
                if (this.x > ajVar.nt) {
                    ajVar.nt = this.x;
                    ajVar.yb = z;
                    recyclerView.c.hw();
                }
            }
        }

        @Override // com.byazt.hr.RecyclerView.aj.pr
        public void hw(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.x * 2;
            int[] iArr = this.hn;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.hn = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[i3 * 2];
                this.hn = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.hn;
            iArr4[i3] = i;
            iArr4[i3 + 1] = i2;
            this.x++;
        }

        public boolean pr(int i) {
            if (this.hn != null) {
                int i2 = this.x * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.hn[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void pr() {
            int[] iArr = this.hn;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.x = 0;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 759})
    static class hw {
        public int c;
        public int hn;
        public int hw;
        public boolean pr;
        public RecyclerView x;

        public void pr() {
            this.pr = false;
            this.hw = 0;
            this.hn = 0;
            this.x = null;
            this.c = 0;
        }
    }
}

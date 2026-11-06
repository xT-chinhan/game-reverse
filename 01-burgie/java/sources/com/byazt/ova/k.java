package com.byazt.ova;

import android.graphics.Path;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 423, 250})
public class k implements m, vk {
    public final com.byazt.ynb.aj uc;
    public final String x;
    public final Path pr = new Path();
    public final Path hw = new Path();
    public final Path hn = new Path();
    public final List<m> c = new ArrayList();

    public k(com.byazt.ynb.aj ajVar) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.x = ajVar.pr();
        this.uc = ajVar;
    }

    @Override // com.byazt.ova.vk
    public void pr(ListIterator<hn> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            hn hnVarPrevious = listIterator.previous();
            if (hnVarPrevious instanceof m) {
                this.c.add((m) hnVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.byazt.ova.hn
    public void pr(List<hn> list, List<hn> list2) {
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).pr(list, list2);
        }
    }

    @Override // com.byazt.ova.m
    public Path x() {
        this.hn.reset();
        if (this.uc.hn()) {
            return this.hn;
        }
        switch (AnonymousClass1.pr[this.uc.hw().ordinal()]) {
            case 1:
                pr();
                break;
            case 2:
                pr(Path.Op.UNION);
                break;
            case 3:
                pr(Path.Op.REVERSE_DIFFERENCE);
                break;
            case 4:
                pr(Path.Op.INTERSECT);
                break;
            case 5:
                pr(Path.Op.XOR);
                break;
        }
        return this.hn;
    }

    /* JADX INFO: renamed from: com.byazt.ova.k$1, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, 423, 30})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[com.byazt.ynb.aj.pr.values().length];
            pr = iArr;
            try {
                iArr[com.byazt.ynb.aj.pr.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[com.byazt.ynb.aj.pr.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[com.byazt.ynb.aj.pr.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                pr[com.byazt.ynb.aj.pr.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                pr[com.byazt.ynb.aj.pr.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private void pr() {
        for (int i = 0; i < this.c.size(); i++) {
            this.hn.addPath(this.c.get(i).x());
        }
    }

    private void pr(Path.Op op) {
        this.hw.reset();
        this.pr.reset();
        for (int size = this.c.size() - 1; size > 0; size--) {
            m mVar = this.c.get(size);
            if (mVar instanceof x) {
                x xVar = (x) mVar;
                List<m> listHw = xVar.hw();
                for (int size2 = listHw.size() - 1; size2 >= 0; size2--) {
                    Path pathX = listHw.get(size2).x();
                    pathX.transform(xVar.hn());
                    this.hw.addPath(pathX);
                }
            } else {
                this.hw.addPath(mVar.x());
            }
        }
        m mVar2 = this.c.get(0);
        if (mVar2 instanceof x) {
            x xVar2 = (x) mVar2;
            List<m> listHw2 = xVar2.hw();
            for (int i = 0; i < listHw2.size(); i++) {
                Path pathX2 = listHw2.get(i).x();
                pathX2.transform(xVar2.hn());
                this.pr.addPath(pathX2);
            }
        } else {
            this.pr.set(mVar2.x());
        }
        this.hn.op(this.pr, this.hw, op);
    }
}

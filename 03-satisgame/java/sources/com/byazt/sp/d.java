package com.byazt.sp;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1179, 113})
public class d implements oa, tj {
    public final String q;
    public final com.byazt.aw.rv w;
    public final Path n = new Path();
    public final Path qg = new Path();
    public final Path s = new Path();
    public final List<oa> l = new ArrayList();

    public d(com.byazt.aw.rv rvVar) {
        this.q = rvVar.n();
        this.w = rvVar;
    }

    @Override // com.byazt.sp.tj
    public void n(ListIterator<s> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            s sVarPrevious = listIterator.previous();
            if (sVarPrevious instanceof oa) {
                this.l.add((oa) sVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.byazt.sp.s
    public void n(List<s> list, List<s> list2) {
        for (int i = 0; i < this.l.size(); i++) {
            this.l.get(i).n(list, list2);
        }
    }

    @Override // com.byazt.sp.oa
    public Path q() {
        this.s.reset();
        if (this.w.s()) {
            return this.s;
        }
        int i = AnonymousClass1.n[this.w.qg().ordinal()];
        if (i == 1) {
            n();
        } else if (i == 2) {
            n(Path.Op.UNION);
        } else if (i == 3) {
            n(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            n(Path.Op.INTERSECT);
        } else if (i == 5) {
            n(Path.Op.XOR);
        }
        return this.s;
    }

    /* JADX INFO: renamed from: com.byazt.sp.d$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 1179, 218})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[com.byazt.aw.rv.n.values().length];
            n = iArr;
            try {
                iArr[com.byazt.aw.rv.n.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[com.byazt.aw.rv.n.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                n[com.byazt.aw.rv.n.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                n[com.byazt.aw.rv.n.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                n[com.byazt.aw.rv.n.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void n() {
        for (int i = 0; i < this.l.size(); i++) {
            this.s.addPath(this.l.get(i).q());
        }
    }

    private void n(Path.Op op) {
        this.qg.reset();
        this.n.reset();
        for (int size = this.l.size() - 1; size > 0; size--) {
            oa oaVar = this.l.get(size);
            if (oaVar instanceof q) {
                q qVar = (q) oaVar;
                List<oa> listQg = qVar.qg();
                for (int size2 = listQg.size() - 1; size2 >= 0; size2--) {
                    Path pathQ = listQg.get(size2).q();
                    pathQ.transform(qVar.s());
                    this.qg.addPath(pathQ);
                }
            } else {
                this.qg.addPath(oaVar.q());
            }
        }
        oa oaVar2 = this.l.get(0);
        if (oaVar2 instanceof q) {
            q qVar2 = (q) oaVar2;
            List<oa> listQg2 = qVar2.qg();
            for (int i = 0; i < listQg2.size(); i++) {
                Path pathQ2 = listQg2.get(i).q();
                pathQ2.transform(qVar2.s());
                this.n.addPath(pathQ2);
            }
        } else {
            this.n.set(oaVar2.q());
        }
        this.s.op(this.n, this.qg, op);
    }
}

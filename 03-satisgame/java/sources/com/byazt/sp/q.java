package com.byazt.sp;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1179, 5})
public class q implements l, oa, com.byazt.bd.n.InterfaceC0134n {
    public com.byazt.bd.cy cp;
    public final List<s> fs;
    public final RectF l;
    public final Paint n;
    public final Path q;
    public final RectF qg;
    public final com.byazt.pp.fs rv;
    public final Matrix s;
    public List<oa> tj;
    public final String w;
    public final boolean x;

    private static List<s> n(com.byazt.pp.fs fsVar, com.byazt.pp.w wVar, com.byazt.eg.s sVar, List<com.byazt.aw.s> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            s sVarN = list.get(i).n(fsVar, wVar, sVar);
            if (sVarN != null) {
                arrayList.add(sVarN);
            }
        }
        return arrayList;
    }

    public static com.byazt.ccr.d n(List<com.byazt.aw.s> list) {
        for (int i = 0; i < list.size(); i++) {
            com.byazt.aw.s sVar = list.get(i);
            if (sVar instanceof com.byazt.ccr.d) {
                return (com.byazt.ccr.d) sVar;
            }
        }
        return null;
    }

    public q(com.byazt.pp.fs fsVar, com.byazt.eg.s sVar, com.byazt.aw.cy cyVar, com.byazt.pp.w wVar) {
        this(fsVar, sVar, cyVar.n(), cyVar.s(), n(fsVar, wVar, sVar, cyVar.qg()), n(cyVar.qg()));
    }

    public q(com.byazt.pp.fs fsVar, com.byazt.eg.s sVar, String str, boolean z, List<s> list, com.byazt.ccr.d dVar) {
        this.n = new com.byazt.ft.n();
        this.qg = new RectF();
        this.s = new Matrix();
        this.q = new Path();
        this.l = new RectF();
        this.w = str;
        this.rv = fsVar;
        this.x = z;
        this.fs = list;
        if (dVar != null) {
            com.byazt.bd.cy cyVarTj = dVar.tj();
            this.cp = cyVarTj;
            cyVarTj.n(sVar);
            this.cp.n(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            s sVar2 = list.get(size);
            if (sVar2 instanceof tj) {
                arrayList.add((tj) sVar2);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((tj) arrayList.get(size2)).n(list.listIterator(list.size()));
        }
    }

    @Override // com.byazt.bd.n.InterfaceC0134n
    public void n() {
        this.rv.invalidateSelf();
    }

    @Override // com.byazt.sp.s
    public void n(List<s> list, List<s> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.fs.size());
        arrayList.addAll(list);
        for (int size = this.fs.size() - 1; size >= 0; size--) {
            s sVar = this.fs.get(size);
            sVar.n(arrayList, this.fs.subList(0, size));
            arrayList.add(sVar);
        }
    }

    public List<oa> qg() {
        if (this.tj == null) {
            this.tj = new ArrayList();
            for (int i = 0; i < this.fs.size(); i++) {
                s sVar = this.fs.get(i);
                if (sVar instanceof oa) {
                    this.tj.add((oa) sVar);
                }
            }
        }
        return this.tj;
    }

    public Matrix s() {
        com.byazt.bd.cy cyVar = this.cp;
        if (cyVar != null) {
            return cyVar.q();
        }
        this.s.reset();
        return this.s;
    }

    @Override // com.byazt.sp.oa
    public Path q() {
        this.s.reset();
        com.byazt.bd.cy cyVar = this.cp;
        if (cyVar != null) {
            this.s.set(cyVar.q());
        }
        this.q.reset();
        if (this.x) {
            return this.q;
        }
        for (int size = this.fs.size() - 1; size >= 0; size--) {
            s sVar = this.fs.get(size);
            if (sVar instanceof oa) {
                this.q.addPath(((oa) sVar).q(), this.s);
            }
        }
        return this.q;
    }

    @Override // com.byazt.sp.l
    public void n(Canvas canvas, Matrix matrix, int i) {
        if (this.x) {
            return;
        }
        this.s.set(matrix);
        com.byazt.bd.cy cyVar = this.cp;
        if (cyVar != null) {
            this.s.preConcat(cyVar.q());
            i = (int) (((((this.cp.n() == null ? 100 : this.cp.n().x().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.rv.tj() && l() && i != 255;
        if (z) {
            this.qg.set(0.0f, 0.0f, 0.0f, 0.0f);
            n(this.qg, this.s, true);
            this.n.setAlpha(i);
            com.byazt.nu.tj.n(canvas, this.qg, this.n);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.fs.size() - 1; size >= 0; size--) {
            s sVar = this.fs.get(size);
            if (sVar instanceof l) {
                ((l) sVar).n(canvas, this.s, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    private boolean l() {
        int i = 0;
        for (int i2 = 0; i2 < this.fs.size(); i2++) {
            if ((this.fs.get(i2) instanceof l) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.sp.l
    public void n(RectF rectF, Matrix matrix, boolean z) {
        this.s.set(matrix);
        com.byazt.bd.cy cyVar = this.cp;
        if (cyVar != null) {
            this.s.preConcat(cyVar.q());
        }
        this.l.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.fs.size() - 1; size >= 0; size--) {
            s sVar = this.fs.get(size);
            if (sVar instanceof l) {
                ((l) sVar).n(this.l, this.s, z);
                rectF.union(this.l);
            }
        }
    }
}

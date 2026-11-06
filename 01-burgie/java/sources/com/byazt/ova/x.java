package com.byazt.ova;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 423, 121})
public class x implements com.byazt.al.pr.InterfaceC0016pr, c, m {
    public final com.byazt.dx.zo aj;
    public final RectF c;
    public final boolean fw;
    public final Matrix hn;
    public final RectF hw;
    public final Paint pr;
    public final String uc;
    public List<m> vk;
    public com.byazt.al.nt w;
    public final Path x;
    public final List<hn> zo;

    private static List<hn> pr(com.byazt.dx.zo zoVar, com.byazt.dx.uc ucVar, com.byazt.cg.hn hnVar, List<com.byazt.ynb.hn> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            hn hnVarPr = list.get(i).pr(zoVar, ucVar, hnVar);
            if (hnVarPr != null) {
                arrayList.add(hnVarPr);
            }
        }
        return arrayList;
    }

    public static com.byazt.eqw.k pr(List<com.byazt.ynb.hn> list) {
        for (int i = 0; i < list.size(); i++) {
            com.byazt.ynb.hn hnVar = list.get(i);
            if (hnVar instanceof com.byazt.eqw.k) {
                return (com.byazt.eqw.k) hnVar;
            }
        }
        return null;
    }

    public x(com.byazt.dx.zo zoVar, com.byazt.cg.hn hnVar, com.byazt.ynb.nt ntVar, com.byazt.dx.uc ucVar) {
        this(zoVar, hnVar, ntVar.pr(), ntVar.hn(), pr(zoVar, ucVar, hnVar, ntVar.hw()), pr(ntVar.hw()));
    }

    public x(com.byazt.dx.zo zoVar, com.byazt.cg.hn hnVar, String str, boolean z, List<hn> list, com.byazt.eqw.k kVar) {
        this.pr = new com.byazt.qpa.pr();
        this.hw = new RectF();
        this.hn = new Matrix();
        this.x = new Path();
        this.c = new RectF();
        this.uc = str;
        this.aj = zoVar;
        this.fw = z;
        this.zo = list;
        if (kVar != null) {
            com.byazt.al.nt ntVarVk = kVar.vk();
            this.w = ntVarVk;
            ntVarVk.pr(hnVar);
            this.w.pr(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            hn hnVar2 = list.get(size);
            if (hnVar2 instanceof vk) {
                arrayList.add((vk) hnVar2);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((vk) arrayList.get(size2)).pr(list.listIterator(list.size()));
        }
    }

    @Override // com.byazt.al.pr.InterfaceC0016pr
    public void pr() {
        this.aj.invalidateSelf();
    }

    @Override // com.byazt.ova.hn
    public void pr(List<hn> list, List<hn> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.zo.size());
        arrayList.addAll(list);
        for (int size = this.zo.size() - 1; size >= 0; size--) {
            hn hnVar = this.zo.get(size);
            hnVar.pr(arrayList, this.zo.subList(0, size));
            arrayList.add(hnVar);
        }
    }

    public List<m> hw() {
        if (this.vk == null) {
            this.vk = new ArrayList();
            for (int i = 0; i < this.zo.size(); i++) {
                hn hnVar = this.zo.get(i);
                if (hnVar instanceof m) {
                    this.vk.add((m) hnVar);
                }
            }
        }
        return this.vk;
    }

    public Matrix hn() {
        com.byazt.al.nt ntVar = this.w;
        if (ntVar != null) {
            return ntVar.x();
        }
        this.hn.reset();
        return this.hn;
    }

    @Override // com.byazt.ova.m
    public Path x() {
        this.hn.reset();
        com.byazt.al.nt ntVar = this.w;
        if (ntVar != null) {
            this.hn.set(ntVar.x());
        }
        this.x.reset();
        if (this.fw) {
            return this.x;
        }
        for (int size = this.zo.size() - 1; size >= 0; size--) {
            hn hnVar = this.zo.get(size);
            if (hnVar instanceof m) {
                this.x.addPath(((m) hnVar).x(), this.hn);
            }
        }
        return this.x;
    }

    @Override // com.byazt.ova.c
    public void pr(Canvas canvas, Matrix matrix, int i) {
        if (this.fw) {
            return;
        }
        this.hn.set(matrix);
        com.byazt.al.nt ntVar = this.w;
        if (ntVar != null) {
            this.hn.preConcat(ntVar.x());
            i = (int) (((((this.w.pr() == null ? 100 : this.w.pr().fw().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.aj.vk() && c() && i != 255;
        if (z) {
            this.hw.set(0.0f, 0.0f, 0.0f, 0.0f);
            pr(this.hw, this.hn, true);
            this.pr.setAlpha(i);
            com.byazt.ptr.vk.pr(canvas, this.hw, this.pr);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.zo.size() - 1; size >= 0; size--) {
            hn hnVar = this.zo.get(size);
            if (hnVar instanceof c) {
                ((c) hnVar).pr(canvas, this.hn, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    private boolean c() {
        int i = 0;
        for (int i2 = 0; i2 < this.zo.size(); i2++) {
            if ((this.zo.get(i2) instanceof c) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.ova.c
    public void pr(RectF rectF, Matrix matrix, boolean z) {
        this.hn.set(matrix);
        com.byazt.al.nt ntVar = this.w;
        if (ntVar != null) {
            this.hn.preConcat(ntVar.x());
        }
        this.c.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.zo.size() - 1; size >= 0; size--) {
            hn hnVar = this.zo.get(size);
            if (hnVar instanceof c) {
                ((c) hnVar).pr(this.c, this.hn, z);
                rectF.union(this.c);
            }
        }
    }
}

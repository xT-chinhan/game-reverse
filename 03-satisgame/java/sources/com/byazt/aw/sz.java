package com.byazt.aw;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1026, 110})
public class sz {
    public final List<com.byazt.ld.n> n;
    public PointF qg;
    public boolean s;

    public sz(PointF pointF, boolean z, List<com.byazt.ld.n> list) {
        this.qg = pointF;
        this.s = z;
        this.n = new ArrayList(list);
    }

    public sz() {
        this.n = new ArrayList();
    }

    public void n(float f, float f2) {
        if (this.qg == null) {
            this.qg = new PointF();
        }
        this.qg.set(f, f2);
    }

    public PointF n() {
        return this.qg;
    }

    public void n(boolean z) {
        this.s = z;
    }

    public boolean qg() {
        return this.s;
    }

    public List<com.byazt.ld.n> s() {
        return this.n;
    }

    public void n(sz szVar, sz szVar2, float f) {
        if (this.qg == null) {
            this.qg = new PointF();
        }
        this.s = szVar.qg() || szVar2.qg();
        if (szVar.s().size() != szVar2.s().size()) {
            com.byazt.nu.w.qg("Curves must have the same number of control points. Shape 1: " + szVar.s().size() + "\tShape 2: " + szVar2.s().size());
        }
        int iMin = Math.min(szVar.s().size(), szVar2.s().size());
        if (this.n.size() < iMin) {
            for (int size = this.n.size(); size < iMin; size++) {
                this.n.add(new com.byazt.ld.n());
            }
        } else if (this.n.size() > iMin) {
            for (int size2 = this.n.size() - 1; size2 >= iMin; size2--) {
                List<com.byazt.ld.n> list = this.n;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFN = szVar.n();
        PointF pointFN2 = szVar2.n();
        n(com.byazt.nu.rv.n(pointFN.x, pointFN2.x, f), com.byazt.nu.rv.n(pointFN.y, pointFN2.y, f));
        for (int size3 = this.n.size() - 1; size3 >= 0; size3--) {
            com.byazt.ld.n nVar = szVar.s().get(size3);
            com.byazt.ld.n nVar2 = szVar2.s().get(size3);
            PointF pointFN3 = nVar.n();
            PointF pointFQg = nVar.qg();
            PointF pointFS = nVar.s();
            PointF pointFN4 = nVar2.n();
            PointF pointFQg2 = nVar2.qg();
            PointF pointFS2 = nVar2.s();
            this.n.get(size3).n(com.byazt.nu.rv.n(pointFN3.x, pointFN4.x, f), com.byazt.nu.rv.n(pointFN3.y, pointFN4.y, f));
            this.n.get(size3).qg(com.byazt.nu.rv.n(pointFQg.x, pointFQg2.x, f), com.byazt.nu.rv.n(pointFQg.y, pointFQg2.y, f));
            this.n.get(size3).s(com.byazt.nu.rv.n(pointFS.x, pointFS2.x, f), com.byazt.nu.rv.n(pointFS.y, pointFS2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.n.size() + "closed=" + this.s + AbstractJsonLexerKt.END_OBJ;
    }
}

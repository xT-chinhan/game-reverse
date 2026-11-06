package com.byazt.sp;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1179, 210})
public class k implements cp, oa, com.byazt.bd.n.InterfaceC0134n {
    public boolean cp;
    public final com.byazt.bd.n<?, Float> fs;
    public final com.byazt.pp.fs l;
    public final boolean q;
    public final String s;
    public final com.byazt.bd.n<?, PointF> w;
    public final com.byazt.bd.n<?, PointF> x;
    public final Path n = new Path();
    public final RectF qg = new RectF();
    public final qg rv = new qg();
    public com.byazt.bd.n<Float, Float> tj = null;

    public k(com.byazt.pp.fs fsVar, com.byazt.eg.s sVar, com.byazt.aw.cp cpVar) {
        this.s = cpVar.n();
        this.q = cpVar.l();
        this.l = fsVar;
        com.byazt.bd.n<PointF, PointF> nVarN = cpVar.q().n();
        this.w = nVarN;
        com.byazt.bd.n<PointF, PointF> nVarN2 = cpVar.s().n();
        this.x = nVarN2;
        com.byazt.bd.n<Float, Float> nVarN3 = cpVar.qg().n();
        this.fs = nVarN3;
        sVar.n(nVarN);
        sVar.n(nVarN2);
        sVar.n(nVarN3);
        nVarN.n(this);
        nVarN2.n(this);
        nVarN3.n(this);
    }

    @Override // com.byazt.bd.n.InterfaceC0134n
    public void n() {
        qg();
    }

    private void qg() {
        this.cp = false;
        this.l.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:12:0x0029  */
    /* JADX WARN: Code duplicated, block: B:18:0x0031 A[SYNTHETIC] */
    @Override // com.byazt.sp.s
    public void n(List<s> list, List<s> list2) {
        for (int i = 0; i < list.size(); i++) {
            s sVar = list.get(i);
            if (sVar instanceof py) {
                py pyVar = (py) sVar;
                if (pyVar.getType() == com.byazt.aw.um.n.SIMULTANEOUSLY) {
                    this.rv.n(pyVar);
                    pyVar.n(this);
                } else if (sVar instanceof hd) {
                    this.tj = ((hd) sVar).qg();
                }
            } else if (sVar instanceof hd) {
                this.tj = ((hd) sVar).qg();
            }
        }
    }

    @Override // com.byazt.sp.oa
    public Path q() {
        com.byazt.bd.n<Float, Float> nVar;
        if (this.cp) {
            return this.n;
        }
        this.n.reset();
        if (this.q) {
            this.cp = true;
            return this.n;
        }
        PointF pointFX = this.x.x();
        float f = pointFX.x / 2.0f;
        float f2 = pointFX.y / 2.0f;
        com.byazt.bd.n<?, Float> nVar2 = this.fs;
        float fRv = nVar2 == null ? 0.0f : ((com.byazt.bd.q) nVar2).rv();
        if (fRv == 0.0f && (nVar = this.tj) != null) {
            fRv = Math.min(nVar.x().floatValue(), Math.min(f, f2));
        }
        float fMin = Math.min(f, f2);
        if (fRv > fMin) {
            fRv = fMin;
        }
        PointF pointFX2 = this.w.x();
        this.n.moveTo(pointFX2.x + f, (pointFX2.y - f2) + fRv);
        this.n.lineTo(pointFX2.x + f, (pointFX2.y + f2) - fRv);
        if (fRv > 0.0f) {
            float f3 = fRv * 2.0f;
            this.qg.set((pointFX2.x + f) - f3, (pointFX2.y + f2) - f3, pointFX2.x + f, pointFX2.y + f2);
            this.n.arcTo(this.qg, 0.0f, 90.0f, false);
        }
        this.n.lineTo((pointFX2.x - f) + fRv, pointFX2.y + f2);
        if (fRv > 0.0f) {
            float f4 = fRv * 2.0f;
            this.qg.set(pointFX2.x - f, (pointFX2.y + f2) - f4, (pointFX2.x - f) + f4, pointFX2.y + f2);
            this.n.arcTo(this.qg, 90.0f, 90.0f, false);
        }
        this.n.lineTo(pointFX2.x - f, (pointFX2.y - f2) + fRv);
        if (fRv > 0.0f) {
            float f5 = fRv * 2.0f;
            this.qg.set(pointFX2.x - f, pointFX2.y - f2, (pointFX2.x - f) + f5, (pointFX2.y - f2) + f5);
            this.n.arcTo(this.qg, 180.0f, 90.0f, false);
        }
        this.n.lineTo((pointFX2.x + f) - fRv, pointFX2.y - f2);
        if (fRv > 0.0f) {
            float f6 = fRv * 2.0f;
            this.qg.set((pointFX2.x + f) - f6, pointFX2.y - f2, pointFX2.x + f, (pointFX2.y - f2) + f6);
            this.n.arcTo(this.qg, 270.0f, 90.0f, false);
        }
        this.n.close();
        this.rv.n(this.n);
        this.cp = true;
        return this.n;
    }
}

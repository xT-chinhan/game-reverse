package com.byazt.sp;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1179, 13})
public class w implements cp, oa, com.byazt.bd.n.InterfaceC0134n {
    public boolean fs;
    public final com.byazt.bd.n<?, PointF> l;
    public final com.byazt.bd.n<?, PointF> q;
    public final String qg;
    public final com.byazt.pp.fs s;
    public final com.byazt.aw.qg w;
    public final Path n = new Path();
    public final qg x = new qg();

    public w(com.byazt.pp.fs fsVar, com.byazt.eg.s sVar, com.byazt.aw.qg qgVar) {
        this.qg = qgVar.n();
        this.s = fsVar;
        com.byazt.bd.n<PointF, PointF> nVarN = qgVar.s().n();
        this.q = nVarN;
        com.byazt.bd.n<PointF, PointF> nVarN2 = qgVar.qg().n();
        this.l = nVarN2;
        this.w = qgVar;
        sVar.n(nVarN);
        sVar.n(nVarN2);
        nVarN.n(this);
        nVarN2.n(this);
    }

    @Override // com.byazt.bd.n.InterfaceC0134n
    public void n() {
        qg();
    }

    private void qg() {
        this.fs = false;
        this.s.invalidateSelf();
    }

    @Override // com.byazt.sp.s
    public void n(List<s> list, List<s> list2) {
        for (int i = 0; i < list.size(); i++) {
            s sVar = list.get(i);
            if (sVar instanceof py) {
                py pyVar = (py) sVar;
                if (pyVar.getType() == com.byazt.aw.um.n.SIMULTANEOUSLY) {
                    this.x.n(pyVar);
                    pyVar.n(this);
                }
            }
        }
    }

    @Override // com.byazt.sp.oa
    public Path q() {
        if (this.fs) {
            return this.n;
        }
        this.n.reset();
        if (this.w.l()) {
            this.fs = true;
            return this.n;
        }
        PointF pointFX = this.q.x();
        float f = pointFX.x / 2.0f;
        float f2 = pointFX.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.n.reset();
        if (this.w.q()) {
            float f5 = -f2;
            this.n.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.n.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.n.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.n.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.n.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.n.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.n.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.n.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.n.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.n.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFX2 = this.l.x();
        this.n.offset(pointFX2.x, pointFX2.y);
        this.n.close();
        this.x.n(this.n);
        this.fs = true;
        return this.n;
    }
}

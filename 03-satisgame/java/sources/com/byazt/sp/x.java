package com.byazt.sp;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1179, 21})
public class x implements cp, l, com.byazt.bd.n.InterfaceC0134n {
    public final com.byazt.pp.fs cp;
    public com.byazt.bd.n<Float, Float> d;
    public final com.byazt.bd.n<Integer, Integer> fs;
    public final String l;
    public float n;
    public com.byazt.bd.s oa;
    public final com.byazt.eg.s q;
    public final Path qg;
    public final com.byazt.bd.n<Integer, Integer> rv;
    public final Paint s;
    public com.byazt.bd.n<ColorFilter, ColorFilter> tj;
    public final boolean w;
    public final List<oa> x;

    public x(com.byazt.pp.fs fsVar, com.byazt.eg.s sVar, com.byazt.aw.k kVar) {
        Path path = new Path();
        this.qg = path;
        this.s = new com.byazt.ft.n(1);
        this.x = new ArrayList();
        this.q = sVar;
        this.l = kVar.n();
        this.w = kVar.l();
        this.cp = fsVar;
        if (sVar.d() != null) {
            com.byazt.bd.n<Float, Float> nVarN = sVar.d().n().n();
            this.d = nVarN;
            nVarN.n(this);
            sVar.n(this.d);
        }
        if (sVar.oa() != null) {
            this.oa = new com.byazt.bd.s(this, sVar, sVar.oa());
        }
        if (kVar.qg() == null || kVar.s() == null) {
            this.fs = null;
            this.rv = null;
            return;
        }
        path.setFillType(kVar.q());
        com.byazt.bd.n<Integer, Integer> nVarN2 = kVar.qg().n();
        this.fs = nVarN2;
        nVarN2.n(this);
        sVar.n(nVarN2);
        com.byazt.bd.n<Integer, Integer> nVarN3 = kVar.s().n();
        this.rv = nVarN3;
        nVarN3.n(this);
        sVar.n(nVarN3);
    }

    @Override // com.byazt.bd.n.InterfaceC0134n
    public void n() {
        this.cp.invalidateSelf();
    }

    @Override // com.byazt.sp.s
    public void n(List<s> list, List<s> list2) {
        for (int i = 0; i < list2.size(); i++) {
            s sVar = list2.get(i);
            if (sVar instanceof oa) {
                this.x.add((oa) sVar);
            }
        }
    }

    @Override // com.byazt.sp.l
    public void n(Canvas canvas, Matrix matrix, int i) {
        if (this.w) {
            return;
        }
        com.byazt.pp.l.n("FillContent#draw");
        this.s.setColor((com.byazt.nu.rv.n((int) ((((i / 255.0f) * this.rv.x().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((com.byazt.bd.qg) this.fs).rv() & ViewCompat.MEASURED_SIZE_MASK));
        com.byazt.bd.n<ColorFilter, ColorFilter> nVar = this.tj;
        if (nVar != null) {
            this.s.setColorFilter(nVar.x());
        }
        com.byazt.bd.n<Float, Float> nVar2 = this.d;
        if (nVar2 != null) {
            float fFloatValue = nVar2.x().floatValue();
            if (fFloatValue == 0.0f) {
                this.s.setMaskFilter(null);
            } else if (fFloatValue != this.n) {
                this.s.setMaskFilter(this.q.qg(fFloatValue));
            }
            this.n = fFloatValue;
        }
        com.byazt.bd.s sVar = this.oa;
        if (sVar != null) {
            sVar.n(this.s);
        }
        this.qg.reset();
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            this.qg.addPath(this.x.get(i2).q(), matrix);
        }
        canvas.drawPath(this.qg, this.s);
        com.byazt.pp.l.qg("FillContent#draw");
    }

    @Override // com.byazt.sp.l
    public void n(RectF rectF, Matrix matrix, boolean z) {
        this.qg.reset();
        for (int i = 0; i < this.x.size(); i++) {
            this.qg.addPath(this.x.get(i).q(), matrix);
        }
        this.qg.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}

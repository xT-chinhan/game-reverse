package com.byazt.ova;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 423, 62})
public class fw implements com.byazt.al.pr.InterfaceC0016pr, c, w {
    public final com.byazt.al.pr<Integer, Integer> aj;
    public final String c;
    public final List<m> fw;
    public final Paint hn;
    public final Path hw;
    public com.byazt.al.pr<Float, Float> k;
    public com.byazt.al.hn m;
    public float pr;
    public final boolean uc;
    public com.byazt.al.pr<ColorFilter, ColorFilter> vk;
    public final com.byazt.dx.zo w;
    public final com.byazt.cg.hn x;
    public final com.byazt.al.pr<Integer, Integer> zo;

    public fw(com.byazt.dx.zo zoVar, com.byazt.cg.hn hnVar, com.byazt.ynb.ho hoVar) {
        Path path = new Path();
        this.hw = path;
        this.hn = new com.byazt.qpa.pr(1);
        this.fw = new ArrayList();
        this.x = hnVar;
        this.c = hoVar.pr();
        this.uc = hoVar.c();
        this.w = zoVar;
        if (hnVar.k() != null) {
            com.byazt.al.pr<Float, Float> prVarPr = hnVar.k().pr().pr();
            this.k = prVarPr;
            prVarPr.pr(this);
            hnVar.pr(this.k);
        }
        if (hnVar.m() != null) {
            this.m = new com.byazt.al.hn(this, hnVar, hnVar.m());
        }
        if (hoVar.hw() == null || hoVar.hn() == null) {
            this.zo = null;
            this.aj = null;
            return;
        }
        path.setFillType(hoVar.x());
        com.byazt.al.pr<Integer, Integer> prVarPr2 = hoVar.hw().pr();
        this.zo = prVarPr2;
        prVarPr2.pr(this);
        hnVar.pr(prVarPr2);
        com.byazt.al.pr<Integer, Integer> prVarPr3 = hoVar.hn().pr();
        this.aj = prVarPr3;
        prVarPr3.pr(this);
        hnVar.pr(prVarPr3);
    }

    @Override // com.byazt.al.pr.InterfaceC0016pr
    public void pr() {
        this.w.invalidateSelf();
    }

    @Override // com.byazt.ova.hn
    public void pr(List<hn> list, List<hn> list2) {
        for (int i = 0; i < list2.size(); i++) {
            hn hnVar = list2.get(i);
            if (hnVar instanceof m) {
                this.fw.add((m) hnVar);
            }
        }
    }

    @Override // com.byazt.ova.c
    public void pr(Canvas canvas, Matrix matrix, int i) {
        if (this.uc) {
            return;
        }
        com.byazt.dx.c.pr("FillContent#draw");
        this.hn.setColor((com.byazt.ptr.aj.pr((int) ((((i / 255.0f) * this.aj.fw().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((com.byazt.al.hw) this.zo).aj() & ViewCompat.MEASURED_SIZE_MASK));
        com.byazt.al.pr<ColorFilter, ColorFilter> prVar = this.vk;
        if (prVar != null) {
            this.hn.setColorFilter(prVar.fw());
        }
        com.byazt.al.pr<Float, Float> prVar2 = this.k;
        if (prVar2 != null) {
            float fFloatValue = prVar2.fw().floatValue();
            if (fFloatValue == 0.0f) {
                this.hn.setMaskFilter(null);
            } else if (fFloatValue != this.pr) {
                this.hn.setMaskFilter(this.x.hw(fFloatValue));
            }
            this.pr = fFloatValue;
        }
        com.byazt.al.hn hnVar = this.m;
        if (hnVar != null) {
            hnVar.pr(this.hn);
        }
        this.hw.reset();
        for (int i2 = 0; i2 < this.fw.size(); i2++) {
            this.hw.addPath(this.fw.get(i2).x(), matrix);
        }
        canvas.drawPath(this.hw, this.hn);
        com.byazt.dx.c.hw("FillContent#draw");
    }

    @Override // com.byazt.ova.c
    public void pr(RectF rectF, Matrix matrix, boolean z) {
        this.hw.reset();
        for (int i = 0; i < this.fw.size(); i++) {
            this.hw.addPath(this.fw.get(i).x(), matrix);
        }
        this.hw.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}

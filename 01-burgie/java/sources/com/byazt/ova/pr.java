package com.byazt.ova;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.mar.sdk.MARCode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 423, 37})
public abstract class pr implements com.byazt.al.pr.InterfaceC0016pr, c, w {
    public final com.byazt.al.pr<?, Float> g;
    public float hn;
    public com.byazt.al.pr<ColorFilter, ColorFilter> ho;
    public final Paint hw;
    public final com.byazt.al.pr<?, Integer> k;
    public final List<com.byazt.al.pr<?, Float>> m;
    public com.byazt.al.pr<Float, Float> nt;
    public final com.byazt.cg.hn pr;
    public final float[] vk;
    public final com.byazt.al.pr<?, Float> w;
    public com.byazt.al.hn yb;
    public final com.byazt.dx.zo zo;
    public final PathMeasure x = new PathMeasure();
    public final Path c = new Path();
    public final Path uc = new Path();
    public final RectF fw = new RectF();
    public final List<C0159pr> aj = new ArrayList();

    public pr(com.byazt.dx.zo zoVar, com.byazt.cg.hn hnVar, Paint.Cap cap, Paint.Join join, float f, com.byazt.eqw.x xVar, com.byazt.eqw.hw hwVar, List<com.byazt.eqw.hw> list, com.byazt.eqw.hw hwVar2) {
        com.byazt.qpa.pr prVar = new com.byazt.qpa.pr(1);
        this.hw = prVar;
        this.hn = 0.0f;
        this.zo = zoVar;
        this.pr = hnVar;
        prVar.setStyle(Paint.Style.STROKE);
        prVar.setStrokeCap(cap);
        prVar.setStrokeJoin(join);
        prVar.setStrokeMiter(f);
        this.k = xVar.pr();
        this.w = hwVar.pr();
        if (hwVar2 == null) {
            this.g = null;
        } else {
            this.g = hwVar2.pr();
        }
        this.m = new ArrayList(list.size());
        this.vk = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.m.add(list.get(i).pr());
        }
        hnVar.pr(this.k);
        hnVar.pr(this.w);
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            hnVar.pr(this.m.get(i2));
        }
        com.byazt.al.pr<?, Float> prVar2 = this.g;
        if (prVar2 != null) {
            hnVar.pr(prVar2);
        }
        this.k.pr(this);
        this.w.pr(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.m.get(i3).pr(this);
        }
        com.byazt.al.pr<?, Float> prVar3 = this.g;
        if (prVar3 != null) {
            prVar3.pr(this);
        }
        if (hnVar.k() != null) {
            com.byazt.al.pr<Float, Float> prVarPr = hnVar.k().pr().pr();
            this.nt = prVarPr;
            prVarPr.pr(this);
            hnVar.pr(this.nt);
        }
        if (hnVar.m() != null) {
            this.yb = new com.byazt.al.hn(this, hnVar, hnVar.m());
        }
    }

    @Override // com.byazt.al.pr.InterfaceC0016pr
    public void pr() {
        this.zo.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0057  */
    /* JADX WARN: Code duplicated, block: B:23:0x005b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x005d  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b A[SYNTHETIC] */
    @Override // com.byazt.ova.hn
    public void pr(List<hn> list, List<hn> list2) {
        cz czVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            hn hnVar = list.get(size);
            if (hnVar instanceof cz) {
                cz czVar2 = (cz) hnVar;
                if (czVar2.getType() == com.byazt.ynb.qa.pr.INDIVIDUALLY) {
                    czVar = czVar2;
                }
            }
        }
        if (czVar != null) {
            czVar.pr(this);
        }
        C0159pr c0159pr = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            hn hnVar2 = list2.get(size2);
            if (hnVar2 instanceof cz) {
                cz czVar3 = (cz) hnVar2;
                if (czVar3.getType() == com.byazt.ynb.qa.pr.INDIVIDUALLY) {
                    if (c0159pr != null) {
                        this.aj.add(c0159pr);
                    }
                    c0159pr = new C0159pr(czVar3);
                    czVar3.pr(this);
                } else if (!(hnVar2 instanceof m)) {
                    if (c0159pr == null) {
                        c0159pr = new C0159pr(czVar);
                    }
                    c0159pr.pr.add((m) hnVar2);
                }
            } else if (!(hnVar2 instanceof m)) {
                if (c0159pr == null) {
                    c0159pr = new C0159pr(czVar);
                }
                c0159pr.pr.add((m) hnVar2);
            }
        }
        if (c0159pr != null) {
            this.aj.add(c0159pr);
        }
    }

    public void pr(Canvas canvas, Matrix matrix, int i) {
        com.byazt.dx.c.pr("StrokeContent#draw");
        if (com.byazt.ptr.vk.hw(matrix)) {
            com.byazt.dx.c.hw("StrokeContent#draw");
            return;
        }
        this.hw.setAlpha(com.byazt.ptr.aj.pr((int) ((((i / 255.0f) * ((com.byazt.al.uc) this.k).aj()) / 100.0f) * 255.0f), 0, 255));
        this.hw.setStrokeWidth(((com.byazt.al.x) this.w).aj() * com.byazt.ptr.vk.pr(matrix));
        if (this.hw.getStrokeWidth() <= 0.0f) {
            com.byazt.dx.c.hw("StrokeContent#draw");
            return;
        }
        pr(matrix);
        com.byazt.al.pr<ColorFilter, ColorFilter> prVar = this.ho;
        if (prVar != null) {
            this.hw.setColorFilter(prVar.fw());
        }
        com.byazt.al.pr<Float, Float> prVar2 = this.nt;
        if (prVar2 != null) {
            float fFloatValue = prVar2.fw().floatValue();
            if (fFloatValue == 0.0f) {
                this.hw.setMaskFilter(null);
            } else if (fFloatValue != this.hn) {
                this.hw.setMaskFilter(this.pr.hw(fFloatValue));
            }
            this.hn = fFloatValue;
        }
        com.byazt.al.hn hnVar = this.yb;
        if (hnVar != null) {
            hnVar.pr(this.hw);
        }
        for (int i2 = 0; i2 < this.aj.size(); i2++) {
            C0159pr c0159pr = this.aj.get(i2);
            if (c0159pr.hw != null) {
                pr(canvas, c0159pr, matrix);
            } else {
                com.byazt.dx.c.pr("StrokeContent#buildPath");
                this.c.reset();
                for (int size = c0159pr.pr.size() - 1; size >= 0; size--) {
                    this.c.addPath(((m) c0159pr.pr.get(size)).x(), matrix);
                }
                com.byazt.dx.c.hw("StrokeContent#buildPath");
                com.byazt.dx.c.pr("StrokeContent#drawPath");
                canvas.drawPath(this.c, this.hw);
                com.byazt.dx.c.hw("StrokeContent#drawPath");
            }
        }
        com.byazt.dx.c.hw("StrokeContent#draw");
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0111  */
    private void pr(Canvas canvas, C0159pr c0159pr, Matrix matrix) {
        float f;
        float f2;
        float fMin;
        com.byazt.dx.c.pr("StrokeContent#applyTrimPath");
        if (c0159pr.hw == null) {
            com.byazt.dx.c.hw("StrokeContent#applyTrimPath");
            return;
        }
        this.c.reset();
        for (int size = c0159pr.pr.size() - 1; size >= 0; size--) {
            this.c.addPath(((m) c0159pr.pr.get(size)).x(), matrix);
        }
        float fFloatValue = c0159pr.hw.hw().fw().floatValue() / 100.0f;
        float fFloatValue2 = c0159pr.hw.hn().fw().floatValue() / 100.0f;
        float fFloatValue3 = c0159pr.hw.x().fw().floatValue() / 360.0f;
        if (fFloatValue >= 0.01f || fFloatValue2 <= 0.99f) {
            this.x.setPath(this.c, false);
            float length = this.x.getLength();
            while (this.x.nextContour()) {
                length += this.x.getLength();
            }
            float f3 = fFloatValue3 * length;
            float f4 = (fFloatValue * length) + f3;
            float fMin2 = Math.min((fFloatValue2 * length) + f3, (f4 + length) - 1.0f);
            float f5 = 0.0f;
            for (int size2 = c0159pr.pr.size() - 1; size2 >= 0; size2--) {
                this.uc.set(((m) c0159pr.pr.get(size2)).x());
                this.uc.transform(matrix);
                this.x.setPath(this.uc, false);
                float length2 = this.x.getLength();
                if (fMin2 <= length) {
                    f = f5 + length2;
                    if (f < f4) {
                    }
                } else {
                    float f6 = fMin2 - length;
                    if (f6 < f5 + length2 && f5 < f6) {
                        if (f4 > length) {
                            f2 = (f4 - length) / length2;
                        } else {
                            f2 = 0.0f;
                        }
                        fMin = Math.min(f6 / length2, 1.0f);
                    } else {
                        f = f5 + length2;
                        if (f < f4 && f5 <= fMin2) {
                            if (f > fMin2 || f4 >= f5) {
                                if (f4 < f5) {
                                    f2 = 0.0f;
                                } else {
                                    f2 = (f4 - f5) / length2;
                                }
                                if (fMin2 > f) {
                                    fMin = 1.0f;
                                } else {
                                    fMin = (fMin2 - f5) / length2;
                                }
                            } else {
                                canvas.drawPath(this.uc, this.hw);
                            }
                        }
                    }
                    com.byazt.ptr.vk.pr(this.uc, f2, fMin, 0.0f);
                    canvas.drawPath(this.uc, this.hw);
                }
                f5 += length2;
            }
            com.byazt.dx.c.hw("StrokeContent#applyTrimPath");
            return;
        }
        canvas.drawPath(this.c, this.hw);
        com.byazt.dx.c.hw("StrokeContent#applyTrimPath");
    }

    @Override // com.byazt.ova.c
    public void pr(RectF rectF, Matrix matrix, boolean z) {
        com.byazt.dx.c.pr("StrokeContent#getBounds");
        this.c.reset();
        for (int i = 0; i < this.aj.size(); i++) {
            C0159pr c0159pr = this.aj.get(i);
            for (int i2 = 0; i2 < c0159pr.pr.size(); i2++) {
                this.c.addPath(((m) c0159pr.pr.get(i2)).x(), matrix);
            }
        }
        this.c.computeBounds(this.fw, false);
        float fAj = ((com.byazt.al.x) this.w).aj();
        RectF rectF2 = this.fw;
        float f = fAj / 2.0f;
        rectF2.set(rectF2.left - f, this.fw.top - f, this.fw.right + f, this.fw.bottom + f);
        rectF.set(this.fw);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.byazt.dx.c.hw("StrokeContent#getBounds");
    }

    private void pr(Matrix matrix) {
        com.byazt.dx.c.pr("StrokeContent#applyDashPattern");
        if (this.m.isEmpty()) {
            com.byazt.dx.c.hw("StrokeContent#applyDashPattern");
            return;
        }
        float fPr = com.byazt.ptr.vk.pr(matrix);
        for (int i = 0; i < this.m.size(); i++) {
            this.vk[i] = this.m.get(i).fw().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.vk;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.vk;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.vk;
            fArr3[i] = fArr3[i] * fPr;
        }
        com.byazt.al.pr<?, Float> prVar = this.g;
        this.hw.setPathEffect(new DashPathEffect(this.vk, prVar == null ? 0.0f : fPr * prVar.fw().floatValue()));
        com.byazt.dx.c.hw("StrokeContent#applyDashPattern");
    }

    /* JADX INFO: renamed from: com.byazt.ova.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 423, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static final class C0159pr {
        public final cz hw;
        public final List<m> pr;

        private C0159pr(cz czVar) {
            this.pr = new ArrayList();
            this.hw = czVar;
        }
    }
}

package com.bytedance.adsdk.lottie.ms.ms;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms implements hi, ka, com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms {
    float ah;
    private com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> ao;
    private final float[] ch;
    private com.bytedance.adsdk.lottie.ms.xr.ah h;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> hi;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final com.bytedance.adsdk.lottie.model.layer.ah f248ms;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<?, Integer> sl;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> u;
    private com.bytedance.adsdk.lottie.ms.xr.ms<ColorFilter, ColorFilter> ub;
    private final com.bytedance.adsdk.lottie.x x;
    final Paint xr;
    private final List<com.bytedance.adsdk.lottie.ms.xr.ms<?, Float>> zb;
    private final PathMeasure d = new PathMeasure();
    private final Path ka = new Path();
    private final Path c = new Path();
    private final RectF ab = new RectF();
    private final List<C0188ms> ny = new ArrayList();

    ms(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar, Paint.Cap cap, Paint.Join join, float f, com.bytedance.adsdk.lottie.model.ms.d dVar, com.bytedance.adsdk.lottie.model.ms.xr xrVar, List<com.bytedance.adsdk.lottie.model.ms.xr> list, com.bytedance.adsdk.lottie.model.ms.xr xrVar2) {
        com.bytedance.adsdk.lottie.ms.ms msVar = new com.bytedance.adsdk.lottie.ms.ms(1);
        this.xr = msVar;
        this.ah = 0.0f;
        this.x = xVar;
        this.f248ms = ahVar;
        msVar.setStyle(Paint.Style.STROKE);
        msVar.setStrokeCap(cap);
        msVar.setStrokeJoin(join);
        msVar.setStrokeMiter(f);
        this.sl = dVar.ms();
        this.hi = xrVar.ms();
        if (xrVar2 == null) {
            this.u = null;
        } else {
            this.u = xrVar2.ms();
        }
        this.zb = new ArrayList(list.size());
        this.ch = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.zb.add(list.get(i).ms());
        }
        ahVar.ms(this.sl);
        ahVar.ms(this.hi);
        for (int i2 = 0; i2 < this.zb.size(); i2++) {
            ahVar.ms(this.zb.get(i2));
        }
        com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> msVar2 = this.u;
        if (msVar2 != null) {
            ahVar.ms(msVar2);
        }
        this.sl.ms(this);
        this.hi.ms(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.zb.get(i3).ms(this);
        }
        com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> msVar3 = this.u;
        if (msVar3 != null) {
            msVar3.ms(this);
        }
        if (ahVar.sl() != null) {
            com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVarMs = ahVar.sl().ms().ms();
            this.ao = msVarMs;
            msVarMs.ms(this);
            ahVar.ms(this.ao);
        }
        if (ahVar.zb() != null) {
            this.h = new com.bytedance.adsdk.lottie.ms.xr.ah(this, ahVar, ahVar.zb());
        }
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms
    public void ms() {
        this.x.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0055  */
    /* JADX WARN: Code duplicated, block: B:23:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069 A[SYNTHETIC] */
    @Override // com.bytedance.adsdk.lottie.ms.ms.ah
    public void ms(List<ah> list, List<ah> list2) {
        nw nwVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            ah ahVar = list.get(size);
            if (ahVar instanceof nw) {
                nw nwVar2 = (nw) ahVar;
                if (nwVar2.getType() == com.bytedance.adsdk.lottie.model.xr.y.ms.INDIVIDUALLY) {
                    nwVar = nwVar2;
                }
            }
        }
        if (nwVar != null) {
            nwVar.ms(this);
        }
        C0188ms c0188ms = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            ah ahVar2 = list2.get(size2);
            if (ahVar2 instanceof nw) {
                nw nwVar3 = (nw) ahVar2;
                if (nwVar3.getType() == com.bytedance.adsdk.lottie.model.xr.y.ms.INDIVIDUALLY) {
                    if (c0188ms != null) {
                        this.ny.add(c0188ms);
                    }
                    c0188ms = new C0188ms(nwVar3);
                    nwVar3.ms(this);
                } else if (!(ahVar2 instanceof zb)) {
                    if (c0188ms == null) {
                        c0188ms = new C0188ms(nwVar);
                    }
                    c0188ms.f249ms.add((zb) ahVar2);
                }
            } else if (!(ahVar2 instanceof zb)) {
                if (c0188ms == null) {
                    c0188ms = new C0188ms(nwVar);
                }
                c0188ms.f249ms.add((zb) ahVar2);
            }
        }
        if (c0188ms != null) {
            this.ny.add(c0188ms);
        }
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(Canvas canvas, Matrix matrix, int i) {
        com.bytedance.adsdk.lottie.ka.ms("StrokeContent#draw");
        if (com.bytedance.adsdk.lottie.ka.ny.xr(matrix)) {
            com.bytedance.adsdk.lottie.ka.xr("StrokeContent#draw");
            return;
        }
        this.xr.setAlpha(com.bytedance.adsdk.lottie.ka.x.ms((int) ((((i / 255.0f) * ((com.bytedance.adsdk.lottie.ms.xr.c) this.sl).ny()) / 100.0f) * 255.0f), 0, 255));
        this.xr.setStrokeWidth(((com.bytedance.adsdk.lottie.ms.xr.d) this.hi).ny() * com.bytedance.adsdk.lottie.ka.ny.ms(matrix));
        if (this.xr.getStrokeWidth() <= 0.0f) {
            com.bytedance.adsdk.lottie.ka.xr("StrokeContent#draw");
            return;
        }
        ms(matrix);
        com.bytedance.adsdk.lottie.ms.xr.ms<ColorFilter, ColorFilter> msVar = this.ub;
        if (msVar != null) {
            this.xr.setColorFilter(msVar.ab());
        }
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVar2 = this.ao;
        if (msVar2 != null) {
            float fFloatValue = msVar2.ab().floatValue();
            if (fFloatValue == 0.0f) {
                this.xr.setMaskFilter(null);
            } else if (fFloatValue != this.ah) {
                this.xr.setMaskFilter(this.f248ms.xr(fFloatValue));
            }
            this.ah = fFloatValue;
        }
        com.bytedance.adsdk.lottie.ms.xr.ah ahVar = this.h;
        if (ahVar != null) {
            ahVar.ms(this.xr);
        }
        for (int i2 = 0; i2 < this.ny.size(); i2++) {
            C0188ms c0188ms = this.ny.get(i2);
            if (c0188ms.xr != null) {
                ms(canvas, c0188ms, matrix);
            } else {
                com.bytedance.adsdk.lottie.ka.ms("StrokeContent#buildPath");
                this.ka.reset();
                for (int size = c0188ms.f249ms.size() - 1; size >= 0; size--) {
                    this.ka.addPath(((zb) c0188ms.f249ms.get(size)).d(), matrix);
                }
                com.bytedance.adsdk.lottie.ka.xr("StrokeContent#buildPath");
                com.bytedance.adsdk.lottie.ka.ms("StrokeContent#drawPath");
                canvas.drawPath(this.ka, this.xr);
                com.bytedance.adsdk.lottie.ka.xr("StrokeContent#drawPath");
            }
        }
        com.bytedance.adsdk.lottie.ka.xr("StrokeContent#draw");
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0110  */
    private void ms(Canvas canvas, C0188ms c0188ms, Matrix matrix) {
        float f;
        float f2;
        float fMin;
        com.bytedance.adsdk.lottie.ka.ms("StrokeContent#applyTrimPath");
        if (c0188ms.xr == null) {
            com.bytedance.adsdk.lottie.ka.xr("StrokeContent#applyTrimPath");
            return;
        }
        this.ka.reset();
        for (int size = c0188ms.f249ms.size() - 1; size >= 0; size--) {
            this.ka.addPath(((zb) c0188ms.f249ms.get(size)).d(), matrix);
        }
        float fFloatValue = c0188ms.xr.xr().ab().floatValue() / 100.0f;
        float fFloatValue2 = c0188ms.xr.ah().ab().floatValue() / 100.0f;
        float fFloatValue3 = c0188ms.xr.d().ab().floatValue() / 360.0f;
        if (fFloatValue < 0.01f && fFloatValue2 > 0.99f) {
            canvas.drawPath(this.ka, this.xr);
            com.bytedance.adsdk.lottie.ka.xr("StrokeContent#applyTrimPath");
            return;
        }
        this.d.setPath(this.ka, false);
        float length = this.d.getLength();
        while (this.d.nextContour()) {
            length += this.d.getLength();
        }
        float f3 = fFloatValue3 * length;
        float f4 = (fFloatValue * length) + f3;
        float fMin2 = Math.min((fFloatValue2 * length) + f3, (f4 + length) - 1.0f);
        float f5 = 0.0f;
        for (int size2 = c0188ms.f249ms.size() - 1; size2 >= 0; size2--) {
            this.c.set(((zb) c0188ms.f249ms.get(size2)).d());
            this.c.transform(matrix);
            this.d.setPath(this.c, false);
            float length2 = this.d.getLength();
            if (fMin2 > length) {
                float f6 = fMin2 - length;
                if (f6 >= f5 + length2 || f5 >= f6) {
                    f = f5 + length2;
                    if (f < f4 && f5 <= fMin2) {
                        if (f > fMin2 || f4 >= f5) {
                            f2 = f4 < f5 ? 0.0f : (f4 - f5) / length2;
                            fMin = fMin2 > f ? 1.0f : (fMin2 - f5) / length2;
                        } else {
                            canvas.drawPath(this.c, this.xr);
                        }
                    }
                } else {
                    f2 = f4 > length ? (f4 - length) / length2 : 0.0f;
                    fMin = Math.min(f6 / length2, 1.0f);
                }
                com.bytedance.adsdk.lottie.ka.ny.ms(this.c, f2, fMin, 0.0f);
                canvas.drawPath(this.c, this.xr);
            } else {
                f = f5 + length2;
                if (f < f4) {
                }
            }
            f5 += length2;
        }
        com.bytedance.adsdk.lottie.ka.xr("StrokeContent#applyTrimPath");
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(RectF rectF, Matrix matrix, boolean z) {
        com.bytedance.adsdk.lottie.ka.ms("StrokeContent#getBounds");
        this.ka.reset();
        for (int i = 0; i < this.ny.size(); i++) {
            C0188ms c0188ms = this.ny.get(i);
            for (int i2 = 0; i2 < c0188ms.f249ms.size(); i2++) {
                this.ka.addPath(((zb) c0188ms.f249ms.get(i2)).d(), matrix);
            }
        }
        this.ka.computeBounds(this.ab, false);
        float fNy = ((com.bytedance.adsdk.lottie.ms.xr.d) this.hi).ny();
        RectF rectF2 = this.ab;
        float f = fNy / 2.0f;
        rectF2.set(rectF2.left - f, this.ab.top - f, this.ab.right + f, this.ab.bottom + f);
        rectF.set(this.ab);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.bytedance.adsdk.lottie.ka.xr("StrokeContent#getBounds");
    }

    private void ms(Matrix matrix) {
        com.bytedance.adsdk.lottie.ka.ms("StrokeContent#applyDashPattern");
        if (this.zb.isEmpty()) {
            com.bytedance.adsdk.lottie.ka.xr("StrokeContent#applyDashPattern");
            return;
        }
        float fMs = com.bytedance.adsdk.lottie.ka.ny.ms(matrix);
        for (int i = 0; i < this.zb.size(); i++) {
            this.ch[i] = this.zb.get(i).ab().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.ch;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.ch;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.ch;
            fArr3[i] = fArr3[i] * fMs;
        }
        com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> msVar = this.u;
        this.xr.setPathEffect(new DashPathEffect(this.ch, msVar == null ? 0.0f : fMs * msVar.ab().floatValue()));
        com.bytedance.adsdk.lottie.ka.xr("StrokeContent#applyDashPattern");
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.ms.ms.ms$ms, reason: collision with other inner class name */
    private static final class C0188ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final List<zb> f249ms;
        private final nw xr;

        private C0188ms(nw nwVar) {
            this.f249ms = new ArrayList();
            this.xr = nwVar;
        }
    }
}

package com.bytedance.adsdk.lottie.ms.ms;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class x implements hi, ka, com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms {
    private final Path ab;
    private final boolean ah;
    private com.bytedance.adsdk.lottie.ms.xr.ms<ColorFilter, ColorFilter> ao;
    private final List<zb> ch;
    private final com.bytedance.adsdk.lottie.model.layer.ah d;
    private com.bytedance.adsdk.lottie.ms.xr.h h;
    private final com.bytedance.adsdk.lottie.model.xr.ab hi;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    float f257ms;
    private com.bytedance.adsdk.lottie.ms.xr.ah nw;
    private final RectF ny;
    private final com.bytedance.adsdk.lottie.x qv;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<com.bytedance.adsdk.lottie.model.xr.d, com.bytedance.adsdk.lottie.model.xr.d> sl;
    private com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> t;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<PointF, PointF> u;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<PointF, PointF> ub;
    private final Paint x;
    private final String xr;
    private final int y;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> zb;
    private final LongSparseArray<LinearGradient> ka = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> c = new LongSparseArray<>();

    public x(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.c cVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar, com.bytedance.adsdk.lottie.model.xr.ka kaVar) {
        Path path = new Path();
        this.ab = path;
        this.x = new com.bytedance.adsdk.lottie.ms.ms(1);
        this.ny = new RectF();
        this.ch = new ArrayList();
        this.f257ms = 0.0f;
        this.d = ahVar;
        this.xr = kaVar.ms();
        this.ah = kaVar.x();
        this.qv = xVar;
        this.hi = kaVar.xr();
        path.setFillType(kaVar.ah());
        this.y = (int) (cVar.ka() / 32.0f);
        com.bytedance.adsdk.lottie.ms.xr.ms<com.bytedance.adsdk.lottie.model.xr.d, com.bytedance.adsdk.lottie.model.xr.d> msVarMs = kaVar.d().ms();
        this.sl = msVarMs;
        msVarMs.ms(this);
        ahVar.ms(msVarMs);
        com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> msVarMs2 = kaVar.ka().ms();
        this.zb = msVarMs2;
        msVarMs2.ms(this);
        ahVar.ms(msVarMs2);
        com.bytedance.adsdk.lottie.ms.xr.ms<PointF, PointF> msVarMs3 = kaVar.c().ms();
        this.u = msVarMs3;
        msVarMs3.ms(this);
        ahVar.ms(msVarMs3);
        com.bytedance.adsdk.lottie.ms.xr.ms<PointF, PointF> msVarMs4 = kaVar.ab().ms();
        this.ub = msVarMs4;
        msVarMs4.ms(this);
        ahVar.ms(msVarMs4);
        if (ahVar.sl() != null) {
            com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVarMs5 = ahVar.sl().ms().ms();
            this.t = msVarMs5;
            msVarMs5.ms(this);
            ahVar.ms(this.t);
        }
        if (ahVar.zb() != null) {
            this.nw = new com.bytedance.adsdk.lottie.ms.xr.ah(this, ahVar, ahVar.zb());
        }
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms
    public void ms() {
        this.qv.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ah
    public void ms(List<ah> list, List<ah> list2) {
        for (int i = 0; i < list2.size(); i++) {
            ah ahVar = list2.get(i);
            if (ahVar instanceof zb) {
                this.ch.add((zb) ahVar);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(Canvas canvas, Matrix matrix, int i) {
        Shader shaderAh;
        if (this.ah) {
            return;
        }
        com.bytedance.adsdk.lottie.ka.ms("GradientFillContent#draw");
        this.ab.reset();
        for (int i2 = 0; i2 < this.ch.size(); i2++) {
            this.ab.addPath(this.ch.get(i2).d(), matrix);
        }
        this.ab.computeBounds(this.ny, false);
        if (this.hi == com.bytedance.adsdk.lottie.model.xr.ab.LINEAR) {
            shaderAh = xr();
        } else {
            shaderAh = ah();
        }
        shaderAh.setLocalMatrix(matrix);
        this.x.setShader(shaderAh);
        com.bytedance.adsdk.lottie.ms.xr.ms<ColorFilter, ColorFilter> msVar = this.ao;
        if (msVar != null) {
            this.x.setColorFilter(msVar.ab());
        }
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVar2 = this.t;
        if (msVar2 != null) {
            float fFloatValue = msVar2.ab().floatValue();
            if (fFloatValue == 0.0f) {
                this.x.setMaskFilter(null);
            } else if (fFloatValue != this.f257ms) {
                this.x.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.f257ms = fFloatValue;
        }
        com.bytedance.adsdk.lottie.ms.xr.ah ahVar = this.nw;
        if (ahVar != null) {
            ahVar.ms(this.x);
        }
        this.x.setAlpha(com.bytedance.adsdk.lottie.ka.x.ms((int) ((((i / 255.0f) * this.zb.ab().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.ab, this.x);
        com.bytedance.adsdk.lottie.ka.xr("GradientFillContent#draw");
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(RectF rectF, Matrix matrix, boolean z) {
        this.ab.reset();
        for (int i = 0; i < this.ch.size(); i++) {
            this.ab.addPath(this.ch.get(i).d(), matrix);
        }
        this.ab.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    private LinearGradient xr() {
        long jD = d();
        LinearGradient linearGradient = this.ka.get(jD);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFAb = this.u.ab();
        PointF pointFAb2 = this.ub.ab();
        com.bytedance.adsdk.lottie.model.xr.d dVarAb = this.sl.ab();
        LinearGradient linearGradient2 = new LinearGradient(pointFAb.x, pointFAb.y, pointFAb2.x, pointFAb2.y, ms(dVarAb.xr()), dVarAb.ms(), Shader.TileMode.CLAMP);
        this.ka.put(jD, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient ah() {
        long jD = d();
        RadialGradient radialGradient = this.c.get(jD);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFAb = this.u.ab();
        PointF pointFAb2 = this.ub.ab();
        com.bytedance.adsdk.lottie.model.xr.d dVarAb = this.sl.ab();
        int[] iArrMs = ms(dVarAb.xr());
        float[] fArrMs = dVarAb.ms();
        float f = pointFAb.x;
        float f2 = pointFAb.y;
        float fHypot = (float) Math.hypot(pointFAb2.x - f, pointFAb2.y - f2);
        if (fHypot <= 0.0f) {
            fHypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f, f2, fHypot, iArrMs, fArrMs, Shader.TileMode.CLAMP);
        this.c.put(jD, radialGradient2);
        return radialGradient2;
    }

    private int d() {
        int iRound = Math.round(this.u.x() * this.y);
        int iRound2 = Math.round(this.ub.x() * this.y);
        int iRound3 = Math.round(this.sl.x() * this.y);
        int i = iRound != 0 ? iRound * 527 : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private int[] ms(int[] iArr) {
        com.bytedance.adsdk.lottie.ms.xr.h hVar = this.h;
        if (hVar != null) {
            Integer[] numArr = (Integer[]) hVar.ab();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }
}

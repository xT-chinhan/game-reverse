package com.bytedance.adsdk.lottie.ms.ms;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;

/* JADX INFO: loaded from: classes2.dex */
public class ny extends ms {
    private final LongSparseArray<RadialGradient> ab;
    private final LongSparseArray<LinearGradient> c;
    private final int ch;
    private final String d;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<com.bytedance.adsdk.lottie.model.xr.d, com.bytedance.adsdk.lottie.model.xr.d> hi;
    private final boolean ka;
    private final com.bytedance.adsdk.lottie.model.xr.ab ny;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<PointF, PointF> sl;
    private com.bytedance.adsdk.lottie.ms.xr.h u;
    private final RectF x;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<PointF, PointF> zb;

    public ny(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar, com.bytedance.adsdk.lottie.model.xr.c cVar) {
        super(xVar, ahVar, cVar.x().ms(), cVar.ny().ms(), cVar.sl(), cVar.d(), cVar.ab(), cVar.ch(), cVar.hi());
        this.c = new LongSparseArray<>();
        this.ab = new LongSparseArray<>();
        this.x = new RectF();
        this.d = cVar.ms();
        this.ny = cVar.xr();
        this.ka = cVar.zb();
        this.ch = (int) (xVar.op().ka() / 32.0f);
        com.bytedance.adsdk.lottie.ms.xr.ms<com.bytedance.adsdk.lottie.model.xr.d, com.bytedance.adsdk.lottie.model.xr.d> msVarMs = cVar.ah().ms();
        this.hi = msVarMs;
        msVarMs.ms(this);
        ahVar.ms(msVarMs);
        com.bytedance.adsdk.lottie.ms.xr.ms<PointF, PointF> msVarMs2 = cVar.ka().ms();
        this.sl = msVarMs2;
        msVarMs2.ms(this);
        ahVar.ms(msVarMs2);
        com.bytedance.adsdk.lottie.ms.xr.ms<PointF, PointF> msVarMs3 = cVar.c().ms();
        this.zb = msVarMs3;
        msVarMs3.ms(this);
        ahVar.ms(msVarMs3);
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ms, com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(Canvas canvas, Matrix matrix, int i) {
        Shader shaderAh;
        if (this.ka) {
            return;
        }
        ms(this.x, matrix, false);
        if (this.ny == com.bytedance.adsdk.lottie.model.xr.ab.LINEAR) {
            shaderAh = xr();
        } else {
            shaderAh = ah();
        }
        shaderAh.setLocalMatrix(matrix);
        this.xr.setShader(shaderAh);
        super.ms(canvas, matrix, i);
    }

    private LinearGradient xr() {
        long jD = d();
        LinearGradient linearGradient = this.c.get(jD);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFAb = this.sl.ab();
        PointF pointFAb2 = this.zb.ab();
        com.bytedance.adsdk.lottie.model.xr.d dVarAb = this.hi.ab();
        LinearGradient linearGradient2 = new LinearGradient(pointFAb.x, pointFAb.y, pointFAb2.x, pointFAb2.y, ms(dVarAb.xr()), dVarAb.ms(), Shader.TileMode.CLAMP);
        this.c.put(jD, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient ah() {
        long jD = d();
        RadialGradient radialGradient = this.ab.get(jD);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFAb = this.sl.ab();
        PointF pointFAb2 = this.zb.ab();
        com.bytedance.adsdk.lottie.model.xr.d dVarAb = this.hi.ab();
        int[] iArrMs = ms(dVarAb.xr());
        float[] fArrMs = dVarAb.ms();
        float f = pointFAb.x;
        float f2 = pointFAb.y;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(pointFAb2.x - f, pointFAb2.y - f2), iArrMs, fArrMs, Shader.TileMode.CLAMP);
        this.ab.put(jD, radialGradient2);
        return radialGradient2;
    }

    private int d() {
        int iRound = Math.round(this.sl.x() * this.ch);
        int iRound2 = Math.round(this.zb.x() * this.ch);
        int iRound3 = Math.round(this.hi.x() * this.ch);
        int i = iRound != 0 ? iRound * 527 : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private int[] ms(int[] iArr) {
        com.bytedance.adsdk.lottie.ms.xr.h hVar = this.u;
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

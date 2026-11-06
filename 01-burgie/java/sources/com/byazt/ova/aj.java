package com.byazt.ova;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 423, 61})
public class aj extends pr {
    public final com.byazt.ynb.fw aj;
    public final boolean c;
    public final LongSparseArray<RadialGradient> fw;
    public com.byazt.al.yb g;
    public final com.byazt.al.pr<PointF, PointF> k;
    public final com.byazt.al.pr<PointF, PointF> m;
    public final LongSparseArray<LinearGradient> uc;
    public final int vk;
    public final com.byazt.al.pr<com.byazt.ynb.x, com.byazt.ynb.x> w;
    public final String x;
    public final RectF zo;

    public aj(com.byazt.dx.zo zoVar, com.byazt.cg.hn hnVar, com.byazt.ynb.uc ucVar) {
        super(zoVar, hnVar, ucVar.zo().pr(), ucVar.aj().pr(), ucVar.k(), ucVar.x(), ucVar.fw(), ucVar.vk(), ucVar.w());
        this.uc = new LongSparseArray<>();
        this.fw = new LongSparseArray<>();
        this.zo = new RectF();
        this.x = ucVar.pr();
        this.aj = ucVar.hw();
        this.c = ucVar.m();
        this.vk = (int) (zoVar.iu().c() / 32.0f);
        com.byazt.al.pr<com.byazt.ynb.x, com.byazt.ynb.x> prVarPr = ucVar.hn().pr();
        this.w = prVarPr;
        prVarPr.pr(this);
        hnVar.pr(prVarPr);
        com.byazt.al.pr<PointF, PointF> prVarPr2 = ucVar.c().pr();
        this.k = prVarPr2;
        prVarPr2.pr(this);
        hnVar.pr(prVarPr2);
        com.byazt.al.pr<PointF, PointF> prVarPr3 = ucVar.uc().pr();
        this.m = prVarPr3;
        prVarPr3.pr(this);
        hnVar.pr(prVarPr3);
    }

    @Override // com.byazt.ova.pr, com.byazt.ova.c
    public void pr(Canvas canvas, Matrix matrix, int i) {
        Shader shaderHn;
        if (this.c) {
            return;
        }
        pr(this.zo, matrix, false);
        if (this.aj == com.byazt.ynb.fw.LINEAR) {
            shaderHn = hw();
        } else {
            shaderHn = hn();
        }
        shaderHn.setLocalMatrix(matrix);
        this.hw.setShader(shaderHn);
        super.pr(canvas, matrix, i);
    }

    private LinearGradient hw() {
        long jX = x();
        LinearGradient linearGradient = this.uc.get(jX);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFFw = this.k.fw();
        PointF pointFFw2 = this.m.fw();
        com.byazt.ynb.x xVarFw = this.w.fw();
        LinearGradient linearGradient2 = new LinearGradient(pointFFw.x, pointFFw.y, pointFFw2.x, pointFFw2.y, pr(xVarFw.hw()), xVarFw.pr(), Shader.TileMode.CLAMP);
        this.uc.put(jX, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient hn() {
        long jX = x();
        RadialGradient radialGradient = this.fw.get(jX);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFFw = this.k.fw();
        PointF pointFFw2 = this.m.fw();
        com.byazt.ynb.x xVarFw = this.w.fw();
        int[] iArrPr = pr(xVarFw.hw());
        float[] fArrPr = xVarFw.pr();
        float f = pointFFw.x;
        float f2 = pointFFw.y;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(pointFFw2.x - f, pointFFw2.y - f2), iArrPr, fArrPr, Shader.TileMode.CLAMP);
        this.fw.put(jX, radialGradient2);
        return radialGradient2;
    }

    private int x() {
        int i;
        int iRound = Math.round(this.k.zo() * this.vk);
        int iRound2 = Math.round(this.m.zo() * this.vk);
        int iRound3 = Math.round(this.w.zo() * this.vk);
        if (iRound == 0) {
            i = 17;
        } else {
            i = iRound * 527;
        }
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        if (iRound3 != 0) {
            return i * 31 * iRound3;
        }
        return i;
    }

    private int[] pr(int[] iArr) {
        com.byazt.al.yb ybVar = this.g;
        if (ybVar != null) {
            Integer[] numArr = (Integer[]) ybVar.fw();
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

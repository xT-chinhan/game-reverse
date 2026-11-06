package com.byazt.sp;

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
@com.byazt.cp.n(n = {0, 1, 1179, 101})
public class fs implements cp, l, com.byazt.bd.n.InterfaceC0134n {
    public com.byazt.bd.n<Float, Float> a;
    public final com.byazt.pp.fs cd;
    public final com.byazt.aw.x cp;
    public com.byazt.bd.n<ColorFilter, ColorFilter> cy;
    public final com.byazt.bd.n<com.byazt.aw.q, com.byazt.aw.q> d;
    public final Paint fs;
    public com.byazt.bd.hd hd;
    public final com.byazt.bd.n<PointF, PointF> k;
    public float n;
    public final com.byazt.bd.n<Integer, Integer> oa;
    public com.byazt.bd.s py;
    public final com.byazt.eg.s q;
    public final String qg;
    public final RectF rv;
    public final boolean s;
    public final com.byazt.bd.n<PointF, PointF> sz;
    public final List<oa> tj;
    public final int um;
    public final Path x;
    public final LongSparseArray<LinearGradient> l = new LongSparseArray<>();
    public final LongSparseArray<RadialGradient> w = new LongSparseArray<>();

    public fs(com.byazt.pp.fs fsVar, com.byazt.pp.w wVar, com.byazt.eg.s sVar, com.byazt.aw.l lVar) {
        Path path = new Path();
        this.x = path;
        this.fs = new com.byazt.ft.n(1);
        this.rv = new RectF();
        this.tj = new ArrayList();
        this.n = 0.0f;
        this.q = sVar;
        this.qg = lVar.n();
        this.s = lVar.fs();
        this.cd = fsVar;
        this.cp = lVar.qg();
        path.setFillType(lVar.s());
        this.um = (int) (wVar.l() / 32.0f);
        com.byazt.bd.n<com.byazt.aw.q, com.byazt.aw.q> nVarN = lVar.q().n();
        this.d = nVarN;
        nVarN.n(this);
        sVar.n(nVarN);
        com.byazt.bd.n<Integer, Integer> nVarN2 = lVar.l().n();
        this.oa = nVarN2;
        nVarN2.n(this);
        sVar.n(nVarN2);
        com.byazt.bd.n<PointF, PointF> nVarN3 = lVar.w().n();
        this.sz = nVarN3;
        nVarN3.n(this);
        sVar.n(nVarN3);
        com.byazt.bd.n<PointF, PointF> nVarN4 = lVar.x().n();
        this.k = nVarN4;
        nVarN4.n(this);
        sVar.n(nVarN4);
        if (sVar.d() != null) {
            com.byazt.bd.n<Float, Float> nVarN5 = sVar.d().n().n();
            this.a = nVarN5;
            nVarN5.n(this);
            sVar.n(this.a);
        }
        if (sVar.oa() != null) {
            this.py = new com.byazt.bd.s(this, sVar, sVar.oa());
        }
    }

    @Override // com.byazt.bd.n.InterfaceC0134n
    public void n() {
        this.cd.invalidateSelf();
    }

    @Override // com.byazt.sp.s
    public void n(List<s> list, List<s> list2) {
        for (int i = 0; i < list2.size(); i++) {
            s sVar = list2.get(i);
            if (sVar instanceof oa) {
                this.tj.add((oa) sVar);
            }
        }
    }

    @Override // com.byazt.sp.l
    public void n(Canvas canvas, Matrix matrix, int i) {
        Shader shaderS;
        if (this.s) {
            return;
        }
        com.byazt.pp.l.n("GradientFillContent#draw");
        this.x.reset();
        for (int i2 = 0; i2 < this.tj.size(); i2++) {
            this.x.addPath(this.tj.get(i2).q(), matrix);
        }
        this.x.computeBounds(this.rv, false);
        if (this.cp == com.byazt.aw.x.LINEAR) {
            shaderS = qg();
        } else {
            shaderS = s();
        }
        shaderS.setLocalMatrix(matrix);
        this.fs.setShader(shaderS);
        com.byazt.bd.n<ColorFilter, ColorFilter> nVar = this.cy;
        if (nVar != null) {
            this.fs.setColorFilter(nVar.x());
        }
        com.byazt.bd.n<Float, Float> nVar2 = this.a;
        if (nVar2 != null) {
            float fFloatValue = nVar2.x().floatValue();
            if (fFloatValue == 0.0f) {
                this.fs.setMaskFilter(null);
            } else if (fFloatValue != this.n) {
                this.fs.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.n = fFloatValue;
        }
        com.byazt.bd.s sVar = this.py;
        if (sVar != null) {
            sVar.n(this.fs);
        }
        this.fs.setAlpha(com.byazt.nu.rv.n((int) ((((i / 255.0f) * this.oa.x().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.x, this.fs);
        com.byazt.pp.l.qg("GradientFillContent#draw");
    }

    @Override // com.byazt.sp.l
    public void n(RectF rectF, Matrix matrix, boolean z) {
        this.x.reset();
        for (int i = 0; i < this.tj.size(); i++) {
            this.x.addPath(this.tj.get(i).q(), matrix);
        }
        this.x.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    private LinearGradient qg() {
        long jQ = q();
        LinearGradient linearGradient = this.l.get(jQ);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFX = this.sz.x();
        PointF pointFX2 = this.k.x();
        com.byazt.aw.q qVarX = this.d.x();
        LinearGradient linearGradient2 = new LinearGradient(pointFX.x, pointFX.y, pointFX2.x, pointFX2.y, n(qVarX.qg()), qVarX.n(), Shader.TileMode.CLAMP);
        this.l.put(jQ, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient s() {
        long jQ = q();
        RadialGradient radialGradient = this.w.get(jQ);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFX = this.sz.x();
        PointF pointFX2 = this.k.x();
        com.byazt.aw.q qVarX = this.d.x();
        int[] iArrN = n(qVarX.qg());
        float[] fArrN = qVarX.n();
        float f = pointFX.x;
        float f2 = pointFX.y;
        float fHypot = (float) Math.hypot(pointFX2.x - f, pointFX2.y - f2);
        if (fHypot <= 0.0f) {
            fHypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f, f2, fHypot, iArrN, fArrN, Shader.TileMode.CLAMP);
        this.w.put(jQ, radialGradient2);
        return radialGradient2;
    }

    private int q() {
        int iRound = Math.round(this.sz.fs() * this.um);
        int iRound2 = Math.round(this.k.fs() * this.um);
        int iRound3 = Math.round(this.d.fs() * this.um);
        int i = iRound != 0 ? iRound * 527 : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private int[] n(int[] iArr) {
        com.byazt.bd.hd hdVar = this.hd;
        if (hdVar != null) {
            Integer[] numArr = (Integer[]) hdVar.x();
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

package com.byazt.ova;

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
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 423, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo implements com.byazt.al.pr.InterfaceC0016pr, c, w {
    public com.byazt.al.pr<Float, Float> a;
    public final RectF aj;
    public com.byazt.al.hn cz;
    public final Path fw;
    public final com.byazt.al.pr<PointF, PointF> g;
    public final boolean hn;
    public final com.byazt.al.pr<PointF, PointF> ho;
    public final String hw;
    public final com.byazt.al.pr<com.byazt.ynb.x, com.byazt.ynb.x> k;
    public final com.byazt.dx.zo lb;
    public final com.byazt.al.pr<Integer, Integer> m;
    public com.byazt.al.pr<ColorFilter, ColorFilter> nt;
    public float pr;
    public final int qa;
    public final List<m> vk;
    public final com.byazt.ynb.fw w;
    public final com.byazt.cg.hn x;
    public com.byazt.al.yb yb;
    public final Paint zo;
    public final LongSparseArray<LinearGradient> c = new LongSparseArray<>();
    public final LongSparseArray<RadialGradient> uc = new LongSparseArray<>();

    public zo(com.byazt.dx.zo zoVar, com.byazt.dx.uc ucVar, com.byazt.cg.hn hnVar, com.byazt.ynb.c cVar) {
        Path path = new Path();
        this.fw = path;
        this.zo = new com.byazt.qpa.pr(1);
        this.aj = new RectF();
        this.vk = new ArrayList();
        this.pr = 0.0f;
        this.x = hnVar;
        this.hw = cVar.pr();
        this.hn = cVar.zo();
        this.lb = zoVar;
        this.w = cVar.hw();
        path.setFillType(cVar.hn());
        this.qa = (int) (ucVar.c() / 32.0f);
        com.byazt.al.pr<com.byazt.ynb.x, com.byazt.ynb.x> prVarPr = cVar.x().pr();
        this.k = prVarPr;
        prVarPr.pr(this);
        hnVar.pr(prVarPr);
        com.byazt.al.pr<Integer, Integer> prVarPr2 = cVar.c().pr();
        this.m = prVarPr2;
        prVarPr2.pr(this);
        hnVar.pr(prVarPr2);
        com.byazt.al.pr<PointF, PointF> prVarPr3 = cVar.uc().pr();
        this.g = prVarPr3;
        prVarPr3.pr(this);
        hnVar.pr(prVarPr3);
        com.byazt.al.pr<PointF, PointF> prVarPr4 = cVar.fw().pr();
        this.ho = prVarPr4;
        prVarPr4.pr(this);
        hnVar.pr(prVarPr4);
        if (hnVar.k() != null) {
            com.byazt.al.pr<Float, Float> prVarPr5 = hnVar.k().pr().pr();
            this.a = prVarPr5;
            prVarPr5.pr(this);
            hnVar.pr(this.a);
        }
        if (hnVar.m() != null) {
            this.cz = new com.byazt.al.hn(this, hnVar, hnVar.m());
        }
    }

    @Override // com.byazt.al.pr.InterfaceC0016pr
    public void pr() {
        this.lb.invalidateSelf();
    }

    @Override // com.byazt.ova.hn
    public void pr(List<hn> list, List<hn> list2) {
        for (int i = 0; i < list2.size(); i++) {
            hn hnVar = list2.get(i);
            if (hnVar instanceof m) {
                this.vk.add((m) hnVar);
            }
        }
    }

    @Override // com.byazt.ova.c
    public void pr(Canvas canvas, Matrix matrix, int i) {
        Shader shaderHn;
        if (this.hn) {
            return;
        }
        com.byazt.dx.c.pr("GradientFillContent#draw");
        this.fw.reset();
        for (int i2 = 0; i2 < this.vk.size(); i2++) {
            this.fw.addPath(this.vk.get(i2).x(), matrix);
        }
        this.fw.computeBounds(this.aj, false);
        if (this.w == com.byazt.ynb.fw.LINEAR) {
            shaderHn = hw();
        } else {
            shaderHn = hn();
        }
        shaderHn.setLocalMatrix(matrix);
        this.zo.setShader(shaderHn);
        com.byazt.al.pr<ColorFilter, ColorFilter> prVar = this.nt;
        if (prVar != null) {
            this.zo.setColorFilter(prVar.fw());
        }
        com.byazt.al.pr<Float, Float> prVar2 = this.a;
        if (prVar2 != null) {
            float fFloatValue = prVar2.fw().floatValue();
            if (fFloatValue == 0.0f) {
                this.zo.setMaskFilter(null);
            } else if (fFloatValue != this.pr) {
                this.zo.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.pr = fFloatValue;
        }
        com.byazt.al.hn hnVar = this.cz;
        if (hnVar != null) {
            hnVar.pr(this.zo);
        }
        this.zo.setAlpha(com.byazt.ptr.aj.pr((int) ((((i / 255.0f) * this.m.fw().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.fw, this.zo);
        com.byazt.dx.c.hw("GradientFillContent#draw");
    }

    @Override // com.byazt.ova.c
    public void pr(RectF rectF, Matrix matrix, boolean z) {
        this.fw.reset();
        for (int i = 0; i < this.vk.size(); i++) {
            this.fw.addPath(this.vk.get(i).x(), matrix);
        }
        this.fw.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    private LinearGradient hw() {
        long jX = x();
        LinearGradient linearGradient = this.c.get(jX);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFFw = this.g.fw();
        PointF pointFFw2 = this.ho.fw();
        com.byazt.ynb.x xVarFw = this.k.fw();
        LinearGradient linearGradient2 = new LinearGradient(pointFFw.x, pointFFw.y, pointFFw2.x, pointFFw2.y, pr(xVarFw.hw()), xVarFw.pr(), Shader.TileMode.CLAMP);
        this.c.put(jX, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient hn() {
        float f;
        long jX = x();
        RadialGradient radialGradient = this.uc.get(jX);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFFw = this.g.fw();
        PointF pointFFw2 = this.ho.fw();
        com.byazt.ynb.x xVarFw = this.k.fw();
        int[] iArrPr = pr(xVarFw.hw());
        float[] fArrPr = xVarFw.pr();
        float f2 = pointFFw.x;
        float f3 = pointFFw.y;
        float fHypot = (float) Math.hypot(pointFFw2.x - f2, pointFFw2.y - f3);
        if (fHypot > 0.0f) {
            f = fHypot;
        } else {
            f = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f2, f3, f, iArrPr, fArrPr, Shader.TileMode.CLAMP);
        this.uc.put(jX, radialGradient2);
        return radialGradient2;
    }

    private int x() {
        int i;
        int iRound = Math.round(this.g.zo() * this.qa);
        int iRound2 = Math.round(this.ho.zo() * this.qa);
        int iRound3 = Math.round(this.k.zo() * this.qa);
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
        com.byazt.al.yb ybVar = this.yb;
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

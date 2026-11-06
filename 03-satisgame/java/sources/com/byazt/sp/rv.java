package com.byazt.sp;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1179, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends n {
    public final com.byazt.bd.n<com.byazt.aw.q, com.byazt.aw.q> cp;
    public final com.byazt.bd.n<PointF, PointF> d;
    public final RectF fs;
    public final boolean l;
    public final com.byazt.bd.n<PointF, PointF> oa;
    public final String q;
    public final com.byazt.aw.x rv;
    public com.byazt.bd.hd sz;
    public final int tj;
    public final LongSparseArray<LinearGradient> w;
    public final LongSparseArray<RadialGradient> x;

    public rv(com.byazt.pp.fs fsVar, com.byazt.eg.s sVar, com.byazt.aw.w wVar) {
        super(fsVar, sVar, wVar.fs().n(), wVar.rv().n(), wVar.d(), wVar.q(), wVar.x(), wVar.tj(), wVar.cp());
        this.w = new LongSparseArray<>();
        this.x = new LongSparseArray<>();
        this.fs = new RectF();
        this.q = wVar.n();
        this.rv = wVar.qg();
        this.l = wVar.oa();
        this.tj = (int) (fsVar.t().l() / 32.0f);
        com.byazt.bd.n<com.byazt.aw.q, com.byazt.aw.q> nVarN = wVar.s().n();
        this.cp = nVarN;
        nVarN.n(this);
        sVar.n(nVarN);
        com.byazt.bd.n<PointF, PointF> nVarN2 = wVar.l().n();
        this.d = nVarN2;
        nVarN2.n(this);
        sVar.n(nVarN2);
        com.byazt.bd.n<PointF, PointF> nVarN3 = wVar.w().n();
        this.oa = nVarN3;
        nVarN3.n(this);
        sVar.n(nVarN3);
    }

    @Override // com.byazt.sp.n, com.byazt.sp.l
    public void n(Canvas canvas, Matrix matrix, int i) {
        Shader shaderS;
        if (this.l) {
            return;
        }
        n(this.fs, matrix, false);
        if (this.rv == com.byazt.aw.x.LINEAR) {
            shaderS = qg();
        } else {
            shaderS = s();
        }
        shaderS.setLocalMatrix(matrix);
        this.qg.setShader(shaderS);
        super.n(canvas, matrix, i);
    }

    private LinearGradient qg() {
        long jQ = q();
        LinearGradient linearGradient = this.w.get(jQ);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFX = this.d.x();
        PointF pointFX2 = this.oa.x();
        com.byazt.aw.q qVarX = this.cp.x();
        LinearGradient linearGradient2 = new LinearGradient(pointFX.x, pointFX.y, pointFX2.x, pointFX2.y, n(qVarX.qg()), qVarX.n(), Shader.TileMode.CLAMP);
        this.w.put(jQ, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient s() {
        long jQ = q();
        RadialGradient radialGradient = this.x.get(jQ);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFX = this.d.x();
        PointF pointFX2 = this.oa.x();
        com.byazt.aw.q qVarX = this.cp.x();
        int[] iArrN = n(qVarX.qg());
        float[] fArrN = qVarX.n();
        float f = pointFX.x;
        float f2 = pointFX.y;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(pointFX2.x - f, pointFX2.y - f2), iArrN, fArrN, Shader.TileMode.CLAMP);
        this.x.put(jQ, radialGradient2);
        return radialGradient2;
    }

    private int q() {
        int iRound = Math.round(this.d.fs() * this.tj);
        int iRound2 = Math.round(this.oa.fs() * this.tj);
        int iRound3 = Math.round(this.cp.fs() * this.tj);
        int i = iRound != 0 ? iRound * 527 : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private int[] n(int[] iArr) {
        com.byazt.bd.hd hdVar = this.sz;
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

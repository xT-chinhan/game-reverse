package com.byazt.bd;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 893, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy {
    public q cp;
    public q d;
    public n<com.byazt.yt.q, com.byazt.yt.q> fs;
    public final float[] l;
    public final Matrix n = new Matrix();
    public n<?, Float> oa;
    public final Matrix q;
    public final Matrix qg;
    public n<Float, Float> rv;
    public final Matrix s;
    public n<?, Float> sz;
    public n<Integer, Integer> tj;
    public n<PointF, PointF> w;
    public n<?, PointF> x;

    public cy(com.byazt.ccr.d dVar) {
        this.w = dVar.n() == null ? null : dVar.n().n();
        this.x = dVar.qg() == null ? null : dVar.qg().n();
        this.fs = dVar.s() == null ? null : dVar.s().n();
        this.rv = dVar.q() == null ? null : dVar.q().n();
        q qVar = dVar.fs() == null ? null : (q) dVar.fs().n();
        this.cp = qVar;
        if (qVar != null) {
            this.qg = new Matrix();
            this.s = new Matrix();
            this.q = new Matrix();
            this.l = new float[9];
        } else {
            this.qg = null;
            this.s = null;
            this.q = null;
            this.l = null;
        }
        this.d = dVar.rv() == null ? null : (q) dVar.rv().n();
        if (dVar.l() != null) {
            this.tj = dVar.l().n();
        }
        if (dVar.w() != null) {
            this.oa = dVar.w().n();
        } else {
            this.oa = null;
        }
        if (dVar.x() != null) {
            this.sz = dVar.x().n();
        } else {
            this.sz = null;
        }
    }

    public void n(com.byazt.eg.s sVar) {
        sVar.n(this.tj);
        sVar.n(this.oa);
        sVar.n(this.sz);
        sVar.n(this.w);
        sVar.n(this.x);
        sVar.n(this.fs);
        sVar.n(this.rv);
        sVar.n(this.cp);
        sVar.n(this.d);
    }

    public void n(n.InterfaceC0134n interfaceC0134n) {
        n<Integer, Integer> nVar = this.tj;
        if (nVar != null) {
            nVar.n(interfaceC0134n);
        }
        n<?, Float> nVar2 = this.oa;
        if (nVar2 != null) {
            nVar2.n(interfaceC0134n);
        }
        n<?, Float> nVar3 = this.sz;
        if (nVar3 != null) {
            nVar3.n(interfaceC0134n);
        }
        n<PointF, PointF> nVar4 = this.w;
        if (nVar4 != null) {
            nVar4.n(interfaceC0134n);
        }
        n<?, PointF> nVar5 = this.x;
        if (nVar5 != null) {
            nVar5.n(interfaceC0134n);
        }
        n<com.byazt.yt.q, com.byazt.yt.q> nVar6 = this.fs;
        if (nVar6 != null) {
            nVar6.n(interfaceC0134n);
        }
        n<Float, Float> nVar7 = this.rv;
        if (nVar7 != null) {
            nVar7.n(interfaceC0134n);
        }
        q qVar = this.cp;
        if (qVar != null) {
            qVar.n(interfaceC0134n);
        }
        q qVar2 = this.d;
        if (qVar2 != null) {
            qVar2.n(interfaceC0134n);
        }
    }

    public void n(float f) {
        n<Integer, Integer> nVar = this.tj;
        if (nVar != null) {
            nVar.n(f);
        }
        n<?, Float> nVar2 = this.oa;
        if (nVar2 != null) {
            nVar2.n(f);
        }
        n<?, Float> nVar3 = this.sz;
        if (nVar3 != null) {
            nVar3.n(f);
        }
        n<PointF, PointF> nVar4 = this.w;
        if (nVar4 != null) {
            nVar4.n(f);
        }
        n<?, PointF> nVar5 = this.x;
        if (nVar5 != null) {
            nVar5.n(f);
        }
        n<com.byazt.yt.q, com.byazt.yt.q> nVar6 = this.fs;
        if (nVar6 != null) {
            nVar6.n(f);
        }
        n<Float, Float> nVar7 = this.rv;
        if (nVar7 != null) {
            nVar7.n(f);
        }
        q qVar = this.cp;
        if (qVar != null) {
            qVar.n(f);
        }
        q qVar2 = this.d;
        if (qVar2 != null) {
            qVar2.n(f);
        }
    }

    public n<?, Integer> n() {
        return this.tj;
    }

    public n<?, Float> qg() {
        return this.oa;
    }

    public n<?, Float> s() {
        return this.sz;
    }

    public Matrix q() {
        PointF pointFX;
        float fRv;
        PointF pointFX2;
        this.n.reset();
        n<?, PointF> nVar = this.x;
        if (nVar != null && (pointFX2 = nVar.x()) != null && (pointFX2.x != 0.0f || pointFX2.y != 0.0f)) {
            this.n.preTranslate(pointFX2.x, pointFX2.y);
        }
        n<Float, Float> nVar2 = this.rv;
        if (nVar2 != null) {
            if (nVar2 instanceof hd) {
                fRv = nVar2.x().floatValue();
            } else {
                fRv = ((q) nVar2).rv();
            }
            if (fRv != 0.0f) {
                this.n.preRotate(fRv);
            }
        }
        q qVar = this.cp;
        if (qVar != null) {
            q qVar2 = this.d;
            float fCos = qVar2 == null ? 0.0f : (float) Math.cos(Math.toRadians((-qVar2.rv()) + 90.0f));
            q qVar3 = this.d;
            float fSin = qVar3 == null ? 1.0f : (float) Math.sin(Math.toRadians((-qVar3.rv()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(qVar.rv()));
            l();
            float[] fArr = this.l;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f = -fSin;
            fArr[3] = f;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.qg.setValues(fArr);
            l();
            float[] fArr2 = this.l;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.s.setValues(fArr2);
            l();
            float[] fArr3 = this.l;
            fArr3[0] = fCos;
            fArr3[1] = f;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.q.setValues(fArr3);
            this.s.preConcat(this.qg);
            this.q.preConcat(this.s);
            this.n.preConcat(this.q);
        }
        n<com.byazt.yt.q, com.byazt.yt.q> nVar3 = this.fs;
        if (nVar3 != null) {
            com.byazt.yt.q qVarX = nVar3.x();
            if (qVarX.n() != 1.0f || qVarX.qg() != 1.0f) {
                this.n.preScale(qVarX.n(), qVarX.qg());
            }
        }
        n<PointF, PointF> nVar4 = this.w;
        if (nVar4 != null && (((pointFX = nVar4.x()) != null && pointFX.x != 0.0f) || pointFX.y != 0.0f)) {
            this.n.preTranslate(-pointFX.x, -pointFX.y);
        }
        return this.n;
    }

    private void l() {
        for (int i = 0; i < 9; i++) {
            this.l[i] = 0.0f;
        }
    }

    public Matrix qg(float f) {
        n<?, PointF> nVar = this.x;
        PointF pointFX = nVar == null ? null : nVar.x();
        n<com.byazt.yt.q, com.byazt.yt.q> nVar2 = this.fs;
        com.byazt.yt.q qVarX = nVar2 == null ? null : nVar2.x();
        this.n.reset();
        if (pointFX != null) {
            this.n.preTranslate(pointFX.x * f, pointFX.y * f);
        }
        if (qVarX != null) {
            double d = f;
            this.n.preScale((float) Math.pow(qVarX.n(), d), (float) Math.pow(qVarX.qg(), d));
        }
        n<Float, Float> nVar3 = this.rv;
        if (nVar3 != null) {
            float fFloatValue = nVar3.x().floatValue();
            n<PointF, PointF> nVar4 = this.w;
            PointF pointFX2 = nVar4 != null ? nVar4.x() : null;
            this.n.preRotate(fFloatValue * f, pointFX2 == null ? 0.0f : pointFX2.x, pointFX2 != null ? pointFX2.y : 0.0f);
        }
        return this.n;
    }
}

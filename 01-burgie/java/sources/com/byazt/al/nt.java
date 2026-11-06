package com.byazt.al;

import android.graphics.Matrix;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 60, 74})
public class nt {
    public pr<Float, Float> aj;
    public final float[] c;
    public pr<?, PointF> fw;
    public pr<?, Float> g;
    public final Matrix hn;
    public final Matrix hw;
    public x k;
    public pr<?, Float> m;
    public final Matrix pr = new Matrix();
    public pr<PointF, PointF> uc;
    public pr<Integer, Integer> vk;
    public x w;
    public final Matrix x;
    public pr<com.byazt.cz.x, com.byazt.cz.x> zo;

    public nt(com.byazt.eqw.k kVar) {
        this.uc = kVar.pr() == null ? null : kVar.pr().pr();
        this.fw = kVar.hw() == null ? null : kVar.hw().pr();
        this.zo = kVar.hn() == null ? null : kVar.hn().pr();
        this.aj = kVar.x() == null ? null : kVar.x().pr();
        x xVar = kVar.zo() == null ? null : (x) kVar.zo().pr();
        this.w = xVar;
        if (xVar != null) {
            this.hw = new Matrix();
            this.hn = new Matrix();
            this.x = new Matrix();
            this.c = new float[9];
        } else {
            this.hw = null;
            this.hn = null;
            this.x = null;
            this.c = null;
        }
        this.k = kVar.aj() == null ? null : (x) kVar.aj().pr();
        if (kVar.c() != null) {
            this.vk = kVar.c().pr();
        }
        if (kVar.uc() != null) {
            this.m = kVar.uc().pr();
        } else {
            this.m = null;
        }
        if (kVar.fw() != null) {
            this.g = kVar.fw().pr();
        } else {
            this.g = null;
        }
    }

    public void pr(com.byazt.cg.hn hnVar) {
        hnVar.pr(this.vk);
        hnVar.pr(this.m);
        hnVar.pr(this.g);
        hnVar.pr(this.uc);
        hnVar.pr(this.fw);
        hnVar.pr(this.zo);
        hnVar.pr(this.aj);
        hnVar.pr(this.w);
        hnVar.pr(this.k);
    }

    public void pr(pr.InterfaceC0016pr interfaceC0016pr) {
        pr<Integer, Integer> prVar = this.vk;
        if (prVar != null) {
            prVar.pr(interfaceC0016pr);
        }
        pr<?, Float> prVar2 = this.m;
        if (prVar2 != null) {
            prVar2.pr(interfaceC0016pr);
        }
        pr<?, Float> prVar3 = this.g;
        if (prVar3 != null) {
            prVar3.pr(interfaceC0016pr);
        }
        pr<PointF, PointF> prVar4 = this.uc;
        if (prVar4 != null) {
            prVar4.pr(interfaceC0016pr);
        }
        pr<?, PointF> prVar5 = this.fw;
        if (prVar5 != null) {
            prVar5.pr(interfaceC0016pr);
        }
        pr<com.byazt.cz.x, com.byazt.cz.x> prVar6 = this.zo;
        if (prVar6 != null) {
            prVar6.pr(interfaceC0016pr);
        }
        pr<Float, Float> prVar7 = this.aj;
        if (prVar7 != null) {
            prVar7.pr(interfaceC0016pr);
        }
        x xVar = this.w;
        if (xVar != null) {
            xVar.pr(interfaceC0016pr);
        }
        x xVar2 = this.k;
        if (xVar2 != null) {
            xVar2.pr(interfaceC0016pr);
        }
    }

    public void pr(float f) {
        pr<Integer, Integer> prVar = this.vk;
        if (prVar != null) {
            prVar.pr(f);
        }
        pr<?, Float> prVar2 = this.m;
        if (prVar2 != null) {
            prVar2.pr(f);
        }
        pr<?, Float> prVar3 = this.g;
        if (prVar3 != null) {
            prVar3.pr(f);
        }
        pr<PointF, PointF> prVar4 = this.uc;
        if (prVar4 != null) {
            prVar4.pr(f);
        }
        pr<?, PointF> prVar5 = this.fw;
        if (prVar5 != null) {
            prVar5.pr(f);
        }
        pr<com.byazt.cz.x, com.byazt.cz.x> prVar6 = this.zo;
        if (prVar6 != null) {
            prVar6.pr(f);
        }
        pr<Float, Float> prVar7 = this.aj;
        if (prVar7 != null) {
            prVar7.pr(f);
        }
        x xVar = this.w;
        if (xVar != null) {
            xVar.pr(f);
        }
        x xVar2 = this.k;
        if (xVar2 != null) {
            xVar2.pr(f);
        }
    }

    public pr<?, Integer> pr() {
        return this.vk;
    }

    public pr<?, Float> hw() {
        return this.m;
    }

    public pr<?, Float> hn() {
        return this.g;
    }

    public Matrix x() {
        PointF pointFFw;
        float fAj;
        PointF pointFFw2;
        this.pr.reset();
        pr<?, PointF> prVar = this.fw;
        if (prVar != null && (pointFFw2 = prVar.fw()) != null && (pointFFw2.x != 0.0f || pointFFw2.y != 0.0f)) {
            this.pr.preTranslate(pointFFw2.x, pointFFw2.y);
        }
        pr<Float, Float> prVar2 = this.aj;
        if (prVar2 != null) {
            if (prVar2 instanceof yb) {
                fAj = prVar2.fw().floatValue();
            } else {
                fAj = ((x) prVar2).aj();
            }
            if (fAj != 0.0f) {
                this.pr.preRotate(fAj);
            }
        }
        x xVar = this.w;
        if (xVar != null) {
            x xVar2 = this.k;
            float fCos = xVar2 == null ? 0.0f : (float) Math.cos(Math.toRadians((-xVar2.aj()) + 90.0f));
            x xVar3 = this.k;
            float fSin = xVar3 == null ? 1.0f : (float) Math.sin(Math.toRadians((-xVar3.aj()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(xVar.aj()));
            c();
            float[] fArr = this.c;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f = -fSin;
            fArr[3] = f;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.hw.setValues(fArr);
            c();
            float[] fArr2 = this.c;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.hn.setValues(fArr2);
            c();
            float[] fArr3 = this.c;
            fArr3[0] = fCos;
            fArr3[1] = f;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.x.setValues(fArr3);
            this.hn.preConcat(this.hw);
            this.x.preConcat(this.hn);
            this.pr.preConcat(this.x);
        }
        pr<com.byazt.cz.x, com.byazt.cz.x> prVar3 = this.zo;
        if (prVar3 != null) {
            com.byazt.cz.x xVarFw = prVar3.fw();
            if (xVarFw.pr() != 1.0f || xVarFw.hw() != 1.0f) {
                this.pr.preScale(xVarFw.pr(), xVarFw.hw());
            }
        }
        pr<PointF, PointF> prVar4 = this.uc;
        if (prVar4 != null && (((pointFFw = prVar4.fw()) != null && pointFFw.x != 0.0f) || pointFFw.y != 0.0f)) {
            this.pr.preTranslate(-pointFFw.x, -pointFFw.y);
        }
        return this.pr;
    }

    private void c() {
        for (int i = 0; i < 9; i++) {
            this.c[i] = 0.0f;
        }
    }

    public Matrix hw(float f) {
        pr<?, PointF> prVar = this.fw;
        PointF pointFFw = prVar == null ? null : prVar.fw();
        pr<com.byazt.cz.x, com.byazt.cz.x> prVar2 = this.zo;
        com.byazt.cz.x xVarFw = prVar2 == null ? null : prVar2.fw();
        this.pr.reset();
        if (pointFFw != null) {
            this.pr.preTranslate(pointFFw.x * f, pointFFw.y * f);
        }
        if (xVarFw != null) {
            double d = f;
            this.pr.preScale((float) Math.pow(xVarFw.pr(), d), (float) Math.pow(xVarFw.hw(), d));
        }
        pr<Float, Float> prVar3 = this.aj;
        if (prVar3 != null) {
            float fFloatValue = prVar3.fw().floatValue();
            pr<PointF, PointF> prVar4 = this.uc;
            PointF pointFFw2 = prVar4 != null ? prVar4.fw() : null;
            this.pr.preRotate(fFloatValue * f, pointFFw2 == null ? 0.0f : pointFFw2.x, pointFFw2 != null ? pointFFw2.y : 0.0f);
        }
        return this.pr;
    }
}

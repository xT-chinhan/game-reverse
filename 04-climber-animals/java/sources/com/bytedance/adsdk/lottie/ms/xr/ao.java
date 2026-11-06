package com.bytedance.adsdk.lottie.ms.xr;

import android.graphics.Matrix;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
public class ao {
    private ms<?, PointF> ab;
    private final Matrix ah;
    private ms<PointF, PointF> c;
    private ms<Integer, Integer> ch;
    private final Matrix d;
    private d hi;
    private final float[] ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Matrix f260ms = new Matrix();
    private ms<Float, Float> ny;
    private d sl;
    private ms<?, Float> u;
    private ms<com.bytedance.adsdk.lottie.c.d, com.bytedance.adsdk.lottie.c.d> x;
    private final Matrix xr;
    private ms<?, Float> zb;

    public ao(com.bytedance.adsdk.lottie.model.ms.sl slVar) {
        this.c = slVar.ms() == null ? null : slVar.ms().ms();
        this.ab = slVar.xr() == null ? null : slVar.xr().ms();
        this.x = slVar.ah() == null ? null : slVar.ah().ms();
        this.ny = slVar.d() == null ? null : slVar.d().ms();
        d dVar = slVar.x() == null ? null : (d) slVar.x().ms();
        this.hi = dVar;
        if (dVar != null) {
            this.xr = new Matrix();
            this.ah = new Matrix();
            this.d = new Matrix();
            this.ka = new float[9];
        } else {
            this.xr = null;
            this.ah = null;
            this.d = null;
            this.ka = null;
        }
        this.sl = slVar.ny() == null ? null : (d) slVar.ny().ms();
        if (slVar.ka() != null) {
            this.ch = slVar.ka().ms();
        }
        if (slVar.c() != null) {
            this.zb = slVar.c().ms();
        } else {
            this.zb = null;
        }
        if (slVar.ab() != null) {
            this.u = slVar.ab().ms();
        } else {
            this.u = null;
        }
    }

    public void ms(com.bytedance.adsdk.lottie.model.layer.ah ahVar) {
        ahVar.ms(this.ch);
        ahVar.ms(this.zb);
        ahVar.ms(this.u);
        ahVar.ms(this.c);
        ahVar.ms(this.ab);
        ahVar.ms(this.x);
        ahVar.ms(this.ny);
        ahVar.ms(this.hi);
        ahVar.ms(this.sl);
    }

    public void ms(ms.InterfaceC0189ms interfaceC0189ms) {
        ms<Integer, Integer> msVar = this.ch;
        if (msVar != null) {
            msVar.ms(interfaceC0189ms);
        }
        ms<?, Float> msVar2 = this.zb;
        if (msVar2 != null) {
            msVar2.ms(interfaceC0189ms);
        }
        ms<?, Float> msVar3 = this.u;
        if (msVar3 != null) {
            msVar3.ms(interfaceC0189ms);
        }
        ms<PointF, PointF> msVar4 = this.c;
        if (msVar4 != null) {
            msVar4.ms(interfaceC0189ms);
        }
        ms<?, PointF> msVar5 = this.ab;
        if (msVar5 != null) {
            msVar5.ms(interfaceC0189ms);
        }
        ms<com.bytedance.adsdk.lottie.c.d, com.bytedance.adsdk.lottie.c.d> msVar6 = this.x;
        if (msVar6 != null) {
            msVar6.ms(interfaceC0189ms);
        }
        ms<Float, Float> msVar7 = this.ny;
        if (msVar7 != null) {
            msVar7.ms(interfaceC0189ms);
        }
        d dVar = this.hi;
        if (dVar != null) {
            dVar.ms(interfaceC0189ms);
        }
        d dVar2 = this.sl;
        if (dVar2 != null) {
            dVar2.ms(interfaceC0189ms);
        }
    }

    public void ms(float f) {
        ms<Integer, Integer> msVar = this.ch;
        if (msVar != null) {
            msVar.ms(f);
        }
        ms<?, Float> msVar2 = this.zb;
        if (msVar2 != null) {
            msVar2.ms(f);
        }
        ms<?, Float> msVar3 = this.u;
        if (msVar3 != null) {
            msVar3.ms(f);
        }
        ms<PointF, PointF> msVar4 = this.c;
        if (msVar4 != null) {
            msVar4.ms(f);
        }
        ms<?, PointF> msVar5 = this.ab;
        if (msVar5 != null) {
            msVar5.ms(f);
        }
        ms<com.bytedance.adsdk.lottie.c.d, com.bytedance.adsdk.lottie.c.d> msVar6 = this.x;
        if (msVar6 != null) {
            msVar6.ms(f);
        }
        ms<Float, Float> msVar7 = this.ny;
        if (msVar7 != null) {
            msVar7.ms(f);
        }
        d dVar = this.hi;
        if (dVar != null) {
            dVar.ms(f);
        }
        d dVar2 = this.sl;
        if (dVar2 != null) {
            dVar2.ms(f);
        }
    }

    public ms<?, Integer> ms() {
        return this.ch;
    }

    public ms<?, Float> xr() {
        return this.zb;
    }

    public ms<?, Float> ah() {
        return this.u;
    }

    public Matrix d() {
        PointF pointFAb;
        float fNy;
        PointF pointFAb2;
        this.f260ms.reset();
        ms<?, PointF> msVar = this.ab;
        if (msVar != null && (pointFAb2 = msVar.ab()) != null && (pointFAb2.x != 0.0f || pointFAb2.y != 0.0f)) {
            this.f260ms.preTranslate(pointFAb2.x, pointFAb2.y);
        }
        ms<Float, Float> msVar2 = this.ny;
        if (msVar2 != null) {
            if (msVar2 instanceof h) {
                fNy = msVar2.ab().floatValue();
            } else {
                fNy = ((d) msVar2).ny();
            }
            if (fNy != 0.0f) {
                this.f260ms.preRotate(fNy);
            }
        }
        d dVar = this.hi;
        if (dVar != null) {
            d dVar2 = this.sl;
            float fCos = dVar2 == null ? 0.0f : (float) Math.cos(Math.toRadians((-dVar2.ny()) + 90.0f));
            d dVar3 = this.sl;
            float fSin = dVar3 == null ? 1.0f : (float) Math.sin(Math.toRadians((-dVar3.ny()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(dVar.ny()));
            ka();
            float[] fArr = this.ka;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f = -fSin;
            fArr[3] = f;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.xr.setValues(fArr);
            ka();
            float[] fArr2 = this.ka;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.ah.setValues(fArr2);
            ka();
            float[] fArr3 = this.ka;
            fArr3[0] = fCos;
            fArr3[1] = f;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.d.setValues(fArr3);
            this.ah.preConcat(this.xr);
            this.d.preConcat(this.ah);
            this.f260ms.preConcat(this.d);
        }
        ms<com.bytedance.adsdk.lottie.c.d, com.bytedance.adsdk.lottie.c.d> msVar3 = this.x;
        if (msVar3 != null) {
            com.bytedance.adsdk.lottie.c.d dVarAb = msVar3.ab();
            if (dVarAb.ms() != 1.0f || dVarAb.xr() != 1.0f) {
                this.f260ms.preScale(dVarAb.ms(), dVarAb.xr());
            }
        }
        ms<PointF, PointF> msVar4 = this.c;
        if (msVar4 != null && (((pointFAb = msVar4.ab()) != null && pointFAb.x != 0.0f) || pointFAb.y != 0.0f)) {
            this.f260ms.preTranslate(-pointFAb.x, -pointFAb.y);
        }
        return this.f260ms;
    }

    private void ka() {
        for (int i = 0; i < 9; i++) {
            this.ka[i] = 0.0f;
        }
    }

    public Matrix xr(float f) {
        ms<?, PointF> msVar = this.ab;
        PointF pointFAb = msVar == null ? null : msVar.ab();
        ms<com.bytedance.adsdk.lottie.c.d, com.bytedance.adsdk.lottie.c.d> msVar2 = this.x;
        com.bytedance.adsdk.lottie.c.d dVarAb = msVar2 == null ? null : msVar2.ab();
        this.f260ms.reset();
        if (pointFAb != null) {
            this.f260ms.preTranslate(pointFAb.x * f, pointFAb.y * f);
        }
        if (dVarAb != null) {
            double d = f;
            this.f260ms.preScale((float) Math.pow(dVarAb.ms(), d), (float) Math.pow(dVarAb.xr(), d));
        }
        ms<Float, Float> msVar3 = this.ny;
        if (msVar3 != null) {
            float fFloatValue = msVar3.ab().floatValue();
            ms<PointF, PointF> msVar4 = this.c;
            PointF pointFAb2 = msVar4 != null ? msVar4.ab() : null;
            this.f260ms.preRotate(fFloatValue * f, pointFAb2 == null ? 0.0f : pointFAb2.x, pointFAb2 != null ? pointFAb2.y : 0.0f);
        }
        return this.f260ms;
    }
}

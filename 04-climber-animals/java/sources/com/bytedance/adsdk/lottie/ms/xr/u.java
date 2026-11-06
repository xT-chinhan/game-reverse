package com.bytedance.adsdk.lottie.ms.xr;

import android.graphics.PointF;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class u extends ms<PointF, PointF> {
    private final PointF ab;
    private final PointF c;
    protected com.bytedance.adsdk.lottie.c.ah<Float> d;
    protected com.bytedance.adsdk.lottie.c.ah<Float> ka;
    private final ms<Float, Float> ny;
    private final ms<Float, Float> x;

    public u(ms<Float, Float> msVar, ms<Float, Float> msVar2) {
        super(Collections.emptyList());
        this.c = new PointF();
        this.ab = new PointF();
        this.x = msVar;
        this.ny = msVar2;
        ms(x());
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms
    public void ms(float f) {
        this.x.ms(f);
        this.ny.ms(f);
        this.c.set(this.x.ab().floatValue(), this.ny.ab().floatValue());
        for (int i = 0; i < this.f261ms.size(); i++) {
            this.f261ms.get(i).ms();
        }
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms
    /* JADX INFO: renamed from: ny, reason: merged with bridge method [inline-methods] */
    public PointF ab() {
        return ms(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.ms.xr.ms
    /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
    public PointF ms(com.bytedance.adsdk.lottie.c.ms<PointF> msVar, float f) {
        Float fMs;
        com.bytedance.adsdk.lottie.c.ms<Float> msVarAh;
        com.bytedance.adsdk.lottie.c.ms<Float> msVarAh2;
        Float fMs2 = null;
        if (this.d == null || (msVarAh2 = this.x.ah()) == null) {
            fMs = null;
        } else {
            float fKa = this.x.ka();
            Float f2 = msVarAh2.ab;
            fMs = this.d.ms(msVarAh2.c, f2 == null ? msVarAh2.c : f2.floatValue(), msVarAh2.f150ms, msVarAh2.xr, f, f, fKa);
        }
        if (this.ka != null && (msVarAh = this.ny.ah()) != null) {
            float fKa2 = this.ny.ka();
            Float f3 = msVarAh.ab;
            fMs2 = this.ka.ms(msVarAh.c, f3 == null ? msVarAh.c : f3.floatValue(), msVarAh.f150ms, msVarAh.xr, f, f, fKa2);
        }
        if (fMs == null) {
            this.ab.set(this.c.x, 0.0f);
        } else {
            this.ab.set(fMs.floatValue(), 0.0f);
        }
        if (fMs2 == null) {
            PointF pointF = this.ab;
            pointF.set(pointF.x, this.c.y);
        } else {
            PointF pointF2 = this.ab;
            pointF2.set(pointF2.x, fMs2.floatValue());
        }
        return this.ab;
    }
}

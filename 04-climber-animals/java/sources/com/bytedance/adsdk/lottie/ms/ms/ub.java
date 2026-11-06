package com.bytedance.adsdk.lottie.ms.ms;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ub implements hi, zb, com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms {
    private final com.bytedance.adsdk.lottie.ms.xr.ms<?, PointF> ab;
    private final String ah;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<?, PointF> c;
    private final boolean d;
    private boolean hi;
    private final com.bytedance.adsdk.lottie.x ka;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> x;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Path f256ms = new Path();
    private final RectF xr = new RectF();
    private final xr ny = new xr();
    private com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> ch = null;

    public ub(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar, com.bytedance.adsdk.lottie.model.xr.hi hiVar) {
        this.ah = hiVar.ms();
        this.d = hiVar.ka();
        this.ka = xVar;
        com.bytedance.adsdk.lottie.ms.xr.ms<PointF, PointF> msVarMs = hiVar.d().ms();
        this.c = msVarMs;
        com.bytedance.adsdk.lottie.ms.xr.ms<PointF, PointF> msVarMs2 = hiVar.ah().ms();
        this.ab = msVarMs2;
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVarMs3 = hiVar.xr().ms();
        this.x = msVarMs3;
        ahVar.ms(msVarMs);
        ahVar.ms(msVarMs2);
        ahVar.ms(msVarMs3);
        msVarMs.ms(this);
        msVarMs2.ms(this);
        msVarMs3.ms(this);
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms
    public void ms() {
        xr();
    }

    private void xr() {
        this.hi = false;
        this.ka.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:12:0x0029  */
    /* JADX WARN: Code duplicated, block: B:18:0x0031 A[SYNTHETIC] */
    @Override // com.bytedance.adsdk.lottie.ms.ms.ah
    public void ms(List<ah> list, List<ah> list2) {
        for (int i = 0; i < list.size(); i++) {
            ah ahVar = list.get(i);
            if (ahVar instanceof nw) {
                nw nwVar = (nw) ahVar;
                if (nwVar.getType() == com.bytedance.adsdk.lottie.model.xr.y.ms.SIMULTANEOUSLY) {
                    this.ny.ms(nwVar);
                    nwVar.ms(this);
                } else if (ahVar instanceof h) {
                    this.ch = ((h) ahVar).xr();
                }
            } else if (ahVar instanceof h) {
                this.ch = ((h) ahVar).xr();
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.zb
    public Path d() {
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVar;
        if (this.hi) {
            return this.f256ms;
        }
        this.f256ms.reset();
        if (this.d) {
            this.hi = true;
            return this.f256ms;
        }
        PointF pointFAb = this.ab.ab();
        float f = pointFAb.x / 2.0f;
        float f2 = pointFAb.y / 2.0f;
        com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> msVar2 = this.x;
        float fNy = msVar2 == null ? 0.0f : ((com.bytedance.adsdk.lottie.ms.xr.d) msVar2).ny();
        if (fNy == 0.0f && (msVar = this.ch) != null) {
            fNy = Math.min(msVar.ab().floatValue(), Math.min(f, f2));
        }
        float fMin = Math.min(f, f2);
        if (fNy > fMin) {
            fNy = fMin;
        }
        PointF pointFAb2 = this.c.ab();
        this.f256ms.moveTo(pointFAb2.x + f, (pointFAb2.y - f2) + fNy);
        this.f256ms.lineTo(pointFAb2.x + f, (pointFAb2.y + f2) - fNy);
        if (fNy > 0.0f) {
            float f3 = fNy * 2.0f;
            this.xr.set((pointFAb2.x + f) - f3, (pointFAb2.y + f2) - f3, pointFAb2.x + f, pointFAb2.y + f2);
            this.f256ms.arcTo(this.xr, 0.0f, 90.0f, false);
        }
        this.f256ms.lineTo((pointFAb2.x - f) + fNy, pointFAb2.y + f2);
        if (fNy > 0.0f) {
            float f4 = fNy * 2.0f;
            this.xr.set(pointFAb2.x - f, (pointFAb2.y + f2) - f4, (pointFAb2.x - f) + f4, pointFAb2.y + f2);
            this.f256ms.arcTo(this.xr, 90.0f, 90.0f, false);
        }
        this.f256ms.lineTo(pointFAb2.x - f, (pointFAb2.y - f2) + fNy);
        if (fNy > 0.0f) {
            float f5 = fNy * 2.0f;
            this.xr.set(pointFAb2.x - f, pointFAb2.y - f2, (pointFAb2.x - f) + f5, (pointFAb2.y - f2) + f5);
            this.f256ms.arcTo(this.xr, 180.0f, 90.0f, false);
        }
        this.f256ms.lineTo((pointFAb2.x + f) - fNy, pointFAb2.y - f2);
        if (fNy > 0.0f) {
            float f6 = fNy * 2.0f;
            this.xr.set((pointFAb2.x + f) - f6, pointFAb2.y - f2, pointFAb2.x + f, (pointFAb2.y - f2) + f6);
            this.f256ms.arcTo(this.xr, 270.0f, 90.0f, false);
        }
        this.f256ms.close();
        this.ny.ms(this.f256ms);
        this.hi = true;
        return this.f256ms;
    }
}

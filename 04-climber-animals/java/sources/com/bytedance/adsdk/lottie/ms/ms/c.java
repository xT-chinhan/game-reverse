package com.bytedance.adsdk.lottie.ms.ms;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c implements hi, zb, com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms {
    private final com.bytedance.adsdk.lottie.x ah;
    private final com.bytedance.adsdk.lottie.model.xr.xr c;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<?, PointF> d;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<?, PointF> ka;
    private boolean x;
    private final String xr;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Path f245ms = new Path();
    private final xr ab = new xr();

    public c(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar, com.bytedance.adsdk.lottie.model.xr.xr xrVar) {
        this.xr = xrVar.ms();
        this.ah = xVar;
        com.bytedance.adsdk.lottie.ms.xr.ms<PointF, PointF> msVarMs = xrVar.ah().ms();
        this.d = msVarMs;
        com.bytedance.adsdk.lottie.ms.xr.ms<PointF, PointF> msVarMs2 = xrVar.xr().ms();
        this.ka = msVarMs2;
        this.c = xrVar;
        ahVar.ms(msVarMs);
        ahVar.ms(msVarMs2);
        msVarMs.ms(this);
        msVarMs2.ms(this);
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms
    public void ms() {
        xr();
    }

    private void xr() {
        this.x = false;
        this.ah.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ah
    public void ms(List<ah> list, List<ah> list2) {
        for (int i = 0; i < list.size(); i++) {
            ah ahVar = list.get(i);
            if (ahVar instanceof nw) {
                nw nwVar = (nw) ahVar;
                if (nwVar.getType() == com.bytedance.adsdk.lottie.model.xr.y.ms.SIMULTANEOUSLY) {
                    this.ab.ms(nwVar);
                    nwVar.ms(this);
                }
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.zb
    public Path d() {
        if (this.x) {
            return this.f245ms;
        }
        this.f245ms.reset();
        if (this.c.ka()) {
            this.x = true;
            return this.f245ms;
        }
        PointF pointFAb = this.d.ab();
        float f = pointFAb.x / 2.0f;
        float f2 = pointFAb.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.f245ms.reset();
        if (this.c.d()) {
            float f5 = -f2;
            this.f245ms.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.f245ms.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.f245ms.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.f245ms.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.f245ms.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.f245ms.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.f245ms.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.f245ms.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.f245ms.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.f245ms.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFAb2 = this.ka.ab();
        this.f245ms.offset(pointFAb2.x, pointFAb2.y);
        this.f245ms.close();
        this.ab.ms(this.f245ms);
        this.x = true;
        return this.f245ms;
    }
}

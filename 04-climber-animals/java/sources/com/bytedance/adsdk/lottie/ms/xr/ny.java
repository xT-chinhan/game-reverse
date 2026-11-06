package com.bytedance.adsdk.lottie.ms.xr;

import android.graphics.Path;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
public class ny extends com.bytedance.adsdk.lottie.c.ms<PointF> {
    private Path ch;
    private final com.bytedance.adsdk.lottie.c.ms<PointF> hi;

    public ny(com.bytedance.adsdk.lottie.c cVar, com.bytedance.adsdk.lottie.c.ms<PointF> msVar) {
        super(cVar, msVar.f150ms, msVar.xr, msVar.ah, msVar.d, msVar.ka, msVar.c, msVar.ab);
        this.hi = msVar;
        ms();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ms() {
        boolean z = (this.xr == 0 || this.f150ms == 0 || !((PointF) this.f150ms).equals(((PointF) this.xr).x, ((PointF) this.xr).y)) ? false : true;
        if (this.f150ms == 0 || this.xr == 0 || z) {
            return;
        }
        this.ch = com.bytedance.adsdk.lottie.ka.ny.ms((PointF) this.f150ms, (PointF) this.xr, this.hi.x, this.hi.ny);
    }

    Path xr() {
        return this.ch;
    }
}

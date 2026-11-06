package com.bytedance.adsdk.lottie.model.xr;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ah {
    private final com.bytedance.adsdk.lottie.model.ms.c ah;
    private final boolean d;
    private final boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f237ms;
    private final com.bytedance.adsdk.lottie.model.ms.zb<PointF, PointF> xr;

    public xr(String str, com.bytedance.adsdk.lottie.model.ms.zb<PointF, PointF> zbVar, com.bytedance.adsdk.lottie.model.ms.c cVar, boolean z, boolean z2) {
        this.f237ms = str;
        this.xr = zbVar;
        this.ah = cVar;
        this.d = z;
        this.ka = z2;
    }

    @Override // com.bytedance.adsdk.lottie.model.xr.ah
    public com.bytedance.adsdk.lottie.ms.ms.ah ms(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.c cVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar) {
        return new com.bytedance.adsdk.lottie.ms.ms.c(xVar, ahVar, this);
    }

    public String ms() {
        return this.f237ms;
    }

    public com.bytedance.adsdk.lottie.model.ms.zb<PointF, PointF> xr() {
        return this.xr;
    }

    public com.bytedance.adsdk.lottie.model.ms.c ah() {
        return this.ah;
    }

    public boolean d() {
        return this.d;
    }

    public boolean ka() {
        return this.ka;
    }
}

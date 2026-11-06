package com.bytedance.adsdk.lottie.model.ms;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ny implements zb<PointF, PointF> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final xr f211ms;
    private final xr xr;

    public ny(xr xrVar, xr xrVar2) {
        this.f211ms = xrVar;
        this.xr = xrVar2;
    }

    @Override // com.bytedance.adsdk.lottie.model.ms.zb
    public List<com.bytedance.adsdk.lottie.c.ms<PointF>> ah() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.bytedance.adsdk.lottie.model.ms.zb
    public boolean xr() {
        return this.f211ms.xr() && this.xr.xr();
    }

    @Override // com.bytedance.adsdk.lottie.model.ms.zb
    public com.bytedance.adsdk.lottie.ms.xr.ms<PointF, PointF> ms() {
        return new com.bytedance.adsdk.lottie.ms.xr.u(this.f211ms.ms(), this.xr.ms());
    }
}

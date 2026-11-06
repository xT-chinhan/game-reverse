package com.bytedance.adsdk.lottie.model.xr;

/* JADX INFO: loaded from: classes2.dex */
public class zb implements ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f240ms;
    private final com.bytedance.adsdk.lottie.model.ms.zb<Float, Float> xr;

    public zb(String str, com.bytedance.adsdk.lottie.model.ms.zb<Float, Float> zbVar) {
        this.f240ms = str;
        this.xr = zbVar;
    }

    public String ms() {
        return this.f240ms;
    }

    public com.bytedance.adsdk.lottie.model.ms.zb<Float, Float> xr() {
        return this.xr;
    }

    @Override // com.bytedance.adsdk.lottie.model.xr.ah
    public com.bytedance.adsdk.lottie.ms.ms.ah ms(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.c cVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar) {
        return new com.bytedance.adsdk.lottie.ms.ms.h(xVar, ahVar, this);
    }
}

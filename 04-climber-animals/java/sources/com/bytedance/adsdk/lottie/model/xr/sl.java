package com.bytedance.adsdk.lottie.model.xr;

/* JADX INFO: loaded from: classes2.dex */
public class sl implements ah {
    private final com.bytedance.adsdk.lottie.model.ms.xr ah;
    private final com.bytedance.adsdk.lottie.model.ms.sl d;
    private final boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f232ms;
    private final com.bytedance.adsdk.lottie.model.ms.xr xr;

    public sl(String str, com.bytedance.adsdk.lottie.model.ms.xr xrVar, com.bytedance.adsdk.lottie.model.ms.xr xrVar2, com.bytedance.adsdk.lottie.model.ms.sl slVar, boolean z) {
        this.f232ms = str;
        this.xr = xrVar;
        this.ah = xrVar2;
        this.d = slVar;
        this.ka = z;
    }

    public String ms() {
        return this.f232ms;
    }

    public com.bytedance.adsdk.lottie.model.ms.xr xr() {
        return this.xr;
    }

    public com.bytedance.adsdk.lottie.model.ms.xr ah() {
        return this.ah;
    }

    public com.bytedance.adsdk.lottie.model.ms.sl d() {
        return this.d;
    }

    public boolean ka() {
        return this.ka;
    }

    @Override // com.bytedance.adsdk.lottie.model.xr.ah
    public com.bytedance.adsdk.lottie.ms.ms.ah ms(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.c cVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar) {
        return new com.bytedance.adsdk.lottie.ms.ms.ao(xVar, ahVar, this);
    }
}

package com.bytedance.adsdk.lottie.model.xr;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    private final com.bytedance.adsdk.lottie.model.ms.d ah;
    private final boolean d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ms f235ms;
    private final com.bytedance.adsdk.lottie.model.ms.x xr;

    public enum ms {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public x(ms msVar, com.bytedance.adsdk.lottie.model.ms.x xVar, com.bytedance.adsdk.lottie.model.ms.d dVar, boolean z) {
        this.f235ms = msVar;
        this.xr = xVar;
        this.ah = dVar;
        this.d = z;
    }

    public ms ms() {
        return this.f235ms;
    }

    public com.bytedance.adsdk.lottie.model.ms.x xr() {
        return this.xr;
    }

    public com.bytedance.adsdk.lottie.model.ms.d ah() {
        return this.ah;
    }

    public boolean d() {
        return this.d;
    }
}

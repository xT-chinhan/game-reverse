package com.bytedance.adsdk.lottie.model.xr;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ah {
    private final com.bytedance.adsdk.lottie.model.ms.xr ab;
    private final com.bytedance.adsdk.lottie.model.ms.ah ah;
    private final com.bytedance.adsdk.lottie.model.ms.c c;
    private final float ch;
    private final com.bytedance.adsdk.lottie.model.ms.d d;
    private final List<com.bytedance.adsdk.lottie.model.ms.xr> hi;
    private final com.bytedance.adsdk.lottie.model.ms.c ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f218ms;
    private final qv.xr ny;
    private final com.bytedance.adsdk.lottie.model.ms.xr sl;
    private final qv.ms x;
    private final ab xr;
    private final boolean zb;

    public c(String str, ab abVar, com.bytedance.adsdk.lottie.model.ms.ah ahVar, com.bytedance.adsdk.lottie.model.ms.d dVar, com.bytedance.adsdk.lottie.model.ms.c cVar, com.bytedance.adsdk.lottie.model.ms.c cVar2, com.bytedance.adsdk.lottie.model.ms.xr xrVar, qv.ms msVar, qv.xr xrVar2, float f, List<com.bytedance.adsdk.lottie.model.ms.xr> list, com.bytedance.adsdk.lottie.model.ms.xr xrVar3, boolean z) {
        this.f218ms = str;
        this.xr = abVar;
        this.ah = ahVar;
        this.d = dVar;
        this.ka = cVar;
        this.c = cVar2;
        this.ab = xrVar;
        this.x = msVar;
        this.ny = xrVar2;
        this.ch = f;
        this.hi = list;
        this.sl = xrVar3;
        this.zb = z;
    }

    public String ms() {
        return this.f218ms;
    }

    public ab xr() {
        return this.xr;
    }

    public com.bytedance.adsdk.lottie.model.ms.ah ah() {
        return this.ah;
    }

    public com.bytedance.adsdk.lottie.model.ms.d d() {
        return this.d;
    }

    public com.bytedance.adsdk.lottie.model.ms.c ka() {
        return this.ka;
    }

    public com.bytedance.adsdk.lottie.model.ms.c c() {
        return this.c;
    }

    public com.bytedance.adsdk.lottie.model.ms.xr ab() {
        return this.ab;
    }

    public qv.ms x() {
        return this.x;
    }

    public qv.xr ny() {
        return this.ny;
    }

    public List<com.bytedance.adsdk.lottie.model.ms.xr> ch() {
        return this.hi;
    }

    public com.bytedance.adsdk.lottie.model.ms.xr hi() {
        return this.sl;
    }

    public float sl() {
        return this.ch;
    }

    public boolean zb() {
        return this.zb;
    }

    @Override // com.bytedance.adsdk.lottie.model.xr.ah
    public com.bytedance.adsdk.lottie.ms.ms.ah ms(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.c cVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar) {
        return new com.bytedance.adsdk.lottie.ms.ms.ny(xVar, ahVar, this);
    }
}

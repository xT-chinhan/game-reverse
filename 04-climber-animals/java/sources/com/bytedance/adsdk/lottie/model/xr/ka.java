package com.bytedance.adsdk.lottie.model.xr;

import android.graphics.Path;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements ah {
    private final String ab;
    private final com.bytedance.adsdk.lottie.model.ms.ah ah;
    private final com.bytedance.adsdk.lottie.model.ms.c c;
    private final boolean ch;
    private final com.bytedance.adsdk.lottie.model.ms.d d;
    private final com.bytedance.adsdk.lottie.model.ms.c ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ab f224ms;
    private final com.bytedance.adsdk.lottie.model.ms.xr ny;
    private final com.bytedance.adsdk.lottie.model.ms.xr x;
    private final Path.FillType xr;

    public ka(String str, ab abVar, Path.FillType fillType, com.bytedance.adsdk.lottie.model.ms.ah ahVar, com.bytedance.adsdk.lottie.model.ms.d dVar, com.bytedance.adsdk.lottie.model.ms.c cVar, com.bytedance.adsdk.lottie.model.ms.c cVar2, com.bytedance.adsdk.lottie.model.ms.xr xrVar, com.bytedance.adsdk.lottie.model.ms.xr xrVar2, boolean z) {
        this.f224ms = abVar;
        this.xr = fillType;
        this.ah = ahVar;
        this.d = dVar;
        this.ka = cVar;
        this.c = cVar2;
        this.ab = str;
        this.x = xrVar;
        this.ny = xrVar2;
        this.ch = z;
    }

    public String ms() {
        return this.ab;
    }

    public ab xr() {
        return this.f224ms;
    }

    public Path.FillType ah() {
        return this.xr;
    }

    public com.bytedance.adsdk.lottie.model.ms.ah d() {
        return this.ah;
    }

    public com.bytedance.adsdk.lottie.model.ms.d ka() {
        return this.d;
    }

    public com.bytedance.adsdk.lottie.model.ms.c c() {
        return this.ka;
    }

    public com.bytedance.adsdk.lottie.model.ms.c ab() {
        return this.c;
    }

    public boolean x() {
        return this.ch;
    }

    @Override // com.bytedance.adsdk.lottie.model.xr.ah
    public com.bytedance.adsdk.lottie.ms.ms.ah ms(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.c cVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar) {
        return new com.bytedance.adsdk.lottie.ms.ms.x(xVar, cVar, ahVar, this);
    }
}

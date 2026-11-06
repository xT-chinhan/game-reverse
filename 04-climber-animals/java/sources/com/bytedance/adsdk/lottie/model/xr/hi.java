package com.bytedance.adsdk.lottie.model.xr;

import android.graphics.PointF;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class hi implements ah {
    private final com.bytedance.adsdk.lottie.model.ms.zb<PointF, PointF> ah;
    private final com.bytedance.adsdk.lottie.model.ms.xr d;
    private final boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f223ms;
    private final com.bytedance.adsdk.lottie.model.ms.zb<PointF, PointF> xr;

    public hi(String str, com.bytedance.adsdk.lottie.model.ms.zb<PointF, PointF> zbVar, com.bytedance.adsdk.lottie.model.ms.zb<PointF, PointF> zbVar2, com.bytedance.adsdk.lottie.model.ms.xr xrVar, boolean z) {
        this.f223ms = str;
        this.xr = zbVar;
        this.ah = zbVar2;
        this.d = xrVar;
        this.ka = z;
    }

    public String ms() {
        return this.f223ms;
    }

    public com.bytedance.adsdk.lottie.model.ms.xr xr() {
        return this.d;
    }

    public com.bytedance.adsdk.lottie.model.ms.zb<PointF, PointF> ah() {
        return this.ah;
    }

    public com.bytedance.adsdk.lottie.model.ms.zb<PointF, PointF> d() {
        return this.xr;
    }

    public boolean ka() {
        return this.ka;
    }

    @Override // com.bytedance.adsdk.lottie.model.xr.ah
    public com.bytedance.adsdk.lottie.ms.ms.ah ms(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.c cVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar) {
        return new com.bytedance.adsdk.lottie.ms.ms.ub(xVar, ahVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.xr + ", size=" + this.ah + AbstractJsonLexerKt.END_OBJ;
    }
}

package com.bytedance.adsdk.lottie.model.xr;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class h implements ah {
    private final com.bytedance.adsdk.lottie.model.ms.x ah;
    private final boolean d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f222ms;
    private final int xr;

    public h(String str, int i, com.bytedance.adsdk.lottie.model.ms.x xVar, boolean z) {
        this.f222ms = str;
        this.xr = i;
        this.ah = xVar;
        this.d = z;
    }

    public String ms() {
        return this.f222ms;
    }

    public com.bytedance.adsdk.lottie.model.ms.x xr() {
        return this.ah;
    }

    @Override // com.bytedance.adsdk.lottie.model.xr.ah
    public com.bytedance.adsdk.lottie.ms.ms.ah ms(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.c cVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar) {
        return new com.bytedance.adsdk.lottie.ms.ms.qv(xVar, ahVar, this);
    }

    public boolean ah() {
        return this.d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f222ms + ", index=" + this.xr + AbstractJsonLexerKt.END_OBJ;
    }
}

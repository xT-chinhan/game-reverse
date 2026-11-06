package com.bytedance.adsdk.lottie.model.xr;

import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class ao implements ah {
    private final boolean ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f217ms;
    private final List<ah> xr;

    public ao(String str, List<ah> list, boolean z) {
        this.f217ms = str;
        this.xr = list;
        this.ah = z;
    }

    public String ms() {
        return this.f217ms;
    }

    public List<ah> xr() {
        return this.xr;
    }

    public boolean ah() {
        return this.ah;
    }

    @Override // com.bytedance.adsdk.lottie.model.xr.ah
    public com.bytedance.adsdk.lottie.ms.ms.ah ms(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.c cVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar) {
        return new com.bytedance.adsdk.lottie.ms.ms.d(xVar, ahVar, this, cVar);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f217ms + "' Shapes: " + Arrays.toString(this.xr.toArray()) + AbstractJsonLexerKt.END_OBJ;
    }
}

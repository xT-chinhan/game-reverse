package com.bytedance.adsdk.lottie.model.xr;

import android.graphics.Path;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class ub implements ah {
    private final String ah;
    private final boolean c;
    private final com.bytedance.adsdk.lottie.model.ms.ms d;
    private final com.bytedance.adsdk.lottie.model.ms.d ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final boolean f234ms;
    private final Path.FillType xr;

    public ub(String str, boolean z, Path.FillType fillType, com.bytedance.adsdk.lottie.model.ms.ms msVar, com.bytedance.adsdk.lottie.model.ms.d dVar, boolean z2) {
        this.ah = str;
        this.f234ms = z;
        this.xr = fillType;
        this.d = msVar;
        this.ka = dVar;
        this.c = z2;
    }

    public String ms() {
        return this.ah;
    }

    public com.bytedance.adsdk.lottie.model.ms.ms xr() {
        return this.d;
    }

    public com.bytedance.adsdk.lottie.model.ms.d ah() {
        return this.ka;
    }

    public Path.FillType d() {
        return this.xr;
    }

    public boolean ka() {
        return this.c;
    }

    @Override // com.bytedance.adsdk.lottie.model.xr.ah
    public com.bytedance.adsdk.lottie.ms.ms.ah ms(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.c cVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar) {
        return new com.bytedance.adsdk.lottie.ms.ms.ab(xVar, ahVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f234ms + AbstractJsonLexerKt.END_OBJ;
    }
}

package com.bytedance.adsdk.lottie.model.xr;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class ny implements ah {
    private final boolean ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f226ms;
    private final ms xr;

    public enum ms {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static ms ms(int i) {
            if (i == 1) {
                return MERGE;
            }
            if (i == 2) {
                return ADD;
            }
            if (i == 3) {
                return SUBTRACT;
            }
            if (i == 4) {
                return INTERSECT;
            }
            if (i == 5) {
                return EXCLUDE_INTERSECTIONS;
            }
            return MERGE;
        }
    }

    public ny(String str, ms msVar, boolean z) {
        this.f226ms = str;
        this.xr = msVar;
        this.ah = z;
    }

    public String ms() {
        return this.f226ms;
    }

    public ms xr() {
        return this.xr;
    }

    public boolean ah() {
        return this.ah;
    }

    @Override // com.bytedance.adsdk.lottie.model.xr.ah
    public com.bytedance.adsdk.lottie.ms.ms.ah ms(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.c cVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar) {
        return new com.bytedance.adsdk.lottie.ms.ms.sl(this);
    }

    public String toString() {
        return "MergePaths{mode=" + this.xr + AbstractJsonLexerKt.END_OBJ;
    }
}

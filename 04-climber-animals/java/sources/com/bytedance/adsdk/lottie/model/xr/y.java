package com.bytedance.adsdk.lottie.model.xr;

import com.bytedance.adsdk.lottie.ms.ms.nw;

/* JADX INFO: loaded from: classes2.dex */
public class y implements ah {
    private final com.bytedance.adsdk.lottie.model.ms.xr ah;
    private final boolean c;
    private final com.bytedance.adsdk.lottie.model.ms.xr d;
    private final com.bytedance.adsdk.lottie.model.ms.xr ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f238ms;
    private final ms xr;

    public enum ms {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static ms ms(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type ".concat(String.valueOf(i)));
        }
    }

    public y(String str, ms msVar, com.bytedance.adsdk.lottie.model.ms.xr xrVar, com.bytedance.adsdk.lottie.model.ms.xr xrVar2, com.bytedance.adsdk.lottie.model.ms.xr xrVar3, boolean z) {
        this.f238ms = str;
        this.xr = msVar;
        this.ah = xrVar;
        this.d = xrVar2;
        this.ka = xrVar3;
        this.c = z;
    }

    public String ms() {
        return this.f238ms;
    }

    public ms getType() {
        return this.xr;
    }

    public com.bytedance.adsdk.lottie.model.ms.xr xr() {
        return this.d;
    }

    public com.bytedance.adsdk.lottie.model.ms.xr ah() {
        return this.ah;
    }

    public com.bytedance.adsdk.lottie.model.ms.xr d() {
        return this.ka;
    }

    public boolean ka() {
        return this.c;
    }

    @Override // com.bytedance.adsdk.lottie.model.xr.ah
    public com.bytedance.adsdk.lottie.ms.ms.ah ms(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.c cVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar) {
        return new nw(ahVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.ah + ", end: " + this.d + ", offset: " + this.ka + "}";
    }
}

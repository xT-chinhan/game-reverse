package com.bytedance.adsdk.lottie.model.xr;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
public class ch implements ah {
    private final com.bytedance.adsdk.lottie.model.ms.xr ab;
    private final com.bytedance.adsdk.lottie.model.ms.xr ah;
    private final com.bytedance.adsdk.lottie.model.ms.xr c;
    private final boolean ch;
    private final com.bytedance.adsdk.lottie.model.ms.zb<PointF, PointF> d;
    private final boolean hi;
    private final com.bytedance.adsdk.lottie.model.ms.xr ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f219ms;
    private final com.bytedance.adsdk.lottie.model.ms.xr ny;
    private final com.bytedance.adsdk.lottie.model.ms.xr x;
    private final ms xr;

    public enum ms {
        STAR(1),
        POLYGON(2);

        private final int ah;

        ms(int i) {
            this.ah = i;
        }

        public static ms ms(int i) {
            for (ms msVar : values()) {
                if (msVar.ah == i) {
                    return msVar;
                }
            }
            return null;
        }
    }

    public ch(String str, ms msVar, com.bytedance.adsdk.lottie.model.ms.xr xrVar, com.bytedance.adsdk.lottie.model.ms.zb<PointF, PointF> zbVar, com.bytedance.adsdk.lottie.model.ms.xr xrVar2, com.bytedance.adsdk.lottie.model.ms.xr xrVar3, com.bytedance.adsdk.lottie.model.ms.xr xrVar4, com.bytedance.adsdk.lottie.model.ms.xr xrVar5, com.bytedance.adsdk.lottie.model.ms.xr xrVar6, boolean z, boolean z2) {
        this.f219ms = str;
        this.xr = msVar;
        this.ah = xrVar;
        this.d = zbVar;
        this.ka = xrVar2;
        this.c = xrVar3;
        this.ab = xrVar4;
        this.x = xrVar5;
        this.ny = xrVar6;
        this.ch = z;
        this.hi = z2;
    }

    public String ms() {
        return this.f219ms;
    }

    public ms getType() {
        return this.xr;
    }

    public com.bytedance.adsdk.lottie.model.ms.xr xr() {
        return this.ah;
    }

    public com.bytedance.adsdk.lottie.model.ms.zb<PointF, PointF> ah() {
        return this.d;
    }

    public com.bytedance.adsdk.lottie.model.ms.xr d() {
        return this.ka;
    }

    public com.bytedance.adsdk.lottie.model.ms.xr ka() {
        return this.c;
    }

    public com.bytedance.adsdk.lottie.model.ms.xr c() {
        return this.ab;
    }

    public com.bytedance.adsdk.lottie.model.ms.xr ab() {
        return this.x;
    }

    public com.bytedance.adsdk.lottie.model.ms.xr x() {
        return this.ny;
    }

    public boolean ny() {
        return this.ch;
    }

    public boolean ch() {
        return this.hi;
    }

    @Override // com.bytedance.adsdk.lottie.model.xr.ah
    public com.bytedance.adsdk.lottie.ms.ms.ah ms(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.c cVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar) {
        return new com.bytedance.adsdk.lottie.ms.ms.u(xVar, ahVar, this);
    }
}

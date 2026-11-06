package com.bytedance.adsdk.lottie.model.ms;

import android.graphics.PointF;
import com.bytedance.adsdk.lottie.ms.xr.ao;

/* JADX INFO: loaded from: classes2.dex */
public class sl implements com.bytedance.adsdk.lottie.model.xr.ah {
    private final xr ab;
    private final ab ah;
    private final xr c;
    private final xr d;
    private final d ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ka f212ms;
    private final xr ny;
    private final xr x;
    private final zb<PointF, PointF> xr;

    @Override // com.bytedance.adsdk.lottie.model.xr.ah
    public com.bytedance.adsdk.lottie.ms.ms.ah ms(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.c cVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar) {
        return null;
    }

    public sl() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public sl(ka kaVar, zb<PointF, PointF> zbVar, ab abVar, xr xrVar, d dVar, xr xrVar2, xr xrVar3, xr xrVar4, xr xrVar5) {
        this.f212ms = kaVar;
        this.xr = zbVar;
        this.ah = abVar;
        this.d = xrVar;
        this.ka = dVar;
        this.x = xrVar2;
        this.ny = xrVar3;
        this.c = xrVar4;
        this.ab = xrVar5;
    }

    public ka ms() {
        return this.f212ms;
    }

    public zb<PointF, PointF> xr() {
        return this.xr;
    }

    public ab ah() {
        return this.ah;
    }

    public xr d() {
        return this.d;
    }

    public d ka() {
        return this.ka;
    }

    public xr c() {
        return this.x;
    }

    public xr ab() {
        return this.ny;
    }

    public xr x() {
        return this.c;
    }

    public xr ny() {
        return this.ab;
    }

    public ao ch() {
        return new ao(this);
    }
}

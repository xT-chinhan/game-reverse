package com.bytedance.adsdk.lottie.model;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private final PointF ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final PointF f208ms;
    private final PointF xr;

    public ms() {
        this.f208ms = new PointF();
        this.xr = new PointF();
        this.ah = new PointF();
    }

    public ms(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f208ms = pointF;
        this.xr = pointF2;
        this.ah = pointF3;
    }

    public void ms(float f, float f2) {
        this.f208ms.set(f, f2);
    }

    public PointF ms() {
        return this.f208ms;
    }

    public void xr(float f, float f2) {
        this.xr.set(f, f2);
    }

    public PointF xr() {
        return this.xr;
    }

    public void ah(float f, float f2) {
        this.ah.set(f, f2);
    }

    public PointF ah() {
        return this.ah;
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.ah.x), Float.valueOf(this.ah.y), Float.valueOf(this.f208ms.x), Float.valueOf(this.f208ms.y), Float.valueOf(this.xr.x), Float.valueOf(this.xr.y));
    }
}

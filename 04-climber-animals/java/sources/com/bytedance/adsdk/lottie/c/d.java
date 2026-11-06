package com.bytedance.adsdk.lottie.c;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private float f149ms;
    private float xr;

    public d(float f, float f2) {
        this.f149ms = f;
        this.xr = f2;
    }

    public d() {
        this(1.0f, 1.0f);
    }

    public float ms() {
        return this.f149ms;
    }

    public float xr() {
        return this.xr;
    }

    public void ms(float f, float f2) {
        this.f149ms = f;
        this.xr = f2;
    }

    public boolean xr(float f, float f2) {
        return this.f149ms == f && this.xr == f2;
    }

    public String toString() {
        return ms() + "x" + xr();
    }
}

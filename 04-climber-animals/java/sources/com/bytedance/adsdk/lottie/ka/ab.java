package com.bytedance.adsdk.lottie.ka;

/* JADX INFO: loaded from: classes2.dex */
public class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private float f168ms;
    private int xr;

    public void ms(float f) {
        float f2 = this.f168ms + f;
        this.f168ms = f2;
        int i = this.xr + 1;
        this.xr = i;
        if (i == Integer.MAX_VALUE) {
            this.f168ms = f2 / 2.0f;
            this.xr = i / 2;
        }
    }
}

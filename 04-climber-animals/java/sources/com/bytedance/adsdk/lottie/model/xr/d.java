package com.bytedance.adsdk.lottie.model.xr;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final float[] f221ms;
    private final int[] xr;

    public d(float[] fArr, int[] iArr) {
        this.f221ms = fArr;
        this.xr = iArr;
    }

    public float[] ms() {
        return this.f221ms;
    }

    public int[] xr() {
        return this.xr;
    }

    public int ah() {
        return this.xr.length;
    }

    public void ms(d dVar, d dVar2, float f) {
        if (dVar.xr.length != dVar2.xr.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + dVar.xr.length + " vs " + dVar2.xr.length + ")");
        }
        for (int i = 0; i < dVar.xr.length; i++) {
            this.f221ms[i] = com.bytedance.adsdk.lottie.ka.x.ms(dVar.f221ms[i], dVar2.f221ms[i], f);
            this.xr[i] = com.bytedance.adsdk.lottie.ka.ah.ms(f, dVar.xr[i], dVar2.xr[i]);
        }
    }

    public d ms(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            iArr[i] = ms(fArr[i]);
        }
        return new d(fArr, iArr);
    }

    private int ms(float f) {
        int iBinarySearch = Arrays.binarySearch(this.f221ms, f);
        if (iBinarySearch >= 0) {
            return this.xr[iBinarySearch];
        }
        int i = -(iBinarySearch + 1);
        if (i == 0) {
            return this.xr[0];
        }
        int[] iArr = this.xr;
        if (i == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.f221ms;
        int i2 = i - 1;
        float f2 = fArr[i2];
        return com.bytedance.adsdk.lottie.ka.ah.ms((f - f2) / (fArr[i] - f2), iArr[i2], iArr[i]);
    }
}

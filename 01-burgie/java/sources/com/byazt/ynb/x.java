package com.byazt.ynb;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 47, 121})
public class x {
    public final int[] hw;
    public final float[] pr;

    public x(float[] fArr, int[] iArr) {
        this.pr = fArr;
        this.hw = iArr;
    }

    public float[] pr() {
        return this.pr;
    }

    public int[] hw() {
        return this.hw;
    }

    public int hn() {
        return this.hw.length;
    }

    public void pr(x xVar, x xVar2, float f) {
        if (xVar.hw.length != xVar2.hw.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + xVar.hw.length + " vs " + xVar2.hw.length + ")");
        }
        for (int i = 0; i < xVar.hw.length; i++) {
            this.pr[i] = com.byazt.ptr.aj.pr(xVar.pr[i], xVar2.pr[i], f);
            this.hw[i] = com.byazt.ptr.x.pr(f, xVar.hw[i], xVar2.hw[i]);
        }
    }

    public x pr(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            iArr[i] = pr(fArr[i]);
        }
        return new x(fArr, iArr);
    }

    private int pr(float f) {
        int iBinarySearch = Arrays.binarySearch(this.pr, f);
        if (iBinarySearch >= 0) {
            return this.hw[iBinarySearch];
        }
        int i = -(iBinarySearch + 1);
        if (i == 0) {
            return this.hw[0];
        }
        int[] iArr = this.hw;
        if (i == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.pr;
        int i2 = i - 1;
        float f2 = fArr[i2];
        return com.byazt.ptr.x.pr((f - f2) / (fArr[i] - f2), iArr[i2], iArr[i]);
    }
}

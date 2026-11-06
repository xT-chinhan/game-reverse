package com.byazt.aw;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1026, 5})
public class q {
    public final float[] n;
    public final int[] qg;

    public q(float[] fArr, int[] iArr) {
        this.n = fArr;
        this.qg = iArr;
    }

    public float[] n() {
        return this.n;
    }

    public int[] qg() {
        return this.qg;
    }

    public int s() {
        return this.qg.length;
    }

    public void n(q qVar, q qVar2, float f) {
        if (qVar.qg.length != qVar2.qg.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + qVar.qg.length + " vs " + qVar2.qg.length + ")");
        }
        for (int i = 0; i < qVar.qg.length; i++) {
            this.n[i] = com.byazt.nu.rv.n(qVar.n[i], qVar2.n[i], f);
            this.qg[i] = com.byazt.nu.q.n(f, qVar.qg[i], qVar2.qg[i]);
        }
    }

    public q n(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            iArr[i] = n(fArr[i]);
        }
        return new q(fArr, iArr);
    }

    private int n(float f) {
        int iBinarySearch = Arrays.binarySearch(this.n, f);
        if (iBinarySearch >= 0) {
            return this.qg[iBinarySearch];
        }
        int i = -(iBinarySearch + 1);
        if (i == 0) {
            return this.qg[0];
        }
        int[] iArr = this.qg;
        if (i == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.n;
        int i2 = i - 1;
        float f2 = fArr[i2];
        return com.byazt.nu.q.n((f - f2) / (fArr[i] - f2), iArr[i2], iArr[i]);
    }
}

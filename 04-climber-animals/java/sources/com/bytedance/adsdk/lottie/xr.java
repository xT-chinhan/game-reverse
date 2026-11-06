package com.bytedance.adsdk.lottie;

/* JADX INFO: loaded from: classes2.dex */
class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final int[] f291ms = new int[0];
    static final long[] xr = new long[0];
    static final Object[] ah = new Object[0];

    static int ms(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else {
                if (i6 <= i2) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }
}

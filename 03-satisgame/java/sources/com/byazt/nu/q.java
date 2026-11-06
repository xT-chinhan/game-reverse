package com.byazt.nu;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1243, 5})
public class q {
    private static float n(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float qg(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int n(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float fQg = qg(((i >> 16) & 255) / 255.0f);
        float fQg2 = qg(((i >> 8) & 255) / 255.0f);
        float fQg3 = qg((i & 255) / 255.0f);
        float fQg4 = qg(((i2 >> 16) & 255) / 255.0f);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f);
        float fQg5 = fQg2 + ((qg(((i2 >> 8) & 255) / 255.0f) - fQg2) * f);
        float fQg6 = fQg3 + (f * (qg((i2 & 255) / 255.0f) - fQg3));
        return (Math.round(n(fQg + ((fQg4 - fQg) * f)) * 255.0f) << 16) | (Math.round(f3 * 255.0f) << 24) | (Math.round(n(fQg5) * 255.0f) << 8) | Math.round(n(fQg6) * 255.0f);
    }
}

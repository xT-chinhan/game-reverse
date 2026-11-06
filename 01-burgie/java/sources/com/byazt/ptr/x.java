package com.byazt.ptr;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 950, 121})
public class x {
    private static float pr(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float hw(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int pr(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float fHw = hw(((i >> 16) & 255) / 255.0f);
        float fHw2 = hw(((i >> 8) & 255) / 255.0f);
        float fHw3 = hw((i & 255) / 255.0f);
        float fHw4 = hw(((i2 >> 16) & 255) / 255.0f);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f);
        float fHw5 = fHw2 + ((hw(((i2 >> 8) & 255) / 255.0f) - fHw2) * f);
        float fHw6 = fHw3 + (f * (hw((i2 & 255) / 255.0f) - fHw3));
        return (Math.round(pr(fHw + ((fHw4 - fHw) * f)) * 255.0f) << 16) | (Math.round(f3 * 255.0f) << 24) | (Math.round(pr(fHw5) * 255.0f) << 8) | Math.round(pr(fHw6) * 255.0f);
    }
}

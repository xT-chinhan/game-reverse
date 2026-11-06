package com.bytedance.adsdk.lottie.ka;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    private static float ms(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float xr(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int ms(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float fXr = xr(((i >> 16) & 255) / 255.0f);
        float fXr2 = xr(((i >> 8) & 255) / 255.0f);
        float fXr3 = xr((i & 255) / 255.0f);
        float fXr4 = xr(((i2 >> 16) & 255) / 255.0f);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f);
        float fXr5 = fXr2 + ((xr(((i2 >> 8) & 255) / 255.0f) - fXr2) * f);
        float fXr6 = fXr3 + (f * (xr((i2 & 255) / 255.0f) - fXr3));
        return (Math.round(ms(fXr + ((fXr4 - fXr) * f)) * 255.0f) << 16) | (Math.round(f3 * 255.0f) << 24) | (Math.round(ms(fXr5) * 255.0f) << 8) | Math.round(ms(fXr6) * 255.0f);
    }
}

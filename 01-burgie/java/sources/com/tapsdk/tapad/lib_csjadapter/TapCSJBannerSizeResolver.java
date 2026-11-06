package com.tapsdk.tapad.lib_csjadapter;

/* JADX INFO: loaded from: classes3.dex */
final class TapCSJBannerSizeResolver {
    private static final int DEFAULT_ASPECT_HEIGHT = 1;
    private static final int DEFAULT_ASPECT_WIDTH = 2;
    private static final int DEFAULT_WIDTH_DP = 300;

    private TapCSJBannerSizeResolver() {
    }

    static Size resolve(int requestedWidthPx, int requestedHeightPx, float density, int screenWidthPx) {
        float safeDensity;
        if (density > 0.0f && !Float.isNaN(density) && !Float.isInfinite(density)) {
            safeDensity = density;
        } else {
            safeDensity = 1.0f;
        }
        int widthDp = toDp(requestedWidthPx, safeDensity);
        int heightDp = toDp(requestedHeightPx, safeDensity);
        if (widthDp <= 0 && heightDp <= 0) {
            widthDp = toDp(screenWidthPx, safeDensity);
            if (widthDp <= 0) {
                widthDp = 300;
            }
            heightDp = scale(widthDp, 1, 2);
        } else if (widthDp <= 0) {
            widthDp = scale(heightDp, 2, 1);
        } else if (heightDp <= 0) {
            heightDp = scale(widthDp, 1, 2);
        }
        return new Size(widthDp, heightDp, toPx(widthDp, safeDensity), toPx(heightDp, safeDensity));
    }

    private static int toDp(int px, float density) {
        if (px > 0) {
            return Math.max(1, Math.round(px / density));
        }
        return -1;
    }

    private static int toPx(int dp, float density) {
        return Math.max(1, Math.round(dp * density));
    }

    private static int scale(int value, int numerator, int denominator) {
        long result = Math.round((((double) value) * ((double) numerator)) / ((double) denominator));
        return (int) Math.max(1L, Math.min(2147483647L, result));
    }

    static final class Size {
        final int heightDp;
        final int heightPx;
        final int widthDp;
        final int widthPx;

        Size(int widthDp, int heightDp, int widthPx, int heightPx) {
            this.widthDp = widthDp;
            this.heightDp = heightDp;
            this.widthPx = widthPx;
            this.heightPx = heightPx;
        }
    }
}

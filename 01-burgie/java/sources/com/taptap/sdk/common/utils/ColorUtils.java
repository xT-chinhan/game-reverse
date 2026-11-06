package com.taptap.sdk.common.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ColorUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004¨\u0006\u000f"}, d2 = {"Lcom/taptap/sdk/common/utils/ColorUtils;", "", "()V", "getAlpha", "", "color", "getAlphaFloat", "", "getRgb", "parseColor", "hexColor", "", "alpha", "rgbToArgb", "rgbColor", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ColorUtils {
    public static final ColorUtils INSTANCE = new ColorUtils();

    private ColorUtils() {
    }

    public static /* synthetic */ int rgbToArgb$default(ColorUtils colorUtils, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 255;
        }
        return colorUtils.rgbToArgb(i, i2);
    }

    public final int rgbToArgb(int rgbColor, int alpha) {
        return (alpha << 24) | (16777215 & rgbColor);
    }

    public final int rgbToArgb(int rgbColor, float alpha) {
        int alphaInt = RangesKt.coerceIn((int) (255 * alpha), 0, 255);
        return rgbToArgb(rgbColor, alphaInt);
    }

    public static /* synthetic */ int parseColor$default(ColorUtils colorUtils, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 255;
        }
        return colorUtils.parseColor(str, i);
    }

    public final int parseColor(String hexColor, int alpha) {
        Intrinsics.checkNotNullParameter(hexColor, "hexColor");
        String cleanHex = StringsKt.removePrefix(hexColor, (CharSequence) "#");
        int rgbColor = Integer.parseInt(cleanHex, CharsKt.checkRadix(16));
        return rgbToArgb(rgbColor, alpha);
    }

    public final int parseColor(String hexColor, float alpha) {
        Intrinsics.checkNotNullParameter(hexColor, "hexColor");
        String cleanHex = StringsKt.removePrefix(hexColor, (CharSequence) "#");
        int rgbColor = Integer.parseInt(cleanHex, CharsKt.checkRadix(16));
        return rgbToArgb(rgbColor, alpha);
    }

    public final int getRgb(int color) {
        return 16777215 & color;
    }

    public final int getAlpha(int color) {
        return (color >> 24) & 255;
    }

    public final float getAlphaFloat(int color) {
        return getAlpha(color) / 255.0f;
    }
}

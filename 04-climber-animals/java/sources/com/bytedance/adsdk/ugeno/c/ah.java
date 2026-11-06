package com.bytedance.adsdk.ugeno.c;

import com.bytedance.sdk.component.utils.sl;

/* JADX INFO: loaded from: classes2.dex */
public final class ah {
    public static float ms(String str, float f) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            sl.ms(e);
            return f;
        }
    }

    public static int ms(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            sl.ms(e);
            return i;
        }
    }

    public static long ms(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            sl.ms(e);
            return j;
        }
    }

    public static double ms(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            sl.ms(e);
            return d;
        }
    }

    public static boolean ms(String str, boolean z) {
        try {
            return Boolean.parseBoolean(str);
        } catch (NumberFormatException e) {
            sl.ms(e);
            return z;
        }
    }
}

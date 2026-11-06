package com.byazt.hb;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 583, 8})
public final class s {
    public static float n(String str, float f) {
        if (str == null) {
            return f;
        }
        try {
            return Float.parseFloat(str);
        } catch (Throwable unused) {
            return f;
        }
    }

    public static int n(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return (int) Float.parseFloat(str);
        } catch (Throwable unused) {
            return i;
        }
    }

    public static long n(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return j;
        }
    }

    public static double n(String str, double d) {
        if (str == null) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (Throwable unused) {
            return d;
        }
    }

    public static boolean n(String str, boolean z) {
        if (str == null) {
            return z;
        }
        try {
            return Boolean.parseBoolean(str);
        } catch (Throwable unused) {
            return z;
        }
    }
}

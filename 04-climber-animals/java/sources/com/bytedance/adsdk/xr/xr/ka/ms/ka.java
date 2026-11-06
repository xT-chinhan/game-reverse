package com.bytedance.adsdk.xr.xr.ka.ms;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    private static Object ms(int i, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Integer.valueOf(i - number.intValue());
        }
        if (number instanceof Long) {
            return Long.valueOf(((long) i) - number.longValue());
        }
        if (number instanceof Float) {
            return Float.valueOf(i - number.floatValue());
        }
        if (number instanceof Double) {
            return Double.valueOf(((double) i) - number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object ms(long j, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Long.valueOf(j - ((long) number.intValue()));
        }
        if (number instanceof Long) {
            return Long.valueOf(j - number.longValue());
        }
        if (number instanceof Float) {
            return Float.valueOf(j - number.floatValue());
        }
        if (number instanceof Double) {
            return Double.valueOf(j - number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object ms(float f, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Float.valueOf(f - number.intValue());
        }
        if (number instanceof Long) {
            return Float.valueOf(f - number.longValue());
        }
        if (number instanceof Float) {
            return Float.valueOf(f - number.floatValue());
        }
        if (number instanceof Double) {
            return Double.valueOf(((double) f) - number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    private static Object ms(double d, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Double.valueOf(d - ((double) number.intValue()));
        }
        if (number instanceof Long) {
            return Double.valueOf(d - number.longValue());
        }
        if (number instanceof Float) {
            return Double.valueOf(d - ((double) number.floatValue()));
        }
        if (number instanceof Double) {
            return Double.valueOf(d - number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }

    public static Object ms(Number number, Number number2) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return ms(number.intValue(), number2);
        }
        if (number instanceof Long) {
            return ms(number.longValue(), number2);
        }
        if (number instanceof Float) {
            return ms(number.floatValue(), number2);
        }
        if (number instanceof Double) {
            return ms(number.doubleValue(), number2);
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "This type of addition operation is not supported");
    }
}

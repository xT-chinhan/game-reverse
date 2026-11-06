package com.smartdigimkt.z0;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.bykv.vk.component.ttvideo.player.C;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class u {
    public static final int a;
    public static final String b;
    public static final String c;
    public static final String d;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') {
            i = 26;
        }
        a = i;
        b = Build.DEVICE;
        c = Build.MANUFACTURER;
        d = Build.MODEL;
        Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        Pattern.compile("%([A-Fa-f0-9]{2})");
    }

    public static void a(Context context, Intent intent) {
        if (a >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public static boolean a(int i) {
        return i == 3 || i == 2 || i == Integer.MIN_VALUE || i == 1073741824 || i == 4;
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new Locale(str).getISO3Language();
        } catch (MissingResourceException unused) {
            return str.toLowerCase(Locale.US);
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static Object[] a(Object[] objArr, int i) {
        if (i <= objArr.length) {
            return Arrays.copyOf(objArr, i);
        }
        throw new IllegalArgumentException();
    }

    public static String a(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, Charset.forName("UTF-8"));
    }

    public static int a(long[] jArr, long j, boolean z, boolean z2) {
        int i;
        int i2;
        int iBinarySearch = Arrays.binarySearch(jArr, j);
        if (iBinarySearch < 0) {
            i2 = ~iBinarySearch;
        } else {
            while (true) {
                i = iBinarySearch + 1;
                if (i >= jArr.length || jArr[i] != j) {
                    break;
                }
                iBinarySearch = i;
            }
            i2 = z ? iBinarySearch : i;
        }
        return z2 ? Math.min(jArr.length - 1, i2) : i2;
    }

    public static long a(long j, long j2, long j3) {
        if (j3 >= j2 && j3 % j2 == 0) {
            return j / (j3 / j2);
        }
        if (j3 < j2 && j2 % j3 == 0) {
            return (j2 / j3) * j;
        }
        return (long) (j * (j2 / j3));
    }

    public static void a(long[] jArr, long j) {
        int i = 0;
        if (j >= C.MICROS_PER_SECOND && j % C.MICROS_PER_SECOND == 0) {
            long j2 = j / C.MICROS_PER_SECOND;
            while (i < jArr.length) {
                jArr[i] = jArr[i] / j2;
                i++;
            }
            return;
        }
        if (j < C.MICROS_PER_SECOND && C.MICROS_PER_SECOND % j == 0) {
            long j3 = C.MICROS_PER_SECOND / j;
            while (i < jArr.length) {
                jArr[i] = jArr[i] * j3;
                i++;
            }
            return;
        }
        double d2 = C.MICROS_PER_SECOND / j;
        while (i < jArr.length) {
            jArr[i] = (long) (jArr[i] * d2);
            i++;
        }
    }

    public static int a(String str) {
        int length = str.length();
        if (length > 4) {
            throw new IllegalArgumentException();
        }
        int iCharAt = 0;
        for (int i = 0; i < length; i++) {
            iCharAt = (iCharAt << 8) | str.charAt(i);
        }
        return iCharAt;
    }

    public static int a(int i, int i2) {
        if (i == Integer.MIN_VALUE) {
            return i2 * 3;
        }
        if (i != 1073741824) {
            if (i == 2) {
                return i2 * 2;
            }
            if (i == 3) {
                return i2;
            }
            if (i != 4) {
                throw new IllegalArgumentException();
            }
        }
        return i2 * 4;
    }
}

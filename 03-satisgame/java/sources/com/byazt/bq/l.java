package com.byazt.bq;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 290, 18})
public final class l {
    public static Method n;
    public static Method qg;
    public static Method s;

    static {
        try {
            n = Class.class.getDeclaredMethod("forName", String.class);
            qg = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            s = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (NoSuchMethodException | NullPointerException unused) {
        }
    }

    public static Object n(Object obj, String str, String str2, Object obj2) {
        try {
            Field fieldN = n(str, str2);
            if (fieldN == null) {
                return obj2;
            }
            fieldN.setAccessible(true);
            return fieldN.get(obj);
        } catch (IllegalAccessException unused) {
            return obj2;
        }
    }

    public static Field n(String str, String str2) {
        if (!n()) {
            return null;
        }
        try {
            Field field = (Field) s.invoke((Class) n.invoke(null, str), str2);
            try {
                field.setAccessible(true);
            } catch (Throwable unused) {
            }
            return field;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static boolean n() {
        return (n == null || qg == null || s == null) ? false : true;
    }
}

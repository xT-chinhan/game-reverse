package com.bytedance.sdk.openadsdk.core.jw;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    private static Method ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Method f2706ms;
    private static Method xr;

    static {
        try {
            f2706ms = Class.class.getDeclaredMethod("forName", String.class);
            xr = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            ah = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (NoSuchMethodException | NullPointerException unused) {
        }
    }

    public static Object ms(Object obj, String str, String str2, Object obj2) {
        try {
            Field fieldMs = ms(str, str2);
            if (fieldMs == null) {
                return obj2;
            }
            fieldMs.setAccessible(true);
            return fieldMs.get(obj);
        } catch (IllegalAccessException unused) {
            return obj2;
        }
    }

    public static Field ms(String str, String str2) {
        if (!ms()) {
            return null;
        }
        try {
            Field field = (Field) ah.invoke((Class) f2706ms.invoke(null, str), str2);
            try {
                field.setAccessible(true);
            } catch (Throwable unused) {
            }
            return field;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static boolean ms() {
        return (f2706ms == null || xr == null || ah == null) ? false : true;
    }
}

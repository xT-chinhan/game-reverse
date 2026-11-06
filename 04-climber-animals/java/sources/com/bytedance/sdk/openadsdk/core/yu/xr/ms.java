package com.bytedance.sdk.openadsdk.core.yu.xr;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Map<String, Field> f3811ms = new HashMap();

    private static String xr(Class<?> cls, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString()).append("#").append(str);
        return sb.toString();
    }

    public static Field ms(Class<?> cls, String str) {
        Field field;
        String strXr = xr(cls, str);
        synchronized (f3811ms) {
            field = f3811ms.get(strXr);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                synchronized (f3811ms) {
                    continue;
                    f3811ms.put(strXr, declaredField);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static Object ms(Field field, Object obj) throws IllegalAccessException {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static Object ms(Object obj, String str) throws IllegalAccessException {
        Field fieldMs = ms(obj.getClass(), str);
        if (fieldMs != null) {
            return ms(fieldMs, obj);
        }
        return null;
    }
}

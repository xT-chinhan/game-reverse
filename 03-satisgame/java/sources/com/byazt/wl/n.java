package com.byazt.wl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 888, 19})
public class n {
    public static Map<String, Field> n = new HashMap();

    private static String qg(Class<?> cls, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString()).append("#").append(str);
        return sb.toString();
    }

    public static Field n(Class<?> cls, String str) {
        Field field;
        String strQg = qg(cls, str);
        synchronized (n) {
            field = n.get(strQg);
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
                synchronized (n) {
                    continue;
                    n.put(strQg, declaredField);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static Object n(Field field, Object obj) throws IllegalAccessException {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static Object n(Object obj, String str) throws IllegalAccessException {
        Field fieldN = n(obj.getClass(), str);
        if (fieldN != null) {
            return n(fieldN, obj);
        }
        return null;
    }
}

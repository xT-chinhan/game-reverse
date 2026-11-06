package com.bytedance.sdk.component.hi.c;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends xr {
    private ms() {
    }

    public static ms ms() {
        if (f1238ms != null) {
            return f1238ms;
        }
        synchronized (ms.class) {
            if (f1238ms != null) {
                return f1238ms;
            }
            ms msVar = new ms();
            f1238ms = msVar;
            return msVar;
        }
    }

    public com.bytedance.sdk.component.hi.ms.ms.ms ms(com.bytedance.sdk.component.hi.ms.ms.ms msVar) {
        try {
            Class<?> cls = msVar.getClass();
            return (cls.isAnnotationPresent(com.bytedance.sdk.component.hi.xr.xr.class) && !"SINGLETON".equals(((com.bytedance.sdk.component.hi.xr.xr) cls.getAnnotation(com.bytedance.sdk.component.hi.xr.xr.class)).ms())) ? (com.bytedance.sdk.component.hi.ms.ms.ms) cls.newInstance() : msVar;
        } catch (Throwable unused) {
            return msVar;
        }
    }

    public void ms(Object obj, Map<String, Object> map) {
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isAnnotationPresent(com.bytedance.sdk.component.hi.xr.xr.class)) {
            ms(obj, map, cls);
        }
    }

    private static void ms(Object obj, Map<String, Object> map, Class<?> cls) {
        com.bytedance.sdk.component.hi.xr.ms msVar;
        for (Field field : ms(cls)) {
            if (field != null && field.isAnnotationPresent(com.bytedance.sdk.component.hi.xr.ms.class) && (msVar = (com.bytedance.sdk.component.hi.xr.ms) field.getAnnotation(com.bytedance.sdk.component.hi.xr.ms.class)) != null) {
                field.setAccessible(true);
                String strMs = msVar.ms();
                if (TextUtils.isEmpty(strMs)) {
                    strMs = com.bytedance.sdk.component.hi.x.ms.ms(field.getName(), true);
                }
                if (!TextUtils.isEmpty(strMs)) {
                    com.bytedance.sdk.component.hi.ka.ms.xr.ms(obj, map, field, strMs);
                }
            }
        }
    }

    public static Field[] ms(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null && cls != Object.class) {
            arrayList.addAll(new ArrayList(Arrays.asList(cls.getDeclaredFields())));
            cls = cls.getSuperclass();
        }
        return (Field[]) arrayList.toArray(new Field[arrayList.size()]);
    }
}

package com.bytedance.sdk.component.hi.ka.ms;

import com.bytedance.sdk.component.hi.ka.ms.ms.ab;
import com.bytedance.sdk.component.hi.ka.ms.ms.ah;
import com.bytedance.sdk.component.hi.ka.ms.ms.c;
import com.bytedance.sdk.component.hi.ka.ms.ms.d;
import com.bytedance.sdk.component.hi.ka.ms.ms.ka;
import com.bytedance.sdk.component.hi.ka.ms.ms.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Map<Class, ms> f1240ms;

    static {
        HashMap map = new HashMap();
        f1240ms = map;
        c cVar = new c();
        x xVar = new x();
        ab abVar = new ab();
        com.bytedance.sdk.component.hi.ka.ms.ms.xr xrVar = new com.bytedance.sdk.component.hi.ka.ms.ms.xr();
        d dVar = new d();
        ka kaVar = new ka();
        com.bytedance.sdk.component.hi.ka.ms.ms.ms msVar = new com.bytedance.sdk.component.hi.ka.ms.ms.ms();
        ah ahVar = new ah();
        map.put(Integer.class, cVar);
        map.put(Integer.TYPE, cVar);
        map.put(Short.class, xVar);
        map.put(Short.TYPE, xVar);
        map.put(Long.class, abVar);
        map.put(Long.TYPE, abVar);
        map.put(Byte.class, xrVar);
        map.put(Byte.TYPE, xrVar);
        map.put(Double.class, dVar);
        map.put(Double.TYPE, dVar);
        map.put(Float.class, kaVar);
        map.put(Float.TYPE, kaVar);
        map.put(Boolean.class, msVar);
        map.put(Boolean.TYPE, msVar);
        map.put(Character.class, ahVar);
        map.put(Character.TYPE, ahVar);
    }

    public static void ms(Object obj, Field field, Object obj2) {
        Object objMs;
        if (field == null || obj2 == null) {
            return;
        }
        Class<?> type = field.getType();
        try {
            objMs = type.getConstructor(new Class[0]).newInstance(obj2);
        } catch (Throwable unused) {
            objMs = ms(type, obj2);
        }
        try {
            field.setAccessible(true);
            field.set(obj, objMs);
        } catch (Throwable unused2) {
        }
    }

    public static void ms(Object obj, Map<String, Object> map, Field field, String str) {
        Object obj2;
        if (field == null || (obj2 = map.get(str)) == null) {
            return;
        }
        field.setAccessible(true);
        try {
            field.set(obj, obj2);
        } catch (Throwable unused) {
            ms(obj, field, obj2);
        }
    }

    public static Object ms(Class cls, Object obj) {
        String strValueOf = String.valueOf(obj);
        if (String.class.equals(cls)) {
            return strValueOf;
        }
        ms msVar = f1240ms.get(cls);
        return msVar == null ? obj : msVar.ms(cls, strValueOf);
    }
}

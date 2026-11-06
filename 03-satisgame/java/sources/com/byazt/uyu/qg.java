package com.byazt.uyu;

import com.byazt.nz.fs;
import com.byazt.nz.l;
import com.byazt.nz.q;
import com.byazt.nz.s;
import com.byazt.nz.w;
import com.byazt.nz.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 785, 26})
public class qg {
    public static final Map<Class, n> n;

    static {
        HashMap map = new HashMap();
        n = map;
        w wVar = new w();
        fs fsVar = new fs();
        x xVar = new x();
        com.byazt.nz.qg qgVar = new com.byazt.nz.qg();
        q qVar = new q();
        l lVar = new l();
        com.byazt.nz.n nVar = new com.byazt.nz.n();
        s sVar = new s();
        map.put(Integer.class, wVar);
        map.put(Integer.TYPE, wVar);
        map.put(Short.class, fsVar);
        map.put(Short.TYPE, fsVar);
        map.put(Long.class, xVar);
        map.put(Long.TYPE, xVar);
        map.put(Byte.class, qgVar);
        map.put(Byte.TYPE, qgVar);
        map.put(Double.class, qVar);
        map.put(Double.TYPE, qVar);
        map.put(Float.class, lVar);
        map.put(Float.TYPE, lVar);
        map.put(Boolean.class, nVar);
        map.put(Boolean.TYPE, nVar);
        map.put(Character.class, sVar);
        map.put(Character.TYPE, sVar);
    }

    public static void n(Object obj, Field field, Object obj2) {
        Object objN;
        if (field == null || obj2 == null) {
            return;
        }
        Class<?> type = field.getType();
        try {
            objN = type.getConstructor(new Class[0]).newInstance(obj2);
        } catch (Throwable unused) {
            objN = n(type, obj2);
        }
        try {
            field.setAccessible(true);
            field.set(obj, objN);
        } catch (Throwable unused2) {
        }
    }

    public static void n(Object obj, Map<String, Object> map, Field field, String str) {
        Object obj2;
        if (field == null || (obj2 = map.get(str)) == null) {
            return;
        }
        field.setAccessible(true);
        try {
            field.set(obj, obj2);
        } catch (Throwable unused) {
            n(obj, field, obj2);
        }
    }

    public static Object n(Class cls, Object obj) {
        String strValueOf = String.valueOf(obj);
        if (String.class.equals(cls)) {
            return strValueOf;
        }
        n nVar = n.get(cls);
        return nVar == null ? obj : nVar.n(cls, strValueOf);
    }
}

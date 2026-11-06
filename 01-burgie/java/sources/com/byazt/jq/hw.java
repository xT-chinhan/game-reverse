package com.byazt.jq;

import com.byazt.ia.c;
import com.byazt.ia.fw;
import com.byazt.ia.hn;
import com.byazt.ia.uc;
import com.byazt.ia.x;
import com.byazt.ia.zo;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1264, 13})
public class hw {
    public static final Map<Class, pr> pr;

    static {
        HashMap map = new HashMap();
        pr = map;
        uc ucVar = new uc();
        zo zoVar = new zo();
        fw fwVar = new fw();
        com.byazt.ia.hw hwVar = new com.byazt.ia.hw();
        x xVar = new x();
        c cVar = new c();
        com.byazt.ia.pr prVar = new com.byazt.ia.pr();
        hn hnVar = new hn();
        map.put(Integer.class, ucVar);
        map.put(Integer.TYPE, ucVar);
        map.put(Short.class, zoVar);
        map.put(Short.TYPE, zoVar);
        map.put(Long.class, fwVar);
        map.put(Long.TYPE, fwVar);
        map.put(Byte.class, hwVar);
        map.put(Byte.TYPE, hwVar);
        map.put(Double.class, xVar);
        map.put(Double.TYPE, xVar);
        map.put(Float.class, cVar);
        map.put(Float.TYPE, cVar);
        map.put(Boolean.class, prVar);
        map.put(Boolean.TYPE, prVar);
        map.put(Character.class, hnVar);
        map.put(Character.TYPE, hnVar);
    }

    public static void pr(Object obj, Field field, Object obj2) {
        Object objPr;
        if (field == null || obj2 == null) {
            return;
        }
        Class<?> type = field.getType();
        try {
            objPr = type.getConstructor(new Class[0]).newInstance(obj2);
        } catch (Throwable th) {
            objPr = pr(type, obj2);
        }
        try {
            field.setAccessible(true);
            field.set(obj, objPr);
        } catch (Throwable th2) {
        }
    }

    public static void pr(Object obj, Map<String, Object> map, Field field, String str) {
        Object obj2;
        if (field == null || (obj2 = map.get(str)) == null) {
            return;
        }
        field.setAccessible(true);
        try {
            field.set(obj, obj2);
        } catch (Throwable th) {
            pr(obj, field, obj2);
        }
    }

    public static Object pr(Class cls, Object obj) {
        String strValueOf = String.valueOf(obj);
        if (String.class.equals(cls)) {
            return strValueOf;
        }
        pr prVar = pr.get(cls);
        if (prVar == null) {
            return obj;
        }
        return prVar.pr(cls, strValueOf);
    }
}

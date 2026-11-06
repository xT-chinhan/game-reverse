package com.byazt.fu;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2093, 19})
public class n extends qg {
    public static final String[] qg;
    public static final String[] s;
    public static final String[] q = {"CONTEXT", "DATA_SOURCE", "DSL"};
    public static final String[] l = {"DATA_SOURCE", "DSL", "CONTEXT"};

    static {
        String[] strArr = {"DSL", "CONTEXT", "DATA_SOURCE"};
        qg = strArr;
        s = strArr;
    }

    private n() {
    }

    public static n n() {
        if (n != null) {
            return n;
        }
        synchronized (n.class) {
            if (n != null) {
                return n;
            }
            n nVar = new n();
            n = nVar;
            return nVar;
        }
    }

    public com.byazt.jjq.n n(com.byazt.jjq.n nVar) {
        try {
            Class<?> cls = nVar.getClass();
            if (cls.isAnnotationPresent(com.byazt.phr.qg.class)) {
                return "SINGLETON".equals(((com.byazt.phr.qg) cls.getAnnotation(com.byazt.phr.qg.class)).n()) ? nVar : (com.byazt.jjq.n) cls.newInstance();
            }
            return (com.byazt.jjq.n) cls.newInstance();
        } catch (Throwable unused) {
            return nVar;
        }
    }

    public void n(Object obj, Map<String, Object> map) {
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isAnnotationPresent(com.byazt.phr.qg.class)) {
            n(obj, map, cls);
        }
    }

    public void n(Object obj, Map<String, Object> map, JSONObject jSONObject, Map<String, Object> map2) {
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isAnnotationPresent(com.byazt.phr.qg.class)) {
            n(obj, map, jSONObject, map2, cls);
        }
    }

    private static void n(Object obj, Map<String, Object> map, Class<?> cls) {
        com.byazt.phr.n nVar;
        for (Field field : n(cls)) {
            if (field != null && field.isAnnotationPresent(com.byazt.phr.n.class) && (nVar = (com.byazt.phr.n) field.getAnnotation(com.byazt.phr.n.class)) != null) {
                field.setAccessible(true);
                String strN = nVar.n();
                if (TextUtils.isEmpty(strN)) {
                    strN = com.byazt.vip.n.n(field.getName(), true);
                }
                if (!TextUtils.isEmpty(strN)) {
                    com.byazt.uyu.qg.n(obj, map, field, strN);
                }
            }
        }
    }

    private static void n(Object obj, Map<String, Object> map, JSONObject jSONObject, Map<String, Object> map2, Class<?> cls) {
        com.byazt.phr.n nVar;
        for (Field field : n(cls)) {
            if (field != null && field.isAnnotationPresent(com.byazt.phr.n.class) && (nVar = (com.byazt.phr.n) field.getAnnotation(com.byazt.phr.n.class)) != null) {
                field.setAccessible(true);
                String strN = nVar.n();
                if (TextUtils.isEmpty(strN)) {
                    strN = com.byazt.vip.n.n(field.getName(), true);
                }
                if (!TextUtils.isEmpty(strN)) {
                    Object objN = null;
                    for (String str : n(nVar.qg())) {
                        objN = n(strN, str, map, jSONObject, map2);
                        if (objN == JSONObject.NULL) {
                            objN = null;
                        }
                        if (objN != null) {
                            break;
                        }
                    }
                    if (objN != null) {
                        com.byazt.uyu.qg.n(obj, field, objN);
                    }
                }
            }
        }
    }

    private static String[] n(String str) {
        if ("DSL".equals(str)) {
            return s;
        }
        if ("CONTEXT".equals(str)) {
            return q;
        }
        if ("DATA_SOURCE".equals(str)) {
            return l;
        }
        return qg;
    }

    private static Object n(String str, String str2, Map<String, Object> map, JSONObject jSONObject, Map<String, Object> map2) {
        if ("DSL".equals(str2)) {
            if (map == null || !map.containsKey(str)) {
                return null;
            }
            return map.get(str);
        }
        if ("CONTEXT".equals(str2)) {
            if (map2 == null || !map2.containsKey(str)) {
                return null;
            }
            return map2.get(str);
        }
        if ("DATA_SOURCE".equals(str2)) {
            return com.byazt.vip.qg.n(jSONObject, str);
        }
        return null;
    }

    public static Field[] n(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null && cls != Object.class) {
            arrayList.addAll(new ArrayList(Arrays.asList(cls.getDeclaredFields())));
            cls = cls.getSuperclass();
        }
        return (Field[]) arrayList.toArray(new Field[arrayList.size()]);
    }
}

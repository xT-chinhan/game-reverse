package com.byazt.bxj;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1608, 37})
public class pr extends hw {
    public static final String[] hn;
    public static final String[] hw;
    public static final String[] x = {"CONTEXT", "DATA_SOURCE", "DSL"};
    public static final String[] c = {"DATA_SOURCE", "DSL", "CONTEXT"};

    static {
        String[] strArr = {"DSL", "CONTEXT", "DATA_SOURCE"};
        hw = strArr;
        hn = strArr;
    }

    private pr() {
    }

    public static pr pr() {
        if (pr != null) {
            return pr;
        }
        synchronized (pr.class) {
            if (pr != null) {
                return pr;
            }
            pr prVar = new pr();
            pr = prVar;
            return prVar;
        }
    }

    public com.byazt.lf.pr pr(com.byazt.lf.pr prVar) {
        try {
            Class<?> cls = prVar.getClass();
            if (!cls.isAnnotationPresent(com.byazt.qa.hw.class)) {
                return (com.byazt.lf.pr) cls.newInstance();
            }
            if ("SINGLETON".equals(((com.byazt.qa.hw) cls.getAnnotation(com.byazt.qa.hw.class)).pr())) {
                return prVar;
            }
            return (com.byazt.lf.pr) cls.newInstance();
        } catch (Throwable th) {
            return prVar;
        }
    }

    public void pr(Object obj, Map<String, Object> map) {
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (!cls.isAnnotationPresent(com.byazt.qa.hw.class)) {
            return;
        }
        pr(obj, map, cls);
    }

    public void pr(Object obj, Map<String, Object> map, JSONObject jSONObject, Map<String, Object> map2) {
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (!cls.isAnnotationPresent(com.byazt.qa.hw.class)) {
            return;
        }
        pr(obj, map, jSONObject, map2, cls);
    }

    private static void pr(Object obj, Map<String, Object> map, Class<?> cls) {
        com.byazt.qa.pr prVar;
        for (Field field : pr(cls)) {
            if (field != null && field.isAnnotationPresent(com.byazt.qa.pr.class) && (prVar = (com.byazt.qa.pr) field.getAnnotation(com.byazt.qa.pr.class)) != null) {
                field.setAccessible(true);
                String strPr = prVar.pr();
                if (TextUtils.isEmpty(strPr)) {
                    strPr = com.byazt.tl.pr.pr(field.getName(), true);
                }
                if (!TextUtils.isEmpty(strPr)) {
                    com.byazt.jq.hw.pr(obj, map, field, strPr);
                }
            }
        }
    }

    private static void pr(Object obj, Map<String, Object> map, JSONObject jSONObject, Map<String, Object> map2, Class<?> cls) {
        com.byazt.qa.pr prVar;
        for (Field field : pr(cls)) {
            if (field != null && field.isAnnotationPresent(com.byazt.qa.pr.class) && (prVar = (com.byazt.qa.pr) field.getAnnotation(com.byazt.qa.pr.class)) != null) {
                field.setAccessible(true);
                String strPr = prVar.pr();
                if (TextUtils.isEmpty(strPr)) {
                    strPr = com.byazt.tl.pr.pr(field.getName(), true);
                }
                if (!TextUtils.isEmpty(strPr)) {
                    Object objPr = null;
                    for (String str : pr(prVar.hw())) {
                        objPr = pr(strPr, str, map, jSONObject, map2);
                        if (objPr == JSONObject.NULL) {
                            objPr = null;
                        }
                        if (objPr != null) {
                            break;
                        }
                    }
                    if (objPr != null) {
                        com.byazt.jq.hw.pr(obj, field, objPr);
                    }
                }
            }
        }
    }

    private static String[] pr(String str) {
        if ("DSL".equals(str)) {
            return hn;
        }
        if ("CONTEXT".equals(str)) {
            return x;
        }
        if ("DATA_SOURCE".equals(str)) {
            return c;
        }
        return hw;
    }

    private static Object pr(String str, String str2, Map<String, Object> map, JSONObject jSONObject, Map<String, Object> map2) {
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
            return com.byazt.tl.hw.pr(jSONObject, str);
        }
        return null;
    }

    public static Field[] pr(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null && cls != Object.class) {
            arrayList.addAll(new ArrayList(Arrays.asList(cls.getDeclaredFields())));
            cls = cls.getSuperclass();
        }
        return (Field[]) arrayList.toArray(new Field[arrayList.size()]);
    }
}

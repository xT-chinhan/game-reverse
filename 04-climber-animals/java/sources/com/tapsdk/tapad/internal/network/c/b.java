package com.tapsdk.tapad.internal.network.c;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static <T> T a(String str, c<T> cVar) throws JSONException {
        try {
            return (T) b(str, cVar);
        } catch (Exception e) {
            if (e instanceof JSONException) {
                throw ((JSONException) e);
            }
            throw ((JSONException) new JSONException(str).initCause(e));
        }
    }

    public static <T> T a(String str, Class<T> cls) throws JSONException {
        try {
            return (T) c(str, cls);
        } catch (Exception e) {
            if (e instanceof JSONException) {
                throw ((JSONException) e);
            }
            throw ((JSONException) new JSONException(str).initCause(e));
        }
    }

    public static <T> T a(JSONObject jSONObject, Class<T> cls) throws JSONException {
        try {
            return (T) b(jSONObject, cls);
        } catch (Exception e) {
            if (e instanceof JSONException) {
                throw ((JSONException) e);
            }
            throw ((JSONException) new JSONException(jSONObject.toString()).initCause(e));
        }
    }

    private static String a(String str) {
        String strTrim = str.trim();
        return strTrim.substring(1, strTrim.length() - 1);
    }

    public static List<Object> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object objA = jSONArray.get(i);
            if (objA instanceof JSONArray) {
                objA = a((JSONArray) objA);
            } else if (objA instanceof JSONObject) {
                objA = a((JSONObject) objA);
            }
            arrayList.add(objA);
        }
        return arrayList;
    }

    public static Map<String, Object> a(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objA = jSONObject.get(next);
            if (objA instanceof JSONArray) {
                objA = a((JSONArray) objA);
            } else if (objA instanceof JSONObject) {
                objA = a((JSONObject) objA);
            }
            map.put(next, objA);
        }
        return map;
    }

    private static <T> T b(String str, c<T> cVar) throws JSONException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Class cls = (Class) cVar.a.getRawType();
        Type[] actualTypeArguments = cVar.a.getActualTypeArguments();
        int length = actualTypeArguments.length + 1;
        Class<?>[] clsArr = new Class[length];
        clsArr[0] = JSONObject.class;
        for (int i = 1; i < length; i++) {
            clsArr[i] = Class.class;
        }
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(clsArr);
        declaredConstructor.setAccessible(true);
        Object[] objArr = new Object[length];
        objArr[0] = new JSONObject(str);
        for (int i2 = 1; i2 < length; i2++) {
            objArr[i2] = actualTypeArguments[i2 - 1];
        }
        return declaredConstructor.newInstance(objArr);
    }

    private static <T> T b(String str, Class<T> cls) throws JSONException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Class<?> componentType = cls.getComponentType();
        JSONArray jSONArray = new JSONArray(str);
        int length = jSONArray.length();
        T t = (T) Array.newInstance(componentType, length);
        int i = 0;
        if (!componentType.isPrimitive()) {
            Constructor<?> declaredConstructor = componentType.getDeclaredConstructor(JSONObject.class);
            declaredConstructor.setAccessible(true);
            for (int i2 = 0; i2 < length; i2++) {
                Array.set(t, i2, declaredConstructor.newInstance(jSONArray.getJSONObject(i2)));
            }
        } else if (componentType == Boolean.TYPE) {
            while (i < length) {
                Array.setBoolean(t, i, jSONArray.getBoolean(i));
                i++;
            }
        } else if (componentType == Integer.TYPE) {
            while (i < length) {
                Array.setInt(t, i, jSONArray.getInt(i));
                i++;
            }
        } else if (componentType == Long.TYPE) {
            while (i < length) {
                Array.setLong(t, i, jSONArray.getLong(i));
                i++;
            }
        } else if (componentType == Float.TYPE) {
            while (i < length) {
                Array.setFloat(t, i, (float) jSONArray.getDouble(i));
                i++;
            }
        } else {
            if (componentType != Double.TYPE) {
                throw new UnsupportedOperationException(str + " - " + componentType.toString());
            }
            while (i < length) {
                Array.setDouble(t, i, jSONArray.getDouble(i));
                i++;
            }
        }
        return t;
    }

    private static <T> T b(JSONObject jSONObject, Class<T> cls) throws JSONException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(JSONObject.class);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(jSONObject);
    }

    private static <T> T c(String str, Class<T> cls) throws IllegalAccessException, JSONException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        if (cls.isArray()) {
            return (T) b(str, cls);
        }
        if (cls.isPrimitive()) {
            return (T) e(str, cls);
        }
        return cls == String.class ? (T) a(str) : (T) d(str, cls);
    }

    private static <T> T d(String str, Class<T> cls) throws JSONException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        return (T) b(new JSONObject(str), cls);
    }

    private static <T> T e(String str, Class<T> cls) {
        if (cls == Boolean.TYPE) {
            return (T) Boolean.valueOf(str);
        }
        if (cls == Integer.TYPE) {
            return (T) Integer.valueOf(str);
        }
        if (cls == Long.TYPE) {
            return (T) Long.valueOf(str);
        }
        if (cls == Float.TYPE) {
            return (T) Float.valueOf(str);
        }
        if (cls == Double.TYPE) {
            return (T) Double.valueOf(str);
        }
        throw new UnsupportedOperationException(str + " - " + cls.toString());
    }
}

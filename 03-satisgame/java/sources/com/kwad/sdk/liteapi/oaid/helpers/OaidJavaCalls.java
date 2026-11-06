package com.kwad.sdk.liteapi.oaid.helpers;

import android.text.TextUtils;
import com.kwad.sdk.liteapi.LiteApiLogger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class OaidJavaCalls {
    private static final Map<Class<?>, Class<?>> PRIMITIVE_MAP;
    public static final String TAG = "JavaCalls_";
    private static Method sForNameMethod;
    private static Method sGetDeclaredMethod;
    private static Method sGetFieldMethod;
    private static Map<String, Method> sMethodCache;
    private static final HashMap<Class<?>, Class<?>> sPrimitiveToWrapperMap;

    static {
        HashMap map = new HashMap();
        PRIMITIVE_MAP = map;
        sMethodCache = new HashMap();
        HashMap<Class<?>, Class<?>> map2 = new HashMap<>();
        sPrimitiveToWrapperMap = map2;
        map.put(Boolean.class, Boolean.TYPE);
        map.put(Byte.class, Byte.TYPE);
        map.put(Character.class, Character.TYPE);
        map.put(Short.class, Short.TYPE);
        map.put(Integer.class, Integer.TYPE);
        map.put(Float.class, Float.TYPE);
        map.put(Long.class, Long.TYPE);
        map.put(Double.class, Double.TYPE);
        map.put(Boolean.TYPE, Boolean.TYPE);
        map.put(Byte.TYPE, Byte.TYPE);
        map.put(Character.TYPE, Character.TYPE);
        map.put(Short.TYPE, Short.TYPE);
        map.put(Integer.TYPE, Integer.TYPE);
        map.put(Float.TYPE, Float.TYPE);
        map.put(Long.TYPE, Long.TYPE);
        map.put(Double.TYPE, Double.TYPE);
        map2.put(Boolean.TYPE, Boolean.class);
        map2.put(Byte.TYPE, Byte.class);
        map2.put(Character.TYPE, Character.class);
        map2.put(Short.TYPE, Short.class);
        map2.put(Integer.TYPE, Integer.class);
        map2.put(Long.TYPE, Long.class);
        map2.put(Double.TYPE, Double.class);
        map2.put(Float.TYPE, Float.class);
        map2.put(Void.TYPE, Void.class);
        try {
            sForNameMethod = Class.class.getDeclaredMethod("forName", String.class);
            sGetDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            sGetFieldMethod = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static class JavaParam<T> {
        public final Class<? extends T> clazz;
        public final T obj;

        public JavaParam(Class<? extends T> cls, T t) {
            this.clazz = cls;
            this.obj = t;
        }
    }

    @Deprecated
    public static <T> T callMethod(Object obj, String str, Object... objArr) {
        try {
            return (T) callMethodOrThrow(obj, str, objArr);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    public static <T> T callMethodOrThrow(Object obj, String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        return (T) getAccessibleMethod(obj.getClass(), str, getParameterTypes(objArr)).invoke(obj, getParameters(objArr));
    }

    @Deprecated
    public static <T> T callStaticMethod(Class<?> cls, String str, Object... objArr) {
        try {
            return (T) callStaticMethodOrThrow(cls, str, objArr);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    public static <T> T callStaticMethodOrThrow(Class<?> cls, String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        return (T) getAccessibleMethod(cls, str, getParameterTypes(objArr)).invoke(null, getParameters(objArr));
    }

    public static <T> T newInstanceOrThrow(Class<?> cls, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        return (T) cls.getConstructor(getParameterTypes(objArr)).newInstance(getParameters(objArr));
    }

    public static <T> T newInstance(String str, Object... objArr) {
        try {
            return (T) newInstanceOrThrow(str, objArr);
        } catch (Throwable th) {
            wrapToRuntime(th);
            return null;
        }
    }

    public static <T> T newInstanceOrThrow(String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        return (T) newInstanceOrThrow(Class.forName(str), getParameters(objArr));
    }

    @Deprecated
    private static Class<?>[] getParameterTypes(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj != null && (obj instanceof JavaParam)) {
                clsArr[i] = ((JavaParam) obj).clazz;
            } else {
                clsArr[i] = obj == null ? null : obj.getClass();
            }
        }
        return clsArr;
    }

    private static Object[] getParameters(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj != null && (obj instanceof JavaParam)) {
                objArr2[i] = ((JavaParam) obj).obj;
            } else {
                objArr2[i] = obj;
            }
        }
        return objArr2;
    }

    private static void wrapToRuntime(Throwable th) {
        LiteApiLogger.printStackTrace(th);
    }

    private static String getKey(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString()).append("#").append(str).append("#").append(cls.getClassLoader() != null ? Integer.valueOf(cls.getClassLoader().hashCode()) : "");
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.toString()).append("#");
            }
        } else {
            sb.append(Void.class.toString());
        }
        return sb.toString();
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method declaredMethod;
        String key = getKey(cls, str, clsArr);
        synchronized (sMethodCache) {
            declaredMethod = sMethodCache.get(key);
        }
        if (declaredMethod != null) {
            if (!declaredMethod.isAccessible()) {
                declaredMethod.setAccessible(true);
            }
            LiteApiLogger.d(TAG, "in new get method from cache: key：" + key + " method:" + declaredMethod.getName());
            return declaredMethod;
        }
        while (cls != null) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (declaredMethod == null) {
                try {
                    for (Method method : cls.getDeclaredMethods()) {
                        if (method != null && TextUtils.equals(method.getName(), str)) {
                            Class<?>[] parameterTypes = method.getParameterTypes();
                            if (clsArr != null && parameterTypes != null && clsArr.length == parameterTypes.length) {
                                boolean z = true;
                                for (int i = 0; i < clsArr.length; i++) {
                                    if (!isAssignableFrom(clsArr[i], parameterTypes[i])) {
                                        z = false;
                                    }
                                }
                                if (z) {
                                    declaredMethod = method;
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                synchronized (sMethodCache) {
                    sMethodCache.put(key, declaredMethod);
                    LiteApiLogger.d(TAG, "in new get method:" + declaredMethod.getName());
                }
                return declaredMethod;
            }
            cls = cls.getSuperclass();
        }
        throw new NoSuchMethodException();
    }

    public static boolean isAssignableFrom(Class<?> cls, Class<?> cls2) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (cls.isPrimitive() && !cls2.isPrimitive()) {
            cls = sPrimitiveToWrapperMap.get(cls);
        }
        if (cls2.isPrimitive() && !cls.isPrimitive()) {
            cls2 = sPrimitiveToWrapperMap.get(cls2);
        }
        return cls2.isAssignableFrom(cls);
    }
}

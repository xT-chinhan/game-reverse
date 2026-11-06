package com.bytedance.sdk.openadsdk.ats;

import android.util.Pair;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.jw.ny;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
final class ms {
    private static volatile ms ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final Map<String, Pair<Class, Boolean>> f1831ms = new HashMap();
    static final Map<Class, Pair<Class, Method>> xr = new HashMap();
    private final Map<Class, SparseArray<Method>> ab;
    private final Map<Object, Object> c;
    private final Map<String, Object> d;
    private final Map<Object, Object> ka;
    private d x;

    private ms() {
        xr(ah.class);
        xr(ka.class);
        xr(ny.class);
        xr(com.bytedance.sdk.openadsdk.core.w.ka.class);
        xr(com.bytedance.sdk.openadsdk.core.t.ah.class);
        xr(com.bytedance.sdk.openadsdk.core.t.d.class);
        xr(com.bytedance.sdk.component.c.ah.xr.class);
        ah(com.bytedance.sdk.openadsdk.x.ms.class);
        this.d = new HashMap();
        this.ka = new WeakHashMap();
        this.c = new WeakHashMap();
        this.ab = new HashMap();
    }

    public static ms ms() {
        if (ah == null) {
            synchronized (ms.class) {
                if (ah == null) {
                    ah = new ms();
                }
            }
        }
        return ah;
    }

    private static void xr(Class cls) {
        String[] strArrValue;
        ATS ats = (ATS) cls.getAnnotation(ATS.class);
        if (ats == null || (strArrValue = ats.value()) == null) {
            return;
        }
        ats.single();
        for (String str : strArrValue) {
            f1831ms.put(str, new Pair<>(cls, Boolean.valueOf(ats.single())));
        }
    }

    private static void ah(Class cls) {
        for (Method method : cls.getMethods()) {
            if (((ATSMethod) method.getAnnotation(ATSMethod.class)) != null) {
                xr.put(method.getReturnType(), new Pair<>(cls, method));
            }
        }
    }

    public <T> T ms(Class<T> cls) {
        if (cls == null) {
            if (this.x != null) {
                new RuntimeException("null api");
            }
            return null;
        }
        String strMs = xr.ms(cls);
        if (strMs == null || strMs == AbstractJsonLexerKt.NULL) {
            if (this.x != null) {
                cls.getName();
                new RuntimeException("not decorate by ATSApi");
            }
            return null;
        }
        Pair<Class, Boolean> pair = f1831ms.get(strMs);
        if (pair == null) {
            if (this.x != null) {
                cls.getName();
                new RuntimeException("clazz not register");
            }
            return null;
        }
        T t = (T) ms(strMs, pair, cls);
        if (t == null) {
            return null;
        }
        return t.getClass().getClassLoader() == cls.getClassLoader() ? t : (T) ms(t, cls);
    }

    private Object ms(Object obj, Class cls) {
        Object obj2 = this.c.get(obj);
        if (obj2 != null) {
            return obj2;
        }
        Object objNewProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, xr(obj, cls));
        this.c.put(obj, objNewProxyInstance);
        return objNewProxyInstance;
    }

    private InvocationHandler xr(final Object obj, final Class cls) {
        return new InvocationHandler() { // from class: com.bytedance.sdk.openadsdk.ats.ms.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj2, Method method, Object[] objArr) {
                try {
                    return ms.this.ms(obj, obj2, method, objArr, cls);
                } catch (Throwable unused) {
                    if (ms.this.x == null) {
                        return null;
                    }
                    d unused2 = ms.this.x;
                    obj.getClass().getName();
                    method.getName();
                    return null;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object ms(Object obj, Object obj2, Method method, Object[] objArr, Class cls) throws Throwable {
        Annotation annotationMs = xr.ms(cls, method);
        if (annotationMs == null) {
            try {
                Method declaredMethod = obj.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(obj, objArr);
            } catch (Exception unused) {
                if (this.x != null) {
                    obj.getClass().getName();
                    method.getName();
                    method.getName();
                }
                return null;
            }
        }
        Method methodMs = ms(obj, ((Integer) xr.ms(annotationMs)).intValue());
        if (methodMs == null) {
            if (this.x != null) {
                obj.getClass().getName();
                method.getName();
                method.getName();
            }
            return null;
        }
        Class<?>[] parameterTypes = methodMs.getParameterTypes();
        if (parameterTypes != null) {
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = ah(objArr[i], parameterTypes[i]);
            }
        }
        Object objInvoke = methodMs.invoke(obj, objArr);
        if (objInvoke == obj) {
            Object obj3 = this.ka.get(objInvoke);
            if (obj3 != null) {
                return obj3;
            }
            Object objD = d(objInvoke, method.getReturnType());
            this.ka.put(objInvoke, objD);
            return objD;
        }
        return d(objInvoke, method.getReturnType());
    }

    private Method ms(Object obj, int i) {
        Method method;
        Class<?> cls = obj.getClass();
        SparseArray<Method> sparseArray = this.ab.get(cls);
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.ab.put(cls, sparseArray);
            method = null;
        } else {
            method = sparseArray.get(i);
        }
        return method == null ? ms(cls, sparseArray, i) : method;
    }

    private Method ms(Class<?> cls, SparseArray<Method> sparseArray, int i) {
        Method methodMs;
        Integer num;
        Method[] methods = cls.getMethods();
        Method method = null;
        if (methods == null) {
            return null;
        }
        System.currentTimeMillis();
        if (cls.getClassLoader() == ATSMethod.class.getClassLoader()) {
            methodMs = ms(methods, sparseArray, i);
        } else {
            Class clsAh = xr.ah(cls);
            if (clsAh == null) {
                return null;
            }
            for (Method method2 : methods) {
                Annotation annotation = method2.getAnnotation(clsAh);
                if (annotation != null && (num = (Integer) xr.ms(annotation)) != null) {
                    if (num.intValue() == i) {
                        method = method2;
                    }
                    sparseArray.put(num.intValue(), method2);
                }
            }
            methodMs = method;
        }
        cls.getName();
        System.currentTimeMillis();
        return methodMs;
    }

    private Method ms(Method[] methodArr, SparseArray<Method> sparseArray, int i) {
        Method method = null;
        for (Method method2 : methodArr) {
            ATSMethod aTSMethod = (ATSMethod) method2.getAnnotation(ATSMethod.class);
            if (aTSMethod != null) {
                if (aTSMethod.value() == i) {
                    method = method2;
                }
                sparseArray.put(aTSMethod.value(), method2);
            }
        }
        return method;
    }

    private Object ah(Object obj, Class<?> cls) {
        if (obj == null || cls == Void.class) {
            return null;
        }
        return xr.xr(cls) == null ? obj : ms(obj, cls);
    }

    private Object d(Object obj, Class<?> cls) {
        if (obj == null || cls == Void.class) {
            return null;
        }
        return xr.xr(cls) == null ? obj : ms(obj, cls);
    }

    private Object ms(String str, Pair<Class, Boolean> pair, Class cls) {
        Object objMs;
        try {
            if (((Boolean) pair.second).booleanValue()) {
                objMs = this.d.get(str);
                if (objMs == null) {
                    try {
                        synchronized (this.d) {
                            objMs = this.d.get(str);
                            if (objMs == null) {
                                objMs = ms((Class<Object>) pair.first, (Class<Object>) cls);
                                this.d.put(str, objMs);
                            }
                        }
                    } catch (Throwable unused) {
                        return objMs;
                    }
                }
            } else {
                objMs = ms((Class<Object>) pair.first, (Class<Object>) cls);
            }
            return objMs;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private <T> T ms(Class<T> cls, Class<T> cls2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T t = (T) d(cls2);
        if (t != null) {
            return t;
        }
        T t2 = (T) d(cls);
        if (t2 != null) {
            return t2;
        }
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            if (constructor.getAnnotation(ATSMethod.class) != null) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                Object[] objArr = new Object[parameterTypes.length];
                for (int i = 0; i < parameterTypes.length; i++) {
                    objArr[i] = d(parameterTypes[i]);
                }
                return (T) constructor.newInstance(objArr);
            }
        }
        return cls.newInstance();
    }

    private <T> T d(Class<T> cls) throws IllegalAccessException, InvocationTargetException {
        Object[] objArr;
        Pair<Class, Method> pair = xr.get(cls);
        Object objNewInstance = null;
        if (pair == null) {
            return null;
        }
        Method method = (Method) pair.second;
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes == null || parameterTypes.length <= 0) {
            objArr = null;
        } else {
            objArr = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                objArr[i] = d(parameterTypes[i]);
            }
        }
        if (!Modifier.isStatic(method.getModifiers())) {
            try {
                objNewInstance = ((Class) pair.first).newInstance();
            } catch (Throwable unused) {
                if (this.x != null) {
                    cls.getName();
                }
                return null;
            }
        }
        return (T) method.invoke(objNewInstance, objArr);
    }
}

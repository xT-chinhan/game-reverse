package com.kwad.sdk.api.loader;

import com.anythink.core.common.d.i;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ApiReflect {
    private final Object object;
    private final Class<?> type;

    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = -6213149635297151442L;

        public ReflectException(String str) {
            super(str);
        }

        public ReflectException(String str, Throwable th) {
            super(str, th);
        }

        public ReflectException() {
        }

        public ReflectException(Throwable th) {
            super(th);
        }
    }

    private static class JavaApiWrapper {
        private static final Method forName1;
        private static final Method forName2;
        private static final Method getConstructor;
        private static final Method getConstructors;
        private static final Method getDeclaredConstructor;
        private static final Method getDeclaredConstructors;
        private static final Method getDeclaredField;
        private static final Method getDeclaredFields;
        private static final Method getDeclaredMethod;
        private static final Method getDeclaredMethods;
        private static final Method getField;
        private static final Method getFields;
        private static final Method getMethod;
        private static final Method getMethods;

        private JavaApiWrapper() {
        }

        static {
            try {
                forName1 = Class.class.getDeclaredMethod("forName", String.class);
                forName2 = Class.class.getDeclaredMethod("forName", String.class, Boolean.TYPE, ClassLoader.class);
                getDeclaredField = Class.class.getDeclaredMethod("getDeclaredField", String.class);
                getDeclaredFields = Class.class.getDeclaredMethod("getDeclaredFields", new Class[0]);
                getDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                getDeclaredMethods = Class.class.getDeclaredMethod("getDeclaredMethods", new Class[0]);
                getDeclaredConstructor = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
                getDeclaredConstructors = Class.class.getDeclaredMethod("getDeclaredConstructors", new Class[0]);
                getField = Class.class.getDeclaredMethod("getField", String.class);
                getFields = Class.class.getDeclaredMethod("getFields", new Class[0]);
                getMethod = Class.class.getDeclaredMethod("getMethod", String.class, Class[].class);
                getMethods = Class.class.getDeclaredMethod("getMethods", new Class[0]);
                getConstructor = Class.class.getDeclaredMethod("getConstructor", Class[].class);
                getConstructors = Class.class.getDeclaredMethod("getConstructors", new Class[0]);
            } catch (NoSuchMethodException e) {
                throw new ReflectException(e);
            }
        }

        static Class forName(String str, boolean z, ClassLoader classLoader) throws ClassNotFoundException {
            try {
                return (Class) forName2.invoke(null, str, Boolean.valueOf(z), classLoader);
            } catch (Exception e) {
                ClassNotFoundException classNotFoundException = new ClassNotFoundException();
                classNotFoundException.initCause(e);
                throw classNotFoundException;
            }
        }

        static Class forName(String str) throws ClassNotFoundException {
            try {
                return (Class) forName1.invoke(null, str);
            } catch (Exception e) {
                ClassNotFoundException classNotFoundException = new ClassNotFoundException();
                classNotFoundException.initCause(e);
                throw classNotFoundException;
            }
        }

        static Field getDeclaredField(Class cls, String str) throws NoSuchFieldException {
            try {
                return (Field) getDeclaredField.invoke(cls, str);
            } catch (Exception e) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e);
                throw noSuchFieldException;
            }
        }

        static Field getField(Class cls, String str) throws NoSuchFieldException {
            try {
                return (Field) getField.invoke(cls, str);
            } catch (Exception e) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                noSuchFieldException.initCause(e);
                throw noSuchFieldException;
            }
        }

        static Field[] getDeclaredFields(Class cls) {
            try {
                return (Field[]) getDeclaredFields.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        static Method getDeclaredMethod(Class cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
            try {
                return (Method) getDeclaredMethod.invoke(cls, str, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        static Method getMethod(Class cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
            try {
                return (Method) getMethod.invoke(cls, str, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        static Method[] getDeclaredMethods(Class cls) {
            try {
                return (Method[]) getDeclaredMethods.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        static Method[] getMethods(Class cls) {
            try {
                return (Method[]) getMethods.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }

        static Constructor getDeclaredConstructor(Class cls, Class<?>... clsArr) throws NoSuchMethodException {
            try {
                return (Constructor) getDeclaredConstructor.invoke(cls, clsArr);
            } catch (Exception e) {
                NoSuchMethodException noSuchMethodException = new NoSuchMethodException();
                noSuchMethodException.initCause(e);
                throw noSuchMethodException;
            }
        }

        static Constructor[] getDeclaredConstructors(Class cls) {
            try {
                return (Constructor[]) getDeclaredConstructors.invoke(cls, new Object[0]);
            } catch (Exception e) {
                throw new ReflectException(e);
            }
        }
    }

    @Deprecated
    public static ApiReflect on(String str) throws ReflectException {
        return onClass(str);
    }

    @Deprecated
    public static ApiReflect on(String str, ClassLoader classLoader) throws ReflectException {
        return onClass(str, classLoader);
    }

    @Deprecated
    public static ApiReflect on(Class<?> cls) {
        return onClass(cls);
    }

    public static ApiReflect onClass(String str) throws ReflectException {
        return onClass(forName(str));
    }

    public static ApiReflect onClass(String str, ClassLoader classLoader) throws ReflectException {
        return onClass(forName(str, classLoader));
    }

    public static ApiReflect onClass(Class<?> cls) {
        return new ApiReflect(cls);
    }

    public static ApiReflect on(Object obj) {
        return new ApiReflect(obj == null ? Object.class : obj.getClass(), obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ApiReflect on(Class<?> cls, Object obj) {
        return new ApiReflect(cls, obj);
    }

    public static <T> T initValue(Class<T> cls) {
        if (cls == Boolean.TYPE) {
            return (T) Boolean.FALSE;
        }
        if (cls == Byte.TYPE) {
            return (T) (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (T) (short) 0;
        }
        if (cls == Integer.TYPE) {
            return (T) 0;
        }
        if (cls == Long.TYPE) {
            return (T) 0L;
        }
        if (cls == Double.TYPE) {
            return (T) Double.valueOf(0.0d);
        }
        if (cls == Float.TYPE) {
            return (T) Float.valueOf(0.0f);
        }
        if (cls == Character.TYPE) {
            return (T) (char) 0;
        }
        return null;
    }

    public static <T extends AccessibleObject> T accessible(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        return t;
    }

    private ApiReflect(Class<?> cls) {
        this(cls, cls);
    }

    private ApiReflect(Class<?> cls, Object obj) {
        this.type = cls;
        this.object = obj;
    }

    public <T> T get() {
        return (T) this.object;
    }

    public ApiReflect set(String str, Object obj) throws ReflectException {
        try {
            Field fieldField0 = field0(str);
            if ((fieldField0.getModifiers() & 16) == 16) {
                try {
                    Field declaredField = JavaApiWrapper.getDeclaredField(Field.class, "modifiers");
                    declaredField.setAccessible(true);
                    declaredField.setInt(fieldField0, fieldField0.getModifiers() & (-17));
                } catch (NoSuchFieldException unused) {
                }
            }
            fieldField0.set(this.object, unwrap(obj));
            return this;
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public <T> T get(String str) throws ReflectException {
        return (T) field(str).get();
    }

    public ApiReflect field(String str) throws ReflectException {
        try {
            Field fieldField0 = field0(str);
            return on(fieldField0.getType(), fieldField0.get(this.object));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private Field field0(String str) throws ReflectException {
        Class<?> clsType = type();
        try {
            return (Field) accessible(JavaApiWrapper.getField(clsType, str));
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return (Field) accessible(JavaApiWrapper.getDeclaredField(clsType, str));
                } catch (NoSuchFieldException unused) {
                    clsType = clsType.getSuperclass();
                    if (clsType == null) {
                        throw new ReflectException(e);
                    }
                }
            } while (clsType == null);
            throw new ReflectException(e);
        }
    }

    public Map<String, ApiReflect> fields() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class<?> clsType = type();
        do {
            for (Field field : JavaApiWrapper.getDeclaredFields(clsType)) {
                if ((this.type != this.object) ^ Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!linkedHashMap.containsKey(name)) {
                        linkedHashMap.put(name, field(name));
                    }
                }
            }
            clsType = clsType.getSuperclass();
        } while (clsType != null);
        return linkedHashMap;
    }

    public ApiReflect call(String str) throws ReflectException {
        return call(str, new Object[0]);
    }

    public ApiReflect call(String str, Class<?>[] clsArr) throws ReflectException {
        return call(str, clsArr, new Object[0]);
    }

    public ApiReflect call(String str, Object... objArr) throws ReflectException {
        return call(str, types(objArr), objArr);
    }

    public ApiReflect call(String str, Class<?>[] clsArr, Object... objArr) throws ReflectException {
        try {
            try {
                return on(exactMethod(str, clsArr), this.object, objArr);
            } catch (NoSuchMethodException unused) {
                return on(similarMethod(str, clsArr), this.object, objArr);
            }
        } catch (NoSuchMethodException e) {
            throw new ReflectException(e);
        }
    }

    private Method exactMethod(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> clsType = type();
        try {
            return JavaApiWrapper.getMethod(clsType, str, clsArr);
        } catch (NoSuchMethodException unused) {
            do {
                try {
                    return JavaApiWrapper.getDeclaredMethod(clsType, str, clsArr);
                } catch (NoSuchMethodException unused2) {
                    clsType = clsType.getSuperclass();
                }
            } while (clsType != null);
            throw new NoSuchMethodException();
        }
    }

    private Method similarMethod(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class<?> clsType = type();
        for (Method method : JavaApiWrapper.getMethods(clsType)) {
            if (isSimilarSignature(method, str, clsArr)) {
                return method;
            }
        }
        do {
            for (Method method2 : JavaApiWrapper.getDeclaredMethods(clsType)) {
                if (isSimilarSignature(method2, str, clsArr)) {
                    return method2;
                }
            }
            clsType = clsType.getSuperclass();
        } while (clsType != null);
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + i.E);
    }

    private boolean isSimilarSignature(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && match(method.getParameterTypes(), clsArr);
    }

    public ApiReflect create() throws ReflectException {
        return create(new Object[0]);
    }

    public ApiReflect create(Object... objArr) throws ReflectException {
        return create(types(objArr), objArr);
    }

    public ApiReflect create(Class<?>[] clsArr, Object... objArr) throws ReflectException {
        try {
            return on((Constructor<?>) JavaApiWrapper.getDeclaredConstructor(type(), clsArr), objArr);
        } catch (NoSuchMethodException e) {
            for (Constructor constructor : JavaApiWrapper.getDeclaredConstructors(type())) {
                if (match(constructor.getParameterTypes(), clsArr)) {
                    return on((Constructor<?>) constructor, objArr);
                }
            }
            throw new ReflectException(e);
        }
    }

    public <P> P as(Class<P> cls) {
        return (P) as(cls, new Class[0]);
    }

    public <P> P as(Class<P> cls, Class<?>... clsArr) {
        final boolean z = this.object instanceof Map;
        InvocationHandler invocationHandler = new InvocationHandler() { // from class: com.kwad.sdk.api.loader.ApiReflect.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                String name = method.getName();
                try {
                    return ApiReflect.on((Class<?>) ApiReflect.this.type, ApiReflect.this.object).call(name, objArr).get();
                } catch (ReflectException e) {
                    if (z) {
                        Map map = (Map) ApiReflect.this.object;
                        int length = objArr == null ? 0 : objArr.length;
                        if (length == 0 && name.startsWith("get")) {
                            return map.get(ApiReflect.property(name.substring(3)));
                        }
                        if (length == 0 && name.startsWith("is")) {
                            return map.get(ApiReflect.property(name.substring(2)));
                        }
                        if (length == 1 && name.startsWith("set")) {
                            map.put(ApiReflect.property(name.substring(3)), objArr[0]);
                            return null;
                        }
                    }
                    throw e;
                }
            }
        };
        Class[] clsArr2 = new Class[clsArr.length + 1];
        clsArr2[0] = cls;
        System.arraycopy(clsArr, 0, clsArr2, 1, clsArr.length);
        return (P) Proxy.newProxyInstance(cls.getClassLoader(), clsArr2, invocationHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String property(String str) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    private boolean match(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != NULL.class && !wrapper(clsArr[i]).isAssignableFrom(wrapper(clsArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ApiReflect) {
            return this.object.equals(((ApiReflect) obj).get());
        }
        return false;
    }

    public String toString() {
        return String.valueOf(this.object);
    }

    private static ApiReflect on(Constructor<?> constructor, Object... objArr) throws ReflectException {
        try {
            return on(constructor.getDeclaringClass(), ((Constructor) accessible(constructor)).newInstance(objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private static ApiReflect on(Method method, Object obj, Object... objArr) throws ReflectException {
        try {
            accessible(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                return on(obj);
            }
            return on(method.invoke(obj, objArr));
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private static Object unwrap(Object obj) {
        return obj instanceof ApiReflect ? ((ApiReflect) obj).get() : obj;
    }

    private static Class<?>[] types(Object... objArr) {
        if (objArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? NULL.class : obj.getClass();
        }
        return clsArr;
    }

    private static Class<?> forName(String str) throws ReflectException {
        try {
            return JavaApiWrapper.forName(str);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    private static Class<?> forName(String str, ClassLoader classLoader) throws ReflectException {
        try {
            return JavaApiWrapper.forName(str, true, classLoader);
        } catch (Exception e) {
            throw new ReflectException(e);
        }
    }

    public Class<?> type() {
        return this.type;
    }

    public static Class<?> wrapper(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        return Void.TYPE == cls ? Void.class : cls;
    }

    private static class NULL {
        private NULL() {
        }
    }
}

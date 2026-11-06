package com.bytedance.sdk.component.ah.xr.ms.ab;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
class d<T> {
    private final Class[] ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Class<?> f1050ms;
    private final String xr;

    d(Class<?> cls, String str, Class... clsArr) {
        this.f1050ms = cls;
        this.xr = str;
        this.ah = clsArr;
    }

    public boolean ms(T t) {
        return ms(t.getClass()) != null;
    }

    public Object ms(T t, Object... objArr) throws InvocationTargetException {
        Method methodMs = ms(t.getClass());
        if (methodMs == null) {
            return null;
        }
        try {
            return methodMs.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object xr(T t, Object... objArr) {
        try {
            return ms(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object ah(T t, Object... objArr) throws InvocationTargetException {
        Method methodMs = ms(t.getClass());
        if (methodMs == null) {
            throw new AssertionError("Method " + this.xr + " not supported for object " + t);
        }
        try {
            return methodMs.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: ".concat(String.valueOf(methodMs)));
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public Object d(T t, Object... objArr) {
        try {
            return ah(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    private Method ms(Class<?> cls) {
        Class<?> cls2;
        String str = this.xr;
        if (str == null) {
            return null;
        }
        Method methodMs = ms(cls, str, this.ah);
        if (methodMs == null || (cls2 = this.f1050ms) == null || cls2.isAssignableFrom(methodMs.getReturnType())) {
            return methodMs;
        }
        return null;
    }

    private static Method ms(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }
}

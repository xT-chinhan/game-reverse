package com.byazt.quz;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND, 5})
public class q<T> {
    public final Class<?> n;
    public final String qg;
    public final Class[] s;

    public q(Class<?> cls, String str, Class... clsArr) {
        this.n = cls;
        this.qg = str;
        this.s = clsArr;
    }

    public boolean n(T t) {
        return n(t.getClass()) != null;
    }

    public Object n(T t, Object... objArr) throws InvocationTargetException {
        Method methodN = n(t.getClass());
        if (methodN == null) {
            return null;
        }
        try {
            return methodN.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object qg(T t, Object... objArr) {
        try {
            return n(t, objArr);
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

    public Object s(T t, Object... objArr) throws InvocationTargetException {
        Method methodN = n(t.getClass());
        if (methodN == null) {
            throw new AssertionError("Method " + this.qg + " not supported for object " + t);
        }
        try {
            return methodN.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: ".concat(String.valueOf(methodN)));
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public Object q(T t, Object... objArr) {
        try {
            return s(t, objArr);
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

    private Method n(Class<?> cls) {
        Class<?> cls2;
        String str = this.qg;
        if (str == null) {
            return null;
        }
        Method methodN = n(cls, str, this.s);
        if (methodN == null || (cls2 = this.n) == null || cls2.isAssignableFrom(methodN.getReturnType())) {
            return methodN;
        }
        return null;
    }

    private static Method n(Class<?> cls, String str, Class[] clsArr) {
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

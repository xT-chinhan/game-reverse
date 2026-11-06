package com.byazt.lp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH, 121})
public class x<T> {
    public final Class[] hn;
    public final String hw;
    public final Class<?> pr;

    public x(Class<?> cls, String str, Class... clsArr) {
        this.pr = cls;
        this.hw = str;
        this.hn = clsArr;
    }

    public boolean pr(T t) {
        return pr(t.getClass()) != null;
    }

    public Object pr(T t, Object... objArr) throws InvocationTargetException {
        Method methodPr = pr(t.getClass());
        if (methodPr == null) {
            return null;
        }
        try {
            return methodPr.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    public Object hw(T t, Object... objArr) {
        try {
            return pr(t, objArr);
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

    public Object hn(T t, Object... objArr) throws InvocationTargetException {
        Method methodPr = pr(t.getClass());
        if (methodPr == null) {
            throw new AssertionError("Method " + this.hw + " not supported for object " + t);
        }
        try {
            return methodPr.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: ".concat(String.valueOf(methodPr)));
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public Object x(T t, Object... objArr) {
        try {
            return hn(t, objArr);
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

    private Method pr(Class<?> cls) {
        Class<?> cls2;
        String str = this.hw;
        if (str == null) {
            return null;
        }
        Method methodPr = pr(cls, str, this.hn);
        if (methodPr == null || (cls2 = this.pr) == null || cls2.isAssignableFrom(methodPr.getReturnType())) {
            return methodPr;
        }
        return null;
    }

    private static Method pr(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
                return method;
            } catch (NoSuchMethodException e) {
                return method;
            }
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }
}

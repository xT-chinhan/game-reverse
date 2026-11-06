package com.byazt.hx;

import com.bytedance.pangle.log.ZeusLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1364, 19})
public class n {
    public static Method n;
    public static Method q;
    public static Method qg;
    public static Method s;

    static {
        try {
            n = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            qg = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            s = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
            q = Class.class.getDeclaredMethod("forName", String.class);
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "DoubleReflectorinit failed", th);
        }
    }

    public static Field n(Class<?> cls, String str) {
        Throwable th;
        Field field;
        Method method = n;
        Field field2 = null;
        if (method != null) {
            try {
                field = (Field) method.invoke(cls, str);
                if (field != null) {
                    try {
                        field.setAccessible(true);
                    } catch (Throwable th2) {
                        th = th2;
                        ZeusLogger.w(ZeusLogger.TAG, "DoubleReflector" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                field = null;
            }
            field2 = field;
        }
        return field2 != null ? field2 : com.byazt.el.n.n(cls, str);
    }

    public static Method n(Class<?> cls, String str, Class<?>... clsArr) {
        Throwable th;
        Method method;
        Method method2 = qg;
        Method method3 = null;
        if (method2 != null) {
            try {
                method = (Method) method2.invoke(cls, str, clsArr);
                if (method != null) {
                    try {
                        method.setAccessible(true);
                    } catch (Throwable th2) {
                        th = th2;
                        ZeusLogger.w(ZeusLogger.TAG, "DoubleReflector" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                method = null;
            }
            method3 = method;
        }
        return method3 != null ? method3 : com.byazt.el.n.n(cls, str, clsArr);
    }

    public static Constructor n(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        Method method = s;
        if (method != null) {
            try {
                constructor = (Constructor) method.invoke(cls, clsArr);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder("DoubleReflector");
                Object[] objArr = new Object[2];
                objArr[0] = cls.getName();
                objArr[1] = Integer.valueOf(clsArr != null ? clsArr.length : 0);
                ZeusLogger.w(ZeusLogger.TAG, sb.append(String.format("getConstructor %s<init>%s failed !!!", objArr)).toString(), th);
                constructor = null;
            }
        } else {
            constructor = null;
        }
        return constructor != null ? constructor : com.byazt.el.n.n(cls, clsArr);
    }
}

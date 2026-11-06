package com.byazt.gy;

import com.bytedance.pangle.log.ZeusLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1527, 37})
public class pr {
    public static Method hn;
    public static Method hw;
    public static Method pr;
    public static Method x;

    static {
        try {
            pr = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            hw = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            hn = Class.class.getDeclaredMethod("getDeclaredConstructor", Class[].class);
            x = Class.class.getDeclaredMethod("forName", String.class);
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "DoubleReflectorinit failed", th);
        }
    }

    public static Field pr(Class<?> cls, String str) {
        Throwable th;
        Field field;
        Method method = pr;
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
                        field2 = field;
                    }
                }
                field2 = field;
            } catch (Throwable th3) {
                th = th3;
                field = null;
            }
        }
        return field2 != null ? field2 : com.byazt.fx.pr.pr(cls, str);
    }

    public static Method pr(Class<?> cls, String str, Class<?>... clsArr) {
        Throwable th;
        Method method;
        Method method2 = hw;
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
                        method3 = method;
                    }
                }
                method3 = method;
            } catch (Throwable th3) {
                th = th3;
                method = null;
            }
        }
        return method3 != null ? method3 : com.byazt.fx.pr.pr(cls, str, clsArr);
    }

    public static Constructor pr(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        Method method = hn;
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
        return constructor != null ? constructor : com.byazt.fx.pr.pr(cls, clsArr);
    }
}

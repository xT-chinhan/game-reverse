package com.byazt.el;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 989, 19})
public class n {
    public static Map<String, Field> n = new HashMap();
    public static Map<String, Method> qg = new HashMap();
    public static Map<String, Constructor> s = new HashMap();
    public static Map<String, Class> q = new HashMap();

    static {
        try {
            FieldUtils.writeField(qg.class, "classLoader", (Object) null);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "HackHelperinit failed", e);
        }
    }

    public static Field n(Class<?> cls, String str) {
        Field field;
        String strQg = qg(cls, str);
        synchronized (n) {
            field = n.get(strQg);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field fieldN = qg.n(cls, str);
            if (fieldN != null) {
                synchronized (n) {
                    n.put(strQg, fieldN);
                }
            }
            return fieldN;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    public static Method n(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String strQg = qg(cls, str, clsArr);
        synchronized (qg) {
            method = qg.get(strQg);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method methodN = qg.n(cls, str, clsArr);
            if (methodN != null) {
                synchronized (qg) {
                    qg.put(strQg, methodN);
                }
            }
            return methodN;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    public static Constructor n(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        String strQg = qg(cls, "clinit", clsArr);
        synchronized (s) {
            constructor = s.get(strQg);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor constructorN = qg.n(cls, clsArr);
            if (constructorN != null) {
                synchronized (s) {
                    s.put(strQg, constructorN);
                }
            }
            return constructorN;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getConstructor %s failed !!!", cls.getName()), th);
            return null;
        }
    }

    private static String qg(Class<?> cls, String str) {
        return cls.getName() + "#" + str;
    }

    private static String qg(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName()).append("#").append(str);
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.getName()).append("#");
            }
        } else {
            sb.append(Void.class.getName());
        }
        return sb.toString();
    }
}

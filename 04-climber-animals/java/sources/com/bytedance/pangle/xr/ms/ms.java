package com.bytedance.pangle.xr.ms;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Map<String, Field> f731ms = new HashMap();
    private static Map<String, Method> xr = new HashMap();
    private static Map<String, Constructor> ah = new HashMap();
    private static Map<String, Class> d = new HashMap();

    static {
        try {
            FieldUtils.writeField(xr.class, "classLoader", (Object) null);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "HackHelperinit failed", e);
        }
    }

    public static Field ms(Class<?> cls, String str) {
        Field field;
        String strXr = xr(cls, str);
        synchronized (f731ms) {
            field = f731ms.get(strXr);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field fieldMs = xr.ms(cls, str);
            if (fieldMs != null) {
                synchronized (f731ms) {
                    f731ms.put(strXr, fieldMs);
                }
            }
            return fieldMs;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    public static Method ms(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String strXr = xr(cls, str, clsArr);
        synchronized (xr) {
            method = xr.get(strXr);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method methodMs = xr.ms(cls, str, clsArr);
            if (methodMs != null) {
                synchronized (xr) {
                    xr.put(strXr, methodMs);
                }
            }
            return methodMs;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    public static Constructor ms(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        String strXr = xr(cls, "clinit", clsArr);
        synchronized (ah) {
            constructor = ah.get(strXr);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor constructorMs = xr.ms(cls, clsArr);
            if (constructorMs != null) {
                synchronized (ah) {
                    ah.put(strXr, constructorMs);
                }
            }
            return constructorMs;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getConstructor %s failed !!!", cls.getName()), th);
            return null;
        }
    }

    private static String xr(Class<?> cls, String str) {
        return cls.getName() + "#" + str;
    }

    private static String xr(Class<?> cls, String str, Class<?>... clsArr) {
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

package com.byazt.fx;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1147, 37})
public class pr {
    public static Map<String, Field> pr = new HashMap();
    public static Map<String, Method> hw = new HashMap();
    public static Map<String, Constructor> hn = new HashMap();
    public static Map<String, Class> x = new HashMap();

    static {
        try {
            FieldUtils.writeField(hw.class, "classLoader", (Object) null);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "HackHelperinit failed", e);
        }
    }

    public static Field pr(Class<?> cls, String str) {
        Field field;
        String strHw = hw(cls, str);
        synchronized (pr) {
            field = pr.get(strHw);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field fieldPr = hw.pr(cls, str);
            if (fieldPr != null) {
                synchronized (pr) {
                    pr.put(strHw, fieldPr);
                }
            }
            return fieldPr;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    public static Method pr(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String strHw = hw(cls, str, clsArr);
        synchronized (hw) {
            method = hw.get(strHw);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method methodPr = hw.pr(cls, str, clsArr);
            if (methodPr != null) {
                synchronized (hw) {
                    hw.put(strHw, methodPr);
                }
            }
            return methodPr;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    public static Constructor pr(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        String strHw = hw(cls, "clinit", clsArr);
        synchronized (hn) {
            constructor = hn.get(strHw);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor constructorPr = hw.pr(cls, clsArr);
            if (constructorPr != null) {
                synchronized (hn) {
                    hn.put(strHw, constructorPr);
                }
            }
            return constructorPr;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getConstructor %s failed !!!", cls.getName()), th);
            return null;
        }
    }

    private static String hw(Class<?> cls, String str) {
        return cls.getName() + "#" + str;
    }

    private static String hw(Class<?> cls, String str, Class<?>... clsArr) {
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

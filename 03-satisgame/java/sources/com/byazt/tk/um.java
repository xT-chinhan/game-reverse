package com.byazt.tk;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, 33})
public class um {
    public static Object n;
    public static Method qg;

    static {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            Method method = (Method) declaredMethod2.invoke(cls, "getRuntime", null);
            qg = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            n = method.invoke(null, new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public static boolean n(String... strArr) {
        Method method;
        Object obj = n;
        if (obj != null && (method = qg) != null) {
            try {
                method.invoke(obj, strArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean n() {
        return n("L");
    }
}

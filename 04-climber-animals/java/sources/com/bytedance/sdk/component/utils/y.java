package com.bytedance.sdk.component.utils;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Object f1371ms;
    private static Method xr;

    static {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            Method method = (Method) declaredMethod2.invoke(cls, "getRuntime", null);
            xr = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            f1371ms = method.invoke(null, new Object[0]);
        } catch (Throwable th) {
            sl.xr("Reflection", "reflect bootstrap failed:", th);
        }
    }

    public static boolean ms(String... strArr) {
        Method method;
        Object obj = f1371ms;
        if (obj != null && (method = xr) != null) {
            try {
                method.invoke(obj, strArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean ms() {
        return ms("L");
    }
}

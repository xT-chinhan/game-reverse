package com.tapsdk.tapad.e;

import com.tapsdk.tapad.internal.utils.TapADLogger;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
class k {
    k() {
    }

    public static String a() {
        try {
            Class<?> cls = Class.forName("com.taptap.sdk.Profile");
            Method declaredMethod = cls.getDeclaredMethod("getCurrentProfile", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = cls.getDeclaredMethod("toJsonString", new Class[0]);
            declaredMethod2.setAccessible(true);
            return (String) declaredMethod2.invoke(objInvoke, new Object[0]);
        } catch (Throwable th) {
            TapADLogger.e(th.getMessage());
            return "";
        }
    }
}

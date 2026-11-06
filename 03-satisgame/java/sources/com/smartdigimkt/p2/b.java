package com.smartdigimkt.p2;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final Method a;

    public b(Class cls, String str, Class[] clsArr) {
        Method declaredMethod = null;
        if (cls == null) {
            this.a = null;
            return;
        }
        while (cls != Object.class && cls != null) {
            try {
                try {
                    try {
                        declaredMethod = cls.getDeclaredMethod(str, clsArr);
                        break;
                    } catch (Throwable th) {
                        this.a = declaredMethod;
                        throw th;
                    }
                } catch (NoSuchMethodException | SecurityException unused) {
                    cls = cls.getSuperclass();
                }
            } catch (Exception e) {
                throw new a(e);
            }
        }
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
        }
        this.a = declaredMethod;
    }
}

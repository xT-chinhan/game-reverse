package com.anythink.core.common.b;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class b implements c {
    private Object a;
    private Method b;

    public b() {
        try {
            Class<?> cls = Class.forName("com.aegis.guard.TDNAHandler");
            Method method = cls.getMethod("getInstance", new Class[0]);
            method.setAccessible(true);
            this.a = method.invoke(null, new Object[0]);
            Method method2 = cls.getMethod(com.anythink.core.d.b.a.A, Context.class, Long.TYPE);
            this.b = method2;
            method2.setAccessible(true);
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.common.b.c
    public final byte[] a(Context context) {
        try {
            Object obj = this.a;
            if (obj != null) {
                return (byte[]) this.b.invoke(obj, context, -1L);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}

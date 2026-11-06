package com.anythink.china.a;

import android.content.Context;
import com.anythink.core.common.u.j;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class b implements d {
    private static final String a = "Y29tLmFlZ2lzLmd1YXJkLlRETkFIYW5kbGVy";
    private Object b;
    private Method c;

    public b() {
        try {
            Class<?> cls = Class.forName(j.b(a));
            Method method = cls.getMethod("getInstance", new Class[0]);
            method.setAccessible(true);
            this.b = method.invoke(null, new Object[0]);
            Method method2 = cls.getMethod(com.anythink.core.e.b.a.z, Context.class, Long.TYPE);
            this.c = method2;
            method2.setAccessible(true);
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.china.a.d
    public final byte[] a(Context context, long j) {
        try {
            Object obj = this.b;
            if (obj != null) {
                return (byte[]) this.c.invoke(obj, context, Long.valueOf(j));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}

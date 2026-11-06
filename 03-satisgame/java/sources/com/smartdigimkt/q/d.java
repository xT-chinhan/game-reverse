package com.smartdigimkt.q;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final Object b;
    public static final Method c;
    public final String a;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls.newInstance();
            c = cls.getMethod("getOAID", Context.class);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001a  */
    public d(Context context) {
        String str;
        Method method = c;
        Object obj = b;
        if (obj == null || method == null) {
            str = null;
        } else {
            try {
                Object objInvoke = method.invoke(obj, context);
                if (objInvoke != null) {
                    str = (String) objInvoke;
                } else {
                    str = null;
                }
            } catch (Throwable unused) {
            }
        }
        this.a = str;
    }
}

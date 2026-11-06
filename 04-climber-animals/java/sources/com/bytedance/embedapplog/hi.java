package com.bytedance.embedapplog;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
final class hi implements pl {
    private static Method ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Object f492ms;
    private static Class<?> xr;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            xr = cls;
            f492ms = cls.newInstance();
            ah = xr.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            oh.ms("Api#static reflect exception! " + e.getMessage());
        }
    }

    hi() {
    }

    static boolean ms() {
        return (xr == null || f492ms == null || ah == null) ? false : true;
    }

    @Override // com.bytedance.embedapplog.pl
    public boolean ms(Context context) {
        return ms();
    }

    @Override // com.bytedance.embedapplog.pl
    public pl.ms xr(Context context) {
        try {
            pl.ms msVar = new pl.ms();
            msVar.xr = ms(context, ah);
            return msVar;
        } catch (Exception e) {
            oh.ms(e);
            return null;
        }
    }

    private static String ms(Context context, Method method) {
        Object obj = f492ms;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}

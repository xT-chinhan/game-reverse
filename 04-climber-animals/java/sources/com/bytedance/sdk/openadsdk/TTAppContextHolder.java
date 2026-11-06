package com.bytedance.sdk.openadsdk;

import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.api.ab;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class TTAppContextHolder {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile Context f1640ms;

    public static Context getContext() {
        if (f1640ms == null) {
            setContext(null);
        }
        return f1640ms;
    }

    public static synchronized void setContext(Context context) {
        if (f1640ms == null) {
            if (context != null) {
                f1640ms = context.getApplicationContext();
            } else if (ms.ms() != null) {
                try {
                    Application applicationMs = ms.ms();
                    f1640ms = applicationMs;
                    if (applicationMs != null) {
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static volatile Application f1641ms;

        public static Application ms() {
            return f1641ms;
        }

        static {
            try {
                Object objXr = xr();
                f1641ms = (Application) objXr.getClass().getMethod("getApplication", new Class[0]).invoke(objXr, new Object[0]);
                ab.d("MyApplication", "application get success");
            } catch (Throwable th) {
                ab.ka("MyApplication", "application get failed", th);
            }
        }

        private static Object xr() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                ab.ka("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }
}

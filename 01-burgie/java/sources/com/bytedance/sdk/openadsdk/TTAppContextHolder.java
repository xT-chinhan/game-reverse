package com.bytedance.sdk.openadsdk;

import android.app.Application;
import android.content.Context;
import com.byazt.dea.uc;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 78, 79, 80, 1239})
public class TTAppContextHolder {
    private static volatile Context pr;

    public static Context getContext() {
        if (pr == null) {
            setContext(null);
        }
        return pr;
    }

    public static synchronized void setContext(Context context) {
        if (pr == null) {
            if (context != null) {
                pr = context.getApplicationContext();
            } else if (pr.pr() != null) {
                try {
                    Application applicationPr = pr.pr();
                    pr = applicationPr;
                    if (applicationPr != null) {
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 78, 79, 80, 1516})
    private static class pr {
        private static volatile Application pr;

        public static Application pr() {
            return pr;
        }

        static {
            try {
                Object objHw = hw();
                pr = (Application) objHw.getClass().getMethod("getApplication", new Class[0]).invoke(objHw, new Object[0]);
                uc.x("MyApplication", "application get success");
            } catch (Throwable th) {
                uc.c("MyApplication", "application get failed", th);
            }
        }

        private static Object hw() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                uc.c("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }
}

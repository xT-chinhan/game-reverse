package com.bytedance.sdk.openadsdk;

import android.app.Application;
import android.content.Context;
import com.byazt.vx.w;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 55, 56, 57, 1375})
public class TTAppContextHolder {
    private static volatile Context n;

    public static Context getContext() {
        if (n == null) {
            setContext(null);
        }
        return n;
    }

    public static synchronized void setContext(Context context) {
        if (n == null) {
            if (context != null) {
                n = context.getApplicationContext();
            } else if (n.n() != null) {
                try {
                    Application applicationN = n.n();
                    n = applicationN;
                    if (applicationN != null) {
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    @com.byazt.cp.n(n = {0, 55, 56, 57, AVMDLDataLoader.KeyIsIsGetChecksumInfo})
    private static class n {
        private static volatile Application n;

        public static Application n() {
            return n;
        }

        static {
            try {
                Object objQg = qg();
                n = (Application) objQg.getClass().getMethod("getApplication", new Class[0]).invoke(objQg, new Object[0]);
                w.q("MyApplication", "application get success");
            } catch (Throwable th) {
                w.l("MyApplication", "application get failed", th);
            }
        }

        private static Object qg() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                w.l("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }
}

package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class re {
    private static final AtomicBoolean ah = new AtomicBoolean(false);
    private static volatile Context d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile yu<com.bytedance.sdk.openadsdk.core.zb.ms> f3294ms;
    private static volatile com.bytedance.sdk.openadsdk.core.g.ch xr;

    public static Context getContext() {
        if (d == null) {
            d = ms.ms();
        }
        return d;
    }

    public static synchronized void ms(Context context) {
        if (d == null && context != null) {
            d = context.getApplicationContext();
        }
    }

    public static yu<com.bytedance.sdk.openadsdk.core.zb.ms> ms() {
        if (f3294ms == null) {
            synchronized (re.class) {
                if (f3294ms == null) {
                    f3294ms = new op(getContext());
                }
            }
        }
        return f3294ms;
    }

    public static com.bytedance.sdk.openadsdk.core.g.ch xr() {
        if (xr == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.g.ch.class) {
                if (xr == null) {
                    xr = new com.bytedance.sdk.openadsdk.core.g.ch();
                }
            }
        }
        return xr;
    }

    public static Bridge ms(int i) {
        return jw.ms().ms(i);
    }

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static volatile Application f3295ms;

        public static Application ms() {
            return f3295ms;
        }

        static {
            try {
                Object objXr = xr();
                f3295ms = (Application) objXr.getClass().getMethod("getApplication", new Class[0]).invoke(objXr, new Object[0]);
                com.bytedance.sdk.component.utils.sl.xr("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.xr("MyApplication", "application get failed", th);
            }
        }

        private static Object xr() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.xr("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }
}

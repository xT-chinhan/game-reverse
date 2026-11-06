package com.bytedance.sdk.openadsdk.op;

import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.nw;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class ab {
    public static boolean ms() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void ms(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            nw.c().post(runnable);
        }
    }

    public static void ms(Runnable runnable, long j) {
        nw.c().postDelayed(runnable, j);
    }

    public static void ms(com.bytedance.sdk.component.ch.ny nyVar) {
        com.bytedance.sdk.component.ch.ab.xr(nyVar);
    }

    public static void xr(com.bytedance.sdk.component.ch.ny nyVar) {
        com.bytedance.sdk.component.ch.ab.ah(nyVar);
    }

    public static void xr(Runnable runnable) {
        if (re.xr().df() || Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            nw.c().post(runnable);
        }
    }

    public static void ah(Runnable runnable) {
        if (re.xr().zh()) {
            com.bytedance.sdk.component.utils.x.ah().post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void ms(final Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        if (!ms()) {
            if (runnable != null) {
                runnable.run();
            }
        } else if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(runnable);
        } else {
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("") { // from class: com.bytedance.sdk.openadsdk.op.ab.1
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            });
        }
    }

    public static void d(Runnable runnable) {
        ms(runnable, (ScheduledExecutorService) null);
    }

    public static Looper xr() {
        return re.xr().zh() ? com.bytedance.sdk.component.utils.x.ah().getLooper() : Looper.getMainLooper();
    }
}

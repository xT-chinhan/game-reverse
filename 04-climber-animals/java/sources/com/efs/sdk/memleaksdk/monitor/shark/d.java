package com.efs.sdk.memleaksdk.monitor.shark;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private static final Handler a;
    private static volatile ScheduledThreadPoolExecutor b;
    private static final ThreadFactory c;

    static {
        HandlerThread handlerThread = new HandlerThread("UMonitor Loop");
        handlerThread.start();
        a = new Handler(handlerThread.getLooper());
        c = new ThreadFactory() { // from class: com.efs.sdk.memleaksdk.monitor.internal.d.1
            private final AtomicInteger a = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "UMonitor #" + this.a.addAndGet(1));
            }
        };
    }

    public static Handler a() {
        return a;
    }

    private static ScheduledThreadPoolExecutor b() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new ScheduledThreadPoolExecutor(2, c);
                    b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return b;
    }

    public static void a(Runnable runnable, long j) {
        try {
            b().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            g.b("UMonitor.Executor", "schedule", th);
        }
    }
}

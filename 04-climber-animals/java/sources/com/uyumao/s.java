package com.uyumao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: UMExecutor.java */
/* JADX INFO: loaded from: classes4.dex */
public class s {
    public static volatile ScheduledThreadPoolExecutor a;
    public static volatile ExecutorService b;
    public static final ThreadFactory c = new a();

    /* JADX INFO: compiled from: UMExecutor.java */
    public static class a implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Azx-" + this.a.incrementAndGet());
        }
    }

    /* JADX INFO: compiled from: UMExecutor.java */
    public static class b implements Runnable {
        public final Runnable a;

        public b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Runnable runnable = this.a;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    public static ScheduledThreadPoolExecutor a() {
        if (a == null) {
            synchronized (s.class) {
                if (a == null) {
                    a = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), c);
                    a.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    a.allowCoreThreadTimeOut(true);
                }
            }
        }
        return a;
    }

    public static Future<?> a(Runnable runnable) {
        try {
            if (b == null) {
                synchronized (s.class) {
                    if (b == null) {
                        b = Executors.newSingleThreadExecutor(c);
                    }
                }
            }
            return b.submit(new b(runnable));
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static void a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j, timeUnit);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}

package com.byazt.rb;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.byazt.tk.k;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1315, 18})
public class l {
    public static final int fs;
    public static HandlerThread l = null;
    public static final /* synthetic */ boolean n = true;
    public static Handler q = null;
    public static final Object qg = new Object();
    public static final ThreadPoolExecutor rv;
    public static boolean s = false;
    public static final Executor tj;
    public static Handler w;
    public static final int x;

    static {
        n();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        x = iAvailableProcessors;
        fs = Math.min(iAvailableProcessors, 4);
        rv = fs();
        tj = rv();
    }

    public static void n() {
        try {
            HandlerThread handlerThread = new HandlerThread("gm_t_main", -19);
            l = handlerThread;
            handlerThread.start();
            w = new Handler(l.getLooper());
        } catch (Throwable unused) {
        }
    }

    private static boolean x() {
        HandlerThread handlerThread = l;
        return (handlerThread == null || !handlerThread.isAlive() || w == null) ? false : true;
    }

    public static void n(Runnable runnable) {
        if (x()) {
            if (s()) {
                runnable.run();
                return;
            } else {
                w.post(runnable);
                return;
            }
        }
        n();
    }

    public static void n(Runnable runnable, long j) {
        if (x()) {
            w.postDelayed(runnable, j);
        } else {
            n();
        }
    }

    public static Looper qg() {
        if (x()) {
            return l.getLooper();
        }
        return null;
    }

    public static boolean s() {
        return x() && l.getLooper() == Looper.myLooper();
    }

    public static ThreadFactory n(final String str) {
        return new ThreadFactory() { // from class: com.byazt.rb.l.1
            public final AtomicInteger qg = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new com.byazt.xis.s(runnable, str + " # " + this.qg.getAndIncrement());
            }
        };
    }

    public static Handler q() {
        Handler handler;
        synchronized (qg) {
            if (q == null) {
                if (s) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                q = new Handler(Looper.getMainLooper());
            }
            handler = q;
        }
        return handler;
    }

    public static void qg(Runnable runnable) {
        if (l()) {
            runnable.run();
            return;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        qg(futureTask);
        try {
            futureTask.get();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured while waiting for runnable", e);
        }
    }

    public static <T> T n(Callable<T> callable) {
        try {
            return (T) qg(callable);
        } catch (ExecutionException e) {
            throw new RuntimeException("Error occured waiting for callable", e);
        }
    }

    public static <T> T qg(Callable<T> callable) throws ExecutionException {
        FutureTask futureTask = new FutureTask(callable);
        n(futureTask);
        try {
            return (T) futureTask.get();
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted waiting for callable", e);
        }
    }

    public static <T> FutureTask<T> n(FutureTask<T> futureTask) {
        if (l()) {
            futureTask.run();
        } else {
            qg((FutureTask) futureTask);
        }
        return futureTask;
    }

    public static void s(Runnable runnable) {
        if (l()) {
            runnable.run();
        } else {
            q().post(runnable);
        }
    }

    public static <T> FutureTask<T> qg(FutureTask<T> futureTask) {
        q().post(futureTask);
        return futureTask;
    }

    public static boolean l() {
        return q().getLooper() == Looper.myLooper();
    }

    public static ExecutorService n(String str, int i, RejectedExecutionHandler rejectedExecutionHandler) {
        return new com.byazt.xis.q(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(i), n("gm_t_single_".concat(String.valueOf(str))), rejectedExecutionHandler);
    }

    private static ThreadPoolExecutor fs() {
        int i = fs;
        com.byazt.xis.q qVar = new com.byazt.xis.q(i, i, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(1024), n("gm_t_executor:"), new ThreadPoolExecutor.DiscardOldestPolicy() { // from class: com.byazt.rb.l.2
            @Override // java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy, java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                super.rejectedExecution(runnable, threadPoolExecutor);
                com.byazt.gi.n.n().s();
            }
        });
        try {
            qVar.allowCoreThreadTimeOut(true);
        } catch (Exception e) {
            k.n("ThreadHelper", "stackerror:", e);
        } catch (NoSuchMethodError unused) {
        }
        return qVar;
    }

    public static Executor w() {
        return rv;
    }

    private static Executor rv() {
        return new com.byazt.xis.q(2, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), n("gm_t_log_upload:"), new ThreadPoolExecutor.DiscardPolicy());
    }

    public static void q(Runnable runnable) {
        n(rv, runnable);
    }

    private static boolean n(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
            return true;
        } catch (Throwable th) {
            k.n("ThreadHelper", "stackerror:", th);
            return false;
        }
    }
}

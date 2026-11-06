package com.byazt.fyy;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.byazt.vx.w;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1740, 19})
public final class n {
    public static volatile n n;
    public volatile ThreadPoolExecutor qg = null;
    public final Handler s;

    private n() {
        HandlerThread handlerThread = new HandlerThread("csj_api_main");
        handlerThread.start();
        this.s = new Handler(handlerThread.getLooper());
    }

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                n = new n();
            }
        }
        return n;
    }

    public Handler qg() {
        return this.s;
    }

    public Handler s() {
        return new Handler(Looper.getMainLooper());
    }

    public void n(Runnable runnable) {
        if (runnable != null) {
            try {
                this.s.post(runnable);
            } catch (Throwable th) {
                w.n(th);
            }
        }
    }

    public ExecutorService q() {
        if (this.qg == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, Integer.MAX_VALUE, 1000L, TimeUnit.MILLISECONDS, new SynchronousQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            this.qg = threadPoolExecutor;
        }
        return this.qg;
    }
}

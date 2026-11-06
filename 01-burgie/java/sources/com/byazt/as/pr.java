package com.byazt.as;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.byazt.dea.uc;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2308, 37})
public final class pr {
    public static volatile pr pr;
    public final Handler hn;
    public volatile ThreadPoolExecutor hw = null;

    private pr() {
        HandlerThread handlerThread = new HandlerThread("csj_api_main");
        handlerThread.start();
        this.hn = new Handler(handlerThread.getLooper());
    }

    public static pr pr() {
        if (pr == null) {
            synchronized (pr.class) {
                pr = new pr();
            }
        }
        return pr;
    }

    public Handler hw() {
        return this.hn;
    }

    public Handler hn() {
        return new Handler(Looper.getMainLooper());
    }

    public void pr(Runnable runnable) {
        if (runnable != null) {
            try {
                this.hn.post(runnable);
            } catch (Throwable th) {
                uc.pr(th);
            }
        }
    }

    public ExecutorService x() {
        if (this.hw == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, Integer.MAX_VALUE, 1000L, TimeUnit.MILLISECONDS, new SynchronousQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            this.hw = threadPoolExecutor;
        }
        return this.hw;
    }
}

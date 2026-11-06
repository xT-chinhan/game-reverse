package com.bytedance.sdk.openadsdk.qv;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.openadsdk.api.ab;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ms f4081ms;
    private final Handler ah;
    private volatile ThreadPoolExecutor xr = null;

    private ms() {
        HandlerThread handlerThread = new HandlerThread("csj_api_main");
        handlerThread.start();
        this.ah = new Handler(handlerThread.getLooper());
    }

    public static ms ms() {
        if (f4081ms == null) {
            synchronized (ms.class) {
                f4081ms = new ms();
            }
        }
        return f4081ms;
    }

    public Handler xr() {
        return this.ah;
    }

    public void ms(Runnable runnable) {
        if (runnable != null) {
            try {
                this.ah.post(runnable);
            } catch (Throwable th) {
                ab.ms(th);
            }
        }
    }

    public void ms(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor != null) {
            if (this.xr != null) {
                com.ss.android.socialbase.downloader.ah.ms.xr("ApiThread", "setPluginExecutor: 释放掉api层的线程池");
                ms(threadPoolExecutor, this.xr);
            }
            this.xr = threadPoolExecutor;
        }
    }

    public ExecutorService ah() {
        if (this.xr == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, Integer.MAX_VALUE, 1000L, TimeUnit.MILLISECONDS, new SynchronousQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            this.xr = threadPoolExecutor;
        }
        return this.xr;
    }

    private void ms(ExecutorService executorService, final ThreadPoolExecutor threadPoolExecutor) {
        executorService.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.qv.ms.1
            @Override // java.lang.Runnable
            public void run() {
                ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                if (threadPoolExecutor2 == null) {
                    return;
                }
                try {
                    threadPoolExecutor2.setKeepAliveTime(1L, TimeUnit.MILLISECONDS);
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    while (true) {
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException unused) {
                        }
                        if (threadPoolExecutor.getQueue().size() <= 0 && threadPoolExecutor.getActiveCount() == 0) {
                            threadPoolExecutor.shutdown();
                            return;
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        });
    }
}

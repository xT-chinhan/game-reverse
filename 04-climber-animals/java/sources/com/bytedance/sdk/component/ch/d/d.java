package com.bytedance.sdk.component.ch.d;

import com.bytedance.sdk.component.ch.hi;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ms {
    @Override // com.bytedance.sdk.component.ch.d.ms, java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public void allowCoreThreadTimeOut(boolean z) {
    }

    public d(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, new com.bytedance.sdk.component.ch.ms.ms(blockingQueue), new com.bytedance.sdk.component.ch.ms.d(threadFactory, 2));
        ms();
    }

    public d(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, new com.bytedance.sdk.component.ch.ms.ms(blockingQueue), new com.bytedance.sdk.component.ch.ms.d(threadFactory, 2), rejectedExecutionHandler);
        ms();
    }

    private void ms() {
        if (hi.xr.ka()) {
            if (!allowsCoreThreadTimeOut()) {
                setKeepAliveTime(ms(20L), TimeUnit.SECONDS);
                try {
                    super.allowCoreThreadTimeOut(true);
                } catch (Throwable unused) {
                }
            }
            com.bytedance.sdk.component.ch.d.f1203ms.ms(this);
        }
    }

    @Override // com.bytedance.sdk.component.ch.d.ms, java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.bytedance.sdk.component.ch.ms.d(threadFactory, 2));
    }

    @Override // com.bytedance.sdk.component.ch.d.ms, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.ch.xr
    public void shutdown() {
        super.shutdown();
        com.bytedance.sdk.component.ch.d.f1203ms.xr(this);
    }

    @Override // com.bytedance.sdk.component.ch.d.ms, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.ch.xr
    public List shutdownNow() {
        com.bytedance.sdk.component.ch.d.f1203ms.xr(this);
        return super.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void finalize() {
        super.finalize();
        shutdown();
        com.bytedance.sdk.component.ch.d.f1203ms.xr(this);
    }

    private ExecutorService xr() {
        return com.bytedance.sdk.component.ch.d.f1203ms.ms("PThreadPoolExecutor", com.bytedance.sdk.component.ch.d.f1203ms.ms(getQueue()));
    }

    @Override // com.bytedance.sdk.component.ch.d.ms, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.ch.xr
    public <T> Future<T> submit(Callable<T> callable) {
        if (hi.xr.ka()) {
            try {
                return super.submit(callable);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceXr = xr();
                if (executorServiceXr != null) {
                    return executorServiceXr.submit(callable);
                }
                throw e;
            }
        }
        return super.submit(callable);
    }

    @Override // com.bytedance.sdk.component.ch.d.ms, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.ch.xr
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (hi.xr.ka()) {
            try {
                return super.submit(runnable, t);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceXr = xr();
                if (executorServiceXr != null) {
                    return executorServiceXr.submit(runnable, t);
                }
                throw e;
            }
        }
        return super.submit(runnable, t);
    }

    @Override // com.bytedance.sdk.component.ch.d.ms, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.ch.xr
    public Future submit(Runnable runnable) {
        if (hi.xr.ka()) {
            try {
                return super.submit(runnable);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceXr = xr();
                if (executorServiceXr != null) {
                    return executorServiceXr.submit(runnable);
                }
                throw e;
            }
        }
        return super.submit(runnable);
    }

    @Override // com.bytedance.sdk.component.ch.d.ms, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.bytedance.sdk.component.ch.xr
    public void execute(Runnable runnable) {
        if (hi.xr.ka()) {
            try {
                super.execute(runnable);
                return;
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceXr = xr();
                if (executorServiceXr != null) {
                    executorServiceXr.execute(runnable);
                    return;
                }
                throw e;
            }
        }
        super.execute(runnable);
    }

    private long ms(long j) {
        long jMin = Math.min(j, getKeepAliveTime(TimeUnit.SECONDS));
        if (jMin > 1) {
            return jMin;
        }
        return 1L;
    }
}

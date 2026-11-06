package com.byazt.fr;

import com.byazt.xlm.aj;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 443, 121})
public class x extends pr {
    public x(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, new com.byazt.rj.pr(blockingQueue), new com.byazt.rj.x(threadFactory, 2));
        pr();
    }

    public x(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, new com.byazt.rj.pr(blockingQueue), new com.byazt.rj.x(threadFactory, 2), rejectedExecutionHandler);
        pr();
    }

    private void pr() {
        if (aj.hw.c()) {
            if (!allowsCoreThreadTimeOut()) {
                setKeepAliveTime(pr(20L), TimeUnit.SECONDS);
                try {
                    super.allowCoreThreadTimeOut(true);
                } catch (Throwable th) {
                }
            }
            com.byazt.xlm.hn.pr.pr(this);
        }
    }

    @Override // com.byazt.fr.pr, java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.byazt.rj.x(threadFactory, 2));
    }

    @Override // com.byazt.fr.pr, java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public void allowCoreThreadTimeOut(boolean z) {
    }

    private ExecutorService hw() {
        return com.byazt.xlm.hn.pr.pr("PThreadPoolExecutor", com.byazt.xlm.hn.pr.pr(getQueue()));
    }

    @Override // com.byazt.fr.pr, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.byazt.xlm.pr
    public <T> Future<T> submit(Callable<T> callable) {
        if (aj.hw.c()) {
            try {
                return super.submit(callable);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceHw = hw();
                if (executorServiceHw != null) {
                    return executorServiceHw.submit(callable);
                }
                throw e;
            }
        }
        return super.submit(callable);
    }

    @Override // com.byazt.fr.pr, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.byazt.xlm.pr
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (aj.hw.c()) {
            try {
                return super.submit(runnable, t);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceHw = hw();
                if (executorServiceHw != null) {
                    return executorServiceHw.submit(runnable, t);
                }
                throw e;
            }
        }
        return super.submit(runnable, t);
    }

    @Override // com.byazt.fr.pr, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.byazt.xlm.pr
    public Future submit(Runnable runnable) {
        if (aj.hw.c()) {
            try {
                return super.submit(runnable);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceHw = hw();
                if (executorServiceHw != null) {
                    return executorServiceHw.submit(runnable);
                }
                throw e;
            }
        }
        return super.submit(runnable);
    }

    @Override // com.byazt.fr.pr, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.byazt.xlm.pr
    public void execute(Runnable runnable) {
        if (aj.hw.c()) {
            try {
                super.execute(runnable);
                return;
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceHw = hw();
                if (executorServiceHw != null) {
                    executorServiceHw.execute(runnable);
                    return;
                }
                throw e;
            }
        }
        super.execute(runnable);
    }

    private long pr(long j) {
        long jMin = Math.min(j, getKeepAliveTime(TimeUnit.SECONDS));
        if (jMin > 1) {
            return jMin;
        }
        return 1L;
    }
}

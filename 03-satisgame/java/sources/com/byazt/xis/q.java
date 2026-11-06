package com.byazt.xis;

import com.byazt.qit.rv;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 589, 5})
public class q extends n {
    @Override // com.byazt.xis.n, java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public void allowCoreThreadTimeOut(boolean z) {
    }

    public q(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, new com.byazt.ncu.n(blockingQueue), new com.byazt.ncu.q(threadFactory, 2));
        n();
    }

    public q(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, new com.byazt.ncu.n(blockingQueue), new com.byazt.ncu.q(threadFactory, 2), rejectedExecutionHandler);
        n();
    }

    private void n() {
        if (rv.qg.l()) {
            if (!allowsCoreThreadTimeOut()) {
                setKeepAliveTime(n(20L), TimeUnit.SECONDS);
                try {
                    super.allowCoreThreadTimeOut(true);
                } catch (Throwable unused) {
                }
            }
            com.byazt.qit.s.n.n(this);
        }
    }

    @Override // com.byazt.xis.n, java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.byazt.ncu.q(threadFactory, 2));
    }

    private ExecutorService qg() {
        return com.byazt.qit.s.n.n("PThreadPoolExecutor", com.byazt.qit.s.n.n(getQueue()));
    }

    @Override // com.byazt.xis.n, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.byazt.qit.n
    public <T> Future<T> submit(Callable<T> callable) {
        if (rv.qg.l()) {
            try {
                return super.submit(callable);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceQg = qg();
                if (executorServiceQg != null) {
                    return executorServiceQg.submit(callable);
                }
                throw e;
            }
        }
        return super.submit(callable);
    }

    @Override // com.byazt.xis.n, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.byazt.qit.n
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (rv.qg.l()) {
            try {
                return super.submit(runnable, t);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceQg = qg();
                if (executorServiceQg != null) {
                    return executorServiceQg.submit(runnable, t);
                }
                throw e;
            }
        }
        return super.submit(runnable, t);
    }

    @Override // com.byazt.xis.n, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.byazt.qit.n
    public Future submit(Runnable runnable) {
        if (rv.qg.l()) {
            try {
                return super.submit(runnable);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceQg = qg();
                if (executorServiceQg != null) {
                    return executorServiceQg.submit(runnable);
                }
                throw e;
            }
        }
        return super.submit(runnable);
    }

    @Override // com.byazt.xis.n, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.byazt.qit.n
    public void execute(Runnable runnable) {
        if (rv.qg.l()) {
            try {
                super.execute(runnable);
                return;
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceQg = qg();
                if (executorServiceQg != null) {
                    executorServiceQg.execute(runnable);
                    return;
                }
                throw e;
            }
        }
        super.execute(runnable);
    }

    private long n(long j) {
        long jMin = Math.min(j, getKeepAliveTime(TimeUnit.SECONDS));
        if (jMin > 1) {
            return jMin;
        }
        return 1L;
    }
}

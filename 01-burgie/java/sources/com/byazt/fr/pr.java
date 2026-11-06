package com.byazt.fr;

import com.byazt.rj.uc;
import com.byazt.xlm.aj;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 443, 37})
public class pr extends ThreadPoolExecutor implements com.byazt.xlm.pr {
    public static final RejectedExecutionHandler pr = new RejectedExecutionHandler() { // from class: com.byazt.fr.pr.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (threadPoolExecutor != null && (threadPoolExecutor instanceof ScheduledThreadPoolExecutor) && threadPoolExecutor.getCorePoolSize() == 1) {
                ScheduledExecutorService scheduledExecutorServiceK = aj.hw.k();
                if (scheduledExecutorServiceK.isShutdown() || scheduledExecutorServiceK.isTerminated()) {
                    aj.hw.aj().execute(runnable);
                } else {
                    scheduledExecutorServiceK.execute(runnable);
                }
            } else {
                aj.hw.aj().execute(runnable);
            }
            aj.hw.fw();
        }
    };
    public com.byazt.xlm.pr hw;

    public pr(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, pr);
    }

    public pr(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.hw = new uc(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler, this);
        aj.hw.fw();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.byazt.xlm.pr
    public void execute(Runnable runnable) {
        this.hw.execute(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.byazt.xlm.pr
    public Future<?> submit(Runnable runnable) {
        return this.hw.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.byazt.xlm.pr
    public <T> Future<T> submit(Callable<T> callable) {
        return this.hw.submit(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.byazt.xlm.pr
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.hw.submit(runnable, t);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.byazt.xlm.pr
    public void shutdown() {
        com.byazt.xlm.pr prVar = this.hw;
        if (prVar != null) {
            prVar.shutdown();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.byazt.xlm.pr
    public List<Runnable> shutdownNow() {
        return this.hw.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.byazt.xlm.pr
    public boolean isShutdown() {
        return this.hw.isShutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public boolean isTerminating() {
        return this.hw.isTerminating();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.byazt.xlm.pr
    public boolean isTerminated() {
        return this.hw.isTerminated();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.byazt.xlm.pr
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.hw.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public void setThreadFactory(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException();
        }
        this.hw.setThreadFactory(threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public ThreadFactory getThreadFactory() {
        return this.hw.getThreadFactory();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        this.hw.setRejectedExecutionHandler(rejectedExecutionHandler);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.hw.getRejectedExecutionHandler();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public void setCorePoolSize(int i) {
        this.hw.setCorePoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public int getCorePoolSize() {
        return this.hw.getCorePoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public boolean prestartCoreThread() {
        return this.hw.prestartCoreThread();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public int prestartAllCoreThreads() {
        return this.hw.prestartAllCoreThreads();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public boolean allowsCoreThreadTimeOut() {
        return this.hw.allowsCoreThreadTimeOut();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public void allowCoreThreadTimeOut(boolean z) {
        this.hw.allowCoreThreadTimeOut(z);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public void setMaximumPoolSize(int i) {
        this.hw.setMaximumPoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public int getMaximumPoolSize() {
        return this.hw.getMaximumPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        this.hw.setKeepAliveTime(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return this.hw.getKeepAliveTime(timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public BlockingQueue<Runnable> getQueue() {
        return this.hw.getQueue();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public boolean remove(Runnable runnable) {
        return this.hw.remove(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public void purge() {
        this.hw.purge();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public int getPoolSize() {
        return this.hw.getPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public int getActiveCount() {
        return this.hw.getActiveCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public int getLargestPoolSize() {
        return this.hw.getLargestPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public long getTaskCount() {
        return this.hw.getTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public long getCompletedTaskCount() {
        return this.hw.getCompletedTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void finalize() {
        com.byazt.xlm.pr prVar = this.hw;
        if (prVar instanceof uc) {
            ((uc) prVar).hn();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.xlm.pr
    public String toString() {
        com.byazt.xlm.pr prVar = this.hw;
        if (prVar != null) {
            return prVar.toString();
        }
        return super.toString();
    }
}

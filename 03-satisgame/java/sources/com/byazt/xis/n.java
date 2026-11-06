package com.byazt.xis;

import com.byazt.ncu.w;
import com.byazt.qit.rv;
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

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 589, 19})
public class n extends ThreadPoolExecutor implements com.byazt.qit.n {
    public static final RejectedExecutionHandler n = new RejectedExecutionHandler() { // from class: com.byazt.xis.n.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (threadPoolExecutor != null && (threadPoolExecutor instanceof ScheduledThreadPoolExecutor) && threadPoolExecutor.getCorePoolSize() == 1) {
                ScheduledExecutorService scheduledExecutorServiceOa = rv.qg.oa();
                if (scheduledExecutorServiceOa.isShutdown() || scheduledExecutorServiceOa.isTerminated()) {
                    rv.qg.rv().execute(runnable);
                } else {
                    scheduledExecutorServiceOa.execute(runnable);
                }
            } else {
                rv.qg.rv().execute(runnable);
            }
            rv.qg.x();
        }
    };
    public com.byazt.qit.n qg;

    public n(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, n);
    }

    public n(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.qg = new w(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler, this);
        rv.qg.x();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.byazt.qit.n
    public void execute(Runnable runnable) {
        this.qg.execute(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.byazt.qit.n
    public Future<?> submit(Runnable runnable) {
        return this.qg.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.byazt.qit.n
    public <T> Future<T> submit(Callable<T> callable) {
        return this.qg.submit(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.byazt.qit.n
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.qg.submit(runnable, t);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.byazt.qit.n
    public void shutdown() {
        com.byazt.qit.n nVar = this.qg;
        if (nVar != null) {
            nVar.shutdown();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.byazt.qit.n
    public List<Runnable> shutdownNow() {
        return this.qg.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.byazt.qit.n
    public boolean isShutdown() {
        return this.qg.isShutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public boolean isTerminating() {
        return this.qg.isTerminating();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.byazt.qit.n
    public boolean isTerminated() {
        return this.qg.isTerminated();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.byazt.qit.n
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.qg.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public void setThreadFactory(ThreadFactory threadFactory) {
        threadFactory.getClass();
        this.qg.setThreadFactory(threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public ThreadFactory getThreadFactory() {
        return this.qg.getThreadFactory();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        this.qg.setRejectedExecutionHandler(rejectedExecutionHandler);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.qg.getRejectedExecutionHandler();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public void setCorePoolSize(int i) {
        this.qg.setCorePoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public int getCorePoolSize() {
        return this.qg.getCorePoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public boolean prestartCoreThread() {
        return this.qg.prestartCoreThread();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public int prestartAllCoreThreads() {
        return this.qg.prestartAllCoreThreads();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public boolean allowsCoreThreadTimeOut() {
        return this.qg.allowsCoreThreadTimeOut();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public void allowCoreThreadTimeOut(boolean z) {
        this.qg.allowCoreThreadTimeOut(z);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public void setMaximumPoolSize(int i) {
        this.qg.setMaximumPoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public int getMaximumPoolSize() {
        return this.qg.getMaximumPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        this.qg.setKeepAliveTime(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return this.qg.getKeepAliveTime(timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public BlockingQueue<Runnable> getQueue() {
        return this.qg.getQueue();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public boolean remove(Runnable runnable) {
        return this.qg.remove(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public void purge() {
        this.qg.purge();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public int getPoolSize() {
        return this.qg.getPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public int getActiveCount() {
        return this.qg.getActiveCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public int getLargestPoolSize() {
        return this.qg.getLargestPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public long getTaskCount() {
        return this.qg.getTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public long getCompletedTaskCount() {
        return this.qg.getCompletedTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void finalize() {
        com.byazt.qit.n nVar = this.qg;
        if (nVar instanceof w) {
            ((w) nVar).s();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.qit.n
    public String toString() {
        com.byazt.qit.n nVar = this.qg;
        if (nVar != null) {
            return nVar.toString();
        }
        return super.toString();
    }
}

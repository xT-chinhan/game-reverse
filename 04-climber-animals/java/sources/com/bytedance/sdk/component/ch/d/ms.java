package com.bytedance.sdk.component.ch.d;

import com.bytedance.sdk.component.ch.hi;
import com.bytedance.sdk.component.ch.ms.c;
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
public class ms extends ThreadPoolExecutor implements com.bytedance.sdk.component.ch.xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final RejectedExecutionHandler f1214ms = new RejectedExecutionHandler() { // from class: com.bytedance.sdk.component.ch.d.ms.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (threadPoolExecutor != null && (threadPoolExecutor instanceof ScheduledThreadPoolExecutor) && threadPoolExecutor.getCorePoolSize() == 1) {
                ScheduledExecutorService scheduledExecutorServiceSl = hi.xr.sl();
                if (scheduledExecutorServiceSl.isShutdown() || scheduledExecutorServiceSl.isTerminated()) {
                    hi.xr.ny().execute(runnable);
                } else {
                    scheduledExecutorServiceSl.execute(runnable);
                }
            } else {
                hi.xr.ny().execute(runnable);
            }
            hi.xr.ab();
        }
    };
    private com.bytedance.sdk.component.ch.xr xr;

    public ms(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, f1214ms);
    }

    public ms(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.xr = new c(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler, this);
        hi.xr.ab();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.bytedance.sdk.component.ch.xr
    public void execute(Runnable runnable) {
        this.xr.execute(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.ch.xr
    public Future<?> submit(Runnable runnable) {
        return this.xr.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.ch.xr
    public <T> Future<T> submit(Callable<T> callable) {
        return this.xr.submit(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.ch.xr
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.xr.submit(runnable, t);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.ch.xr
    public void shutdown() {
        this.xr.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.ch.xr
    public List<Runnable> shutdownNow() {
        return this.xr.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.ch.xr
    public boolean isShutdown() {
        return this.xr.isShutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public boolean isTerminating() {
        return this.xr.isTerminating();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.ch.xr
    public boolean isTerminated() {
        return this.xr.isTerminated();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.ch.xr
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.xr.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public void setThreadFactory(ThreadFactory threadFactory) {
        threadFactory.getClass();
        this.xr.setThreadFactory(threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public ThreadFactory getThreadFactory() {
        return this.xr.getThreadFactory();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        this.xr.setRejectedExecutionHandler(rejectedExecutionHandler);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.xr.getRejectedExecutionHandler();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public void setCorePoolSize(int i) {
        this.xr.setCorePoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public int getCorePoolSize() {
        return this.xr.getCorePoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public boolean prestartCoreThread() {
        return this.xr.prestartCoreThread();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public int prestartAllCoreThreads() {
        return this.xr.prestartAllCoreThreads();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public boolean allowsCoreThreadTimeOut() {
        return this.xr.allowsCoreThreadTimeOut();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public void allowCoreThreadTimeOut(boolean z) {
        this.xr.allowCoreThreadTimeOut(z);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public void setMaximumPoolSize(int i) {
        this.xr.setMaximumPoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public int getMaximumPoolSize() {
        return this.xr.getMaximumPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        this.xr.setKeepAliveTime(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return this.xr.getKeepAliveTime(timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public BlockingQueue<Runnable> getQueue() {
        return this.xr.getQueue();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public boolean remove(Runnable runnable) {
        return this.xr.remove(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public void purge() {
        this.xr.purge();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public int getPoolSize() {
        return this.xr.getPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public int getActiveCount() {
        return this.xr.getActiveCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public int getLargestPoolSize() {
        return this.xr.getLargestPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public long getTaskCount() {
        return this.xr.getTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public long getCompletedTaskCount() {
        return this.xr.getCompletedTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.ch.xr
    public String toString() {
        com.bytedance.sdk.component.ch.xr xrVar = this.xr;
        if (xrVar != null) {
            return xrVar.toString();
        }
        return super.toString();
    }
}

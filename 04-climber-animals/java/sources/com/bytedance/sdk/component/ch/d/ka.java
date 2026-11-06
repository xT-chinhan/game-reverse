package com.bytedance.sdk.component.ch.d;

import com.bytedance.sdk.component.ch.hi;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends ScheduledThreadPoolExecutor {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ConcurrentHashMap f1209ms;

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void allowCoreThreadTimeOut(boolean z) {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
    }

    public ka(int i, ThreadFactory threadFactory) {
        super(i, new com.bytedance.sdk.component.ch.ms.d(threadFactory, 8));
        this.f1209ms = new ConcurrentHashMap();
        ms();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.bytedance.sdk.component.ch.ms.d(threadFactory, 8));
    }

    private void ms() {
        if (!hi.xr.ka() || allowsCoreThreadTimeOut()) {
            return;
        }
        super.setKeepAliveTime(Math.max(10L, getKeepAliveTime(TimeUnit.SECONDS)), TimeUnit.SECONDS);
        super.allowCoreThreadTimeOut(true);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Runnable runnable, final long j, final TimeUnit timeUnit) {
        if (hi.xr.ka()) {
            try {
                ScheduledFuture<?> scheduledFutureSchedule = super.schedule(runnable, j, timeUnit);
                this.f1209ms.remove(runnable);
                return scheduledFutureSchedule;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.ch.d.f1203ms.ms("PThreadScheduledThreadPoolExecutor");
                hi.xr.sl().schedule(new Runnable() { // from class: com.bytedance.sdk.component.ch.d.ka.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ka.super.schedule(runnable, j, timeUnit);
                        ka.this.f1209ms.remove(runnable);
                    }
                }, hi.xr.d(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.f1209ms.get(runnable);
            }
        }
        return super.schedule(runnable, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(final Runnable runnable, final long j, final long j2, final TimeUnit timeUnit) {
        if (hi.xr.ka()) {
            try {
                ScheduledFuture<?> scheduledFutureScheduleAtFixedRate = super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
                this.f1209ms.remove(runnable);
                return scheduledFutureScheduleAtFixedRate;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.ch.d.f1203ms.ms("PThreadScheduledThreadPoolExecutor");
                hi.xr.sl().schedule(new Runnable() { // from class: com.bytedance.sdk.component.ch.d.ka.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ka.super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
                        ka.this.f1209ms.remove(runnable);
                    }
                }, hi.xr.d(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.f1209ms.get(runnable);
            }
        }
        return super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(final Runnable runnable, final long j, final long j2, final TimeUnit timeUnit) {
        if (hi.xr.ka()) {
            try {
                ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay = super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
                this.f1209ms.remove(runnable);
                return scheduledFutureScheduleWithFixedDelay;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.ch.d.f1203ms.ms("PThreadScheduledThreadPoolExecutor");
                hi.xr.sl().schedule(new Runnable() { // from class: com.bytedance.sdk.component.ch.d.ka.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ka.super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
                        ka.this.f1209ms.remove(runnable);
                    }
                }, hi.xr.d(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.f1209ms.get(runnable);
            }
        }
        return super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Callable callable, final long j, final TimeUnit timeUnit) {
        if (hi.xr.ka()) {
            try {
                ScheduledFuture scheduledFutureSchedule = super.schedule(callable, j, timeUnit);
                this.f1209ms.remove(callable);
                return scheduledFutureSchedule;
            } catch (OutOfMemoryError unused) {
                com.bytedance.sdk.component.ch.d.f1203ms.ms("PThreadScheduledThreadPoolExecutor");
                hi.xr.sl().schedule(new Runnable() { // from class: com.bytedance.sdk.component.ch.d.ka.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ka.super.schedule(callable, j, timeUnit);
                        ka.this.f1209ms.remove(callable);
                    }
                }, hi.xr.d(), TimeUnit.MILLISECONDS);
                return (ScheduledFuture) this.f1209ms.get(callable);
            }
        }
        return super.schedule(callable, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected RunnableScheduledFuture decorateTask(Runnable runnable, RunnableScheduledFuture runnableScheduledFuture) {
        if (hi.xr.ka()) {
            RunnableScheduledFuture runnableScheduledFuture2 = (RunnableScheduledFuture) this.f1209ms.get(runnable);
            if (runnableScheduledFuture2 != null) {
                return runnableScheduledFuture2;
            }
            RunnableScheduledFuture runnableScheduledFutureDecorateTask = super.decorateTask(runnable, runnableScheduledFuture);
            this.f1209ms.put(runnable, runnableScheduledFutureDecorateTask);
            return runnableScheduledFutureDecorateTask;
        }
        return super.decorateTask(runnable, runnableScheduledFuture);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor
    protected RunnableScheduledFuture decorateTask(Callable callable, RunnableScheduledFuture runnableScheduledFuture) {
        if (hi.xr.ka()) {
            RunnableScheduledFuture runnableScheduledFuture2 = (RunnableScheduledFuture) this.f1209ms.get(callable);
            if (runnableScheduledFuture2 != null) {
                return runnableScheduledFuture2;
            }
            RunnableScheduledFuture runnableScheduledFutureDecorateTask = super.decorateTask(callable, runnableScheduledFuture);
            this.f1209ms.put(callable, runnableScheduledFutureDecorateTask);
            return runnableScheduledFutureDecorateTask;
        }
        return super.decorateTask(callable, runnableScheduledFuture);
    }
}

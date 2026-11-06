package com.byazt.xis;

import com.byazt.qit.rv;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 589, 18})
public class l extends ScheduledThreadPoolExecutor {
    @Override // java.util.concurrent.ThreadPoolExecutor
    public void allowCoreThreadTimeOut(boolean z) {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
    }

    public l(int i, ThreadFactory threadFactory) {
        super(i, new com.byazt.ncu.q(threadFactory, 8));
        n();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.byazt.ncu.q(threadFactory, 8));
    }

    private void n() {
        if (!rv.qg.l() || allowsCoreThreadTimeOut()) {
            return;
        }
        super.setKeepAliveTime(Math.max(10L, getKeepAliveTime(TimeUnit.SECONDS)), TimeUnit.SECONDS);
        super.allowCoreThreadTimeOut(true);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        if (rv.qg.l()) {
            try {
                return super.schedule(runnable, j, timeUnit);
            } catch (OutOfMemoryError unused) {
                return rv.qg.oa().schedule(runnable, j, timeUnit);
            }
        }
        return super.schedule(runnable, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        if (rv.qg.l()) {
            try {
                return super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
            } catch (OutOfMemoryError unused) {
                return rv.qg.oa().scheduleAtFixedRate(runnable, j, j2, timeUnit);
            }
        }
        return super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        if (rv.qg.l()) {
            try {
                return super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
            } catch (OutOfMemoryError unused) {
                return rv.qg.oa().scheduleWithFixedDelay(runnable, j, j2, timeUnit);
            }
        }
        return super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        if (rv.qg.l()) {
            try {
                return super.schedule(callable, j, timeUnit);
            } catch (OutOfMemoryError unused) {
                return rv.qg.oa().schedule(callable, j, timeUnit);
            }
        }
        return super.schedule(callable, j, timeUnit);
    }
}

package com.bytedance.sdk.component.ch.ah;

import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.hi;
import com.bytedance.sdk.component.utils.sl;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ScheduledFuture<?> f1199ms;

    @Override // com.bytedance.sdk.component.ch.ah.ms
    protected int xr() {
        return 2;
    }

    public d(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (ab.ka()) {
            ka();
        }
    }

    private void ka() {
        BlockingQueue queue = getQueue();
        int iX = hi.xr.x();
        if (getCorePoolSize() == iX || queue == null || queue.size() != 0) {
            return;
        }
        setCorePoolSize(iX);
    }

    private boolean c() {
        BlockingQueue queue = getQueue();
        int corePoolSize = getCorePoolSize();
        int i = corePoolSize * 2;
        int iMin = Math.min(corePoolSize + 4, ab.f1196ms);
        if (corePoolSize >= iMin || queue == null || queue.size() < i) {
            return false;
        }
        try {
            setCorePoolSize(iMin);
            return true;
        } catch (Exception e) {
            sl.ms("BizCoreThreadPool", e.getMessage());
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.ch.ah.ms
    protected void ms(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        boolean zOffer;
        super.ms(runnable, outOfMemoryError);
        boolean z = false;
        if (runnable != null) {
            try {
                zOffer = getQueue().offer(runnable);
            } catch (Throwable unused) {
                zOffer = z;
            }
        } else {
            zOffer = true;
            try {
                ab.ms(false);
            } catch (Throwable unused2) {
                z = zOffer;
                zOffer = z;
            }
        }
        allowCoreThreadTimeOut(false);
        if (!zOffer) {
            throw outOfMemoryError;
        }
    }

    @Override // com.bytedance.sdk.component.ch.ah.ms
    public boolean ms() {
        BlockingQueue queue = getQueue();
        return queue != null && queue.size() > getCorePoolSize() * 2;
    }

    @Override // com.bytedance.sdk.component.ch.ah.ms, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (ab.ka()) {
            c();
        }
        super.execute(runnable);
    }

    public void ah() {
        ScheduledFuture<?> scheduledFuture = this.f1199ms;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public static boolean d() {
        ThreadPoolExecutor threadPoolExecutorNy = hi.xr.ny();
        if (threadPoolExecutorNy.getQueue().size() != 0 || threadPoolExecutorNy.isShutdown() || threadPoolExecutorNy.isTerminated()) {
            return false;
        }
        int activeCount = threadPoolExecutorNy.getActiveCount();
        int corePoolSize = threadPoolExecutorNy.getCorePoolSize();
        return activeCount < corePoolSize + (-1) && com.bytedance.sdk.component.ch.ms.ah.f1222ms.get() < corePoolSize / 2;
    }
}

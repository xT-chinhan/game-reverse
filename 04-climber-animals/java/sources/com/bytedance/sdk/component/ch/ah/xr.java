package com.bytedance.sdk.component.ch.ah;

import com.bytedance.sdk.component.ch.hi;
import com.bytedance.sdk.component.utils.sl;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private AtomicInteger f1200ms;

    @Override // com.bytedance.sdk.component.ch.ah.ms
    protected int xr() {
        return 1;
    }

    public xr(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, new SynchronousQueue(), threadFactory);
        this.f1200ms = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        Runnable runnablePoll;
        super.afterExecute(runnable, th);
        BlockingQueue<Runnable> queue = hi.xr.ny().getQueue();
        if (queue.size() == 0) {
            return;
        }
        int maximumPoolSize = getMaximumPoolSize();
        if (this.f1200ms.get() >= Math.max(getCorePoolSize(), maximumPoolSize / 4)) {
            return;
        }
        try {
            this.f1200ms.getAndIncrement();
            int activeCount = getActiveCount();
            while (activeCount < maximumPoolSize / 2 && !isShutdown() && !isTerminated() && !isTerminating() && (runnablePoll = queue.poll()) != null) {
                if (runnablePoll instanceof com.bytedance.sdk.component.ch.ms.ah) {
                    com.bytedance.sdk.component.ch.ms.ah ahVar = (com.bytedance.sdk.component.ch.ms.ah) runnablePoll;
                    ahVar.ms(xr());
                    ahVar.xr();
                }
                runnablePoll.run();
                activeCount = getActiveCount();
            }
        } finally {
            this.f1200ms.getAndDecrement();
        }
    }

    @Override // com.bytedance.sdk.component.ch.ah.ms
    protected void ms(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        super.ms(runnable, outOfMemoryError);
        if (runnable != null) {
            if (runnable instanceof com.bytedance.sdk.component.ch.ms.ah) {
                ((com.bytedance.sdk.component.ch.ms.ah) runnable).ms(false);
            } else {
                runnable = new ah(runnable);
            }
            hi.xr.ny().execute(runnable);
        }
        try {
            allowCoreThreadTimeOut(false);
        } catch (Exception e) {
            sl.ah("BigThreadPool", e);
        }
    }

    @Override // com.bytedance.sdk.component.ch.ah.ms
    public boolean ms() {
        return getActiveCount() >= getMaximumPoolSize();
    }

    @Override // com.bytedance.sdk.component.ch.ah.ms, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable instanceof ah) {
            super.execute(runnable);
            return;
        }
        if (ms(runnable)) {
            return;
        }
        if (ms()) {
            if (runnable instanceof com.bytedance.sdk.component.ch.ms.ah) {
                ((com.bytedance.sdk.component.ch.ms.ah) runnable).ms(false);
            } else {
                runnable = new ah(runnable);
            }
            hi.xr.ny().execute(runnable);
            return;
        }
        super.execute(runnable);
    }

    private boolean ms(Runnable runnable) {
        com.bytedance.sdk.component.ch.ms.ah ahVar;
        if (!d.d()) {
            return false;
        }
        if (runnable instanceof com.bytedance.sdk.component.ch.ms.ah) {
            ahVar = (com.bytedance.sdk.component.ch.ms.ah) runnable;
            if (!ahVar.ah()) {
                return false;
            }
        } else {
            ahVar = new ah(runnable);
        }
        com.bytedance.sdk.component.ch.ms.ah.f1222ms.incrementAndGet();
        ahVar.ms(false);
        hi.xr.ny().execute(ahVar);
        return true;
    }
}

package com.bytedance.sdk.component.ch.ah;

import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.hi;
import com.bytedance.sdk.component.utils.sl;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms extends ThreadPoolExecutor {
    public boolean ms() {
        return false;
    }

    protected int xr() {
        return 0;
    }

    public ms(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, com.bytedance.sdk.component.ch.d.ms.f1214ms);
    }

    public ms(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
    }

    private void ms(Runnable runnable) {
        com.bytedance.sdk.component.ch.ms.ah ahVar;
        try {
            if (runnable instanceof com.bytedance.sdk.component.ch.ms.ah) {
                ahVar = (com.bytedance.sdk.component.ch.ms.ah) runnable;
            } else {
                ahVar = new com.bytedance.sdk.component.ch.ms.ah(runnable);
            }
            ahVar.xr();
            if (hi.xr.u()) {
                if (!(getCorePoolSize() > getActiveCount() && getQueue().size() <= 0)) {
                    sl.xr("BaseThreadPool", "crashing drop task :".concat(String.valueOf(runnable)));
                    ahVar.ms(3);
                    hi.xr.sl().submit(ahVar);
                    return;
                }
            }
            ahVar.ms(xr());
            super.execute(ahVar);
        } catch (OutOfMemoryError e) {
            if (hi.xr.xr()) {
                ab.ms(false);
            }
            ms(runnable, e);
            hi hiVar = hi.xr;
        }
    }

    protected void ms(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        com.bytedance.sdk.component.ch.ms.ah.xr = true;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        ms(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setCorePoolSize(int i) {
        try {
            super.setCorePoolSize(i);
        } catch (Exception e) {
            sl.ms("BaseThreadPool", e.getMessage());
        } catch (OutOfMemoryError e2) {
            ms(null, e2);
        }
    }
}

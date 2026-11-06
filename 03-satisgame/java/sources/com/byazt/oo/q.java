package com.byazt.oo;

import com.byazt.qit.rv;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1330, 5})
public class q extends n {
    @Override // com.byazt.oo.n
    public int qg() {
        return 2;
    }

    public q(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (rv.q) {
            q();
        }
    }

    private void q() {
        BlockingQueue queue = getQueue();
        int iFs = rv.qg.fs();
        if (getCorePoolSize() == iFs || queue == null || queue.size() != 0) {
            return;
        }
        setCorePoolSize(iFs);
    }

    private boolean l() {
        BlockingQueue queue = getQueue();
        int corePoolSize = getCorePoolSize();
        int i = corePoolSize * 2;
        int iMin = Math.min(Math.min(corePoolSize + 2, rv.n), rv.qg.d());
        if (corePoolSize >= iMin || queue == null || queue.size() < i) {
            return false;
        }
        try {
            setCorePoolSize(iMin);
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    @Override // com.byazt.oo.n
    public void n(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        boolean zOffer;
        super.n(runnable, outOfMemoryError);
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
                rv.q = false;
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

    @Override // com.byazt.oo.n
    public boolean n() {
        BlockingQueue queue = getQueue();
        return queue != null && queue.size() > getCorePoolSize() * 2;
    }

    @Override // com.byazt.oo.n, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (rv.q) {
            l();
        }
        super.execute(runnable);
    }

    public static boolean s() {
        ThreadPoolExecutor threadPoolExecutorRv = rv.qg.rv();
        if (threadPoolExecutorRv.getQueue().size() != 0 || threadPoolExecutorRv.isShutdown() || threadPoolExecutorRv.isTerminated()) {
            return false;
        }
        int activeCount = threadPoolExecutorRv.getActiveCount();
        int corePoolSize = threadPoolExecutorRv.getCorePoolSize();
        return activeCount < corePoolSize + (-1) && com.byazt.ncu.s.n.get() < corePoolSize / 2;
    }
}

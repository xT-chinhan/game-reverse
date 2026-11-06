package com.byazt.oo;

import com.byazt.qit.rv;
import com.byazt.tk.k;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1330, 26})
public class qg extends n {
    public AtomicInteger n;

    @Override // com.byazt.oo.n
    public int qg() {
        return 1;
    }

    public qg(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, new SynchronousQueue(), threadFactory);
        this.n = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        Runnable runnablePoll;
        super.afterExecute(runnable, th);
        BlockingQueue<Runnable> queue = rv.qg.rv().getQueue();
        if (queue.size() == 0) {
            return;
        }
        int maximumPoolSize = getMaximumPoolSize();
        if (this.n.get() >= Math.max(getCorePoolSize(), maximumPoolSize / 4)) {
            return;
        }
        try {
            this.n.getAndIncrement();
            int activeCount = getActiveCount();
            while (activeCount < maximumPoolSize / 2 && !isShutdown() && !isTerminated() && !isTerminating() && (runnablePoll = queue.poll()) != null) {
                if (runnablePoll instanceof com.byazt.ncu.s) {
                    com.byazt.ncu.s sVar = (com.byazt.ncu.s) runnablePoll;
                    sVar.n(qg());
                    sVar.qg();
                }
                runnablePoll.run();
                activeCount = getActiveCount();
            }
        } finally {
            this.n.getAndDecrement();
        }
    }

    @Override // com.byazt.oo.n
    public void n(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        super.n(runnable, outOfMemoryError);
        if (runnable != null) {
            if (runnable instanceof com.byazt.ncu.s) {
                ((com.byazt.ncu.s) runnable).n(false);
            } else {
                runnable = new s(runnable);
            }
            rv.qg.rv().execute(runnable);
        }
        try {
            allowCoreThreadTimeOut(false);
        } catch (Exception e) {
            k.n("BigThreadPool", "oom", e);
        }
    }

    @Override // com.byazt.oo.n
    public boolean n() {
        return getActiveCount() >= getMaximumPoolSize();
    }

    @Override // com.byazt.oo.n, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable instanceof s) {
            super.execute(runnable);
            return;
        }
        if (n(runnable)) {
            return;
        }
        if (n()) {
            if (runnable instanceof com.byazt.ncu.s) {
                ((com.byazt.ncu.s) runnable).n(false);
            } else {
                runnable = new s(runnable);
            }
            rv.qg.rv().execute(runnable);
            return;
        }
        super.execute(runnable);
    }

    private boolean n(Runnable runnable) {
        com.byazt.ncu.s sVar;
        if (!q.s()) {
            return false;
        }
        if (runnable instanceof com.byazt.ncu.s) {
            sVar = (com.byazt.ncu.s) runnable;
            if (!sVar.s()) {
                return false;
            }
        } else {
            sVar = new s(runnable);
        }
        com.byazt.ncu.s.n.incrementAndGet();
        sVar.n(false);
        rv.qg.rv().execute(sVar);
        return true;
    }
}

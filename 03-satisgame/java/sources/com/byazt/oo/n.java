package com.byazt.oo;

import com.byazt.qit.rv;
import com.byazt.tk.k;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1330, 19})
public abstract class n extends ThreadPoolExecutor {
    public boolean n() {
        return false;
    }

    public int qg() {
        return 0;
    }

    public n(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, com.byazt.xis.n.n);
    }

    public n(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
    }

    private void n(Runnable runnable) {
        com.byazt.ncu.s sVar;
        try {
            if (runnable instanceof com.byazt.ncu.s) {
                sVar = (com.byazt.ncu.s) runnable;
            } else {
                sVar = new com.byazt.ncu.s(runnable);
            }
            sVar.qg();
            if (rv.qg.k()) {
                if (!(getCorePoolSize() > getActiveCount() && getQueue().size() <= 0)) {
                    sVar.n(3);
                    rv.qg.oa().submit(sVar);
                    return;
                }
            }
            sVar.n(qg());
            super.execute(sVar);
        } catch (InternalError e) {
            k.n("BaseThreadPool", "InternalError", e);
        } catch (OutOfMemoryError e2) {
            if (rv.qg.qg()) {
                rv.q = false;
            }
            n(runnable, e2);
            rv rvVar = rv.qg;
        }
    }

    public void n(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        com.byazt.ncu.s.qg = true;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        n(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setCorePoolSize(int i) {
        try {
            super.setCorePoolSize(i);
        } catch (Exception e) {
            e.getMessage();
        } catch (OutOfMemoryError e2) {
            n(null, e2);
        }
    }
}

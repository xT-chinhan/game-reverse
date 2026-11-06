package com.byazt.mz;

import com.byazt.ca.ho;
import com.byazt.xlm.aj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT, 13})
public class hw extends pr {
    public AtomicInteger pr;

    public hw(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, new SynchronousQueue(), threadFactory);
        this.pr = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        BlockingQueue<Runnable> queue = aj.hw.aj().getQueue();
        if (queue.size() == 0) {
            return;
        }
        int maximumPoolSize = getMaximumPoolSize();
        if (this.pr.get() >= Math.max(getCorePoolSize(), maximumPoolSize / 4)) {
            return;
        }
        try {
            this.pr.getAndIncrement();
            int activeCount = getActiveCount();
            while (activeCount < maximumPoolSize / 2) {
                if (!isShutdown() && !isTerminated() && !isTerminating()) {
                    Runnable runnablePoll = queue.poll();
                    if (runnablePoll == null) {
                        return;
                    }
                    if (runnablePoll instanceof com.byazt.rj.hn) {
                        com.byazt.rj.hn hnVar = (com.byazt.rj.hn) runnablePoll;
                        hnVar.pr(hw());
                        hnVar.hw();
                    }
                    runnablePoll.run();
                    activeCount = getActiveCount();
                }
                return;
            }
        } finally {
            this.pr.getAndDecrement();
        }
    }

    @Override // com.byazt.mz.pr
    public void pr(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        super.pr(runnable, outOfMemoryError);
        if (runnable != null) {
            if (runnable instanceof com.byazt.rj.hn) {
                ((com.byazt.rj.hn) runnable).pr(false);
            } else {
                runnable = new hn(runnable);
            }
            aj.hw.aj().execute(runnable);
        }
        try {
            allowCoreThreadTimeOut(false);
        } catch (Exception e) {
            ho.pr("BigThreadPool", "oom", e);
        }
    }

    @Override // com.byazt.mz.pr
    public boolean pr() {
        return getActiveCount() >= getMaximumPoolSize();
    }

    @Override // com.byazt.mz.pr, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable instanceof hn) {
            super.execute(runnable);
            return;
        }
        if (!pr(runnable)) {
            if (pr()) {
                if (runnable instanceof com.byazt.rj.hn) {
                    ((com.byazt.rj.hn) runnable).pr(false);
                } else {
                    runnable = new hn(runnable);
                }
                aj.hw.aj().execute(runnable);
                return;
            }
            super.execute(runnable);
        }
    }

    private boolean pr(Runnable runnable) {
        com.byazt.rj.hn hnVar;
        if (!x.hn()) {
            return false;
        }
        if (runnable instanceof com.byazt.rj.hn) {
            hnVar = (com.byazt.rj.hn) runnable;
            if (!hnVar.hn()) {
                return false;
            }
        } else {
            hnVar = new hn(runnable);
        }
        com.byazt.rj.hn.pr.incrementAndGet();
        hnVar.pr(false);
        aj.hw.aj().execute(hnVar);
        return true;
    }

    @Override // com.byazt.mz.pr
    public int hw() {
        return 1;
    }
}

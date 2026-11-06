package com.byazt.mz;

import com.byazt.ca.ho;
import com.byazt.xlm.aj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT, 37})
public abstract class pr extends ThreadPoolExecutor {
    public pr(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, com.byazt.fr.pr.pr);
    }

    public pr(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
    }

    private void pr(Runnable runnable) {
        com.byazt.rj.hn hnVar;
        try {
            if (runnable instanceof com.byazt.rj.hn) {
                hnVar = (com.byazt.rj.hn) runnable;
            } else {
                hnVar = new com.byazt.rj.hn(runnable);
            }
            hnVar.hw();
            if (aj.hw.g()) {
                if (!(getCorePoolSize() > getActiveCount() && getQueue().size() <= 0)) {
                    hnVar.pr(3);
                    aj.hw.k().submit(hnVar);
                    return;
                }
            }
            hnVar.pr(hw());
            super.execute(hnVar);
        } catch (InternalError e) {
            ho.pr("BaseThreadPool", "InternalError", e);
        } catch (OutOfMemoryError e2) {
            if (aj.hw.hw()) {
                aj.x = false;
            }
            pr(runnable, e2);
            aj ajVar = aj.hw;
        }
    }

    public void pr(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        com.byazt.rj.hn.hw = true;
    }

    public boolean pr() {
        return false;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        pr(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setCorePoolSize(int i) {
        try {
            super.setCorePoolSize(i);
        } catch (Exception e) {
            e.getMessage();
        } catch (OutOfMemoryError e2) {
            pr(null, e2);
        }
    }

    public int hw() {
        return 0;
    }
}

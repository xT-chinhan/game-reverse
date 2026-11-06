package com.byazt.mz;

import com.byazt.xlm.aj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_DROP_COUNT, 121})
public class x extends pr {
    public x(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (aj.x) {
            x();
        }
    }

    private void x() {
        BlockingQueue queue = getQueue();
        int iZo = aj.hw.zo();
        if (getCorePoolSize() != iZo && queue != null && queue.size() == 0) {
            setCorePoolSize(iZo);
        }
    }

    private boolean c() {
        BlockingQueue queue = getQueue();
        int corePoolSize = getCorePoolSize();
        int i = corePoolSize * 2;
        int iMin = Math.min(corePoolSize + 4, aj.pr);
        if (corePoolSize < iMin && queue != null && queue.size() >= i) {
            try {
                setCorePoolSize(iMin);
                return true;
            } catch (Exception e) {
                e.getMessage();
                return false;
            }
        }
        return false;
    }

    @Override // com.byazt.mz.pr
    public void pr(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        boolean zOffer;
        super.pr(runnable, outOfMemoryError);
        boolean z = false;
        if (runnable != null) {
            try {
                zOffer = getQueue().offer(runnable);
            } catch (Throwable th) {
                zOffer = z;
            }
        } else {
            zOffer = true;
            try {
                aj.x = false;
            } catch (Throwable th2) {
                z = zOffer;
                zOffer = z;
            }
        }
        allowCoreThreadTimeOut(false);
        if (!zOffer) {
            throw outOfMemoryError;
        }
    }

    @Override // com.byazt.mz.pr
    public boolean pr() {
        BlockingQueue queue = getQueue();
        return queue != null && queue.size() > getCorePoolSize() * 2;
    }

    @Override // com.byazt.mz.pr, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (aj.x) {
            c();
        }
        super.execute(runnable);
    }

    @Override // com.byazt.mz.pr
    public int hw() {
        return 2;
    }

    public static boolean hn() {
        ThreadPoolExecutor threadPoolExecutorAj = aj.hw.aj();
        if (threadPoolExecutorAj.getQueue().size() == 0 && !threadPoolExecutorAj.isShutdown() && !threadPoolExecutorAj.isTerminated()) {
            int activeCount = threadPoolExecutorAj.getActiveCount();
            int corePoolSize = threadPoolExecutorAj.getCorePoolSize();
            if (activeCount < corePoolSize - 1 && com.byazt.rj.hn.pr.get() < corePoolSize / 2) {
                return true;
            }
            return false;
        }
        return false;
    }
}

package com.byazt.fr;

import com.byazt.xlm.aj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 443, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends ScheduledThreadPoolExecutor {
    public c(int i, ThreadFactory threadFactory) {
        super(i, new com.byazt.rj.x(threadFactory, 8));
        pr();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.byazt.rj.x(threadFactory, 8));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void allowCoreThreadTimeOut(boolean z) {
    }

    private void pr() {
        if (aj.hw.c() && !allowsCoreThreadTimeOut()) {
            super.setKeepAliveTime(Math.max(10L, getKeepAliveTime(TimeUnit.SECONDS)), TimeUnit.SECONDS);
            super.allowCoreThreadTimeOut(true);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        if (aj.hw.c()) {
            try {
                return super.schedule(runnable, j, timeUnit);
            } catch (OutOfMemoryError e) {
                return aj.hw.k().schedule(runnable, j, timeUnit);
            }
        }
        return super.schedule(runnable, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        if (aj.hw.c()) {
            try {
                return super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
            } catch (OutOfMemoryError e) {
                return aj.hw.k().scheduleAtFixedRate(runnable, j, j2, timeUnit);
            }
        }
        return super.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        if (aj.hw.c()) {
            try {
                return super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
            } catch (OutOfMemoryError e) {
                return aj.hw.k().scheduleWithFixedDelay(runnable, j, j2, timeUnit);
            }
        }
        return super.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        if (aj.hw.c()) {
            try {
                return super.schedule(callable, j, timeUnit);
            } catch (OutOfMemoryError e) {
                return aj.hw.k().schedule(callable, j, timeUnit);
            }
        }
        return super.schedule(callable, j, timeUnit);
    }
}

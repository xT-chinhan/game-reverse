package com.byazt.qit;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 26})
public final class qg {
    public static ExecutorService n(ThreadFactory threadFactory) {
        return new s(new com.byazt.xis.q(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory));
    }

    public static ExecutorService qg(ThreadFactory threadFactory) {
        return new com.byazt.xis.q(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
    }

    public static ScheduledExecutorService s(ThreadFactory threadFactory) {
        return new ScheduledExecutorServiceC0313qg(new ScheduledThreadPoolExecutor(1, threadFactory));
    }

    public static ScheduledExecutorService n(int i, ThreadFactory threadFactory) {
        return new com.byazt.xis.l(i, threadFactory);
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 48})
    protected static class n extends AbstractExecutorService {
        public final ExecutorService n;

        public n(ExecutorService executorService) {
            this.n = executorService;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.n.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.n.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            return this.n.shutdownNow();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.n.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.n.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.n.awaitTermination(j, timeUnit);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable runnable) {
            return this.n.submit(runnable);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> callable) {
            return this.n.submit(callable);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable runnable, T t) {
            return this.n.submit(runnable, t);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
            return this.n.invokeAll(collection);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
            return this.n.invokeAll(collection, j, timeUnit);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
            return (T) this.n.invokeAny(collection);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return (T) this.n.invokeAny(collection, j, timeUnit);
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 47})
    protected static class s extends n {
        public s(ExecutorService executorService) {
            super(executorService);
        }

        public void finalize() throws Throwable {
            super.shutdown();
            super.finalize();
        }
    }

    /* JADX INFO: renamed from: com.byazt.qit.qg$qg, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 201})
    protected static class ScheduledExecutorServiceC0313qg extends n implements ScheduledExecutorService {
        public final ScheduledExecutorService n;

        public ScheduledExecutorServiceC0313qg(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.n = scheduledExecutorService;
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.n.schedule(runnable, j, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
            return this.n.schedule(callable, j, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            return this.n.scheduleAtFixedRate(runnable, j, j2, timeUnit);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            return this.n.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
        }
    }
}

package c1m.m2a.m1g;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class v {
    private static final RejectedExecutionHandler a;
    private static final ThreadFactory b;
    private static final BlockingQueue<Runnable> c;
    private static final Executor d;

    static class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("MPG_AD_Thread # %s", Integer.valueOf(this.a.getAndIncrement())));
        }
    }

    static {
        ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();
        a = discardOldestPolicy;
        a aVar = new a();
        b = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        c = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, linkedBlockingQueue, aVar, discardOldestPolicy);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        d = threadPoolExecutor;
    }

    public static void a(Runnable runnable) {
        try {
            d.execute(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

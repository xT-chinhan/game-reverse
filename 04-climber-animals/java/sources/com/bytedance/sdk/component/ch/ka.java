package com.bytedance.sdk.component.ch;

import java.lang.reflect.Field;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class ka {
    private static void ms(Throwable th) {
        String.valueOf(th.getMessage());
    }

    public static int ms() {
        ThreadGroup threadGroupXr = xr();
        if (threadGroupXr == null) {
            return 0;
        }
        int iActiveCount = threadGroupXr.activeCount();
        try {
            return threadGroupXr.enumerate(new Thread[(iActiveCount / 2) + iActiveCount]);
        } catch (Throwable unused) {
            return iActiveCount;
        }
    }

    public static ThreadGroup xr() {
        try {
            Field declaredField = ThreadGroup.class.getDeclaredField("systemThreadGroup");
            declaredField.setAccessible(true);
            return (ThreadGroup) declaredField.get(ThreadGroup.class);
        } catch (Exception e) {
            ms(e);
            return null;
        }
    }

    public static void ms(ExecutorService executorService, final ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor != null) {
            try {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
                threadPoolExecutor.setKeepAliveTime(2L, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                ms(e);
            }
            executorService.execute(new Runnable() { // from class: com.bytedance.sdk.component.ch.ka.1
                @Override // java.lang.Runnable
                public void run() {
                    ka.xr(threadPoolExecutor);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(ThreadPoolExecutor threadPoolExecutor) {
        BlockingQueue<Runnable> queue;
        try {
            threadPoolExecutor.setKeepAliveTime(1L, TimeUnit.MILLISECONDS);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            while (true) {
                if (queue != null) {
                    try {
                        if (queue.size() > 0) {
                            while (true) {
                                Runnable runnablePoll = queue.poll(0L, TimeUnit.MILLISECONDS);
                                if (runnablePoll == null) {
                                    break;
                                } else {
                                    runnablePoll.run();
                                }
                            }
                        }
                    } catch (Exception unused) {
                        continue;
                    }
                }
                if (threadPoolExecutor.getActiveCount() != 0) {
                    Thread.sleep(1000L);
                } else {
                    threadPoolExecutor.shutdown();
                    return;
                }
            }
        } catch (Exception e) {
            ms(e);
        }
        queue = threadPoolExecutor.getQueue();
    }
}

package com.anythink.dlopt.common.a.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static ExecutorService a;

    public static ExecutorService a() {
        if (a == null) {
            a = new ThreadPoolExecutor(0, 6, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.anythink.dlopt.common.a.a.a.1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return Executors.defaultThreadFactory().newThread(runnable);
                }
            }, new RejectedExecutionHandler() { // from class: com.anythink.dlopt.common.a.a.a.2
                @Override // java.util.concurrent.RejectedExecutionHandler
                public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    new StringBuilder("rejectedExecution() >>> 被拒绝的任务：r = ").append(runnable);
                    Thread.currentThread().getId();
                }
            });
        }
        return a;
    }
}

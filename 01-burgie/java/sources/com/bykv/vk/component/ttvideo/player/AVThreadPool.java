package com.bykv.vk.component.ttvideo.player;

import com.byazt.fr.x;
import com.byazt.xlm.zo;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class AVThreadPool {
    private static ThreadPoolExecutor mExecutorInstance;
    private static volatile ExecutorService mExtExecutorInstance;

    public static synchronized void setExecutorInstance(ExecutorService executorService) {
        mExtExecutorInstance = executorService;
    }

    private static synchronized ExecutorService getExecutorInstance() {
        ExecutorService executorService;
        if (mExtExecutorInstance != null) {
            executorService = mExtExecutorInstance;
        } else {
            if (mExecutorInstance == null) {
                mExecutorInstance = new x(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new zo("/AVThreadPool"));
            }
            executorService = mExecutorInstance;
        }
        return executorService;
    }

    public static synchronized void addTask(Runnable runnable) {
        getExecutorInstance().submit(runnable);
    }

    public static synchronized Future<String> addTask(Callable<String> callable) {
        return getExecutorInstance().submit(callable);
    }
}

package com.tapsdk.tapad.internal.utils;

import android.os.Handler;
import android.os.Looper;
import com.tapsdk.tapad.group.constants.Constants;
import com.tapsdk.tapad.internal.runtime.CoreMediationTelemetryBridge;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class AsyncExecutor {
    private static final int CPU_COUNT;
    private static final int IO_CORE_THREADS;
    private static final ThreadPoolExecutor IO_EXECUTOR;
    private static final int IO_MAX_THREADS;
    private static final int IO_QUEUE_CAPACITY;
    private static final Handler MAIN;

    public interface ResultCallback<T> {
        void onError(Exception exc);

        void onSuccess(T t);
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = iAvailableProcessors;
        int iMax = Math.max(2, Math.min(iAvailableProcessors / 2, 4));
        IO_CORE_THREADS = iMax;
        int iMax2 = Math.max(4, Math.min(iAvailableProcessors, 8));
        IO_MAX_THREADS = iMax2;
        int iMax3 = Math.max(16, Math.min(iAvailableProcessors * 4, 32));
        IO_QUEUE_CAPACITY = iMax3;
        IO_EXECUTOR = newBoundedExecutor(iMax, iMax2, iMax3, "TapAd-IO");
        MAIN = new Handler(Looper.getMainLooper());
    }

    private AsyncExecutor() {
    }

    public static <T> void executeIO(final Callable<T> callable, final ResultCallback<T> resultCallback) {
        if (callable == null) {
            if (resultCallback != null) {
                runOnMain(new Runnable() { // from class: com.tapsdk.tapad.internal.utils.AsyncExecutor$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        resultCallback.onError(new IllegalArgumentException("IO task is null"));
                    }
                });
            }
        } else {
            if (tryExecuteIO(new Runnable() { // from class: com.tapsdk.tapad.internal.utils.AsyncExecutor$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    AsyncExecutor.lambda$executeIO$3(callable, resultCallback);
                }
            }) || resultCallback == null) {
                return;
            }
            runOnMain(new Runnable() { // from class: com.tapsdk.tapad.internal.utils.AsyncExecutor$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    resultCallback.onError(new RejectedExecutionException("TapAd IO executor is saturated"));
                }
            });
        }
    }

    static /* synthetic */ void lambda$executeIO$3(Callable callable, final ResultCallback resultCallback) {
        try {
            final Object objCall = callable.call();
            if (resultCallback != null) {
                runOnMain(new Runnable() { // from class: com.tapsdk.tapad.internal.utils.AsyncExecutor$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        resultCallback.onSuccess(objCall);
                    }
                });
            }
        } catch (Exception e) {
            if (resultCallback != null) {
                runOnMain(new Runnable() { // from class: com.tapsdk.tapad.internal.utils.AsyncExecutor$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        resultCallback.onError(e);
                    }
                });
            }
        }
    }

    static /* synthetic */ Thread lambda$threadFactory$6(String str, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(false);
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.tapsdk.tapad.internal.utils.AsyncExecutor$$ExternalSyntheticLambda0
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread2, Throwable th) {
                AsyncExecutor.reportThreadPoolException(th, thread2.getName());
            }
        });
        return thread;
    }

    public static ThreadPoolExecutor newBoundedExecutor(int i, int i2, int i3, String str) {
        return new ThreadPoolExecutor(i, i2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(i3), threadFactory(str), new ThreadPoolExecutor.AbortPolicy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportThreadPoolException(Throwable th, String str) {
        HashMap map = new HashMap();
        map.put(Constants.ERROR_MSG_FIELD, String.valueOf(th.getMessage()));
        map.put("error_stack_trace", Arrays.toString(th.getStackTrace()));
        if (str == null) {
            str = "";
        }
        map.put(Constants.THREAD_NAME_FIELD, str);
        CoreMediationTelemetryBridge.reportFact(62, map);
    }

    public static void runOnMain(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            MAIN.post(runnable);
        }
    }

    private static ThreadFactory threadFactory(final String str) {
        return new ThreadFactory() { // from class: com.tapsdk.tapad.internal.utils.AsyncExecutor$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return AsyncExecutor.lambda$threadFactory$6(str, runnable);
            }
        };
    }

    public static boolean tryExecute(ThreadPoolExecutor threadPoolExecutor, Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        try {
            threadPoolExecutor.execute(runnable);
            return true;
        } catch (RejectedExecutionException e) {
            reportThreadPoolException(e, Thread.currentThread().getName());
            return false;
        }
    }

    public static boolean tryExecuteIO(Runnable runnable) {
        return tryExecute(IO_EXECUTOR, runnable);
    }
}

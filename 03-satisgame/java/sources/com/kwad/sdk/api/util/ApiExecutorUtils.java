package com.kwad.sdk.api.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class ApiExecutorUtils {
    private static final ExecutorService asyncExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    public static Future<?> submit(ApiSafeRunnable apiSafeRunnable) {
        return asyncExecutor.submit(apiSafeRunnable);
    }

    static void runOnUIThread(ApiSafeRunnable apiSafeRunnable) {
        mainHandler.post(apiSafeRunnable);
    }
}

package com.bykv.vk.component.ttvideo.utils;

import com.bytedance.sdk.component.ch.ch;
import com.bytedance.sdk.component.ch.d.d;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class EngineThreadPool {
    private static ThreadPoolExecutor a;

    public static ExecutorService a() {
        if (a == null) {
            synchronized (EngineThreadPool.class) {
                if (a == null) {
                    d dVar = new d(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ch("EngineThreadPool"));
                    a = dVar;
                    dVar.allowCoreThreadTimeOut(true);
                }
            }
        }
        return a;
    }

    public static void setExcutorInstance(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (EngineThreadPool.class) {
            a = threadPoolExecutor;
        }
    }
}

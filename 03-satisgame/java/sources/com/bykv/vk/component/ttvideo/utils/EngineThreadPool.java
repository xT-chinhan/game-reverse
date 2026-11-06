package com.bykv.vk.component.ttvideo.utils;

import com.byazt.qit.fs;
import com.byazt.xis.q;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class EngineThreadPool {
    private static ThreadPoolExecutor a;

    public static ExecutorService a() {
        if (a == null) {
            synchronized (EngineThreadPool.class) {
                if (a == null) {
                    q qVar = new q(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new fs("EngineThreadPool"));
                    a = qVar;
                    qVar.allowCoreThreadTimeOut(true);
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

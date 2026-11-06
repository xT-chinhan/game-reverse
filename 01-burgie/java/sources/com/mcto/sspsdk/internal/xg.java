package com.mcto.sspsdk.internal;

import java.util.AbstractQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class xg {
    public static final int i = Runtime.getRuntime().availableProcessors();
    public int a;
    public int b;
    public long c;
    public AbstractQueue d;
    public RejectedExecutionHandler e;
    public yg f;
    public final ThreadPoolExecutor g;
    public boolean h;

    /* JADX WARN: Type inference failed for: r10v0, types: [java.util.AbstractQueue, java.util.concurrent.BlockingQueue] */
    public xg() {
        int i2 = i;
        this.a = Math.max(2, Math.min(i2 - 1, 4));
        this.b = (i2 * 2) + 1;
        this.c = 30L;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.d = new LinkedBlockingQueue(10);
        this.e = new ThreadPoolExecutor.CallerRunsPolicy();
        this.f = new yg("base Scheduler", 5);
        this.h = true;
        a();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.a, this.b, this.c, timeUnit, this.d, this.f, this.e);
        threadPoolExecutor.allowCoreThreadTimeOut(this.h);
        this.g = threadPoolExecutor;
    }

    public abstract void a();

    public final void a(Runnable runnable) {
        try {
            this.g.execute(runnable);
        } catch (Exception e) {
        }
    }
}

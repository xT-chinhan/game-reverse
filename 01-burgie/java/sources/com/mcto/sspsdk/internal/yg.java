package com.mcto.sspsdk.internal;

import com.umeng.analytics.pro.an;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class yg implements ThreadFactory {
    public static final AtomicInteger d = new AtomicInteger(1);
    public final String a;
    public final int b;
    public final AtomicInteger c = new AtomicInteger(1);

    public yg(String str, int i) {
        this.b = i;
        this.a = "ssp_thread_" + str + "_p" + d.getAndIncrement() + an.aI;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.a + this.c.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int i = this.b;
        if (i > 10 || i < 1) {
            i = 5;
        }
        thread.setPriority(i);
        return thread;
    }
}

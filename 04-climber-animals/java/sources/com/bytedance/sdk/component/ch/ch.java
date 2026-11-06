package com.bytedance.sdk.component.ch;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class ch implements ThreadFactory {
    private int ah;
    private final AtomicInteger d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final String f1202ms;
    private final ThreadGroup xr;

    public ch(String str) {
        this(5, str);
    }

    public ch(int i, String str) {
        this.d = new AtomicInteger(1);
        this.ah = i;
        this.xr = new ThreadGroup("csj_g_" + str);
        this.f1202ms = "csj_" + (hi.xr.c() ? "p" : "") + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadMs = ms(this.xr, runnable, this.f1202ms + "_" + this.d.getAndIncrement());
        if (threadMs.isDaemon()) {
            threadMs.setDaemon(false);
        }
        int i = this.ah;
        if (i > 10) {
            this.ah = 10;
        } else if (i <= 0) {
            this.ah = 1;
        }
        threadMs.setPriority(this.ah);
        return threadMs;
    }

    protected Thread ms(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new com.bytedance.sdk.component.ch.d.ah(threadGroup, runnable, str);
    }
}

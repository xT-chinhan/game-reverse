package com.baidu.mobads.sdk.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
class bg implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);

    bg() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "MobAds-p-" + this.a.getAndIncrement());
        thread.setUncaughtExceptionHandler(new bh(this));
        return thread;
    }
}

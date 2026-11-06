package com.bytedance.sdk.component.c.ms;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements ThreadFactory {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ThreadGroup f1191ms;
    private final AtomicInteger xr = new AtomicInteger(1);

    public ms(String str) {
        this.f1191ms = new ThreadGroup("tt_img_".concat(String.valueOf(str)));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.bytedance.sdk.component.ch.d.ah ahVar = new com.bytedance.sdk.component.ch.d.ah(this.f1191ms, runnable, "tt_img_" + this.xr.getAndIncrement());
        if (ahVar.isDaemon()) {
            ahVar.setDaemon(false);
        }
        return ahVar;
    }
}

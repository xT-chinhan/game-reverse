package com.ss.android.socialbase.downloader.x;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class ms implements ThreadFactory {
    private final boolean ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f4801ms;
    private final AtomicInteger xr;

    public ms(String str) {
        this(str, false);
    }

    public ms(String str, boolean z) {
        this.xr = new AtomicInteger();
        this.f4801ms = str;
        this.ah = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.bytedance.sdk.component.ch.d.ah ahVar = new com.bytedance.sdk.component.ch.d.ah(runnable, this.f4801ms + "-" + this.xr.incrementAndGet());
        if (!this.ah) {
            if (ahVar.isDaemon()) {
                ahVar.setDaemon(false);
            }
            if (ahVar.getPriority() != 5) {
                ahVar.setPriority(5);
            }
        }
        return ahVar;
    }
}

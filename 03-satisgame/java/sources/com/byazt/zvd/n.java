package com.byazt.zvd;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1640, 19})
public class n implements ThreadFactory {
    public final ThreadGroup n;
    public final AtomicInteger qg = new AtomicInteger(1);

    public n(String str) {
        this.n = new ThreadGroup("tt_img_".concat(String.valueOf(str)));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.byazt.xis.s sVar = new com.byazt.xis.s(this.n, runnable, "tt_img_" + this.qg.getAndIncrement());
        if (sVar.isDaemon()) {
            sVar.setDaemon(false);
        }
        return sVar;
    }
}

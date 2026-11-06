package com.byazt.ih;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1059, 37})
public class pr implements ThreadFactory {
    public final AtomicInteger hw = new AtomicInteger(1);
    public final ThreadGroup pr;

    public pr(String str) {
        this.pr = new ThreadGroup("tt_img_".concat(String.valueOf(str)));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.byazt.fr.hn hnVar = new com.byazt.fr.hn(this.pr, runnable, "tt_img_" + this.hw.getAndIncrement());
        if (hnVar.isDaemon()) {
            hnVar.setDaemon(false);
        }
        return hnVar;
    }
}

package com.byazt.gi;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 587, 37})
public class pr implements ThreadFactory {
    public final boolean hn;
    public final AtomicInteger hw;
    public final String pr;

    public pr(String str) {
        this(str, false);
    }

    public pr(String str, boolean z) {
        this.hw = new AtomicInteger();
        this.pr = str;
        this.hn = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.byazt.fr.hn hnVar = new com.byazt.fr.hn(runnable, this.pr + "-" + this.hw.incrementAndGet());
        if (!this.hn) {
            if (hnVar.isDaemon()) {
                hnVar.setDaemon(false);
            }
            if (hnVar.getPriority() != 5) {
                hnVar.setPriority(5);
            }
        }
        return hnVar;
    }
}

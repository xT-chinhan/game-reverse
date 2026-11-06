package com.byazt.l;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 18, 19})
public class n implements ThreadFactory {
    public final String n;
    public final AtomicInteger qg;
    public final boolean s;

    public n(String str) {
        this(str, false);
    }

    public n(String str, boolean z) {
        this.qg = new AtomicInteger();
        this.n = str;
        this.s = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.byazt.xis.s sVar = new com.byazt.xis.s(runnable, this.n + "-" + this.qg.incrementAndGet());
        if (!this.s) {
            if (sVar.isDaemon()) {
                sVar.setDaemon(false);
            }
            if (sVar.getPriority() != 5) {
                sVar.setPriority(5);
            }
        }
        return sVar;
    }
}

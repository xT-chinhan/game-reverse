package com.byazt.oy;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2147, 5})
public class q implements ThreadFactory {
    public static final AtomicInteger n = new AtomicInteger(1);
    public final qg.n l;
    public final String q;
    public final ThreadGroup qg;
    public final AtomicInteger s = new AtomicInteger(1);

    public q(qg.n nVar, String str) {
        ThreadGroup threadGroup;
        this.l = nVar;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.qg = threadGroup;
        if (TextUtils.isEmpty(str)) {
            this.q = "ttdefault-" + n.getAndIncrement() + "-thread-";
        } else {
            this.q = str + n.getAndIncrement() + "-thread-";
        }
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.byazt.xis.s sVar = new com.byazt.xis.s(this.qg, runnable, this.q + this.s.getAndIncrement(), 0L);
        if (sVar.isDaemon()) {
            sVar.setDaemon(false);
        }
        qg.n nVar = this.l;
        if (nVar != null && nVar.n() == qg.n.LOW.n()) {
            sVar.setPriority(1);
        } else if (sVar.getPriority() != 5) {
            sVar.setPriority(3);
        } else {
            sVar.setPriority(5);
        }
        return sVar;
    }
}

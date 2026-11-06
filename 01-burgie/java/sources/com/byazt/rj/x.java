package com.byazt.rj;

import com.byazt.xlm.aj;
import com.byazt.xlm.zo;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1628, 121})
public class x implements ThreadFactory {
    public final int hw;
    public final ThreadFactory pr;

    public x(ThreadFactory threadFactory, int i) {
        if (threadFactory == null) {
            this.pr = new zo("default");
        } else {
            this.pr = threadFactory;
        }
        this.hw = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.pr.newThread(runnable);
        if (hw()) {
            return new fw(threadNewThread);
        }
        return threadNewThread;
    }

    public final String pr() {
        return this.pr.getClass().getName();
    }

    public boolean hw() {
        return aj.hw.hw(this.hw);
    }
}

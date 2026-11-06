package com.byazt.fr;

import com.byazt.rj.fw;
import com.byazt.xlm.aj;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 443, 20})
public class hn extends Thread {
    public fw proxy;

    @Override // java.lang.Thread
    public void interrupt() {
        fw fwVar = this.proxy;
        if (fwVar != null) {
            fwVar.interrupt();
        } else {
            super.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        fw fwVar = this.proxy;
        return fwVar != null ? fwVar.isInterrupted() : super.isInterrupted();
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        try {
            if (isProxyEnable()) {
                if (this.proxy == null) {
                    this.proxy = new fw(this);
                }
                this.proxy.start();
                return;
            }
            super.start();
        } catch (InternalError e) {
        } catch (OutOfMemoryError e2) {
            com.byazt.xlm.hn.pr.pr("PThread");
            aj.hw.k().schedule(new Runnable() { // from class: com.byazt.fr.hn.1
                @Override // java.lang.Runnable
                public void run() {
                    hn.super.start();
                }
            }, aj.hw.x(), TimeUnit.MILLISECONDS);
        }
    }

    public boolean isProxyEnable() {
        return aj.hw.hw(1);
    }

    public hn() {
    }

    public hn(Runnable runnable) {
        super(runnable);
    }

    public hn(String str) {
        super(str);
    }

    public hn(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, runnable);
    }

    public hn(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }

    public hn(Runnable runnable, String str) {
        super(runnable, str);
    }

    public hn(ThreadGroup threadGroup, Runnable runnable, String str) {
        super(threadGroup, runnable, str);
    }

    public hn(ThreadGroup threadGroup, Runnable runnable, String str, long j) {
        super(threadGroup, runnable, str, j);
    }
}

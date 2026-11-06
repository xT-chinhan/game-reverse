package com.byazt.xis;

import com.byazt.ncu.x;
import com.byazt.qit.rv;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 589, 8})
public class s extends Thread {
    public x proxy;

    @Override // java.lang.Thread
    public void interrupt() {
        x xVar = this.proxy;
        if (xVar != null) {
            xVar.interrupt();
        } else {
            super.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        x xVar = this.proxy;
        return xVar != null ? xVar.isInterrupted() : super.isInterrupted();
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        try {
            if (isProxyEnable()) {
                if (this.proxy == null) {
                    this.proxy = new x(this);
                }
                this.proxy.start();
                return;
            }
            super.start();
        } catch (InternalError unused) {
        } catch (OutOfMemoryError unused2) {
            com.byazt.qit.s.n.n("PThread");
            rv.qg.oa().schedule(new Runnable() { // from class: com.byazt.xis.s.1
                @Override // java.lang.Runnable
                public void run() {
                    s.super.start();
                }
            }, rv.qg.q(), TimeUnit.MILLISECONDS);
        }
    }

    public boolean isProxyEnable() {
        return rv.qg.qg(1);
    }

    public s() {
    }

    public s(Runnable runnable) {
        super(runnable);
    }

    public s(String str) {
        super(str);
    }

    public s(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, runnable);
    }

    public s(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }

    public s(Runnable runnable, String str) {
        super(runnable, str);
    }

    public s(ThreadGroup threadGroup, Runnable runnable, String str) {
        super(threadGroup, runnable, str);
    }

    public s(ThreadGroup threadGroup, Runnable runnable, String str, long j) {
        super(threadGroup, runnable, str, j);
    }
}

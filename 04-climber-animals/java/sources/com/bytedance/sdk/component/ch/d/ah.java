package com.bytedance.sdk.component.ch.d;

import com.bytedance.sdk.component.ch.hi;
import com.bytedance.sdk.component.ch.ms.ab;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends Thread {
    private ab proxy;

    @Override // java.lang.Thread
    public void interrupt() {
        ab abVar = this.proxy;
        if (abVar != null) {
            abVar.interrupt();
        } else {
            super.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        ab abVar = this.proxy;
        return abVar != null ? abVar.isInterrupted() : super.isInterrupted();
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        try {
            if (isProxyEnable()) {
                if (this.proxy == null) {
                    this.proxy = new ab(this);
                }
                this.proxy.start();
                return;
            }
            super.start();
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.ch.d.f1203ms.ms("PThread");
            hi.xr.sl().schedule(new Runnable() { // from class: com.bytedance.sdk.component.ch.d.ah.1
                @Override // java.lang.Runnable
                public void run() {
                    ah.super.start();
                }
            }, hi.xr.d(), TimeUnit.MILLISECONDS);
        }
    }

    protected boolean isProxyEnable() {
        return hi.xr.xr(1);
    }

    public ah() {
    }

    public ah(Runnable runnable) {
        super(runnable);
    }

    public ah(String str) {
        super(str);
    }

    public ah(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, runnable);
    }

    public ah(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }

    public ah(Runnable runnable, String str) {
        super(runnable, str);
    }

    public ah(ThreadGroup threadGroup, Runnable runnable, String str) {
        super(threadGroup, runnable, str);
    }

    public ah(ThreadGroup threadGroup, Runnable runnable, String str, long j) {
        super(threadGroup, runnable, str, j);
    }
}

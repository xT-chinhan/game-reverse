package com.bytedance.sdk.component.ch.ms;

import com.bytedance.sdk.component.ch.hi;
import com.bytedance.sdk.component.ch.ny;

/* JADX INFO: loaded from: classes2.dex */
public final class ab extends Thread {
    private final Thread ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile Thread f1220ms;
    private volatile boolean xr;

    public ab(Thread thread) {
        this.ah = thread;
    }

    @Override // java.lang.Thread
    public void interrupt() {
        if (this.f1220ms != null) {
            this.f1220ms.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        if (this.f1220ms != null) {
            return this.f1220ms.isInterrupted();
        }
        return true;
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        if (this.xr) {
            return;
        }
        this.xr = true;
        hi.xr.ch().execute(new com.bytedance.sdk.component.ch.ah.ah(new ny(this.ah.getName()) { // from class: com.bytedance.sdk.component.ch.ms.ab.1
            @Override // java.lang.Runnable
            public void run() {
                if (hi.xr.ub()) {
                    ab.this.ms();
                } else {
                    ab.this.xr();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms() {
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        try {
            xr xrVarAh = hi.xr.ah();
            String name2 = this.ah.getName();
            if (xrVarAh != null) {
                name2 = xrVarAh.ms(name2);
            }
            threadCurrentThread.setName(name2);
            this.f1220ms = threadCurrentThread;
            threadCurrentThread.setPriority(this.ah.getPriority());
            this.ah.run();
        } finally {
            threadCurrentThread.setName(name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr() {
        Thread threadCurrentThread = Thread.currentThread();
        this.f1220ms = threadCurrentThread;
        threadCurrentThread.setPriority(this.ah.getPriority());
        this.ah.run();
    }
}

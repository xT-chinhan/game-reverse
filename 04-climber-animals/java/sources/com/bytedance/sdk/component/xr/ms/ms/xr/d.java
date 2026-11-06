package com.bytedance.sdk.component.xr.ms.ms.xr;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.bytedance.sdk.component.xr.ms.d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ExecutorService f1611ms;
    private final Deque<ms.C0258ms> xr = new ArrayDeque();
    private final Deque<ms.C0258ms> ah = new ArrayDeque();
    private final Deque<ms> d = new ArrayDeque();
    private AtomicInteger ka = new AtomicInteger(64);

    @Override // com.bytedance.sdk.component.xr.ms.d
    public void xr(int i) {
    }

    public d() {
        if (this.f1611ms == null) {
            this.f1611ms = new com.bytedance.sdk.component.ch.d.d(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.component.xr.ms.ms.xr.d.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    com.bytedance.sdk.component.ch.d.ah ahVar = new com.bytedance.sdk.component.ch.d.ah(runnable, "systemHttp Dispatcher");
                    ahVar.setDaemon(false);
                    ahVar.setPriority(10);
                    return ahVar;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.xr.ms.d
    public ExecutorService xr() {
        return this.f1611ms;
    }

    @Override // com.bytedance.sdk.component.xr.ms.d
    public void ms(int i) {
        this.ka.set(i);
    }

    @Override // com.bytedance.sdk.component.xr.ms.d
    public int ms() {
        return this.ka.get();
    }

    public synchronized void ms(ms.C0258ms c0258ms) {
        try {
            if (this.ah.size() < ms()) {
                this.ah.add(c0258ms);
                if (c0258ms != null) {
                    c0258ms.ms();
                }
                xr().submit(c0258ms);
                return;
            }
            this.xr.add(c0258ms);
        } catch (Throwable unused) {
        }
    }

    synchronized void ms(ms msVar) {
        this.d.add(msVar);
    }

    void xr(ms.C0258ms c0258ms) {
        ms(this.ah, c0258ms, true);
    }

    void xr(ms msVar) {
        ms(this.d, msVar, false);
    }

    private <T> void ms(Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            deque.remove(t);
            if (z) {
                ah();
            }
        }
    }

    private void ah() {
        if (this.ah.size() < ms() && !this.xr.isEmpty()) {
            Iterator<ms.C0258ms> it = this.xr.iterator();
            while (it.hasNext()) {
                ms.C0258ms next = it.next();
                it.remove();
                this.ah.add(next);
                if (next != null) {
                    next.ms();
                }
                xr().submit(next);
                if (this.ah.size() >= ms()) {
                    return;
                }
            }
        }
    }
}

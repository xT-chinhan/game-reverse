package com.mcto.sspsdk.internal;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 implements Runnable {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ AtomicInteger b;
    public final /* synthetic */ ScheduledExecutorService c;
    public final /* synthetic */ com.mcto.sspsdk.ssp.taskpage.a d;
    public final /* synthetic */ List e;

    public k0(AtomicBoolean atomicBoolean, AtomicInteger atomicInteger, ScheduledExecutorService scheduledExecutorService, com.mcto.sspsdk.ssp.taskpage.a aVar, List list) {
        this.a = atomicBoolean;
        this.b = atomicInteger;
        this.c = scheduledExecutorService;
        this.d = aVar;
        this.e = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.compareAndSet(false, true) && this.b.decrementAndGet() == 0) {
            this.c.shutdownNow();
            this.d.a(this.e);
        }
    }
}

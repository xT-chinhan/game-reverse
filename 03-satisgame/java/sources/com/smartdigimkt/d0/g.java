package com.smartdigimkt.d0;

import android.os.SystemClock;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ ScheduledFuture b;
    public final /* synthetic */ q c;

    public g(q qVar, AtomicBoolean atomicBoolean, ScheduledFuture scheduledFuture) {
        this.c = qVar;
        this.a = atomicBoolean;
        this.b = scheduledFuture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            q.b(this.c);
        } catch (Throwable th) {
            th.getMessage();
        }
        if (this.a.compareAndSet(false, true)) {
            this.b.cancel(true);
            this.c.getClass();
            SystemClock.elapsedRealtime();
            this.c.a(4);
        }
    }
}

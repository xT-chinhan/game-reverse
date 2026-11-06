package com.anythink.core.common.l.e;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final AtomicBoolean b = new AtomicBoolean(false);
    private volatile ScheduledFuture<?> c;

    public final void a(ScheduledFuture<?> scheduledFuture) {
        if (scheduledFuture == null) {
            return;
        }
        this.c = scheduledFuture;
        this.b.set(true);
        if (this.a.get()) {
            b();
        }
    }

    public final boolean a() {
        if (!this.a.compareAndSet(false, true)) {
            return false;
        }
        b();
        return true;
    }

    private void b() {
        if (this.b.compareAndSet(true, false)) {
            ScheduledFuture<?> scheduledFuture = this.c;
            this.c = null;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
        }
    }
}

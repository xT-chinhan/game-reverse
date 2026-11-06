package com.tapsdk.tapad.group;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class SchedulerResultGate {
    private long attemptId;
    private boolean cancelled;
    private final long requestId;
    private final AtomicBoolean requestTerminal;
    private final int routeKey;

    public SchedulerResultGate(long j, int i, AtomicBoolean atomicBoolean) {
        this.requestId = j;
        this.routeKey = i;
        this.requestTerminal = atomicBoolean;
    }

    private void checkIdentity(long j, long j2, int i) {
        if (j != this.requestId || i != this.routeKey || j2 <= 0 || j2 != this.attemptId) {
            throw new IllegalStateException("invalid result identity");
        }
    }

    public void bind(long j) {
        if (j <= 0 || this.attemptId != 0) {
            throw new IllegalStateException("invalid result binding");
        }
        this.attemptId = j;
    }

    public void cancel(long j) {
        checkIdentity(this.requestId, j, this.routeKey);
        this.cancelled = true;
    }

    public boolean discardIfClosed(long j, long j2, int i, Runnable runnable) {
        checkIdentity(j, j2, i);
        if (!this.cancelled && !this.requestTerminal.get()) {
            return false;
        }
        runnable.run();
        return true;
    }
}

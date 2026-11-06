package com.tapsdk.tapad.internal.runtime;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public final class PrivacyFactCache<T> {
    private final Clock clock;
    private long lastAttempt;
    private long running;
    private long sequence;
    private T value;

    public interface Clock {
        long now();
    }

    public interface Permission {
        boolean allowed();
    }

    public interface Probe<T> {
        T read();
    }

    public PrivacyFactCache() {
        this(new Clock() { // from class: com.tapsdk.tapad.internal.runtime.PrivacyFactCache$$ExternalSyntheticLambda0
            @Override // com.tapsdk.tapad.internal.runtime.PrivacyFactCache.Clock
            public final long now() {
                return SystemClock.elapsedRealtime();
            }
        });
    }

    public synchronized long begin(long j) {
        long jNow = this.clock.now();
        if (this.running == 0) {
            long j2 = this.lastAttempt;
            if (j2 == Long.MIN_VALUE || jNow < j2 || jNow - j2 >= j) {
                this.lastAttempt = jNow;
                long j3 = this.sequence + 1;
                this.sequence = j3;
                this.running = j3;
                return j3;
            }
        }
        return 0L;
    }

    public synchronized void complete(long j, T t) {
        if (j != 0) {
            if (j == this.running) {
                this.value = t;
                this.running = 0L;
            }
        }
    }

    public synchronized void invalidate() {
        this.value = null;
        this.running = 0L;
        this.sequence++;
    }

    public T read(Permission permission, long j, Probe<T> probe) {
        if (!permission.allowed()) {
            invalidate();
            return null;
        }
        long jBegin = begin(j);
        if (jBegin != 0) {
            try {
                T t = permission.allowed() ? probe.read() : null;
                if (!permission.allowed()) {
                    t = null;
                }
                complete(jBegin, t);
            } catch (Exception e) {
                permission.allowed();
                complete(jBegin, null);
            } catch (Throwable th) {
                permission.allowed();
                complete(jBegin, null);
                throw th;
            }
        }
        if (permission.allowed()) {
            return value();
        }
        invalidate();
        return null;
    }

    public synchronized T value() {
        return this.value;
    }

    public PrivacyFactCache(Clock clock) {
        this.lastAttempt = Long.MIN_VALUE;
        this.clock = clock;
    }
}

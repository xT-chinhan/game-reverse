package com.anythink.core.common.n.c;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class x {
    public static final x c = new x() { // from class: com.anythink.core.common.n.c.x.1
        @Override // com.anythink.core.common.n.c.x
        public final x a(long j) {
            return this;
        }

        @Override // com.anythink.core.common.n.c.x
        public final x a(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // com.anythink.core.common.n.c.x
        public final void g() {
        }
    };
    private boolean a;
    private long b;
    private long d;

    private static long a(long j, long j2) {
        if (j == 0) {
            return j2;
        }
        return (j2 != 0 && j >= j2) ? j2 : j;
    }

    public x a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: ".concat(String.valueOf(j)));
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.d = timeUnit.toNanos(j);
        return this;
    }

    public long i_() {
        return this.d;
    }

    public boolean f_() {
        return this.a;
    }

    public long g_() {
        if (!this.a) {
            throw new IllegalStateException("No deadline");
        }
        return this.b;
    }

    public x a(long j) {
        this.a = true;
        this.b = j;
        return this;
    }

    private x b(long j, TimeUnit timeUnit) {
        if (j <= 0) {
            throw new IllegalArgumentException("duration <= 0: ".concat(String.valueOf(j)));
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        return a(System.nanoTime() + timeUnit.toNanos(j));
    }

    public x h_() {
        this.d = 0L;
        return this;
    }

    public x f() {
        this.a = false;
        return this;
    }

    public void g() throws InterruptedIOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.a && this.b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    private void a(Object obj) throws InterruptedIOException {
        try {
            boolean zF_ = f_();
            long jI_ = i_();
            long jNanoTime = 0;
            if (!zF_ && jI_ == 0) {
                obj.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zF_ && jI_ != 0) {
                jI_ = Math.min(jI_, g_() - jNanoTime2);
            } else if (zF_) {
                jI_ = g_() - jNanoTime2;
            }
            if (jI_ > 0) {
                long j = jI_ / 1000000;
                obj.wait(j, (int) (jI_ - (1000000 * j)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jI_) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}

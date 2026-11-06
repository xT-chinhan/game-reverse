package com.anythink.core.common.m.c;

import com.bykv.vk.component.ttvideo.player.C;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class x {
    public static final x c = new x() { // from class: com.anythink.core.common.m.c.x.1
        @Override // com.anythink.core.common.m.c.x
        public final x a(long j) {
            return this;
        }

        @Override // com.anythink.core.common.m.c.x
        public final x a(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // com.anythink.core.common.m.c.x
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

    public long e_() {
        return this.d;
    }

    public boolean b_() {
        return this.a;
    }

    public long c_() {
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

    public x d_() {
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
            boolean zB_ = b_();
            long jE_ = e_();
            long jNanoTime = 0;
            if (!zB_ && jE_ == 0) {
                obj.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zB_ && jE_ != 0) {
                jE_ = Math.min(jE_, c_() - jNanoTime2);
            } else if (zB_) {
                jE_ = c_() - jNanoTime2;
            }
            if (jE_ > 0) {
                long j = jE_ / C.MICROS_PER_SECOND;
                obj.wait(j, (int) (jE_ - (C.MICROS_PER_SECOND * j)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jE_) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}

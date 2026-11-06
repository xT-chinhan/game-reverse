package com.bytedance.sdk.component.ah.ms;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    public static final t ah = new t() { // from class: com.bytedance.sdk.component.ah.ms.t.1
        @Override // com.bytedance.sdk.component.ah.ms.t
        public void ab() throws IOException {
        }

        @Override // com.bytedance.sdk.component.ah.ms.t
        public t ms(long j) {
            return this;
        }

        @Override // com.bytedance.sdk.component.ah.ms.t
        public t ms(long j, TimeUnit timeUnit) {
            return this;
        }
    };
    private long d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f1017ms;
    private long xr;

    public t ms(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: ".concat(String.valueOf(j)));
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.d = timeUnit.toNanos(j);
        return this;
    }

    public long f_() {
        return this.d;
    }

    public boolean ah() {
        return this.f1017ms;
    }

    public long g_() {
        if (!this.f1017ms) {
            throw new IllegalStateException("No deadline");
        }
        return this.xr;
    }

    public t ms(long j) {
        this.f1017ms = true;
        this.xr = j;
        return this;
    }

    public t ka() {
        this.d = 0L;
        return this;
    }

    public t c() {
        this.f1017ms = false;
        return this;
    }

    public void ab() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f1017ms && this.xr - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}

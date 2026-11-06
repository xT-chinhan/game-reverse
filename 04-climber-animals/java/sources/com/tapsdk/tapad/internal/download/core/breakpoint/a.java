package com.tapsdk.tapad.internal.download.core.breakpoint;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private final long a;
    private final long b;
    private final AtomicLong c;

    public a(long j, long j2) {
        this(j, j2, 0L);
    }

    public a(long j, long j2, long j3) {
        if (j < 0 || ((j2 < 0 && j2 != -1) || j3 < 0)) {
            throw new IllegalArgumentException();
        }
        this.a = j;
        this.b = j2;
        this.c = new AtomicLong(j3);
    }

    public a a() {
        return new a(this.a, this.b, this.c.get());
    }

    public void a(long j) {
        this.c.addAndGet(j);
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.c.get();
    }

    public long d() {
        return this.a + this.c.get();
    }

    public long e() {
        return (this.a + this.b) - 1;
    }

    public long f() {
        return this.a;
    }

    public void g() {
        this.c.set(0L);
    }

    public String toString() {
        return "[" + this.a + ", " + e() + ")-current:" + this.c;
    }
}

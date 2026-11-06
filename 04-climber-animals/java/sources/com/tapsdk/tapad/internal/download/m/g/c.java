package com.tapsdk.tapad.internal.download.m.g;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static final String c = "FileLock";
    private static final long d = TimeUnit.MILLISECONDS.toNanos(100);
    private final Map<String, AtomicInteger> a;
    private final Map<String, Thread> b;

    c() {
        this(new HashMap(), new HashMap());
    }

    c(Map<String, AtomicInteger> map, Map<String, Thread> map2) {
        this.a = map;
        this.b = map2;
    }

    void a() {
        LockSupport.park(Long.valueOf(d));
    }

    public void a(String str) {
        AtomicInteger atomicInteger;
        Thread thread;
        synchronized (this.a) {
            atomicInteger = this.a.get(str);
        }
        if (atomicInteger == null || atomicInteger.decrementAndGet() != 0) {
            return;
        }
        com.tapsdk.tapad.internal.download.m.c.a(c, "decreaseLock decrease lock-count to 0 " + str);
        synchronized (this.b) {
            thread = this.b.get(str);
            if (thread != null) {
                this.b.remove(str);
            }
        }
        if (thread != null) {
            com.tapsdk.tapad.internal.download.m.c.a(c, "decreaseLock " + str + " unpark locked thread " + atomicInteger);
            a(thread);
        }
        synchronized (this.a) {
            this.a.remove(str);
        }
    }

    void a(Thread thread) {
        LockSupport.unpark(thread);
    }

    boolean a(AtomicInteger atomicInteger) {
        return atomicInteger.get() <= 0;
    }

    public void b(String str) {
        AtomicInteger atomicInteger;
        synchronized (this.a) {
            atomicInteger = this.a.get(str);
        }
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
            synchronized (this.a) {
                this.a.put(str, atomicInteger);
            }
        }
        com.tapsdk.tapad.internal.download.m.c.a(c, "increaseLock increase lock-count to " + atomicInteger.incrementAndGet() + str);
    }

    public void c(String str) {
        AtomicInteger atomicInteger;
        synchronized (this.a) {
            atomicInteger = this.a.get(str);
        }
        if (atomicInteger == null || atomicInteger.get() <= 0) {
            return;
        }
        synchronized (this.b) {
            this.b.put(str, Thread.currentThread());
        }
        com.tapsdk.tapad.internal.download.m.c.a(c, "waitForRelease start " + str);
        while (!a(atomicInteger)) {
            a();
        }
        com.tapsdk.tapad.internal.download.m.c.a(c, "waitForRelease finish " + str);
    }
}

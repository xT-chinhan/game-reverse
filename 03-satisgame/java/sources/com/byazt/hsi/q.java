package com.byazt.hsi;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1461, 5})
public final class q {
    public static final AtomicInteger n = new AtomicInteger(1);

    private q() {
    }

    private static int qg() {
        return n.getAndIncrement();
    }

    public static long n() {
        return (((long) System.identityHashCode(q.class.getClassLoader())) << 32) | (((long) qg()) & 4294967295L);
    }
}

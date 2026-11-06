package com.bytedance.ms.xr.ka;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final AtomicReference<Long> f568ms = new AtomicReference<>(0L);

    public static void ms(long j) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 5) {
                return;
            }
            AtomicReference<Long> atomicReference = f568ms;
            long jLongValue = atomicReference.get().longValue();
            if (c$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, Long.valueOf(jLongValue), Long.valueOf(jLongValue | j))) {
                return;
            } else {
                i = i2;
            }
        }
    }
}

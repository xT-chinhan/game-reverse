package com.byazt.sds;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1663, 5})
public class uc {
    public static final AtomicReference<Long> pr = new AtomicReference<>(0L);

    public static void pr(long j) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i < 5) {
                AtomicReference<Long> atomicReference = pr;
                long jLongValue = atomicReference.get().longValue();
                if (uc$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, Long.valueOf(jLongValue), Long.valueOf(jLongValue | j))) {
                    return;
                } else {
                    i = i2;
                }
            } else {
                return;
            }
        }
    }
}

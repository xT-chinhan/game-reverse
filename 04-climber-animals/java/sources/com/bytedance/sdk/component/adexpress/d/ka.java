package com.bytedance.sdk.component.adexpress.d;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    public static void ms(com.bytedance.sdk.component.ch.ny nyVar, int i) {
        if (nyVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.ms.ms.ah ahVarAh = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah();
        ExecutorService executorServiceU = ahVarAh != null ? ahVarAh.u() : null;
        if (executorServiceU != null) {
            nyVar.ms(i);
            executorServiceU.execute(nyVar);
        } else {
            com.bytedance.sdk.component.ch.ab.ms(nyVar, i);
        }
    }

    public static void xr(com.bytedance.sdk.component.ch.ny nyVar, int i) {
        if (nyVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.ms.ms.ah ahVarAh = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah();
        ExecutorService executorServiceZb = ahVarAh != null ? ahVarAh.zb() : null;
        if (executorServiceZb != null) {
            nyVar.ms(i);
            executorServiceZb.execute(nyVar);
        } else {
            com.bytedance.sdk.component.ch.ab.ms(nyVar);
        }
    }

    public static ScheduledFuture ms(Runnable runnable, long j, TimeUnit timeUnit) {
        return com.bytedance.sdk.component.ch.ab.d().schedule(runnable, j, timeUnit);
    }
}

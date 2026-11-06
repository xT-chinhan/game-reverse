package com.mcto.sspsdk.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class u4 implements Runnable {
    public final /* synthetic */ v4 a;

    public u4(v4 v4Var) {
        this.a = v4Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        this.a.i.set(false);
        v4 v4Var = this.a;
        v4Var.getClass();
        synchronized (v4.j) {
            if (v4Var.h.getAndSet(false)) {
                v4Var.a();
                long j = v4Var.e;
                int i2 = v4Var.b.get();
                HashMap map = new HashMap(Math.max(16, v4Var.c.size()));
                for (Map.Entry entry : v4Var.c.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null && (i = ((AtomicInteger) entry.getValue()).get()) > 0) {
                        map.put(entry.getKey(), Integer.valueOf(i));
                    }
                }
                try {
                    v4Var.a(j, i2, map);
                } catch (Throwable th) {
                    synchronized (v4.j) {
                        v4Var.h.set(true);
                        v4Var.c();
                    }
                }
            }
        }
    }
}

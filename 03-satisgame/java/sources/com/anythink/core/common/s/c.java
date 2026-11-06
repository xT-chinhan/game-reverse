package com.anythink.core.common.s;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes.dex */
public class c implements a {
    private static final String a = "TimeOutHandlerImpl";
    private static volatile c b;
    private final ConcurrentHashMap<com.anythink.core.common.u.b.d, ScheduledFuture<?>> c = new ConcurrentHashMap<>();

    public static a a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    private c() {
    }

    @Override // com.anythink.core.common.s.a
    public final void a(com.anythink.core.common.u.b.d dVar, long j) {
        if (dVar == null) {
            return;
        }
        this.c.put(dVar, com.anythink.core.common.u.b.c.a().b(dVar, j));
    }

    @Override // com.anythink.core.common.s.a
    public final void a(com.anythink.core.common.u.b.d dVar) {
        if (dVar == null) {
            return;
        }
        ScheduledFuture<?> scheduledFutureRemove = this.c.remove(dVar);
        com.anythink.core.common.u.b.c.a();
        com.anythink.core.common.u.b.c.a(scheduledFutureRemove);
    }
}

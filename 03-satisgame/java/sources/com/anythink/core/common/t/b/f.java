package com.anythink.core.common.t.b;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes.dex */
public class f {
    private static final String a = "anythink_f";
    private final Map<String, ScheduledFuture<?>> b = new ConcurrentHashMap();

    public final void a(String str, Runnable runnable) {
        a(str);
        this.b.put(str, com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cX, runnable), 3000L));
    }

    public final void a(String str) {
        ScheduledFuture<?> scheduledFutureRemove;
        if (str == null || (scheduledFutureRemove = this.b.remove(str)) == null) {
            return;
        }
        com.anythink.core.common.u.b.c.a();
        com.anythink.core.common.u.b.c.a(scheduledFutureRemove);
    }

    private void a() {
        for (ScheduledFuture<?> scheduledFuture : this.b.values()) {
            com.anythink.core.common.u.b.c.a();
            com.anythink.core.common.u.b.c.a(scheduledFuture);
        }
        this.b.clear();
    }

    public final boolean b(String str) {
        return str != null && this.b.containsKey(str);
    }
}

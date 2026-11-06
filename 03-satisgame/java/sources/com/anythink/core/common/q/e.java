package com.anythink.core.common.q;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final String a = "e";
    private final Map<String, Integer> b = new ConcurrentHashMap();
    private final Map<String, ScheduledFuture<?>> c = new ConcurrentHashMap();

    public final void a(h hVar, a aVar) {
        g gVar;
        Integer numValueOf;
        if (hVar != null) {
            try {
                gVar = hVar.j;
            } catch (Throwable unused) {
                return;
            }
        } else {
            gVar = null;
        }
        if (gVar != null && gVar.a(16, hVar.b)) {
            String str = hVar.b;
            Integer num = this.b.get(str);
            if (num != null) {
                numValueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                numValueOf = 1;
            }
            hVar.i = numValueOf.intValue();
            this.b.put(str, numValueOf);
            if (numValueOf.intValue() > gVar.g()) {
                return;
            }
            this.c.put(str, com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cN, new f(hVar, aVar)), gVar.h() * ((long) numValueOf.intValue())));
        }
    }

    public final void a(h hVar) {
        if (hVar == null) {
            return;
        }
        String str = hVar.b;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            hVar.i = 0;
            this.b.remove(str);
            ScheduledFuture<?> scheduledFutureRemove = this.c.remove(str);
            com.anythink.core.common.u.b.c.a();
            com.anythink.core.common.u.b.c.a(scheduledFutureRemove);
        } catch (Throwable unused) {
        }
    }
}

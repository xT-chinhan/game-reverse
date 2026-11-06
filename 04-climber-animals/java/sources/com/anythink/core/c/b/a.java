package com.anythink.core.c.b;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    e b;
    private final String c = getClass().getSimpleName();
    Map<String, com.anythink.core.c.a.c> a = new ConcurrentHashMap();

    public a(e eVar) {
        this.b = eVar;
    }

    private com.anythink.core.c.a.d a(String str, int i, com.anythink.core.d.f fVar) {
        com.anythink.core.c.a.c cVar = this.a.get(str);
        int i2 = fVar.a() == 1 ? i : -1;
        if (cVar == null || !cVar.b(fVar) || cVar.a(i2) == null) {
            cVar = new com.anythink.core.c.a.c();
            cVar.a(fVar);
            int iC = fVar.c();
            long jCurrentTimeMillis = System.currentTimeMillis() - (((long) (((fVar.b() * 24) * 60) * 60)) * 1000);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(jCurrentTimeMillis);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            cVar.a(i2, this.b.a(str, i2, calendar.getTimeInMillis(), iC));
            this.a.put(str, cVar);
        } else {
            cVar.c(i);
        }
        return cVar.b(i2);
    }

    private void a(String str, com.anythink.core.c.a.a aVar) {
        com.anythink.core.c.a.c cVar = this.a.get(str);
        new StringBuilder("insertOrUpdateLoadedUnitGroupInfo::placementId:").append(str).append("segmentId:").append(aVar.a()).append(":::").append(aVar);
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    private List<com.anythink.core.c.a.a> a(String str, int i, com.anythink.core.d.f fVar, int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis() - (((long) (((fVar.b() * 24) * 60) * 60)) * 1000);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(jCurrentTimeMillis);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return this.b.a(str, i, calendar.getTimeInMillis(), i2);
    }
}

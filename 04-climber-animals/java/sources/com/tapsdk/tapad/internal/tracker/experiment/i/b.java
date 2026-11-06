package com.tapsdk.tapad.internal.tracker.experiment.i;

import com.tapsdk.tapad.internal.tracker.experiment.entities.ExpTrackMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class b implements a {
    private final Map<String, AtomicInteger> a = new HashMap();

    @Override // com.tapsdk.tapad.internal.tracker.experiment.i.a
    public boolean a(ExpTrackMessage expTrackMessage) {
        Map<String, String> map = expTrackMessage.logContentsMap;
        if (!map.containsKey("url")) {
            return false;
        }
        String str = map.get("url");
        if (!com.tapsdk.tapad.internal.network.c.a.c(str)) {
            return false;
        }
        if (this.a.containsKey(str)) {
            AtomicInteger atomicInteger = this.a.get(str);
            return atomicInteger != null && atomicInteger.incrementAndGet() % 10 == 1;
        }
        this.a.put(str, new AtomicInteger(1));
        return true;
    }
}

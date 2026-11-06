package com.tapsdk.tapad.internal.tracker.experiment;

import android.app.Application;
import android.text.TextUtils;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class f {
    private static final Map<String, c> a = new ConcurrentHashMap();
    private static final Map<String, com.tapsdk.tapad.internal.tracker.experiment.i.a> b = new HashMap();

    public static class a {
        public static f a = new f();
    }

    private c a(ExpTdsTrackerConfig expTdsTrackerConfig, Application application, com.tapsdk.tapad.internal.tracker.experiment.i.a aVar) {
        c cVar;
        String str = expTdsTrackerConfig.g;
        Map<String, com.tapsdk.tapad.internal.tracker.experiment.i.a> map = b;
        map.put(str, aVar);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, c> map2 = a;
        return (!map2.containsKey(str) || (cVar = map2.get(str)) == null) ? new c(expTdsTrackerConfig, application, a(), map) : cVar;
    }

    public static f b() {
        return a.a;
    }

    public c a(int i) {
        Map<String, c> map = a;
        if (map.containsKey(g.a(i))) {
            return map.get(g.a(i));
        }
        return null;
    }

    public PublishSubject<com.tapsdk.tapad.internal.tracker.experiment.entities.c> a() {
        return com.tapsdk.tapad.b.e();
    }

    public void b(ExpTdsTrackerConfig expTdsTrackerConfig, Application application, com.tapsdk.tapad.internal.tracker.experiment.i.a aVar) {
        a.put(expTdsTrackerConfig.g, a(expTdsTrackerConfig, application, aVar));
    }
}

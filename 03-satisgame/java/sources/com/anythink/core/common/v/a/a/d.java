package com.anythink.core.common.v.a.a;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final String a = "d";
    private static volatile Map<String, Map<Class<? extends com.anythink.core.common.v.a.b.b>, com.anythink.core.common.v.a.b.b>> b;

    private static Map<Class<? extends com.anythink.core.common.v.a.b.b>, com.anythink.core.common.v.a.b.b> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new ConcurrentHashMap();
                }
            }
        }
        Map<Class<? extends com.anythink.core.common.v.a.b.b>, com.anythink.core.common.v.a.b.b> map = b.get(str);
        if (map != null) {
            return map;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        a aVar = new a();
        b bVar = new b(str, aVar);
        concurrentHashMap.put(com.anythink.core.common.v.a.b.e.class, new e(str, aVar, bVar));
        concurrentHashMap.put(com.anythink.core.common.v.a.b.c.class, aVar);
        concurrentHashMap.put(com.anythink.core.common.v.a.b.d.class, bVar);
        b.put(str, concurrentHashMap);
        return concurrentHashMap;
    }

    public static <M extends com.anythink.core.common.v.a.b.b> M a(String str, Class<M> cls) {
        Map<Class<? extends com.anythink.core.common.v.a.b.b>, com.anythink.core.common.v.a.b.b> mapB = b(str);
        if (mapB != null) {
            return (M) mapB.get(cls);
        }
        return null;
    }

    public static void a(String str) {
        Map<Class<? extends com.anythink.core.common.v.a.b.b>, com.anythink.core.common.v.a.b.b> map;
        com.anythink.core.common.v.a.b.b bVar;
        if (b == null || TextUtils.isEmpty(str) || (map = b.get(str)) == null || map.isEmpty()) {
            return;
        }
        for (Class<? extends com.anythink.core.common.v.a.b.b> cls : map.keySet()) {
            if (cls != null && (bVar = map.get(cls)) != null) {
                bVar.b();
            }
        }
    }
}

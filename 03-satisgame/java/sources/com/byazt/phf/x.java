package com.byazt.phf;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1735, 21})
public final class x {
    public static final ConcurrentHashMap<String, WeakReference<l>> n = new ConcurrentHashMap<>();

    public static void n(Object obj, l lVar) {
        if (!(obj instanceof String) || lVar == null) {
            return;
        }
        n.put((String) obj, new WeakReference<>(lVar));
    }

    public static l n(Object obj) {
        String str;
        ConcurrentHashMap<String, WeakReference<l>> concurrentHashMap;
        WeakReference<l> weakReference;
        if (!(obj instanceof String) || (weakReference = (concurrentHashMap = n).get((str = (String) obj))) == null) {
            return null;
        }
        l lVar = weakReference.get();
        if (lVar == null) {
            concurrentHashMap.remove(str);
        }
        return lVar;
    }

    public static void qg(Object obj) {
        if (obj instanceof String) {
            n.remove(obj);
        }
    }
}

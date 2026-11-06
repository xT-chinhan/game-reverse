package com.byazt.sd;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, 213})
public class cz {
    public static final Map<Class, Map> pr = new ConcurrentHashMap();
    public static final Map<Class, Map<String, WeakReference<?>>> hw = new ConcurrentHashMap();
    public static final Map<Class, Map> hn = new ConcurrentHashMap();

    public static <T> void pr(String str, T t, Class cls) {
        if (t == null) {
            return;
        }
        Map<Class, Map> map = pr;
        Map map2 = map.get(cls);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(cls, map2);
        }
        map2.put(str, t);
    }

    public static <T> void pr(String str) {
        try {
            Iterator<Class> it = pr.keySet().iterator();
            while (it.hasNext()) {
                Map map = pr.get(it.next());
                if (map != null) {
                    map.remove(str);
                }
            }
            Iterator<Class> it2 = hw.keySet().iterator();
            while (it2.hasNext()) {
                Map<String, WeakReference<?>> map2 = hw.get(it2.next());
                if (map2 != null) {
                    map2.remove(str);
                }
            }
        } catch (Throwable th) {
            com.byazt.xk.hw.pr().pr("in_map_error", th);
        }
    }

    public static <T> T pr(String str, Class<T> cls) {
        Map map;
        if (cls == null || str == null || (map = pr.get(cls)) == null) {
            return null;
        }
        return (T) map.get(str);
    }

    public static <T> T hw(String str, Class<T> cls) {
        Map map;
        if (cls == null || str == null || (map = pr.get(cls)) == null) {
            return null;
        }
        return (T) map.remove(str);
    }

    public static <T> void hw(String str, T t, Class cls) {
        if (t == null || cls == null || str == null) {
            return;
        }
        Map<Class, Map<String, WeakReference<?>>> map = hw;
        Map<String, WeakReference<?>> map2 = map.get(cls);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(cls, map2);
        }
        map2.put(str, new WeakReference<>(t));
    }

    public static <T> T hn(String str, Class<T> cls) {
        Map<String, WeakReference<?>> map;
        WeakReference<?> weakReference;
        if (cls == null || str == null || (map = hw.get(cls)) == null || (weakReference = map.get(str)) == null) {
            return null;
        }
        Object obj = weakReference.get();
        if (obj == null) {
            map.remove(str);
            return null;
        }
        return cls.cast(obj);
    }

    public static <T> void hn(String str, T t, Class cls) {
        if (t == null || cls == null || str == null) {
            return;
        }
        Map<Class, Map> map = hn;
        Map map2 = map.get(cls);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(cls, map2);
        }
        map2.put(str, t);
    }

    public static <T> T x(String str, Class<T> cls) {
        Map map;
        if (cls == null || str == null || (map = hn.get(cls)) == null) {
            return null;
        }
        return (T) map.remove(str);
    }
}

package com.byazt.ikv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_SDK_DNS_IP, 26})
public class qg {
    public static final Map<Class, Map> n = new ConcurrentHashMap();
    public static final Map<Class, Map<String, WeakReference<?>>> qg = new ConcurrentHashMap();
    public static final Map<Class, Map> s = new ConcurrentHashMap();

    public static <T> void n(String str, T t, Class cls) {
        if (t == null) {
            return;
        }
        Map<Class, Map> map = n;
        Map map2 = map.get(cls);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(cls, map2);
        }
        map2.put(str, t);
    }

    public static <T> void n(String str) {
        try {
            Iterator<Class> it = n.keySet().iterator();
            while (it.hasNext()) {
                Map map = n.get(it.next());
                if (map != null) {
                    map.remove(str);
                }
            }
            Iterator<Class> it2 = qg.keySet().iterator();
            while (it2.hasNext()) {
                Map<String, WeakReference<?>> map2 = qg.get(it2.next());
                if (map2 != null) {
                    map2.remove(str);
                }
            }
        } catch (Throwable th) {
            com.byazt.eji.s.n().n("in_map_error", th);
        }
    }

    public static <T> T n(String str, Class<T> cls) {
        Map map;
        if (cls == null || str == null || (map = n.get(cls)) == null) {
            return null;
        }
        return (T) map.get(str);
    }

    public static <T> T qg(String str, Class<T> cls) {
        Map map;
        if (cls == null || str == null || (map = n.get(cls)) == null) {
            return null;
        }
        return (T) map.remove(str);
    }

    public static <T> void qg(String str, T t, Class cls) {
        if (t == null || cls == null || str == null) {
            return;
        }
        Map<Class, Map<String, WeakReference<?>>> map = qg;
        Map<String, WeakReference<?>> map2 = map.get(cls);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(cls, map2);
        }
        map2.put(str, new WeakReference<>(t));
    }

    public static <T> T s(String str, Class<T> cls) {
        Map<String, WeakReference<?>> map;
        WeakReference<?> weakReference;
        if (cls == null || str == null || (map = qg.get(cls)) == null || (weakReference = map.get(str)) == null) {
            return null;
        }
        Object obj = weakReference.get();
        if (obj == null) {
            map.remove(str);
            return null;
        }
        return cls.cast(obj);
    }

    public static <T> void s(String str, T t, Class cls) {
        if (t == null || cls == null || str == null) {
            return;
        }
        Map<Class, Map> map = s;
        Map map2 = map.get(cls);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(cls, map2);
        }
        map2.put(str, t);
    }

    public static <T> T q(String str, Class<T> cls) {
        Map map;
        if (cls == null || str == null || (map = s.get(cls)) == null) {
            return null;
        }
        return (T) map.remove(str);
    }
}

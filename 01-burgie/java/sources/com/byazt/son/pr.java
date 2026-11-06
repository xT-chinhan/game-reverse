package com.byazt.son;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1721, 37})
public final class pr {
    public static final Object pr = new Object();
    public static final Map<x, String> hw = new WeakHashMap();
    public static final Map<String, Map<x, Set<String>>> hn = new HashMap();

    public static void pr(String str, x xVar) {
        if (TextUtils.isEmpty(str) || xVar == null) {
            return;
        }
        synchronized (pr) {
            Map<x, String> map = hw;
            String str2 = map.get(xVar);
            if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str2, str)) {
                hw(str2, xVar);
            }
            map.put(xVar, str);
            hw(str);
        }
    }

    public static void pr(x xVar, String str) {
        if (xVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (pr) {
            String str2 = hw.get(xVar);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            Map<x, Set<String>> mapHw = hw(str2);
            Set<String> hashSet = mapHw.get(xVar);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                mapHw.put(xVar, hashSet);
            }
            hashSet.add(str);
        }
    }

    public static void hw(x xVar, String str) {
        if (xVar == null) {
            return;
        }
        synchronized (pr) {
            String str2 = hw.get(xVar);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            Map<x, Set<String>> map = hn.get(str2);
            if (map == null) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                map.remove(xVar);
                pr(str2, map);
                return;
            }
            Set<String> set = map.get(xVar);
            if (set == null) {
                return;
            }
            set.remove(str);
            if (set.isEmpty()) {
                map.remove(xVar);
            }
            pr(str2, map);
        }
    }

    public static void pr(x xVar, String str, String str2, Object obj) {
        Set set;
        if (xVar == null || TextUtils.isEmpty(str2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (pr) {
            String str3 = hw.get(xVar);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            Map<x, Set<String>> map = hn.get(str3);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : new ArrayList(map.entrySet())) {
                    x xVar2 = (x) entry.getKey();
                    if (xVar2 != null && xVar2 != xVar && (set = (Set) entry.getValue()) != null && set.contains(str2)) {
                        arrayList.add(xVar2);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((x) it.next()).pr(str, str2, obj);
                }
            }
        }
    }

    public static void pr(x xVar) {
        if (xVar == null) {
            return;
        }
        synchronized (pr) {
            String strRemove = hw.remove(xVar);
            if (TextUtils.isEmpty(strRemove)) {
                return;
            }
            hw(strRemove, xVar);
        }
    }

    public static void pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (pr) {
            Map<x, Set<String>> mapRemove = hn.remove(str);
            if (mapRemove != null && !mapRemove.isEmpty()) {
                Iterator it = new ArrayList(mapRemove.keySet()).iterator();
                while (it.hasNext()) {
                    hw.remove((x) it.next());
                }
            }
        }
    }

    private static Map<x, Set<String>> hw(String str) {
        Map<String, Map<x, Set<String>>> map = hn;
        Map<x, Set<String>> map2 = map.get(str);
        if (map2 == null) {
            WeakHashMap weakHashMap = new WeakHashMap();
            map.put(str, weakHashMap);
            return weakHashMap;
        }
        return map2;
    }

    private static void hw(String str, x xVar) {
        Map<x, Set<String>> map = hn.get(str);
        if (map == null) {
            return;
        }
        map.remove(xVar);
        pr(str, map);
    }

    private static void pr(String str, Map<x, Set<String>> map) {
        if (map == null || !map.isEmpty()) {
            return;
        }
        hn.remove(str);
    }
}

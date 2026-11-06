package com.byazt.mh;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1196, 26})
public class qg {
    public static String n = "AdapterPl";
    public static final Set<String> qg = new CopyOnWriteArraySet();
    public static volatile Map<String, Map<String, Object>> s = new ConcurrentHashMap(1);

    public static boolean n(String str) {
        Set<String> set = qg;
        if (set.contains(str)) {
            return true;
        }
        set.add(str);
        return false;
    }

    public static Map<String, Map<String, Object>> n() {
        return s;
    }
}

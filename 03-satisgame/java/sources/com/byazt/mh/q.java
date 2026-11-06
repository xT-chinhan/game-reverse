package com.byazt.mh;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1196, 5})
public class q {
    public static Map<String, com.byazt.zh.s> n = new ConcurrentHashMap();

    public static com.byazt.zh.s n(String str) {
        if (!l.l(str)) {
            return null;
        }
        com.byazt.zh.s sVar = n.get(str);
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(str);
        n.put(str, sVar2);
        return sVar2;
    }

    public static Set<String> n() {
        return n.keySet();
    }
}

package com.byazt.wu;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1538, 19})
public class n {
    public static volatile n n;
    public static Map<String, Map<String, Object>> qg = new HashMap();

    private n() {
    }

    public static n n() {
        if (n != null) {
            return n;
        }
        synchronized (n.class) {
            if (n != null) {
                return n;
            }
            n nVar = new n();
            n = nVar;
            return nVar;
        }
    }

    public Map<String, Object> n(String str) {
        Map<String, Object> map = qg.get(str);
        if (map != null) {
            return map;
        }
        HashMap map2 = new HashMap();
        qg.put(str, map2);
        return map2;
    }
}

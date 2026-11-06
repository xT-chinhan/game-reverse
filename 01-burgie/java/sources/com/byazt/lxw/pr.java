package com.byazt.lxw;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 156, 37})
public class pr {
    public static Map<String, Map<String, Object>> hw = new HashMap();
    public static volatile pr pr;

    private pr() {
    }

    public static pr pr() {
        if (pr != null) {
            return pr;
        }
        synchronized (pr.class) {
            if (pr != null) {
                return pr;
            }
            pr prVar = new pr();
            pr = prVar;
            return prVar;
        }
    }

    public Map<String, Object> pr(String str) {
        Map<String, Object> map = hw.get(str);
        if (map != null) {
            return map;
        }
        HashMap map2 = new HashMap();
        hw.put(str, map2);
        return map2;
    }
}

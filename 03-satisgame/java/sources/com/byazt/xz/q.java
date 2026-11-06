package com.byazt.xz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 774, 5})
public class q {
    public static Map<String, qg> n = new HashMap();

    public static void n(List<qg> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (qg qgVar : list) {
            if (qgVar != null) {
                n.put(qgVar.n(), qgVar);
            }
        }
    }

    public static qg n(String str) {
        return n.get(str);
    }
}

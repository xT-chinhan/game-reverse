package com.byazt.xz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 774, 29})
public class cp {
    public static Map<String, fs> n = new HashMap();

    public static void n(List<fs> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (fs fsVar : list) {
            if (fsVar != null) {
                n.put(fsVar.n(), fsVar);
            }
        }
    }

    public static fs n(String str) {
        return n.get(str);
    }
}

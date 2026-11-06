package com.byazt.p001if;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2430, 19})
public final class n {
    public static Map<String, Object> n() {
        return n("no_appid_prefix");
    }

    public static Map<String, Object> qg() {
        return n("keep_original_sp_name");
    }

    public static Map<String, Object> n(String str) {
        HashMap map = new HashMap();
        map.put(str, Boolean.TRUE);
        return map;
    }
}

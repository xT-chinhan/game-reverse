package com.byazt.aun;

import androidx.core.internal.view.SupportMenu;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 898, 21})
public class x {
    public static final Map<String, Integer> n;
    public static final Map<String, String> qg;

    public static int n(int i) {
        return i & SupportMenu.USER_MASK;
    }

    public static int qg(int i) {
        return (i >>> 16) & SupportMenu.USER_MASK;
    }

    static {
        HashMap map = new HashMap();
        n = map;
        HashMap map2 = new HashMap();
        qg = map2;
        map.put("strategy_req_drop", 1);
        map.put("c_s_s_performance_device_level", 1);
        map2.put("c_s_s_performance_device_level", "{\"device_level\" : -1000}");
    }
}

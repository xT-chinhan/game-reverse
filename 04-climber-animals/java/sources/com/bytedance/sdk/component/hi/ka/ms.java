package com.bytedance.sdk.component.hi.ka;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ms f1239ms;
    private static Map<String, Map<String, Object>> xr = new HashMap();

    private ms() {
    }

    public static ms ms() {
        if (f1239ms != null) {
            return f1239ms;
        }
        synchronized (ms.class) {
            if (f1239ms != null) {
                return f1239ms;
            }
            ms msVar = new ms();
            f1239ms = msVar;
            return msVar;
        }
    }

    public Map<String, Object> ms(String str) {
        Map<String, Object> map = xr.get(str);
        if (map != null) {
            return map;
        }
        HashMap map2 = new HashMap();
        xr.put(str, map2);
        return map2;
    }
}

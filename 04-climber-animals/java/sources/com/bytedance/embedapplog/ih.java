package com.bytedance.embedapplog;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ih {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final j f493ms = new j();
    private static final Map<String, String> xr = new ConcurrentHashMap();

    public static String ms(String str) {
        Map<String, String> map = xr;
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String strMs = f493ms.ms(str);
        if (strMs != null) {
            map.put(str, strMs);
        }
        return strMs;
    }
}

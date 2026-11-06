package com.anythink.core.common.v;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class j {
    private static String a = "j";

    public static Map<String, Object> a(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        try {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (TextUtils.equals(key, ATAdConst.KEY.AD_WIDTH) || TextUtils.equals(key, ATAdConst.KEY.AD_HEIGHT)) {
                        try {
                            value = Integer.valueOf((int) Double.parseDouble(value.toString()));
                        } catch (Throwable unused) {
                        }
                    }
                    Object[] objArr = new Object[3];
                    concurrentHashMap.put(key, value);
                }
            } catch (Throwable unused2) {
            }
            return concurrentHashMap;
        } catch (Throwable unused3) {
            return null;
        }
    }

    public static void a(Map<String, Object> map, Map<String, Object> map2) {
        if (map == null || map2 == null) {
            return;
        }
        try {
            if (map2.isEmpty()) {
                return;
            }
            for (Map.Entry<String, Object> entry : map2.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && value != null) {
                    map.put(key, value);
                }
            }
        } catch (Throwable unused) {
        }
    }
}

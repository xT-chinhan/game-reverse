package com.bytedance.sdk.component.ab.ms;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public Map<String, Object> ms(Map<String, Object> map, com.bytedance.sdk.component.d.ms.ms msVar, boolean z) {
        if (msVar == null) {
            return map;
        }
        Map<String, Object> concurrentHashMap = z ? new ConcurrentHashMap<>() : map;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (z) {
                key = (String) msVar.xr(key);
            }
            concurrentHashMap.put(key, msVar.xr(value.toString()));
        }
        return concurrentHashMap;
    }

    public Map<String, Object> xr(Map<String, Object> map, com.bytedance.sdk.component.d.ms.ms msVar, boolean z) {
        if (msVar == null) {
            return map;
        }
        Map<String, Object> concurrentHashMap = z ? new ConcurrentHashMap<>() : map;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (z) {
                key = msVar.ms(key);
            }
            concurrentHashMap.put(key, msVar.ms(value.toString()));
        }
        return concurrentHashMap;
    }
}

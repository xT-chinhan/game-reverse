package com.byazt.ox;

import com.byazt.cr.hn;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1739, 13})
public class hw {
    public Map<String, Object> pr(Map<String, Object> map, hn hnVar, boolean z) {
        Map<String, Object> concurrentHashMap;
        if (hnVar == null) {
            return map;
        }
        if (z) {
            concurrentHashMap = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap = map;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (z) {
                key = hnVar.hw(key);
            }
            concurrentHashMap.put(key, hnVar.hw(value.toString()));
        }
        return concurrentHashMap;
    }

    public Map<String, Object> hw(Map<String, Object> map, hn hnVar, boolean z) {
        Map<String, Object> concurrentHashMap;
        if (hnVar == null) {
            return map;
        }
        if (z) {
            concurrentHashMap = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap = map;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (z) {
                key = hnVar.pr(key);
            }
            concurrentHashMap.put(key, hnVar.pr(value.toString()));
        }
        return concurrentHashMap;
    }
}

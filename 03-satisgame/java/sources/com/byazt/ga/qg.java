package com.byazt.ga;

import com.byazt.eau.s;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE, 26})
public class qg {
    public Map<String, Object> n(Map<String, Object> map, s sVar, boolean z) {
        if (sVar == null) {
            return map;
        }
        Map<String, Object> concurrentHashMap = z ? new ConcurrentHashMap<>() : map;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (z) {
                key = sVar.qg(key);
            }
            concurrentHashMap.put(key, sVar.qg(value.toString()));
        }
        return concurrentHashMap;
    }

    public Map<String, Object> qg(Map<String, Object> map, s sVar, boolean z) {
        if (sVar == null) {
            return map;
        }
        Map<String, Object> concurrentHashMap = z ? new ConcurrentHashMap<>() : map;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (z) {
                key = sVar.n(key);
            }
            concurrentHashMap.put(key, sVar.n(value.toString()));
        }
        return concurrentHashMap;
    }
}

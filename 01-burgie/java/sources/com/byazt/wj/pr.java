package com.byazt.wj;

import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSION_TIME_MS, 37})
public final class pr {
    public static final Map<String, LinkedHashMap<String, Long>> pr = new HashMap();
    public static final Object hw = new Object();

    public static String pr(String str, String str2) {
        if (hw.hw() >= 8) {
            return "depth_overflow";
        }
        if (hw.hw(str2)) {
            return "cycle_detected";
        }
        if (hw(str, str2)) {
            return "same_frame_dropped";
        }
        return null;
    }

    private static boolean hw(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        long jUptimeMillis = SystemClock.uptimeMillis() / 16;
        synchronized (hw) {
            Map<String, LinkedHashMap<String, Long>> map = pr;
            LinkedHashMap<String, Long> linkedHashMap = map.get(str);
            boolean z = true;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<String, Long>(16, 0.75f, z) { // from class: com.byazt.wj.pr.1
                    @Override // java.util.LinkedHashMap
                    public boolean removeEldestEntry(Map.Entry<String, Long> entry) {
                        return size() > 64;
                    }
                };
                map.put(str, linkedHashMap);
            }
            Long l = linkedHashMap.get(str2);
            if (l != null && l.longValue() == jUptimeMillis) {
                return true;
            }
            linkedHashMap.put(str2, Long.valueOf(jUptimeMillis));
            return false;
        }
    }

    public static void pr(String str) {
        if (str == null) {
            str = "";
        }
        synchronized (hw) {
            pr.remove(str);
        }
    }
}

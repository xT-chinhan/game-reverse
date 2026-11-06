package com.byazt.hy;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH, 13})
public class hw implements x {
    @Override // com.byazt.hy.x
    public String pr() {
        return "animateState";
    }

    @Override // com.byazt.hy.x
    public boolean pr(com.byazt.mu.pr.C0137pr c0137pr, Map<String, Object> map) {
        if (c0137pr == null) {
            return false;
        }
        Map<String, Object> mapPr = c0137pr.pr();
        if (mapPr == null || mapPr.isEmpty()) {
            return true;
        }
        if (map == null) {
            map = Collections.emptyMap();
        }
        for (Map.Entry<String, Object> entry : mapPr.entrySet()) {
            String key = entry.getKey();
            if (!map.containsKey(key) || !pr(entry.getValue(), map.get(key))) {
                return false;
            }
        }
        return true;
    }

    private static boolean pr(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return String.valueOf(obj).equals(String.valueOf(obj2));
    }
}

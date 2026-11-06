package com.byazt.qu;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, 26})
public class qg {
    public static Map<String, Object> n(Map<String, Object> map, Map<String, Object> map2) {
        if (map == null) {
            return map2;
        }
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }
}

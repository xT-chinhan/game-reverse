package com.byazt.dd;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_AUDIO_FIRSTSEG_CONNECT_TIME, 109})
public class w {
    public static Map<String, zo> pr = new HashMap();

    public static void pr(List<zo> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (zo zoVar : list) {
            if (zoVar != null) {
                pr.put(zoVar.pr(), zoVar);
            }
        }
    }

    public static zo pr(String str) {
        return pr.get(str);
    }
}

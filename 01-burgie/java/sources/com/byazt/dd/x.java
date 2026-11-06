package com.byazt.dd;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_AUDIO_FIRSTSEG_CONNECT_TIME, 121})
public class x {
    public static Map<String, hw> pr = new HashMap();

    public static void pr(List<hw> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (hw hwVar : list) {
            if (hwVar != null) {
                pr.put(hwVar.pr(), hwVar);
            }
        }
    }

    public static hw pr(String str) {
        return pr.get(str);
    }
}

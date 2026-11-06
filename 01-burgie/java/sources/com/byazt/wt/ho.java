package com.byazt.wt;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 19})
public class ho {
    public static String pr(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        if (!TextUtils.isEmpty(map.get("content-type"))) {
            return map.get("content-type");
        }
        return map.get("Content-Type");
    }
}

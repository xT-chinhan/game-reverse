package com.byazt.ewt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1073, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public Map<String, Object> hw = new ConcurrentHashMap();
    public long pr;

    public zo(long j) {
        this.pr = j;
    }

    public long pr() {
        return this.pr;
    }

    public void pr(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        this.hw.put(str, obj);
    }

    public Object pr(String str) {
        if (str == null) {
            return null;
        }
        return this.hw.get(str);
    }
}

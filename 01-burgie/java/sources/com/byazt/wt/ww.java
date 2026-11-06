package com.byazt.wt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 576})
public class ww<K, V> extends HashMap<K, V> {
    /* JADX WARN: Multi-variable type inference failed */
    public ww<String, Object> pr(K k, V v) {
        put(k, v);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ww<String, Object> pr(Map<? extends K, ? extends V> map) {
        putAll(map);
        return this;
    }
}

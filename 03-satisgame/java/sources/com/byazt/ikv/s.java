package com.byazt.ikv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_SDK_DNS_IP, 8})
public class s<K, V> extends HashMap<K, V> {
    /* JADX WARN: Multi-variable type inference failed */
    public s<String, Object> n(K k, V v) {
        put(k, v);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s<String, Object> n(Map<? extends K, ? extends V> map) {
        putAll(map);
        return this;
    }
}

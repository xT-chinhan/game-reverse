package com.byazt.ta;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 101})
public class fs<K, T> extends LinkedHashMap<K, T> {
    public int n;

    public fs() {
        this(4, 4);
    }

    public fs(int i, int i2) {
        this(i, i2, true);
    }

    public fs(int i, int i2, boolean z) {
        super(i, 0.75f, z);
        n(i2);
    }

    public void n(int i) {
        this.n = i;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.n;
    }
}

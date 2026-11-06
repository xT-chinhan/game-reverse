package com.byazt.tuy;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_OUTFPS_LIST, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo<K, T> extends LinkedHashMap<K, T> {
    public int pr;

    public zo() {
        this(4, 4);
    }

    public zo(int i, int i2) {
        this(i, i2, true);
    }

    public zo(int i, int i2, boolean z) {
        super(i, 0.75f, z);
        pr(i2);
    }

    public void pr(int i) {
        this.pr = i;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.pr;
    }
}

package com.byazt.bok;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC, 13})
public class w {
    public long n;
    public Map<String, Object> qg = new ConcurrentHashMap();

    public w(long j) {
        this.n = j;
    }

    public long n() {
        return this.n;
    }

    public void n(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        this.qg.put(str, obj);
    }

    public Object n(String str) {
        if (str == null) {
            return null;
        }
        return this.qg.get(str);
    }
}

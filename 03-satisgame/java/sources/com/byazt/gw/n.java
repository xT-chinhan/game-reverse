package com.byazt.gw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS, 19})
public class n {
    public int qg = 0;
    public Map<Integer, Long> n = new ConcurrentHashMap();

    public void n() {
        this.qg = 0;
        try {
            this.n.clear();
        } catch (Exception unused) {
        }
    }

    public boolean n(int i) {
        return (this.qg & i) == i;
    }

    public Long qg(int i) {
        try {
            if (n(i)) {
                return this.n.get(Integer.valueOf(i));
            }
        } catch (Exception unused) {
        }
        return -1L;
    }

    public void s(int i) {
        if (n(i)) {
            return;
        }
        this.qg |= i;
        try {
            this.n.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
        } catch (Exception unused) {
        }
    }

    public boolean q(int i) {
        return i == this.qg;
    }
}

package com.byazt.ne;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_EXIT, 37})
public class pr {
    public int hw = 0;
    public Map<Integer, Long> pr = new ConcurrentHashMap();

    public void pr() {
        this.hw = 0;
        try {
            this.pr.clear();
        } catch (Exception e) {
        }
    }

    public boolean pr(int i) {
        return (this.hw & i) == i;
    }

    public Long hw(int i) {
        try {
            if (pr(i)) {
                return this.pr.get(Integer.valueOf(i));
            }
        } catch (Exception e) {
        }
        return -1L;
    }

    public void hn(int i) {
        if (!pr(i)) {
            this.hw |= i;
            try {
                this.pr.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
            } catch (Exception e) {
            }
        }
    }

    public boolean x(int i) {
        return i == this.hw;
    }
}

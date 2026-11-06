package com.byazt.jy;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BARRAGE_MASK, 5})
public class uc {
    public long hn;
    public long hw;
    public String pr;

    public String getType() {
        return this.pr;
    }

    public void pr(String str) {
        this.pr = str;
    }

    public long pr() {
        return this.hw;
    }

    public void pr(long j) {
        this.hw = j;
    }

    public long hw() {
        return this.hn;
    }

    public void hw(long j) {
        this.hn = j;
    }

    public boolean hn() {
        return "time".equals(this.pr);
    }
}

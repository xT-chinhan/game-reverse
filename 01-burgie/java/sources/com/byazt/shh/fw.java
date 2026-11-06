package com.byazt.shh;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DOWNLOAD_BYTES, 62})
public class fw {
    public String hn;
    public int hw;
    public int pr;

    public fw(int i) {
        this(i, 0, null);
    }

    public fw(int i, int i2) {
        this(i, i2, null);
    }

    public fw(int i, String str) {
        this(i, 0, str);
    }

    public fw(int i, int i2, String str) {
        this.pr = i;
        this.hw = i2;
        this.hn = str;
    }

    public int getType() {
        return this.pr;
    }

    public int pr() {
        return this.hw;
    }

    public String hw() {
        return this.hn;
    }
}

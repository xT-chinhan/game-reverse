package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public abstract class oa {
    public int n;

    public abstract double fs();

    public abstract String l();

    public abstract int q();

    public abstract int s();

    public abstract int w();

    public abstract int x();

    public int n() {
        return this.n;
    }

    public boolean qg() {
        int i = this.n;
        return i == 1 || i == 2;
    }
}

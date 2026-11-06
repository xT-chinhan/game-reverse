package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1696})
public class kc {
    public int l;
    public int n;
    public int q;
    public double qg;
    public int s;

    public kc(int i, double d, int i2, int i3) {
        this.n = i;
        this.qg = d;
        this.s = i2;
        this.q = i3;
    }

    public void n(int i) {
        this.l = i;
    }

    public int n() {
        return this.q;
    }

    public int qg() {
        return this.n;
    }

    public double s() {
        return this.qg;
    }

    public int q() {
        return this.s;
    }
}

package com.byazt.vl;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 21})
public class x {
    public int n;
    public int qg;
    public String s;

    public x(int i) {
        this(i, 0, null);
    }

    public x(int i, int i2) {
        this(i, i2, null);
    }

    public x(int i, String str) {
        this(i, 0, str);
    }

    public x(int i, int i2, String str) {
        this.n = i;
        this.qg = i2;
        this.s = str;
    }

    public int getType() {
        return this.n;
    }

    public int n() {
        return this.qg;
    }

    public String qg() {
        return this.s;
    }
}

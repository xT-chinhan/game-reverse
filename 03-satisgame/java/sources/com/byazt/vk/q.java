package com.byazt.vk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OPEN_VOICE_IN_PREPARE, 5})
public class q {
    public final String n;
    public final String q;
    public final String qg;
    public final String s;

    public q(String str, String str2, String str3, String str4) {
        this.n = str;
        this.qg = str2;
        this.s = str3;
        this.q = str4 == null ? "img_0.png" : str4;
    }

    public String n() {
        return this.n;
    }

    public String qg() {
        return this.s;
    }

    public String s() {
        return this.q;
    }
}

package com.byazt.bf;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, 18})
public class l {
    public int l;
    public int n;
    public long q;
    public long qg;
    public String s;

    public void n(l lVar) {
        this.n = lVar.n();
        this.qg = lVar.qg();
        this.s = lVar.s();
        this.q = lVar.q();
        this.l = lVar.l();
    }

    public int n() {
        return this.n;
    }

    public void n(int i) {
        this.n = i;
    }

    public long qg() {
        return this.qg;
    }

    public void n(long j) {
        this.qg = j;
    }

    public String s() {
        return this.s;
    }

    public void n(String str) {
        this.s = str;
    }

    public long q() {
        return this.q;
    }

    public int l() {
        return this.l;
    }

    public void qg(long j) {
        this.q = j;
    }

    public void qg(int i) {
        this.l = i;
    }
}

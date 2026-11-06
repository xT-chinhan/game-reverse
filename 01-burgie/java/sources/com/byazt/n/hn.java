package com.byazt.n;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 20})
public class hn implements com.byazt.ihe.hn {
    public String hn;
    public int hw;
    public int pr;

    public hn(int i, int i2) {
        this.pr = i;
        this.hw = i2;
    }

    public hn(int i, int i2, String str) {
        this.pr = i;
        this.hw = i2;
        this.hn = str;
    }

    @Override // com.byazt.ihe.hn
    public int pr() {
        return this.pr;
    }

    @Override // com.byazt.ihe.hn
    public void pr(int i) {
        this.pr = i;
    }

    @Override // com.byazt.ihe.hn
    public int hw() {
        return this.hw;
    }

    @Override // com.byazt.ihe.hn
    public void hw(int i) {
        this.hw = i;
    }

    @Override // com.byazt.ihe.hn
    public String hn() {
        return this.hn;
    }

    @Override // com.byazt.ihe.hn
    public void pr(String str) {
        this.hn = str;
    }
}

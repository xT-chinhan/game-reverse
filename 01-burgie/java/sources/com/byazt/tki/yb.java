package com.byazt.tki;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1549, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public abstract class yb implements com.byazt.awu.pr {
    public com.byazt.yiq.hn hn;
    public com.byazt.awu.pr hw;
    public com.byazt.awu.pr pr;

    public yb(com.byazt.yiq.hn hnVar) {
        this.hn = hnVar;
    }

    public void pr(com.byazt.awu.pr prVar) {
        this.pr = prVar;
    }

    public void hw(com.byazt.awu.pr prVar) {
        this.hw = prVar;
    }

    @Override // com.byazt.awu.pr
    public com.byazt.yiq.c pr() {
        return com.byazt.yiq.uc.OPERATOR_RESULT;
    }

    @Override // com.byazt.awu.pr
    public String hw() {
        return this.pr.hw() + this.hn.pr() + this.hw.hw();
    }

    public String toString() {
        return hw();
    }
}

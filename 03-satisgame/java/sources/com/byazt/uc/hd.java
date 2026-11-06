package com.byazt.uc;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1276, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public abstract class hd implements com.byazt.uk.n {
    public com.byazt.uk.n n;
    public com.byazt.uk.n qg;
    public com.byazt.mn.s s;

    public hd(com.byazt.mn.s sVar) {
        this.s = sVar;
    }

    public void n(com.byazt.uk.n nVar) {
        this.n = nVar;
    }

    public void qg(com.byazt.uk.n nVar) {
        this.qg = nVar;
    }

    @Override // com.byazt.uk.n
    public com.byazt.mn.l n() {
        return com.byazt.mn.w.OPERATOR_RESULT;
    }

    @Override // com.byazt.uk.n
    public String qg() {
        return this.n.qg() + this.s.n() + this.qg.qg();
    }

    public String toString() {
        return qg();
    }
}

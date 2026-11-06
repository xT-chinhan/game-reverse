package com.byazt.xq;

import com.byazt.pch.s;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_OPENED_TIME, 26})
public class qg extends s {
    public com.byazt.lr.n n;

    public qg(com.byazt.lr.n nVar) {
        this.n = nVar;
    }

    @Override // com.byazt.pch.s
    public void n(int i, String str) {
        com.byazt.lr.n nVar = this.n;
        if (nVar != null) {
            nVar.n(i, str, false);
        }
    }

    @Override // com.byazt.pch.s
    public void n() {
        com.byazt.lr.n nVar = this.n;
        if (nVar != null) {
            nVar.qg();
        }
    }

    @Override // com.byazt.pch.s
    public void qg() {
        com.byazt.lr.n nVar = this.n;
        if (nVar != null) {
            nVar.n();
        }
    }
}

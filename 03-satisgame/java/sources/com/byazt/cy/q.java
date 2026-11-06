package com.byazt.cy;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE, 5})
public class q extends com.byazt.fvm.l {
    public com.byazt.sg.s n;

    public q(com.byazt.sg.s sVar) {
        this.n = sVar;
    }

    @Override // com.byazt.fvm.l
    public void n() {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            if (sVar.q() == 3) {
                this.n.qg();
            } else if (this.n.q() == 2) {
                this.n.n();
            }
        }
    }

    @Override // com.byazt.fvm.l
    public void qg() {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            sVar.s();
        }
    }
}

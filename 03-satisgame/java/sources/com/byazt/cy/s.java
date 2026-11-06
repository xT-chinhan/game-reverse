package com.byazt.cy;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE, 8})
public class s extends com.byazt.slh.n {
    public com.byazt.sg.s n;

    public s(com.byazt.sg.s sVar) {
        this.n = sVar;
    }

    @Override // com.byazt.slh.n
    public String n() {
        com.byazt.sg.s sVar = this.n;
        return sVar != null ? sVar.x() : "";
    }

    @Override // com.byazt.slh.n
    public void qg() {
        com.byazt.sg.s sVar = this.n;
        if (sVar == null || sVar.fs() == null) {
            return;
        }
        this.n.fs().qg();
    }

    @Override // com.byazt.slh.n
    public void n(long j) {
        com.byazt.sg.s sVar = this.n;
        if (sVar == null || sVar.fs() == null) {
            return;
        }
        this.n.fs().n(j);
    }

    @Override // com.byazt.slh.n
    public void qg(long j) {
        com.byazt.sg.s sVar = this.n;
        if (sVar == null || sVar.fs() == null) {
            return;
        }
        this.n.fs().qg(j);
    }

    @Override // com.byazt.slh.n
    public void s() {
        com.byazt.sg.s sVar = this.n;
        if (sVar == null || sVar.fs() == null) {
            return;
        }
        this.n.fs().n();
    }

    @Override // com.byazt.slh.n
    public void s(long j) {
        com.byazt.sg.s sVar = this.n;
        if (sVar == null || sVar.fs() == null) {
            return;
        }
        this.n.fs().s(j);
    }

    @Override // com.byazt.slh.n
    public void q() {
        com.byazt.sg.s sVar = this.n;
        if (sVar == null || sVar.fs() == null) {
            return;
        }
        this.n.fs().qg();
    }

    @Override // com.byazt.slh.n
    public void n(int i, int i2) {
        com.byazt.sg.s sVar = this.n;
        if (sVar == null || sVar.fs() == null) {
            return;
        }
        this.n.fs().n(i, i2);
    }

    @Override // com.byazt.slh.n
    public void n(long j, int i, int i2) {
        com.byazt.sg.s sVar = this.n;
        if (sVar == null || sVar.fs() == null) {
            return;
        }
        this.n.fs().n(j, i, i2);
    }
}

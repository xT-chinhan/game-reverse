package com.byazt.ia;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_STRENGTH_OPTION, 21})
public class x {
    public w n;

    public x(w wVar) {
        this.n = wVar;
    }

    public boolean n() {
        boolean zN = this.n.t != null ? this.n.t.n() : false;
        this.n.s.getVisibility();
        return zN || this.n.s.getVisibility() == 0;
    }

    public boolean qg() {
        if (com.byazt.gks.n.n(this.n.hu)) {
            return true;
        }
        return (this.n.fs != null && this.n.fs.getVisibility() == 0) || (this.n.tj != null && this.n.tj.getVisibility() == 0) || ((this.n.cp != null && this.n.cp.getVisibility() == 0) || (this.n.d != null && this.n.d.getVisibility() == 0));
    }
}

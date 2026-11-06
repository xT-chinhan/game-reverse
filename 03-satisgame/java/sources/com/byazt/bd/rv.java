package com.byazt.bd;

import android.graphics.Path;
import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 893, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends com.byazt.yt.n<PointF> {
    public final com.byazt.yt.n<PointF> cp;
    public Path tj;

    public rv(com.byazt.pp.w wVar, com.byazt.yt.n<PointF> nVar) {
        super(wVar, nVar.n, nVar.qg, nVar.s, nVar.q, nVar.l, nVar.w, nVar.x);
        this.cp = nVar;
        n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n() {
        boolean z = (this.qg == 0 || this.n == 0 || !((PointF) this.n).equals(((PointF) this.qg).x, ((PointF) this.qg).y)) ? false : true;
        if (this.n == 0 || this.qg == 0 || z) {
            return;
        }
        this.tj = com.byazt.nu.tj.n((PointF) this.n, (PointF) this.qg, this.cp.fs, this.cp.rv);
    }

    public Path qg() {
        return this.tj;
    }
}
